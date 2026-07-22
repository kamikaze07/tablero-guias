/*      */ package sicret;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Insets;
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
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import principal.MaterialButton;
/*      */ 
/*      */ public class Compras extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   42 */   Date fechaActual = new Date();
/*   43 */   Date fechaInicio = null;
/*   44 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   45 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   46 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   47 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   48 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   49 */   Icon MODIFI = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/modificar.png")));
/*   50 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   51 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   52 */   JFrame padre = null;
/*   53 */   Consultas2 con = new Consultas2();
/*      */   boolean encontrado = false;
/*      */   boolean PRIMERA = false;
/*   56 */   PlaceHolder placeHolder = null;
/*   57 */   String holderFolio = "FOLIO";
/*   58 */   String holderSuPedido = "SU PEDIDO";
/*   59 */   String holderUso = "USO O DESTINO";
/*   60 */   String holderProv = "PROVEEDOR";
/*   61 */   String holderProducto = "MERCANCIA  |  PRODUCTO  |  SERVICIO";
/*   62 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   64 */   Utilerias utilerias = new Utilerias();
/*   65 */   List<Tras_codigos> CODIGOSP = null;
/*   66 */   Fuentes fuentes = new Fuentes();
/*   67 */   pintarComponentes pintar = new pintarComponentes();
/*      */   private int xx;
/*      */   private int xy;
/*      */   String[] SUCURSALES;
/*      */   String[] AREAS;
/*      */   String[] USOS;
/*   73 */   String DIRECTIVA = "";
/*   74 */   String UNIDADMED = "";
/*      */   
/*      */   String[] CONTACTOS;
/*   77 */   ArrayList TODOS_COSTOS = new ArrayList();
/*   78 */   ArrayList TODOS_PROV = new ArrayList();
/*   79 */   ArrayList TODOS_DOMICILIOS = new ArrayList();
/*   80 */   ArrayList TODOS_CIUDAD = new ArrayList();
/*   81 */   ArrayList TODOS_CONTACTOS = new ArrayList();
/*   82 */   ArrayList TODOS_USO = new ArrayList();
/*      */   
/*   84 */   TextAutoCompleter com_Costos = null;
/*   85 */   TextAutoCompleter com_Prov = null;
/*   86 */   TextAutoCompleter com_Domicilios = null;
/*   87 */   TextAutoCompleter com_Ciudad = null;
/*   88 */   TextAutoCompleter com_Contactos = null;
/*   89 */   TextAutoCompleter com_Usos = null;
/*      */   
/*   91 */   ArrayList<Proveedores> clientitos = new ArrayList<>();
/*      */   Proveedores[] proveedores;
/*   93 */   CeldaRender celda = new CeldaRender();
/*   94 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   boolean ENTRAMODIFICAR = false;
/*   96 */   String nombreArchivo = "";
/*      */   
/*   98 */   List<String> DEPARTAMENTOSTODO = new ArrayList<>();
/*   99 */   List<String> DEPARTAMENTOSVER = new ArrayList<>();
/*      */   
/*      */   boolean llenarPrimera = false;
/*  102 */   String[] porcentajes = new String[] { "PROCENTAJE", "", "", "", "", "", "", "", "", "", "", "", "", "", "" }; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private JButton jButton1; private JButton jButton15; private JButton jButton18; private JButton jButton2; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton52; private JButton jButton53; private JButton jButton54; private JButton jButton60; private JCheckBox jCheckBox1; private JComboBox<String> jComboBox1; private JComboBox<String> jComboBox10; private JComboBox<String> jComboBox2; private JComboBox jComboBox20; private JComboBox<String> jComboBox23; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox<String> jComboBox5; private JComboBox<String> jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JDateChooser jDateChooser11; private JDateChooser jDateChooser12; private JDateChooser jDateChooser6; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JEditorPane jEditorPane1; private JEditorPane jEditorPane2; private JEditorPane jEditorPane3; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField6; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel103; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel12; private JLabel jLabel125; private JLabel jLabel13; private JLabel jLabel135; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel217; private JLabel jLabel219; private JLabel jLabel22; private JLabel jLabel221; private JLabel jLabel223; private JLabel jLabel224; private JLabel jLabel23; private JLabel jLabel235; private JLabel jLabel238; private JLabel jLabel239; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel37; private JLabel jLabel39;
/*      */   private JLabel jLabel42;
/*      */   private JLabel jLabel48;
/*      */   private JLabel jLabel52;
/*      */   
/*      */   public Compras(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  108 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  109 */     this.con.setBaseDatos("sicre2PR");
/*      */     
/*  111 */     this.DEPARTAMENTOSVER.add("CONTRALORIA");
/*      */     
/*  113 */     this.DEPARTAMENTOSTODO.add("SUPER USUARIO");
/*  114 */     this.DEPARTAMENTOSTODO.add("ADMINISTRADOR");
/*  115 */     this.DEPARTAMENTOSTODO.add("RESETEOS");
/*      */     
/*  117 */     String año = "2009";
/*  118 */     String mes = "10";
/*      */     
/*  120 */     this.DIRECTIVA = this.CAMPOSGENERALES.get("directiva");
/*  121 */     String dia = "10";
/*  122 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  123 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  125 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  126 */     } catch (ParseException ex) {
/*  127 */       ex.printStackTrace();
/*      */     } 
/*  129 */     this.padre = padre;
/*  130 */     fichas = fichas;
/*  131 */     initComponents();
/*      */     
/*  133 */     this.placeHolder = new PlaceHolder(this.jTextField6, new Color(120, 120, 120), Color.BLACK, this.holderFolio, false, "Cantarell", 11);
/*  134 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(120, 120, 120), Color.BLACK, this.holderUso, false, "Cantarell", 11);
/*  135 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(120, 120, 120), Color.BLACK, this.holderProv, false, "Cantarell", 11);
/*  136 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(120, 120, 120), Color.BLACK, this.holderProducto, false, "Cantarell", 11);
/*      */     
/*  138 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  139 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  140 */     this.jLabel223.setCursor(micursor);
/*  141 */     this.jLabel103.setCursor(micursor);
/*  142 */     this.jLabel224.setCursor(micursor);
/*      */     
/*  144 */     this.USUARIO = USUARIO;
/*  145 */     panelito.setViewportView(this);
/*  146 */     this.panel = panelito;
/*      */     
/*  148 */     int w = this.tama.width;
/*  149 */     int h = this.tama.height;
/*  150 */     int rw = (w - 870) / 2;
/*  151 */     int rh = (h - 10) / 2;
/*      */     
/*  153 */     this.utilerias.activarVentanajDialog(this.jDialog1, 870, this.tama.height - 70);
/*  154 */     this.utilerias.activarVentanajDialog(this.jDialog2, 450, 450);
/*  155 */     this.utilerias.activarVentanajDialog(this.jDialog3, 400, 190);
/*  156 */     this.utilerias.activarVentanajDialog(this.jDialog4, 400, 190);
/*  157 */     this.utilerias.activarVentanajDialog(this.jDialog5, 1500, 1000);
/*      */     
/*  159 */     colorear();
/*  160 */     llenarCombos();
/*      */     
/*  162 */     for (int i = 2023; i <= this.utilerias.añoActual(); i++) {
/*  163 */       this.jComboBox2.addItem("" + i);
/*      */     }
/*  165 */     this.jComboBox1.setSelectedIndex(this.utilerias.mesActual());
/*  166 */     this.jComboBox2.setSelectedItem("" + this.utilerias.añoActual());
/*      */     
/*  168 */     consultar();
/*  169 */     cargarCatalogos();
/*      */     
/*  171 */     this.buttonGroup1.add(this.jRadioButton1);
/*  172 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  174 */     this.buttonGroup2.add(this.jRadioButton3);
/*  175 */     this.buttonGroup2.add(this.jRadioButton5);
/*      */     
/*  177 */     this.jComboBox5.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*  178 */     privilegios();
/*  179 */     autoCompletarNueva();
/*      */   }
/*      */   private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JLabel jLabel95; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel100; private JPanel jPanel105; private JPanel jPanel108; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel151; private JPanel jPanel159; private JPanel jPanel16; private JPanel jPanel168; private JPanel jPanel169; private JPanel jPanel17; private JPanel jPanel170; private JPanel jPanel171; private JPanel jPanel18; private JPanel jPanel2; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel36; private JPanel jPanel4; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel5; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel6; private JPanel jPanel61; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel81; private JPanel jPanel83;
/*      */   private JPanel jPanel84;
/*      */   private JPanel jPanel85;
/*      */   
/*      */   private void initComponents() {
/*  186 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  187 */     this.jPanel105 = new JPanel();
/*  188 */     this.jPanel54 = new JPanel();
/*  189 */     this.jLabel52 = new JLabel();
/*  190 */     this.jPanel100 = new JPanel();
/*  191 */     this.jLabel135 = new JLabel();
/*  192 */     this.jLabel60 = new JLabel();
/*  193 */     this.jLabel61 = new JLabel();
/*  194 */     this.jPanel108 = new JPanel();
/*  195 */     this.materialButton19 = new MaterialButton();
/*  196 */     this.materialButton20 = new MaterialButton();
/*  197 */     this.materialButton21 = new MaterialButton();
/*  198 */     this.jPanel1 = new JPanel();
/*  199 */     this.jPanel2 = new JPanel();
/*  200 */     this.jPanel3 = new JPanel();
/*  201 */     this.jLabel26 = new JLabel();
/*  202 */     this.jTextField4 = new JTextField();
/*  203 */     this.jLabel17 = new JLabel();
/*  204 */     this.jComboBox5 = new JComboBox<>();
/*  205 */     this.jPanel4 = new JPanel();
/*  206 */     this.jLabel27 = new JLabel();
/*  207 */     this.jTextField5 = new JTextField();
/*  208 */     this.jLabel6 = new JLabel();
/*  209 */     this.jComboBox6 = new JComboBox<>();
/*  210 */     this.jPanel5 = new JPanel();
/*  211 */     this.jPanel6 = new JPanel();
/*  212 */     this.jLabel7 = new JLabel();
/*  213 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  214 */     this.jLabel9 = new JLabel();
/*  215 */     this.jTextField8 = new JTextField();
/*  216 */     this.jLabel10 = new JLabel();
/*  217 */     this.jTextField9 = new JTextField();
/*  218 */     this.jLabel11 = new JLabel();
/*  219 */     this.jTextField10 = new JTextField();
/*  220 */     this.jPanel7 = new JPanel();
/*  221 */     this.jLabel8 = new JLabel();
/*  222 */     this.jPanel14 = new JPanel();
/*  223 */     this.jButton1 = new JButton();
/*  224 */     this.jTextField7 = new JTextField();
/*  225 */     this.jLabel12 = new JLabel();
/*  226 */     this.jTextField11 = new JTextField();
/*  227 */     this.jLabel13 = new JLabel();
/*  228 */     this.jTextField12 = new JTextField();
/*  229 */     this.jLabel14 = new JLabel();
/*  230 */     this.jTextField13 = new JTextField();
/*  231 */     this.jPanel8 = new JPanel();
/*  232 */     this.jScrollPane40 = new JScrollPane();
/*  233 */     this.rSTableMetro2 = new RSTableMetro();
/*  234 */     this.jButton52 = new JButton();
/*  235 */     this.jButton54 = new JButton();
/*  236 */     this.jButton53 = new JButton();
/*  237 */     this.jPanel80 = new JPanel();
/*  238 */     this.jPanel81 = new JPanel();
/*  239 */     this.jLabel109 = new JLabel();
/*  240 */     this.jLabel107 = new JLabel();
/*  241 */     this.jPanel83 = new JPanel();
/*  242 */     this.jLabel110 = new JLabel();
/*  243 */     this.jLabel108 = new JLabel();
/*  244 */     this.jPanel84 = new JPanel();
/*  245 */     this.jLabel111 = new JLabel();
/*  246 */     this.jLabel112 = new JLabel();
/*  247 */     this.jPanel85 = new JPanel();
/*  248 */     this.jSeparator23 = new JSeparator();
/*  249 */     this.jPanel86 = new JPanel();
/*  250 */     this.jLabel113 = new JLabel();
/*  251 */     this.jLabel114 = new JLabel();
/*  252 */     this.jLabel30 = new JLabel();
/*  253 */     this.jPanel9 = new JPanel();
/*  254 */     this.jPanel10 = new JPanel();
/*  255 */     this.jLabel15 = new JLabel();
/*  256 */     this.jRadioButton1 = new JRadioButton();
/*  257 */     this.jSlider1 = new JSlider();
/*  258 */     this.jPanel11 = new JPanel();
/*  259 */     this.jLabel16 = new JLabel();
/*  260 */     this.jRadioButton2 = new JRadioButton();
/*  261 */     this.jPanel12 = new JPanel();
/*  262 */     this.jScrollPane6 = new JScrollPane();
/*  263 */     this.jEditorPane1 = new JEditorPane();
/*  264 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  265 */     this.jPanel44 = new JPanel();
/*  266 */     this.jLabel18 = new JLabel();
/*  267 */     this.jLabel19 = new JLabel();
/*  268 */     this.jLabel20 = new JLabel();
/*  269 */     this.jLabel21 = new JLabel();
/*  270 */     this.jLabel22 = new JLabel();
/*  271 */     this.jLabel23 = new JLabel();
/*  272 */     this.jLabel24 = new JLabel();
/*  273 */     this.jLabel25 = new JLabel();
/*  274 */     this.jComboBox20 = new JComboBox();
/*  275 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  276 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  277 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  278 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  279 */     this.jCheckBox1 = new JCheckBox();
/*  280 */     this.jScrollPane2 = new JScrollPane();
/*  281 */     this.jEditorPane3 = new JEditorPane();
/*  282 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  283 */     this.jPanel15 = new JPanel();
/*  284 */     this.jButton2 = new JButton();
/*  285 */     this.jTextField14 = new JTextField();
/*  286 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  287 */     this.jLabel3 = new JLabel();
/*  288 */     this.jPanel45 = new JPanel();
/*  289 */     this.materialButton37 = new MaterialButton();
/*  290 */     this.materialButton36 = new MaterialButton();
/*  291 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  292 */     this.jPanel29 = new JPanel();
/*  293 */     this.jLabel125 = new JLabel();
/*  294 */     this.jScrollPane18 = new JScrollPane();
/*  295 */     this.jTextArea5 = new JTextArea();
/*  296 */     this.materialButton38 = new MaterialButton();
/*  297 */     this.materialButton39 = new MaterialButton();
/*  298 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  299 */     this.jPanel16 = new JPanel();
/*  300 */     this.jRadioButton5 = new JRadioButton();
/*  301 */     this.jRadioButton3 = new JRadioButton();
/*  302 */     this.materialButton46 = new MaterialButton();
/*  303 */     this.jSeparator1 = new JSeparator();
/*  304 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  305 */     this.materialButton47 = new MaterialButton();
/*  306 */     this.jPanel18 = new JPanel();
/*  307 */     this.jScrollPane3 = new JScrollPane();
/*  308 */     this.jTable1 = new JTable();
/*  309 */     this.jScrollPane4 = new JScrollPane();
/*  310 */     this.jTable2 = new JTable();
/*  311 */     this.jScrollPane5 = new JScrollPane();
/*  312 */     this.jTable3 = new JTable();
/*  313 */     this.jLabel1 = new JLabel();
/*  314 */     this.jLabel2 = new JLabel();
/*  315 */     this.jPanel13 = new JPanel();
/*  316 */     this.jLabel28 = new JLabel();
/*  317 */     this.jComboBox10 = new JComboBox<>();
/*  318 */     this.jLabel29 = new JLabel();
/*  319 */     this.buttonGroup1 = new ButtonGroup();
/*  320 */     this.jScrollPane1 = new JScrollPane();
/*  321 */     this.jEditorPane2 = new JEditorPane();
/*  322 */     this.buttonGroup2 = new ButtonGroup();
/*  323 */     this.jPanel159 = new JPanel();
/*  324 */     this.jPanel168 = new JPanel();
/*  325 */     this.jPanel17 = new JPanel();
/*  326 */     this.jComboBox23 = new JComboBox<>();
/*  327 */     this.jComboBox3 = new JComboBox();
/*  328 */     this.jTextField6 = new JTextField();
/*  329 */     this.jTextField1 = new JTextField();
/*  330 */     this.jTextField2 = new JTextField();
/*  331 */     this.jTextField3 = new JTextField();
/*  332 */     this.jComboBox7 = new JComboBox();
/*  333 */     this.jComboBox8 = new JComboBox();
/*  334 */     this.jComboBox4 = new JComboBox();
/*  335 */     this.jPanel169 = new JPanel();
/*  336 */     this.jPanel170 = new JPanel();
/*  337 */     this.jPanel171 = new JPanel();
/*  338 */     this.jLabel235 = new JLabel();
/*  339 */     this.jLabel48 = new JLabel();
/*  340 */     this.jButton24 = new JButton();
/*  341 */     this.jButton60 = new JButton();
/*  342 */     this.jButton29 = new JButton();
/*  343 */     this.jButton25 = new JButton();
/*  344 */     this.jButton18 = new JButton();
/*  345 */     this.jButton27 = new JButton();
/*  346 */     this.jButton26 = new JButton();
/*  347 */     this.jButton15 = new JButton();
/*  348 */     this.jScrollPane29 = new JScrollPane();
/*  349 */     this.rSTableMetro1 = new RSTableMetro();
/*  350 */     this.jPanel151 = new JPanel();
/*  351 */     this.jLabel217 = new JLabel();
/*  352 */     this.jLabel42 = new JLabel();
/*  353 */     this.jLabel219 = new JLabel();
/*  354 */     this.jLabel39 = new JLabel();
/*  355 */     this.jLabel221 = new JLabel();
/*  356 */     this.jLabel37 = new JLabel();
/*  357 */     this.jPanel36 = new JPanel();
/*  358 */     this.jLabel95 = new JLabel();
/*  359 */     this.jPanel55 = new JPanel();
/*  360 */     this.jPanel61 = new JPanel();
/*  361 */     this.jDateChooser11 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  362 */     this.jLabel238 = new JLabel();
/*  363 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  364 */     this.jComboBox2 = new JComboBox<>();
/*  365 */     this.jPanel63 = new JPanel();
/*  366 */     this.jButton28 = new JButton();
/*  367 */     this.jLabel223 = new JLabel();
/*  368 */     this.jLabel103 = new JLabel();
/*  369 */     this.jLabel224 = new JLabel();
/*  370 */     this.jPanel64 = new JPanel();
/*  371 */     this.jLabel239 = new JLabel();
/*  372 */     this.jComboBox1 = new JComboBox<>();
/*      */     
/*  374 */     this.jDialog1.setTitle("Crear nuevo comprobante");
/*  375 */     this.jDialog1.setModal(true);
/*  376 */     this.jDialog1.setUndecorated(true);
/*      */     
/*  378 */     this.jPanel105.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/*  380 */     this.jPanel54.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  382 */     this.jLabel52.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  383 */     this.jLabel52.setForeground(new Color(255, 255, 255));
/*  384 */     this.jLabel52.setHorizontalAlignment(0);
/*  385 */     this.jLabel52.setText("Requisición de Compra");
/*  386 */     this.jLabel52.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  388 */             Compras.this.jLabel52MouseDragged(evt);
/*      */           }
/*      */         });
/*  391 */     this.jLabel52.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  393 */             Compras.this.jLabel52MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  397 */     this.jPanel100.setBackground(this.lc.PRIMARIO1);
/*  398 */     this.jPanel100.setLayout(new GridLayout(1, 0));
/*      */     
/*  400 */     this.jLabel135.setHorizontalAlignment(0);
/*  401 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  402 */     this.jLabel135.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  404 */             Compras.this.jLabel135MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  407 */             Compras.this.jLabel135MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  410 */             Compras.this.jLabel135MouseExited(evt);
/*      */           }
/*      */         });
/*  413 */     this.jPanel100.add(this.jLabel135);
/*      */     
/*  415 */     this.jLabel60.setHorizontalAlignment(0);
/*  416 */     this.jLabel60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/menu.png")));
/*      */     
/*  418 */     this.jLabel61.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  419 */     this.jLabel61.setForeground(new Color(255, 255, 255));
/*  420 */     this.jLabel61.setHorizontalAlignment(0);
/*  421 */     this.jLabel61.setText("PR-98374");
/*  422 */     this.jLabel61.setHorizontalTextPosition(0);
/*      */     
/*  424 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/*  425 */     this.jPanel54.setLayout(jPanel54Layout);
/*  426 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/*  427 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  428 */         .addGroup(jPanel54Layout.createSequentialGroup()
/*  429 */           .addGap(1, 1, 1)
/*  430 */           .addComponent(this.jLabel60, -2, 36, -2)
/*  431 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  432 */           .addComponent(this.jLabel61, -2, 102, -2)
/*  433 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  434 */           .addComponent(this.jLabel52, -1, -1, 32767)
/*  435 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  436 */           .addComponent(this.jPanel100, -2, 34, -2)));
/*      */     
/*  438 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/*  439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  440 */         .addComponent(this.jPanel100, -1, -1, 32767)
/*  441 */         .addGroup(jPanel54Layout.createSequentialGroup()
/*  442 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  443 */             .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 30, 32767)
/*  444 */             .addComponent(this.jLabel52, -1, -1, 32767)
/*  445 */             .addComponent(this.jLabel61, -1, -1, 32767))
/*  446 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  449 */     this.jPanel108.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  451 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/*  452 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  453 */     this.materialButton19.setMnemonic('C');
/*  454 */     this.materialButton19.setText("Cerrar");
/*  455 */     this.materialButton19.setToolTipText("Cerrar (Alt+C)");
/*  456 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  457 */     this.materialButton19.setHorizontalTextPosition(0);
/*  458 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  460 */             Compras.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  464 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/*  465 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/*  466 */     this.materialButton20.setMnemonic('E');
/*  467 */     this.materialButton20.setText("Guardar");
/*  468 */     this.materialButton20.setToolTipText("Expedir CFDI (Alt+E)");
/*  469 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/*  470 */     this.materialButton20.setHorizontalTextPosition(0);
/*  471 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  473 */             Compras.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  477 */     this.materialButton21.setBackground(this.lc.PRIMARIO1);
/*  478 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  479 */     this.materialButton21.setMnemonic('E');
/*  480 */     this.materialButton21.setText("Enviar por correo");
/*  481 */     this.materialButton21.setToolTipText("Enviar por Correo CFDI (Alt+E)");
/*  482 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  483 */     this.materialButton21.setHorizontalTextPosition(0);
/*  484 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  486 */             Compras.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  490 */     GroupLayout jPanel108Layout = new GroupLayout(this.jPanel108);
/*  491 */     this.jPanel108.setLayout(jPanel108Layout);
/*  492 */     jPanel108Layout.setHorizontalGroup(jPanel108Layout
/*  493 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  494 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  495 */           .addContainerGap()
/*  496 */           .addComponent((Component)this.materialButton21, -2, 150, -2)
/*  497 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  498 */           .addComponent((Component)this.materialButton20, -2, 150, -2)
/*  499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  500 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/*  501 */           .addContainerGap()));
/*      */     
/*  503 */     jPanel108Layout.setVerticalGroup(jPanel108Layout
/*  504 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  505 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  506 */           .addGroup(jPanel108Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  507 */             .addComponent((Component)this.materialButton19, -2, 38, -2)
/*  508 */             .addComponent((Component)this.materialButton20, -2, 38, -2)
/*  509 */             .addComponent((Component)this.materialButton21, -2, 38, -2))
/*  510 */           .addGap(0, 6, 32767)));
/*      */ 
/*      */     
/*  513 */     this.jPanel2.setLayout(new GridLayout(1, 2, 24, 0));
/*      */     
/*  515 */     this.jPanel3.setLayout(new GridLayout(2, 2, 6, 6));
/*      */     
/*  517 */     this.jLabel26.setFont(new Font("SF UI Display Light", 1, 12));
/*  518 */     this.jLabel26.setText(" Folio");
/*  519 */     this.jPanel3.add(this.jLabel26);
/*      */     
/*  521 */     this.jTextField4.setText("jTextField4");
/*  522 */     this.jTextField4.setEnabled(false);
/*  523 */     this.jPanel3.add(this.jTextField4);
/*      */     
/*  525 */     this.jLabel17.setFont(new Font("SF UI Display Light", 1, 12));
/*  526 */     this.jLabel17.setText(" Sucursal");
/*  527 */     this.jPanel3.add(this.jLabel17);
/*      */     
/*  529 */     this.jComboBox5.setBackground(new Color(255, 255, 255));
/*  530 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  531 */     this.jPanel3.add(this.jComboBox5);
/*      */     
/*  533 */     this.jPanel2.add(this.jPanel3);
/*      */     
/*  535 */     this.jPanel4.setLayout(new GridLayout(2, 2, 6, 6));
/*      */     
/*  537 */     this.jLabel27.setText(" Centro de Costos");
/*  538 */     this.jPanel4.add(this.jLabel27);
/*      */     
/*  540 */     this.jTextField5.setText("jTextField5");
/*  541 */     this.jPanel4.add(this.jTextField5);
/*      */     
/*  543 */     this.jLabel6.setText(" Área");
/*  544 */     this.jPanel4.add(this.jLabel6);
/*      */     
/*  546 */     this.jComboBox6.setBackground(new Color(255, 255, 255));
/*  547 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  548 */     this.jPanel4.add(this.jComboBox6);
/*      */     
/*  550 */     this.jPanel2.add(this.jPanel4);
/*      */     
/*  552 */     this.jPanel5.setLayout(new GridLayout(1, 2, 24, 0));
/*      */     
/*  554 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(null, "[ Usuario ]", 2, 0));
/*  555 */     this.jPanel6.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/*  557 */     this.jLabel7.setFont(new Font("SF UI Display Light", 1, 12));
/*  558 */     this.jLabel7.setText(" Fecha");
/*  559 */     this.jPanel6.add(this.jLabel7);
/*      */     
/*  561 */     this.jDateChooser6.setDate(this.fechaActual);
/*  562 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  563 */     this.jDateChooser6.setEnabled(false);
/*  564 */     this.jDateChooser6.setIcon(this.icon);
/*  565 */     this.jDateChooser6.setMinSelectableDate(new Date(1257058862000L));
/*  566 */     this.jPanel6.add((Component)this.jDateChooser6);
/*      */     
/*  568 */     this.jLabel9.setFont(new Font("SF UI Display Light", 1, 12));
/*  569 */     this.jLabel9.setText(" Nombre");
/*  570 */     this.jPanel6.add(this.jLabel9);
/*      */     
/*  572 */     this.jTextField8.setText("jTextField8");
/*  573 */     this.jPanel6.add(this.jTextField8);
/*      */     
/*  575 */     this.jLabel10.setText(" Departamento");
/*  576 */     this.jPanel6.add(this.jLabel10);
/*      */     
/*  578 */     this.jTextField9.setText("jTextField9");
/*  579 */     this.jPanel6.add(this.jTextField9);
/*      */     
/*  581 */     this.jLabel11.setText("Correo electrónico");
/*  582 */     this.jPanel6.add(this.jLabel11);
/*      */     
/*  584 */     this.jTextField10.setText("jTextField10");
/*  585 */     this.jPanel6.add(this.jTextField10);
/*      */     
/*  587 */     this.jPanel5.add(this.jPanel6);
/*      */     
/*  589 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder(null, "[ Proveedor ]", 2, 0));
/*  590 */     this.jPanel7.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/*  592 */     this.jLabel8.setFont(new Font("SF UI Display Light", 1, 12));
/*  593 */     this.jLabel8.setText(" Nombre");
/*  594 */     this.jPanel7.add(this.jLabel8);
/*      */     
/*  596 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  597 */     this.jButton1.setMnemonic('F');
/*  598 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/*  599 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  601 */             Compras.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  605 */     this.jTextField7.setText("TextField7");
/*  606 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  608 */             Compras.this.jTextField7FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  612 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  613 */     this.jPanel14.setLayout(jPanel14Layout);
/*  614 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/*  615 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  616 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/*  617 */           .addComponent(this.jTextField7, -1, 161, 32767)
/*  618 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  619 */           .addComponent(this.jButton1, -2, 20, -2)));
/*      */     
/*  621 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/*  622 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  623 */         .addComponent(this.jButton1, -1, -1, 32767)
/*  624 */         .addComponent(this.jTextField7));
/*      */ 
/*      */     
/*  627 */     this.jPanel7.add(this.jPanel14);
/*      */     
/*  629 */     this.jLabel12.setText(" Dirección");
/*  630 */     this.jPanel7.add(this.jLabel12);
/*      */     
/*  632 */     this.jTextField11.setText("jTextField11");
/*  633 */     this.jTextField11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  635 */             Compras.this.jTextField11ActionPerformed(evt);
/*      */           }
/*      */         });
/*  638 */     this.jPanel7.add(this.jTextField11);
/*      */     
/*  640 */     this.jLabel13.setText(" Ciudad");
/*  641 */     this.jPanel7.add(this.jLabel13);
/*      */     
/*  643 */     this.jTextField12.setText("jTextField12");
/*  644 */     this.jPanel7.add(this.jTextField12);
/*      */     
/*  646 */     this.jLabel14.setText(" Contacto");
/*  647 */     this.jPanel7.add(this.jLabel14);
/*      */     
/*  649 */     this.jTextField13.setText("jTextField13");
/*  650 */     this.jPanel7.add(this.jTextField13);
/*      */     
/*  652 */     this.jPanel5.add(this.jPanel7);
/*      */     
/*  654 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "U / M", "Mercancía | Producto | Servicio", "Uso | Destino", "Precio U.", "Subtotal", "Iva", "Ret", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  662 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  667 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  670 */     this.rSTableMetro2.setAltoHead(25);
/*  671 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  672 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  673 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  674 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  675 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  676 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  677 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  678 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  679 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  680 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  681 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  682 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  683 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  684 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  685 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  687 */             Compras.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  690 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  692 */             Compras.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  695 */     this.jScrollPane40.setViewportView((Component)this.rSTableMetro2);
/*  696 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/*  697 */       this.rSTableMetro2.getColumnModel().getColumn(0).setResizable(false);
/*  698 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(45);
/*  699 */       this.rSTableMetro2.getColumnModel().getColumn(1).setResizable(false);
/*  700 */       this.rSTableMetro2.getColumnModel().getColumn(2).setResizable(false);
/*  701 */       this.rSTableMetro2.getColumnModel().getColumn(2).setPreferredWidth(250);
/*  702 */       this.rSTableMetro2.getColumnModel().getColumn(3).setResizable(false);
/*  703 */       this.rSTableMetro2.getColumnModel().getColumn(3).setPreferredWidth(150);
/*  704 */       this.rSTableMetro2.getColumnModel().getColumn(4).setResizable(false);
/*  705 */       this.rSTableMetro2.getColumnModel().getColumn(4).setPreferredWidth(70);
/*  706 */       this.rSTableMetro2.getColumnModel().getColumn(5).setResizable(false);
/*  707 */       this.rSTableMetro2.getColumnModel().getColumn(6).setResizable(false);
/*  708 */       this.rSTableMetro2.getColumnModel().getColumn(7).setResizable(false);
/*  709 */       this.rSTableMetro2.getColumnModel().getColumn(8).setResizable(false);
/*      */     } 
/*      */     
/*  712 */     this.jButton52.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  713 */     this.jButton52.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  715 */             Compras.this.jButton52ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  719 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  720 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  722 */             Compras.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  726 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  727 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  729 */             Compras.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  733 */     this.jPanel80.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  734 */     this.jPanel80.setLayout(new GridLayout(5, 0, 0, 6));
/*      */     
/*  736 */     this.jPanel81.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  738 */     this.jLabel109.setFont(new Font("Cantarell", 0, 13));
/*  739 */     this.jLabel109.setText(" Subtotal");
/*  740 */     this.jPanel81.add(this.jLabel109);
/*      */     
/*  742 */     this.jLabel107.setFont(new Font("Cantarell", 0, 13));
/*  743 */     this.jLabel107.setHorizontalAlignment(4);
/*  744 */     this.jLabel107.setText("jLabel107");
/*  745 */     this.jPanel81.add(this.jLabel107);
/*      */     
/*  747 */     this.jPanel80.add(this.jPanel81);
/*      */     
/*  749 */     this.jPanel83.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  751 */     this.jLabel110.setFont(new Font("Cantarell", 0, 13));
/*  752 */     this.jLabel110.setText(" Iva");
/*  753 */     this.jPanel83.add(this.jLabel110);
/*      */     
/*  755 */     this.jLabel108.setFont(new Font("Cantarell", 0, 13));
/*  756 */     this.jLabel108.setHorizontalAlignment(4);
/*  757 */     this.jLabel108.setText("jLabel108");
/*  758 */     this.jPanel83.add(this.jLabel108);
/*      */     
/*  760 */     this.jPanel80.add(this.jPanel83);
/*      */     
/*  762 */     this.jPanel84.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  764 */     this.jLabel111.setFont(new Font("Cantarell", 0, 13));
/*  765 */     this.jLabel111.setText(" Retención");
/*  766 */     this.jPanel84.add(this.jLabel111);
/*      */     
/*  768 */     this.jLabel112.setFont(new Font("Cantarell", 0, 13));
/*  769 */     this.jLabel112.setHorizontalAlignment(4);
/*  770 */     this.jLabel112.setText("Label112");
/*  771 */     this.jPanel84.add(this.jLabel112);
/*      */     
/*  773 */     this.jPanel80.add(this.jPanel84);
/*      */     
/*  775 */     this.jPanel85.setLayout(new GridLayout(1, 0));
/*  776 */     this.jPanel85.add(this.jSeparator23);
/*      */     
/*  778 */     this.jPanel80.add(this.jPanel85);
/*      */     
/*  780 */     this.jPanel86.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  782 */     this.jLabel113.setFont(new Font("Cantarell", 1, 13));
/*  783 */     this.jLabel113.setText(" Total");
/*  784 */     this.jPanel86.add(this.jLabel113);
/*      */     
/*  786 */     this.jLabel114.setFont(new Font("Cantarell", 1, 13));
/*  787 */     this.jLabel114.setHorizontalAlignment(4);
/*  788 */     this.jLabel114.setText("jLabel114");
/*  789 */     this.jPanel86.add(this.jLabel114);
/*      */     
/*  791 */     this.jPanel80.add(this.jPanel86);
/*      */     
/*  793 */     this.jLabel30.setText("100 Conceptos");
/*      */     
/*  795 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  796 */     this.jPanel8.setLayout(jPanel8Layout);
/*  797 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  798 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  799 */         .addComponent(this.jScrollPane40)
/*  800 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  801 */           .addContainerGap()
/*  802 */           .addComponent(this.jLabel30, -2, 144, -2)
/*  803 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  804 */           .addComponent(this.jButton52)
/*  805 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  806 */           .addComponent(this.jButton54)
/*  807 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  808 */           .addComponent(this.jButton53)
/*  809 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  810 */           .addComponent(this.jPanel80, -2, 252, -2)));
/*      */     
/*  812 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  813 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  814 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  815 */           .addComponent(this.jScrollPane40, -1, 140, 32767)
/*  816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  817 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  818 */             .addComponent(this.jButton52, -2, 26, -2)
/*  819 */             .addComponent(this.jButton54, -2, 26, -2)
/*  820 */             .addComponent(this.jButton53, -2, 26, -2)
/*  821 */             .addComponent(this.jPanel80, -2, -1, -2)
/*  822 */             .addComponent(this.jLabel30, -2, 29, -2))));
/*      */ 
/*      */     
/*  825 */     this.jPanel9.setLayout(new GridLayout(1, 2, 24, 0));
/*      */     
/*  827 */     this.jPanel10.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  829 */     this.jLabel15.setFont(new Font("SF UI Display Light", 1, 12));
/*  830 */     this.jLabel15.setText(" Condiciones de Pago");
/*  831 */     this.jPanel10.add(this.jLabel15);
/*      */     
/*  833 */     this.jRadioButton1.setText("Crédito");
/*  834 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  836 */             Compras.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  839 */     this.jPanel10.add(this.jRadioButton1);
/*      */     
/*  841 */     this.jSlider1.setMaximum(60);
/*  842 */     this.jSlider1.setValue(0);
/*  843 */     this.jSlider1.addChangeListener(new ChangeListener() {
/*      */           public void stateChanged(ChangeEvent evt) {
/*  845 */             Compras.this.jSlider1StateChanged(evt);
/*      */           }
/*      */         });
/*  848 */     this.jPanel10.add(this.jSlider1);
/*      */     
/*  850 */     this.jPanel9.add(this.jPanel10);
/*      */     
/*  852 */     this.jPanel11.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  854 */     this.jLabel16.setFont(new Font("SF UI Display Light", 1, 12));
/*  855 */     this.jLabel16.setText("0 días");
/*  856 */     this.jPanel11.add(this.jLabel16);
/*      */     
/*  858 */     this.jRadioButton2.setText("Contado");
/*  859 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  861 */             Compras.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  864 */     this.jPanel11.add(this.jRadioButton2);
/*      */     
/*  866 */     this.jPanel9.add(this.jPanel11);
/*      */     
/*  868 */     this.jPanel12.setBorder(BorderFactory.createTitledBorder("[ Notas o comentarios del solicitante ]"));
/*      */     
/*  870 */     this.jEditorPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/*  871 */     this.jScrollPane6.setViewportView(this.jEditorPane1);
/*      */     
/*  873 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  874 */     this.jPanel12.setLayout(jPanel12Layout);
/*  875 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  876 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  877 */         .addComponent(this.jScrollPane6, GroupLayout.Alignment.TRAILING));
/*      */     
/*  879 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  880 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  881 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  882 */           .addContainerGap()
/*  883 */           .addComponent(this.jScrollPane6, -2, 80, -2)
/*  884 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  887 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  888 */     this.jPanel1.setLayout(jPanel1Layout);
/*  889 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  890 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  891 */         .addComponent(this.jPanel2, -1, -1, 32767)
/*  892 */         .addComponent(this.jPanel5, -1, -1, 32767)
/*  893 */         .addComponent(this.jPanel8, -1, -1, 32767)
/*  894 */         .addComponent(this.jPanel9, -2, 0, 32767)
/*  895 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/*  897 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  898 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  899 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  900 */           .addContainerGap()
/*  901 */           .addComponent(this.jPanel2, -2, -1, -2)
/*  902 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  903 */           .addComponent(this.jPanel5, -2, -1, -2)
/*  904 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  905 */           .addComponent(this.jPanel8, -1, -1, 32767)
/*  906 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  907 */           .addComponent(this.jPanel9, -2, -1, -2)
/*  908 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  909 */           .addComponent(this.jPanel12, -2, -1, -2)
/*  910 */           .addContainerGap()));
/*      */ 
/*      */     
/*  913 */     GroupLayout jPanel105Layout = new GroupLayout(this.jPanel105);
/*  914 */     this.jPanel105.setLayout(jPanel105Layout);
/*  915 */     jPanel105Layout.setHorizontalGroup(jPanel105Layout
/*  916 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  917 */         .addComponent(this.jPanel108, -1, -1, 32767)
/*  918 */         .addComponent(this.jPanel54, -1, -1, 32767)
/*  919 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  921 */     jPanel105Layout.setVerticalGroup(jPanel105Layout
/*  922 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  923 */         .addGroup(jPanel105Layout.createSequentialGroup()
/*  924 */           .addComponent(this.jPanel54, -2, -1, -2)
/*  925 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  926 */           .addComponent(this.jPanel1, -1, -1, 32767)
/*  927 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  928 */           .addComponent(this.jPanel108, -2, -1, -2)));
/*      */ 
/*      */     
/*  931 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  932 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  933 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  934 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  935 */         .addGap(0, 806, 32767)
/*  936 */         .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  937 */           .addComponent(this.jPanel105, -1, -1, 32767)));
/*      */     
/*  939 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  940 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  941 */         .addGap(0, 744, 32767)
/*  942 */         .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  943 */           .addComponent(this.jPanel105, GroupLayout.Alignment.TRAILING, -1, -1, 32767)));
/*      */ 
/*      */     
/*  946 */     this.jDialog2.setTitle("Nuevo concepto");
/*  947 */     this.jDialog2.setModal(true);
/*      */     
/*  949 */     this.jPanel44.setLayout(new GridBagLayout());
/*      */     
/*  951 */     this.jLabel18.setFont(new Font("SF UI Display Light", 1, 12));
/*  952 */     this.jLabel18.setHorizontalAlignment(2);
/*  953 */     this.jLabel18.setText("Cantidad");
/*  954 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  955 */     gridBagConstraints.gridx = 0;
/*  956 */     gridBagConstraints.gridy = 0;
/*  957 */     gridBagConstraints.gridwidth = 2;
/*  958 */     gridBagConstraints.anchor = 21;
/*  959 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/*  960 */     this.jPanel44.add(this.jLabel18, gridBagConstraints);
/*      */     
/*  962 */     this.jLabel19.setFont(new Font("SF UI Display", 1, 12));
/*  963 */     this.jLabel19.setHorizontalAlignment(2);
/*  964 */     this.jLabel19.setText("Unidad de Medida");
/*  965 */     gridBagConstraints = new GridBagConstraints();
/*  966 */     gridBagConstraints.gridx = 0;
/*  967 */     gridBagConstraints.gridy = 1;
/*  968 */     gridBagConstraints.gridwidth = 2;
/*  969 */     gridBagConstraints.anchor = 21;
/*  970 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/*  971 */     this.jPanel44.add(this.jLabel19, gridBagConstraints);
/*      */     
/*  973 */     this.jLabel20.setFont(new Font("SF UI Display Light", 1, 12));
/*  974 */     this.jLabel20.setHorizontalAlignment(2);
/*  975 */     this.jLabel20.setText("Descripcion");
/*  976 */     gridBagConstraints = new GridBagConstraints();
/*  977 */     gridBagConstraints.gridx = 0;
/*  978 */     gridBagConstraints.gridy = 2;
/*  979 */     gridBagConstraints.gridwidth = 2;
/*  980 */     gridBagConstraints.anchor = 23;
/*  981 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/*  982 */     this.jPanel44.add(this.jLabel20, gridBagConstraints);
/*      */     
/*  984 */     this.jLabel21.setFont(new Font("SF UI Display Light", 1, 12));
/*  985 */     this.jLabel21.setHorizontalAlignment(2);
/*  986 */     this.jLabel21.setText("Uso o Destino");
/*  987 */     gridBagConstraints = new GridBagConstraints();
/*  988 */     gridBagConstraints.gridx = 0;
/*  989 */     gridBagConstraints.gridy = 3;
/*  990 */     gridBagConstraints.gridwidth = 2;
/*  991 */     gridBagConstraints.anchor = 21;
/*  992 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/*  993 */     this.jPanel44.add(this.jLabel21, gridBagConstraints);
/*      */     
/*  995 */     this.jLabel22.setFont(new Font("SF UI Display Light", 1, 12));
/*  996 */     this.jLabel22.setHorizontalAlignment(2);
/*  997 */     this.jLabel22.setText("Precio Unitario");
/*  998 */     gridBagConstraints = new GridBagConstraints();
/*  999 */     gridBagConstraints.gridx = 0;
/* 1000 */     gridBagConstraints.gridy = 4;
/* 1001 */     gridBagConstraints.gridwidth = 2;
/* 1002 */     gridBagConstraints.anchor = 21;
/* 1003 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1004 */     this.jPanel44.add(this.jLabel22, gridBagConstraints);
/*      */     
/* 1006 */     this.jLabel23.setFont(new Font("SF UI Display Light", 1, 12));
/* 1007 */     this.jLabel23.setHorizontalAlignment(2);
/* 1008 */     this.jLabel23.setText("Subtotal");
/* 1009 */     gridBagConstraints = new GridBagConstraints();
/* 1010 */     gridBagConstraints.gridx = 0;
/* 1011 */     gridBagConstraints.gridy = 5;
/* 1012 */     gridBagConstraints.gridwidth = 2;
/* 1013 */     gridBagConstraints.anchor = 21;
/* 1014 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1015 */     this.jPanel44.add(this.jLabel23, gridBagConstraints);
/*      */     
/* 1017 */     this.jLabel24.setFont(new Font("SF UI Display Light", 1, 12));
/* 1018 */     this.jLabel24.setHorizontalAlignment(2);
/* 1019 */     this.jLabel24.setText("Iva");
/* 1020 */     gridBagConstraints = new GridBagConstraints();
/* 1021 */     gridBagConstraints.gridx = 0;
/* 1022 */     gridBagConstraints.gridy = 6;
/* 1023 */     gridBagConstraints.anchor = 21;
/* 1024 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1025 */     this.jPanel44.add(this.jLabel24, gridBagConstraints);
/*      */     
/* 1027 */     this.jLabel25.setFont(new Font("SF UI Display Light", 1, 12));
/* 1028 */     this.jLabel25.setHorizontalAlignment(2);
/* 1029 */     this.jLabel25.setText("Total");
/* 1030 */     gridBagConstraints = new GridBagConstraints();
/* 1031 */     gridBagConstraints.gridx = 0;
/* 1032 */     gridBagConstraints.gridy = 8;
/* 1033 */     gridBagConstraints.gridwidth = 2;
/* 1034 */     gridBagConstraints.anchor = 21;
/* 1035 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1036 */     this.jPanel44.add(this.jLabel25, gridBagConstraints);
/*      */     
/* 1038 */     this.jComboBox20.setEditable(true);
/* 1039 */     this.jComboBox20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1041 */             Compras.this.jComboBox20FocusGained(evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1044 */             Compras.this.jComboBox20FocusLost(evt);
/*      */           }
/*      */         });
/* 1047 */     gridBagConstraints = new GridBagConstraints();
/* 1048 */     gridBagConstraints.gridx = 2;
/* 1049 */     gridBagConstraints.gridy = 1;
/* 1050 */     gridBagConstraints.gridwidth = 2;
/* 1051 */     gridBagConstraints.fill = 1;
/* 1052 */     gridBagConstraints.weightx = 1.0D;
/* 1053 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1054 */     this.jPanel44.add(this.jComboBox20, gridBagConstraints);
/*      */     
/* 1056 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 1057 */     this.jFormattedTextField1.setText("jFormattedTextField1");
/* 1058 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 1060 */             Compras.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/* 1063 */     gridBagConstraints = new GridBagConstraints();
/* 1064 */     gridBagConstraints.gridx = 2;
/* 1065 */     gridBagConstraints.gridy = 4;
/* 1066 */     gridBagConstraints.gridwidth = 2;
/* 1067 */     gridBagConstraints.fill = 1;
/* 1068 */     gridBagConstraints.weightx = 1.0D;
/* 1069 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1070 */     this.jPanel44.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/* 1072 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/* 1073 */     this.jFormattedTextField2.setText("jFormattedTextField2");
/* 1074 */     this.jFormattedTextField2.setEnabled(false);
/* 1075 */     gridBagConstraints = new GridBagConstraints();
/* 1076 */     gridBagConstraints.gridx = 2;
/* 1077 */     gridBagConstraints.gridy = 5;
/* 1078 */     gridBagConstraints.gridwidth = 2;
/* 1079 */     gridBagConstraints.fill = 1;
/* 1080 */     gridBagConstraints.weightx = 1.0D;
/* 1081 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1082 */     this.jPanel44.add(this.jFormattedTextField2, gridBagConstraints);
/*      */     
/* 1084 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 1085 */     this.jFormattedTextField3.setText("jFormattedTextField3");
/* 1086 */     this.jFormattedTextField3.setEnabled(false);
/* 1087 */     gridBagConstraints = new GridBagConstraints();
/* 1088 */     gridBagConstraints.gridx = 3;
/* 1089 */     gridBagConstraints.gridy = 6;
/* 1090 */     gridBagConstraints.fill = 1;
/* 1091 */     gridBagConstraints.weightx = 1.0D;
/* 1092 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1093 */     this.jPanel44.add(this.jFormattedTextField3, gridBagConstraints);
/*      */     
/* 1095 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/* 1096 */     this.jFormattedTextField4.setText("jFormattedTextField4");
/* 1097 */     this.jFormattedTextField4.setEnabled(false);
/* 1098 */     gridBagConstraints = new GridBagConstraints();
/* 1099 */     gridBagConstraints.gridx = 2;
/* 1100 */     gridBagConstraints.gridy = 8;
/* 1101 */     gridBagConstraints.gridwidth = 2;
/* 1102 */     gridBagConstraints.fill = 1;
/* 1103 */     gridBagConstraints.weightx = 1.0D;
/* 1104 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1105 */     this.jPanel44.add(this.jFormattedTextField4, gridBagConstraints);
/*      */     
/* 1107 */     this.jCheckBox1.setText("Si");
/* 1108 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1110 */             Compras.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1113 */     gridBagConstraints = new GridBagConstraints();
/* 1114 */     gridBagConstraints.gridx = 1;
/* 1115 */     gridBagConstraints.gridy = 6;
/* 1116 */     this.jPanel44.add(this.jCheckBox1, gridBagConstraints);
/*      */     
/* 1118 */     this.jEditorPane3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1120 */             Compras.this.jEditorPane3FocusGained(evt);
/*      */           }
/*      */         });
/* 1123 */     this.jScrollPane2.setViewportView(this.jEditorPane3);
/*      */     
/* 1125 */     gridBagConstraints = new GridBagConstraints();
/* 1126 */     gridBagConstraints.gridx = 2;
/* 1127 */     gridBagConstraints.gridy = 2;
/* 1128 */     gridBagConstraints.gridwidth = 2;
/* 1129 */     gridBagConstraints.fill = 1;
/* 1130 */     gridBagConstraints.weighty = 1.0D;
/* 1131 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1132 */     this.jPanel44.add(this.jScrollPane2, gridBagConstraints);
/*      */     
/* 1134 */     this.jFormattedTextField5.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/* 1135 */     this.jFormattedTextField5.setHorizontalAlignment(4);
/* 1136 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1138 */             Compras.this.jFormattedTextField5FocusGained(evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1141 */             Compras.this.jFormattedTextField5FocusLost(evt);
/*      */           }
/*      */         });
/* 1144 */     this.jFormattedTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1146 */             Compras.this.jFormattedTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1149 */     gridBagConstraints = new GridBagConstraints();
/* 1150 */     gridBagConstraints.gridx = 2;
/* 1151 */     gridBagConstraints.gridy = 0;
/* 1152 */     gridBagConstraints.gridwidth = 2;
/* 1153 */     gridBagConstraints.fill = 2;
/* 1154 */     gridBagConstraints.weightx = 1.0D;
/* 1155 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1156 */     this.jPanel44.add(this.jFormattedTextField5, gridBagConstraints);
/*      */     
/* 1158 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1159 */     this.jButton2.setMnemonic('F');
/* 1160 */     this.jButton2.setToolTipText("Filtrar información (Alt+F)");
/* 1161 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1163 */             Compras.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1167 */     this.jTextField14.setText("TextField14");
/* 1168 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 1170 */             Compras.this.jTextField14FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/* 1174 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1175 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1176 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 1177 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1178 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/* 1179 */           .addComponent(this.jTextField14, -1, 296, 32767)
/* 1180 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1181 */           .addComponent(this.jButton2, -2, 20, -2)));
/*      */     
/* 1183 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 1184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1185 */         .addComponent(this.jButton2, -1, -1, 32767)
/* 1186 */         .addComponent(this.jTextField14));
/*      */ 
/*      */     
/* 1189 */     gridBagConstraints = new GridBagConstraints();
/* 1190 */     gridBagConstraints.gridx = 2;
/* 1191 */     gridBagConstraints.gridy = 3;
/* 1192 */     gridBagConstraints.gridwidth = 2;
/* 1193 */     gridBagConstraints.fill = 1;
/* 1194 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1195 */     this.jPanel44.add(this.jPanel15, gridBagConstraints);
/*      */     
/* 1197 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/* 1198 */     this.jFormattedTextField6.setText("jFormattedTextField6");
/* 1199 */     gridBagConstraints = new GridBagConstraints();
/* 1200 */     gridBagConstraints.gridx = 2;
/* 1201 */     gridBagConstraints.gridy = 7;
/* 1202 */     gridBagConstraints.gridwidth = 2;
/* 1203 */     gridBagConstraints.fill = 2;
/* 1204 */     gridBagConstraints.insets = new Insets(0, 10, 5, 10);
/* 1205 */     this.jPanel44.add(this.jFormattedTextField6, gridBagConstraints);
/*      */     
/* 1207 */     this.jLabel3.setText("Retención");
/* 1208 */     gridBagConstraints = new GridBagConstraints();
/* 1209 */     gridBagConstraints.gridx = 0;
/* 1210 */     gridBagConstraints.gridy = 7;
/* 1211 */     gridBagConstraints.gridwidth = 2;
/* 1212 */     gridBagConstraints.fill = 2;
/* 1213 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1214 */     this.jPanel44.add(this.jLabel3, gridBagConstraints);
/*      */     
/* 1216 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1217 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1218 */     this.materialButton37.setMnemonic('A');
/* 1219 */     this.materialButton37.setText("Agregar");
/* 1220 */     this.materialButton37.setToolTipText("Agregar (Alt+A)");
/* 1221 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1222 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1223 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1225 */             Compras.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1229 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1230 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1231 */     this.materialButton36.setMnemonic('C');
/* 1232 */     this.materialButton36.setText("Cerrar");
/* 1233 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1234 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 1235 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1236 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1238 */             Compras.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1242 */     GroupLayout jPanel45Layout = new GroupLayout(this.jPanel45);
/* 1243 */     this.jPanel45.setLayout(jPanel45Layout);
/* 1244 */     jPanel45Layout.setHorizontalGroup(jPanel45Layout
/* 1245 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1246 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
/* 1247 */           .addGap(0, 0, 32767)
/* 1248 */           .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 1249 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1250 */           .addComponent((Component)this.materialButton36, -2, 105, -2)));
/*      */     
/* 1252 */     jPanel45Layout.setVerticalGroup(jPanel45Layout
/* 1253 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1254 */         .addGroup(jPanel45Layout.createSequentialGroup()
/* 1255 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1256 */             .addComponent((Component)this.materialButton37, -2, 38, -2)
/* 1257 */             .addComponent((Component)this.materialButton36, -2, 38, -2))
/* 1258 */           .addGap(0, 6, 32767)));
/*      */ 
/*      */     
/* 1261 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1262 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1263 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1264 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1265 */         .addComponent(this.jPanel44, -1, -1, 32767)
/* 1266 */         .addComponent(this.jPanel45, -1, -1, 32767));
/*      */     
/* 1268 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1269 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1270 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1271 */           .addComponent(this.jPanel44, -1, 335, 32767)
/* 1272 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1273 */           .addComponent(this.jPanel45, -2, -1, -2)));
/*      */ 
/*      */     
/* 1276 */     this.jDialog3.setTitle("Cancelar Requisición");
/* 1277 */     this.jDialog3.setModal(true);
/*      */     
/* 1279 */     this.jLabel125.setFont(new Font("Cantarell", 0, 11));
/* 1280 */     this.jLabel125.setHorizontalAlignment(4);
/* 1281 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1283 */     this.jTextArea5.setColumns(20);
/* 1284 */     this.jTextArea5.setLineWrap(true);
/* 1285 */     this.jTextArea5.setRows(5);
/* 1286 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1288 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/* 1289 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/* 1290 */     this.materialButton38.setMnemonic('C');
/* 1291 */     this.materialButton38.setText("Cerrar");
/* 1292 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/* 1293 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/* 1294 */     this.materialButton38.setHorizontalTextPosition(0);
/* 1295 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1297 */             Compras.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1301 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/* 1302 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/* 1303 */     this.materialButton39.setMnemonic('A');
/* 1304 */     this.materialButton39.setText("Cancelar");
/* 1305 */     this.materialButton39.setToolTipText("Cancelar CFDI (Alt+A)");
/* 1306 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/* 1307 */     this.materialButton39.setHorizontalTextPosition(0);
/* 1308 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1310 */             Compras.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1314 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1315 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1316 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1317 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1318 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1319 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1320 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1321 */               .addGap(0, 285, 32767)
/* 1322 */               .addComponent((Component)this.materialButton39, -2, 150, -2)
/* 1323 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1324 */               .addComponent((Component)this.materialButton38, -2, 105, -2))
/* 1325 */             .addGroup(jPanel29Layout.createSequentialGroup()
/* 1326 */               .addComponent(this.jLabel125, -2, 64, -2)
/* 1327 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1328 */               .addComponent(this.jScrollPane18, -1, 476, 32767)))
/* 1329 */           .addContainerGap()));
/*      */     
/* 1331 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1333 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1334 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1335 */             .addComponent(this.jLabel125)
/* 1336 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1337 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1338 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1339 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/* 1340 */             .addComponent((Component)this.materialButton39, -2, 38, -2))
/* 1341 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1344 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1345 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1346 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */     
/* 1350 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1352 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */ 
/*      */     
/* 1355 */     this.jDialog4.setTitle("Tipo de reporte");
/*      */     
/* 1357 */     this.jPanel16.setLayout(new GridLayout(2, 1, 6, 6));
/*      */     
/* 1359 */     this.jRadioButton5.setSelected(true);
/* 1360 */     this.jRadioButton5.setText("Bases y Áreas Anual");
/* 1361 */     this.jPanel16.add(this.jRadioButton5);
/*      */     
/* 1363 */     this.jRadioButton3.setText("Vista Actual");
/* 1364 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1366 */             Compras.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1369 */     this.jPanel16.add(this.jRadioButton3);
/*      */     
/* 1371 */     this.materialButton46.setBackground(this.lc.PRIMARIO1);
/* 1372 */     this.materialButton46.setForeground(new Color(255, 255, 255));
/* 1373 */     this.materialButton46.setMnemonic('I');
/* 1374 */     this.materialButton46.setText("Imprimir");
/* 1375 */     this.materialButton46.setToolTipText("Imprimir (Alt+I)");
/* 1376 */     this.materialButton46.setFont(new Font("Cantarell", 0, 12));
/* 1377 */     this.materialButton46.setHorizontalTextPosition(0);
/* 1378 */     this.materialButton46.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1380 */             Compras.this.materialButton46ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1384 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1385 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1386 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1387 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1388 */         .addComponent(this.jPanel16, -1, 343, 32767)
/* 1389 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 1390 */           .addContainerGap(-1, 32767)
/* 1391 */           .addComponent((Component)this.materialButton46, -2, 150, -2)
/* 1392 */           .addContainerGap())
/* 1393 */         .addComponent(this.jSeparator1));
/*      */     
/* 1395 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1396 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1397 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1398 */           .addComponent(this.jPanel16, -1, 96, 32767)
/* 1399 */           .addGap(18, 18, 18)
/* 1400 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1401 */           .addGap(3, 3, 3)
/* 1402 */           .addComponent((Component)this.materialButton46, -2, 38, -2)
/* 1403 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1406 */     this.jDialog5.setTitle("Tipo de reporte");
/*      */     
/* 1408 */     this.materialButton47.setBackground(this.lc.PRIMARIO1);
/* 1409 */     this.materialButton47.setForeground(new Color(255, 255, 255));
/* 1410 */     this.materialButton47.setMnemonic('I');
/* 1411 */     this.materialButton47.setText("Cerrar");
/* 1412 */     this.materialButton47.setToolTipText("Imprimir (Alt+I)");
/* 1413 */     this.materialButton47.setFont(new Font("Cantarell", 0, 12));
/* 1414 */     this.materialButton47.setHorizontalTextPosition(0);
/* 1415 */     this.materialButton47.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1417 */             Compras.this.materialButton47ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1421 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Base", "Area", "Mes", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1429 */     this.jScrollPane3.setViewportView(this.jTable1);
/*      */     
/* 1431 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Base", "Area", "Ene", "Feb", "Mar", "Abri", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1439 */     this.jScrollPane4.setViewportView(this.jTable2);
/*      */     
/* 1441 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Base", "Area", "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1449 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1451 */             Compras.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1454 */     this.jScrollPane5.setViewportView(this.jTable3);
/*      */     
/* 1456 */     this.jLabel1.setText("jLabel1");
/*      */     
/* 1458 */     this.jLabel2.setText("jLabel1");
/*      */     
/* 1460 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1461 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1462 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1464 */         .addComponent(this.jScrollPane3, -1, 1387, 32767)
/* 1465 */         .addComponent(this.jScrollPane5)
/* 1466 */         .addComponent(this.jScrollPane4)
/* 1467 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1468 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1469 */             .addComponent(this.jLabel1, -2, 295, -2)
/* 1470 */             .addComponent(this.jLabel2, -2, 295, -2))
/* 1471 */           .addGap(0, 0, 32767)));
/*      */     
/* 1473 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1474 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1475 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1476 */           .addComponent(this.jScrollPane3, -2, 198, -2)
/* 1477 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1478 */           .addComponent(this.jScrollPane4, -2, 230, -2)
/* 1479 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1480 */           .addComponent(this.jLabel1)
/* 1481 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1482 */           .addComponent(this.jScrollPane5, -1, 402, 32767)
/* 1483 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1484 */           .addComponent(this.jLabel2)
/* 1485 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1488 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1489 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1490 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1491 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1492 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog5Layout.createSequentialGroup()
/* 1493 */           .addContainerGap(1231, 32767)
/* 1494 */           .addComponent((Component)this.materialButton47, -2, 150, -2)
/* 1495 */           .addContainerGap())
/* 1496 */         .addComponent(this.jPanel18, -1, -1, 32767));
/*      */     
/* 1498 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1499 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1500 */         .addGroup(jDialog5Layout.createSequentialGroup()
/* 1501 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 1502 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1503 */           .addComponent((Component)this.materialButton47, -2, 38, -2)
/* 1504 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1507 */     this.jLabel28.setText("Ingresa el nuevo estado:");
/*      */     
/* 1509 */     this.jComboBox10.setBackground(Color.white);
/* 1510 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "<Por Autorizar>", "<Autorizada>" }));
/*      */     
/* 1512 */     this.jLabel29.setText("¿Estás seguro que deseas cambiar el estado de la requisición?");
/*      */     
/* 1514 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1515 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1516 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1517 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1518 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1519 */           .addComponent(this.jLabel28, -1, -1, 32767)
/* 1520 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1521 */           .addComponent(this.jComboBox10, -2, 178, -2))
/* 1522 */         .addComponent(this.jLabel29, -1, -1, 32767));
/*      */     
/* 1524 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1526 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1527 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1528 */             .addComponent(this.jComboBox10, -2, -1, -2)
/* 1529 */             .addComponent(this.jLabel28))
/* 1530 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1531 */           .addComponent(this.jLabel29)));
/*      */ 
/*      */     
/* 1534 */     this.jScrollPane1.setViewportView(this.jEditorPane2);
/*      */     
/* 1536 */     this.jPanel159.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1538 */     this.jPanel168.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1540 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 1541 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Requisiciones", 0, 1, new Font("Cantarell", 0, 11)));
/* 1542 */     this.jPanel17.setMaximumSize(new Dimension(978, 32767));
/* 1543 */     this.jPanel17.setPreferredSize(new Dimension(978, 71));
/* 1544 */     this.jPanel17.setLayout(new GridLayout(1, 9, 6, 0));
/*      */     
/* 1546 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/* 1547 */     this.jComboBox23.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL" }));
/* 1548 */     this.jComboBox23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1550 */             Compras.this.jComboBox23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1553 */     this.jPanel17.add(this.jComboBox23);
/*      */     
/* 1555 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1556 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ÁREA" }));
/* 1557 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1559 */             Compras.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1562 */     this.jPanel17.add(this.jComboBox3);
/*      */     
/* 1564 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1566 */             Compras.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1569 */     this.jPanel17.add(this.jTextField6);
/*      */     
/* 1571 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1573 */             Compras.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1576 */     this.jPanel17.add(this.jTextField1);
/*      */     
/* 1578 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1580 */             Compras.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1583 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1585 */             Compras.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1588 */     this.jPanel17.add(this.jTextField2);
/*      */     
/* 1590 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1592 */             Compras.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1595 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1597 */             Compras.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1600 */     this.jPanel17.add(this.jTextField3);
/*      */     
/* 1602 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 1603 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "CONDICIONES DE PAGO", "CRÉDITO", "CONTADO" }));
/* 1604 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1606 */             Compras.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1609 */     this.jPanel17.add(this.jComboBox7);
/*      */     
/* 1611 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 1612 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1614 */             Compras.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1617 */     this.jPanel17.add(this.jComboBox8);
/*      */     
/* 1619 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 1620 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Autorizada>", "<Por Autorizar>", "<Cancelada>" }));
/* 1621 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1623 */             Compras.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1626 */     this.jPanel17.add(this.jComboBox4);
/*      */     
/* 1628 */     this.jPanel169.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1630 */     this.jPanel170.setBackground(this.lc.SECUNDARIO2);
/* 1631 */     this.jPanel170.setLayout(new GridLayout(1, 9, 6, 0));
/*      */     
/* 1633 */     this.jPanel171.setBackground(this.lc.SECUNDARIO1);
/* 1634 */     this.jPanel171.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 1636 */     this.jLabel235.setFont(new Font("Cantarell", 0, 13));
/* 1637 */     this.jLabel235.setForeground(this.lc.TERCERO1);
/* 1638 */     this.jLabel235.setHorizontalAlignment(4);
/* 1639 */     this.jLabel235.setText("Total: ");
/* 1640 */     this.jPanel171.add(this.jLabel235);
/*      */     
/* 1642 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 1643 */     this.jLabel48.setForeground(this.lc.PRIMARIO2);
/* 1644 */     this.jLabel48.setHorizontalAlignment(0);
/* 1645 */     this.jLabel48.setText("t");
/* 1646 */     this.jPanel171.add(this.jLabel48);
/*      */     
/* 1648 */     this.jPanel170.add(this.jPanel171);
/*      */     
/* 1650 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1651 */     this.jButton24.setMnemonic('N');
/* 1652 */     this.jButton24.setText("Nueva");
/* 1653 */     this.jButton24.setToolTipText("Crear nuevas Requisiciones (Alt+N)");
/* 1654 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1656 */             Compras.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1659 */     this.jPanel170.add(this.jButton24);
/*      */     
/* 1661 */     this.jButton60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1662 */     this.jButton60.setMnemonic('M');
/* 1663 */     this.jButton60.setText("Modifcar");
/* 1664 */     this.jButton60.setToolTipText("Modificar Requisiciones (Alt+M)");
/* 1665 */     this.jButton60.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1667 */             Compras.this.jButton60ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1670 */     this.jPanel170.add(this.jButton60);
/*      */     
/* 1672 */     this.jButton29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/documentos.png")));
/* 1673 */     this.jButton29.setText("Copiar");
/* 1674 */     this.jButton29.setToolTipText("Copiar y crear una nueva");
/* 1675 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1677 */             Compras.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1680 */     this.jPanel170.add(this.jButton29);
/*      */     
/* 1682 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1683 */     this.jButton25.setMnemonic('C');
/* 1684 */     this.jButton25.setText("Cancelar");
/* 1685 */     this.jButton25.setToolTipText("Cancelar Requisiciones (Alt+C)");
/* 1686 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1688 */             Compras.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1691 */     this.jPanel170.add(this.jButton25);
/*      */     
/* 1693 */     this.jButton18.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/* 1694 */     this.jButton18.setMnemonic('A');
/* 1695 */     this.jButton18.setText("Autorizar");
/* 1696 */     this.jButton18.setToolTipText("Autorizar Requisiciones (Alt +A)");
/* 1697 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1699 */             Compras.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1702 */     this.jPanel170.add(this.jButton18);
/*      */     
/* 1704 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/exchange.png")));
/* 1705 */     this.jButton27.setMnemonic('E');
/* 1706 */     this.jButton27.setText("Cambiar Estatus");
/* 1707 */     this.jButton27.setToolTipText("Cambiar de Estatus (Alt+E)");
/* 1708 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1710 */             Compras.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1713 */     this.jPanel170.add(this.jButton27);
/*      */     
/* 1715 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1716 */     this.jButton26.setMnemonic('G');
/* 1717 */     this.jButton26.setText("Guardar Reporte");
/* 1718 */     this.jButton26.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1719 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1721 */             Compras.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1724 */     this.jPanel170.add(this.jButton26);
/*      */     
/* 1726 */     this.jButton15.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1727 */     this.jButton15.setMnemonic('I');
/* 1728 */     this.jButton15.setText("Imprimir");
/* 1729 */     this.jButton15.setToolTipText("Imprimir (Alt+I)");
/* 1730 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1732 */             Compras.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1735 */     this.jPanel170.add(this.jButton15);
/*      */     
/* 1737 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Fecha", "Proveedor", "Mercancia", "Sub", "Iva", "Total", "Condiciones", "Dias", "Estatus", "Sucursal", "Area", "Uso", "Actualizacion" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1745 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1750 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1753 */     this.rSTableMetro1.setAltoHead(40);
/* 1754 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1755 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1756 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1757 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1758 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1759 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1760 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1761 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1762 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1763 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1764 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1765 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1766 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1767 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1768 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1770 */             Compras.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1773 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1775 */             Compras.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1778 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1780 */     this.jPanel151.setBorder(BorderFactory.createBevelBorder(1));
/* 1781 */     this.jPanel151.setLayout(new GridLayout(1, 12, 6, 0));
/*      */     
/* 1783 */     this.jLabel217.setFont(new Font("Tahoma", 0, 12));
/* 1784 */     this.jLabel217.setHorizontalAlignment(4);
/* 1785 */     this.jLabel217.setText("SUBTOTAL:");
/* 1786 */     this.jPanel151.add(this.jLabel217);
/*      */     
/* 1788 */     this.jLabel42.setFont(new Font("Tahoma", 1, 12));
/* 1789 */     this.jLabel42.setHorizontalAlignment(2);
/* 1790 */     this.jLabel42.setText("subtotal");
/* 1791 */     this.jPanel151.add(this.jLabel42);
/*      */     
/* 1793 */     this.jLabel219.setFont(new Font("Tahoma", 0, 12));
/* 1794 */     this.jLabel219.setHorizontalAlignment(4);
/* 1795 */     this.jLabel219.setText("I.V.A.:");
/* 1796 */     this.jPanel151.add(this.jLabel219);
/*      */     
/* 1798 */     this.jLabel39.setFont(new Font("Tahoma", 1, 12));
/* 1799 */     this.jLabel39.setHorizontalAlignment(2);
/* 1800 */     this.jLabel39.setText("iva");
/* 1801 */     this.jPanel151.add(this.jLabel39);
/*      */     
/* 1803 */     this.jLabel221.setFont(new Font("Tahoma", 0, 12));
/* 1804 */     this.jLabel221.setHorizontalAlignment(4);
/* 1805 */     this.jLabel221.setText("TOTAL:");
/* 1806 */     this.jPanel151.add(this.jLabel221);
/*      */     
/* 1808 */     this.jLabel37.setFont(new Font("Tahoma", 1, 12));
/* 1809 */     this.jLabel37.setHorizontalAlignment(2);
/* 1810 */     this.jLabel37.setText("total");
/* 1811 */     this.jPanel151.add(this.jLabel37);
/*      */     
/* 1813 */     GroupLayout jPanel169Layout = new GroupLayout(this.jPanel169);
/* 1814 */     this.jPanel169.setLayout(jPanel169Layout);
/* 1815 */     jPanel169Layout.setHorizontalGroup(jPanel169Layout
/* 1816 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1817 */         .addComponent(this.jPanel170, -1, -1, 32767)
/* 1818 */         .addComponent(this.jPanel151, -1, -1, 32767)
/* 1819 */         .addComponent(this.jScrollPane29));
/*      */     
/* 1821 */     jPanel169Layout.setVerticalGroup(jPanel169Layout
/* 1822 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1823 */         .addGroup(jPanel169Layout.createSequentialGroup()
/* 1824 */           .addComponent(this.jPanel170, -2, 31, -2)
/* 1825 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1826 */           .addComponent(this.jScrollPane29, -1, 279, 32767)
/* 1827 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1828 */           .addComponent(this.jPanel151, -2, -1, -2)));
/*      */ 
/*      */     
/* 1831 */     GroupLayout jPanel168Layout = new GroupLayout(this.jPanel168);
/* 1832 */     this.jPanel168.setLayout(jPanel168Layout);
/* 1833 */     jPanel168Layout.setHorizontalGroup(jPanel168Layout
/* 1834 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1835 */         .addComponent(this.jPanel169, -1, -1, 32767)
/* 1836 */         .addComponent(this.jPanel17, -2, 0, 32767));
/*      */     
/* 1838 */     jPanel168Layout.setVerticalGroup(jPanel168Layout
/* 1839 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1840 */         .addGroup(jPanel168Layout.createSequentialGroup()
/* 1841 */           .addComponent(this.jPanel17, -2, 48, -2)
/* 1842 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1843 */           .addComponent(this.jPanel169, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1846 */     this.jPanel36.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1848 */     this.jLabel95.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 1849 */     this.jLabel95.setForeground(this.lc.PRIMARIO2);
/* 1850 */     this.jLabel95.setText("COMPRAS");
/*      */     
/* 1852 */     this.jPanel55.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1854 */     this.jPanel61.setBackground(this.lc.SECUNDARIO2);
/* 1855 */     this.jPanel61.setLayout(new GridBagLayout());
/*      */     
/* 1857 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1858 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/* 1859 */     this.jDateChooser11.setIcon(this.icon);
/* 1860 */     this.jDateChooser11.setMinSelectableDate(this.fechaInicio);
/* 1861 */     gridBagConstraints = new GridBagConstraints();
/* 1862 */     gridBagConstraints.gridx = 2;
/* 1863 */     gridBagConstraints.gridy = 0;
/* 1864 */     gridBagConstraints.fill = 2;
/* 1865 */     gridBagConstraints.weightx = 1.0D;
/* 1866 */     this.jPanel61.add((Component)this.jDateChooser11, gridBagConstraints);
/*      */     
/* 1868 */     this.jLabel238.setFont(new Font("Cantarell", 0, 11));
/* 1869 */     this.jLabel238.setHorizontalAlignment(0);
/* 1870 */     this.jLabel238.setText("     al     ");
/* 1871 */     gridBagConstraints = new GridBagConstraints();
/* 1872 */     gridBagConstraints.gridx = 4;
/* 1873 */     gridBagConstraints.gridy = 0;
/* 1874 */     gridBagConstraints.fill = 2;
/* 1875 */     this.jPanel61.add(this.jLabel238, gridBagConstraints);
/*      */     
/* 1877 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1878 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 1879 */     this.jDateChooser12.setIcon(this.icon);
/* 1880 */     this.jDateChooser12.setMinSelectableDate(this.fechaInicio);
/* 1881 */     gridBagConstraints = new GridBagConstraints();
/* 1882 */     gridBagConstraints.gridx = 6;
/* 1883 */     gridBagConstraints.gridy = 0;
/* 1884 */     gridBagConstraints.fill = 2;
/* 1885 */     gridBagConstraints.weightx = 1.0D;
/* 1886 */     this.jPanel61.add((Component)this.jDateChooser12, gridBagConstraints);
/*      */     
/* 1888 */     this.jComboBox2.setBackground(new Color(255, 255, 255));
/* 1889 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1891 */             Compras.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1894 */     gridBagConstraints = new GridBagConstraints();
/* 1895 */     gridBagConstraints.gridx = 0;
/* 1896 */     gridBagConstraints.gridy = 0;
/* 1897 */     this.jPanel61.add(this.jComboBox2, gridBagConstraints);
/*      */     
/* 1899 */     this.jPanel63.setBackground(this.lc.SECUNDARIO2);
/* 1900 */     this.jPanel63.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 1902 */     this.jButton28.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 1903 */     this.jButton28.setMnemonic('F');
/* 1904 */     this.jButton28.setToolTipText("Filtrar información (Alt+F)");
/* 1905 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1907 */             Compras.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1910 */     this.jPanel63.add(this.jButton28);
/*      */     
/* 1912 */     this.jLabel223.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 1913 */     this.jLabel223.setForeground(new Color(15, 87, 51));
/* 1914 */     this.jLabel223.setHorizontalAlignment(0);
/* 1915 */     this.jLabel223.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 1916 */     this.jLabel223.setToolTipText("Retroceder un día en la búsqueda");
/* 1917 */     this.jLabel223.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1919 */             Compras.this.jLabel223MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1922 */             Compras.this.jLabel223MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1925 */             Compras.this.jLabel223MouseExited(evt);
/*      */           }
/*      */         });
/* 1928 */     this.jPanel63.add(this.jLabel223);
/*      */     
/* 1930 */     this.jLabel103.setFont(new Font("Tahoma", 2, 12));
/* 1931 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 1932 */     this.jLabel103.setHorizontalAlignment(0);
/* 1933 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 1934 */     this.jLabel103.setToolTipText("Clic para filtrar los datos de HOY");
/* 1935 */     this.jLabel103.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1937 */             Compras.this.jLabel103MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1940 */             Compras.this.jLabel103MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1943 */             Compras.this.jLabel103MouseExited(evt);
/*      */           }
/*      */         });
/* 1946 */     this.jPanel63.add(this.jLabel103);
/*      */     
/* 1948 */     this.jLabel224.setHorizontalAlignment(0);
/* 1949 */     this.jLabel224.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 1950 */     this.jLabel224.setToolTipText("Aumentar un día en la búsqueda");
/* 1951 */     this.jLabel224.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1953 */             Compras.this.jLabel224MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1956 */             Compras.this.jLabel224MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1959 */             Compras.this.jLabel224MouseExited(evt);
/*      */           }
/*      */         });
/* 1962 */     this.jPanel63.add(this.jLabel224);
/*      */     
/* 1964 */     this.jPanel64.setBackground(this.lc.SECUNDARIO2);
/* 1965 */     this.jPanel64.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1967 */     this.jLabel239.setFont(new Font("Cantarell", 0, 11));
/* 1968 */     this.jLabel239.setHorizontalAlignment(4);
/* 1969 */     this.jLabel239.setText("Visualizando información de ");
/* 1970 */     this.jPanel64.add(this.jLabel239);
/*      */     
/* 1972 */     this.jComboBox1.setBackground(new Color(255, 255, 255));
/* 1973 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "PERIODO LIBRE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/* 1974 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1976 */             Compras.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1979 */     this.jPanel64.add(this.jComboBox1);
/*      */     
/* 1981 */     GroupLayout jPanel55Layout = new GroupLayout(this.jPanel55);
/* 1982 */     this.jPanel55.setLayout(jPanel55Layout);
/* 1983 */     jPanel55Layout.setHorizontalGroup(jPanel55Layout
/* 1984 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1985 */         .addGroup(jPanel55Layout.createSequentialGroup()
/* 1986 */           .addComponent(this.jPanel64, -2, -1, -2)
/* 1987 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1988 */           .addComponent(this.jPanel61, -1, -1, 32767)
/* 1989 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1990 */           .addComponent(this.jPanel63, -1, -1, 32767)
/* 1991 */           .addGap(18, 18, 18)));
/*      */     
/* 1993 */     jPanel55Layout.setVerticalGroup(jPanel55Layout
/* 1994 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1995 */         .addGroup(jPanel55Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1996 */           .addComponent(this.jPanel63, -1, -1, 32767)
/* 1997 */           .addComponent(this.jPanel61, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1998 */         .addComponent(this.jPanel64, -1, -1, 32767));
/*      */ 
/*      */     
/* 2001 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 2002 */     this.jPanel36.setLayout(jPanel36Layout);
/* 2003 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 2004 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2005 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 2006 */           .addComponent(this.jLabel95, -1, -1, 32767)
/* 2007 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2008 */           .addComponent(this.jPanel55, -1, -1, 32767)
/* 2009 */           .addContainerGap()));
/*      */     
/* 2011 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 2012 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2013 */         .addComponent(this.jLabel95, -2, 26, -2)
/* 2014 */         .addComponent(this.jPanel55, -2, -1, -2));
/*      */ 
/*      */     
/* 2017 */     GroupLayout jPanel159Layout = new GroupLayout(this.jPanel159);
/* 2018 */     this.jPanel159.setLayout(jPanel159Layout);
/* 2019 */     jPanel159Layout.setHorizontalGroup(jPanel159Layout
/* 2020 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2021 */         .addComponent(this.jPanel168, -1, -1, 32767)
/* 2022 */         .addComponent(this.jPanel36, -1, -1, 32767));
/*      */     
/* 2024 */     jPanel159Layout.setVerticalGroup(jPanel159Layout
/* 2025 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2026 */         .addGroup(jPanel159Layout.createSequentialGroup()
/* 2027 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 2028 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2029 */           .addComponent(this.jPanel168, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2032 */     GroupLayout layout = new GroupLayout(this);
/* 2033 */     setLayout(layout);
/* 2034 */     layout.setHorizontalGroup(layout
/* 2035 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2036 */         .addComponent(this.jPanel159, -1, -1, 32767));
/*      */     
/* 2038 */     layout.setVerticalGroup(layout
/* 2039 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2040 */         .addComponent(this.jPanel159, -1, -1, 32767));
/*      */   }
/*      */   private JPanel jPanel86; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton5; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane29; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane40; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JSeparator jSeparator1; private JSeparator jSeparator23; private JSlider jSlider1; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton36; private MaterialButton materialButton37; private MaterialButton materialButton38; private MaterialButton materialButton39; private MaterialButton materialButton46; private MaterialButton materialButton47; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2045 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2049 */     if (this.jComboBox4.getItemCount() > 0 && this.PRIMERA == true) {
/* 2050 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2055 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/* 2056 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2061 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 2065 */     this.utilerias.guardarTableAExcel((JTable)this.rSTableMetro1, this.USUARIO, " REQUISICIONES DE COMPRA");
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 2069 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2070 */     if (ind < 0) {
/* 2071 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una requisición para poder Cancelarla", "Selecciona una requisición", 0, this.ERROR);
/*      */     } else {
/* 2073 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10).toString();
/* 2074 */       String act = this.rSTableMetro1.getValueAt(ind, 14).toString();
/* 2075 */       if (!estatus.equals("<Por Autorizar>")) {
/* 2076 */         JOptionPane.showMessageDialog(this.padre, "Para cancelar una requisición necesita estar en estatus POR AUTORIZAR", "Selecciona otra requisición", 0, this.ERROR);
/* 2077 */       } else if (!act.contains(this.USUARIO) && this.DEPARTAMENTOSVER.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2078 */         JOptionPane.showMessageDialog(this.padre, "Por seguridad solo puedes cancelar requisiciones que han sido creadas con tu usuario", "Selecciona otra requisición", 0, this.ERROR);
/*      */       } else {
/* 2080 */         this.jTextArea5.setText("");
/* 2081 */         this.jDialog3.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2087 */     limpiar();
/* 2088 */     this.materialButton21.setVisible(false);
/* 2089 */     buscarUltimoCostos();
/* 2090 */     dameUsuario();
/* 2091 */     sacarMayor();
/* 2092 */     ActivarRequi();
/* 2093 */     if (this.DEPARTAMENTOSTODO.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2094 */       this.jDateChooser6.setEnabled(true);
/* 2095 */     } else if (this.DEPARTAMENTOSVER.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2096 */       this.jDateChooser6.setEnabled(false);
/*      */     } 
/* 2098 */     this.materialButton20.setText("Guardar");
/* 2099 */     this.materialButton20.setMnemonic('G');
/* 2100 */     this.materialButton20.setToolTipText("Guardar Requisición");
/* 2101 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton60ActionPerformed(ActionEvent evt) {
/* 2105 */     limpiar();
/* 2106 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2107 */     if (ind < 0) {
/* 2108 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar una requisición para poder Modificarla", "Selecciona una requisición", 0, this.ERROR);
/*      */     } else {
/* 2110 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10).toString();
/* 2111 */       if (!estatus.equals("<Por Autorizar>")) {
/* 2112 */         JOptionPane.showMessageDialog(this, "Para MODIFICAR una requisición necesita estar en estatus POR AUTORIZAR", "Selecciona otra requisición", 0, this.ERROR);
/*      */       } else {
/* 2114 */         this.ENTRAMODIFICAR = false;
/* 2115 */         ActivarRequi();
/* 2116 */         this.materialButton21.setVisible(false);
/* 2117 */         this.materialButton20.setText("Modificar");
/* 2118 */         this.materialButton20.setMnemonic('M');
/* 2119 */         this.materialButton20.setToolTipText("Modificar Requisición");
/* 2120 */         verRequisicion();
/* 2121 */         if (this.DEPARTAMENTOSTODO.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2122 */           this.jDateChooser6.setEnabled(true);
/* 2123 */         } else if (this.DEPARTAMENTOSVER.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2124 */           this.jDateChooser6.setEnabled(false);
/*      */         } 
/* 2126 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox23ActionPerformed(ActionEvent evt) {
/* 2132 */     if (this.jComboBox23.getItemCount() > 0 && this.PRIMERA == true) {
/* 2133 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2138 */     if (evt.getClickCount() > 1) {
/* 2139 */       desactivarRequi();
/* 2140 */       this.materialButton21.setVisible(true);
/* 2141 */       this.materialButton20.setText("Imprimir");
/* 2142 */       this.materialButton20.setMnemonic('I');
/* 2143 */       this.materialButton20.setToolTipText("Imprimir Requisición");
/* 2144 */       verRequisicion();
/* 2145 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2155 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 2159 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2160 */     if (ind < 0) {
/* 2161 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una requisición para poder Autorizarla", "Selecciona una requisición", 0, this.ERROR);
/*      */     } else {
/* 2163 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10).toString();
/* 2164 */       if (estatus.equals("<Autorizada>")) {
/* 2165 */         JOptionPane.showMessageDialog(this.padre, "La requisición que seleccionaste ya se encuentra AUTORIZADA, selecciona otra por favor.", "Selecciona otra requisición", 0, this.ERROR);
/*      */       } else {
/* 2167 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas AUTORIZAR la requisición?", "Autorizar Requisición", 0, 3, this.PREG);
/* 2168 */         if (res == 0) {
/* 2169 */           this.con.insertar("update com_requi set estatus ='<Autorizada: " + this.USUARIO + " " + this.utilerias.convertirFechaDateStringBarras(new Date()) + ">' where id_requi = '" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/* 2170 */           consultar();
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
/* 2185 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel223MouseClicked(MouseEvent evt) {
/* 2189 */     Calendar fecha = this.jDateChooser11.getCalendar();
/* 2190 */     int aa = fecha.get(1);
/* 2191 */     int mm = fecha.get(2);
/* 2192 */     int dd = fecha.get(5);
/* 2193 */     if (dd == 1) {
/* 2194 */       if (mm == 0) {
/* 2195 */         mm = 11;
/* 2196 */         aa--;
/*      */       } else {
/* 2198 */         mm--;
/*      */       } 
/* 2200 */       int diasTotal = diasDelMes(mm, aa);
/* 2201 */       dd = diasTotal;
/*      */     } else {
/* 2203 */       dd--;
/*      */     } 
/* 2205 */     mm++;
/* 2206 */     String año = "" + aa;
/* 2207 */     String mes = "" + mm;
/* 2208 */     String dia = "" + dd;
/* 2209 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2210 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2212 */       this.jDateChooser11.setDate(formatoDelTexto.parse(strFecha));
/* 2213 */       this.jDateChooser12.setDate(formatoDelTexto.parse(strFecha));
/* 2214 */     } catch (ParseException ex) {
/* 2215 */       ex.printStackTrace();
/*      */     } 
/* 2217 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel223MouseEntered(MouseEvent evt) {
/* 2221 */     this.jLabel223.setForeground(new Color(153, 255, 153));
/* 2222 */     this.jLabel223.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel223MouseExited(MouseEvent evt) {
/* 2226 */     this.jLabel223.setForeground(new Color(15, 87, 51));
/* 2227 */     this.jLabel223.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel103MouseClicked(MouseEvent evt) {
/* 2231 */     this.jDateChooser11.setDate(this.fechaActual);
/* 2232 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2233 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel103MouseEntered(MouseEvent evt) {
/* 2237 */     this.jLabel103.setForeground(new Color(153, 255, 153));
/* 2238 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel103MouseExited(MouseEvent evt) {
/* 2242 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 2243 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel224MouseClicked(MouseEvent evt) {
/* 2247 */     Calendar calendar = this.jDateChooser11.getCalendar();
/* 2248 */     calendar.setTime(this.jDateChooser12.getDate());
/* 2249 */     calendar.add(6, 1);
/* 2250 */     this.jDateChooser11.setCalendar(calendar);
/* 2251 */     this.jDateChooser12.setCalendar(calendar);
/* 2252 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel224MouseEntered(MouseEvent evt) {
/* 2256 */     this.jLabel224.setForeground(new Color(153, 255, 153));
/* 2257 */     this.jLabel224.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel224MouseExited(MouseEvent evt) {
/* 2261 */     this.jLabel224.setForeground(new Color(15, 87, 51));
/* 2262 */     this.jLabel224.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2266 */     int v = this.jComboBox1.getSelectedIndex();
/* 2267 */     if (v == 0) {
/* 2268 */       this.jDateChooser11.setEnabled(true);
/* 2269 */       this.jDateChooser12.setEnabled(true);
/* 2270 */       this.jComboBox2.setEnabled(false);
/*      */     } else {
/* 2272 */       this.jDateChooser11.setEnabled(false);
/* 2273 */       this.jDateChooser12.setEnabled(false);
/* 2274 */       this.jComboBox2.setEnabled(true);
/*      */     } 
/* 2276 */     if (this.PRIMERA) {
/* 2277 */       consultar();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2286 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2290 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2291 */     if (ind < 0) {
/* 2292 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar una requisición para cambiar el estatus", "Selecciona una requisición", 0, this.ERROR);
/*      */     } else {
/* 2294 */       this.jComboBox10.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10));
/* 2295 */       int res = JOptionPane.showConfirmDialog(this, this.jPanel13, "Cambiar de estado", 0, 3, this.PREG);
/* 2296 */       if (res == 0) {
/* 2297 */         this.con.insertar("update com_requi set estatus ='" + String.valueOf(this.jComboBox10.getSelectedItem()) + "', actualizacion = '" + this.utilerias.sacarUsuario(this.USUARIO) + "' where id_requi = '" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/* 2298 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 2304 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 2308 */     if (this.jComboBox6.getSelectedIndex() == 0) {
/* 2309 */       this.jComboBox6.setBackground(Color.RED);
/* 2310 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta seleccionar el ÁREA donde será cargada la Requisición", "Fala el Área", 0, this.ERROR);
/* 2311 */     } else if (this.jDateChooser6.getDate() == null) {
/* 2312 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar la fecha de la requisición", "Fala la fecha", 0, this.ERROR);
/* 2313 */     } else if (this.jTextField8.getText().equals("")) {
/* 2314 */       this.jTextField8.setBackground(Color.RED);
/* 2315 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar la información del Nombre", "Fala el nombre", 0, this.ERROR);
/* 2316 */     } else if (this.jTextField7.getText().equals("")) {
/* 2317 */       this.jTextField7.setBackground(Color.RED);
/* 2318 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar la información del Proveedor", "Fala el Proveedor", 0, this.ERROR);
/* 2319 */     } else if (this.jLabel114.getText().equals("$0.00")) {
/* 2320 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas agregar por lo menos un concepto", "Fala agregar conceptos", 0, this.ERROR);
/* 2321 */     } else if (this.jRadioButton1.isSelected() && this.jSlider1.getValue() == 0) {
/* 2322 */       JOptionPane.showMessageDialog(this.jDialog2, "Si seleccionas CRÉDITO, necesitas seleccionar los días de cŕedito", "Fala seleccionar los días", 0, this.ERROR);
/*      */     } else {
/* 2324 */       String productos = "";
/* 2325 */       String usos = "";
/* 2326 */       for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2327 */         productos = productos + productos + " | ";
/* 2328 */         usos = usos + usos + " | ";
/*      */       } 
/* 2330 */       String tipoPago = "CONTADO";
/* 2331 */       if (this.jRadioButton1.isSelected()) {
/* 2332 */         tipoPago = "CRÉDITO";
/*      */       }
/* 2334 */       if (this.materialButton20.getText().equals("Guardar")) {
/* 2335 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas agregar una nueva requisición?", "Agregar nueva", 0, 3, this.PREG);
/* 2336 */         if (res == 0) {
/* 2337 */           sacarMayor();
/* 2338 */           String fecha = this.utilerias.convertirFechaDateString(this.jDateChooser6.getDate());
/* 2339 */           this.con.inserSinMsj("insert into com_requi (id_requi, costos, fecha, usu_nombre, usu_depto, correo, prov_nombre, prov_dir, prov_cd, prov_contacto, productos, sub, iva, total, tipoPago, diasCredito, actualizacion, estatus, motivo, comentarios, suc_nombre, area_nombre, usos, retencion) values ('" + this.jTextField4
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2348 */               .getText() + "', '" + this.jTextField5.getText().toUpperCase() + "', '" + fecha + "', '" + this.jTextField8
/* 2349 */               .getText().toUpperCase() + "', '" + this.jTextField9.getText().toUpperCase() + "', '" + this.jTextField10.getText().toUpperCase() + "', '" + this.jTextField7
/* 2350 */               .getText().toUpperCase() + "', '" + this.jTextField11.getText().toUpperCase() + "', '" + this.jTextField12.getText().toUpperCase() + "', '" + this.jTextField13
/* 2351 */               .getText().toUpperCase() + "', '" + productos + "', '" + this.jLabel107
/* 2352 */               .getText() + "', '" + this.jLabel108.getText() + "', '" + this.jLabel114.getText() + "', '" + tipoPago + "', " + this.jSlider1
/* 2353 */               .getValue() + ", '" + this.utilerias.sacarUsuario(this.USUARIO) + "', '<Por Autorizar>', '', '" + this.jEditorPane1
/* 2354 */               .getText().toUpperCase() + "', '" + 
/* 2355 */               String.valueOf(this.jComboBox5.getSelectedItem()) + "', '" + String.valueOf(this.jComboBox6.getSelectedItem()) + "', '" + usos + "', '" + this.jLabel12.getText() + "')");
/*      */           
/* 2357 */           insertarConceptos();
/*      */           
/* 2359 */           res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas imprimir la requisición?", "Imprimir la requisición", 0, 3, this.PREG);
/* 2360 */           if (res == 0) {
/*      */             try {
/* 2362 */               imprimirRequisicion();
/* 2363 */             } catch (JRException ex) {
/* 2364 */               Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */             } 
/*      */           }
/* 2367 */           this.jDialog1.setVisible(false);
/* 2368 */           consultar();
/*      */         } 
/* 2370 */       } else if (this.materialButton20.getText().equals("Modificar")) {
/* 2371 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas modificar la requisición?", "Modificar la requisición", 0, 3, this.MODIFI);
/* 2372 */         if (res == 0) {
/* 2373 */           String fecha = this.utilerias.convertirFechaDateString(this.jDateChooser6.getDate());
/* 2374 */           this.con.inserSinMsj("update com_requi set costos = '" + this.jTextField5
/* 2375 */               .getText().toUpperCase() + "', usu_nombre = '" + this.jTextField8
/* 2376 */               .getText().toUpperCase() + "', usu_depto = '" + this.jTextField9
/* 2377 */               .getText().toUpperCase() + "', correo = '" + this.jTextField10
/* 2378 */               .getText().toUpperCase() + "', prov_nombre = '" + this.jTextField7
/* 2379 */               .getText().toUpperCase() + "', prov_dir = '" + this.jTextField11
/* 2380 */               .getText().toUpperCase() + "', prov_cd = '" + this.jTextField12
/* 2381 */               .getText().toUpperCase() + "', prov_contacto = '" + this.jTextField13
/* 2382 */               .getText().toUpperCase() + "', productos = '" + productos + "', sub = '" + this.jLabel107
/*      */               
/* 2384 */               .getText() + "', iva = '" + this.jLabel108
/* 2385 */               .getText() + "', retencion = '" + this.jLabel114
/* 2386 */               .getText() + "', total = '" + this.jLabel114
/* 2387 */               .getText() + "', tipoPago = '" + tipoPago + "', diasCredito = " + this.jSlider1
/*      */               
/* 2389 */               .getValue() + ", actualizacion = '" + this.utilerias
/* 2390 */               .sacarUsuario(this.USUARIO) + "', comentarios = '" + this.jEditorPane1
/* 2391 */               .getText().toUpperCase() + "', suc_nombre = '" + 
/* 2392 */               String.valueOf(this.jComboBox5.getSelectedItem()) + "', area_nombre = '" + 
/* 2393 */               String.valueOf(this.jComboBox6.getSelectedItem()) + "', usos = '" + usos + "', fecha = '" + fecha + "' where id_requi = '" + this.jTextField4
/*      */ 
/*      */               
/* 2396 */               .getText() + "'");
/*      */           
/* 2398 */           if (this.ENTRAMODIFICAR) {
/* 2399 */             this.con.eliminar2("com_requi_conceptos", "where id_requi = '" + this.jTextField4.getText() + "'");
/* 2400 */             insertarConceptos();
/*      */           } 
/*      */           
/* 2403 */           res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas imprimir la requisición?", "Imprimir la requisición", 0, 3, this.PREG);
/* 2404 */           if (res == 0) {
/*      */             try {
/* 2406 */               imprimirRequisicion();
/* 2407 */             } catch (JRException ex) {
/* 2408 */               Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */             } 
/*      */           }
/* 2411 */           this.jDialog1.setVisible(false);
/* 2412 */           consultar();
/*      */         } 
/* 2414 */       } else if (this.materialButton20.getText().equals("Imprimir")) {
/*      */         
/*      */         try {
/* 2417 */           imprimirRequisicion();
/*      */         }
/* 2419 */         catch (JRException ex) {
/* 2420 */           Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel52MouseDragged(MouseEvent evt) {
/* 2428 */     int x = evt.getXOnScreen();
/* 2429 */     int y = evt.getYOnScreen();
/* 2430 */     this.jDialog1.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel52MouseClicked(MouseEvent evt) {
/* 2434 */     this.xx = evt.getX();
/* 2435 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel135MouseClicked(MouseEvent evt) {
/* 2439 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel135MouseEntered(MouseEvent evt) {
/* 2443 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel135MouseExited(MouseEvent evt) {
/* 2447 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 2451 */     limpiar();
/* 2452 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2453 */     if (ind < 0) {
/* 2454 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar una requisición para poder Copiar los datos", "Selecciona una requisición", 0, this.ERROR);
/*      */     } else {
/* 2456 */       this.materialButton21.setVisible(false);
/* 2457 */       this.ENTRAMODIFICAR = false;
/* 2458 */       ActivarRequi();
/* 2459 */       verRequisicion();
/* 2460 */       this.jDateChooser6.setEnabled(true);
/* 2461 */       this.jDateChooser6.setDate(new Date());
/* 2462 */       sacarMayor();
/* 2463 */       this.materialButton20.setText("Guardar");
/* 2464 */       this.materialButton20.setMnemonic('G');
/* 2465 */       this.materialButton20.setToolTipText("Guardar Requisición");
/* 2466 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 2471 */     if (evt.getClickCount() > 1) {
/* 2472 */       int ind = this.rSTableMetro2.getSelectedRow();
/* 2473 */       this.jFormattedTextField5.setValue(Double.valueOf(Double.parseDouble(this.rSTableMetro2.getValueAt(ind, 0).toString())));
/* 2474 */       this.jComboBox20.setSelectedItem(this.rSTableMetro2.getValueAt(ind, 1));
/* 2475 */       this.jEditorPane3.setText(this.rSTableMetro2.getValueAt(ind, 2).toString());
/*      */       
/* 2477 */       this.com_Usos.removeAllItems();
/* 2478 */       this.jTextField14.setText(this.rSTableMetro2.getValueAt(ind, 3).toString());
/* 2479 */       carcarAutoCompletar();
/*      */       
/* 2481 */       this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.rSTableMetro2.getValueAt(ind, 4).toString())));
/* 2482 */       this.jFormattedTextField6.setText(this.rSTableMetro2.getValueAt(ind, 7).toString());
/* 2483 */       if (this.rSTableMetro2.getValueAt(this.rSTableMetro2.getSelectedRow(), 6).toString().equals("$0.00")) {
/* 2484 */         this.jCheckBox1.setSelected(false);
/*      */       } else {
/* 2486 */         this.jCheckBox1.setSelected(true);
/*      */       } 
/* 2488 */       calcularImporte();
/* 2489 */       this.materialButton37.setVisible(false);
/* 2490 */       this.jFormattedTextField5.setEnabled(false);
/* 2491 */       this.jFormattedTextField6.setEnabled(false);
/* 2492 */       this.jComboBox20.setEnabled(false);
/* 2493 */       this.jEditorPane3.setEditable(false);
/* 2494 */       this.jTextField14.setEnabled(false);
/* 2495 */       this.jFormattedTextField1.setEnabled(false);
/* 2496 */       this.jCheckBox1.setEnabled(false);
/* 2497 */       this.jButton2.setEnabled(false);
/* 2498 */       this.jDialog2.setTitle("Ver Concepto");
/* 2499 */       this.jDialog2.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton52ActionPerformed(ActionEvent evt) {
/* 2508 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 2509 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 2510 */     this.jEditorPane3.setText("");
/*      */     
/* 2512 */     this.jEditorPane3.setText("");
/* 2513 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2514 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2515 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 2516 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2517 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 2518 */     this.jComboBox20.setSelectedIndex(0);
/* 2519 */     this.jTextField14.setText("");
/* 2520 */     this.materialButton37.setText("Agregar");
/* 2521 */     this.materialButton37.setToolTipText("Agregar nueva partida");
/* 2522 */     this.materialButton37.setMnemonic('A');
/* 2523 */     this.jCheckBox1.setSelected(true);
/* 2524 */     this.jDialog2.setTitle("Agregar Concepto");
/*      */     
/* 2526 */     this.materialButton37.setVisible(true);
/* 2527 */     this.jFormattedTextField5.setEnabled(true);
/* 2528 */     this.jFormattedTextField6.setEnabled(true);
/* 2529 */     this.jComboBox20.setEnabled(true);
/* 2530 */     this.jEditorPane3.setEditable(true);
/* 2531 */     this.jTextField14.setEnabled(true);
/* 2532 */     this.jFormattedTextField1.setEnabled(true);
/* 2533 */     this.jCheckBox1.setEnabled(true);
/* 2534 */     this.jButton2.setEnabled(true);
/* 2535 */     this.ENTRAMODIFICAR = true;
/* 2536 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 2540 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 2541 */     if (ind < 0) {
/* 2542 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un concepto para modificar los datos", "Selecciona un concepto", 0, this.ERROR);
/*      */     } else {
/* 2544 */       this.jFormattedTextField5.setValue(Double.valueOf(Double.parseDouble(this.rSTableMetro2.getValueAt(ind, 0).toString())));
/* 2545 */       this.jComboBox20.setSelectedItem(this.rSTableMetro2.getValueAt(ind, 1));
/* 2546 */       this.jEditorPane3.setText(this.rSTableMetro2.getValueAt(ind, 2).toString());
/*      */ 
/*      */       
/* 2549 */       this.com_Usos.removeAllItems();
/* 2550 */       this.jTextField14.setText(this.rSTableMetro2.getValueAt(ind, 3).toString());
/* 2551 */       carcarAutoCompletar();
/* 2552 */       this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.rSTableMetro2.getValueAt(ind, 4).toString())));
/* 2553 */       this.jFormattedTextField6.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.rSTableMetro2.getValueAt(ind, 7).toString())));
/*      */       
/* 2555 */       calcularImporte();
/* 2556 */       this.materialButton37.setText("Modificar");
/* 2557 */       this.materialButton37.setToolTipText("Modificar la partida");
/* 2558 */       this.materialButton37.setMnemonic('M');
/* 2559 */       this.jDialog2.setTitle("Modificar Concepto");
/*      */       
/* 2561 */       this.materialButton37.setVisible(true);
/* 2562 */       this.jFormattedTextField5.setEnabled(true);
/* 2563 */       this.jFormattedTextField6.setEnabled(true);
/* 2564 */       this.jComboBox20.setEnabled(true);
/* 2565 */       this.jEditorPane3.setEditable(true);
/* 2566 */       this.jTextField14.setEnabled(true);
/* 2567 */       this.jButton2.setEnabled(true);
/* 2568 */       this.jFormattedTextField1.setEnabled(true);
/* 2569 */       if (this.rSTableMetro2.getValueAt(this.rSTableMetro2.getSelectedRow(), 6).toString().equals("$0.00")) {
/* 2570 */         this.jCheckBox1.setSelected(false);
/*      */       } else {
/* 2572 */         this.jCheckBox1.setSelected(true);
/*      */       } 
/* 2574 */       this.jCheckBox1.setEnabled(true);
/* 2575 */       this.ENTRAMODIFICAR = true;
/* 2576 */       this.jDialog2.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 2581 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 2582 */     if (ind < 0) {
/* 2583 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un concepto para eliminar los datos", "Selecciona un concepto", 0, this.ERROR);
/*      */     } else {
/* 2585 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, this.rSTableMetro2.getSelectedRow());
/* 2586 */       sumas();
/* 2587 */       this.ENTRAMODIFICAR = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jSlider1StateChanged(ChangeEvent evt) {
/* 2592 */     this.jLabel16.setText("" + this.jSlider1.getValue() + "  días");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField11ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 2600 */     this.jSlider1.setEnabled(true);
/* 2601 */     this.jLabel16.setEnabled(true);
/* 2602 */     this.jSlider1.setValue(0);
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 2606 */     this.jSlider1.setEnabled(false);
/* 2607 */     this.jLabel16.setEnabled(false);
/* 2608 */     this.jSlider1.setValue(0);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2612 */     GuiasFormCat clienteForm = new GuiasFormCat(this.jDialog1, true, "com_compras", this.jButton1);
/* 2613 */     if (clienteForm.seleccionado) {
/* 2614 */       this.jTextField7.setText(clienteForm.proveedores.getNombre());
/* 2615 */       this.jTextField11.setText(clienteForm.proveedores.getCalle() + " " + clienteForm.proveedores.getCalle() + clienteForm.proveedores.getNum());
/* 2616 */       this.jTextField12.setText(clienteForm.proveedores.getCd());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField7FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 2625 */     calcularImporte();
/* 2626 */     if (this.utilerias.convertirCantTexto(this.jFormattedTextField5.getValue().toString()) <= 0.0D) {
/* 2627 */       this.jFormattedTextField5.setBackground(Color.RED);
/* 2628 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar la cantidad", "Fala la clave", 0, this.ERROR);
/* 2629 */     } else if (this.jComboBox20.getSelectedItem().equals("")) {
/* 2630 */       this.jComboBox20.setBackground(Color.RED);
/* 2631 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar la Unidad de Medida", "Fala la Unidad de Medida", 0, this.ERROR);
/* 2632 */     } else if (this.jEditorPane3.getText().equals("")) {
/* 2633 */       this.jEditorPane3.setBackground(Color.RED);
/* 2634 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar la Descripción Interna", "Fala la Descripción", 0, this.ERROR);
/* 2635 */     } else if (this.jEditorPane3.getText().contains("'")) {
/* 2636 */       this.jEditorPane3.setBackground(Color.RED);
/* 2637 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes ingresar caracteres especiales como Apostrofe (')", "Caracteres Invalidos", 0, this.ERROR);
/* 2638 */     } else if (this.jTextField14.getText().equals("")) {
/* 2639 */       this.jTextField14.setBackground(Color.RED);
/* 2640 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar el Uso o Destino", "Fala agregar el Uso", 0, this.ERROR);
/* 2641 */     } else if (this.utilerias.convertirCantTexto(this.jFormattedTextField1.getText()) <= 0.0D) {
/* 2642 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 2643 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta agregar el precio unitario", "Fala el precio", 0, this.ERROR);
/*      */     } else {
/* 2645 */       if (this.materialButton37.getText().equals("Agregar")) {
/* 2646 */         this.utilerias.agregarCampoTablas(new String[] { this.jFormattedTextField5
/*      */               
/* 2648 */               .getText(), this.jComboBox20
/* 2649 */               .getSelectedItem().toString().toUpperCase(), this.jEditorPane3
/* 2650 */               .getText().toUpperCase(), this.jTextField14
/* 2651 */               .getText().toUpperCase(), this.jFormattedTextField1
/* 2652 */               .getText(), this.jFormattedTextField2
/* 2653 */               .getText(), this.jFormattedTextField3
/* 2654 */               .getText(), this.jFormattedTextField6
/* 2655 */               .getText(), this.jFormattedTextField4
/* 2656 */               .getText() }, (JTable)this.rSTableMetro2);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 2661 */         System.out.println("ret " + this.jFormattedTextField6.getText());
/* 2662 */         this.rSTableMetro2.setValueAt(this.jFormattedTextField5.getText(), this.rSTableMetro2.getSelectedRow(), 0);
/* 2663 */         this.rSTableMetro2.setValueAt(this.jComboBox20.getSelectedItem().toString().toUpperCase(), this.rSTableMetro2.getSelectedRow(), 1);
/* 2664 */         this.rSTableMetro2.setValueAt(this.jEditorPane3.getText().toUpperCase(), this.rSTableMetro2.getSelectedRow(), 2);
/* 2665 */         this.rSTableMetro2.setValueAt(this.jTextField14.getText().toUpperCase(), this.rSTableMetro2.getSelectedRow(), 3);
/* 2666 */         this.rSTableMetro2.setValueAt(this.jFormattedTextField1.getText(), this.rSTableMetro2.getSelectedRow(), 4);
/* 2667 */         this.rSTableMetro2.setValueAt(this.jFormattedTextField2.getText(), this.rSTableMetro2.getSelectedRow(), 5);
/* 2668 */         this.rSTableMetro2.setValueAt(this.jFormattedTextField3.getText(), this.rSTableMetro2.getSelectedRow(), 6);
/* 2669 */         this.rSTableMetro2.setValueAt(this.jFormattedTextField6.getText(), this.rSTableMetro2.getSelectedRow(), 7);
/* 2670 */         this.rSTableMetro2.setValueAt(this.jFormattedTextField4.getText(), this.rSTableMetro2.getSelectedRow(), 8);
/*      */       } 
/* 2672 */       sumas();
/* 2673 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 2678 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField5FocusGained(FocusEvent evt) {
/* 2682 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void jFormattedTextField5FocusLost(FocusEvent evt) {
/* 2686 */     calcularImporte();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jEditorPane3FocusGained(FocusEvent evt) {
/* 2694 */     calcularImporte();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox20FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox20FocusGained(FocusEvent evt) {
/* 2702 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 2706 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 2710 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 2714 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 2718 */     int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas CANCELAR la requisición?", "Cancelar Requisición", 0, 3, this.PREG);
/* 2719 */     if (res == 0) {
/* 2720 */       this.con.insertar("update com_requi set estatus ='<Cancelada>', motivo = '" + this.jTextArea5.getText().toUpperCase() + "', actualizacion ='" + this.utilerias.sacarUsuario(this.USUARIO) + "'  where id_requi = '" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/* 2721 */       this.jDialog3.setVisible(false);
/* 2722 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 2727 */     crearPDF();
/* 2728 */     String productos = "";
/* 2729 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2730 */       productos = productos + productos + " | \n";
/*      */     }
/* 2732 */     String asunto = "GRUPO FORSIS - Requisición: [" + this.jTextField4.getText().toUpperCase() + " | " + this.jTextField7.getText().toUpperCase() + " ]";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2737 */     String textoDesc = "Se adjunta el reporte completo de la requisición con Folio: " + this.jTextField4.getText() + "\n\nProveedor: " + this.jTextField7.getText().toUpperCase() + "\nDirección: " + this.jTextField11.getText().toUpperCase() + "\nMaterial, Producto o Servicio: " + productos + "\nPara el Área de: " + String.valueOf(this.jComboBox6.getSelectedItem()) + "\n";
/* 2738 */     EnviarCorreo correo = new EnviarCorreo(this.padre, asunto, textoDesc, this.USUARIO, this.nombreArchivo);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2742 */     GuiasFormCat clienteForm = new GuiasFormCat(this.jDialog2, true, "com_usos", this.jButton2);
/* 2743 */     if (clienteForm.seleccionado) {
/* 2744 */       this.jTextField14.setText(clienteForm.usos.getUso());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField14FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton46ActionPerformed(ActionEvent evt) {
/* 2753 */     if (this.jRadioButton3.isSelected()) {
/*      */       try {
/* 2755 */         this.jDialog4.setVisible(false);
/* 2756 */         imprimirVistaActual();
/*      */       }
/* 2758 */       catch (JRException ex) {
/* 2759 */         Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/* 2761 */     } else if (this.jRadioButton5.isSelected()) {
/*      */       try {
/* 2763 */         this.utilerias.vaciarTabla(this.jTable1);
/* 2764 */         this.utilerias.vaciarTabla(this.jTable2);
/* 2765 */         this.utilerias.vaciarTabla(this.jTable3);
/* 2766 */         this.porcentajes = new String[] { "", "% DE GASTOS VS FACT", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 2767 */         this.llenarPrimera = false;
/* 2768 */         imprimirReporteAnual();
/* 2769 */         this.jDialog4.setVisible(false);
/*      */         
/* 2771 */         verHojaFinal();
/*      */       }
/* 2773 */       catch (JRException ex) {
/* 2774 */         Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton47ActionPerformed(ActionEvent evt) {
/* 2784 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
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
/*      */ 
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2804 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 2808 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2812 */     consultar();
/*      */   }
/*      */   
/*      */   public void verHojaFinal() throws JRException {
/* 2816 */     Map<Object, Object> datos = new HashMap<>();
/*      */     
/* 2818 */     datos.put("titulo", "REPORTE DE GASTOS VS FACTURACIÓN " + String.valueOf(this.jComboBox2.getSelectedItem()));
/* 2819 */     this.utilerias.cargarImagenesAReporte(datos);
/* 2820 */     this.utilerias.verImpresion("/Reportes/Proveedores/Com_Rep_Anual.jasper", this.jTable3, datos, "Reporte de gastos contra Facturación  " + String.valueOf(this.jComboBox2.getSelectedItem()));
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 2824 */     if (this.DEPARTAMENTOSTODO.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2825 */       this.jButton27.setEnabled(true);
/* 2826 */     } else if (this.DEPARTAMENTOSVER.contains(this.CAMPOSGENERALES.get("priv"))) {
/* 2827 */       this.jButton27.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirReporteAnual() throws JRException {
/* 2832 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Base", "Area", "Mes", "Total" }, "suc_nombre AS 'Nombre de Sucursal',\n    area_nombre AS 'Nombre de Área',\n    CASE MONTH(fecha)\n        WHEN 1 THEN 'Ene'\n        WHEN 2 THEN 'Feb'\n        WHEN 3 THEN 'Mar'\n        WHEN 4 THEN 'Abr'\n        WHEN 5 THEN 'May'\n        WHEN 6 THEN 'Jun'\n        WHEN 7 THEN 'Jul'\n        WHEN 8 THEN 'Ago'\n        WHEN 9 THEN 'Sep'\n        WHEN 10 THEN 'Oct'\n        WHEN 11 THEN 'Nov'\n        WHEN 12 THEN 'Dic'\n    END AS 'Mes',\n    total AS 'Total'", "com_requi", "WHERE estatus != '<Cancelada>' and \n    YEAR(fecha) = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2852 */         String.valueOf(this.jComboBox2.getSelectedItem()) + "\nORDER BY \n    FIELD(MONTH(fecha), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), \n    suc_nombre,\n    area_nombre;");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2858 */     this.utilerias.pintarTablaReg(this.jTable1);
/* 2859 */     ordenarImpresionAnual();
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarEncabezadosBase(int col) {
/* 2864 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/* 2865 */     int numBase = -1;
/* 2866 */     double suma = 0.0D;
/*      */     
/* 2868 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 2869 */       Object valorColumna0 = model.getValueAt(i, 0);
/* 2870 */       if (valorColumna0 != null && !valorColumna0.toString().isEmpty()) {
/* 2871 */         numBase = i;
/* 2872 */         suma = 0.0D;
/* 2873 */         for (int j = i + 1; j < model.getRowCount(); ) {
/* 2874 */           Object valorColumnaOtra = model.getValueAt(j, col);
/* 2875 */           if (((valorColumnaOtra != null && !valorColumnaOtra.toString().isEmpty()) || !valorColumnaOtra.toString().equals("")) && valorColumnaOtra instanceof Number) {
/*      */             try {
/* 2877 */               suma += ((Number)valorColumnaOtra).doubleValue();
/* 2878 */             } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2883 */             model.setValueAt(Double.valueOf(suma), i, col);
/*      */             j++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   } public void ordenarImpresionAnual() {
/* 2890 */     this.utilerias.vaciarTabla(this.jTable2);
/* 2891 */     DefaultTableModel modeloTabla1 = (DefaultTableModel)this.jTable1.getModel();
/* 2892 */     DefaultTableModel modeloTabla2 = (DefaultTableModel)this.jTable2.getModel(); int i;
/* 2893 */     for (i = 0; i < modeloTabla1.getRowCount(); i++) {
/* 2894 */       String base = modeloTabla1.getValueAt(i, 0).toString();
/* 2895 */       String area = modeloTabla1.getValueAt(i, 1).toString();
/* 2896 */       String mes = modeloTabla1.getValueAt(i, 2).toString();
/* 2897 */       int columnaMes = obtenerIndiceMes(mes);
/* 2898 */       if (columnaMes != -1) {
/* 2899 */         Object[] fila = new Object[modeloTabla2.getColumnCount()];
/* 2900 */         fila[0] = base;
/* 2901 */         fila[1] = area;
/* 2902 */         fila[columnaMes + 2] = modeloTabla1.getValueAt(i, 3);
/* 2903 */         modeloTabla2.addRow(fila);
/*      */       } 
/*      */     } 
/* 2906 */     this.jLabel1.setText("" + this.jTable2.getRowCount());
/* 2907 */     llenarCeldasVaciasConCeros(this.jTable2);
/* 2908 */     for (i = 2; i < 14; i++) {
/* 2909 */       ordenarSegundaParte(i);
/*      */     }
/* 2911 */     calcularTotales();
/* 2912 */     agregarTotalGlobal();
/* 2913 */     insertarNombresBaseUnicos();
/*      */     
/* 2915 */     sumarBloques((DefaultTableModel)this.jTable3.getModel());
/* 2916 */     for (i = 2; i < 15; i++) {
/* 2917 */       sacarEncabezadosBase(i);
/*      */     }
/* 2919 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/*      */     
/* 2921 */     for (i = 1; i < 13; i++) {
/* 2922 */       consultarFacMes(i);
/*      */     }
/* 2924 */     sacarSumasFacturacion();
/* 2925 */     for (i = 2; i < 15; i++) {
/* 2926 */       sacarPorcentajes(i);
/*      */     }
/* 2928 */     this.utilerias.agregarCampoTablas(this.porcentajes, this.jTable3);
/* 2929 */     subirRenglonPorcentaje();
/*      */   }
/*      */   
/*      */   public void subirRenglonPorcentaje() {
/* 2933 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/* 2934 */     if (model.getRowCount() >= 2) {
/* 2935 */       int lastRow = model.getRowCount() - 1;
/* 2936 */       Object[] lastRowData = new Object[model.getColumnCount()];
/* 2937 */       for (int i = 0; i < model.getColumnCount(); i++) {
/* 2938 */         lastRowData[i] = model.getValueAt(lastRow, i);
/*      */       }
/* 2940 */       model.removeRow(lastRow);
/* 2941 */       model.insertRow(lastRow - 1, lastRowData);
/* 2942 */       this.jTable3.repaint();
/*      */     } else {
/* 2944 */       JOptionPane.showMessageDialog(null, "No hay suficientes filas para realizar la acción.", "Advertencia", 2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarPorcentajes(int mes) {
/* 2949 */     String valor1 = this.jTable3.getValueAt(this.jTable3.getRowCount() - 1, mes).toString();
/* 2950 */     String valor2 = this.jTable3.getValueAt(this.jTable3.getRowCount() - 2, mes).toString();
/* 2951 */     if (!valor1.equals("$0.0") && !valor1.equals("$0") && !valor1.equals("") && !valor2.equals("$0.0") && !valor2.equals("$0") && !valor2.equals("")) {
/*      */       
/* 2953 */       double fact = this.utilerias.convertirCantTexto(this.jTable3.getValueAt(this.jTable3.getRowCount() - 1, mes).toString());
/* 2954 */       double compras = this.utilerias.convertirCantTexto(this.jTable3.getValueAt(this.jTable3.getRowCount() - 2, mes).toString());
/* 2955 */       double porcentaje = compras / fact * 100.0D;
/* 2956 */       porcentaje = Math.round(porcentaje * 100.0D) / 100.0D;
/* 2957 */       this.porcentajes[mes] = "" + porcentaje + " %";
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarSumasFacturacion() {
/* 2962 */     double suma = 0.0D; int i;
/* 2963 */     for (i = 2; i < 14; i++) {
/* 2964 */       suma += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(this.jTable3.getRowCount() - 1, i).toString());
/*      */     }
/* 2966 */     this.jTable3.setValueAt("FACT (SIN IVA) " + String.valueOf(this.jComboBox2.getSelectedItem()), this.jTable3.getRowCount() - 1, 1);
/* 2967 */     this.jTable3.setValueAt(Double.valueOf(suma), this.jTable3.getRowCount() - 1, 14);
/*      */     
/* 2969 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 2970 */       for (int j = 2; j < this.jTable3.getColumnCount(); j++) {
/* 2971 */         String valor = this.jTable3.getValueAt(i, j).toString();
/* 2972 */         if (valor.equals("0.0") || valor.equals("0") || valor.equals("")) {
/* 2973 */           this.jTable3.setValueAt("", i, j);
/*      */         } else {
/* 2975 */           this.jTable3.setValueAt(this.utilerias.quitarDecimalesAEnteros(valor), i, j);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarFacMes(int mes) {
/* 2982 */     this.con.setBaseDatos("sicrePR");
/* 2983 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "FECHA", "TOTAL" }, "fecha, subtotal", "facturas33", "where MONTH(fecha) = " + mes + " AND YEAR(fecha) = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2988 */         String.valueOf(this.jComboBox2.getSelectedItem()) + " and  tipo = 'F'and cliente !='GRUPO NACIONAL PROVINCIAL, S.A.B.' and ( estatus='<Por Pagar>' || estatus like '%<Pagada%' || estatus like '%<Abono%' || estatus like '%<Aplicada%') and usuario like '%%' and supedido like'%%' and moneda like '%%'");
/*      */     
/* 2990 */     this.con.setBaseDatos("sicre2PR");
/*      */     
/* 2992 */     double suma = 0.0D;
/* 2993 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2994 */       suma += this.utilerias.convertirCantTexto(this.jTable1.getValueAt(i, 1).toString());
/*      */     }
/* 2996 */     this.jTable3.setValueAt(Double.valueOf(suma), this.jTable3.getRowCount() - 1, mes + 1);
/*      */   }
/*      */   
/*      */   public void sumarBloques(DefaultTableModel model) {
/* 3000 */     String baseAnterior = "";
/* 3001 */     double sumaBloque = 0.0D;
/*      */     
/* 3003 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3004 */       String baseActual = model.getValueAt(i, 0).toString();
/* 3005 */       if (!model.getValueAt(i, 2).toString().equals("")) {
/* 3006 */         double valor = Double.parseDouble(model.getValueAt(i, 2).toString());
/*      */         
/* 3008 */         if (!baseActual.equals(baseAnterior)) {
/* 3009 */           if (!baseAnterior.isEmpty()) {
/* 3010 */             model.setValueAt(Double.valueOf(sumaBloque), i - 1, 2);
/*      */           }
/* 3012 */           baseAnterior = baseActual;
/* 3013 */           sumaBloque = 0.0D;
/*      */         } 
/* 3015 */         sumaBloque += valor;
/*      */       } 
/*      */     } 
/* 3018 */     if (!baseAnterior.isEmpty()) {
/* 3019 */       model.setValueAt(Double.valueOf(sumaBloque), model.getRowCount() - 1, 2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void moverFilasVeracruzAlInicio(JTable tabla) {
/* 3024 */     DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
/* 3025 */     int rowCount = modelo.getRowCount();
/* 3026 */     int posicionInsertar = 0;
/*      */ 
/*      */     
/* 3029 */     for (int i = 0; i < rowCount; i++) {
/*      */       
/* 3031 */       String valorColumna0 = (String)modelo.getValueAt(i, 0);
/*      */ 
/*      */       
/* 3034 */       if ("VERACRUZ".equals(valorColumna0)) {
/*      */         
/* 3036 */         Object[] fila = new Object[modelo.getColumnCount()];
/* 3037 */         for (int j = 0; j < modelo.getColumnCount(); j++) {
/* 3038 */           fila[j] = modelo.getValueAt(i, j);
/*      */         }
/*      */ 
/*      */         
/* 3042 */         modelo.removeRow(i);
/* 3043 */         modelo.insertRow(posicionInsertar, fila);
/*      */ 
/*      */         
/* 3046 */         posicionInsertar++;
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
/*      */   public void insertarNombresBaseUnicos() {
/* 3093 */     moverFilasVeracruzAlInicio(this.jTable3);
/* 3094 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/*      */     
/* 3096 */     String baseAnterior = "";
/*      */     
/*      */     int i;
/* 3099 */     for (i = 0; i < model.getRowCount(); i++) {
/*      */       
/* 3101 */       String baseActual = (String)model.getValueAt(i, 0);
/*      */ 
/*      */       
/* 3104 */       if (!baseActual.equals(baseAnterior) && !baseActual.equals("GASTOS (CON IVA)")) {
/*      */         
/* 3106 */         model.insertRow(i, new Object[] { baseActual, "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
/*      */         
/* 3108 */         baseAnterior = baseActual;
/*      */         
/* 3110 */         i++;
/*      */       } 
/*      */     } 
/*      */     
/* 3114 */     for (i = 0; i < model.getRowCount(); i++) {
/* 3115 */       String area = (String)model.getValueAt(i, 1);
/*      */       
/* 3117 */       if (!area.equals("")) {
/* 3118 */         model.setValueAt("", i, 0);
/*      */       }
/*      */     } 
/*      */     
/* 3122 */     insertarRenglonVacio(this.jTable3);
/*      */   }
/*      */   
/*      */   public void insertarRenglonVacio(JTable tabla) {
/* 3126 */     DefaultTableModel model = (DefaultTableModel)tabla.getModel();
/* 3127 */     int rowCount = model.getRowCount();
/*      */ 
/*      */     
/* 3130 */     for (int i = rowCount - 1; i >= 0; i--) {
/* 3131 */       Object baseValue = model.getValueAt(i, 0);
/*      */       
/* 3133 */       if (baseValue != null && !baseValue.toString().isEmpty()) {
/*      */         
/* 3135 */         model.insertRow(i, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
/* 3136 */         model.insertRow(i, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
/*      */       } 
/*      */     } 
/* 3139 */     this.utilerias.eliminarRegTabla(this.jTable3, 0);
/* 3140 */     this.utilerias.eliminarRegTabla(this.jTable3, 0);
/*      */   }
/*      */   
/*      */   public void calcularTotales() {
/* 3144 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/* 3145 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3146 */       int total = 0;
/* 3147 */       for (int j = model.findColumn("Ene"); j <= model.findColumn("Dic"); j++) {
/* 3148 */         Object value = model.getValueAt(i, j);
/* 3149 */         if (value instanceof Number) {
/* 3150 */           total += ((Number)value).intValue();
/* 3151 */           model.setValueAt(Integer.valueOf(total), i, model.findColumn("Total"));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarTotalGlobal() {
/* 3158 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/*      */ 
/*      */     
/* 3161 */     int[] totalesPorColumna = new int[model.getColumnCount()];
/*      */ 
/*      */     
/* 3164 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3165 */       for (int k = 2; k < model.getColumnCount(); k++) {
/* 3166 */         Object value = model.getValueAt(i, k);
/* 3167 */         if (value instanceof Number) {
/* 3168 */           totalesPorColumna[k] = totalesPorColumna[k] + ((Number)value).intValue();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 3173 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/*      */     
/* 3175 */     Object[] newRowData = new Object[model.getColumnCount()];
/* 3176 */     newRowData[1] = "GASTOS (CON IVA)";
/* 3177 */     newRowData[0] = "";
/* 3178 */     for (int j = 2; j < model.getColumnCount(); j++) {
/* 3179 */       newRowData[j] = Integer.valueOf(totalesPorColumna[j]);
/*      */     }
/* 3181 */     model.addRow(newRowData);
/*      */   }
/*      */   
/*      */   public void ordenarSegundaParte(int numCol) {
/* 3185 */     DefaultTableModel model = (DefaultTableModel)this.jTable2.getModel();
/* 3186 */     Map<String, Map<String, Double>> sumasPorBaseYArea = new TreeMap<>();
/*      */     
/* 3188 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3189 */       String base = (String)model.getValueAt(i, 0);
/* 3190 */       String area = (String)model.getValueAt(i, 1);
/* 3191 */       double ene = this.utilerias.convertirCantTexto(model.getValueAt(i, numCol).toString());
/* 3192 */       if (!sumasPorBaseYArea.containsKey(base)) {
/* 3193 */         sumasPorBaseYArea.put(base, new TreeMap<>());
/*      */       }
/* 3195 */       Map<String, Double> sumasPorArea = sumasPorBaseYArea.get(base);
/* 3196 */       if (!sumasPorArea.containsKey(area)) {
/* 3197 */         sumasPorArea.put(area, Double.valueOf(0.0D));
/*      */       }
/* 3199 */       sumasPorArea.put(area, Double.valueOf(((Double)sumasPorArea.get(area)).doubleValue() + ene));
/*      */     } 
/*      */     
/* 3202 */     if (!this.llenarPrimera) {
/* 3203 */       this.llenarPrimera = true;
/* 3204 */       for (String base : sumasPorBaseYArea.keySet()) {
/* 3205 */         Map<String, Double> sumasPorArea = sumasPorBaseYArea.get(base);
/* 3206 */         for (String area : sumasPorArea.keySet()) {
/* 3207 */           agregarBaseArea(base, area);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3213 */     for (String base : sumasPorBaseYArea.keySet()) {
/* 3214 */       Map<String, Double> sumasPorArea = sumasPorBaseYArea.get(base);
/* 3215 */       for (String area : sumasPorArea.keySet()) {
/* 3216 */         Double suma = sumasPorArea.get(area);
/* 3217 */         DefaultTableModel modelNueva = (DefaultTableModel)this.jTable3.getModel();
/* 3218 */         for (int j = 0; j < modelNueva.getRowCount(); j++) {
/* 3219 */           Object baseN = modelNueva.getValueAt(j, 0);
/* 3220 */           Object areaN = modelNueva.getValueAt(j, 1);
/* 3221 */           if (baseN.toString().equals(base) && areaN.equals(area)) {
/* 3222 */             modelNueva.setValueAt(suma, j, numCol);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCeldasVaciasConCeros(JTable jTable2) {
/* 3230 */     DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
/* 3231 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3232 */       for (int j = 0; j < model.getColumnCount(); j++) {
/* 3233 */         Object valor = model.getValueAt(i, j);
/* 3234 */         if (valor == null || valor.toString().isEmpty()) {
/* 3235 */           model.setValueAt(Integer.valueOf(0), i, j);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarBaseArea(String Base, String Area) {
/* 3242 */     this.utilerias.agregarCampoTablas(new String[] { Base, Area, "", "", "", "", "", "", "", "", "", "", "", "", "" }, this.jTable3);
/*      */   }
/*      */ 
/*      */   
/*      */   private int obtenerIndiceMes(String mes) {
/* 3247 */     String[] meses = { "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" };
/* 3248 */     for (int i = 0; i < meses.length; i++) {
/* 3249 */       if (meses[i].equals(mes)) {
/* 3250 */         return i;
/*      */       }
/*      */     } 
/* 3253 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public JTable crearTablaAux2(JTable tabla) {
/* 3258 */     DefaultTableModel modeloTablaAux = new DefaultTableModel();
/*      */ 
/*      */     
/* 3261 */     modeloTablaAux.addColumn("cont");
/* 3262 */     modeloTablaAux.addColumn("ID");
/* 3263 */     modeloTablaAux.addColumn("Fecha");
/* 3264 */     modeloTablaAux.addColumn("Proveedor");
/* 3265 */     modeloTablaAux.addColumn("Mercancia");
/* 3266 */     modeloTablaAux.addColumn("Sub");
/* 3267 */     modeloTablaAux.addColumn("Iva");
/* 3268 */     modeloTablaAux.addColumn("Total");
/* 3269 */     modeloTablaAux.addColumn("Suc");
/* 3270 */     modeloTablaAux.addColumn("Area");
/*      */ 
/*      */ 
/*      */     
/* 3274 */     DefaultTableModel modeloTablaExistente = (DefaultTableModel)tabla.getModel();
/*      */ 
/*      */     
/* 3277 */     for (int i = 0; i < modeloTablaExistente.getRowCount(); i++) {
/* 3278 */       Object[] fila = new Object[10];
/*      */ 
/*      */       
/* 3281 */       fila[0] = Integer.valueOf(i + 1);
/*      */ 
/*      */       
/* 3284 */       fila[1] = modeloTablaExistente.getValueAt(i, 0);
/* 3285 */       fila[2] = modeloTablaExistente.getValueAt(i, 1);
/* 3286 */       fila[3] = modeloTablaExistente.getValueAt(i, 3);
/* 3287 */       fila[4] = modeloTablaExistente.getValueAt(i, 4);
/* 3288 */       fila[5] = modeloTablaExistente.getValueAt(i, 5);
/* 3289 */       fila[6] = modeloTablaExistente.getValueAt(i, 6);
/* 3290 */       fila[7] = modeloTablaExistente.getValueAt(i, 7);
/* 3291 */       fila[8] = modeloTablaExistente.getValueAt(i, 11);
/* 3292 */       fila[9] = modeloTablaExistente.getValueAt(i, 12);
/*      */ 
/*      */ 
/*      */       
/* 3296 */       modeloTablaAux.addRow(fila);
/*      */     } 
/*      */ 
/*      */     
/* 3300 */     JTable tablaAux = new JTable();
/* 3301 */     tablaAux.setModel(modeloTablaAux);
/*      */     
/* 3303 */     return tablaAux;
/*      */   }
/*      */   
/*      */   public void imprimirVistaActual() throws JRException {
/* 3307 */     JTable aux = crearTablaAux2((JTable)this.rSTableMetro1);
/* 3308 */     Map<Object, Object> datos = new HashMap<>();
/* 3309 */     String fechaCompleta = "";
/*      */     
/* 3311 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3312 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3313 */       String cadenaFecha1 = formato.format(this.jDateChooser11.getDate());
/* 3314 */       String año = cadenaFecha1.substring(0, 4);
/* 3315 */       String mes = cadenaFecha1.substring(4, 6);
/* 3316 */       String dia = cadenaFecha1.substring(6, 8);
/* 3317 */       fechaCompleta = dia + "/" + dia + "/" + mes;
/* 3318 */       cadenaFecha1 = formato.format(this.jDateChooser12.getDate());
/* 3319 */       año = cadenaFecha1.substring(0, 4);
/* 3320 */       mes = cadenaFecha1.substring(4, 6);
/* 3321 */       dia = cadenaFecha1.substring(6, 8);
/* 3322 */       fechaCompleta = fechaCompleta + " AL " + fechaCompleta + "/" + dia + "/" + mes;
/*      */     } else {
/* 3324 */       fechaCompleta = String.valueOf(this.jComboBox1.getSelectedItem()) + "/" + String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     } 
/*      */     
/* 3327 */     String AREA = "TODAS";
/* 3328 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3329 */       AREA = this.jComboBox3.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3332 */     String SUC = "TODAS";
/* 3333 */     if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3334 */       SUC = this.jComboBox23.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3337 */     String uso = "TODOS";
/* 3338 */     if (!this.jTextField1.getText().equals(this.holderUso)) {
/* 3339 */       uso = this.jTextField1.getText().toUpperCase();
/*      */     }
/*      */     
/* 3342 */     String proveedor = "TODOS";
/* 3343 */     if (!this.jTextField2.getText().equals(this.holderProv)) {
/* 3344 */       proveedor = this.jTextField2.getText().toUpperCase();
/*      */     }
/*      */     
/* 3347 */     String mercancias = "TODAS";
/* 3348 */     if (!this.jTextField3.getText().equals(this.holderProducto)) {
/* 3349 */       mercancias = this.jTextField3.getText().toUpperCase();
/*      */     }
/*      */     
/* 3352 */     datos.put("sucursal", SUC);
/* 3353 */     datos.put("area", AREA);
/* 3354 */     datos.put("uso", uso);
/* 3355 */     datos.put("proveedor", proveedor);
/* 3356 */     datos.put("mercancias", mercancias);
/* 3357 */     datos.put("fecha", fechaCompleta);
/*      */     
/* 3359 */     datos.put("TSubtotal", this.jLabel42.getText());
/* 3360 */     datos.put("TIva", this.jLabel39.getText());
/* 3361 */     datos.put("TTotal", this.jLabel37.getText());
/*      */     
/* 3363 */     this.utilerias.cargarImagenesAReporte(datos);
/* 3364 */     this.utilerias.verImpresion("/Reportes/Proveedores/Com_Rep_VistaGral.jasper", aux, datos, "Vista General");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void crearPDF() {
/* 3370 */     JTable aux = crearTablaAux((JTable)this.rSTableMetro2);
/* 3371 */     Map<Object, Object> datos = new HashMap<>();
/*      */     
/* 3373 */     datos.put("folio", this.jTextField4.getText());
/* 3374 */     datos.put("costos", this.jTextField5.getText().toUpperCase());
/* 3375 */     datos.put("sucursal", this.jComboBox5.getSelectedItem());
/* 3376 */     datos.put("area", this.jComboBox6.getSelectedItem());
/*      */     
/* 3378 */     datos.put("usu_fecha", this.utilerias.convertirFechaDateStringBarras(this.jDateChooser6.getDate()));
/* 3379 */     datos.put("usu_nombre", this.jTextField8.getText().toUpperCase());
/* 3380 */     datos.put("usu_depto", this.jTextField9.getText().toUpperCase());
/* 3381 */     datos.put("usu_correo", this.jTextField10.getText().toUpperCase());
/*      */     
/* 3383 */     datos.put("prov_nombre", this.jTextField7.getText().toUpperCase());
/* 3384 */     datos.put("prov_dir", this.jTextField11.getText().toUpperCase());
/* 3385 */     datos.put("prov_cd", this.jTextField12.getText().toUpperCase());
/* 3386 */     datos.put("prov_contacto", this.jTextField13.getText().toUpperCase());
/*      */     
/* 3388 */     datos.put("TSub", this.jLabel107.getText());
/* 3389 */     datos.put("TIva", this.jLabel108.getText());
/* 3390 */     datos.put("TRet", this.jLabel112.getText());
/* 3391 */     datos.put("TTotal", this.jLabel114.getText());
/*      */     
/* 3393 */     String CONDICIONES = "CRÉDITO";
/*      */     
/* 3395 */     String DIAS = "" + this.jSlider1.getValue() + " DÍAS";
/* 3396 */     if (this.jRadioButton2.isSelected()) {
/* 3397 */       CONDICIONES = "CONTADO";
/* 3398 */       DIAS = "";
/*      */     } 
/*      */     
/* 3401 */     datos.put("comentarios", this.jEditorPane1.getText().toUpperCase());
/* 3402 */     datos.put("condiciones", CONDICIONES);
/* 3403 */     datos.put("dias", DIAS);
/*      */     
/* 3405 */     this.nombreArchivo = "Requisición_" + this.jTextField4.getText() + ".pdf";
/* 3406 */     this.utilerias.cargarImagenesAReporte(datos);
/*      */     try {
/* 3408 */       this.utilerias.crearPDF("/Reportes/Proveedores/Com_Requisicion.jasper", aux, datos, this.nombreArchivo);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 3413 */     catch (JRException ex) {
/* 3414 */       Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirRequisicion() throws JRException {
/* 3419 */     JTable aux = crearTablaAux((JTable)this.rSTableMetro2);
/* 3420 */     Map<Object, Object> datos = new HashMap<>();
/*      */     
/* 3422 */     datos.put("folio", this.jTextField4.getText());
/* 3423 */     datos.put("costos", this.jTextField5.getText().toUpperCase());
/* 3424 */     datos.put("sucursal", this.jComboBox5.getSelectedItem());
/* 3425 */     datos.put("area", this.jComboBox6.getSelectedItem());
/*      */     
/* 3427 */     datos.put("usu_fecha", this.utilerias.convertirFechaDateStringBarras(this.jDateChooser6.getDate()));
/* 3428 */     datos.put("usu_nombre", this.jTextField8.getText().toUpperCase());
/* 3429 */     datos.put("usu_depto", this.jTextField9.getText().toUpperCase());
/* 3430 */     datos.put("usu_correo", this.jTextField10.getText().toUpperCase());
/*      */     
/* 3432 */     datos.put("prov_nombre", this.jTextField7.getText().toUpperCase());
/* 3433 */     datos.put("prov_dir", this.jTextField11.getText().toUpperCase());
/* 3434 */     datos.put("prov_cd", this.jTextField12.getText().toUpperCase());
/* 3435 */     datos.put("prov_contacto", this.jTextField13.getText().toUpperCase());
/*      */     
/* 3437 */     datos.put("TSub", this.jLabel107.getText());
/* 3438 */     datos.put("TIva", this.jLabel108.getText());
/* 3439 */     datos.put("TRet", this.jLabel112.getText());
/* 3440 */     datos.put("TTotal", this.jLabel114.getText());
/*      */     
/* 3442 */     ImageIcon forsis = this.utilerias.dameLogos("forsis");
/* 3443 */     datos.put("forsis", forsis);
/*      */     
/* 3445 */     String CONDICIONES = "CRÉDITO";
/*      */     
/* 3447 */     String DIAS = "" + this.jSlider1.getValue() + " DÍAS";
/* 3448 */     if (this.jRadioButton2.isSelected()) {
/* 3449 */       CONDICIONES = "CONTADO";
/* 3450 */       DIAS = "";
/*      */     } 
/*      */     
/* 3453 */     datos.put("comentarios", this.jEditorPane1.getText().toUpperCase());
/* 3454 */     datos.put("condiciones", CONDICIONES);
/* 3455 */     datos.put("dias", DIAS);
/*      */     
/* 3457 */     this.utilerias.verImpresion("/Reportes/Proveedores/Com_Requisicion.jasper", aux, datos, "Requisición " + this.jTextField4.getText());
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
/*      */   public JTable crearTablaAux(JTable Tabla) {
/* 3471 */     DefaultTableModel modeloOriginal = (DefaultTableModel)Tabla.getModel();
/* 3472 */     DefaultTableModel modeloAuxTabla = new DefaultTableModel();
/* 3473 */     modeloAuxTabla.addColumn("Cont");
/*      */     
/* 3475 */     modeloAuxTabla.addColumn("Cant");
/* 3476 */     modeloAuxTabla.addColumn("Medida");
/* 3477 */     modeloAuxTabla.addColumn("Desc");
/* 3478 */     modeloAuxTabla.addColumn("Uso");
/* 3479 */     modeloAuxTabla.addColumn("PUnit");
/* 3480 */     modeloAuxTabla.addColumn("Subtotal");
/*      */     
/* 3482 */     int contador = 1;
/*      */     
/* 3484 */     for (int fila = 0; fila < modeloOriginal.getRowCount(); fila++) {
/* 3485 */       Object[] filaDatos = new Object[7];
/* 3486 */       filaDatos[0] = Integer.valueOf(contador++);
/* 3487 */       for (int columna = 0; columna < 6; columna++) {
/* 3488 */         filaDatos[columna + 1] = modeloOriginal.getValueAt(fila, columna);
/*      */       }
/* 3490 */       modeloAuxTabla.addRow(filaDatos);
/*      */     } 
/* 3492 */     JTable auxTabla = new JTable(modeloAuxTabla);
/* 3493 */     return auxTabla;
/*      */   }
/*      */   
/*      */   public void desactivarRequi() {
/* 3497 */     this.jTextField5.setEnabled(false);
/* 3498 */     this.jComboBox5.setEnabled(false);
/* 3499 */     this.jComboBox6.setEnabled(false);
/* 3500 */     this.jDateChooser6.setEnabled(false);
/*      */     
/* 3502 */     this.jTextField8.setEnabled(false);
/* 3503 */     this.jTextField9.setEnabled(false);
/* 3504 */     this.jTextField10.setEnabled(false);
/*      */     
/* 3506 */     this.jTextField7.setEnabled(false);
/* 3507 */     this.jTextField11.setEnabled(false);
/* 3508 */     this.jTextField12.setEnabled(false);
/* 3509 */     this.jTextField13.setEnabled(false);
/*      */     
/* 3511 */     this.jButton52.setEnabled(false);
/* 3512 */     this.jButton54.setEnabled(false);
/* 3513 */     this.jButton53.setEnabled(false);
/*      */     
/* 3515 */     this.jRadioButton1.setEnabled(false);
/* 3516 */     this.jRadioButton2.setEnabled(false);
/* 3517 */     this.jSlider1.setEnabled(false);
/*      */     
/* 3519 */     this.jEditorPane1.setEnabled(false);
/* 3520 */     this.jButton1.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void ActivarRequi() {
/* 3524 */     this.jTextField5.setEnabled(true);
/* 3525 */     this.jComboBox5.setEnabled(true);
/* 3526 */     this.jComboBox6.setEnabled(true);
/*      */     
/* 3528 */     this.jTextField8.setEnabled(true);
/* 3529 */     this.jTextField9.setEnabled(true);
/* 3530 */     this.jTextField10.setEnabled(true);
/*      */     
/* 3532 */     this.jTextField7.setEnabled(true);
/* 3533 */     this.jTextField11.setEnabled(true);
/* 3534 */     this.jTextField12.setEnabled(true);
/* 3535 */     this.jTextField13.setEnabled(true);
/*      */     
/* 3537 */     this.jButton52.setEnabled(true);
/* 3538 */     this.jButton54.setEnabled(true);
/* 3539 */     this.jButton53.setEnabled(true);
/*      */     
/* 3541 */     this.jRadioButton1.setEnabled(true);
/* 3542 */     this.jRadioButton2.setEnabled(true);
/* 3543 */     this.jSlider1.setEnabled(true);
/*      */     
/* 3545 */     this.jEditorPane1.setEnabled(true);
/* 3546 */     this.jButton1.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void verRequisicion() {
/* 3550 */     limpiarTablaProd();
/* 3551 */     String[] datos = this.con.regresaRegIndex("id_requi, costos, fecha, usu_nombre, usu_depto, correo, prov_nombre, prov_dir, prov_cd, prov_contacto,sub, iva, total, tipoPago, diasCredito, estatus, comentarios, suc_nombre, area_nombre", "com_requi", "where id_requi = '" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3560 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/*      */ 
/*      */     
/* 3563 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro2, new String[] { "Cant", "U / M", "Mercancía | Producto | Servicio", "Uso | Destino", "Precio U.", "Subtotal", "Iva", "Ret", "Total" }, "cant, unidadMedida, descInterna, uso, precio, sub, iva, retencion, total", "com_requi_conceptos", "where id_requi = '" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3569 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "' order by num");
/*      */     
/* 3571 */     this.rSTableMetro2.setAltoHead(25);
/* 3572 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3573 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3574 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3575 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3576 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3577 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3578 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3579 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3580 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3581 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3582 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3583 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3584 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3585 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3586 */     this.jScrollPane40.setViewportView((Component)this.rSTableMetro2);
/* 3587 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 3588 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/* 3589 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3590 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 3591 */       this.rSTableMetro2.getColumnModel().getColumn(2).setMinWidth(250);
/* 3592 */       this.rSTableMetro2.getColumnModel().getColumn(2).setPreferredWidth(250);
/* 3593 */       this.rSTableMetro2.getColumnModel().getColumn(2).setMaxWidth(250);
/* 3594 */       this.rSTableMetro2.getColumnModel().getColumn(4).setMinWidth(70);
/* 3595 */       this.rSTableMetro2.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 3596 */       this.rSTableMetro2.getColumnModel().getColumn(4).setMaxWidth(70);
/*      */     } 
/* 3598 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda);
/* 3599 */     this.jLabel30.setText("" + this.rSTableMetro2.getRowCount() + " Conceptos");
/*      */     
/* 3601 */     this.jLabel61.setText(datos[0]);
/* 3602 */     this.jTextField4.setText(datos[0]);
/* 3603 */     this.jTextField5.setText(datos[1]);
/*      */     
/* 3605 */     this.jComboBox5.setSelectedItem(datos[17]);
/* 3606 */     this.jComboBox6.setSelectedItem(datos[18]);
/*      */     
/* 3608 */     this.jDateChooser6.setDate(this.utilerias.convertirFechaStringADate(datos[2]));
/* 3609 */     this.jTextField8.setText(datos[3]);
/* 3610 */     this.jTextField9.setText(datos[4]);
/* 3611 */     this.jTextField10.setText(datos[5]);
/*      */     
/* 3613 */     this.jTextField7.setText(datos[6]);
/* 3614 */     this.jTextField11.setText(datos[7]);
/* 3615 */     this.jTextField12.setText(datos[8]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3621 */     this.com_Contactos.removeAllItems();
/* 3622 */     this.jTextField13.setText(datos[9]);
/* 3623 */     cargarAutoContacos();
/*      */ 
/*      */     
/* 3626 */     if (datos[13].equals("CRÉDITO")) {
/* 3627 */       this.jRadioButton1.setSelected(true);
/* 3628 */       this.jSlider1.setValue(Integer.parseInt(datos[14]));
/*      */     } else {
/* 3630 */       this.jSlider1.setEnabled(false);
/* 3631 */       this.jRadioButton2.setSelected(true);
/* 3632 */       this.jSlider1.setValue(0);
/*      */     } 
/* 3634 */     this.jEditorPane1.setText(datos[16]);
/* 3635 */     sumas();
/*      */   }
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 3639 */     if (!datos.contains(valor)) {
/* 3640 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void insertarConceptos() {
/* 3645 */     String conceptos = "";
/* 3646 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3658 */       conceptos = conceptos + "(" + conceptos + ", '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 0)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 1)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 2)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 3)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 4)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 5)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 6)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 7)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 8)) + "')";
/*      */       
/* 3660 */       if (i + 1 < this.rSTableMetro2.getRowCount()) {
/* 3661 */         conceptos = conceptos + " , ";
/*      */       }
/*      */     } 
/* 3664 */     this.con.inserSinMsj("INSERT INTO com_requi_conceptos (cant, unidadMedida, descInterna, uso, precio, sub, iva, retencion, total, id_requi) VALUES " + conceptos);
/*      */   }
/*      */   
/*      */   public void calcularImporte() {
/* 3668 */     boolean tieneIva = this.jCheckBox1.isSelected();
/* 3669 */     double cant = Double.parseDouble(this.jFormattedTextField5.getValue().toString());
/* 3670 */     double precio = this.utilerias.convertirCantTexto(this.jFormattedTextField1.getText());
/* 3671 */     double ret = this.utilerias.convertirCantTexto(this.jFormattedTextField6.getText());
/* 3672 */     double sub = cant * precio;
/* 3673 */     double iva = 0.0D;
/*      */     
/* 3675 */     if (tieneIva) {
/* 3676 */       iva = sub * 0.16D;
/*      */     }
/* 3678 */     double total = sub + iva - ret;
/* 3679 */     this.jFormattedTextField2.setValue(Double.valueOf(sub));
/* 3680 */     this.jFormattedTextField3.setValue(Double.valueOf(iva));
/* 3681 */     this.jFormattedTextField4.setValue(Double.valueOf(total));
/*      */   }
/*      */   
/*      */   public void sumas() {
/* 3685 */     this.jLabel107.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro2, 5)));
/* 3686 */     this.jLabel108.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro2, 6)));
/* 3687 */     this.jLabel112.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro2, 7)));
/* 3688 */     this.jLabel114.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro2, 8)));
/* 3689 */     this.jLabel30.setText("" + this.rSTableMetro2.getRowCount() + " Conceptos");
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
/*      */   public void cargarCatalogos() {
/* 3726 */     String[] contac = this.con.regresaColIndex("distinct(prov_contacto)", "com_requi", "order by prov_contacto");
/* 3727 */     this.CONTACTOS = contac;
/* 3728 */     for (String c : contac) {
/* 3729 */       agregarCampo(this.TODOS_CONTACTOS, c);
/*      */     }
/* 3731 */     this.com_Contactos = new TextAutoCompleter(this.jTextField13, this.TODOS_CONTACTOS);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3735 */     this.con.setBaseDatos("sicre2PR");
/* 3736 */     this.PRIMERA = true;
/* 3737 */     String fechaCompleta1 = "";
/* 3738 */     String fechaCompleta2 = "";
/* 3739 */     String consultaFecha = "";
/* 3740 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3741 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/* 3743 */       int aa = Integer.parseInt(this.jComboBox2.getSelectedItem().toString());
/* 3744 */       consultaFecha = " and  date_format( fecha, '%m-%Y') = '" + mes[this.jComboBox1.getSelectedIndex()] + "-" + aa + "' ";
/*      */     } else {
/* 3746 */       Date fecha1 = this.jDateChooser11.getDate();
/* 3747 */       Date fecha2 = this.jDateChooser12.getDate();
/* 3748 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3749 */       String cadenaFecha = "";
/* 3750 */       cadenaFecha = formato.format(fecha1);
/* 3751 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3752 */       String MES = cadenaFecha.substring(4, 6);
/* 3753 */       String DIA = cadenaFecha.substring(6, 8);
/* 3754 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 3755 */       cadenaFecha = formato.format(fecha2);
/* 3756 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3757 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3758 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 3759 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 3760 */       consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/* 3762 */     this.PRIMERA = true;
/* 3763 */     String suc = "";
/* 3764 */     if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3765 */       suc = String.valueOf(this.jComboBox23.getSelectedItem());
/*      */     }
/* 3767 */     String area = "";
/* 3768 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3769 */       area = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */     
/* 3772 */     String estatus = "";
/* 3773 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/* 3774 */       estatus = " and (estatus like '%<Por Autorizar%' or estatus like '%<Autorizada%')";
/* 3775 */     } else if (this.jComboBox4.getSelectedIndex() == 1) {
/* 3776 */       estatus = " and estatus like '%%'";
/* 3777 */     } else if (this.jComboBox4.getSelectedIndex() == 2) {
/* 3778 */       estatus = " and estatus like '%<Autorizada%'";
/* 3779 */     } else if (this.jComboBox4.getSelectedIndex() == 3) {
/* 3780 */       estatus = " and estatus = '<Por Autorizar>'";
/* 3781 */     } else if (this.jComboBox4.getSelectedIndex() == 4) {
/* 3782 */       estatus = " and estatus = '" + String.valueOf(this.jComboBox4.getSelectedItem()) + "'";
/*      */     } 
/*      */     
/* 3785 */     String folio = "";
/* 3786 */     if (!this.jTextField6.getText().equals(this.holderFolio)) {
/* 3787 */       folio = this.jTextField6.getText();
/*      */     }
/*      */     
/* 3790 */     String usos = "";
/* 3791 */     if (!this.jTextField1.getText().equals(this.holderUso)) {
/* 3792 */       usos = this.jTextField1.getText();
/*      */     }
/*      */     
/* 3795 */     String prov = "";
/* 3796 */     if (!this.jTextField2.getText().equals(this.holderProv)) {
/* 3797 */       prov = this.jTextField2.getText();
/*      */     }
/*      */     
/* 3800 */     String producto = "";
/* 3801 */     if (!this.jTextField3.getText().equals(this.holderProducto)) {
/* 3802 */       producto = this.jTextField3.getText();
/*      */     }
/*      */     
/* 3805 */     String condiciones = "";
/* 3806 */     if (this.jComboBox7.getSelectedIndex() == 1) {
/* 3807 */       condiciones = "CRÉDITO";
/* 3808 */     } else if (this.jComboBox7.getSelectedIndex() == 2) {
/* 3809 */       condiciones = "CONTADO";
/*      */     } 
/*      */     
/* 3812 */     String usuario = "";
/* 3813 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/* 3814 */       usuario = this.jComboBox8.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3817 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "ID", "Fecha", "Usuario", "Proveedor", "Mercancía | Producto | Servicio", "Sub", "Iva", "Total", "Condiciones || Días", "", "Estatus", "Sucursal", "Área", "Uso o Destino", "Actualización" }, "id_requi, fecha, usu_nombre, prov_nombre, productos, sub, iva, total, tipoPago, diasCredito, estatus, suc_nombre, area_nombre, usos, actualizacion", "com_requi", "where id_requi like '%" + folio + "%' and suc_nombre like '%" + suc + "%' and area_nombre like '%" + area + "%' and usos like '%" + usos + "%'  and prov_nombre like '%" + prov + "%' and productos like '%" + producto + "%' " + estatus + " " + consultaFecha + " and tipoPago like '%" + condiciones + "%' and actualizacion like '%" + usuario + "%' order by num desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3829 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Autorizar>", 0, 10, 0));
/* 3830 */     this.celda2.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro1, "<Cancelada>", 0, 10, 0));
/*      */     
/* 3832 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 80);
/* 3833 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 110);
/* 3834 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 4, 220);
/* 3835 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 5, 70);
/* 3836 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 6, 70);
/* 3837 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 7, 70);
/* 3838 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 8, 120);
/* 3839 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 9, 40);
/*      */     
/* 3841 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3842 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3843 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3844 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3845 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3846 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3847 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3848 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3849 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 3850 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 3851 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 3852 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 3853 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 3854 */     this.rSTableMetro1.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 3855 */     this.rSTableMetro1.getColumnModel().getColumn(14).setCellRenderer(this.celda2);
/*      */     
/* 3857 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/*      */     
/* 3859 */     this.jLabel42.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro1, 5)));
/* 3860 */     this.jLabel39.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro1, 6)));
/* 3861 */     this.jLabel37.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro1, 7)));
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 3865 */     this.con.consultar("max(num)", "com_requi", "");
/* 3866 */     String mayor = this.con.Campo;
/* 3867 */     int MAYOR = 0;
/*      */     try {
/* 3869 */       MAYOR = Integer.parseInt(mayor);
/* 3870 */     } catch (NumberFormatException e) {
/* 3871 */       MAYOR = 0;
/*      */     } 
/* 3873 */     MAYOR++;
/* 3874 */     if (MAYOR < 100) {
/* 3875 */       this.jTextField4.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/* 3876 */     } else if (MAYOR < 1000) {
/* 3877 */       this.jTextField4.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/* 3878 */     } else if (MAYOR < 10000) {
/* 3879 */       this.jTextField4.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/* 3881 */       this.jTextField4.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*      */     } 
/* 3883 */     this.jLabel61.setText(this.jTextField4.getText());
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3887 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3895 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3901 */         return 30;
/*      */       
/*      */       case 1:
/* 3904 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3906 */           return 29;
/*      */         }
/* 3908 */         return 28;
/*      */     } 
/*      */     
/* 3911 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void limpiar() {
/* 3916 */     this.jTextField4.setText("");
/* 3917 */     this.jTextField5.setText("");
/* 3918 */     this.jTextField7.setText("");
/* 3919 */     this.jTextField8.setText("");
/* 3920 */     this.jTextField9.setText("");
/* 3921 */     this.jTextField10.setText("");
/* 3922 */     this.jTextField11.setText("");
/* 3923 */     this.jTextField12.setText("");
/* 3924 */     this.jTextField13.setText("");
/* 3925 */     this.jTextField14.setText("");
/* 3926 */     this.jEditorPane1.setText("");
/* 3927 */     this.jRadioButton1.setSelected(true);
/* 3928 */     this.jComboBox6.setSelectedIndex(0);
/*      */     
/* 3930 */     this.jLabel107.setText("$0.00");
/* 3931 */     this.jLabel108.setText("$0.00");
/* 3932 */     this.jLabel114.setText("$0.00");
/* 3933 */     this.jLabel112.setText("$0.00");
/*      */     
/* 3935 */     this.jSlider1.setEnabled(true);
/* 3936 */     this.jLabel16.setEnabled(true);
/* 3937 */     this.jSlider1.setValue(0);
/*      */     
/* 3939 */     limpiarTablaProd();
/* 3940 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 3941 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 3942 */     this.jEditorPane3.setText("");
/* 3943 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 3944 */     this.utilerias.formatearAPesos(this.jFormattedTextField1);
/* 3945 */     this.utilerias.formatearAPesos(this.jFormattedTextField2);
/* 3946 */     this.utilerias.formatearAPesos(this.jFormattedTextField3);
/* 3947 */     this.utilerias.formatearAPesos(this.jFormattedTextField4);
/* 3948 */     this.utilerias.formatearAPesos(this.jFormattedTextField6);
/* 3949 */     this.jCheckBox1.setSelected(true);
/* 3950 */     this.jDateChooser6.setDate(new Date());
/*      */   }
/*      */   
/*      */   public void limpiarTablaProd() {
/* 3954 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "U / M", "Mercancía | Producto | Servicio", "Uso | Destino", "Precio U.", "Subtotal", "Iva", "Ret", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3960 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3965 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3968 */     this.rSTableMetro2.setAltoHead(25);
/* 3969 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3970 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3971 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3972 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3973 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3974 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3975 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3976 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3977 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3978 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3979 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3980 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3981 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3982 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3983 */     this.jScrollPane40.setViewportView((Component)this.rSTableMetro2);
/* 3984 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 3985 */       this.rSTableMetro2.getColumnModel().getColumn(0).setResizable(false);
/* 3986 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 3987 */       this.rSTableMetro2.getColumnModel().getColumn(1).setResizable(false);
/* 3988 */       this.rSTableMetro2.getColumnModel().getColumn(2).setResizable(false);
/* 3989 */       this.rSTableMetro2.getColumnModel().getColumn(2).setPreferredWidth(250);
/* 3990 */       this.rSTableMetro2.getColumnModel().getColumn(3).setResizable(false);
/* 3991 */       this.rSTableMetro2.getColumnModel().getColumn(3).setPreferredWidth(150);
/* 3992 */       this.rSTableMetro2.getColumnModel().getColumn(4).setResizable(false);
/* 3993 */       this.rSTableMetro2.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 3994 */       this.rSTableMetro2.getColumnModel().getColumn(5).setResizable(false);
/* 3995 */       this.rSTableMetro2.getColumnModel().getColumn(6).setResizable(false);
/* 3996 */       this.rSTableMetro2.getColumnModel().getColumn(7).setResizable(false);
/* 3997 */       this.rSTableMetro2.getColumnModel().getColumn(8).setResizable(false);
/*      */     } 
/* 3999 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda);
/* 4000 */     this.jLabel30.setText("" + this.rSTableMetro2.getRowCount() + " Conceptos");
/*      */   }
/*      */ 
/*      */   
/*      */   public void buscarUltimoCostos() {
/* 4005 */     this.encontrado = this.con.consultar("costos", "com_requi", " where DATE(fecha) = CURDATE() order by fecha desc");
/* 4006 */     if (this.encontrado) {
/* 4007 */       this.jTextField5.setText(this.con.Campo);
/*      */     } else {
/* 4009 */       this.jTextField5.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   public void dameUsuario() {
/* 4014 */     this.jTextField8.setText((String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 4015 */     this.jTextField9.setText(this.CAMPOSGENERALES.get("empleados.departamento"));
/* 4016 */     this.jTextField10.setText(this.CAMPOSGENERALES.get("usuarios.correo"));
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 4020 */     this.pintar.colorear(this.jComboBox1);
/* 4021 */     this.pintar.colorear(this.jComboBox2);
/* 4022 */     this.pintar.colorear(this.jComboBox23);
/* 4023 */     this.pintar.colorear(this.jComboBox3);
/* 4024 */     this.pintar.colorear(this.jComboBox4);
/* 4025 */     this.pintar.colorear(this.jComboBox5);
/* 4026 */     this.pintar.colorear(this.jComboBox6);
/* 4027 */     this.pintar.colorear(this.jComboBox7);
/* 4028 */     this.pintar.colorear(this.jComboBox10);
/* 4029 */     this.pintar.colorear(this.jTextField1);
/* 4030 */     this.pintar.colorear(this.jTextField2);
/* 4031 */     this.pintar.colorear(this.jTextField3);
/* 4032 */     this.pintar.colorear(this.jTextField6);
/* 4033 */     this.pintar.colorear(this.jComboBox8);
/*      */     
/* 4035 */     this.pintar.colorear(this.jTextField4);
/* 4036 */     this.pintar.colorear(this.jTextField5);
/* 4037 */     this.pintar.colorear(this.jTextField7);
/* 4038 */     this.pintar.colorear(this.jTextField8);
/* 4039 */     this.pintar.colorear(this.jTextField9);
/* 4040 */     this.pintar.colorear(this.jTextField10);
/* 4041 */     this.pintar.colorear(this.jTextField11);
/* 4042 */     this.pintar.colorear(this.jTextField12);
/* 4043 */     this.pintar.colorear(this.jTextField13);
/* 4044 */     this.pintar.colorear(this.jTextField14);
/* 4045 */     this.pintar.colorear(this.jEditorPane1);
/*      */     
/* 4047 */     this.pintar.colorear(this.jFormattedTextField5);
/* 4048 */     this.pintar.colorear(this.jComboBox20);
/* 4049 */     this.pintar.colorear(this.jEditorPane3);
/* 4050 */     this.pintar.colorear(this.jFormattedTextField1);
/* 4051 */     this.pintar.colorear(this.jFormattedTextField6);
/* 4052 */     this.pintar.colorear(this.jTextArea5);
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 4056 */     this.SUCURSALES = this.con.regresaColIndex("nombre", "com_sucursales", "order by nombre");
/* 4057 */     this.AREAS = this.con.regresaColIndex("nombre", "com_areas", "order by nombre");
/* 4058 */     this.USOS = this.con.regresaColIndex("equipo", "com_usos", "order by equipo");
/*      */     
/* 4060 */     this.jComboBox23.removeAllItems();
/* 4061 */     this.jComboBox5.removeAllItems();
/* 4062 */     this.jComboBox23.addItem("SUCURSAL"); int i;
/* 4063 */     for (i = 0; i < this.SUCURSALES.length; i++) {
/* 4064 */       this.jComboBox23.addItem(this.SUCURSALES[i]);
/* 4065 */       this.jComboBox5.addItem(this.SUCURSALES[i]);
/*      */     } 
/*      */     
/* 4068 */     this.jComboBox3.removeAllItems();
/* 4069 */     this.jComboBox6.removeAllItems();
/* 4070 */     this.jComboBox6.addItem("ÁREA");
/* 4071 */     this.jComboBox3.addItem("ÁREAS");
/* 4072 */     for (i = 0; i < this.AREAS.length; i++) {
/* 4073 */       this.jComboBox3.addItem(this.AREAS[i]);
/* 4074 */       this.jComboBox6.addItem(this.AREAS[i]);
/*      */     } 
/*      */     
/* 4077 */     String[] medida = this.con.regresaColIndex("distinct(unidadMedida)", "com_requi_conceptos", "order by unidadMedida");
/* 4078 */     this.jComboBox20.addItem("");
/* 4079 */     for (int j = 0; j < medida.length; j++) {
/* 4080 */       this.jComboBox20.addItem(medida[j]);
/*      */     }
/*      */     
/* 4083 */     this.con.setBaseDatos("sicrePR");
/* 4084 */     String[] usu = this.con.regresaColIndex("nombre_usu", "usuarios", "where contrasena !='' and (priv = 'ADMINISTRADOR' || PRIV = 'RESETEOS' || PRIV='SUPER USUARIO' || PRIV = 'QHSE') order by nombre_usu");
/* 4085 */     this.jComboBox8.addItem("USUARIO");
/* 4086 */     this.utilerias.llenarCombo(this.jComboBox8, usu);
/* 4087 */     this.con.setBaseDatos("sicre2PR");
/*      */   }
/*      */   
/*      */   public void autoCompletarNueva() {
/* 4091 */     String[] uso = this.con.regresaColIndex("distinct(uso)", "com_requi_conceptos", "order by uso");
/* 4092 */     this.USOS = uso;
/* 4093 */     for (String c : uso) {
/* 4094 */       agregarCampo(this.TODOS_USO, c);
/*      */     }
/* 4096 */     this.com_Usos = new TextAutoCompleter(this.jTextField14, this.TODOS_USO);
/*      */   }
/*      */   
/*      */   public void carcarAutoCompletar() {
/* 4100 */     this.com_Usos.addItems((Object[])this.USOS);
/*      */   }
/*      */ 
/*      */   
/*      */   public void cargarAutoContacos() {
/* 4105 */     this.com_Contactos.addItems(this.TODOS_CONTACTOS);
/*      */   }
/*      */ 
/*      */   
/*      */   public void compras(String usu) {
/* 4110 */     this.USUARIO = usu;
/* 4111 */     this.panel.setViewportView(this);
/* 4112 */     privilegios();
/*      */   }
/*      */ 
/*      */   
/*      */   class Proveedores
/*      */   {
/*      */     String nombre;
/*      */     String direccion;
/*      */     String ciudad;
/*      */     String contacto;
/* 4122 */     int ID = 0;
/*      */     
/*      */     public Proveedores(int ID, String nombre, String direccion, String ciudad, String contacto) {
/* 4125 */       this.nombre = nombre;
/* 4126 */       this.direccion = direccion;
/* 4127 */       this.ciudad = ciudad;
/* 4128 */       this.contacto = contacto;
/* 4129 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public void setNombre(String nombre) {
/* 4133 */       this.nombre = nombre;
/*      */     }
/*      */     
/*      */     public void setDireccion(String direccion) {
/* 4137 */       this.direccion = direccion;
/*      */     }
/*      */     
/*      */     public void setCiudad(String ciudad) {
/* 4141 */       this.ciudad = ciudad;
/*      */     }
/*      */     
/*      */     public void setContacto(String contacto) {
/* 4145 */       this.contacto = contacto;
/*      */     }
/*      */     
/*      */     public void setID(int ID) {
/* 4149 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getNombre() {
/* 4153 */       return this.nombre;
/*      */     }
/*      */     
/*      */     public String getDireccion() {
/* 4157 */       return this.direccion;
/*      */     }
/*      */     
/*      */     public String getCiudad() {
/* 4161 */       return this.ciudad;
/*      */     }
/*      */     
/*      */     public String getContacto() {
/* 4165 */       return this.contacto;
/*      */     }
/*      */     
/*      */     public int getID() {
/* 4169 */       return this.ID;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 4175 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4178 */       setEnabled((table == null || table.isEnabled()));
/* 4179 */       if (column == 0 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8) {
/* 4180 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4182 */         setHorizontalAlignment(2);
/*      */       } 
/* 4184 */       if (row % 2 == 0) {
/* 4185 */         setBackground(Compras.this.lc.FONDOTABLA);
/*      */       } else {
/* 4187 */         setBackground(Color.WHITE);
/*      */       } 
/* 4189 */       setForeground(Compras.this.lc.SECUNDARIO1);
/* 4190 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4191 */       return this;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { String[] indices;
/*      */     String[] indices2;
/*      */     
/*      */     public CeldaRender2() {
/* 4197 */       this.indices = new String[0];
/* 4198 */       this.indices2 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4201 */       setEnabled((table == null || table.isEnabled()));
/* 4202 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4203 */       if (column == 5 || column == 6 || column == 7 || column == 9) {
/* 4204 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4206 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 4209 */       if (comparar(comp)) {
/* 4210 */         setBackground(new Color(102, 153, 255));
/* 4211 */         setForeground(Color.BLUE);
/* 4212 */       } else if (comparar2(comp)) {
/* 4213 */         setBackground(Color.red);
/* 4214 */         setForeground(Color.white);
/*      */       } else {
/* 4216 */         setBackground((Color)null);
/* 4217 */         setForeground(Compras.this.lc.SECUNDARIO1);
/*      */       } 
/*      */       
/* 4220 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4221 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4225 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 4229 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4233 */       for (int i = 0; i < this.indices.length; i++) {
/* 4234 */         if (this.indices[i].equals(reg)) {
/* 4235 */           return true;
/*      */         }
/*      */       } 
/* 4238 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 4242 */       for (int i = 0; i < this.indices2.length; i++) {
/* 4243 */         if (this.indices2[i].equals(reg)) {
/* 4244 */           return true;
/*      */         }
/*      */       } 
/* 4247 */       return false;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Compras.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */