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
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ 
/*      */ public class UnidadesTractos extends JPanel {
/*   40 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   41 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   42 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   43 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   44 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   45 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   49 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   50 */   Utilerias utilerias = new Utilerias();
/*   51 */   Date fechaActual = new Date();
/*   52 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   53 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   55 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*      */   String id;
/*   58 */   Consultas2 con = new Consultas2();
/*   59 */   Consultas2 con2 = new Consultas2();
/*      */   String[] inf;
/*   61 */   cargarDatos datos = new cargarDatos("GeneradoraAlta");
/*   62 */   String holderEco = "ECONÓMICO";
/*   63 */   String holderSerie = "SERIE";
/*   64 */   String holderPlacas = "PLACAS";
/*   65 */   String holderMarca = "MARCA";
/*   66 */   String holderTipo = "TIPO";
/*   67 */   String holderBuscarM = "BUSCAR...";
/*      */   EscribirReporte esc;
/*      */   boolean encontrado = false;
/*   70 */   Errores error = new Errores(true);
/*   71 */   Validaciones val = new Validaciones();
/*   72 */   Date fecha = null;
/*   73 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   75 */   Map<String, String> MARCAS = new TreeMap<>();
/*   76 */   Map<String, String> TIPOS = new TreeMap<>();
/*   77 */   Map<String, String> ESTADOSBAJA = new TreeMap<>();
/*   78 */   MensajePop mensajeTry = null;
/*   79 */   Fuentes fuentes = new Fuentes();
/*   80 */   PlaceHolder placeHolder = null;
/*   81 */   String[] SUCURSALES = null;
/*   82 */   String[] ESTADOS = null;
/*   83 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean PRIMERA = false;
/*   85 */   Cursor micursor = null;
/*   86 */   CeldaRender1 celda1 = new CeldaRender1();
/*   87 */   CeldaRender2 celda2 = new CeldaRender2();
/*   88 */   Map<String, String> CARPETAS = new TreeMap<>();
/*      */   Map<String, UnidadesTractosDoc> DOCUMENTACION;
/*   90 */   Date fechaInicio = null;
/*   91 */   String TIPOSELEC = "";
/*   92 */   private Map<String, String> CAMPOS = new TreeMap<>();
/*   93 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*   94 */   String TIPOV = "ECO";
/*   95 */   Map<String, String> CLAVECONFIGAUT = new TreeMap<>();
/*   96 */   String ClaveTipoAut = ""; private ButtonGroup buttonGroup1; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton38; private JButton jButton39; private JButton jButton53; private JButton jButton54; private JButton jButton55; private JButton jButton56; private JButton jButton58; private JButton jButton59; private JButton jButton61; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox23; private JComboBox jComboBox24; private JComboBox jComboBox25; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JFormattedTextField jFormattedTextField1; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel2; private JLabel jLabel29;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel34;
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel98;
/*      */   private JLabel jLabel99;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel13;
/*      */   private JPanel jPanel133;
/*      */   private JPanel jPanel136;
/*      */   private JPanel jPanel14;
/*      */   private JPanel jPanel15;
/*      */   private JPanel jPanel16;
/*      */   private JPanel jPanel35;
/*      */   private JPanel jPanel36;
/*      */   private JPanel jPanel37;
/*      */   private JPanel jPanel38;
/*      */   private JPanel jPanel39;
/*      */   private JPanel jPanel40;
/*      */   private JPanel jPanel41;
/*      */   
/*      */   public UnidadesTractos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  125 */     this.PRIVILEGIOS.put("1", "SUPER USUARIO");
/*  126 */     this.PRIVILEGIOS.put("2", "QHSE");
/*  127 */     this.PRIVILEGIOS.put("2", "ADMINISTRADOR");
/*      */     
/*  129 */     this.ESTADOSBAJA.put("1", "BAJA");
/*  130 */     this.ESTADOSBAJA.put("2", "DESMANTELADO");
/*  131 */     this.ESTADOSBAJA.put("3", "ROBADO");
/*  132 */     this.ESTADOSBAJA.put("4", "SINIESTRADO");
/*  133 */     this.ESTADOSBAJA.put("5", "VENDIDO");
/*      */     
/*  135 */     String año = "2010";
/*  136 */     String mes = "03";
/*  137 */     String dia = "01";
/*  138 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  139 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  141 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  142 */     } catch (ParseException ex) {
/*  143 */       ex.printStackTrace();
/*      */     } 
/*  145 */     this.con2.setBaseDatos("sicre2PR");
/*  146 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  147 */     this.mensajeTry = mensajeTry;
/*  148 */     this.padre = padre;
/*  149 */     this.fichas = fichas;
/*  150 */     this.USUARIO = USUARIO;
/*  151 */     this.panel = panelito;
/*  152 */     this.panel.setViewportView(this);
/*  153 */     initComponents();
/*      */     
/*  155 */     this.jFormattedTextField1.setValue(Double.valueOf(10.0D));
/*  156 */     this.jDateChooser1.getDate();
/*  157 */     this.buttonGroup1.add(this.jRadioButton1);
/*  158 */     this.buttonGroup1.add(this.jRadioButton2);
/*  159 */     this.buttonGroup1.add(this.jRadioButton3);
/*  160 */     this.buttonGroup1.add(this.jRadioButton4);
/*  161 */     this.buttonGroup1.add(this.jRadioButton5);
/*  162 */     this.buttonGroup1.add(this.jRadioButton6);
/*  163 */     this.buttonGroup1.add(this.jRadioButton7);
/*  164 */     this.buttonGroup1.add(this.jRadioButton8);
/*  165 */     this.buttonGroup1.add(this.jRadioButton9);
/*      */     
/*  167 */     String[][] carpetas = this.con.buscarDatos("tipo, direccion", "unidadescarpetas", "");
/*  168 */     for (int i = 0; i < carpetas.length; i++) {
/*  169 */       this.CARPETAS.put(carpetas[i][0], carpetas[i][1]);
/*      */     }
/*  171 */     this.utilerias.imprimirMapa(this.CARPETAS);
/*      */     
/*  173 */     colorear();
/*  174 */     this.placeHolder = new PlaceHolder(this.jTextField60, new Color(189, 189, 189), Color.BLACK, this.holderEco, false, "Century Gothic", 11);
/*  175 */     this.placeHolder = new PlaceHolder(this.jTextField61, new Color(189, 189, 189), Color.BLACK, this.holderSerie, false, "Century Gothic", 11);
/*  176 */     this.placeHolder = new PlaceHolder(this.jTextField62, new Color(189, 189, 189), Color.BLACK, this.holderPlacas, false, "Century Gothic", 11);
/*  177 */     this.placeHolder = new PlaceHolder(this.jTextField63, new Color(189, 189, 189), Color.BLACK, this.holderMarca, false, "Century Gothic", 11);
/*  178 */     this.placeHolder = new PlaceHolder(this.jTextField64, new Color(189, 189, 189), Color.BLACK, this.holderTipo, false, "Century Gothic", 11);
/*  179 */     this.placeHolder = new PlaceHolder(this.jTextField17, new Color(189, 189, 189), Color.BLACK, this.holderBuscarM, false, "Century Gothic", 11);
/*      */     
/*  181 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  182 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  183 */     this.rSTableMetro1.setCursor(this.micursor);
/*  184 */     this.rSTableMetro2.setCursor(this.micursor);
/*  185 */     this.rSTableMetro3.setCursor(this.micursor);
/*      */     
/*  187 */     this.utilerias.activarVentanajDialog(this.jDialog1, 1000, 550);
/*  188 */     this.utilerias.activarVentanajDialog(this.jDialog2, 280, 390);
/*  189 */     this.utilerias.activarVentanajDialog(this.jDialog3, 475, 260);
/*  190 */     this.utilerias.activarVentanajDialog(this.jDialog4, 495, 140);
/*      */     
/*  192 */     ingresarCampos();
/*  193 */     llenarComboEstados();
/*  194 */     llenarComboSuc();
/*      */     
/*  196 */     llenarModelo();
/*  197 */     llenarMarca();
/*  198 */     llenarTipo();
/*  199 */     this.jComboBox11.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*  200 */     consultar();
/*  201 */     privilegios();
/*      */   }
/*      */   private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel70; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6;
/*      */   private JRadioButton jRadioButton7;
/*      */   
/*      */   private void initComponents() {
/*  207 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  208 */     this.jPanel16 = new JPanel();
/*  209 */     this.jPanel36 = new JPanel();
/*  210 */     this.jPanel37 = new JPanel();
/*  211 */     this.jLabel2 = new JLabel();
/*  212 */     this.jTextField100 = new JTextField();
/*  213 */     this.jPanel38 = new JPanel();
/*  214 */     this.jLabel3 = new JLabel();
/*  215 */     this.jComboBox20 = new JComboBox();
/*  216 */     this.jPanel39 = new JPanel();
/*  217 */     this.jLabel4 = new JLabel();
/*  218 */     this.jTextField101 = new JTextField();
/*  219 */     this.jPanel41 = new JPanel();
/*  220 */     this.materialButton21 = new MaterialButton();
/*  221 */     this.materialButton22 = new MaterialButton();
/*  222 */     this.jPanel42 = new JPanel();
/*  223 */     this.jPanel43 = new JPanel();
/*  224 */     this.jLabel6 = new JLabel();
/*  225 */     this.jTextField102 = new JTextField();
/*  226 */     this.jPanel44 = new JPanel();
/*  227 */     this.jLabel7 = new JLabel();
/*  228 */     this.jTextField103 = new JTextField();
/*  229 */     this.jPanel45 = new JPanel();
/*  230 */     this.jPanel46 = new JPanel();
/*  231 */     this.jPanel47 = new JPanel();
/*  232 */     this.jLabel29 = new JLabel();
/*  233 */     this.jTextField104 = new JTextField();
/*  234 */     this.jPanel48 = new JPanel();
/*  235 */     this.jLabel101 = new JLabel();
/*  236 */     this.jComboBox21 = new JComboBox();
/*  237 */     this.jPanel49 = new JPanel();
/*  238 */     this.jLabel102 = new JLabel();
/*  239 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  240 */     this.jPanel40 = new JPanel();
/*  241 */     this.jPanel50 = new JPanel();
/*  242 */     this.jLabel5 = new JLabel();
/*  243 */     this.jTextField105 = new JTextField();
/*  244 */     this.jPanel51 = new JPanel();
/*  245 */     this.jLabel103 = new JLabel();
/*  246 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  247 */     this.jPanel52 = new JPanel();
/*  248 */     this.jLabel104 = new JLabel();
/*  249 */     this.jTextField107 = new JTextField();
/*  250 */     this.jPanel53 = new JPanel();
/*  251 */     this.jPanel54 = new JPanel();
/*  252 */     this.jLabel105 = new JLabel();
/*  253 */     this.jTextField108 = new JTextField();
/*  254 */     this.jPanel55 = new JPanel();
/*  255 */     this.jLabel106 = new JLabel();
/*  256 */     this.jPanel57 = new JPanel();
/*  257 */     this.jButton38 = new JButton();
/*  258 */     this.jComboBox22 = new JComboBox();
/*  259 */     this.jPanel56 = new JPanel();
/*  260 */     this.jLabel107 = new JLabel();
/*  261 */     this.jPanel58 = new JPanel();
/*  262 */     this.jButton39 = new JButton();
/*  263 */     this.jComboBox23 = new JComboBox();
/*  264 */     this.jPanel64 = new JPanel();
/*  265 */     this.jPanel67 = new JPanel();
/*  266 */     this.jLabel112 = new JLabel();
/*  267 */     this.jPanel133 = new JPanel();
/*  268 */     this.jTextField85 = new JTextField();
/*  269 */     this.jButton56 = new JButton();
/*  270 */     this.jPanel65 = new JPanel();
/*  271 */     this.jLabel109 = new JLabel();
/*  272 */     this.jComboBox24 = new JComboBox();
/*  273 */     this.jPanel66 = new JPanel();
/*  274 */     this.jLabel110 = new JLabel();
/*  275 */     this.jComboBox25 = new JComboBox();
/*  276 */     this.jPanel59 = new JPanel();
/*  277 */     this.jPanel60 = new JPanel();
/*  278 */     this.jLabel108 = new JLabel();
/*  279 */     this.jLabel111 = new JLabel();
/*  280 */     this.jPanel61 = new JPanel();
/*  281 */     this.jPanel63 = new JPanel();
/*  282 */     this.jScrollPane10 = new JScrollPane();
/*  283 */     this.rSTableMetro2 = new RSTableMetro();
/*  284 */     this.jButton53 = new JButton();
/*  285 */     this.jButton54 = new JButton();
/*  286 */     this.jButton55 = new JButton();
/*  287 */     this.jScrollPane11 = new JScrollPane();
/*  288 */     this.jTextPane1 = new JTextPane();
/*  289 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  290 */     this.jPanel70 = new JPanel();
/*  291 */     this.jRadioButton1 = new JRadioButton();
/*  292 */     this.jRadioButton2 = new JRadioButton();
/*  293 */     this.jRadioButton3 = new JRadioButton();
/*  294 */     this.jRadioButton4 = new JRadioButton();
/*  295 */     this.jRadioButton5 = new JRadioButton();
/*  296 */     this.jRadioButton6 = new JRadioButton();
/*  297 */     this.jRadioButton7 = new JRadioButton();
/*  298 */     this.jRadioButton8 = new JRadioButton();
/*  299 */     this.jRadioButton9 = new JRadioButton();
/*  300 */     this.materialButton39 = new MaterialButton();
/*  301 */     this.materialButton38 = new MaterialButton();
/*  302 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  303 */     this.jPanel136 = new JPanel();
/*  304 */     this.jScrollPane33 = new JScrollPane();
/*  305 */     this.rSTableMetro3 = new RSTableMetro();
/*  306 */     this.jButton58 = new JButton();
/*  307 */     this.jButton59 = new JButton();
/*  308 */     this.jButton61 = new JButton();
/*  309 */     this.jTextField17 = new JTextField();
/*  310 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  311 */     this.jPanel62 = new JPanel();
/*  312 */     this.jLabel34 = new JLabel();
/*  313 */     this.jTextField24 = new JTextField();
/*  314 */     this.materialButton24 = new MaterialButton();
/*  315 */     this.materialButton25 = new MaterialButton();
/*  316 */     this.jPanel1 = new JPanel();
/*  317 */     this.jScrollPane1 = new JScrollPane();
/*  318 */     this.jTable1 = new JTable();
/*  319 */     this.jLabel8 = new JLabel();
/*  320 */     this.jTextField106 = new JTextField();
/*  321 */     this.buttonGroup1 = new ButtonGroup();
/*  322 */     this.jPanel9 = new JPanel();
/*  323 */     this.jPanel10 = new JPanel();
/*  324 */     this.jLabel98 = new JLabel();
/*  325 */     this.jPanel35 = new JPanel();
/*  326 */     this.jTextField60 = new JTextField();
/*  327 */     this.jTextField61 = new JTextField();
/*  328 */     this.jTextField62 = new JTextField();
/*  329 */     this.jTextField63 = new JTextField();
/*  330 */     this.jTextField64 = new JTextField();
/*  331 */     this.jComboBox9 = new JComboBox();
/*  332 */     this.jComboBox10 = new JComboBox();
/*  333 */     this.jComboBox11 = new JComboBox();
/*  334 */     this.jPanel11 = new JPanel();
/*  335 */     this.jPanel12 = new JPanel();
/*  336 */     this.jPanel15 = new JPanel();
/*  337 */     this.jLabel99 = new JLabel();
/*  338 */     this.jLabel100 = new JLabel();
/*  339 */     this.jPanel14 = new JPanel();
/*  340 */     this.jButton35 = new JButton();
/*  341 */     this.jButton36 = new JButton();
/*  342 */     this.jButton37 = new JButton();
/*  343 */     this.jButton34 = new JButton();
/*  344 */     this.jButton33 = new JButton();
/*  345 */     this.jScrollPane9 = new JScrollPane();
/*  346 */     this.jPanel13 = new JPanel();
/*  347 */     this.jScrollPane8 = new JScrollPane();
/*  348 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  350 */     this.jDialog1.setTitle("Tractos");
/*  351 */     this.jDialog1.setModal(true);
/*  352 */     this.jDialog1.setResizable(false);
/*      */     
/*  354 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/*      */     
/*  356 */     this.jPanel36.setBackground(new Color(255, 255, 255));
/*  357 */     this.jPanel36.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  359 */     this.jPanel37.setBackground(new Color(255, 255, 255));
/*  360 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  362 */     this.jLabel2.setHorizontalAlignment(4);
/*  363 */     this.jLabel2.setText("Económico");
/*  364 */     this.jPanel37.add(this.jLabel2);
/*      */     
/*  366 */     this.jTextField100.setText("jTextField100");
/*  367 */     this.jPanel37.add(this.jTextField100);
/*      */     
/*  369 */     this.jPanel36.add(this.jPanel37);
/*      */     
/*  371 */     this.jPanel38.setBackground(new Color(255, 255, 255));
/*  372 */     this.jPanel38.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  374 */     this.jLabel3.setHorizontalAlignment(4);
/*  375 */     this.jLabel3.setText("Modelo");
/*  376 */     this.jPanel38.add(this.jLabel3);
/*      */     
/*  378 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  379 */     this.jPanel38.add(this.jComboBox20);
/*      */     
/*  381 */     this.jPanel36.add(this.jPanel38);
/*      */     
/*  383 */     this.jPanel39.setBackground(new Color(255, 255, 255));
/*  384 */     this.jPanel39.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  386 */     this.jLabel4.setHorizontalAlignment(4);
/*  387 */     this.jLabel4.setText("Serie");
/*  388 */     this.jPanel39.add(this.jLabel4);
/*      */     
/*  390 */     this.jTextField101.setText("jTextField101");
/*  391 */     this.jPanel39.add(this.jTextField101);
/*      */     
/*  393 */     this.jPanel36.add(this.jPanel39);
/*      */     
/*  395 */     this.jPanel41.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  397 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  398 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  399 */     this.materialButton21.setMnemonic('C');
/*  400 */     this.materialButton21.setText("Cerrar");
/*  401 */     this.materialButton21.setToolTipText("Cerrar (Al t + C)");
/*  402 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  403 */     this.materialButton21.setHorizontalTextPosition(0);
/*  404 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  406 */             UnidadesTractos.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  410 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  411 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  412 */     this.materialButton22.setMnemonic('A');
/*  413 */     this.materialButton22.setText("Guardar");
/*  414 */     this.materialButton22.setToolTipText("Guardar (Alt+G)");
/*  415 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  416 */     this.materialButton22.setHorizontalTextPosition(0);
/*  417 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  419 */             UnidadesTractos.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  423 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/*  424 */     this.jPanel41.setLayout(jPanel41Layout);
/*  425 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/*  426 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  427 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  428 */           .addContainerGap(-1, 32767)
/*  429 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  430 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  431 */           .addComponent((Component)this.materialButton21, -2, 105, -2)));
/*      */     
/*  433 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/*  434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  435 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  436 */           .addGap(0, 0, 32767)
/*  437 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  438 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  439 */             .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*      */ 
/*      */     
/*  442 */     this.jPanel42.setBackground(new Color(255, 255, 255));
/*  443 */     this.jPanel42.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  445 */     this.jPanel43.setBackground(new Color(255, 255, 255));
/*  446 */     this.jPanel43.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  448 */     this.jLabel6.setHorizontalAlignment(4);
/*  449 */     this.jLabel6.setText("Placas");
/*  450 */     this.jPanel43.add(this.jLabel6);
/*      */     
/*  452 */     this.jTextField102.setText("jTextField102");
/*  453 */     this.jPanel43.add(this.jTextField102);
/*      */     
/*  455 */     this.jPanel42.add(this.jPanel43);
/*      */     
/*  457 */     this.jPanel44.setBackground(new Color(255, 255, 255));
/*  458 */     this.jPanel44.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  460 */     this.jLabel7.setHorizontalAlignment(4);
/*  461 */     this.jLabel7.setText("Motor");
/*  462 */     this.jPanel44.add(this.jLabel7);
/*      */     
/*  464 */     this.jTextField103.setText("jTextField103");
/*  465 */     this.jPanel44.add(this.jTextField103);
/*      */     
/*  467 */     this.jPanel42.add(this.jPanel44);
/*      */     
/*  469 */     this.jPanel45.setBackground(new Color(255, 255, 255));
/*  470 */     this.jPanel45.setLayout(new GridLayout(1, 2, 6, 0));
/*  471 */     this.jPanel42.add(this.jPanel45);
/*      */     
/*  473 */     this.jPanel46.setBackground(new Color(255, 255, 255));
/*  474 */     this.jPanel46.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  476 */     this.jPanel47.setBackground(new Color(255, 255, 255));
/*  477 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  479 */     this.jLabel29.setHorizontalAlignment(4);
/*  480 */     this.jLabel29.setText("Factura");
/*  481 */     this.jPanel47.add(this.jLabel29);
/*      */     
/*  483 */     this.jTextField104.setText("jTextField104");
/*  484 */     this.jPanel47.add(this.jTextField104);
/*      */     
/*  486 */     this.jPanel46.add(this.jPanel47);
/*      */     
/*  488 */     this.jPanel48.setBackground(new Color(255, 255, 255));
/*  489 */     this.jPanel48.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  491 */     this.jLabel101.setHorizontalAlignment(4);
/*  492 */     this.jLabel101.setText("Forma de Pago");
/*  493 */     this.jPanel48.add(this.jLabel101);
/*      */     
/*  495 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  496 */     this.jComboBox21.setEditable(true);
/*  497 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "EFECTIVO", "OTRO" }));
/*  498 */     this.jPanel48.add(this.jComboBox21);
/*      */     
/*  500 */     this.jPanel46.add(this.jPanel48);
/*      */     
/*  502 */     this.jPanel49.setBackground(new Color(255, 255, 255));
/*  503 */     this.jPanel49.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  505 */     this.jLabel102.setHorizontalAlignment(4);
/*  506 */     this.jLabel102.setText("Fecha de Compra");
/*  507 */     this.jPanel49.add(this.jLabel102);
/*      */     
/*  509 */     this.jDateChooser1.setDate(this.fechaActual);
/*  510 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/*  511 */     this.jDateChooser1.setIcon(this.icon);
/*  512 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/*  513 */     this.jPanel49.add((Component)this.jDateChooser1);
/*      */     
/*  515 */     this.jPanel46.add(this.jPanel49);
/*      */     
/*  517 */     this.jPanel40.setBackground(new Color(255, 255, 255));
/*  518 */     this.jPanel40.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  520 */     this.jPanel50.setBackground(new Color(255, 255, 255));
/*  521 */     this.jPanel50.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  523 */     this.jLabel5.setHorizontalAlignment(4);
/*  524 */     this.jLabel5.setText("Color");
/*  525 */     this.jPanel50.add(this.jLabel5);
/*      */     
/*  527 */     this.jTextField105.setText("jTextField105");
/*  528 */     this.jPanel50.add(this.jTextField105);
/*      */     
/*  530 */     this.jPanel40.add(this.jPanel50);
/*      */     
/*  532 */     this.jPanel51.setBackground(new Color(255, 255, 255));
/*  533 */     this.jPanel51.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  535 */     this.jLabel103.setHorizontalAlignment(4);
/*  536 */     this.jLabel103.setText("Peso Bruto");
/*  537 */     this.jPanel51.add(this.jLabel103);
/*      */     
/*  539 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.##"))));
/*  540 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  541 */     this.jPanel51.add(this.jFormattedTextField1);
/*      */     
/*  543 */     this.jPanel40.add(this.jPanel51);
/*      */     
/*  545 */     this.jPanel52.setBackground(new Color(255, 255, 255));
/*  546 */     this.jPanel52.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  548 */     this.jLabel104.setHorizontalAlignment(4);
/*  549 */     this.jLabel104.setText("Dimensión");
/*  550 */     this.jPanel52.add(this.jLabel104);
/*      */     
/*  552 */     this.jTextField107.setText("jTextField107");
/*  553 */     this.jPanel52.add(this.jTextField107);
/*      */     
/*  555 */     this.jPanel40.add(this.jPanel52);
/*      */     
/*  557 */     this.jPanel53.setBackground(new Color(255, 255, 255));
/*  558 */     this.jPanel53.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  560 */     this.jPanel54.setBackground(new Color(255, 255, 255));
/*  561 */     this.jPanel54.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  563 */     this.jLabel105.setHorizontalAlignment(4);
/*  564 */     this.jLabel105.setText("Km Actual");
/*  565 */     this.jPanel54.add(this.jLabel105);
/*      */     
/*  567 */     this.jTextField108.setHorizontalAlignment(4);
/*  568 */     this.jTextField108.setText("jTextField108");
/*  569 */     this.jPanel54.add(this.jTextField108);
/*      */     
/*  571 */     this.jPanel53.add(this.jPanel54);
/*      */     
/*  573 */     this.jPanel55.setBackground(new Color(255, 255, 255));
/*  574 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  576 */     this.jLabel106.setHorizontalAlignment(4);
/*  577 */     this.jLabel106.setText("Marca");
/*  578 */     this.jPanel55.add(this.jLabel106);
/*      */     
/*  580 */     this.jPanel57.setBackground(new Color(255, 255, 255));
/*      */     
/*  582 */     this.jButton38.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  583 */     this.jButton38.setMnemonic('F');
/*  584 */     this.jButton38.setToolTipText("Filtrar información (Alt+F)");
/*  585 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  587 */             UnidadesTractos.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  591 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/*      */     
/*  593 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  594 */     this.jPanel57.setLayout(jPanel57Layout);
/*  595 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  596 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  597 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  598 */           .addComponent(this.jComboBox22, 0, 68, 32767)
/*  599 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  600 */           .addComponent(this.jButton38, -2, 20, -2)
/*  601 */           .addGap(0, 0, 0)));
/*      */     
/*  603 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  604 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  605 */         .addComponent(this.jButton38, -2, 24, -2)
/*  606 */         .addComponent(this.jComboBox22, GroupLayout.Alignment.TRAILING, -2, 25, -2));
/*      */ 
/*      */     
/*  609 */     this.jPanel55.add(this.jPanel57);
/*      */     
/*  611 */     this.jPanel53.add(this.jPanel55);
/*      */     
/*  613 */     this.jPanel56.setBackground(new Color(255, 255, 255));
/*  614 */     this.jPanel56.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  616 */     this.jLabel107.setHorizontalAlignment(4);
/*  617 */     this.jLabel107.setText("Tipo o Submarca");
/*  618 */     this.jPanel56.add(this.jLabel107);
/*      */     
/*  620 */     this.jPanel58.setBackground(new Color(255, 255, 255));
/*      */     
/*  622 */     this.jButton39.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  623 */     this.jButton39.setMnemonic('F');
/*  624 */     this.jButton39.setToolTipText("Filtrar información (Alt+F)");
/*  625 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  627 */             UnidadesTractos.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  631 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/*      */     
/*  633 */     GroupLayout jPanel58Layout = new GroupLayout(this.jPanel58);
/*  634 */     this.jPanel58.setLayout(jPanel58Layout);
/*  635 */     jPanel58Layout.setHorizontalGroup(jPanel58Layout
/*  636 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  637 */         .addGroup(jPanel58Layout.createSequentialGroup()
/*  638 */           .addComponent(this.jComboBox23, 0, 68, 32767)
/*  639 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  640 */           .addComponent(this.jButton39, -2, 20, -2)
/*  641 */           .addGap(0, 0, 0)));
/*      */     
/*  643 */     jPanel58Layout.setVerticalGroup(jPanel58Layout
/*  644 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  645 */         .addComponent(this.jButton39, -2, 24, -2)
/*  646 */         .addComponent(this.jComboBox23, GroupLayout.Alignment.TRAILING, -2, 25, -2));
/*      */ 
/*      */     
/*  649 */     this.jPanel56.add(this.jPanel58);
/*      */     
/*  651 */     this.jPanel53.add(this.jPanel56);
/*      */     
/*  653 */     this.jPanel64.setBackground(new Color(255, 255, 255));
/*  654 */     this.jPanel64.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  656 */     this.jPanel67.setBackground(new Color(255, 255, 255));
/*  657 */     this.jPanel67.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  659 */     this.jLabel112.setHorizontalAlignment(4);
/*  660 */     this.jLabel112.setText("Tipo de unidad");
/*  661 */     this.jPanel67.add(this.jLabel112);
/*      */     
/*  663 */     this.jPanel133.setBackground(new Color(255, 255, 255));
/*      */     
/*  665 */     this.jTextField85.setEditable(false);
/*      */     
/*  667 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  668 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  670 */             UnidadesTractos.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  674 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/*  675 */     this.jPanel133.setLayout(jPanel133Layout);
/*  676 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/*  677 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  678 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  679 */           .addComponent(this.jTextField85, -1, 70, 32767)
/*  680 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  681 */           .addComponent(this.jButton56, -2, 18, -2)));
/*      */     
/*  683 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/*  684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */         .addComponent(this.jTextField85)
/*  686 */         .addComponent(this.jButton56, -2, 0, 32767));
/*      */ 
/*      */     
/*  689 */     this.jPanel67.add(this.jPanel133);
/*      */     
/*  691 */     this.jPanel64.add(this.jPanel67);
/*      */     
/*  693 */     this.jPanel65.setBackground(new Color(255, 255, 255));
/*  694 */     this.jPanel65.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  696 */     this.jLabel109.setHorizontalAlignment(4);
/*  697 */     this.jLabel109.setText("Estado");
/*  698 */     this.jPanel65.add(this.jLabel109);
/*      */     
/*  700 */     this.jComboBox24.setBackground(new Color(244, 244, 244));
/*  701 */     this.jComboBox24.setEditable(true);
/*  702 */     this.jComboBox24.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "BAJA", "DESMANTELADO", "PLAN DE PISO", "ROBADO", "SINIESTRADO", "VENDIDO", "OTRO" }));
/*  703 */     this.jPanel65.add(this.jComboBox24);
/*      */     
/*  705 */     this.jPanel64.add(this.jPanel65);
/*      */     
/*  707 */     this.jPanel66.setBackground(new Color(255, 255, 255));
/*  708 */     this.jPanel66.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  710 */     this.jLabel110.setHorizontalAlignment(4);
/*  711 */     this.jLabel110.setText("Sucursal");
/*  712 */     this.jPanel66.add(this.jLabel110);
/*      */     
/*  714 */     this.jComboBox25.setBackground(new Color(244, 244, 244));
/*  715 */     this.jComboBox25.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "OTRO" }));
/*  716 */     this.jPanel66.add(this.jComboBox25);
/*      */     
/*  718 */     this.jPanel64.add(this.jPanel66);
/*      */     
/*  720 */     this.jPanel59.setBackground(new Color(255, 255, 255));
/*      */     
/*  722 */     this.jPanel60.setBackground(this.lc.SECUNDARIO1);
/*  723 */     this.jPanel60.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/*  725 */     this.jLabel108.setFont(new Font("Quicksand", 1, 13));
/*  726 */     this.jLabel108.setForeground(new Color(255, 255, 255));
/*  727 */     this.jLabel108.setHorizontalAlignment(0);
/*  728 */     this.jLabel108.setText(" Sección de Permisos, Seguro y Documentación");
/*  729 */     this.jPanel60.add(this.jLabel108);
/*      */     
/*  731 */     this.jLabel111.setFont(new Font("Quicksand", 1, 13));
/*  732 */     this.jLabel111.setForeground(new Color(255, 255, 255));
/*  733 */     this.jLabel111.setHorizontalAlignment(0);
/*  734 */     this.jLabel111.setText("Comentarios");
/*  735 */     this.jPanel60.add(this.jLabel111);
/*      */     
/*  737 */     this.jPanel61.setBackground(new Color(255, 255, 255));
/*  738 */     this.jPanel61.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/*  740 */     this.jPanel63.setBackground(new Color(255, 255, 255));
/*      */     
/*  742 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  750 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  755 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  758 */     this.rSTableMetro2.setAltoHead(25);
/*  759 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  760 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  761 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  762 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  763 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  764 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  765 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  766 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  767 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  768 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  769 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  770 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  771 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  772 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  773 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  775 */             UnidadesTractos.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  778 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  780 */             UnidadesTractos.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  783 */     this.jScrollPane10.setViewportView((Component)this.rSTableMetro2);
/*      */     
/*  785 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  786 */     this.jButton53.setToolTipText("Nuevo");
/*  787 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  789 */             UnidadesTractos.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  793 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  794 */     this.jButton54.setToolTipText("Modificar");
/*  795 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  797 */             UnidadesTractos.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  801 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  802 */     this.jButton55.setToolTipText("Eliminar");
/*  803 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  805 */             UnidadesTractos.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  809 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/*  810 */     this.jPanel63.setLayout(jPanel63Layout);
/*  811 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/*  812 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  813 */         .addComponent(this.jScrollPane10, -2, 0, 32767)
/*  814 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  815 */           .addGap(0, 213, 32767)
/*  816 */           .addComponent(this.jButton53)
/*  817 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  818 */           .addComponent(this.jButton54)
/*  819 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  820 */           .addComponent(this.jButton55)));
/*      */     
/*  822 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/*  823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  824 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  825 */           .addComponent(this.jScrollPane10, -1, 221, 32767)
/*  826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  827 */           .addGroup(jPanel63Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  828 */             .addComponent(this.jButton53, -2, 26, -2)
/*  829 */             .addComponent(this.jButton54, -2, 26, -2)
/*  830 */             .addComponent(this.jButton55, -2, 26, -2))));
/*      */ 
/*      */     
/*  833 */     this.jPanel61.add(this.jPanel63);
/*      */     
/*  835 */     this.jScrollPane11.setViewportView(this.jTextPane1);
/*      */     
/*  837 */     this.jPanel61.add(this.jScrollPane11);
/*      */     
/*  839 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/*  840 */     this.jPanel59.setLayout(jPanel59Layout);
/*  841 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/*  842 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  843 */         .addComponent(this.jPanel60, -1, -1, 32767)
/*  844 */         .addComponent(this.jPanel61, -2, 0, 32767));
/*      */     
/*  846 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/*  847 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  848 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  849 */           .addComponent(this.jPanel60, -2, -1, -2)
/*  850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  851 */           .addComponent(this.jPanel61, -1, -1, 32767)));
/*      */ 
/*      */     
/*  854 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/*  855 */     this.jPanel16.setLayout(jPanel16Layout);
/*  856 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/*  857 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  858 */         .addComponent(this.jPanel36, -1, -1, 32767)
/*  859 */         .addComponent(this.jPanel42, -2, 0, 32767)
/*  860 */         .addComponent(this.jPanel46, -2, 0, 32767)
/*  861 */         .addComponent(this.jPanel40, -1, -1, 32767)
/*  862 */         .addComponent(this.jPanel53, -1, -1, 32767)
/*  863 */         .addComponent(this.jPanel64, -2, 0, 32767)
/*  864 */         .addComponent(this.jPanel41, -1, -1, 32767)
/*  865 */         .addComponent(this.jPanel59, -1, -1, 32767));
/*      */     
/*  867 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/*  868 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  869 */         .addGroup(jPanel16Layout.createSequentialGroup()
/*  870 */           .addComponent(this.jPanel36, -2, -1, -2)
/*  871 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  872 */           .addComponent(this.jPanel42, -2, -1, -2)
/*  873 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  874 */           .addComponent(this.jPanel46, -2, 24, -2)
/*  875 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  876 */           .addComponent(this.jPanel40, -2, -1, -2)
/*  877 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  878 */           .addComponent(this.jPanel53, -2, 26, -2)
/*  879 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  880 */           .addComponent(this.jPanel64, -2, 25, -2)
/*  881 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  882 */           .addComponent(this.jPanel59, -1, -1, 32767)
/*  883 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  884 */           .addComponent(this.jPanel41, -2, -1, -2)));
/*      */ 
/*      */     
/*  887 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  888 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  889 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  890 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  891 */         .addComponent(this.jPanel16, -1, -1, 32767));
/*      */     
/*  893 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  894 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  895 */         .addComponent(this.jPanel16, -2, -1, -2));
/*      */ 
/*      */     
/*  898 */     this.jDialog2.setTitle("Tipo de documento");
/*  899 */     this.jDialog2.setModal(true);
/*      */     
/*  901 */     this.jPanel70.setLayout(new GridLayout(10, 0, 0, 2));
/*      */     
/*  903 */     this.jRadioButton1.setSelected(true);
/*  904 */     this.jRadioButton1.setText("Tarjetas de Circulación");
/*  905 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  907 */             UnidadesTractos.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  910 */     this.jPanel70.add(this.jRadioButton1);
/*      */     
/*  912 */     this.jRadioButton2.setText("Póliza de Seguro");
/*  913 */     this.jPanel70.add(this.jRadioButton2);
/*      */     
/*  915 */     this.jRadioButton3.setText("Sedema");
/*  916 */     this.jPanel70.add(this.jRadioButton3);
/*      */     
/*  918 */     this.jRadioButton4.setText("Nom 012");
/*  919 */     this.jPanel70.add(this.jRadioButton4);
/*      */     
/*  921 */     this.jRadioButton5.setText("Verificación");
/*  922 */     this.jPanel70.add(this.jRadioButton5);
/*      */     
/*  924 */     this.jRadioButton6.setText("Fisicomecánica");
/*  925 */     this.jPanel70.add(this.jRadioButton6);
/*      */     
/*  927 */     this.jRadioButton7.setText("Sct");
/*  928 */     this.jPanel70.add(this.jRadioButton7);
/*      */     
/*  930 */     this.jRadioButton8.setText("Pago");
/*  931 */     this.jPanel70.add(this.jRadioButton8);
/*      */     
/*  933 */     this.jRadioButton9.setText("Otro");
/*  934 */     this.jPanel70.add(this.jRadioButton9);
/*      */     
/*  936 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/*  937 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/*  938 */     this.materialButton39.setMnemonic('S');
/*  939 */     this.materialButton39.setText("Siguiente >>");
/*  940 */     this.materialButton39.setToolTipText("Siguiente (Alt+S)");
/*  941 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/*  942 */     this.materialButton39.setHorizontalTextPosition(0);
/*  943 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  945 */             UnidadesTractos.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  949 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  950 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  951 */     this.materialButton38.setMnemonic('C');
/*  952 */     this.materialButton38.setText("Cerrar");
/*  953 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/*  954 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/*  955 */     this.materialButton38.setHorizontalTextPosition(0);
/*  956 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  958 */             UnidadesTractos.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  962 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  963 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  964 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  965 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  966 */         .addComponent(this.jPanel70, -1, -1, 32767)
/*  967 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  968 */           .addGap(0, 0, 32767)
/*  969 */           .addComponent((Component)this.materialButton39, -2, 150, -2)
/*  970 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  971 */           .addComponent((Component)this.materialButton38, -2, 105, -2)));
/*      */     
/*  973 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  974 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  975 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  976 */           .addComponent(this.jPanel70, -1, -1, 32767)
/*  977 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  978 */           .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  979 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/*  980 */             .addComponent((Component)this.materialButton39, -2, 38, -2))
/*  981 */           .addContainerGap()));
/*      */ 
/*      */     
/*  984 */     this.jDialog3.setTitle("Marcas");
/*  985 */     this.jDialog3.setUndecorated(true);
/*      */     
/*  987 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  995 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1000 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1003 */     this.rSTableMetro3.setAltoHead(25);
/* 1004 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1005 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1006 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1007 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1008 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1009 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1010 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1011 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1012 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1013 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1014 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1015 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1016 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1017 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1018 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1020 */             UnidadesTractos.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1023 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1025 */             UnidadesTractos.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1028 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/*      */     
/* 1030 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1031 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1033 */             UnidadesTractos.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1037 */     this.jButton59.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1038 */     this.jButton59.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1040 */             UnidadesTractos.this.jButton59ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1044 */     this.jButton61.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/* 1045 */     this.jButton61.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1047 */             UnidadesTractos.this.jButton61ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1051 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1053 */             UnidadesTractos.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1056 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1058 */             UnidadesTractos.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1062 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 1063 */     this.jPanel136.setLayout(jPanel136Layout);
/* 1064 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 1065 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1066 */         .addComponent(this.jScrollPane33, -1, 418, 32767)
/* 1067 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/* 1068 */           .addContainerGap()
/* 1069 */           .addComponent(this.jTextField17, -2, 179, -2)
/* 1070 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1071 */           .addComponent(this.jButton58)
/* 1072 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1073 */           .addComponent(this.jButton59)
/* 1074 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1075 */           .addComponent(this.jButton61)
/* 1076 */           .addContainerGap()));
/*      */     
/* 1078 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 1079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1080 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1081 */           .addComponent(this.jScrollPane33, -1, 172, 32767)
/* 1082 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1083 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1084 */             .addComponent(this.jButton58, -2, 26, -2)
/* 1085 */             .addComponent(this.jButton59, -2, 26, -2)
/* 1086 */             .addComponent(this.jButton61, -2, 26, -2)
/* 1087 */             .addComponent(this.jTextField17, -2, -1, -2))));
/*      */ 
/*      */     
/* 1090 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1091 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1092 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1093 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1094 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
/* 1095 */           .addGap(0, 0, 0)
/* 1096 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/*      */     
/* 1098 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1099 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1100 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1101 */           .addComponent(this.jPanel136, -1, -1, 32767)
/* 1102 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1105 */     this.jDialog4.setTitle("Marcas");
/* 1106 */     this.jDialog4.setModal(true);
/*      */     
/* 1108 */     this.jLabel34.setText("Ingresa el nombre de la marca");
/*      */     
/* 1110 */     this.jTextField24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1112 */             UnidadesTractos.this.jTextField24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1116 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/* 1117 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 1118 */     this.materialButton24.setMnemonic('C');
/* 1119 */     this.materialButton24.setText("Cerrar");
/* 1120 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/* 1121 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 1122 */     this.materialButton24.setHorizontalTextPosition(0);
/* 1123 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1125 */             UnidadesTractos.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1129 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/* 1130 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/* 1131 */     this.materialButton25.setMnemonic('G');
/* 1132 */     this.materialButton25.setText("Guardar");
/* 1133 */     this.materialButton25.setToolTipText("Guardar (Alt +G)");
/* 1134 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/* 1135 */     this.materialButton25.setHorizontalTextPosition(0);
/* 1136 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1138 */             UnidadesTractos.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1142 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/* 1143 */     this.jPanel62.setLayout(jPanel62Layout);
/* 1144 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/* 1145 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1146 */         .addGroup(jPanel62Layout.createSequentialGroup()
/* 1147 */           .addContainerGap()
/* 1148 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1149 */             .addComponent(this.jTextField24)
/* 1150 */             .addComponent(this.jLabel34, -1, 455, 32767)
/* 1151 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/* 1152 */               .addGap(0, 0, 32767)
/* 1153 */               .addComponent((Component)this.materialButton25, -2, 150, -2)
/* 1154 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1155 */               .addComponent((Component)this.materialButton24, -2, 105, -2)))
/* 1156 */           .addContainerGap()));
/*      */     
/* 1158 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/* 1159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1160 */         .addGroup(jPanel62Layout.createSequentialGroup()
/* 1161 */           .addComponent(this.jLabel34, -2, 26, -2)
/* 1162 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1163 */           .addComponent(this.jTextField24, -2, -1, -2)
/* 1164 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1165 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1166 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/* 1167 */             .addComponent((Component)this.materialButton25, -2, 38, -2))
/* 1168 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1171 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1172 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1173 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1174 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1175 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1176 */           .addComponent(this.jPanel62, -2, -1, -2)
/* 1177 */           .addGap(0, 0, 32767)));
/*      */     
/* 1179 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1181 */         .addComponent(this.jPanel62, -1, -1, 32767));
/*      */ 
/*      */     
/* 1184 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1195 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 1197 */     this.jLabel8.setHorizontalAlignment(4);
/* 1198 */     this.jLabel8.setText("<html><u>Peso Bruto</u></html>");
/* 1199 */     this.jLabel8.setToolTipText("Peso en Toneladas, mínimo 1, máximo 100");
/*      */     
/* 1201 */     this.jTextField106.setHorizontalAlignment(4);
/* 1202 */     this.jTextField106.setText("jTextField106");
/*      */     
/* 1204 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1205 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1206 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1208 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1209 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1210 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1211 */               .addContainerGap()
/* 1212 */               .addComponent(this.jScrollPane1, -2, -1, -2))
/* 1213 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1214 */               .addGap(55, 55, 55)
/* 1215 */               .addComponent(this.jLabel8, -2, -1, -2))
/* 1216 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1217 */               .addGap(200, 200, 200)
/* 1218 */               .addComponent(this.jTextField106, -2, -1, -2)))
/* 1219 */           .addContainerGap(52, 32767)));
/*      */     
/* 1221 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1223 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1224 */           .addContainerGap()
/* 1225 */           .addComponent(this.jScrollPane1, -2, 151, -2)
/* 1226 */           .addGap(57, 57, 57)
/* 1227 */           .addComponent(this.jLabel8, -2, -1, -2)
/* 1228 */           .addGap(18, 18, 18)
/* 1229 */           .addComponent(this.jTextField106, -2, -1, -2)
/* 1230 */           .addContainerGap(441, 32767)));
/*      */ 
/*      */     
/* 1233 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1235 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1237 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 1238 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/* 1239 */     this.jLabel98.setHorizontalAlignment(0);
/* 1240 */     this.jLabel98.setText("Unidades");
/*      */     
/* 1242 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1243 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1244 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1245 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1246 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*      */     
/* 1248 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1249 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1250 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1251 */           .addContainerGap()
/* 1252 */           .addComponent(this.jLabel98)
/* 1253 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1256 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 1257 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1259 */     this.jTextField60.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1261 */             UnidadesTractos.this.jTextField60KeyReleased(evt);
/*      */           }
/*      */         });
/* 1264 */     this.jPanel35.add(this.jTextField60);
/*      */     
/* 1266 */     this.jTextField61.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1268 */             UnidadesTractos.this.jTextField61KeyReleased(evt);
/*      */           }
/*      */         });
/* 1271 */     this.jPanel35.add(this.jTextField61);
/*      */     
/* 1273 */     this.jTextField62.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1275 */             UnidadesTractos.this.jTextField62KeyReleased(evt);
/*      */           }
/*      */         });
/* 1278 */     this.jPanel35.add(this.jTextField62);
/*      */     
/* 1280 */     this.jTextField63.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1282 */             UnidadesTractos.this.jTextField63ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1285 */     this.jTextField63.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1287 */             UnidadesTractos.this.jTextField63KeyReleased(evt);
/*      */           }
/*      */         });
/* 1290 */     this.jPanel35.add(this.jTextField63);
/*      */     
/* 1292 */     this.jTextField64.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1294 */             UnidadesTractos.this.jTextField64KeyReleased(evt);
/*      */           }
/*      */         });
/* 1297 */     this.jPanel35.add(this.jTextField64);
/*      */     
/* 1299 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1300 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "MODELO" }));
/* 1301 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1303 */             UnidadesTractos.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1306 */     this.jPanel35.add(this.jComboBox9);
/*      */     
/* 1308 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 1309 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 1310 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1312 */             UnidadesTractos.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1315 */     this.jPanel35.add(this.jComboBox10);
/*      */     
/* 1317 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 1318 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL" }));
/* 1319 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1321 */             UnidadesTractos.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1324 */     this.jPanel35.add(this.jComboBox11);
/*      */     
/* 1326 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1328 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 1329 */     this.jPanel12.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1331 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 1332 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1334 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1335 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 1336 */     this.jLabel99.setHorizontalAlignment(4);
/* 1337 */     this.jLabel99.setText("Total");
/* 1338 */     this.jPanel15.add(this.jLabel99);
/*      */     
/* 1340 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1341 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 1342 */     this.jLabel100.setHorizontalAlignment(2);
/* 1343 */     this.jLabel100.setText("t");
/* 1344 */     this.jPanel15.add(this.jLabel100);
/*      */     
/* 1346 */     this.jPanel12.add(this.jPanel15);
/*      */     
/* 1348 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1350 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1351 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1352 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1353 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1354 */         .addGap(0, 80, 32767));
/*      */     
/* 1356 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1358 */         .addGap(0, 37, 32767));
/*      */ 
/*      */     
/* 1361 */     this.jPanel12.add(this.jPanel14);
/*      */     
/* 1363 */     this.jButton35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1364 */     this.jButton35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1365 */     this.jButton35.setMnemonic('N');
/* 1366 */     this.jButton35.setText("Nuevo");
/* 1367 */     this.jButton35.setToolTipText("Nuevo Reseteo (Alt + N)");
/* 1368 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1370 */             UnidadesTractos.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1373 */     this.jPanel12.add(this.jButton35);
/*      */     
/* 1375 */     this.jButton36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1376 */     this.jButton36.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1377 */     this.jButton36.setMnemonic('M');
/* 1378 */     this.jButton36.setText("Modificar");
/* 1379 */     this.jButton36.setToolTipText("Modificar (Alt + M)");
/* 1380 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1382 */             UnidadesTractos.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1385 */     this.jPanel12.add(this.jButton36);
/*      */     
/* 1387 */     this.jButton37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1388 */     this.jButton37.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1389 */     this.jButton37.setMnemonic('E');
/* 1390 */     this.jButton37.setText("Eliminar");
/* 1391 */     this.jButton37.setToolTipText("Eliminar (Alt+E)");
/* 1392 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1394 */             UnidadesTractos.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1397 */     this.jPanel12.add(this.jButton37);
/*      */     
/* 1399 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1400 */     this.jButton34.setMnemonic('I');
/* 1401 */     this.jButton34.setText("Imprimir");
/* 1402 */     this.jButton34.setToolTipText("Imprimir Reporte (Alt+I)");
/* 1403 */     this.jButton34.setEnabled(false);
/* 1404 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1406 */             UnidadesTractos.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1409 */     this.jPanel12.add(this.jButton34);
/*      */     
/* 1411 */     this.jButton33.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1412 */     this.jButton33.setMnemonic('G');
/* 1413 */     this.jButton33.setText("Guardar Reporte");
/* 1414 */     this.jButton33.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1415 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1417 */             UnidadesTractos.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1420 */     this.jPanel12.add(this.jButton33);
/*      */     
/* 1422 */     this.jScrollPane8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1424 */             UnidadesTractos.this.jScrollPane8MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1428 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1436 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1441 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1444 */     this.rSTableMetro1.setAltoHead(40);
/* 1445 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1446 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1447 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1448 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1449 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1450 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1451 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1452 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1453 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1454 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1455 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1456 */     this.rSTableMetro1.setRowHeight(18);
/* 1457 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1458 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1459 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1460 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1462 */             UnidadesTractos.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1465 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1467 */             UnidadesTractos.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1470 */     this.jScrollPane8.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1472 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1473 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1474 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1475 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1476 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1477 */           .addComponent(this.jScrollPane8, -2, 2032, -2)
/* 1478 */           .addGap(0, 0, 32767)));
/*      */     
/* 1480 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1481 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1482 */         .addComponent(this.jScrollPane8, -1, 168, 32767));
/*      */ 
/*      */     
/* 1485 */     this.jScrollPane9.setViewportView(this.jPanel13);
/*      */     
/* 1487 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1488 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1489 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1490 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1491 */         .addComponent(this.jPanel12, -2, 0, 32767)
/* 1492 */         .addComponent(this.jScrollPane9, -1, 598, 32767));
/*      */     
/* 1494 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1495 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1496 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1497 */           .addComponent(this.jScrollPane9, -1, 180, 32767)
/* 1498 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1499 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 1500 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1503 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1504 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1505 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1507 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 1508 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 1509 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/* 1511 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1513 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1514 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1515 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1516 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1517 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1518 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1521 */     GroupLayout layout = new GroupLayout(this);
/* 1522 */     setLayout(layout);
/* 1523 */     layout.setHorizontalGroup(layout
/* 1524 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1525 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1527 */     layout.setVerticalGroup(layout
/* 1528 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1529 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */   }
/*      */   private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane33; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JTable jTable1; private JTextField jTextField100; private JTextField jTextField101; private JTextField jTextField102; private JTextField jTextField103; private JTextField jTextField104; private JTextField jTextField105; private JTextField jTextField106; private JTextField jTextField107; private JTextField jTextField108; private JTextField jTextField17; private JTextField jTextField24; private JTextField jTextField60; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField63; private JTextField jTextField64; private JTextField jTextField85; private JTextPane jTextPane1; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton24; private MaterialButton materialButton25; private MaterialButton materialButton38; private MaterialButton materialButton39; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private void jTextField60KeyReleased(KeyEvent evt) {
/* 1534 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 1538 */     if (this.PRIMERA) {
/* 1539 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1544 */     if (evt.getClickCount() == 2) {
/* 1545 */       limpiar();
/* 1546 */       desabilitar();
/* 1547 */       verUnidad();
/* 1548 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 1557 */     String[] datos = { "ECO", "MODELO", "SERIE", "PLACAS", "MOTOR", "FACTURA / PAGO", "KILOMETRAJE", "MARCA", "TIPO", "TARJETA DE CIRCULACIÓN", "PÓLIZA", "SEDEMA", "NOM 012", "VERIFICACIÓN", "FISICOMECÁNICA", "SCT", "ESTADO", "SUCURSAL", "USUARIO" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1564 */     this.esc = new EscribirReporte("TRACTOS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 1569 */       if (!this.rSTableMetro1.print());
/*      */     
/*      */     }
/* 1572 */     catch (PrinterException printerException) {}
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 1577 */     limpiar();
/* 1578 */     habilitar();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1584 */     this.materialButton22.setText("Guardar");
/* 1585 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 1586 */     this.materialButton22.setMnemonic('G');
/* 1587 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 1597 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1598 */     if (ind < 0) {
/* 1599 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar los datos", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1601 */       limpiar();
/* 1602 */       habilitar();
/* 1603 */       verUnidad();
/*      */       
/* 1605 */       this.materialButton22.setText("Modificar");
/* 1606 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 1607 */       this.materialButton22.setMnemonic('M');
/* 1608 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {
/* 1613 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1614 */     if (ind < 0) {
/* 1615 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder darlo de baja", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1617 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Al eliminar la unidad, todos los documentos registrados pasarán a BAJA<p><b> ¿Estás seguro que deseas eliminar el remolque que seleccionaste?</b></html>", "Eliminar registro", 0, 3, this.ELIMINAR);
/* 1618 */       if (res == 0) {
/* 1619 */         String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 17));
/* 1620 */         if (estatus.contains("BAJA")) {
/* 1621 */           JOptionPane.showMessageDialog(this.padre, "El vehículo que seleccionaste ya se encuentra dado de baja, verifica tus datos", "No se puede cancelar", 0, this.ERROR);
/*      */         } else {
/* 1623 */           String numEco = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 1624 */           eliminarDoc(numEco);
/* 1625 */           this.con.inserSinMsj("update tracto set estado = 'BAJA' where num_tracto = " + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/* 1626 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 1633 */     if (this.PRIMERA) {
/* 1634 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField61KeyReleased(KeyEvent evt) {
/* 1639 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField62KeyReleased(KeyEvent evt) {
/* 1643 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField63KeyReleased(KeyEvent evt) {
/* 1647 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField64KeyReleased(KeyEvent evt) {
/* 1651 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 1655 */     if (this.PRIMERA) {
/* 1656 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 1661 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 1665 */     String dato = this.jFormattedTextField1.getText();
/* 1666 */     double valor = Double.parseDouble(dato);
/*      */     
/* 1668 */     if (this.jTextField100.getText().equals("")) {
/* 1669 */       this.jTextField100.setBackground(Color.RED);
/* 1670 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número económico", "Ingresa el económico", 0, this.ADVER);
/* 1671 */     } else if (!this.val.validarSoloNum(this.jTextField100, this.jTextField100.getText())) {
/* 1672 */       if (this.con.consultar("num_tracto", "tracto", "where num_tracto = " + this.jTextField100.getText()) && this.materialButton22.getText().equals("Guardar")) {
/* 1673 */         this.jTextField100.setBackground(new Color(255, 51, 51));
/* 1674 */         JOptionPane.showMessageDialog(this.padre, "El número de Tracto que colocaste ya se encuentra registrado en la base de datos", "Número registrado", 0, this.ERROR); return;
/*      */       } 
/* 1676 */       if (this.jTextField102.getText().equals("")) {
/* 1677 */         this.jTextField102.setBackground(Color.RED);
/* 1678 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número de placas", "Ingresa las placas", 0, this.ADVER);
/*      */       } 
/*      */       
/* 1681 */       if (dato.contains("-")) {
/* 1682 */         this.jFormattedTextField1.setBackground(Color.red);
/* 1683 */         JOptionPane.showMessageDialog(this.jDialog1, "El peso de la unidad no puede ser Negativo", "No se aceptan valores negativos", 1, this.ERROR);
/*      */       }
/* 1685 */       else if (valor < 0.1D) {
/* 1686 */         this.jFormattedTextField1.setBackground(Color.red);
/* 1687 */         JOptionPane.showMessageDialog(this.jDialog1, "No se aceptan valores pequeños menores a 1", "Valores muy pequeños", 1, this.ERROR);
/*      */       }
/* 1689 */       else if (valor > 99.0D) {
/* 1690 */         this.jFormattedTextField1.setBackground(Color.red);
/* 1691 */         JOptionPane.showMessageDialog(this.jDialog1, "No se aceptan valores mayores a 99", "Valores muy grandes", 1, this.ERROR);
/*      */       }
/* 1693 */       else if (this.jDateChooser1.getDate() == null) {
/* 1694 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la fecha de compra", "Falta fecha de compra", 0, this.ADVER);
/* 1695 */       } else if (this.jComboBox22.getSelectedIndex() == 0) {
/* 1696 */         this.jComboBox22.setBackground(Color.RED);
/* 1697 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar la marca del vehículo", "Falta marca", 0, this.ADVER);
/* 1698 */       } else if (this.jComboBox23.getSelectedIndex() == 0) {
/* 1699 */         this.jComboBox23.setBackground(Color.RED);
/* 1700 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar el tipo del vehículo", "Falta tipo", 0, this.ADVER);
/* 1701 */       } else if (this.jTextField85.getText().equals("")) {
/* 1702 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar el catálogo para el tipo de Unidad", "Falta tipo", 0, this.ADVER);
/* 1703 */       } else if (this.jComboBox24.getSelectedItem().equals("")) {
/* 1704 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el estado del vehículo", "Falta Estado", 0, this.ADVER);
/* 1705 */       } else if (this.materialButton22.getText().equals("Guardar")) {
/* 1706 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar la información del nuevo vehículo?", "Crear Nuevo", 0, 3, this.PREG);
/* 1707 */         if (res == 0) {
/* 1708 */           String tc = "";
/* 1709 */           String poliza = "";
/* 1710 */           String sedema = "";
/* 1711 */           String nom012 = "";
/* 1712 */           String verificacion = "";
/* 1713 */           String fisicomecanica = "";
/* 1714 */           String sct = "";
/*      */           
/* 1716 */           for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1717 */             String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1718 */             if (v.equals("TARJETA DE CIRCULACIÓN")) {
/* 1719 */               tc = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1720 */             } else if (v.equals("PÓLIZA DE SEGURO")) {
/* 1721 */               poliza = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1722 */             } else if (v.equals("SEDEMA")) {
/* 1723 */               sedema = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1724 */             } else if (v.equals("NOM 012")) {
/* 1725 */               nom012 = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1726 */             } else if (v.equals("VERIFICACIÓN")) {
/* 1727 */               verificacion = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1728 */             } else if (v.equals("FISICOMECÁNICA")) {
/* 1729 */               fisicomecanica = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1730 */             } else if (v.equals("SCT")) {
/* 1731 */               sct = this.rSTableMetro2.getValueAt(i, 2).toString();
/*      */             } 
/*      */           } 
/* 1734 */           this.con.inserSinMsj("insert into tracto ( num_tracto, modelo, no_serie,placas, no_motor, num_factu,forma_pago, fechaCompra, color,dimen, km_actual,marca, tipo, tc, poliza, sedema, nom012, verificacion, fisicomecanica, sct, estado, sucursal, comentarios, usuario, claveCat, pesoVehicular ) values (" + this.jTextField100
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1744 */               .getText().toUpperCase() + ", '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', '" + this.jTextField101.getText().toUpperCase() + "', '" + this.jTextField102
/* 1745 */               .getText().toUpperCase() + "', '" + this.jTextField103.getText().toUpperCase() + "', '" + this.jTextField104.getText().toUpperCase() + "', '" + this.jComboBox21
/* 1746 */               .getSelectedItem().toString().toUpperCase() + "', '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "', '" + this.jTextField105.getText().toUpperCase() + "', '" + this.jTextField107
/* 1747 */               .getText().toUpperCase() + "', '" + this.jTextField108.getText().toUpperCase() + "', '" + 
/* 1748 */               String.valueOf(this.jComboBox22.getSelectedItem()) + "', '" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', '" + tc + "', '" + poliza + "', '" + sedema + "', '" + nom012 + "', '" + verificacion + "', '" + fisicomecanica + "','" + sct + "', '" + this.jComboBox24
/*      */ 
/*      */               
/* 1751 */               .getSelectedItem().toString().toUpperCase() + "', '" + String.valueOf(this.jComboBox25.getSelectedItem()) + "', '" + this.jTextPane1.getText().toUpperCase() + "', '" + this.utilerias.sacarUsuario(this.USUARIO) + "', '" + this.ClaveTipoAut + "', '" + dato + "')");
/*      */ 
/*      */ 
/*      */           
/* 1755 */           String clave = this.jTextField100.getText();
/* 1756 */           for (int j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/* 1757 */             insertarDocumentos(clave, this.rSTableMetro2.getValueAt(j, 1).toString());
/*      */           }
/* 1759 */           this.jDialog1.setVisible(false);
/* 1760 */           consultar();
/*      */         } 
/*      */       } else {
/*      */         
/* 1764 */         String estado = this.jComboBox24.getSelectedItem().toString().toUpperCase();
/* 1765 */         if (this.ESTADOSBAJA.containsValue(estado)) {
/* 1766 */           JOptionPane.showMessageDialog(this.jDialog1, "<html>Al seleccionar la unidad en estado: <b>" + estado + "</b>, los documentos se darán de baja en automático</html>", "Recordatorio", 0, this.ADVER);
/*      */         }
/*      */         
/* 1769 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar la información del vehículo?", "Modificar", 0, 3, this.PREG);
/* 1770 */         if (res == 0) {
/* 1771 */           String tc = "";
/* 1772 */           String poliza = "";
/* 1773 */           String sedema = "";
/* 1774 */           String nom012 = "";
/* 1775 */           String verificacion = "";
/* 1776 */           String fisicomecanica = "";
/* 1777 */           String sct = "";
/*      */           
/* 1779 */           for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1780 */             String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1781 */             if (v.equals("TARJETA DE CIRCULACIÓN")) {
/* 1782 */               tc = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1783 */             } else if (v.equals("PÓLIZA DE SEGURO")) {
/* 1784 */               poliza = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1785 */             } else if (v.equals("SEDEMA")) {
/* 1786 */               sedema = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1787 */             } else if (v.equals("NOM 012")) {
/* 1788 */               nom012 = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1789 */             } else if (v.equals("VERIFICACIÓN")) {
/* 1790 */               verificacion = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1791 */             } else if (v.equals("FISICOMECÁNICA")) {
/* 1792 */               fisicomecanica = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1793 */             } else if (v.equals("SCT")) {
/* 1794 */               sct = this.rSTableMetro2.getValueAt(i, 2).toString();
/*      */             } 
/*      */           } 
/*      */           
/* 1798 */           this.con.inserSinMsj("update tracto set num_tracto = " + this.jTextField100
/* 1799 */               .getText().toUpperCase() + ", modelo = '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', no_serie ='" + this.jTextField101.getText().toUpperCase() + "', placas = '" + this.jTextField102
/* 1800 */               .getText().toUpperCase() + "', no_motor = '" + this.jTextField103.getText().toUpperCase() + "', num_factu='" + this.jTextField104.getText().toUpperCase() + "', forma_pago = '" + 
/* 1801 */               String.valueOf(this.jComboBox21.getSelectedItem()) + "', fechaCompra = '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "', color='" + this.jTextField105.getText().toUpperCase() + "', dimen='" + this.jTextField107
/* 1802 */               .getText().toUpperCase() + "', km_actual='" + this.jTextField108.getText().toUpperCase() + "', marca = '" + 
/* 1803 */               String.valueOf(this.jComboBox22.getSelectedItem()) + "', tipo = '" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', estado = '" + this.jComboBox24.getSelectedItem().toString().toUpperCase() + "', sucursal='" + 
/* 1804 */               String.valueOf(this.jComboBox25.getSelectedItem()) + "', comentarios ='" + this.jTextPane1.getText().toUpperCase() + "', usuario = '" + this.utilerias.sacarUsuario(this.USUARIO) + "', claveCat = '" + this.ClaveTipoAut + "',  pesoVehicular = " + dato + " where num_tracto = " + 
/*      */               
/* 1806 */               String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */ 
/*      */           
/* 1809 */           if (this.ESTADOSBAJA.containsValue(estado)) {
/* 1810 */             String numEco = this.jTextField100.getText();
/* 1811 */             eliminarDoc(numEco);
/*      */           } 
/* 1813 */           this.jDialog1.setVisible(false);
/* 1814 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 1821 */     this.TIPOSELEC = "Marca";
/* 1822 */     activarVentanas(this.jButton38);
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 1826 */     this.TIPOSELEC = "Tipo";
/* 1827 */     activarVentanas(this.jButton39);
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 1831 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1832 */     if (evt.getClickCount() == 2) {
/* 1833 */       String valor = this.rSTableMetro2.getValueAt(ind, 1).toString();
/* 1834 */       if (!valor.contains("FACTURA") || this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 1835 */         if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1836 */           UnidadesTractosDoc uni = this.DOCUMENTACION.get(this.rSTableMetro2.getValueAt(ind, 1));
/* 1837 */           uni.recibeDocumentacion(this.DOCUMENTACION);
/* 1838 */           uni.setGUARDAR("MODIFICAR TEMPORAL");
/* 1839 */           uni.cargarDatos(uni.getInformacion());
/*      */         } else {
/* 1841 */           UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, this.rSTableMetro2.getValueAt(ind, 1).toString(), "VISUALIZAR");
/* 1842 */           unidad.consultarDoc(this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1843 */           unidad.desabilitar();
/* 1844 */           unidad.activarVentana();
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 1855 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 1865 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1866 */     if (ind < 0) {
/* 1867 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/* 1869 */     else if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1870 */       UnidadesTractosDoc uni = this.DOCUMENTACION.get(this.rSTableMetro2.getValueAt(ind, 1));
/* 1871 */       uni.recibeDocumentacion(this.DOCUMENTACION);
/* 1872 */       uni.setGUARDAR("MODIFICAR TEMPORAL");
/* 1873 */       uni.cargarDatos(uni.getInformacion());
/*      */     } else {
/* 1875 */       UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, this.rSTableMetro2.getValueAt(ind, 1).toString(), "MODIFICAR");
/* 1876 */       unidad.recibeDatos(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1877 */       unidad.consultarDoc(this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1878 */       unidad.activarVentana();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 1884 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1885 */     if (ind < 0) {
/* 1886 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/* 1888 */     else if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1889 */       this.DOCUMENTACION.remove(this.rSTableMetro2.getValueAt(ind, 1).toString());
/* 1890 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/*      */     } else {
/* 1892 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Al eliminar los documentos se borrarán en el sevidor y no se podrá recuperar la información que se encuentra enlazada a las unidades,<p> ¿Estás seguro que deseas eliminar definitivamente los datos?</html>", "Eliminar...", 0, 3, this.ELIMINAR);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1897 */       if (res == 0) {
/* 1898 */         String numDoc = this.rSTableMetro2.getValueAt(ind, 0).toString();
/* 1899 */         this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Archivo", "Tipo", "Act" }, "numArch, nombreArch, tipo, fecha", "unidadesarchivos", "where numDoc = " + numDoc);
/*      */ 
/*      */         
/*      */         int i;
/*      */         
/* 1904 */         for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1905 */           File fichero = new File(this.jTable1.getValueAt(i, 1).toString());
/* 1906 */           fichero.delete();
/*      */         } 
/* 1908 */         this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Num Doc", "Num Tracto" }, "numDoc, tracto.num_tracto", "tracto, unidadesdoctractos ", "where unidadesdoctractos.tipo = 'TRACTO' and tracto.num_tracto = unidadesdoctractos.num_tracto and numDoc = " + numDoc);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1913 */         for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1914 */           this.con.inserSinMsj("update tracto set " + convertirTipoDocCampo(this.rSTableMetro2.getValueAt(ind, 1).toString()) + " = '' where num_tracto = " + String.valueOf(this.jTable1.getValueAt(i, 1)));
/*      */         }
/* 1916 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/* 1917 */         this.con.eliminar2("unidadesarchivos", "where numDoc = " + numDoc);
/* 1918 */         this.con.eliminar2("unidadesdoctractos", "where tipo = 'TRACTO' and numDoc = " + numDoc);
/* 1919 */         this.con.eliminar2("unidadesdocumentos", "where numDoc = " + numDoc);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 1926 */     if (existeDoc()) {
/* 1927 */       JOptionPane.showMessageDialog(this.jDialog2, "El tipo de documento ya se encuentra enlistado, necesitas modificarlo", "Documento Creado", 0, this.ERROR);
/*      */     } else {
/* 1929 */       this.jDialog2.setVisible(false);
/* 1930 */       String guardar = "APLICAR";
/* 1931 */       if (this.materialButton22.getText().equals("Guardar")) {
/* 1932 */         guardar = "TEMPORAL";
/*      */       } else {
/* 1934 */         this.DOCUMENTACION = new LinkedHashMap<>();
/*      */       } 
/* 1936 */       UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, dameTipoDocSelec(), guardar);
/* 1937 */       unidad.recibeDocumentacion(this.DOCUMENTACION);
/* 1938 */       if (this.materialButton22.getText().equals("Modificar")) {
/* 1939 */         unidad.recibeDatos(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), "0");
/*      */       }
/* 1941 */       unidad.activarVentana();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 1946 */     this.jDialog2.setVisible(false);
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
/* 1958 */     if (evt.getClickCount() == 2) {
/* 1959 */       if (this.TIPOSELEC.equals("Marca")) {
/* 1960 */         this.jComboBox22.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*      */       } else {
/* 1962 */         this.jComboBox23.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*      */       } 
/* 1964 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 1973 */     if (this.TIPOSELEC.equals("Marca")) {
/* 1974 */       this.jLabel34.setText("Ingresa el nombre de la marca del tractor");
/*      */     } else {
/* 1976 */       this.jLabel34.setText("Ingresa el nombre del tipo de tractor");
/*      */     } 
/* 1978 */     this.jTextField24.setText("");
/* 1979 */     this.materialButton25.setText("Agregar");
/* 1980 */     this.materialButton25.setMnemonic('A');
/* 1981 */     this.materialButton25.setToolTipText("Agregar (Alt+A)");
/* 1982 */     this.jDialog4.setTitle("Agregar");
/* 1983 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton59ActionPerformed(ActionEvent evt) {
/* 1987 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1988 */     if (ind < 0) {
/* 1989 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1991 */       this.materialButton25.setText("Modificar");
/* 1992 */       this.materialButton25.setMnemonic('M');
/* 1993 */       this.materialButton25.setToolTipText("Modificar tipo (Alt+M)");
/* 1994 */       this.jTextField24.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/* 1995 */       this.jDialog4.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton61ActionPerformed(ActionEvent evt) {
/* 2000 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 2001 */     if (ind < 0) {
/* 2002 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 2004 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas eleiminar la información que seleccionaste?", "Eliminar...", 0, 3, this.PREG);
/* 2005 */       if (res == 0) {
/* 2006 */         if (this.TIPOSELEC.equals("Marca")) {
/* 2007 */           this.con.eliminar("marca", "where id_marca=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 2008 */           llenarMarca();
/* 2009 */           consultarMarcas();
/*      */         } else {
/* 2011 */           this.con.eliminar("tipos", "where id_tipo=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 2012 */           llenarTipo();
/* 2013 */           consultarTipos();
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
/* 2024 */     if (this.TIPOSELEC.equals("Marca")) {
/* 2025 */       consultarMarcas();
/*      */     } else {
/* 2027 */       consultarTipos();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField24ActionPerformed(ActionEvent evt) {
/* 2032 */     guardarMarcasTipos();
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 2036 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 2040 */     guardarMarcasTipos();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jScrollPane8MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 2048 */     new TrasCatalogos(this.padre, true, this.jButton56, "tras_config_aut", this.CLAVECONFIGAUT, "", true);
/* 2049 */     this.CLAVECONFIGAUT.forEach((x, y) -> this.jTextField85.setText(x + " - " + x));
/* 2050 */     this.jTextField85.setToolTipText(this.jTextField85.getText());
/* 2051 */     Set<String> keys = this.CLAVECONFIGAUT.keySet();
/* 2052 */     for (String key : keys) {
/* 2053 */       this.ClaveTipoAut = key;
/*      */     }
/*      */   }
/*      */   
/*      */   public void eliminarDoc(String numEco) {
/* 2058 */     String[] doc = this.con.regresaColIndex("unidadesdocumentos.numDoc", "unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.numDoc = unidadesdocumentos.numDoc and unidadesdocumentos.estado = 'ACTIVO' and unidadesdoctractos.tipo = 'TRACTO' and unidadesdoctractos.num_tracto = " + numEco);
/*      */ 
/*      */ 
/*      */     
/* 2062 */     for (String d : doc) {
/* 2063 */       this.con.inserSinMsj("update unidadesdocumentos set estado = 'BAJA' where numDoc = " + d);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean validadPesoUnidad() {
/* 2068 */     boolean resultado = true;
/* 2069 */     String dato = this.jFormattedTextField1.getText();
/* 2070 */     double val = Double.parseDouble(dato);
/* 2071 */     if (dato.contains("-")) {
/* 2072 */       this.jFormattedTextField1.setBackground(Color.red);
/* 2073 */       JOptionPane.showMessageDialog(this.jDialog1, "El peso de la unidad no puede ser Negativo", "No se aceptan valores negativos", 1, this.ERROR);
/* 2074 */       resultado = false;
/* 2075 */     } else if (val < 0.1D) {
/* 2076 */       this.jFormattedTextField1.setBackground(Color.red);
/* 2077 */       JOptionPane.showMessageDialog(this.jDialog1, "No se aceptan valores pequeños menores a 1", "Valores muy pequeños", 1, this.ERROR);
/* 2078 */       resultado = false;
/* 2079 */     } else if (val > 99.0D) {
/* 2080 */       this.jFormattedTextField1.setBackground(Color.red);
/* 2081 */       JOptionPane.showMessageDialog(this.jDialog1, "No se aceptan valores mayores a 99", "Valores muy grandes", 1, this.ERROR);
/* 2082 */       resultado = false;
/*      */     } 
/*      */     
/* 2085 */     return resultado;
/*      */   }
/*      */   
/*      */   public void verUnidad() {
/* 2089 */     String[] datos = this.con.regresaRegIndex("num_tracto, modelo, no_serie, placas, no_motor, num_factu, forma_pago, fechaCompra, color, dimen, km_actual, marca, tipo, estado, sucursal, comentarios, claveCat, pesoVehicular", "tracto", "where num_tracto= " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2094 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */     
/* 2096 */     this.jTextField100.setText(datos[0]);
/* 2097 */     this.jComboBox20.setSelectedItem(datos[1]);
/* 2098 */     this.jTextField101.setText(datos[2]);
/* 2099 */     this.jTextField102.setText(datos[3]);
/* 2100 */     this.jTextField103.setText(datos[4]);
/* 2101 */     this.jTextField104.setText(datos[5]);
/* 2102 */     this.jComboBox21.setSelectedItem(datos[6]);
/* 2103 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(datos[7]));
/* 2104 */     this.jTextField105.setText(datos[8]);
/*      */     
/* 2106 */     this.jTextField107.setText(datos[9]);
/* 2107 */     this.jTextField108.setText(datos[10]);
/* 2108 */     this.jComboBox22.setSelectedItem(datos[11]);
/* 2109 */     this.jComboBox23.setSelectedItem(datos[12]);
/* 2110 */     this.jComboBox24.setSelectedItem(datos[13]);
/* 2111 */     this.jComboBox25.setSelectedItem(datos[14]);
/* 2112 */     this.jTextPane1.setText(datos[15]);
/* 2113 */     this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(datos[17])));
/* 2114 */     this.encontrado = this.con2.consultar("descripcion", "tras_config_aut", "where claveCat = '" + datos[16] + "'");
/* 2115 */     if (this.encontrado) {
/* 2116 */       this.ClaveTipoAut = datos[16];
/* 2117 */       this.jTextField85.setText(datos[16] + " - " + datos[16]);
/* 2118 */       this.jTextField85.setToolTipText(datos[16] + " - " + datos[16]);
/*      */     } else {
/* 2120 */       this.jTextField85.setText("");
/* 2121 */       this.jTextField85.setToolTipText("");
/*      */     } 
/*      */     
/* 2124 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro2, new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" }, "unidadesdocumentos.numDoc, unidadesdocumentos.tipo, unidadesdocumentos.numeroUnico,unidadesdocumentos.fechaVencimiento, unidadesdocumentos.estado", "tracto, unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.tipo = 'TRACTO' and tracto.num_tracto = unidadesdoctractos.num_tracto and unidadesdocumentos.numDoc = unidadesdoctractos.numDoc and tracto.num_tracto = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2129 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + " order by unidadesdocumentos.estado asc, unidadesdocumentos.tipo asc");
/*      */     
/* 2131 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda2);
/* 2132 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 0, 50);
/*      */     
/* 2134 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 3, 100);
/* 2135 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 4, 60);
/* 2136 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 2137 */     this.rSTableMetro2.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void desabilitar() {
/* 2141 */     this.jTextField100.setEnabled(false);
/* 2142 */     this.jTextField101.setEnabled(false);
/* 2143 */     this.jTextField102.setEnabled(false);
/* 2144 */     this.jTextField103.setEnabled(false);
/* 2145 */     this.jTextField104.setEnabled(false);
/* 2146 */     this.jTextField105.setEnabled(false);
/* 2147 */     this.jTextField106.setEnabled(false);
/* 2148 */     this.jTextField107.setEnabled(false);
/* 2149 */     this.jTextField108.setEnabled(false);
/* 2150 */     this.jComboBox20.setEnabled(false);
/* 2151 */     this.jComboBox21.setEnabled(false);
/* 2152 */     this.jComboBox22.setEnabled(false);
/* 2153 */     this.jComboBox23.setEnabled(false);
/* 2154 */     this.jComboBox24.setEnabled(false);
/* 2155 */     this.jComboBox25.setEnabled(false);
/* 2156 */     this.jButton38.setEnabled(false);
/* 2157 */     this.jButton39.setEnabled(false);
/* 2158 */     this.jDateChooser1.setEnabled(false);
/* 2159 */     this.jButton53.setEnabled(false);
/* 2160 */     this.jButton54.setEnabled(false);
/* 2161 */     this.jButton55.setEnabled(false);
/* 2162 */     this.materialButton22.setEnabled(false);
/* 2163 */     this.jTextPane1.setEnabled(false);
/* 2164 */     this.jButton56.setEnabled(false);
/* 2165 */     this.jFormattedTextField1.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 2169 */     System.out.println("priv " + (String)this.CAMPOSGENERALES.get("priv") + " " + this.PRIVILEGIOS.containsValue("SUPER USUARIO"));
/* 2170 */     if (this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 2171 */       this.jButton35.setEnabled(true);
/* 2172 */       this.jButton36.setEnabled(true);
/* 2173 */       this.jButton37.setEnabled(true);
/* 2174 */       this.materialButton22.setEnabled(true);
/* 2175 */       this.jButton53.setEnabled(true);
/* 2176 */       this.jButton54.setEnabled(true);
/* 2177 */       this.jButton55.setEnabled(true);
/*      */     } else {
/* 2179 */       this.jButton35.setEnabled(false);
/* 2180 */       this.jButton36.setEnabled(false);
/* 2181 */       this.jButton37.setEnabled(false);
/* 2182 */       this.materialButton22.setEnabled(false);
/* 2183 */       this.jButton53.setEnabled(false);
/* 2184 */       this.jButton54.setEnabled(false);
/* 2185 */       this.jButton55.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void habilitar() {
/* 2190 */     this.jTextField100.setEnabled(true);
/* 2191 */     this.jTextField101.setEnabled(true);
/* 2192 */     this.jTextField102.setEnabled(true);
/* 2193 */     this.jTextField103.setEnabled(true);
/* 2194 */     this.jTextField104.setEnabled(true);
/* 2195 */     this.jTextField105.setEnabled(true);
/* 2196 */     this.jTextField106.setEnabled(true);
/* 2197 */     this.jTextField107.setEnabled(true);
/* 2198 */     this.jTextField108.setEnabled(true);
/* 2199 */     this.jComboBox20.setEnabled(true);
/* 2200 */     this.jComboBox21.setEnabled(true);
/* 2201 */     this.jComboBox22.setEnabled(true);
/* 2202 */     this.jComboBox23.setEnabled(true);
/* 2203 */     this.jComboBox24.setEnabled(true);
/* 2204 */     this.jButton38.setEnabled(true);
/* 2205 */     this.jButton39.setEnabled(true);
/* 2206 */     this.jDateChooser1.setEnabled(true);
/* 2207 */     this.jButton53.setEnabled(true);
/* 2208 */     this.jButton54.setEnabled(true);
/* 2209 */     this.jButton55.setEnabled(true);
/* 2210 */     this.materialButton22.setEnabled(true);
/* 2211 */     this.jTextPane1.setEnabled(true);
/* 2212 */     this.jComboBox25.setEnabled(true);
/* 2213 */     this.jButton56.setEnabled(true);
/* 2214 */     this.jFormattedTextField1.setEnabled(true);
/*      */   }
/*      */   
/*      */   public boolean existeValor(Map Mapa, String buscar) {
/* 2218 */     return Mapa.containsValue(buscar);
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertarDocumentos(String claveTracto, String TipoDoc) {
/* 2223 */     String claveDoc = "";
/* 2224 */     this.con.inserSinMsj("insert into unidadesdocumentos (tipo, fechaCaptura, fechaTramite, numeroUnico, periodoVencimiento, fechaInicio, fechaVencimiento, dependencia, costo, dirTramite, telefono, comentarios, estado, usuario) values ('" + ((UnidadesTractosDoc)this.DOCUMENTACION
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2231 */         .get(TipoDoc)).getInformacion().getTipo() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2232 */         .get(TipoDoc)).getInformacion().getfCaptura() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2233 */         .get(TipoDoc)).getInformacion().getFtramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2234 */         .get(TipoDoc)).getInformacion().getNumUnico() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2235 */         .get(TipoDoc)).getInformacion().getpVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2236 */         .get(TipoDoc)).getInformacion().getFinicio() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2237 */         .get(TipoDoc)).getInformacion().getfVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2238 */         .get(TipoDoc)).getInformacion().getDependencia() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2239 */         .get(TipoDoc)).getInformacion().getCosto() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2240 */         .get(TipoDoc)).getInformacion().getDirTramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2241 */         .get(TipoDoc)).getInformacion().getTel() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2242 */         .get(TipoDoc)).getInformacion().getComentarios() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2243 */         .get(TipoDoc)).getInformacion().getEstado() + "', '" + this.utilerias
/* 2244 */         .sacarUsuario(this.USUARIO) + "')");
/*      */ 
/*      */ 
/*      */     
/* 2248 */     this.con.consultar("max(numDoc)", "unidadesdocumentos", "");
/* 2249 */     claveDoc = this.con.Campo;
/*      */     
/* 2251 */     for (int i = 0; i < ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().size(); i++) {
/* 2252 */       this.con.inserSinMsj("insert into unidadesarchivos ( nombreArch, tipo, fecha, numDoc ) values ( '" + 
/*      */ 
/*      */           
/* 2255 */           copiarArchivos(((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().get("" + i)).getArchivo(), getRutaDestino(TipoDoc)) + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 2256 */           .get(TipoDoc)).getDocumentos().get("" + i)).getTipo() + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 2257 */           .get(TipoDoc)).getDocumentos().get("" + i)).getAct() + "', " + claveDoc + ")");
/*      */     }
/*      */ 
/*      */     
/* 2261 */     this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + claveTracto + ",'TRACTO' )");
/* 2262 */     String[] ecos = ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getlistaEcos();
/* 2263 */     for (int j = 0; j < ecos.length; j++) {
/* 2264 */       System.out.println("dentro " + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo() + " " + TipoDoc + " " + ecos[j]);
/* 2265 */       this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto) values(" + claveDoc + ", " + ecos[j] + ",'TRACTO' )");
/* 2266 */       if (this.CAMPOS.containsValue(((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo())) {
/* 2267 */         this.con.inserSinMsj("update tracto set " + convertirTipoDocCampo(TipoDoc) + " = '" + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getNumUnico() + "' where num_tracto= " + ecos[j]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String copiarArchivos(String origen, String destino) {
/* 2274 */     if (this.TIPOV.equals("")) {
/* 2275 */       this.TIPOV = "ECO";
/*      */     }
/* 2277 */     Path origenPath = Paths.get(origen, new String[0]);
/* 2278 */     Path destinoPath = Paths.get(destino + "/" + destino + this.TIPOV + "-" + this.utilerias.getFechaSinEspacios(), new String[0]);
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 2283 */       Files.copy(origenPath, destinoPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*      */     }
/* 2285 */     catch (FileNotFoundException ex) {
/* 2286 */       System.out.println("ERROR 1: al copiar Arhivo: " + ex.getMessage());
/* 2287 */     } catch (IOException ex) {
/* 2288 */       System.out.println("ERROR 2: al copiar Arhivo: " + ex.getMessage());
/*      */     } 
/* 2290 */     String nuevaRuta = destinoPath.toString().replace("\\", "\\\\");
/* 2291 */     return nuevaRuta;
/*      */   }
/*      */   
/*      */   public String getRutaDestino(String tipo) {
/* 2295 */     String ruta = this.CARPETAS.get("OTRO");
/* 2296 */     if (tipo.equals("TARJETA DE CIRCULACIÓN")) {
/* 2297 */       ruta = this.CARPETAS.get("TC");
/* 2298 */     } else if (tipo.equals("PÓLIZA DE SEGURO")) {
/* 2299 */       ruta = this.CARPETAS.get("POLIZA");
/* 2300 */     } else if (tipo.equals("SEDEMA")) {
/* 2301 */       ruta = this.CARPETAS.get("SEDEMA");
/* 2302 */     } else if (tipo.equals("NOM 012")) {
/* 2303 */       ruta = this.CARPETAS.get("NOM012");
/* 2304 */     } else if (tipo.equals("VERIFICACIÓN")) {
/* 2305 */       ruta = this.CARPETAS.get("VERIFICACION");
/* 2306 */     } else if (tipo.equals("FISICOMECÁNICA")) {
/* 2307 */       ruta = this.CARPETAS.get("FISICOMECANICA");
/* 2308 */     } else if (tipo.equals("SCT")) {
/* 2309 */       ruta = this.CARPETAS.get("SCT");
/* 2310 */     } else if (tipo.equals("PAGO")) {
/* 2311 */       ruta = this.CARPETAS.get("PAGOS");
/*      */     } 
/*      */     
/* 2314 */     return ruta;
/*      */   }
/*      */   
/*      */   public void guardarMarcasTipos() {
/* 2318 */     String marca = this.jTextField24.getText().toUpperCase();
/* 2319 */     if (marca.equals("")) {
/* 2320 */       this.jTextField24.setBackground(Color.RED);
/* 2321 */       JOptionPane.showMessageDialog(this.jDialog4, "No puedes dejar el campo vacío, por favor verifica tu información", "Falta información", 0, this.ADVER);
/* 2322 */     } else if (this.TIPOSELEC.equals("Marca")) {
/* 2323 */       if (existeValor(this.MARCAS, this.jTextField24.getText().toUpperCase())) {
/* 2324 */         this.jTextField24.setBackground(Color.RED);
/* 2325 */         JOptionPane.showMessageDialog(this.jDialog4, "La marca que deseas agregar ya se encuentra almacenada, por favor verifica tu información", "Marca ya existe", 0, this.ADVER);
/* 2326 */       } else if (this.materialButton25.getText().equals("Agregar")) {
/* 2327 */         int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar la nueva marca?", "Agregar nueva marca", 0, 3, this.PREG);
/* 2328 */         if (res == 0) {
/* 2329 */           this.con.inserSinMsj("insert into marca(marca) values('" + marca + "')");
/* 2330 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos) values (now(),'" + this.USUARIO + "','Almacenó una nueva marca de carro.','\nMarca: " + marca + "')");
/* 2331 */           llenarMarca();
/* 2332 */           this.jDialog3.setVisible(false);
/* 2333 */           this.jDialog4.setVisible(false);
/* 2334 */           this.jComboBox22.setSelectedItem(marca);
/*      */         } 
/*      */       } else {
/* 2337 */         this.con.inserSinMsj("update marca set marca ='" + this.jTextField24.getText().toUpperCase() + "' where marca ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 2338 */         this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 2339 */         llenarMarca();
/* 2340 */         this.jComboBox22.setSelectedItem(this.jTextField24.getText().toUpperCase());
/* 2341 */         this.jDialog4.setVisible(false);
/* 2342 */         this.jDialog3.setVisible(false);
/*      */       }
/*      */     
/* 2345 */     } else if (existeValor(this.TIPOS, this.jTextField24.getText().toUpperCase())) {
/* 2346 */       this.jTextField24.setBackground(Color.RED);
/* 2347 */       JOptionPane.showMessageDialog(this.jDialog4, "El tipo de tractor que deseas agregar ya se encuentra almacenado, por favor verifica tu información", "Tipo ya existe", 0, this.ADVER);
/* 2348 */     } else if (this.materialButton25.getText().equals("Agregar")) {
/* 2349 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar el nuevo tipo?", "Agregar nuevo tipo", 0, 3, this.PREG);
/* 2350 */       if (res == 0) {
/* 2351 */         this.con.inserSinMsj("insert into tipos(tipo)values('" + marca + "')");
/* 2352 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo tipo de carro.','Tipo: " + marca + "')");
/* 2353 */         llenarTipo();
/* 2354 */         this.jDialog3.setVisible(false);
/* 2355 */         this.jDialog4.setVisible(false);
/* 2356 */         this.jComboBox23.setSelectedItem(marca);
/*      */       } 
/*      */     } else {
/* 2359 */       this.con.inserSinMsj("update tipos set tipo ='" + this.jTextField24.getText().toUpperCase() + "' where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 2360 */       this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 2361 */       llenarTipo();
/* 2362 */       this.jComboBox23.setSelectedItem(this.jTextField24.getText().toUpperCase());
/* 2363 */       this.jDialog4.setVisible(false);
/* 2364 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void activarVentanas(JButton boton) {
/* 2370 */     if (this.TIPOSELEC.equals("Marca")) {
/* 2371 */       consultarMarcas();
/* 2372 */       Dimension di = boton.getSize();
/* 2373 */       Point p = boton.getLocationOnScreen();
/* 2374 */       this.jDialog3.setLocation(p.x + di.width + 5, p.y + 35);
/* 2375 */       this.jDialog3.setVisible(true);
/*      */     } else {
/* 2377 */       consultarTipos();
/* 2378 */       Dimension di = boton.getSize();
/* 2379 */       Point p = boton.getLocationOnScreen();
/* 2380 */       this.jDialog3.setLocation(p.x + di.width - 300, p.y + 35);
/* 2381 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarMarcas() {
/* 2386 */     String marca = "";
/* 2387 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 2388 */       marca = this.jTextField17.getText();
/*      */     }
/* 2390 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Marca" }, "id_marca,marca", "marca", "where marca like '%" + marca + "%' order by marca");
/*      */ 
/*      */     
/* 2393 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 2394 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */   }
/*      */   
/*      */   public void consultarTipos() {
/* 2398 */     String tipo = "";
/* 2399 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 2400 */       tipo = this.jTextField17.getText();
/*      */     }
/* 2402 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Tipo" }, "id_tipo,tipo", "tipos", "where tipo like '%" + tipo + "%' order by tipo");
/*      */ 
/*      */     
/* 2405 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 2406 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */   }
/*      */   
/*      */   public String convertirTipoDocCampo(String tipoDoc) {
/* 2410 */     String campo = "";
/* 2411 */     if (tipoDoc.equals("TARJETA DE CIRCULACIÓN")) {
/* 2412 */       campo = "tc";
/* 2413 */     } else if (tipoDoc.equals("PÓLIZA DE SEGURO")) {
/* 2414 */       campo = "poliza";
/* 2415 */     } else if (tipoDoc.equals("SEDEMA")) {
/* 2416 */       campo = "sedema";
/* 2417 */     } else if (tipoDoc.equals("NOM 012")) {
/* 2418 */       campo = "nom012";
/* 2419 */     } else if (tipoDoc.equals("VERIFICACIÓN")) {
/* 2420 */       campo = "verificacion";
/* 2421 */     } else if (tipoDoc.equals("FISICOMECÁNICA")) {
/* 2422 */       campo = "fisicomecanica";
/* 2423 */     } else if (tipoDoc.equals("SCT")) {
/* 2424 */       campo = "sct";
/* 2425 */     } else if (tipoDoc.equals("PAGO")) {
/* 2426 */       campo = "pago";
/*      */     } 
/*      */     
/* 2429 */     return campo;
/*      */   }
/*      */   
/*      */   public String dameTipoDocSelec() {
/* 2433 */     String tipo = "";
/* 2434 */     if (this.jRadioButton1.isSelected()) {
/* 2435 */       tipo = "TARJETA DE CIRCULACIÓN";
/*      */     }
/* 2437 */     if (this.jRadioButton2.isSelected()) {
/* 2438 */       tipo = "PÓLIZA DE SEGURO";
/*      */     }
/* 2440 */     if (this.jRadioButton3.isSelected()) {
/* 2441 */       tipo = "SEDEMA";
/*      */     }
/* 2443 */     if (this.jRadioButton4.isSelected()) {
/* 2444 */       tipo = "NOM 012";
/*      */     }
/* 2446 */     if (this.jRadioButton5.isSelected()) {
/* 2447 */       tipo = "VERIFICACIÓN";
/*      */     }
/* 2449 */     if (this.jRadioButton6.isSelected()) {
/* 2450 */       tipo = "FISICOMECÁNICA";
/*      */     }
/* 2452 */     if (this.jRadioButton7.isSelected()) {
/* 2453 */       tipo = "SCT";
/*      */     }
/* 2455 */     if (this.jRadioButton8.isSelected()) {
/* 2456 */       tipo = "PAGO";
/*      */     }
/* 2458 */     if (this.jRadioButton9.isSelected()) {
/* 2459 */       tipo = "OTRO";
/*      */     }
/* 2461 */     return tipo;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean existeDoc() {
/* 2466 */     boolean existe = false;
/* 2467 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2468 */       String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 2469 */       if (dameTipoDocSelec().equals(v)) {
/* 2470 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2480 */     return existe;
/*      */   }
/*      */   
/*      */   public void llenarModelo() {
/* 2484 */     int año = this.fechaActual.getYear();
/* 2485 */     año += 1901;
/* 2486 */     this.jComboBox9.removeAllItems();
/* 2487 */     this.jComboBox9.addItem("MODELO");
/* 2488 */     for (int i = año; i >= 1990; i--) {
/* 2489 */       this.jComboBox20.addItem("" + i);
/* 2490 */       this.jComboBox9.addItem("" + i);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarMarca() {
/* 2495 */     String[] depa = this.con.regresaColIndex("marca", "marca", "order by marca");
/* 2496 */     this.jComboBox22.removeAllItems();
/* 2497 */     this.jComboBox22.addItem("SELECCIONA UNO...");
/* 2498 */     this.utilerias.llenarCombo(this.jComboBox22, depa);
/* 2499 */     for (int i = 0; i < depa.length; i++) {
/* 2500 */       this.MARCAS.put("" + i, depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarTipo() {
/* 2505 */     String[] tipo = this.con.regresaColIndex("tipo", "tipos", "order by tipo");
/* 2506 */     this.jComboBox23.removeAllItems();
/* 2507 */     this.jComboBox23.addItem("SELECCIONA UNO...");
/* 2508 */     this.utilerias.llenarCombo(this.jComboBox23, tipo);
/* 2509 */     for (int i = 0; i < tipo.length; i++) {
/* 2510 */       this.TIPOS.put("" + i, tipo[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2515 */     this.pintar.colorear(this.jTextField60);
/* 2516 */     this.pintar.colorear(this.jTextField61);
/* 2517 */     this.pintar.colorear(this.jTextField62);
/* 2518 */     this.pintar.colorear(this.jTextField63);
/* 2519 */     this.pintar.colorear(this.jTextField64);
/* 2520 */     this.pintar.colorear(this.jComboBox9);
/* 2521 */     this.pintar.colorear(this.jComboBox10);
/* 2522 */     this.pintar.colorear(this.jComboBox11);
/*      */     
/* 2524 */     this.pintar.colorear(this.jTextField100);
/* 2525 */     this.pintar.colorear(this.jTextField101);
/* 2526 */     this.pintar.colorear(this.jTextField102);
/* 2527 */     this.pintar.colorear(this.jTextField103);
/* 2528 */     this.pintar.colorear(this.jTextField104);
/* 2529 */     this.pintar.colorear(this.jTextField105);
/* 2530 */     this.pintar.colorear(this.jTextField106);
/* 2531 */     this.pintar.colorear(this.jTextField107);
/* 2532 */     this.pintar.colorear(this.jTextField108);
/* 2533 */     this.pintar.colorear(this.jTextField17);
/* 2534 */     this.pintar.colorear(this.jTextField24);
/* 2535 */     this.pintar.colorear(this.jTextPane1);
/* 2536 */     this.pintar.colorear(this.jComboBox20);
/* 2537 */     this.pintar.colorear(this.jComboBox21);
/* 2538 */     this.pintar.colorear(this.jComboBox22);
/* 2539 */     this.pintar.colorear(this.jComboBox23);
/* 2540 */     this.pintar.colorear(this.jComboBox24);
/* 2541 */     this.pintar.colorear(this.jComboBox25);
/* 2542 */     this.pintar.colorear(this.jFormattedTextField1);
/*      */   }
/*      */   
/*      */   public void ingresarCampos() {
/* 2546 */     this.CAMPOS.put("TARJETA DE CIRCULACIÓN", "TARJETA DE CIRCULACIÓN");
/* 2547 */     this.CAMPOS.put("PÓLIZA DE SEGURO", "PÓLIZA DE SEGURO");
/* 2548 */     this.CAMPOS.put("POLIZA", "POLIZA");
/* 2549 */     this.CAMPOS.put("SEDEMA", "SEDEMA");
/* 2550 */     this.CAMPOS.put("NOM 012", "NOM 012");
/* 2551 */     this.CAMPOS.put("VERIFICACIÓN", "VERIFICACIÓN");
/* 2552 */     this.CAMPOS.put("FISICOMECÁNICA", "FISICOMECÁNICA");
/* 2553 */     this.CAMPOS.put("SCT", "SCT");
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 2557 */     this.DOCUMENTACION = new LinkedHashMap<>();
/* 2558 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro2);
/* 2559 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda2);
/* 2560 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 0, 50);
/* 2561 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 3, 100);
/* 2562 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 4, 60);
/* 2563 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 2564 */     this.rSTableMetro2.setSelectionMode(0);
/* 2565 */     this.jTextField100.setText("");
/* 2566 */     this.jTextField101.setText("");
/* 2567 */     this.jTextField102.setText("");
/* 2568 */     this.jTextField103.setText("");
/* 2569 */     this.jTextField104.setText("");
/* 2570 */     this.jTextField105.setText("");
/* 2571 */     this.jTextField106.setText("");
/* 2572 */     this.jTextField107.setText("");
/* 2573 */     this.jTextField108.setText("");
/* 2574 */     this.jComboBox20.setSelectedIndex(0);
/* 2575 */     this.jComboBox21.setSelectedIndex(0);
/* 2576 */     this.jComboBox22.setSelectedIndex(0);
/* 2577 */     this.jComboBox23.setSelectedIndex(0);
/* 2578 */     this.jComboBox24.setSelectedIndex(0);
/* 2579 */     this.jComboBox25.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/* 2580 */     this.jDateChooser1.setDate(new Date());
/* 2581 */     this.jFormattedTextField1.setValue(Double.valueOf(1.0D));
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
/*      */   public void tracto(String usua) {
/* 2639 */     this.USUARIO = usua;
/* 2640 */     this.panel.setViewportView(this);
/* 2641 */     privilegios();
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
/* 2661 */     this.ESTADOS = this.con.regresaColIndex("distinct(estado)", "tracto", " order by estado");
/* 2662 */     this.jComboBox10.removeAllItems();
/* 2663 */     this.jComboBox10.addItem("ESTADO");
/* 2664 */     this.utilerias.llenarCombo(this.jComboBox10, this.ESTADOS);
/* 2665 */     this.jComboBox10.setSelectedItem("ACTIVO");
/*      */   }
/*      */   
/*      */   public void llenarComboSuc() {
/* 2669 */     this.SUCURSALES = this.con2.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 2670 */     this.jComboBox11.removeAllItems();
/* 2671 */     this.jComboBox25.removeAllItems();
/* 2672 */     this.utilerias.llenarCombo(this.jComboBox11, this.SUCURSALES);
/* 2673 */     this.utilerias.llenarCombo(this.jComboBox25, this.SUCURSALES);
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
/* 2751 */     this.PRIMERA = true;
/* 2752 */     String eco = "";
/* 2753 */     String serie = "";
/* 2754 */     String placas = "";
/* 2755 */     String marca = "";
/* 2756 */     String tipo = "";
/* 2757 */     String modelo = "";
/* 2758 */     String estado = "";
/* 2759 */     String sucursal = "";
/*      */     
/* 2761 */     if (!this.jTextField60.getText().equals(this.holderEco)) {
/* 2762 */       eco = this.jTextField60.getText();
/*      */     }
/* 2764 */     if (!this.jTextField61.getText().equals(this.holderSerie)) {
/* 2765 */       serie = this.jTextField61.getText();
/*      */     }
/* 2767 */     if (!this.jTextField62.getText().equals(this.holderPlacas)) {
/* 2768 */       placas = this.jTextField62.getText();
/*      */     }
/* 2770 */     if (!this.jTextField63.getText().equals(this.holderMarca)) {
/* 2771 */       marca = this.jTextField63.getText();
/*      */     }
/* 2773 */     if (!this.jTextField64.getText().equals(this.holderTipo)) {
/* 2774 */       tipo = this.jTextField64.getText();
/*      */     }
/*      */     
/* 2777 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 2778 */       modelo = this.jComboBox9.getSelectedItem().toString();
/*      */     }
/* 2780 */     if (this.jComboBox10.getSelectedIndex() != 0) {
/* 2781 */       estado = this.jComboBox10.getSelectedItem().toString();
/*      */     }
/* 2783 */     if (!this.jComboBox11.getSelectedItem().equals("GENERAL")) {
/* 2784 */       sucursal = this.jComboBox11.getSelectedItem().toString();
/*      */     }
/*      */     
/* 2787 */     (new String[20])[0] = "Eco"; (new String[20])[1] = "Modelo"; (new String[20])[2] = "Serie"; (new String[20])[3] = "Placas"; (new String[20])[4] = "Motor"; (new String[20])[5] = "Factura / Pago"; (new String[20])[6] = "Pago"; (new String[20])[7] = "Kilometraje"; (new String[20])[8] = "Marca"; (new String[20])[9] = "Tipo"; (new String[20])[10] = "Tarjeta Circualción"; (new String[20])[11] = "Póliza"; (new String[20])[12] = "Sedema"; (new String[20])[13] = "Nom 012"; (new String[20])[14] = "Verificación"; (new String[20])[15] = "Fisicomecanica"; (new String[20])[16] = "SCT"; (new String[20])[17] = "Estado"; (new String[20])[18] = "Sucursal"; (new String[20])[19] = "Usuario"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos("num_tracto, modelo, no_serie, placas, no_motor, num_factu, forma_pago, km_actual, marca, tipo, tc, poliza, sedema, nom012, verificacion, fisicomecanica, sct, estado, sucursal, usuario", "tracto", "where num_tracto like '%" + eco + "%' and no_serie like '%" + serie + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "' and marca like '%" + marca + "%' and sucursal like '%" + sucursal + "%' order by num_tracto asc"), (Object[])new String[20])
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
/* 2804 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2810 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 2814 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/* 2815 */     this.rSTableMetro1.setSelectionMode(0);
/* 2816 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 2817 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2818 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 2819 */     this.rSTableMetro1.setShowVerticalLines(false);
/*      */     
/* 2821 */     eliminarColumna(7, 6, "Pago");
/*      */     
/* 2823 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 2824 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 60);
/* 2825 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 60);
/* 2826 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 6, 80);
/* 2827 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 16, 70);
/* 2828 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 17, 90);
/* 2829 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 18, 135);
/* 2830 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/* 2831 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/* 2832 */     this.jScrollPane8.setViewportView((Component)this.rSTableMetro1);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreColEliminar) {
/* 2836 */     int cont = this.rSTableMetro1.getRowCount();
/* 2837 */     String[] registros = new String[cont]; int i;
/* 2838 */     for (i = 0; i < cont; i++) {
/* 2839 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 2841 */     for (i = 0; i < cont; i++) {
/* 2842 */       registros[i] = registros[i] + " / " + registros[i];
/* 2843 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 2845 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreColEliminar);
/* 2846 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 2851 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2854 */       setEnabled((table == null || table.isEnabled()));
/* 2855 */       if (column == 0 || column == 1 || column == 6) {
/* 2856 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2858 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 2861 */       if (row % 2 == 0) {
/* 2862 */         setBackground(UnidadesTractos.this.lc.FONDOTABLA);
/*      */       } else {
/* 2864 */         setBackground((Color)null);
/*      */       } 
/* 2866 */       setForeground(UnidadesTractos.this.lc.SECUNDARIO1);
/*      */       
/* 2868 */       if (column == 9 || column == 10 || column == 11 || column == 12 || column == 13 || column == 14 || column == 15) {
/* 2869 */         setForeground(UnidadesTractos.this.lc.PRIMARIO1);
/* 2870 */         setFont(UnidadesTractos.this.fuentes.setFuente(UnidadesTractos.this.fuentes.FCentury, UnidadesTractos.this.fuentes.BOLD, 15.0F));
/*      */       } 
/*      */       
/* 2873 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2874 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender2() {
/* 2880 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2883 */       setEnabled((table == null || table.isEnabled()));
/*      */       
/* 2885 */       if (row % 2 == 0) {
/* 2886 */         setBackground(UnidadesTractos.this.lc.FONDOTABLA);
/*      */       } else {
/* 2888 */         setBackground((Color)null);
/*      */       } 
/* 2890 */       setForeground(UnidadesTractos.this.lc.SECUNDARIO1);
/* 2891 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2892 */       return this;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UnidadesTractos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */