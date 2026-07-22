/*      */ package sicret;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Point;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.nio.file.Path;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import principal.MaterialButton;
/*      */ 
/*      */ public class UnidadesUtilitarios extends JPanel {
/*   36 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   37 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   38 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   39 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   40 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   41 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   45 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   46 */   Utilerias utilerias = new Utilerias();
/*   47 */   Date fechaActual = new Date();
/*   48 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   49 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   51 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*      */   String id;
/*   54 */   Consultas2 con = new Consultas2();
/*   55 */   Consultas2 con2 = new Consultas2();
/*      */   String[] inf;
/*   57 */   cargarDatos datos = new cargarDatos("GeneradoraAlta");
/*   58 */   String holderEco = "ECONÓMICO";
/*   59 */   String holderSerie = "SERIE";
/*   60 */   String holderPlacas = "PLACAS";
/*   61 */   String holderMarca = "MARCA";
/*   62 */   String holderTipo = "TIPO";
/*   63 */   String holderBuscarM = "BUSCAR...";
/*      */   EscribirReporte esc;
/*      */   boolean encontrado = false;
/*   66 */   Errores error = new Errores(true);
/*   67 */   Validaciones val = new Validaciones();
/*   68 */   Date fecha = null;
/*   69 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   71 */   Map<String, String> MARCAS = new TreeMap<>();
/*   72 */   Map<String, String> TIPOS = new TreeMap<>();
/*   73 */   Map<String, String> ESTADOSBAJA = new TreeMap<>();
/*   74 */   MensajePop mensajeTry = null;
/*   75 */   Fuentes fuentes = new Fuentes();
/*   76 */   PlaceHolder placeHolder = null;
/*   77 */   String[] SUCURSALES = null;
/*   78 */   String[] ESTADOS = null;
/*   79 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean PRIMERA = false;
/*   81 */   Cursor micursor = null;
/*   82 */   CeldaRender1 celda1 = new CeldaRender1();
/*   83 */   CeldaRender2 celda2 = new CeldaRender2();
/*   84 */   Map<String, String> CARPETAS = new TreeMap<>();
/*      */   Map<String, UnidadesTractosDoc> DOCUMENTACION;
/*   86 */   Date fechaInicio = null;
/*   87 */   String TIPOSELEC = "";
/*   88 */   private Map<String, String> CAMPOS = new TreeMap<>();
/*   89 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*   90 */   String TIPOV = "ECO";
/*   91 */   Map<String, String> CLAVECONFIGAUT = new TreeMap<>(); private ButtonGroup buttonGroup1; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton58; private JButton jButton59; private JButton jButton61; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox24; private JComboBox jComboBox25; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JFormattedTextField jFormattedTextField1; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel109;
/*   92 */   String ClaveTipoAut = ""; private JLabel jLabel110; private JLabel jLabel112; private JLabel jLabel2; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel34; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel136; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42;
/*      */   
/*      */   public UnidadesUtilitarios(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*   95 */     this.PRIVILEGIOS.put("1", "SUPER USUARIO");
/*   96 */     this.PRIVILEGIOS.put("2", "QHSE");
/*   97 */     this.PRIVILEGIOS.put("2", "ADMINISTRADOR");
/*      */     
/*   99 */     this.ESTADOSBAJA.put("1", "BAJA");
/*  100 */     this.ESTADOSBAJA.put("2", "DESMANTELADO");
/*  101 */     this.ESTADOSBAJA.put("3", "ROBADO");
/*  102 */     this.ESTADOSBAJA.put("4", "SINIESTRADO");
/*  103 */     this.ESTADOSBAJA.put("5", "VENDIDO");
/*      */     
/*  105 */     String año = "2010";
/*  106 */     String mes = "03";
/*  107 */     String dia = "01";
/*  108 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  109 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  111 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  112 */     } catch (ParseException ex) {
/*  113 */       ex.printStackTrace();
/*      */     } 
/*  115 */     this.con2.setBaseDatos("sicre2PR");
/*  116 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  117 */     this.mensajeTry = mensajeTry;
/*  118 */     this.padre = padre;
/*  119 */     this.fichas = fichas;
/*  120 */     this.USUARIO = USUARIO;
/*  121 */     this.panel = panelito;
/*  122 */     this.panel.setViewportView(this);
/*  123 */     initComponents();
/*      */     
/*  125 */     this.jFormattedTextField1.setValue(Double.valueOf(10.0D));
/*  126 */     this.jDateChooser1.getDate();
/*  127 */     this.buttonGroup1.add(this.jRadioButton1);
/*  128 */     this.buttonGroup1.add(this.jRadioButton2);
/*  129 */     this.buttonGroup1.add(this.jRadioButton3);
/*  130 */     this.buttonGroup1.add(this.jRadioButton4);
/*  131 */     this.buttonGroup1.add(this.jRadioButton5);
/*  132 */     this.buttonGroup1.add(this.jRadioButton6);
/*  133 */     this.buttonGroup1.add(this.jRadioButton7);
/*  134 */     this.buttonGroup1.add(this.jRadioButton8);
/*  135 */     this.buttonGroup1.add(this.jRadioButton9);
/*      */     
/*  137 */     String[][] carpetas = this.con.buscarDatos("tipo, direccion", "unidadescarpetas", "");
/*  138 */     for (int i = 0; i < carpetas.length; i++) {
/*  139 */       this.CARPETAS.put(carpetas[i][0], carpetas[i][1]);
/*      */     }
/*  141 */     this.utilerias.imprimirMapa(this.CARPETAS);
/*      */     
/*  143 */     colorear();
/*  144 */     this.placeHolder = new PlaceHolder(this.jTextField60, new Color(189, 189, 189), Color.BLACK, this.holderEco, false, "Century Gothic", 11);
/*  145 */     this.placeHolder = new PlaceHolder(this.jTextField61, new Color(189, 189, 189), Color.BLACK, this.holderSerie, false, "Century Gothic", 11);
/*  146 */     this.placeHolder = new PlaceHolder(this.jTextField62, new Color(189, 189, 189), Color.BLACK, this.holderPlacas, false, "Century Gothic", 11);
/*  147 */     this.placeHolder = new PlaceHolder(this.jTextField63, new Color(189, 189, 189), Color.BLACK, this.holderMarca, false, "Century Gothic", 11);
/*  148 */     this.placeHolder = new PlaceHolder(this.jTextField64, new Color(189, 189, 189), Color.BLACK, this.holderTipo, false, "Century Gothic", 11);
/*  149 */     this.placeHolder = new PlaceHolder(this.jTextField17, new Color(189, 189, 189), Color.BLACK, this.holderBuscarM, false, "Century Gothic", 11);
/*      */     
/*  151 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  152 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  153 */     this.rSTableMetro1.setCursor(this.micursor);
/*      */     
/*  155 */     this.rSTableMetro3.setCursor(this.micursor);
/*      */     
/*  157 */     this.utilerias.activarVentanajDialog(this.jDialog1, 1000, 550);
/*  158 */     this.utilerias.activarVentanajDialog(this.jDialog2, 280, 390);
/*  159 */     this.utilerias.activarVentanajDialog(this.jDialog3, 475, 260);
/*  160 */     this.utilerias.activarVentanajDialog(this.jDialog4, 495, 140);
/*      */     
/*  162 */     ingresarCampos();
/*  163 */     llenarComboEstados();
/*  164 */     llenarComboSuc();
/*      */     
/*  166 */     llenarModelo();
/*  167 */     llenarMarca();
/*  168 */     llenarTipo();
/*  169 */     this.jComboBox11.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*  170 */     consultar();
/*  171 */     privilegios();
/*      */   }
/*      */   private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel62; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel70; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane33; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JTable jTable1; private JTextField jTextField100; private JTextField jTextField101; private JTextField jTextField102; private JTextField jTextField103; private JTextField jTextField104; private JTextField jTextField105; private JTextField jTextField106; private JTextField jTextField107; private JTextField jTextField108; private JTextField jTextField109; private JTextField jTextField110; private JTextField jTextField111; private JTextField jTextField17; private JTextField jTextField24; private JTextField jTextField60; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField63; private JTextField jTextField64; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton24; private MaterialButton materialButton25; private MaterialButton materialButton38; private MaterialButton materialButton39; private RSTableMetro rSTableMetro1;
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private void initComponents() {
/*  177 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  178 */     this.jPanel16 = new JPanel();
/*  179 */     this.jPanel36 = new JPanel();
/*  180 */     this.jPanel37 = new JPanel();
/*  181 */     this.jLabel2 = new JLabel();
/*  182 */     this.jTextField100 = new JTextField();
/*  183 */     this.jPanel38 = new JPanel();
/*  184 */     this.jLabel3 = new JLabel();
/*  185 */     this.jComboBox20 = new JComboBox();
/*  186 */     this.jPanel39 = new JPanel();
/*  187 */     this.jLabel4 = new JLabel();
/*  188 */     this.jTextField101 = new JTextField();
/*  189 */     this.jPanel42 = new JPanel();
/*  190 */     this.jPanel43 = new JPanel();
/*  191 */     this.jLabel6 = new JLabel();
/*  192 */     this.jTextField102 = new JTextField();
/*  193 */     this.jPanel44 = new JPanel();
/*  194 */     this.jLabel7 = new JLabel();
/*  195 */     this.jTextField103 = new JTextField();
/*  196 */     this.jPanel45 = new JPanel();
/*  197 */     this.jPanel46 = new JPanel();
/*  198 */     this.jPanel47 = new JPanel();
/*  199 */     this.jLabel29 = new JLabel();
/*  200 */     this.jTextField104 = new JTextField();
/*  201 */     this.jPanel48 = new JPanel();
/*  202 */     this.jLabel101 = new JLabel();
/*  203 */     this.jComboBox21 = new JComboBox();
/*  204 */     this.jPanel49 = new JPanel();
/*  205 */     this.jLabel102 = new JLabel();
/*  206 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  207 */     this.jPanel40 = new JPanel();
/*  208 */     this.jPanel50 = new JPanel();
/*  209 */     this.jLabel5 = new JLabel();
/*  210 */     this.jTextField105 = new JTextField();
/*  211 */     this.jPanel51 = new JPanel();
/*  212 */     this.jLabel103 = new JLabel();
/*  213 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  214 */     this.jPanel52 = new JPanel();
/*  215 */     this.jLabel104 = new JLabel();
/*  216 */     this.jTextField107 = new JTextField();
/*  217 */     this.jPanel53 = new JPanel();
/*  218 */     this.jPanel54 = new JPanel();
/*  219 */     this.jLabel105 = new JLabel();
/*  220 */     this.jTextField108 = new JTextField();
/*  221 */     this.jPanel55 = new JPanel();
/*  222 */     this.jLabel106 = new JLabel();
/*  223 */     this.jTextField109 = new JTextField();
/*  224 */     this.jPanel56 = new JPanel();
/*  225 */     this.jLabel107 = new JLabel();
/*  226 */     this.jTextField110 = new JTextField();
/*  227 */     this.jPanel64 = new JPanel();
/*  228 */     this.jPanel67 = new JPanel();
/*  229 */     this.jLabel112 = new JLabel();
/*  230 */     this.jTextField111 = new JTextField();
/*  231 */     this.jPanel65 = new JPanel();
/*  232 */     this.jLabel109 = new JLabel();
/*  233 */     this.jComboBox24 = new JComboBox();
/*  234 */     this.jPanel66 = new JPanel();
/*  235 */     this.jLabel110 = new JLabel();
/*  236 */     this.jComboBox25 = new JComboBox();
/*  237 */     this.jPanel41 = new JPanel();
/*  238 */     this.materialButton21 = new MaterialButton();
/*  239 */     this.materialButton22 = new MaterialButton();
/*  240 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  241 */     this.jPanel70 = new JPanel();
/*  242 */     this.jRadioButton1 = new JRadioButton();
/*  243 */     this.jRadioButton2 = new JRadioButton();
/*  244 */     this.jRadioButton3 = new JRadioButton();
/*  245 */     this.jRadioButton4 = new JRadioButton();
/*  246 */     this.jRadioButton5 = new JRadioButton();
/*  247 */     this.jRadioButton6 = new JRadioButton();
/*  248 */     this.jRadioButton7 = new JRadioButton();
/*  249 */     this.jRadioButton8 = new JRadioButton();
/*  250 */     this.jRadioButton9 = new JRadioButton();
/*  251 */     this.materialButton39 = new MaterialButton();
/*  252 */     this.materialButton38 = new MaterialButton();
/*  253 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  254 */     this.jPanel136 = new JPanel();
/*  255 */     this.jScrollPane33 = new JScrollPane();
/*  256 */     this.rSTableMetro3 = new RSTableMetro();
/*  257 */     this.jButton58 = new JButton();
/*  258 */     this.jButton59 = new JButton();
/*  259 */     this.jButton61 = new JButton();
/*  260 */     this.jTextField17 = new JTextField();
/*  261 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  262 */     this.jPanel62 = new JPanel();
/*  263 */     this.jLabel34 = new JLabel();
/*  264 */     this.jTextField24 = new JTextField();
/*  265 */     this.materialButton24 = new MaterialButton();
/*  266 */     this.materialButton25 = new MaterialButton();
/*  267 */     this.jPanel1 = new JPanel();
/*  268 */     this.jScrollPane1 = new JScrollPane();
/*  269 */     this.jTable1 = new JTable();
/*  270 */     this.jLabel8 = new JLabel();
/*  271 */     this.jTextField106 = new JTextField();
/*  272 */     this.buttonGroup1 = new ButtonGroup();
/*  273 */     this.jPanel9 = new JPanel();
/*  274 */     this.jPanel10 = new JPanel();
/*  275 */     this.jLabel98 = new JLabel();
/*  276 */     this.jPanel35 = new JPanel();
/*  277 */     this.jTextField60 = new JTextField();
/*  278 */     this.jTextField61 = new JTextField();
/*  279 */     this.jTextField62 = new JTextField();
/*  280 */     this.jTextField63 = new JTextField();
/*  281 */     this.jTextField64 = new JTextField();
/*  282 */     this.jComboBox9 = new JComboBox();
/*  283 */     this.jComboBox10 = new JComboBox();
/*  284 */     this.jComboBox11 = new JComboBox();
/*  285 */     this.jPanel11 = new JPanel();
/*  286 */     this.jPanel12 = new JPanel();
/*  287 */     this.jPanel15 = new JPanel();
/*  288 */     this.jLabel99 = new JLabel();
/*  289 */     this.jLabel100 = new JLabel();
/*  290 */     this.jPanel14 = new JPanel();
/*  291 */     this.jButton35 = new JButton();
/*  292 */     this.jButton36 = new JButton();
/*  293 */     this.jButton37 = new JButton();
/*  294 */     this.jButton34 = new JButton();
/*  295 */     this.jButton33 = new JButton();
/*  296 */     this.jScrollPane9 = new JScrollPane();
/*  297 */     this.jPanel13 = new JPanel();
/*  298 */     this.jScrollPane8 = new JScrollPane();
/*  299 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  301 */     this.jDialog1.setTitle("Utilitarios");
/*  302 */     this.jDialog1.setModal(true);
/*  303 */     this.jDialog1.setResizable(false);
/*      */     
/*  305 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/*  306 */     this.jPanel16.setLayout(new GridLayout(9, 1, 0, 12));
/*      */     
/*  308 */     this.jPanel36.setBackground(new Color(255, 255, 255));
/*  309 */     this.jPanel36.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  311 */     this.jPanel37.setBackground(new Color(255, 255, 255));
/*  312 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  314 */     this.jLabel2.setFont(new Font("Cantarell", 1, 15));
/*  315 */     this.jLabel2.setHorizontalAlignment(4);
/*  316 */     this.jLabel2.setText("Económico");
/*  317 */     this.jPanel37.add(this.jLabel2);
/*      */     
/*  319 */     this.jTextField100.setText("jTextField100");
/*  320 */     this.jPanel37.add(this.jTextField100);
/*      */     
/*  322 */     this.jPanel36.add(this.jPanel37);
/*      */     
/*  324 */     this.jPanel38.setBackground(new Color(255, 255, 255));
/*  325 */     this.jPanel38.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  327 */     this.jLabel3.setFont(new Font("Cantarell", 1, 15));
/*  328 */     this.jLabel3.setHorizontalAlignment(4);
/*  329 */     this.jLabel3.setText("Modelo");
/*  330 */     this.jPanel38.add(this.jLabel3);
/*      */     
/*  332 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  333 */     this.jPanel38.add(this.jComboBox20);
/*      */     
/*  335 */     this.jPanel36.add(this.jPanel38);
/*      */     
/*  337 */     this.jPanel39.setBackground(new Color(255, 255, 255));
/*  338 */     this.jPanel39.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  340 */     this.jLabel4.setFont(new Font("Cantarell", 1, 15));
/*  341 */     this.jLabel4.setHorizontalAlignment(4);
/*  342 */     this.jLabel4.setText("Serie");
/*  343 */     this.jPanel39.add(this.jLabel4);
/*      */     
/*  345 */     this.jTextField101.setText("jTextField101");
/*  346 */     this.jPanel39.add(this.jTextField101);
/*      */     
/*  348 */     this.jPanel36.add(this.jPanel39);
/*      */     
/*  350 */     this.jPanel16.add(this.jPanel36);
/*      */     
/*  352 */     this.jPanel42.setBackground(new Color(255, 255, 255));
/*  353 */     this.jPanel42.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  355 */     this.jPanel43.setBackground(new Color(255, 255, 255));
/*  356 */     this.jPanel43.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  358 */     this.jLabel6.setFont(new Font("Cantarell", 1, 15));
/*  359 */     this.jLabel6.setHorizontalAlignment(4);
/*  360 */     this.jLabel6.setText("Placas");
/*  361 */     this.jPanel43.add(this.jLabel6);
/*      */     
/*  363 */     this.jTextField102.setText("jTextField102");
/*  364 */     this.jPanel43.add(this.jTextField102);
/*      */     
/*  366 */     this.jPanel42.add(this.jPanel43);
/*      */     
/*  368 */     this.jPanel44.setBackground(new Color(255, 255, 255));
/*  369 */     this.jPanel44.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  371 */     this.jLabel7.setHorizontalAlignment(4);
/*  372 */     this.jLabel7.setText("Motor");
/*  373 */     this.jPanel44.add(this.jLabel7);
/*      */     
/*  375 */     this.jTextField103.setText("jTextField103");
/*  376 */     this.jPanel44.add(this.jTextField103);
/*      */     
/*  378 */     this.jPanel42.add(this.jPanel44);
/*      */     
/*  380 */     this.jPanel45.setBackground(new Color(255, 255, 255));
/*  381 */     this.jPanel45.setLayout(new GridLayout(1, 2, 6, 0));
/*  382 */     this.jPanel42.add(this.jPanel45);
/*      */     
/*  384 */     this.jPanel16.add(this.jPanel42);
/*      */     
/*  386 */     this.jPanel46.setBackground(new Color(255, 255, 255));
/*  387 */     this.jPanel46.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  389 */     this.jPanel47.setBackground(new Color(255, 255, 255));
/*  390 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  392 */     this.jLabel29.setHorizontalAlignment(4);
/*  393 */     this.jLabel29.setText("Factura");
/*  394 */     this.jPanel47.add(this.jLabel29);
/*      */     
/*  396 */     this.jTextField104.setText("jTextField104");
/*  397 */     this.jPanel47.add(this.jTextField104);
/*      */     
/*  399 */     this.jPanel46.add(this.jPanel47);
/*      */     
/*  401 */     this.jPanel48.setBackground(new Color(255, 255, 255));
/*  402 */     this.jPanel48.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  404 */     this.jLabel101.setHorizontalAlignment(4);
/*  405 */     this.jLabel101.setText("Forma de Pago");
/*  406 */     this.jPanel48.add(this.jLabel101);
/*      */     
/*  408 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  409 */     this.jComboBox21.setEditable(true);
/*  410 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "EFECTIVO", "OTRO" }));
/*  411 */     this.jPanel48.add(this.jComboBox21);
/*      */     
/*  413 */     this.jPanel46.add(this.jPanel48);
/*      */     
/*  415 */     this.jPanel49.setBackground(new Color(255, 255, 255));
/*  416 */     this.jPanel49.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  418 */     this.jLabel102.setHorizontalAlignment(4);
/*  419 */     this.jLabel102.setText("Fecha de Compra");
/*  420 */     this.jPanel49.add(this.jLabel102);
/*      */     
/*  422 */     this.jDateChooser1.setDate(this.fechaActual);
/*  423 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/*  424 */     this.jDateChooser1.setIcon(this.icon);
/*  425 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/*  426 */     this.jPanel49.add((Component)this.jDateChooser1);
/*      */     
/*  428 */     this.jPanel46.add(this.jPanel49);
/*      */     
/*  430 */     this.jPanel16.add(this.jPanel46);
/*      */     
/*  432 */     this.jPanel40.setBackground(new Color(255, 255, 255));
/*  433 */     this.jPanel40.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  435 */     this.jPanel50.setBackground(new Color(255, 255, 255));
/*  436 */     this.jPanel50.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  438 */     this.jLabel5.setHorizontalAlignment(4);
/*  439 */     this.jLabel5.setText("Color");
/*  440 */     this.jPanel50.add(this.jLabel5);
/*      */     
/*  442 */     this.jTextField105.setText("jTextField105");
/*  443 */     this.jPanel50.add(this.jTextField105);
/*      */     
/*  445 */     this.jPanel40.add(this.jPanel50);
/*      */     
/*  447 */     this.jPanel51.setBackground(new Color(255, 255, 255));
/*  448 */     this.jPanel51.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  450 */     this.jLabel103.setHorizontalAlignment(4);
/*  451 */     this.jLabel103.setText("Kilometraje");
/*  452 */     this.jPanel51.add(this.jLabel103);
/*      */     
/*  454 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
/*  455 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  456 */     this.jPanel51.add(this.jFormattedTextField1);
/*      */     
/*  458 */     this.jPanel40.add(this.jPanel51);
/*      */     
/*  460 */     this.jPanel52.setBackground(new Color(255, 255, 255));
/*  461 */     this.jPanel52.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  463 */     this.jLabel104.setHorizontalAlignment(4);
/*  464 */     this.jLabel104.setText("Marca");
/*  465 */     this.jPanel52.add(this.jLabel104);
/*      */     
/*  467 */     this.jTextField107.setText("jTextField107");
/*  468 */     this.jPanel52.add(this.jTextField107);
/*      */     
/*  470 */     this.jPanel40.add(this.jPanel52);
/*      */     
/*  472 */     this.jPanel16.add(this.jPanel40);
/*      */     
/*  474 */     this.jPanel53.setBackground(new Color(255, 255, 255));
/*  475 */     this.jPanel53.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  477 */     this.jPanel54.setBackground(new Color(255, 255, 255));
/*  478 */     this.jPanel54.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  480 */     this.jLabel105.setHorizontalAlignment(4);
/*  481 */     this.jLabel105.setText("Tipo o Submarca");
/*  482 */     this.jPanel54.add(this.jLabel105);
/*      */     
/*  484 */     this.jTextField108.setHorizontalAlignment(2);
/*  485 */     this.jTextField108.setText("jTextField108");
/*  486 */     this.jPanel54.add(this.jTextField108);
/*      */     
/*  488 */     this.jPanel53.add(this.jPanel54);
/*      */     
/*  490 */     this.jPanel55.setBackground(new Color(255, 255, 255));
/*  491 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  493 */     this.jLabel106.setHorizontalAlignment(4);
/*  494 */     this.jLabel106.setText("Tarjeta de Circulación");
/*  495 */     this.jPanel55.add(this.jLabel106);
/*      */     
/*  497 */     this.jTextField109.setHorizontalAlignment(2);
/*  498 */     this.jTextField109.setText("jTextField109");
/*  499 */     this.jTextField109.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  501 */             UnidadesUtilitarios.this.jTextField109ActionPerformed(evt);
/*      */           }
/*      */         });
/*  504 */     this.jPanel55.add(this.jTextField109);
/*      */     
/*  506 */     this.jPanel53.add(this.jPanel55);
/*      */     
/*  508 */     this.jPanel56.setBackground(new Color(255, 255, 255));
/*  509 */     this.jPanel56.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  511 */     this.jLabel107.setHorizontalAlignment(4);
/*  512 */     this.jLabel107.setText("Póliza de Seguro");
/*  513 */     this.jPanel56.add(this.jLabel107);
/*      */     
/*  515 */     this.jTextField110.setHorizontalAlignment(2);
/*  516 */     this.jTextField110.setText("jTextField110");
/*  517 */     this.jPanel56.add(this.jTextField110);
/*      */     
/*  519 */     this.jPanel53.add(this.jPanel56);
/*      */     
/*  521 */     this.jPanel16.add(this.jPanel53);
/*      */     
/*  523 */     this.jPanel64.setBackground(new Color(255, 255, 255));
/*  524 */     this.jPanel64.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  526 */     this.jPanel67.setBackground(new Color(255, 255, 255));
/*  527 */     this.jPanel67.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  529 */     this.jLabel112.setHorizontalAlignment(4);
/*  530 */     this.jLabel112.setText("Verificación");
/*  531 */     this.jPanel67.add(this.jLabel112);
/*      */     
/*  533 */     this.jTextField111.setHorizontalAlignment(2);
/*  534 */     this.jTextField111.setText("jTextField111");
/*  535 */     this.jPanel67.add(this.jTextField111);
/*      */     
/*  537 */     this.jPanel64.add(this.jPanel67);
/*      */     
/*  539 */     this.jPanel65.setBackground(new Color(255, 255, 255));
/*  540 */     this.jPanel65.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  542 */     this.jLabel109.setHorizontalAlignment(4);
/*  543 */     this.jLabel109.setText("Estado");
/*  544 */     this.jPanel65.add(this.jLabel109);
/*      */     
/*  546 */     this.jComboBox24.setBackground(new Color(244, 244, 244));
/*  547 */     this.jComboBox24.setEditable(true);
/*  548 */     this.jComboBox24.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "BAJA", "DESMANTELADO", "PLAN DE PISO", "ROBADO", "SINIESTRADO", "VENDIDO", "OTRO" }));
/*  549 */     this.jPanel65.add(this.jComboBox24);
/*      */     
/*  551 */     this.jPanel64.add(this.jPanel65);
/*      */     
/*  553 */     this.jPanel66.setBackground(new Color(255, 255, 255));
/*  554 */     this.jPanel66.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  556 */     this.jLabel110.setHorizontalAlignment(4);
/*  557 */     this.jLabel110.setText("Sucursal");
/*  558 */     this.jPanel66.add(this.jLabel110);
/*      */     
/*  560 */     this.jComboBox25.setBackground(new Color(244, 244, 244));
/*  561 */     this.jComboBox25.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "OTRO" }));
/*  562 */     this.jPanel66.add(this.jComboBox25);
/*      */     
/*  564 */     this.jPanel64.add(this.jPanel66);
/*      */     
/*  566 */     this.jPanel16.add(this.jPanel64);
/*      */     
/*  568 */     this.jPanel41.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  570 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  571 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  572 */     this.materialButton21.setMnemonic('C');
/*  573 */     this.materialButton21.setText("Cerrar");
/*  574 */     this.materialButton21.setToolTipText("Cerrar (Al t + C)");
/*  575 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  576 */     this.materialButton21.setHorizontalTextPosition(0);
/*  577 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  579 */             UnidadesUtilitarios.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  583 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  584 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  585 */     this.materialButton22.setMnemonic('A');
/*  586 */     this.materialButton22.setText("Guardar");
/*  587 */     this.materialButton22.setToolTipText("Guardar (Alt+G)");
/*  588 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  589 */     this.materialButton22.setHorizontalTextPosition(0);
/*  590 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  592 */             UnidadesUtilitarios.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  596 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/*  597 */     this.jPanel41.setLayout(jPanel41Layout);
/*  598 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/*  599 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  600 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  601 */           .addContainerGap(-1, 32767)
/*  602 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  603 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  604 */           .addComponent((Component)this.materialButton21, -2, 105, -2)));
/*      */     
/*  606 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/*  607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  608 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  609 */           .addGap(0, 0, 32767)
/*  610 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  611 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  612 */             .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*      */ 
/*      */     
/*  615 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  616 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  617 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  618 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  619 */         .addComponent(this.jPanel16, -1, -1, 32767)
/*  620 */         .addComponent(this.jPanel41, -1, -1, 32767));
/*      */     
/*  622 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  623 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  624 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  625 */           .addComponent(this.jPanel16, -1, 437, 32767)
/*  626 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  627 */           .addComponent(this.jPanel41, -2, -1, -2)));
/*      */ 
/*      */     
/*  630 */     this.jDialog2.setTitle("Tipo de documento");
/*  631 */     this.jDialog2.setModal(true);
/*      */     
/*  633 */     this.jPanel70.setLayout(new GridLayout(10, 0, 0, 2));
/*      */     
/*  635 */     this.jRadioButton1.setSelected(true);
/*  636 */     this.jRadioButton1.setText("Tarjetas de Circulación");
/*  637 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  639 */             UnidadesUtilitarios.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  642 */     this.jPanel70.add(this.jRadioButton1);
/*      */     
/*  644 */     this.jRadioButton2.setText("Póliza de Seguro");
/*  645 */     this.jPanel70.add(this.jRadioButton2);
/*      */     
/*  647 */     this.jRadioButton3.setText("Sedema");
/*  648 */     this.jPanel70.add(this.jRadioButton3);
/*      */     
/*  650 */     this.jRadioButton4.setText("Nom 012");
/*  651 */     this.jPanel70.add(this.jRadioButton4);
/*      */     
/*  653 */     this.jRadioButton5.setText("Verificación");
/*  654 */     this.jPanel70.add(this.jRadioButton5);
/*      */     
/*  656 */     this.jRadioButton6.setText("Fisicomecánica");
/*  657 */     this.jPanel70.add(this.jRadioButton6);
/*      */     
/*  659 */     this.jRadioButton7.setText("Sct");
/*  660 */     this.jPanel70.add(this.jRadioButton7);
/*      */     
/*  662 */     this.jRadioButton8.setText("Pago");
/*  663 */     this.jPanel70.add(this.jRadioButton8);
/*      */     
/*  665 */     this.jRadioButton9.setText("Otro");
/*  666 */     this.jPanel70.add(this.jRadioButton9);
/*      */     
/*  668 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/*  669 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/*  670 */     this.materialButton39.setMnemonic('S');
/*  671 */     this.materialButton39.setText("Siguiente >>");
/*  672 */     this.materialButton39.setToolTipText("Siguiente (Alt+S)");
/*  673 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/*  674 */     this.materialButton39.setHorizontalTextPosition(0);
/*  675 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  677 */             UnidadesUtilitarios.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  681 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  682 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  683 */     this.materialButton38.setMnemonic('C');
/*  684 */     this.materialButton38.setText("Cerrar");
/*  685 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/*  686 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/*  687 */     this.materialButton38.setHorizontalTextPosition(0);
/*  688 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  690 */             UnidadesUtilitarios.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  694 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  695 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  696 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  697 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  698 */         .addComponent(this.jPanel70, -1, -1, 32767)
/*  699 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  700 */           .addGap(0, 0, 32767)
/*  701 */           .addComponent((Component)this.materialButton39, -2, 150, -2)
/*  702 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  703 */           .addComponent((Component)this.materialButton38, -2, 105, -2)));
/*      */     
/*  705 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  706 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  707 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  708 */           .addComponent(this.jPanel70, -1, -1, 32767)
/*  709 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  710 */           .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  711 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/*  712 */             .addComponent((Component)this.materialButton39, -2, 38, -2))
/*  713 */           .addContainerGap()));
/*      */ 
/*      */     
/*  716 */     this.jDialog3.setTitle("Marcas");
/*  717 */     this.jDialog3.setUndecorated(true);
/*      */     
/*  719 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  727 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  732 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  735 */     this.rSTableMetro3.setAltoHead(25);
/*  736 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  737 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  738 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  739 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  740 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  741 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  742 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  743 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  744 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  745 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  746 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  747 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  748 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  749 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  750 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  752 */             UnidadesUtilitarios.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  755 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  757 */             UnidadesUtilitarios.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  760 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  762 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  763 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  765 */             UnidadesUtilitarios.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  769 */     this.jButton59.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  770 */     this.jButton59.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  772 */             UnidadesUtilitarios.this.jButton59ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  776 */     this.jButton61.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  777 */     this.jButton61.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  779 */             UnidadesUtilitarios.this.jButton61ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  783 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  785 */             UnidadesUtilitarios.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/*  788 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  790 */             UnidadesUtilitarios.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  794 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/*  795 */     this.jPanel136.setLayout(jPanel136Layout);
/*  796 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/*  797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  798 */         .addComponent(this.jScrollPane33, -1, 418, 32767)
/*  799 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/*  800 */           .addContainerGap()
/*  801 */           .addComponent(this.jTextField17, -2, 179, -2)
/*  802 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  803 */           .addComponent(this.jButton58)
/*  804 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  805 */           .addComponent(this.jButton59)
/*  806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  807 */           .addComponent(this.jButton61)
/*  808 */           .addContainerGap()));
/*      */     
/*  810 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/*  811 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  812 */         .addGroup(jPanel136Layout.createSequentialGroup()
/*  813 */           .addComponent(this.jScrollPane33, -1, 172, 32767)
/*  814 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  815 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  816 */             .addComponent(this.jButton58, -2, 26, -2)
/*  817 */             .addComponent(this.jButton59, -2, 26, -2)
/*  818 */             .addComponent(this.jButton61, -2, 26, -2)
/*  819 */             .addComponent(this.jTextField17, -2, -1, -2))));
/*      */ 
/*      */     
/*  822 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  823 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  824 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  825 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  826 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
/*  827 */           .addGap(0, 0, 0)
/*  828 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/*      */     
/*  830 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  831 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  832 */         .addGroup(jDialog3Layout.createSequentialGroup()
/*  833 */           .addComponent(this.jPanel136, -1, -1, 32767)
/*  834 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/*  837 */     this.jDialog4.setTitle("Marcas");
/*  838 */     this.jDialog4.setModal(true);
/*      */     
/*  840 */     this.jLabel34.setText("Ingresa el nombre de la marca");
/*      */     
/*  842 */     this.jTextField24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  844 */             UnidadesUtilitarios.this.jTextField24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  848 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/*  849 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/*  850 */     this.materialButton24.setMnemonic('C');
/*  851 */     this.materialButton24.setText("Cerrar");
/*  852 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/*  853 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/*  854 */     this.materialButton24.setHorizontalTextPosition(0);
/*  855 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  857 */             UnidadesUtilitarios.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  861 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/*  862 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/*  863 */     this.materialButton25.setMnemonic('G');
/*  864 */     this.materialButton25.setText("Guardar");
/*  865 */     this.materialButton25.setToolTipText("Guardar (Alt +G)");
/*  866 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/*  867 */     this.materialButton25.setHorizontalTextPosition(0);
/*  868 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  870 */             UnidadesUtilitarios.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  874 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/*  875 */     this.jPanel62.setLayout(jPanel62Layout);
/*  876 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/*  877 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  878 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  879 */           .addContainerGap()
/*  880 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  881 */             .addComponent(this.jTextField24)
/*  882 */             .addComponent(this.jLabel34, -1, 455, 32767)
/*  883 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/*  884 */               .addGap(0, 0, 32767)
/*  885 */               .addComponent((Component)this.materialButton25, -2, 150, -2)
/*  886 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  887 */               .addComponent((Component)this.materialButton24, -2, 105, -2)))
/*  888 */           .addContainerGap()));
/*      */     
/*  890 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/*  891 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  892 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  893 */           .addComponent(this.jLabel34, -2, 26, -2)
/*  894 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  895 */           .addComponent(this.jTextField24, -2, -1, -2)
/*  896 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  897 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  898 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/*  899 */             .addComponent((Component)this.materialButton25, -2, 38, -2))
/*  900 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  903 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  904 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  905 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  906 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  907 */         .addGroup(jDialog4Layout.createSequentialGroup()
/*  908 */           .addComponent(this.jPanel62, -2, -1, -2)
/*  909 */           .addGap(0, 0, 32767)));
/*      */     
/*  911 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  912 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  913 */         .addComponent(this.jPanel62, -1, -1, 32767));
/*      */ 
/*      */     
/*  916 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  927 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  929 */     this.jLabel8.setHorizontalAlignment(4);
/*  930 */     this.jLabel8.setText("<html><u>Peso Bruto</u></html>");
/*  931 */     this.jLabel8.setToolTipText("Peso en Toneladas, mínimo 1, máximo 100");
/*      */     
/*  933 */     this.jTextField106.setHorizontalAlignment(4);
/*  934 */     this.jTextField106.setText("jTextField106");
/*      */     
/*  936 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  937 */     this.jPanel1.setLayout(jPanel1Layout);
/*  938 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  939 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  940 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  941 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  942 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  943 */               .addContainerGap()
/*  944 */               .addComponent(this.jScrollPane1, -2, -1, -2))
/*  945 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  946 */               .addGap(55, 55, 55)
/*  947 */               .addComponent(this.jLabel8, -2, -1, -2))
/*  948 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  949 */               .addGap(200, 200, 200)
/*  950 */               .addComponent(this.jTextField106, -2, -1, -2)))
/*  951 */           .addContainerGap(52, 32767)));
/*      */     
/*  953 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  954 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  955 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  956 */           .addContainerGap()
/*  957 */           .addComponent(this.jScrollPane1, -2, 151, -2)
/*  958 */           .addGap(57, 57, 57)
/*  959 */           .addComponent(this.jLabel8, -2, -1, -2)
/*  960 */           .addGap(18, 18, 18)
/*  961 */           .addComponent(this.jTextField106, -2, -1, -2)
/*  962 */           .addContainerGap(441, 32767)));
/*      */ 
/*      */     
/*  965 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  967 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  969 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/*  970 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/*  971 */     this.jLabel98.setHorizontalAlignment(0);
/*  972 */     this.jLabel98.setText("Utilitarios");
/*      */     
/*  974 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  975 */     this.jPanel10.setLayout(jPanel10Layout);
/*  976 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  977 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  978 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*      */     
/*  980 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  981 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  982 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  983 */           .addContainerGap()
/*  984 */           .addComponent(this.jLabel98)
/*  985 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  988 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/*  989 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/*  991 */     this.jTextField60.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  993 */             UnidadesUtilitarios.this.jTextField60KeyReleased(evt);
/*      */           }
/*      */         });
/*  996 */     this.jPanel35.add(this.jTextField60);
/*      */     
/*  998 */     this.jTextField61.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1000 */             UnidadesUtilitarios.this.jTextField61KeyReleased(evt);
/*      */           }
/*      */         });
/* 1003 */     this.jPanel35.add(this.jTextField61);
/*      */     
/* 1005 */     this.jTextField62.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1007 */             UnidadesUtilitarios.this.jTextField62KeyReleased(evt);
/*      */           }
/*      */         });
/* 1010 */     this.jPanel35.add(this.jTextField62);
/*      */     
/* 1012 */     this.jTextField63.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1014 */             UnidadesUtilitarios.this.jTextField63ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1017 */     this.jTextField63.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1019 */             UnidadesUtilitarios.this.jTextField63KeyReleased(evt);
/*      */           }
/*      */         });
/* 1022 */     this.jPanel35.add(this.jTextField63);
/*      */     
/* 1024 */     this.jTextField64.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1026 */             UnidadesUtilitarios.this.jTextField64KeyReleased(evt);
/*      */           }
/*      */         });
/* 1029 */     this.jPanel35.add(this.jTextField64);
/*      */     
/* 1031 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1032 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "MODELO" }));
/* 1033 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1035 */             UnidadesUtilitarios.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1038 */     this.jPanel35.add(this.jComboBox9);
/*      */     
/* 1040 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 1041 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 1042 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1044 */             UnidadesUtilitarios.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1047 */     this.jPanel35.add(this.jComboBox10);
/*      */     
/* 1049 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 1050 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL" }));
/* 1051 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1053 */             UnidadesUtilitarios.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1056 */     this.jPanel35.add(this.jComboBox11);
/*      */     
/* 1058 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1060 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 1061 */     this.jPanel12.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1063 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 1064 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1066 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1067 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 1068 */     this.jLabel99.setHorizontalAlignment(4);
/* 1069 */     this.jLabel99.setText("Total");
/* 1070 */     this.jPanel15.add(this.jLabel99);
/*      */     
/* 1072 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1073 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 1074 */     this.jLabel100.setHorizontalAlignment(2);
/* 1075 */     this.jLabel100.setText("t");
/* 1076 */     this.jPanel15.add(this.jLabel100);
/*      */     
/* 1078 */     this.jPanel12.add(this.jPanel15);
/*      */     
/* 1080 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1082 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1083 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1084 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1085 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1086 */         .addGap(0, 80, 32767));
/*      */     
/* 1088 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1089 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1090 */         .addGap(0, 37, 32767));
/*      */ 
/*      */     
/* 1093 */     this.jPanel12.add(this.jPanel14);
/*      */     
/* 1095 */     this.jButton35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1096 */     this.jButton35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1097 */     this.jButton35.setMnemonic('N');
/* 1098 */     this.jButton35.setText("Nuevo");
/* 1099 */     this.jButton35.setToolTipText("Nuevo Reseteo (Alt + N)");
/* 1100 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1102 */             UnidadesUtilitarios.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1105 */     this.jPanel12.add(this.jButton35);
/*      */     
/* 1107 */     this.jButton36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1108 */     this.jButton36.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1109 */     this.jButton36.setMnemonic('M');
/* 1110 */     this.jButton36.setText("Modificar");
/* 1111 */     this.jButton36.setToolTipText("Modificar (Alt + M)");
/* 1112 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1114 */             UnidadesUtilitarios.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1117 */     this.jPanel12.add(this.jButton36);
/*      */     
/* 1119 */     this.jButton37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1120 */     this.jButton37.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1121 */     this.jButton37.setMnemonic('E');
/* 1122 */     this.jButton37.setText("Eliminar");
/* 1123 */     this.jButton37.setToolTipText("Eliminar (Alt+E)");
/* 1124 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1126 */             UnidadesUtilitarios.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1129 */     this.jPanel12.add(this.jButton37);
/*      */     
/* 1131 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1132 */     this.jButton34.setMnemonic('I');
/* 1133 */     this.jButton34.setText("Imprimir");
/* 1134 */     this.jButton34.setToolTipText("Imprimir Reporte (Alt+I)");
/* 1135 */     this.jButton34.setEnabled(false);
/* 1136 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1138 */             UnidadesUtilitarios.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1141 */     this.jPanel12.add(this.jButton34);
/*      */     
/* 1143 */     this.jButton33.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1144 */     this.jButton33.setMnemonic('G');
/* 1145 */     this.jButton33.setText("Guardar Reporte");
/* 1146 */     this.jButton33.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1147 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1149 */             UnidadesUtilitarios.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1152 */     this.jPanel12.add(this.jButton33);
/*      */     
/* 1154 */     this.jScrollPane8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1156 */             UnidadesUtilitarios.this.jScrollPane8MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1160 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1168 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1173 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1176 */     this.rSTableMetro1.setAltoHead(40);
/* 1177 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1178 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1179 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1180 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1181 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1182 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1183 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1184 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1185 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1186 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1187 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1188 */     this.rSTableMetro1.setRowHeight(18);
/* 1189 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1190 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1191 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1192 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1194 */             UnidadesUtilitarios.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1197 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1199 */             UnidadesUtilitarios.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1202 */     this.jScrollPane8.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1204 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1205 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1206 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1208 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1209 */           .addComponent(this.jScrollPane8, -2, 2032, -2)
/* 1210 */           .addGap(0, 0, 32767)));
/*      */     
/* 1212 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1213 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1214 */         .addComponent(this.jScrollPane8, -1, 168, 32767));
/*      */ 
/*      */     
/* 1217 */     this.jScrollPane9.setViewportView(this.jPanel13);
/*      */     
/* 1219 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1220 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1221 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1223 */         .addComponent(this.jPanel12, -2, 0, 32767)
/* 1224 */         .addComponent(this.jScrollPane9, -1, 598, 32767));
/*      */     
/* 1226 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1227 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1228 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1229 */           .addComponent(this.jScrollPane9, -1, 180, 32767)
/* 1230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1231 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 1232 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1235 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1236 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1237 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1239 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 1240 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 1241 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/* 1243 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1245 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1246 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1247 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1248 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1249 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1250 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1253 */     GroupLayout layout = new GroupLayout(this);
/* 1254 */     setLayout(layout);
/* 1255 */     layout.setHorizontalGroup(layout
/* 1256 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1257 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1259 */     layout.setVerticalGroup(layout
/* 1260 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1261 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField60KeyReleased(KeyEvent evt) {
/* 1266 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 1270 */     if (this.PRIMERA) {
/* 1271 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1276 */     if (evt.getClickCount() == 2) {
/* 1277 */       limpiar();
/* 1278 */       desabilitar();
/* 1279 */       verUnidad();
/* 1280 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 1289 */     this.utilerias.guardarTableAExcel((JTable)this.rSTableMetro1, this.USUARIO, "UTILITARIOS");
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 1294 */       if (!this.rSTableMetro1.print());
/*      */     
/*      */     }
/* 1297 */     catch (PrinterException printerException) {}
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 1302 */     limpiar();
/* 1303 */     habilitar();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1309 */     this.materialButton22.setText("Guardar");
/* 1310 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 1311 */     this.materialButton22.setMnemonic('G');
/* 1312 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 1322 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1323 */     if (ind < 0) {
/* 1324 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar los datos", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1326 */       limpiar();
/* 1327 */       habilitar();
/* 1328 */       verUnidad();
/*      */       
/* 1330 */       this.materialButton22.setText("Modificar");
/* 1331 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 1332 */       this.materialButton22.setMnemonic('M');
/* 1333 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {
/* 1338 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1339 */     if (ind < 0) {
/* 1340 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder darlo de baja", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1342 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Al eliminar la unidad, todos los documentos registrados pasarán a BAJA<p><b> ¿Estás seguro que deseas eliminar el remolque que seleccionaste?</b></html>", "Eliminar registro", 0, 3, this.ELIMINAR);
/* 1343 */       if (res == 0) {
/* 1344 */         String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 17));
/* 1345 */         if (estatus.contains("BAJA")) {
/* 1346 */           JOptionPane.showMessageDialog(this.padre, "El vehículo que seleccionaste ya se encuentra dado de baja, verifica tus datos", "No se puede cancelar", 0, this.ERROR);
/*      */         } else {
/* 1348 */           String numEco = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 1349 */           eliminarDoc(numEco);
/* 1350 */           this.con.inserSinMsj("update utilitarios set estado = 'BAJA' where num = " + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/* 1351 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 1358 */     if (this.PRIMERA) {
/* 1359 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField61KeyReleased(KeyEvent evt) {
/* 1364 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField62KeyReleased(KeyEvent evt) {
/* 1368 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField63KeyReleased(KeyEvent evt) {
/* 1372 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField64KeyReleased(KeyEvent evt) {
/* 1376 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 1380 */     if (this.PRIMERA) {
/* 1381 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 1386 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 1390 */     String dato = this.jFormattedTextField1.getText();
/*      */     
/* 1392 */     if (this.jTextField100.getText().equals("")) {
/* 1393 */       this.jTextField100.setBackground(Color.RED);
/* 1394 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número económico", "Ingresa el económico", 0, this.ADVER);
/* 1395 */     } else if (this.jTextField101.getText().equals("")) {
/* 1396 */       this.jTextField101.setBackground(Color.RED);
/* 1397 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número de serie", "Ingresa el núm de serie", 0, this.ADVER);
/* 1398 */     } else if (this.jTextField102.getText().equals("")) {
/* 1399 */       this.jTextField102.setBackground(Color.RED);
/* 1400 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar las placas", "Ingresa las placas", 0, this.ADVER);
/* 1401 */     } else if (this.materialButton22.getText().equals("Guardar")) {
/* 1402 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar la información del nuevo vehículo?", "Crear Nuevo", 0, 3, this.PREG);
/* 1403 */       if (res == 0) {
/* 1404 */         String tc = "";
/* 1405 */         String poliza = "";
/* 1406 */         String sedema = "";
/* 1407 */         String nom012 = "";
/* 1408 */         String verificacion = "";
/* 1409 */         String fisicomecanica = "";
/* 1410 */         String sct = "";
/* 1411 */         String clave = this.jTextField100.getText();
/*      */         
/* 1413 */         this.con.inserSinMsj("insert into utilitarios (eco, modelo, serie, placas, motor, numFactura, formaPago, fechacompra, color, kmActual, marca, tipo, tc, poliza, verificacion, sucursal, comentarios, usuario, estado) values ('" + this.jTextField100
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1420 */             .getText().toUpperCase() + "', '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', '" + this.jTextField101.getText().toUpperCase() + "', '" + this.jTextField102.getText().toUpperCase() + "', '" + this.jTextField103
/* 1421 */             .getText().toUpperCase() + "', '" + this.jTextField104.getText().toUpperCase() + "', '" + this.jComboBox21.getSelectedItem().toString().toUpperCase() + "', '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "', '" + this.jTextField105
/* 1422 */             .getText().toUpperCase() + "', '" + dato + "', '" + this.jTextField107.getText().toUpperCase() + "', '" + this.jTextField108.getText().toUpperCase() + "', '" + this.jTextField109
/* 1423 */             .getText().toUpperCase() + "', '" + this.jTextField110.getText().toUpperCase() + "', '" + this.jTextField111.getText().toUpperCase() + "', '" + String.valueOf(this.jComboBox25.getSelectedItem()) + "', '', '" + this.utilerias
/* 1424 */             .sacarUsuario(this.USUARIO) + "', '" + String.valueOf(this.jComboBox24.getSelectedItem()) + "')");
/*      */         
/* 1426 */         this.jDialog1.setVisible(false);
/* 1427 */         consultar();
/*      */       } 
/*      */     } else {
/* 1430 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar la información del vehículo?", "Modificar", 0, 3, this.PREG);
/* 1431 */       if (res == 0) {
/* 1432 */         String tc = "";
/* 1433 */         String poliza = "";
/* 1434 */         String sedema = "";
/* 1435 */         String nom012 = "";
/* 1436 */         String verificacion = "";
/* 1437 */         String fisicomecanica = "";
/* 1438 */         String sct = "";
/*      */         
/* 1440 */         this.con.inserSinMsj("update utilitarios set eco = '" + this.jTextField100
/* 1441 */             .getText().toUpperCase() + "', modelo = '" + 
/* 1442 */             String.valueOf(this.jComboBox20.getSelectedItem()) + "', serie = '" + this.jTextField101
/* 1443 */             .getText().toUpperCase() + "', placas = '" + this.jTextField102
/* 1444 */             .getText().toUpperCase() + "', motor = '" + this.jTextField103
/* 1445 */             .getText().toUpperCase() + "', numFactura = '" + this.jTextField104
/* 1446 */             .getText().toUpperCase() + "', formaPago = '" + this.jComboBox21
/* 1447 */             .getSelectedItem().toString().toUpperCase() + "', fechaCompra = '" + this.utilerias
/* 1448 */             .convertirFechaDateString(this.jDateChooser1.getDate()) + "', color = '" + this.jTextField105
/* 1449 */             .getText().toUpperCase() + "', kmActual = '" + dato + "', marca = '" + this.jTextField107
/*      */             
/* 1451 */             .getText().toUpperCase() + "', tipo = '" + this.jTextField108
/* 1452 */             .getText().toUpperCase() + "', tc = '" + this.jTextField109
/* 1453 */             .getText().toUpperCase() + "', poliza = '" + this.jTextField110
/* 1454 */             .getText().toUpperCase() + "', verificacion = '" + this.jTextField111
/* 1455 */             .getText().toUpperCase() + "', sucursal = '" + this.jComboBox25
/* 1456 */             .getSelectedItem().toString().toUpperCase() + "', usuario = '" + this.utilerias
/* 1457 */             .sacarUsuario(this.USUARIO) + "', estado = '" + this.jComboBox24
/* 1458 */             .getSelectedItem().toString().toUpperCase() + "' where num = " + 
/* 1459 */             String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */         
/* 1461 */         this.jDialog1.setVisible(false);
/* 1462 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 1468 */     if (existeDoc()) {
/* 1469 */       JOptionPane.showMessageDialog(this.jDialog2, "El tipo de documento ya se encuentra enlistado, necesitas modificarlo", "Documento Creado", 0, this.ERROR);
/*      */     } else {
/* 1471 */       this.jDialog2.setVisible(false);
/* 1472 */       String guardar = "APLICAR";
/* 1473 */       if (this.materialButton22.getText().equals("Guardar")) {
/* 1474 */         guardar = "TEMPORAL";
/*      */       } else {
/* 1476 */         this.DOCUMENTACION = new LinkedHashMap<>();
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
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 1488 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField63ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 1500 */     if (evt.getClickCount() == 2) {
/* 1501 */       if (this.TIPOSELEC.equals("Marca"));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1506 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 1515 */     if (this.TIPOSELEC.equals("Marca")) {
/* 1516 */       this.jLabel34.setText("Ingresa el nombre de la marca del tractor");
/*      */     } else {
/* 1518 */       this.jLabel34.setText("Ingresa el nombre del tipo de tractor");
/*      */     } 
/* 1520 */     this.jTextField24.setText("");
/* 1521 */     this.materialButton25.setText("Agregar");
/* 1522 */     this.materialButton25.setMnemonic('A');
/* 1523 */     this.materialButton25.setToolTipText("Agregar (Alt+A)");
/* 1524 */     this.jDialog4.setTitle("Agregar");
/* 1525 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton59ActionPerformed(ActionEvent evt) {
/* 1529 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1530 */     if (ind < 0) {
/* 1531 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1533 */       this.materialButton25.setText("Modificar");
/* 1534 */       this.materialButton25.setMnemonic('M');
/* 1535 */       this.materialButton25.setToolTipText("Modificar tipo (Alt+M)");
/* 1536 */       this.jTextField24.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/* 1537 */       this.jDialog4.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton61ActionPerformed(ActionEvent evt) {
/* 1542 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1543 */     if (ind < 0) {
/* 1544 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 1546 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas eleiminar la información que seleccionaste?", "Eliminar...", 0, 3, this.PREG);
/* 1547 */       if (res == 0) {
/* 1548 */         if (this.TIPOSELEC.equals("Marca")) {
/* 1549 */           this.con.eliminar("marca", "where id_marca=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 1550 */           llenarMarca();
/* 1551 */           consultarMarcas();
/*      */         } else {
/* 1553 */           this.con.eliminar("tipos", "where id_tipo=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 1554 */           llenarTipo();
/* 1555 */           consultarTipos();
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField17ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {
/* 1566 */     if (this.TIPOSELEC.equals("Marca")) {
/* 1567 */       consultarMarcas();
/*      */     } else {
/* 1569 */       consultarTipos();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField24ActionPerformed(ActionEvent evt) {
/* 1574 */     guardarMarcasTipos();
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 1578 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 1582 */     guardarMarcasTipos();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jScrollPane8MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField109ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   public void eliminarDoc(String numEco) {
/* 1594 */     String[] doc = this.con.regresaColIndex("unidadesdocumentos.numDoc", "unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.numDoc = unidadesdocumentos.numDoc and unidadesdocumentos.estado = 'ACTIVO' and unidadesdoctractos.tipo = 'TRACTO' and unidadesdoctractos.num_tracto = " + numEco);
/*      */ 
/*      */ 
/*      */     
/* 1598 */     for (String d : doc) {
/* 1599 */       this.con.inserSinMsj("update unidadesdocumentos set estado = 'BAJA' where numDoc = " + d);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean validadPesoUnidad() {
/* 1604 */     boolean resultado = true;
/* 1605 */     String dato = this.jFormattedTextField1.getText();
/* 1606 */     double val = Double.parseDouble(dato);
/* 1607 */     if (dato.contains("-")) {
/* 1608 */       this.jFormattedTextField1.setBackground(Color.red);
/* 1609 */       JOptionPane.showMessageDialog(this.jDialog1, "El peso de la unidad no puede ser Negativo", "No se aceptan valores negativos", 1, this.ERROR);
/* 1610 */       resultado = false;
/* 1611 */     } else if (val < 0.1D) {
/* 1612 */       this.jFormattedTextField1.setBackground(Color.red);
/* 1613 */       JOptionPane.showMessageDialog(this.jDialog1, "No se aceptan valores pequeños menores a 1", "Valores muy pequeños", 1, this.ERROR);
/* 1614 */       resultado = false;
/* 1615 */     } else if (val > 99.0D) {
/* 1616 */       this.jFormattedTextField1.setBackground(Color.red);
/* 1617 */       JOptionPane.showMessageDialog(this.jDialog1, "No se aceptan valores mayores a 99", "Valores muy grandes", 1, this.ERROR);
/* 1618 */       resultado = false;
/*      */     } 
/* 1620 */     return resultado;
/*      */   }
/*      */   
/*      */   public void verUnidad() {
/* 1624 */     String[] datos = this.con.regresaRegIndex("eco, modelo, serie, placas, motor, numFactura, formaPago, fechaCompra, color,kmActual, marca, tipo, tc, poliza, verificacion, sucursal, comentarios, estado", "utilitarios", "where num= " + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1630 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */     
/* 1632 */     this.jTextField100.setText(datos[0]);
/* 1633 */     this.jComboBox20.setSelectedItem(datos[1]);
/* 1634 */     this.jTextField101.setText(datos[2]);
/* 1635 */     this.jTextField102.setText(datos[3]);
/* 1636 */     this.jTextField103.setText(datos[4]);
/* 1637 */     this.jTextField104.setText(datos[5]);
/*      */     
/* 1639 */     this.jComboBox21.setSelectedItem(datos[6]);
/*      */     
/* 1641 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(datos[7]));
/* 1642 */     this.jTextField105.setText(datos[8]);
/*      */ 
/*      */     
/* 1645 */     this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(datos[9])));
/*      */     
/* 1647 */     this.jTextField107.setText(datos[10]);
/*      */     
/* 1649 */     this.jTextField108.setText(datos[11]);
/* 1650 */     this.jTextField109.setText(datos[12]);
/* 1651 */     this.jTextField110.setText(datos[13]);
/*      */     
/* 1653 */     this.jTextField111.setText(datos[14]);
/*      */ 
/*      */ 
/*      */     
/* 1657 */     this.jComboBox25.setSelectedItem(datos[15]);
/* 1658 */     this.jComboBox24.setSelectedItem(datos[17]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void desabilitar() {
/* 1664 */     this.jTextField100.setEnabled(false);
/* 1665 */     this.jTextField101.setEnabled(false);
/* 1666 */     this.jTextField102.setEnabled(false);
/* 1667 */     this.jTextField103.setEnabled(false);
/* 1668 */     this.jTextField104.setEnabled(false);
/* 1669 */     this.jTextField105.setEnabled(false);
/* 1670 */     this.jTextField106.setEnabled(false);
/* 1671 */     this.jTextField107.setEnabled(false);
/* 1672 */     this.jTextField108.setEnabled(false);
/* 1673 */     this.jTextField109.setEnabled(false);
/* 1674 */     this.jTextField110.setEnabled(false);
/* 1675 */     this.jTextField111.setEnabled(false);
/* 1676 */     this.jComboBox20.setEnabled(false);
/* 1677 */     this.jComboBox21.setEnabled(false);
/*      */ 
/*      */     
/* 1680 */     this.jComboBox24.setEnabled(false);
/* 1681 */     this.jComboBox25.setEnabled(false);
/*      */ 
/*      */     
/* 1684 */     this.jDateChooser1.setEnabled(false);
/*      */ 
/*      */ 
/*      */     
/* 1688 */     this.materialButton22.setEnabled(false);
/*      */ 
/*      */     
/* 1691 */     this.jFormattedTextField1.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 1695 */     System.out.println("priv " + (String)this.CAMPOSGENERALES.get("priv") + " " + this.PRIVILEGIOS.containsValue("SUPER USUARIO"));
/* 1696 */     if (this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 1697 */       this.jButton35.setEnabled(true);
/* 1698 */       this.jButton36.setEnabled(true);
/* 1699 */       this.jButton37.setEnabled(true);
/* 1700 */       this.materialButton22.setEnabled(true);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1705 */       this.jButton35.setEnabled(false);
/* 1706 */       this.jButton36.setEnabled(false);
/* 1707 */       this.jButton37.setEnabled(false);
/* 1708 */       this.materialButton22.setEnabled(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void habilitar() {
/* 1716 */     this.jTextField100.setEnabled(true);
/* 1717 */     this.jTextField101.setEnabled(true);
/* 1718 */     this.jTextField102.setEnabled(true);
/* 1719 */     this.jTextField103.setEnabled(true);
/* 1720 */     this.jTextField104.setEnabled(true);
/* 1721 */     this.jTextField105.setEnabled(true);
/* 1722 */     this.jTextField106.setEnabled(true);
/* 1723 */     this.jTextField107.setEnabled(true);
/* 1724 */     this.jTextField108.setEnabled(true);
/* 1725 */     this.jComboBox20.setEnabled(true);
/* 1726 */     this.jComboBox21.setEnabled(true);
/*      */ 
/*      */     
/* 1729 */     this.jComboBox24.setEnabled(true);
/*      */ 
/*      */     
/* 1732 */     this.jDateChooser1.setEnabled(true);
/*      */ 
/*      */ 
/*      */     
/* 1736 */     this.materialButton22.setEnabled(true);
/*      */     
/* 1738 */     this.jComboBox25.setEnabled(true);
/*      */     
/* 1740 */     this.jFormattedTextField1.setEnabled(true);
/*      */     
/* 1742 */     this.jTextField109.setEnabled(true);
/* 1743 */     this.jTextField110.setEnabled(true);
/* 1744 */     this.jTextField111.setEnabled(true);
/*      */   }
/*      */   
/*      */   public boolean existeValor(Map Mapa, String buscar) {
/* 1748 */     return Mapa.containsValue(buscar);
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertarDocumentos(String claveTracto, String TipoDoc) {
/* 1753 */     String claveDoc = "";
/* 1754 */     this.con.inserSinMsj("insert into unidadesdocumentos (tipo, fechaCaptura, fechaTramite, numeroUnico, periodoVencimiento, fechaInicio, fechaVencimiento, dependencia, costo, dirTramite, telefono, comentarios, estado, usuario) values ('" + ((UnidadesTractosDoc)this.DOCUMENTACION
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1761 */         .get(TipoDoc)).getInformacion().getTipo() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1762 */         .get(TipoDoc)).getInformacion().getfCaptura() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1763 */         .get(TipoDoc)).getInformacion().getFtramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1764 */         .get(TipoDoc)).getInformacion().getNumUnico() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1765 */         .get(TipoDoc)).getInformacion().getpVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1766 */         .get(TipoDoc)).getInformacion().getFinicio() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1767 */         .get(TipoDoc)).getInformacion().getfVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1768 */         .get(TipoDoc)).getInformacion().getDependencia() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1769 */         .get(TipoDoc)).getInformacion().getCosto() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1770 */         .get(TipoDoc)).getInformacion().getDirTramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1771 */         .get(TipoDoc)).getInformacion().getTel() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1772 */         .get(TipoDoc)).getInformacion().getComentarios() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1773 */         .get(TipoDoc)).getInformacion().getEstado() + "', '" + this.utilerias
/* 1774 */         .sacarUsuario(this.USUARIO) + "')");
/*      */ 
/*      */ 
/*      */     
/* 1778 */     this.con.consultar("max(numDoc)", "unidadesdocumentos", "");
/* 1779 */     claveDoc = this.con.Campo;
/*      */     
/* 1781 */     for (int i = 0; i < ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().size(); i++) {
/* 1782 */       this.con.inserSinMsj("insert into unidadesarchivos ( nombreArch, tipo, fecha, numDoc ) values ( '" + 
/*      */ 
/*      */           
/* 1785 */           copiarArchivos(((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().get("" + i)).getArchivo(), getRutaDestino(TipoDoc)) + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 1786 */           .get(TipoDoc)).getDocumentos().get("" + i)).getTipo() + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 1787 */           .get(TipoDoc)).getDocumentos().get("" + i)).getAct() + "', " + claveDoc + ")");
/*      */     }
/*      */ 
/*      */     
/* 1791 */     this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + claveTracto + ",'TRACTO' )");
/* 1792 */     String[] ecos = ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getlistaEcos();
/* 1793 */     for (int j = 0; j < ecos.length; j++) {
/* 1794 */       System.out.println("dentro " + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo() + " " + TipoDoc + " " + ecos[j]);
/* 1795 */       this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto) values(" + claveDoc + ", " + ecos[j] + ",'TRACTO' )");
/* 1796 */       if (this.CAMPOS.containsValue(((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo())) {
/* 1797 */         this.con.inserSinMsj("update tracto set " + convertirTipoDocCampo(TipoDoc) + " = '" + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getNumUnico() + "' where num_tracto= " + ecos[j]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String copiarArchivos(String origen, String destino) {
/* 1804 */     if (this.TIPOV.equals("")) {
/* 1805 */       this.TIPOV = "ECO";
/*      */     }
/* 1807 */     Path origenPath = Paths.get(origen, new String[0]);
/* 1808 */     Path destinoPath = Paths.get(destino + "/" + destino + this.TIPOV + "-" + this.utilerias.getFechaSinEspacios(), new String[0]);
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1813 */       Files.copy(origenPath, destinoPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*      */     }
/* 1815 */     catch (FileNotFoundException ex) {
/* 1816 */       System.out.println("ERROR 1: al copiar Arhivo: " + ex.getMessage());
/* 1817 */     } catch (IOException ex) {
/* 1818 */       System.out.println("ERROR 2: al copiar Arhivo: " + ex.getMessage());
/*      */     } 
/* 1820 */     String nuevaRuta = destinoPath.toString().replace("\\", "\\\\");
/* 1821 */     return nuevaRuta;
/*      */   }
/*      */   
/*      */   public String getRutaDestino(String tipo) {
/* 1825 */     String ruta = this.CARPETAS.get("OTRO");
/* 1826 */     if (tipo.equals("TARJETA DE CIRCULACIÓN")) {
/* 1827 */       ruta = this.CARPETAS.get("TC");
/* 1828 */     } else if (tipo.equals("PÓLIZA DE SEGURO")) {
/* 1829 */       ruta = this.CARPETAS.get("POLIZA");
/* 1830 */     } else if (tipo.equals("SEDEMA")) {
/* 1831 */       ruta = this.CARPETAS.get("SEDEMA");
/* 1832 */     } else if (tipo.equals("NOM 012")) {
/* 1833 */       ruta = this.CARPETAS.get("NOM012");
/* 1834 */     } else if (tipo.equals("VERIFICACIÓN")) {
/* 1835 */       ruta = this.CARPETAS.get("VERIFICACION");
/* 1836 */     } else if (tipo.equals("FISICOMECÁNICA")) {
/* 1837 */       ruta = this.CARPETAS.get("FISICOMECANICA");
/* 1838 */     } else if (tipo.equals("SCT")) {
/* 1839 */       ruta = this.CARPETAS.get("SCT");
/* 1840 */     } else if (tipo.equals("PAGO")) {
/* 1841 */       ruta = this.CARPETAS.get("PAGOS");
/*      */     } 
/*      */     
/* 1844 */     return ruta;
/*      */   }
/*      */   
/*      */   public void guardarMarcasTipos() {
/* 1848 */     String marca = this.jTextField24.getText().toUpperCase();
/* 1849 */     if (marca.equals("")) {
/* 1850 */       this.jTextField24.setBackground(Color.RED);
/* 1851 */       JOptionPane.showMessageDialog(this.jDialog4, "No puedes dejar el campo vacío, por favor verifica tu información", "Falta información", 0, this.ADVER);
/* 1852 */     } else if (this.TIPOSELEC.equals("Marca")) {
/* 1853 */       if (existeValor(this.MARCAS, this.jTextField24.getText().toUpperCase())) {
/* 1854 */         this.jTextField24.setBackground(Color.RED);
/* 1855 */         JOptionPane.showMessageDialog(this.jDialog4, "La marca que deseas agregar ya se encuentra almacenada, por favor verifica tu información", "Marca ya existe", 0, this.ADVER);
/* 1856 */       } else if (this.materialButton25.getText().equals("Agregar")) {
/* 1857 */         int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar la nueva marca?", "Agregar nueva marca", 0, 3, this.PREG);
/* 1858 */         if (res == 0) {
/* 1859 */           this.con.inserSinMsj("insert into marca(marca) values('" + marca + "')");
/* 1860 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos) values (now(),'" + this.USUARIO + "','Almacenó una nueva marca de carro.','\nMarca: " + marca + "')");
/* 1861 */           llenarMarca();
/* 1862 */           this.jDialog3.setVisible(false);
/* 1863 */           this.jDialog4.setVisible(false);
/*      */         } 
/*      */       } else {
/*      */         
/* 1867 */         this.con.inserSinMsj("update marca set marca ='" + this.jTextField24.getText().toUpperCase() + "' where marca ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 1868 */         this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 1869 */         llenarMarca();
/*      */         
/* 1871 */         this.jDialog4.setVisible(false);
/* 1872 */         this.jDialog3.setVisible(false);
/*      */       }
/*      */     
/* 1875 */     } else if (existeValor(this.TIPOS, this.jTextField24.getText().toUpperCase())) {
/* 1876 */       this.jTextField24.setBackground(Color.RED);
/* 1877 */       JOptionPane.showMessageDialog(this.jDialog4, "El tipo de tractor que deseas agregar ya se encuentra almacenado, por favor verifica tu información", "Tipo ya existe", 0, this.ADVER);
/* 1878 */     } else if (this.materialButton25.getText().equals("Agregar")) {
/* 1879 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar el nuevo tipo?", "Agregar nuevo tipo", 0, 3, this.PREG);
/* 1880 */       if (res == 0) {
/* 1881 */         this.con.inserSinMsj("insert into tipos(tipo)values('" + marca + "')");
/* 1882 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo tipo de carro.','Tipo: " + marca + "')");
/* 1883 */         llenarTipo();
/* 1884 */         this.jDialog3.setVisible(false);
/* 1885 */         this.jDialog4.setVisible(false);
/*      */       } 
/*      */     } else {
/*      */       
/* 1889 */       this.con.inserSinMsj("update tipos set tipo ='" + this.jTextField24.getText().toUpperCase() + "' where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 1890 */       this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 1891 */       llenarTipo();
/*      */       
/* 1893 */       this.jDialog4.setVisible(false);
/* 1894 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void activarVentanas(JButton boton) {
/* 1900 */     if (this.TIPOSELEC.equals("Marca")) {
/* 1901 */       consultarMarcas();
/* 1902 */       Dimension di = boton.getSize();
/* 1903 */       Point p = boton.getLocationOnScreen();
/* 1904 */       this.jDialog3.setLocation(p.x + di.width + 5, p.y + 35);
/* 1905 */       this.jDialog3.setVisible(true);
/*      */     } else {
/* 1907 */       consultarTipos();
/* 1908 */       Dimension di = boton.getSize();
/* 1909 */       Point p = boton.getLocationOnScreen();
/* 1910 */       this.jDialog3.setLocation(p.x + di.width - 300, p.y + 35);
/* 1911 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarMarcas() {
/* 1916 */     String marca = "";
/* 1917 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 1918 */       marca = this.jTextField17.getText();
/*      */     }
/* 1920 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Marca" }, "id_marca,marca", "marca", "where marca like '%" + marca + "%' order by marca");
/*      */ 
/*      */     
/* 1923 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 1924 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */   }
/*      */   
/*      */   public void consultarTipos() {
/* 1928 */     String tipo = "";
/* 1929 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 1930 */       tipo = this.jTextField17.getText();
/*      */     }
/* 1932 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Tipo" }, "id_tipo,tipo", "tipos", "where tipo like '%" + tipo + "%' order by tipo");
/*      */ 
/*      */     
/* 1935 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 1936 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */   }
/*      */   
/*      */   public String convertirTipoDocCampo(String tipoDoc) {
/* 1940 */     String campo = "";
/* 1941 */     if (tipoDoc.equals("TARJETA DE CIRCULACIÓN")) {
/* 1942 */       campo = "tc";
/* 1943 */     } else if (tipoDoc.equals("PÓLIZA DE SEGURO")) {
/* 1944 */       campo = "poliza";
/* 1945 */     } else if (tipoDoc.equals("SEDEMA")) {
/* 1946 */       campo = "sedema";
/* 1947 */     } else if (tipoDoc.equals("NOM 012")) {
/* 1948 */       campo = "nom012";
/* 1949 */     } else if (tipoDoc.equals("VERIFICACIÓN")) {
/* 1950 */       campo = "verificacion";
/* 1951 */     } else if (tipoDoc.equals("FISICOMECÁNICA")) {
/* 1952 */       campo = "fisicomecanica";
/* 1953 */     } else if (tipoDoc.equals("SCT")) {
/* 1954 */       campo = "sct";
/* 1955 */     } else if (tipoDoc.equals("PAGO")) {
/* 1956 */       campo = "pago";
/*      */     } 
/*      */     
/* 1959 */     return campo;
/*      */   }
/*      */   
/*      */   public String dameTipoDocSelec() {
/* 1963 */     String tipo = "";
/* 1964 */     if (this.jRadioButton1.isSelected()) {
/* 1965 */       tipo = "TARJETA DE CIRCULACIÓN";
/*      */     }
/* 1967 */     if (this.jRadioButton2.isSelected()) {
/* 1968 */       tipo = "PÓLIZA DE SEGURO";
/*      */     }
/* 1970 */     if (this.jRadioButton3.isSelected()) {
/* 1971 */       tipo = "SEDEMA";
/*      */     }
/* 1973 */     if (this.jRadioButton4.isSelected()) {
/* 1974 */       tipo = "NOM 012";
/*      */     }
/* 1976 */     if (this.jRadioButton5.isSelected()) {
/* 1977 */       tipo = "VERIFICACIÓN";
/*      */     }
/* 1979 */     if (this.jRadioButton6.isSelected()) {
/* 1980 */       tipo = "FISICOMECÁNICA";
/*      */     }
/* 1982 */     if (this.jRadioButton7.isSelected()) {
/* 1983 */       tipo = "SCT";
/*      */     }
/* 1985 */     if (this.jRadioButton8.isSelected()) {
/* 1986 */       tipo = "PAGO";
/*      */     }
/* 1988 */     if (this.jRadioButton9.isSelected()) {
/* 1989 */       tipo = "OTRO";
/*      */     }
/* 1991 */     return tipo;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean existeDoc() {
/* 1996 */     boolean existe = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2011 */     return existe;
/*      */   }
/*      */   
/*      */   public void llenarModelo() {
/* 2015 */     int año = this.fechaActual.getYear();
/* 2016 */     año += 1901;
/* 2017 */     this.jComboBox9.removeAllItems();
/* 2018 */     this.jComboBox9.addItem("MODELO");
/* 2019 */     for (int i = año; i >= 1990; i--) {
/* 2020 */       this.jComboBox20.addItem("" + i);
/* 2021 */       this.jComboBox9.addItem("" + i);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarMarca() {
/* 2026 */     String[] depa = this.con.regresaColIndex("marca", "marca", "order by marca");
/*      */ 
/*      */ 
/*      */     
/* 2030 */     for (int i = 0; i < depa.length; i++) {
/* 2031 */       this.MARCAS.put("" + i, depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarTipo() {
/* 2036 */     String[] tipo = this.con.regresaColIndex("tipo", "tipos", "order by tipo");
/*      */ 
/*      */ 
/*      */     
/* 2040 */     for (int i = 0; i < tipo.length; i++) {
/* 2041 */       this.TIPOS.put("" + i, tipo[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2046 */     this.pintar.colorear(this.jTextField60);
/* 2047 */     this.pintar.colorear(this.jTextField61);
/* 2048 */     this.pintar.colorear(this.jTextField62);
/* 2049 */     this.pintar.colorear(this.jTextField63);
/* 2050 */     this.pintar.colorear(this.jTextField64);
/* 2051 */     this.pintar.colorear(this.jComboBox9);
/* 2052 */     this.pintar.colorear(this.jComboBox10);
/* 2053 */     this.pintar.colorear(this.jComboBox11);
/*      */     
/* 2055 */     this.pintar.colorear(this.jTextField100);
/* 2056 */     this.pintar.colorear(this.jTextField101);
/* 2057 */     this.pintar.colorear(this.jTextField102);
/* 2058 */     this.pintar.colorear(this.jTextField103);
/* 2059 */     this.pintar.colorear(this.jTextField104);
/* 2060 */     this.pintar.colorear(this.jTextField105);
/* 2061 */     this.pintar.colorear(this.jTextField106);
/* 2062 */     this.pintar.colorear(this.jTextField107);
/* 2063 */     this.pintar.colorear(this.jTextField108);
/* 2064 */     this.pintar.colorear(this.jTextField17);
/* 2065 */     this.pintar.colorear(this.jTextField24);
/*      */     
/* 2067 */     this.pintar.colorear(this.jComboBox20);
/* 2068 */     this.pintar.colorear(this.jComboBox21);
/*      */ 
/*      */     
/* 2071 */     this.pintar.colorear(this.jComboBox24);
/* 2072 */     this.pintar.colorear(this.jComboBox25);
/* 2073 */     this.pintar.colorear(this.jFormattedTextField1);
/*      */   }
/*      */   
/*      */   public void ingresarCampos() {
/* 2077 */     this.CAMPOS.put("TARJETA DE CIRCULACIÓN", "TARJETA DE CIRCULACIÓN");
/* 2078 */     this.CAMPOS.put("PÓLIZA DE SEGURO", "PÓLIZA DE SEGURO");
/* 2079 */     this.CAMPOS.put("POLIZA", "POLIZA");
/* 2080 */     this.CAMPOS.put("SEDEMA", "SEDEMA");
/* 2081 */     this.CAMPOS.put("NOM 012", "NOM 012");
/* 2082 */     this.CAMPOS.put("VERIFICACIÓN", "VERIFICACIÓN");
/* 2083 */     this.CAMPOS.put("FISICOMECÁNICA", "FISICOMECÁNICA");
/* 2084 */     this.CAMPOS.put("SCT", "SCT");
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 2088 */     this.DOCUMENTACION = new LinkedHashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2097 */     this.jTextField100.setText("");
/* 2098 */     this.jTextField101.setText("");
/* 2099 */     this.jTextField102.setText("");
/* 2100 */     this.jTextField103.setText("");
/* 2101 */     this.jTextField104.setText("");
/* 2102 */     this.jTextField105.setText("");
/* 2103 */     this.jTextField106.setText("");
/* 2104 */     this.jTextField107.setText("");
/* 2105 */     this.jTextField108.setText("");
/* 2106 */     this.jTextField109.setText("");
/* 2107 */     this.jTextField110.setText("");
/* 2108 */     this.jTextField111.setText("");
/* 2109 */     this.jComboBox20.setSelectedIndex(0);
/* 2110 */     this.jComboBox21.setSelectedIndex(0);
/*      */ 
/*      */     
/* 2113 */     this.jComboBox24.setSelectedIndex(0);
/* 2114 */     this.jComboBox25.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/* 2115 */     this.jDateChooser1.setDate(new Date());
/* 2116 */     this.jFormattedTextField1.setValue(Double.valueOf(1.0D));
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
/*      */   public void utilitarios(String usua) {
/* 2174 */     this.USUARIO = usua;
/* 2175 */     this.panel.setViewportView(this);
/* 2176 */     privilegios();
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
/*      */   public void llenarComboEstados() {
/* 2196 */     this.ESTADOS = this.con.regresaColIndex("distinct(estado)", "tracto", " order by estado");
/* 2197 */     this.jComboBox10.removeAllItems();
/* 2198 */     this.jComboBox10.addItem("ESTADO");
/* 2199 */     this.utilerias.llenarCombo(this.jComboBox10, this.ESTADOS);
/* 2200 */     this.jComboBox10.setSelectedItem("ACTIVO");
/*      */   }
/*      */   
/*      */   public void llenarComboSuc() {
/* 2204 */     this.SUCURSALES = this.con2.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 2205 */     this.jComboBox11.removeAllItems();
/* 2206 */     this.jComboBox25.removeAllItems();
/* 2207 */     this.utilerias.llenarCombo(this.jComboBox11, this.SUCURSALES);
/* 2208 */     this.utilerias.llenarCombo(this.jComboBox25, this.SUCURSALES);
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
/*      */   public void consultar() {
/* 2286 */     this.PRIMERA = true;
/* 2287 */     String eco = "";
/* 2288 */     String serie = "";
/* 2289 */     String placas = "";
/* 2290 */     String marca = "";
/* 2291 */     String tipo = "";
/* 2292 */     String modelo = "";
/* 2293 */     String estado = "";
/* 2294 */     String sucursal = "";
/*      */     
/* 2296 */     if (!this.jTextField60.getText().equals(this.holderEco)) {
/* 2297 */       eco = this.jTextField60.getText();
/*      */     }
/* 2299 */     if (!this.jTextField61.getText().equals(this.holderSerie)) {
/* 2300 */       serie = this.jTextField61.getText();
/*      */     }
/* 2302 */     if (!this.jTextField62.getText().equals(this.holderPlacas)) {
/* 2303 */       placas = this.jTextField62.getText();
/*      */     }
/* 2305 */     if (!this.jTextField63.getText().equals(this.holderMarca)) {
/* 2306 */       marca = this.jTextField63.getText();
/*      */     }
/* 2308 */     if (!this.jTextField64.getText().equals(this.holderTipo)) {
/* 2309 */       tipo = this.jTextField64.getText();
/*      */     }
/*      */     
/* 2312 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 2313 */       modelo = this.jComboBox9.getSelectedItem().toString();
/*      */     }
/* 2315 */     if (this.jComboBox10.getSelectedIndex() != 0) {
/* 2316 */       estado = this.jComboBox10.getSelectedItem().toString();
/*      */     }
/* 2318 */     if (!this.jComboBox11.getSelectedItem().equals("GENERAL")) {
/* 2319 */       sucursal = this.jComboBox11.getSelectedItem().toString();
/*      */     }
/*      */     
/* 2322 */     (new String[19])[0] = "#"; (new String[19])[1] = "Eco"; (new String[19])[2] = "Modelo"; (new String[19])[3] = "Serie"; (new String[19])[4] = "Placas"; (new String[19])[5] = "Motor"; (new String[19])[6] = "Factura"; (new String[19])[7] = "Forma de Pago"; (new String[19])[8] = "Fecha de Compra"; (new String[19])[9] = "Color"; (new String[19])[10] = "Kilometraje"; (new String[19])[11] = "Marca"; (new String[19])[12] = "Tipo"; (new String[19])[13] = "Tarjeta de Circulación"; (new String[19])[14] = "Poliza"; (new String[19])[15] = "Verificación"; (new String[19])[16] = "Sucursal"; (new String[19])[17] = "Usuario"; (new String[19])[18] = "Estado"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos("num, eco, modelo, serie, placas, motor, numFactura, formaPago, fechaCompra, color, kmActual, marca, tipo, tc, poliza, verificacion, sucursal, usuario, estado", "utilitarios", "where eco like '%" + eco + "%' and serie like '%" + serie + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "' and marca like '%" + marca + "%' and sucursal like '%" + sucursal + "%' order by eco asc"), (Object[])new String[19])
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2340 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2346 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 2350 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/* 2351 */     this.rSTableMetro1.setSelectionMode(0);
/* 2352 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 2353 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2354 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 2355 */     this.rSTableMetro1.setShowVerticalLines(false);
/*      */ 
/*      */     
/* 2358 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 2359 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 60);
/* 2360 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 60);
/* 2361 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 6, 80);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2366 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/* 2367 */     this.jScrollPane8.setViewportView((Component)this.rSTableMetro1);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreColEliminar) {
/* 2371 */     int cont = this.rSTableMetro1.getRowCount();
/* 2372 */     String[] registros = new String[cont]; int i;
/* 2373 */     for (i = 0; i < cont; i++) {
/* 2374 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 2376 */     for (i = 0; i < cont; i++) {
/* 2377 */       registros[i] = registros[i] + " / " + registros[i];
/* 2378 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 2380 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreColEliminar);
/* 2381 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 2386 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2389 */       setEnabled((table == null || table.isEnabled()));
/* 2390 */       if (column == 0 || column == 1 || column == 6) {
/* 2391 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2393 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 2396 */       if (row % 2 == 0) {
/* 2397 */         setBackground(UnidadesUtilitarios.this.lc.FONDOTABLA);
/*      */       } else {
/* 2399 */         setBackground((Color)null);
/*      */       } 
/* 2401 */       setForeground(UnidadesUtilitarios.this.lc.SECUNDARIO1);
/*      */       
/* 2403 */       if (column == 9 || column == 10 || column == 11 || column == 12 || column == 13 || column == 14 || column == 15) {
/* 2404 */         setForeground(UnidadesUtilitarios.this.lc.PRIMARIO1);
/* 2405 */         setFont(UnidadesUtilitarios.this.fuentes.setFuente(UnidadesUtilitarios.this.fuentes.FCentury, UnidadesUtilitarios.this.fuentes.BOLD, 15.0F));
/*      */       } 
/*      */       
/* 2408 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2409 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender2() {
/* 2415 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2418 */       setEnabled((table == null || table.isEnabled()));
/*      */       
/* 2420 */       if (row % 2 == 0) {
/* 2421 */         setBackground(UnidadesUtilitarios.this.lc.FONDOTABLA);
/*      */       } else {
/* 2423 */         setBackground((Color)null);
/*      */       } 
/* 2425 */       setForeground(UnidadesUtilitarios.this.lc.SECUNDARIO1);
/* 2426 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2427 */       return this;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UnidadesUtilitarios.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */