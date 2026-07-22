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
/*      */ import rojerusan.RSTableMetro;
/*      */ 
/*      */ public class UnidadesDollys extends JPanel {
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
/*   58 */   String holderEco = "NÚM DEL DOLLY";
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
/*   73 */   MensajePop mensajeTry = null;
/*   74 */   Fuentes fuentes = new Fuentes();
/*   75 */   PlaceHolder placeHolder = null;
/*   76 */   String[] SUCURSALES = null;
/*   77 */   String[] ESTADOS = null;
/*   78 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean PRIMERA = false;
/*   80 */   Cursor micursor = null;
/*   81 */   CeldaRender1 celda1 = new CeldaRender1();
/*   82 */   CeldaRender2 celda2 = new CeldaRender2();
/*   83 */   Map<String, String> CARPETAS = new TreeMap<>();
/*      */   Map<String, UnidadesTractosDoc> DOCUMENTACION;
/*   85 */   Date fechaInicio = null;
/*   86 */   String TIPOSELEC = "";
/*   87 */   private Map<String, String> CAMPOS = new TreeMap<>();
/*   88 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*   89 */   String TIPOV = "DOLLY"; private ButtonGroup buttonGroup1; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton38; private JButton jButton39; private JButton jButton53; private JButton jButton54; private JButton jButton55; private JButton jButton58; private JButton jButton59; private JButton jButton61; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox23; private JComboBox jComboBox24; private JComboBox jComboBox25; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel2;
/*      */   private JLabel jLabel29;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel34;
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel98;
/*      */   private JLabel jLabel99;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel136;
/*      */   private JPanel jPanel14;
/*      */   private JPanel jPanel15;
/*      */   private JPanel jPanel16;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel35;
/*      */   private JPanel jPanel36;
/*      */   private JPanel jPanel37;
/*      */   private JPanel jPanel38;
/*      */   private JPanel jPanel39;
/*      */   private JPanel jPanel40;
/*      */   private JPanel jPanel41;
/*      */   private JPanel jPanel42;
/*      */   
/*      */   public UnidadesDollys(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  118 */     this.PRIVILEGIOS.put("1", "SUPER USUARIO");
/*  119 */     this.PRIVILEGIOS.put("2", "QHSE");
/*  120 */     this.PRIVILEGIOS.put("3", "ADMINISTRADOR");
/*      */     
/*  122 */     String año = "2010";
/*  123 */     String mes = "03";
/*  124 */     String dia = "01";
/*  125 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  126 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  128 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  129 */     } catch (ParseException ex) {
/*  130 */       ex.printStackTrace();
/*      */     } 
/*  132 */     this.con2.setBaseDatos("sicre2PR");
/*  133 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  134 */     this.mensajeTry = mensajeTry;
/*  135 */     this.padre = padre;
/*  136 */     this.fichas = fichas;
/*  137 */     this.USUARIO = USUARIO;
/*  138 */     this.panel = panelito;
/*  139 */     this.panel.setViewportView(this);
/*  140 */     initComponents();
/*      */     
/*  142 */     this.jDateChooser1.getDate();
/*  143 */     this.buttonGroup1.add(this.jRadioButton1);
/*  144 */     this.buttonGroup1.add(this.jRadioButton2);
/*  145 */     this.buttonGroup1.add(this.jRadioButton3);
/*  146 */     this.buttonGroup1.add(this.jRadioButton4);
/*  147 */     this.buttonGroup1.add(this.jRadioButton5);
/*  148 */     this.buttonGroup1.add(this.jRadioButton6);
/*  149 */     this.buttonGroup1.add(this.jRadioButton7);
/*  150 */     this.buttonGroup1.add(this.jRadioButton8);
/*  151 */     this.buttonGroup1.add(this.jRadioButton9);
/*      */     
/*  153 */     String[][] carpetas = this.con.buscarDatos("tipo, direccion", "unidadescarpetas", "");
/*  154 */     for (int i = 0; i < carpetas.length; i++) {
/*  155 */       this.CARPETAS.put(carpetas[i][0], carpetas[i][1]);
/*      */     }
/*  157 */     this.utilerias.imprimirMapa(this.CARPETAS);
/*      */     
/*  159 */     colorear();
/*  160 */     this.placeHolder = new PlaceHolder(this.jTextField60, new Color(189, 189, 189), Color.BLACK, this.holderEco, false, "Century Gothic", 11);
/*  161 */     this.placeHolder = new PlaceHolder(this.jTextField61, new Color(189, 189, 189), Color.BLACK, this.holderSerie, false, "Century Gothic", 11);
/*  162 */     this.placeHolder = new PlaceHolder(this.jTextField62, new Color(189, 189, 189), Color.BLACK, this.holderPlacas, false, "Century Gothic", 11);
/*  163 */     this.placeHolder = new PlaceHolder(this.jTextField63, new Color(189, 189, 189), Color.BLACK, this.holderMarca, false, "Century Gothic", 11);
/*  164 */     this.placeHolder = new PlaceHolder(this.jTextField64, new Color(189, 189, 189), Color.BLACK, this.holderTipo, false, "Century Gothic", 11);
/*  165 */     this.placeHolder = new PlaceHolder(this.jTextField17, new Color(189, 189, 189), Color.BLACK, this.holderBuscarM, false, "Century Gothic", 11);
/*      */     
/*  167 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  168 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  169 */     this.rSTableMetro1.setCursor(this.micursor);
/*  170 */     this.rSTableMetro2.setCursor(this.micursor);
/*  171 */     this.rSTableMetro3.setCursor(this.micursor);
/*      */     
/*  173 */     this.utilerias.activarVentanajDialog(this.jDialog1, 1000, 550);
/*  174 */     this.utilerias.activarVentanajDialog(this.jDialog2, 280, 390);
/*  175 */     this.utilerias.activarVentanajDialog(this.jDialog3, 475, 260);
/*  176 */     this.utilerias.activarVentanajDialog(this.jDialog4, 495, 140);
/*      */     
/*  178 */     ingresarCampos();
/*  179 */     llenarComboEstados();
/*  180 */     llenarComboSuc();
/*      */     
/*  182 */     llenarModelo();
/*  183 */     llenarMarca();
/*  184 */     llenarTipo();
/*  185 */     this.jComboBox11.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*  186 */     consultar();
/*  187 */     privilegios();
/*      */   }
/*      */   private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel70; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3;
/*      */   private JRadioButton jRadioButton4;
/*      */   private JRadioButton jRadioButton5;
/*      */   
/*      */   private void initComponents() {
/*  194 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  195 */     this.jPanel16 = new JPanel();
/*  196 */     this.jPanel36 = new JPanel();
/*  197 */     this.jPanel37 = new JPanel();
/*  198 */     this.jLabel2 = new JLabel();
/*  199 */     this.jTextField100 = new JTextField();
/*  200 */     this.jPanel38 = new JPanel();
/*  201 */     this.jLabel3 = new JLabel();
/*  202 */     this.jComboBox20 = new JComboBox();
/*  203 */     this.jPanel39 = new JPanel();
/*  204 */     this.jLabel4 = new JLabel();
/*  205 */     this.jTextField101 = new JTextField();
/*  206 */     this.jPanel41 = new JPanel();
/*  207 */     this.materialButton21 = new MaterialButton();
/*  208 */     this.materialButton22 = new MaterialButton();
/*  209 */     this.jPanel42 = new JPanel();
/*  210 */     this.jPanel43 = new JPanel();
/*  211 */     this.jLabel6 = new JLabel();
/*  212 */     this.jTextField102 = new JTextField();
/*  213 */     this.jPanel44 = new JPanel();
/*  214 */     this.jPanel45 = new JPanel();
/*  215 */     this.jPanel46 = new JPanel();
/*  216 */     this.jPanel47 = new JPanel();
/*  217 */     this.jLabel29 = new JLabel();
/*  218 */     this.jTextField104 = new JTextField();
/*  219 */     this.jPanel48 = new JPanel();
/*  220 */     this.jLabel101 = new JLabel();
/*  221 */     this.jComboBox21 = new JComboBox();
/*  222 */     this.jPanel49 = new JPanel();
/*  223 */     this.jLabel102 = new JLabel();
/*  224 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  225 */     this.jPanel40 = new JPanel();
/*  226 */     this.jPanel50 = new JPanel();
/*  227 */     this.jLabel5 = new JLabel();
/*  228 */     this.jTextField105 = new JTextField();
/*  229 */     this.jPanel51 = new JPanel();
/*  230 */     this.jLabel103 = new JLabel();
/*  231 */     this.jTextField106 = new JTextField();
/*  232 */     this.jPanel52 = new JPanel();
/*  233 */     this.jPanel53 = new JPanel();
/*  234 */     this.jPanel54 = new JPanel();
/*  235 */     this.jLabel105 = new JLabel();
/*  236 */     this.jPanel57 = new JPanel();
/*  237 */     this.jButton38 = new JButton();
/*  238 */     this.jComboBox22 = new JComboBox();
/*  239 */     this.jPanel55 = new JPanel();
/*  240 */     this.jLabel106 = new JLabel();
/*  241 */     this.jPanel58 = new JPanel();
/*  242 */     this.jButton39 = new JButton();
/*  243 */     this.jComboBox23 = new JComboBox();
/*  244 */     this.jPanel56 = new JPanel();
/*  245 */     this.jPanel64 = new JPanel();
/*  246 */     this.jPanel65 = new JPanel();
/*  247 */     this.jLabel109 = new JLabel();
/*  248 */     this.jComboBox24 = new JComboBox();
/*  249 */     this.jPanel66 = new JPanel();
/*  250 */     this.jLabel110 = new JLabel();
/*  251 */     this.jComboBox25 = new JComboBox();
/*  252 */     this.jPanel67 = new JPanel();
/*  253 */     this.jPanel59 = new JPanel();
/*  254 */     this.jPanel60 = new JPanel();
/*  255 */     this.jLabel108 = new JLabel();
/*  256 */     this.jLabel111 = new JLabel();
/*  257 */     this.jPanel61 = new JPanel();
/*  258 */     this.jPanel63 = new JPanel();
/*  259 */     this.jScrollPane10 = new JScrollPane();
/*  260 */     this.rSTableMetro2 = new RSTableMetro();
/*  261 */     this.jButton53 = new JButton();
/*  262 */     this.jButton54 = new JButton();
/*  263 */     this.jButton55 = new JButton();
/*  264 */     this.jScrollPane11 = new JScrollPane();
/*  265 */     this.jTextPane1 = new JTextPane();
/*  266 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  267 */     this.jPanel70 = new JPanel();
/*  268 */     this.jRadioButton1 = new JRadioButton();
/*  269 */     this.jRadioButton2 = new JRadioButton();
/*  270 */     this.jRadioButton3 = new JRadioButton();
/*  271 */     this.jRadioButton4 = new JRadioButton();
/*  272 */     this.jRadioButton5 = new JRadioButton();
/*  273 */     this.jRadioButton6 = new JRadioButton();
/*  274 */     this.jRadioButton7 = new JRadioButton();
/*  275 */     this.jRadioButton8 = new JRadioButton();
/*  276 */     this.jRadioButton9 = new JRadioButton();
/*  277 */     this.materialButton39 = new MaterialButton();
/*  278 */     this.materialButton38 = new MaterialButton();
/*  279 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  280 */     this.jPanel136 = new JPanel();
/*  281 */     this.jScrollPane33 = new JScrollPane();
/*  282 */     this.rSTableMetro3 = new RSTableMetro();
/*  283 */     this.jButton58 = new JButton();
/*  284 */     this.jButton59 = new JButton();
/*  285 */     this.jButton61 = new JButton();
/*  286 */     this.jTextField17 = new JTextField();
/*  287 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  288 */     this.jPanel62 = new JPanel();
/*  289 */     this.jLabel34 = new JLabel();
/*  290 */     this.jTextField24 = new JTextField();
/*  291 */     this.materialButton24 = new MaterialButton();
/*  292 */     this.materialButton25 = new MaterialButton();
/*  293 */     this.jPanel1 = new JPanel();
/*  294 */     this.jScrollPane1 = new JScrollPane();
/*  295 */     this.jTable1 = new JTable();
/*  296 */     this.buttonGroup1 = new ButtonGroup();
/*  297 */     this.jPanel3 = new JPanel();
/*  298 */     this.jPanel9 = new JPanel();
/*  299 */     this.jPanel10 = new JPanel();
/*  300 */     this.jLabel98 = new JLabel();
/*  301 */     this.jPanel35 = new JPanel();
/*  302 */     this.jTextField60 = new JTextField();
/*  303 */     this.jTextField61 = new JTextField();
/*  304 */     this.jTextField62 = new JTextField();
/*  305 */     this.jTextField63 = new JTextField();
/*  306 */     this.jTextField64 = new JTextField();
/*  307 */     this.jComboBox9 = new JComboBox();
/*  308 */     this.jComboBox10 = new JComboBox();
/*  309 */     this.jComboBox11 = new JComboBox();
/*  310 */     this.jPanel11 = new JPanel();
/*  311 */     this.jPanel12 = new JPanel();
/*  312 */     this.jPanel15 = new JPanel();
/*  313 */     this.jLabel99 = new JLabel();
/*  314 */     this.jLabel100 = new JLabel();
/*  315 */     this.jPanel14 = new JPanel();
/*  316 */     this.jButton35 = new JButton();
/*  317 */     this.jButton36 = new JButton();
/*  318 */     this.jButton37 = new JButton();
/*  319 */     this.jButton34 = new JButton();
/*  320 */     this.jButton33 = new JButton();
/*  321 */     this.jPanel2 = new JPanel();
/*  322 */     this.jScrollPane8 = new JScrollPane();
/*  323 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  325 */     this.jDialog1.setTitle("Dollys");
/*  326 */     this.jDialog1.setModal(true);
/*  327 */     this.jDialog1.setResizable(false);
/*      */     
/*  329 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/*      */     
/*  331 */     this.jPanel36.setBackground(new Color(255, 255, 255));
/*  332 */     this.jPanel36.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  334 */     this.jPanel37.setBackground(new Color(255, 255, 255));
/*  335 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  337 */     this.jLabel2.setHorizontalAlignment(4);
/*  338 */     this.jLabel2.setText("Económico");
/*  339 */     this.jPanel37.add(this.jLabel2);
/*      */     
/*  341 */     this.jTextField100.setText("jTextField100");
/*  342 */     this.jPanel37.add(this.jTextField100);
/*      */     
/*  344 */     this.jPanel36.add(this.jPanel37);
/*      */     
/*  346 */     this.jPanel38.setBackground(new Color(255, 255, 255));
/*  347 */     this.jPanel38.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  349 */     this.jLabel3.setHorizontalAlignment(4);
/*  350 */     this.jLabel3.setText("Modelo");
/*  351 */     this.jPanel38.add(this.jLabel3);
/*      */     
/*  353 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  354 */     this.jPanel38.add(this.jComboBox20);
/*      */     
/*  356 */     this.jPanel36.add(this.jPanel38);
/*      */     
/*  358 */     this.jPanel39.setBackground(new Color(255, 255, 255));
/*  359 */     this.jPanel39.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  361 */     this.jLabel4.setHorizontalAlignment(4);
/*  362 */     this.jLabel4.setText("Serie");
/*  363 */     this.jPanel39.add(this.jLabel4);
/*      */     
/*  365 */     this.jTextField101.setText("jTextField101");
/*  366 */     this.jPanel39.add(this.jTextField101);
/*      */     
/*  368 */     this.jPanel36.add(this.jPanel39);
/*      */     
/*  370 */     this.jPanel41.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  372 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  373 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  374 */     this.materialButton21.setMnemonic('C');
/*  375 */     this.materialButton21.setText("Cerrar");
/*  376 */     this.materialButton21.setToolTipText("Cerrar (Al t + C)");
/*  377 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  378 */     this.materialButton21.setHorizontalTextPosition(0);
/*  379 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  381 */             UnidadesDollys.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  385 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  386 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  387 */     this.materialButton22.setMnemonic('A');
/*  388 */     this.materialButton22.setText("Guardar");
/*  389 */     this.materialButton22.setToolTipText("Guardar (Alt+G)");
/*  390 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  391 */     this.materialButton22.setHorizontalTextPosition(0);
/*  392 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  394 */             UnidadesDollys.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  398 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/*  399 */     this.jPanel41.setLayout(jPanel41Layout);
/*  400 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/*  401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  402 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  403 */           .addContainerGap(-1, 32767)
/*  404 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  405 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  406 */           .addComponent((Component)this.materialButton21, -2, 105, -2)));
/*      */     
/*  408 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/*  409 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  410 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  411 */           .addGap(0, 0, 32767)
/*  412 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  413 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  414 */             .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*      */ 
/*      */     
/*  417 */     this.jPanel42.setBackground(new Color(255, 255, 255));
/*  418 */     this.jPanel42.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  420 */     this.jPanel43.setBackground(new Color(255, 255, 255));
/*  421 */     this.jPanel43.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  423 */     this.jLabel6.setHorizontalAlignment(4);
/*  424 */     this.jLabel6.setText("Placas");
/*  425 */     this.jPanel43.add(this.jLabel6);
/*      */     
/*  427 */     this.jTextField102.setText("jTextField102");
/*  428 */     this.jPanel43.add(this.jTextField102);
/*      */     
/*  430 */     this.jPanel42.add(this.jPanel43);
/*      */     
/*  432 */     this.jPanel44.setBackground(new Color(255, 255, 255));
/*  433 */     this.jPanel44.setLayout(new GridLayout(1, 2, 6, 0));
/*  434 */     this.jPanel42.add(this.jPanel44);
/*      */     
/*  436 */     this.jPanel45.setBackground(new Color(255, 255, 255));
/*  437 */     this.jPanel45.setLayout(new GridLayout(1, 2, 6, 0));
/*  438 */     this.jPanel42.add(this.jPanel45);
/*      */     
/*  440 */     this.jPanel46.setBackground(new Color(255, 255, 255));
/*  441 */     this.jPanel46.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  443 */     this.jPanel47.setBackground(new Color(255, 255, 255));
/*  444 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  446 */     this.jLabel29.setHorizontalAlignment(4);
/*  447 */     this.jLabel29.setText("Factura");
/*  448 */     this.jPanel47.add(this.jLabel29);
/*      */     
/*  450 */     this.jTextField104.setText("jTextField104");
/*  451 */     this.jPanel47.add(this.jTextField104);
/*      */     
/*  453 */     this.jPanel46.add(this.jPanel47);
/*      */     
/*  455 */     this.jPanel48.setBackground(new Color(255, 255, 255));
/*  456 */     this.jPanel48.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  458 */     this.jLabel101.setHorizontalAlignment(4);
/*  459 */     this.jLabel101.setText("Forma de Pago");
/*  460 */     this.jPanel48.add(this.jLabel101);
/*      */     
/*  462 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  463 */     this.jComboBox21.setEditable(true);
/*  464 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "EFECTIVO", "OTRO" }));
/*  465 */     this.jPanel48.add(this.jComboBox21);
/*      */     
/*  467 */     this.jPanel46.add(this.jPanel48);
/*      */     
/*  469 */     this.jPanel49.setBackground(new Color(255, 255, 255));
/*  470 */     this.jPanel49.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  472 */     this.jLabel102.setHorizontalAlignment(4);
/*  473 */     this.jLabel102.setText("Fecha de Compra");
/*  474 */     this.jPanel49.add(this.jLabel102);
/*      */     
/*  476 */     this.jDateChooser1.setDate(this.fechaActual);
/*  477 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/*  478 */     this.jDateChooser1.setIcon(this.icon);
/*  479 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/*  480 */     this.jPanel49.add((Component)this.jDateChooser1);
/*      */     
/*  482 */     this.jPanel46.add(this.jPanel49);
/*      */     
/*  484 */     this.jPanel40.setBackground(new Color(255, 255, 255));
/*  485 */     this.jPanel40.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  487 */     this.jPanel50.setBackground(new Color(255, 255, 255));
/*  488 */     this.jPanel50.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  490 */     this.jLabel5.setHorizontalAlignment(4);
/*  491 */     this.jLabel5.setText("Peso");
/*  492 */     this.jPanel50.add(this.jLabel5);
/*      */     
/*  494 */     this.jTextField105.setText("jTextField105");
/*  495 */     this.jPanel50.add(this.jTextField105);
/*      */     
/*  497 */     this.jPanel40.add(this.jPanel50);
/*      */     
/*  499 */     this.jPanel51.setBackground(new Color(255, 255, 255));
/*  500 */     this.jPanel51.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  502 */     this.jLabel103.setHorizontalAlignment(4);
/*  503 */     this.jLabel103.setText("Dimensión");
/*  504 */     this.jPanel51.add(this.jLabel103);
/*      */     
/*  506 */     this.jTextField106.setText("jTextField106");
/*  507 */     this.jPanel51.add(this.jTextField106);
/*      */     
/*  509 */     this.jPanel40.add(this.jPanel51);
/*      */     
/*  511 */     this.jPanel52.setBackground(new Color(255, 255, 255));
/*  512 */     this.jPanel52.setLayout(new GridLayout(1, 2, 6, 0));
/*  513 */     this.jPanel40.add(this.jPanel52);
/*      */     
/*  515 */     this.jPanel53.setBackground(new Color(255, 255, 255));
/*  516 */     this.jPanel53.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  518 */     this.jPanel54.setBackground(new Color(255, 255, 255));
/*  519 */     this.jPanel54.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  521 */     this.jLabel105.setHorizontalAlignment(4);
/*  522 */     this.jLabel105.setText("Marca");
/*  523 */     this.jPanel54.add(this.jLabel105);
/*      */     
/*  525 */     this.jPanel57.setBackground(new Color(255, 255, 255));
/*      */     
/*  527 */     this.jButton38.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  528 */     this.jButton38.setMnemonic('F');
/*  529 */     this.jButton38.setToolTipText("Filtrar información (Alt+F)");
/*  530 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  532 */             UnidadesDollys.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  536 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/*      */     
/*  538 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  539 */     this.jPanel57.setLayout(jPanel57Layout);
/*  540 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  542 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  543 */           .addComponent(this.jComboBox22, 0, 68, 32767)
/*  544 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  545 */           .addComponent(this.jButton38, -2, 20, -2)
/*  546 */           .addGap(0, 0, 0)));
/*      */     
/*  548 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  549 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  550 */         .addComponent(this.jButton38, -2, 24, -2)
/*  551 */         .addComponent(this.jComboBox22, GroupLayout.Alignment.TRAILING, -2, 25, -2));
/*      */ 
/*      */     
/*  554 */     this.jPanel54.add(this.jPanel57);
/*      */     
/*  556 */     this.jPanel53.add(this.jPanel54);
/*      */     
/*  558 */     this.jPanel55.setBackground(new Color(255, 255, 255));
/*  559 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  561 */     this.jLabel106.setHorizontalAlignment(4);
/*  562 */     this.jLabel106.setText("Tipo");
/*  563 */     this.jPanel55.add(this.jLabel106);
/*      */     
/*  565 */     this.jPanel58.setBackground(new Color(255, 255, 255));
/*      */     
/*  567 */     this.jButton39.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  568 */     this.jButton39.setMnemonic('F');
/*  569 */     this.jButton39.setToolTipText("Filtrar información (Alt+F)");
/*  570 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  572 */             UnidadesDollys.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  576 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/*      */     
/*  578 */     GroupLayout jPanel58Layout = new GroupLayout(this.jPanel58);
/*  579 */     this.jPanel58.setLayout(jPanel58Layout);
/*  580 */     jPanel58Layout.setHorizontalGroup(jPanel58Layout
/*  581 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  582 */         .addGroup(jPanel58Layout.createSequentialGroup()
/*  583 */           .addComponent(this.jComboBox23, 0, 68, 32767)
/*  584 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  585 */           .addComponent(this.jButton39, -2, 20, -2)
/*  586 */           .addGap(0, 0, 0)));
/*      */     
/*  588 */     jPanel58Layout.setVerticalGroup(jPanel58Layout
/*  589 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  590 */         .addComponent(this.jButton39, -2, 24, -2)
/*  591 */         .addComponent(this.jComboBox23, GroupLayout.Alignment.TRAILING, -2, 25, -2));
/*      */ 
/*      */     
/*  594 */     this.jPanel55.add(this.jPanel58);
/*      */     
/*  596 */     this.jPanel53.add(this.jPanel55);
/*      */     
/*  598 */     this.jPanel56.setBackground(new Color(255, 255, 255));
/*  599 */     this.jPanel56.setLayout(new GridLayout(1, 2, 6, 0));
/*  600 */     this.jPanel53.add(this.jPanel56);
/*      */     
/*  602 */     this.jPanel64.setBackground(new Color(255, 255, 255));
/*  603 */     this.jPanel64.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  605 */     this.jPanel65.setBackground(new Color(255, 255, 255));
/*  606 */     this.jPanel65.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  608 */     this.jLabel109.setHorizontalAlignment(4);
/*  609 */     this.jLabel109.setText("Estado");
/*  610 */     this.jPanel65.add(this.jLabel109);
/*      */     
/*  612 */     this.jComboBox24.setBackground(new Color(244, 244, 244));
/*  613 */     this.jComboBox24.setEditable(true);
/*  614 */     this.jComboBox24.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "BAJA", "DESMANTELADO", "PLAN DE PISO", "ROBADO", "SINIESTRADO", "VENDIDO", "OTRO" }));
/*  615 */     this.jPanel65.add(this.jComboBox24);
/*      */     
/*  617 */     this.jPanel64.add(this.jPanel65);
/*      */     
/*  619 */     this.jPanel66.setBackground(new Color(255, 255, 255));
/*  620 */     this.jPanel66.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  622 */     this.jLabel110.setHorizontalAlignment(4);
/*  623 */     this.jLabel110.setText("Sucursal");
/*  624 */     this.jPanel66.add(this.jLabel110);
/*      */     
/*  626 */     this.jComboBox25.setBackground(new Color(244, 244, 244));
/*  627 */     this.jComboBox25.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "OTRO" }));
/*  628 */     this.jPanel66.add(this.jComboBox25);
/*      */     
/*  630 */     this.jPanel64.add(this.jPanel66);
/*      */     
/*  632 */     this.jPanel67.setBackground(new Color(255, 255, 255));
/*  633 */     this.jPanel67.setLayout(new GridLayout(1, 2, 6, 0));
/*  634 */     this.jPanel64.add(this.jPanel67);
/*      */     
/*  636 */     this.jPanel59.setBackground(new Color(255, 255, 255));
/*      */     
/*  638 */     this.jPanel60.setBackground(this.lc.SECUNDARIO1);
/*  639 */     this.jPanel60.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/*  641 */     this.jLabel108.setFont(new Font("Quicksand", 1, 13));
/*  642 */     this.jLabel108.setForeground(new Color(255, 255, 255));
/*  643 */     this.jLabel108.setHorizontalAlignment(0);
/*  644 */     this.jLabel108.setText(" Sección de Permisos, Seguro y Documentación");
/*  645 */     this.jPanel60.add(this.jLabel108);
/*      */     
/*  647 */     this.jLabel111.setFont(new Font("Quicksand", 1, 13));
/*  648 */     this.jLabel111.setForeground(new Color(255, 255, 255));
/*  649 */     this.jLabel111.setHorizontalAlignment(0);
/*  650 */     this.jLabel111.setText("Comentarios");
/*  651 */     this.jPanel60.add(this.jLabel111);
/*      */     
/*  653 */     this.jPanel61.setBackground(new Color(255, 255, 255));
/*  654 */     this.jPanel61.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/*  656 */     this.jPanel63.setBackground(new Color(255, 255, 255));
/*      */     
/*  658 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  666 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  671 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  674 */     this.rSTableMetro2.setAltoHead(25);
/*  675 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  676 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  677 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  678 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  679 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  680 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  681 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  682 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  683 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  684 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  685 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  686 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  687 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  688 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  689 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  691 */             UnidadesDollys.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  694 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  696 */             UnidadesDollys.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  699 */     this.jScrollPane10.setViewportView((Component)this.rSTableMetro2);
/*      */     
/*  701 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  702 */     this.jButton53.setToolTipText("Nuevo");
/*  703 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  705 */             UnidadesDollys.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  709 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  710 */     this.jButton54.setToolTipText("Modificar");
/*  711 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  713 */             UnidadesDollys.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  717 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  718 */     this.jButton55.setToolTipText("Eliminar");
/*  719 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  721 */             UnidadesDollys.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  725 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/*  726 */     this.jPanel63.setLayout(jPanel63Layout);
/*  727 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/*  728 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  729 */         .addComponent(this.jScrollPane10, -2, 0, 32767)
/*  730 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  731 */           .addGap(0, 213, 32767)
/*  732 */           .addComponent(this.jButton53)
/*  733 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  734 */           .addComponent(this.jButton54)
/*  735 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  736 */           .addComponent(this.jButton55)));
/*      */     
/*  738 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/*  739 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  740 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  741 */           .addComponent(this.jScrollPane10, -1, 221, 32767)
/*  742 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  743 */           .addGroup(jPanel63Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  744 */             .addComponent(this.jButton53, -2, 26, -2)
/*  745 */             .addComponent(this.jButton54, -2, 26, -2)
/*  746 */             .addComponent(this.jButton55, -2, 26, -2))));
/*      */ 
/*      */     
/*  749 */     this.jPanel61.add(this.jPanel63);
/*      */     
/*  751 */     this.jScrollPane11.setViewportView(this.jTextPane1);
/*      */     
/*  753 */     this.jPanel61.add(this.jScrollPane11);
/*      */     
/*  755 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/*  756 */     this.jPanel59.setLayout(jPanel59Layout);
/*  757 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/*  758 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  759 */         .addComponent(this.jPanel60, -1, -1, 32767)
/*  760 */         .addComponent(this.jPanel61, -2, 0, 32767));
/*      */     
/*  762 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/*  763 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  764 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  765 */           .addComponent(this.jPanel60, -2, -1, -2)
/*  766 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  767 */           .addComponent(this.jPanel61, -1, -1, 32767)));
/*      */ 
/*      */     
/*  770 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/*  771 */     this.jPanel16.setLayout(jPanel16Layout);
/*  772 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/*  773 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  774 */         .addComponent(this.jPanel36, -1, -1, 32767)
/*  775 */         .addComponent(this.jPanel42, -1, -1, 32767)
/*  776 */         .addComponent(this.jPanel46, -2, 0, 32767)
/*  777 */         .addComponent(this.jPanel40, -1, -1, 32767)
/*  778 */         .addComponent(this.jPanel53, -1, -1, 32767)
/*  779 */         .addComponent(this.jPanel64, -2, 0, 32767)
/*  780 */         .addComponent(this.jPanel41, -1, -1, 32767)
/*  781 */         .addComponent(this.jPanel59, -1, -1, 32767));
/*      */     
/*  783 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/*  784 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  785 */         .addGroup(jPanel16Layout.createSequentialGroup()
/*  786 */           .addComponent(this.jPanel36, -2, -1, -2)
/*  787 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  788 */           .addComponent(this.jPanel42, -2, -1, -2)
/*  789 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  790 */           .addComponent(this.jPanel46, -2, 24, -2)
/*  791 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  792 */           .addComponent(this.jPanel40, -2, -1, -2)
/*  793 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  794 */           .addComponent(this.jPanel53, -2, 26, -2)
/*  795 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  796 */           .addComponent(this.jPanel64, -2, 25, -2)
/*  797 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  798 */           .addComponent(this.jPanel59, -1, -1, 32767)
/*  799 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  800 */           .addComponent(this.jPanel41, -2, -1, -2)));
/*      */ 
/*      */     
/*  803 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  804 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  805 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  806 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  807 */         .addComponent(this.jPanel16, -1, -1, 32767));
/*      */     
/*  809 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  810 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  811 */         .addComponent(this.jPanel16, -2, -1, -2));
/*      */ 
/*      */     
/*  814 */     this.jDialog2.setTitle("Tipo de documento");
/*  815 */     this.jDialog2.setModal(true);
/*      */     
/*  817 */     this.jPanel70.setLayout(new GridLayout(10, 0, 0, 2));
/*      */     
/*  819 */     this.jRadioButton1.setSelected(true);
/*  820 */     this.jRadioButton1.setText("Tarjetas de Circulación");
/*  821 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  823 */             UnidadesDollys.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  826 */     this.jPanel70.add(this.jRadioButton1);
/*      */     
/*  828 */     this.jRadioButton2.setText("Póliza de Seguro");
/*  829 */     this.jPanel70.add(this.jRadioButton2);
/*      */     
/*  831 */     this.jRadioButton3.setText("Sedema");
/*  832 */     this.jPanel70.add(this.jRadioButton3);
/*      */     
/*  834 */     this.jRadioButton4.setText("Nom 012");
/*  835 */     this.jPanel70.add(this.jRadioButton4);
/*      */     
/*  837 */     this.jRadioButton5.setText("Verificación");
/*  838 */     this.jPanel70.add(this.jRadioButton5);
/*      */     
/*  840 */     this.jRadioButton6.setText("Fisicomecánica");
/*  841 */     this.jPanel70.add(this.jRadioButton6);
/*      */     
/*  843 */     this.jRadioButton7.setText("Sct");
/*  844 */     this.jPanel70.add(this.jRadioButton7);
/*      */     
/*  846 */     this.jRadioButton8.setText("Pago");
/*  847 */     this.jPanel70.add(this.jRadioButton8);
/*      */     
/*  849 */     this.jRadioButton9.setText("Otro");
/*  850 */     this.jPanel70.add(this.jRadioButton9);
/*      */     
/*  852 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/*  853 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/*  854 */     this.materialButton39.setMnemonic('S');
/*  855 */     this.materialButton39.setText("Siguiente >>");
/*  856 */     this.materialButton39.setToolTipText("Siguiente (Alt+S)");
/*  857 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/*  858 */     this.materialButton39.setHorizontalTextPosition(0);
/*  859 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  861 */             UnidadesDollys.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  865 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  866 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  867 */     this.materialButton38.setMnemonic('C');
/*  868 */     this.materialButton38.setText("Cerrar");
/*  869 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/*  870 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/*  871 */     this.materialButton38.setHorizontalTextPosition(0);
/*  872 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  874 */             UnidadesDollys.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  878 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  879 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  880 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  881 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  882 */         .addComponent(this.jPanel70, -1, -1, 32767)
/*  883 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  884 */           .addGap(0, 0, 32767)
/*  885 */           .addComponent((Component)this.materialButton39, -2, 150, -2)
/*  886 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  887 */           .addComponent((Component)this.materialButton38, -2, 105, -2)));
/*      */     
/*  889 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  890 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  891 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  892 */           .addComponent(this.jPanel70, -1, -1, 32767)
/*  893 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  894 */           .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  895 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/*  896 */             .addComponent((Component)this.materialButton39, -2, 38, -2))
/*  897 */           .addContainerGap()));
/*      */ 
/*      */     
/*  900 */     this.jDialog3.setTitle("Marcas");
/*  901 */     this.jDialog3.setUndecorated(true);
/*      */     
/*  903 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  911 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  916 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  919 */     this.rSTableMetro3.setAltoHead(25);
/*  920 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  921 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  922 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  923 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  924 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  925 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  926 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  927 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  928 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  929 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  930 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  931 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  932 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  933 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  934 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  936 */             UnidadesDollys.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  939 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  941 */             UnidadesDollys.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  944 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  946 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  947 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  949 */             UnidadesDollys.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  953 */     this.jButton59.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  954 */     this.jButton59.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  956 */             UnidadesDollys.this.jButton59ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  960 */     this.jButton61.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  961 */     this.jButton61.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  963 */             UnidadesDollys.this.jButton61ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  967 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  969 */             UnidadesDollys.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/*  972 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  974 */             UnidadesDollys.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  978 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/*  979 */     this.jPanel136.setLayout(jPanel136Layout);
/*  980 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/*  981 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  982 */         .addComponent(this.jScrollPane33, -1, 418, 32767)
/*  983 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/*  984 */           .addContainerGap()
/*  985 */           .addComponent(this.jTextField17, -2, 179, -2)
/*  986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  987 */           .addComponent(this.jButton58)
/*  988 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  989 */           .addComponent(this.jButton59)
/*  990 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  991 */           .addComponent(this.jButton61)
/*  992 */           .addContainerGap()));
/*      */     
/*  994 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/*  995 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  996 */         .addGroup(jPanel136Layout.createSequentialGroup()
/*  997 */           .addComponent(this.jScrollPane33, -1, 172, 32767)
/*  998 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  999 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1000 */             .addComponent(this.jButton58, -2, 26, -2)
/* 1001 */             .addComponent(this.jButton59, -2, 26, -2)
/* 1002 */             .addComponent(this.jButton61, -2, 26, -2)
/* 1003 */             .addComponent(this.jTextField17, -2, -1, -2))));
/*      */ 
/*      */     
/* 1006 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1007 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1008 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1009 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1010 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
/* 1011 */           .addGap(0, 0, 0)
/* 1012 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/*      */     
/* 1014 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1015 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1016 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1017 */           .addComponent(this.jPanel136, -1, -1, 32767)
/* 1018 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1021 */     this.jDialog4.setTitle("Marcas");
/* 1022 */     this.jDialog4.setModal(true);
/*      */     
/* 1024 */     this.jLabel34.setText("Ingresa el nombre de la marca");
/*      */     
/* 1026 */     this.jTextField24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1028 */             UnidadesDollys.this.jTextField24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1032 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/* 1033 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 1034 */     this.materialButton24.setMnemonic('C');
/* 1035 */     this.materialButton24.setText("Cerrar");
/* 1036 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/* 1037 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 1038 */     this.materialButton24.setHorizontalTextPosition(0);
/* 1039 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1041 */             UnidadesDollys.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1045 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/* 1046 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/* 1047 */     this.materialButton25.setMnemonic('G');
/* 1048 */     this.materialButton25.setText("Guardar");
/* 1049 */     this.materialButton25.setToolTipText("Guardar (Alt +G)");
/* 1050 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/* 1051 */     this.materialButton25.setHorizontalTextPosition(0);
/* 1052 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1054 */             UnidadesDollys.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1058 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/* 1059 */     this.jPanel62.setLayout(jPanel62Layout);
/* 1060 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/* 1061 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1062 */         .addGroup(jPanel62Layout.createSequentialGroup()
/* 1063 */           .addContainerGap()
/* 1064 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1065 */             .addComponent(this.jTextField24)
/* 1066 */             .addComponent(this.jLabel34, -1, 455, 32767)
/* 1067 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/* 1068 */               .addGap(0, 0, 32767)
/* 1069 */               .addComponent((Component)this.materialButton25, -2, 150, -2)
/* 1070 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1071 */               .addComponent((Component)this.materialButton24, -2, 105, -2)))
/* 1072 */           .addContainerGap()));
/*      */     
/* 1074 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/* 1075 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1076 */         .addGroup(jPanel62Layout.createSequentialGroup()
/* 1077 */           .addComponent(this.jLabel34, -2, 26, -2)
/* 1078 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1079 */           .addComponent(this.jTextField24, -2, -1, -2)
/* 1080 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1081 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1082 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/* 1083 */             .addComponent((Component)this.materialButton25, -2, 38, -2))
/* 1084 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1087 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1088 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1089 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1090 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1091 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1092 */           .addComponent(this.jPanel62, -2, -1, -2)
/* 1093 */           .addGap(0, 0, 32767)));
/*      */     
/* 1095 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1096 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1097 */         .addComponent(this.jPanel62, -1, -1, 32767));
/*      */ 
/*      */     
/* 1100 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1111 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 1113 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1114 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1115 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1116 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1117 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1118 */           .addContainerGap()
/* 1119 */           .addComponent(this.jScrollPane1, -2, -1, -2)
/* 1120 */           .addContainerGap(52, 32767)));
/*      */     
/* 1122 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1123 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1124 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1125 */           .addContainerGap()
/* 1126 */           .addComponent(this.jScrollPane1, -2, -1, -2)
/* 1127 */           .addContainerGap(30, 32767)));
/*      */ 
/*      */     
/* 1130 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1131 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1132 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1133 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1134 */         .addGap(0, 160, 32767));
/*      */     
/* 1136 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1138 */         .addGap(0, 176, 32767));
/*      */ 
/*      */     
/* 1141 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1143 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1145 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 1146 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/* 1147 */     this.jLabel98.setHorizontalAlignment(0);
/* 1148 */     this.jLabel98.setText("Dollys");
/*      */     
/* 1150 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1151 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1152 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1153 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1154 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*      */     
/* 1156 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1157 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1158 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1159 */           .addContainerGap()
/* 1160 */           .addComponent(this.jLabel98)
/* 1161 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1164 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 1165 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1167 */     this.jTextField60.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1169 */             UnidadesDollys.this.jTextField60KeyReleased(evt);
/*      */           }
/*      */         });
/* 1172 */     this.jPanel35.add(this.jTextField60);
/*      */     
/* 1174 */     this.jTextField61.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1176 */             UnidadesDollys.this.jTextField61KeyReleased(evt);
/*      */           }
/*      */         });
/* 1179 */     this.jPanel35.add(this.jTextField61);
/*      */     
/* 1181 */     this.jTextField62.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1183 */             UnidadesDollys.this.jTextField62KeyReleased(evt);
/*      */           }
/*      */         });
/* 1186 */     this.jPanel35.add(this.jTextField62);
/*      */     
/* 1188 */     this.jTextField63.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1190 */             UnidadesDollys.this.jTextField63ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1193 */     this.jTextField63.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1195 */             UnidadesDollys.this.jTextField63KeyReleased(evt);
/*      */           }
/*      */         });
/* 1198 */     this.jPanel35.add(this.jTextField63);
/*      */     
/* 1200 */     this.jTextField64.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1202 */             UnidadesDollys.this.jTextField64KeyReleased(evt);
/*      */           }
/*      */         });
/* 1205 */     this.jPanel35.add(this.jTextField64);
/*      */     
/* 1207 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1208 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "MODELO" }));
/* 1209 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1211 */             UnidadesDollys.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1214 */     this.jPanel35.add(this.jComboBox9);
/*      */     
/* 1216 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 1217 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 1218 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1220 */             UnidadesDollys.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1223 */     this.jPanel35.add(this.jComboBox10);
/*      */     
/* 1225 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 1226 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL" }));
/* 1227 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1229 */             UnidadesDollys.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1232 */     this.jPanel35.add(this.jComboBox11);
/*      */     
/* 1234 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1236 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 1237 */     this.jPanel12.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1239 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 1240 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1242 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1243 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 1244 */     this.jLabel99.setHorizontalAlignment(4);
/* 1245 */     this.jLabel99.setText("Total");
/* 1246 */     this.jPanel15.add(this.jLabel99);
/*      */     
/* 1248 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1249 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 1250 */     this.jLabel100.setHorizontalAlignment(2);
/* 1251 */     this.jLabel100.setText("t");
/* 1252 */     this.jPanel15.add(this.jLabel100);
/*      */     
/* 1254 */     this.jPanel12.add(this.jPanel15);
/*      */     
/* 1256 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1258 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1259 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1260 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1261 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1262 */         .addGap(0, 80, 32767));
/*      */     
/* 1264 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1265 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1266 */         .addGap(0, 37, 32767));
/*      */ 
/*      */     
/* 1269 */     this.jPanel12.add(this.jPanel14);
/*      */     
/* 1271 */     this.jButton35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1272 */     this.jButton35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1273 */     this.jButton35.setMnemonic('N');
/* 1274 */     this.jButton35.setText("Nuevo");
/* 1275 */     this.jButton35.setToolTipText("Nuevo Reseteo (Alt + N)");
/* 1276 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1278 */             UnidadesDollys.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1281 */     this.jPanel12.add(this.jButton35);
/*      */     
/* 1283 */     this.jButton36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1284 */     this.jButton36.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1285 */     this.jButton36.setMnemonic('M');
/* 1286 */     this.jButton36.setText("Modificar");
/* 1287 */     this.jButton36.setToolTipText("Modificar (Alt + M)");
/* 1288 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1290 */             UnidadesDollys.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1293 */     this.jPanel12.add(this.jButton36);
/*      */     
/* 1295 */     this.jButton37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1296 */     this.jButton37.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1297 */     this.jButton37.setMnemonic('E');
/* 1298 */     this.jButton37.setText("Eliminar");
/* 1299 */     this.jButton37.setToolTipText("Eliminar (Alt+E)");
/* 1300 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1302 */             UnidadesDollys.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1305 */     this.jPanel12.add(this.jButton37);
/*      */     
/* 1307 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1308 */     this.jButton34.setMnemonic('I');
/* 1309 */     this.jButton34.setText("Imprimir");
/* 1310 */     this.jButton34.setToolTipText("Imprimir Reporte (Alt+I)");
/* 1311 */     this.jButton34.setEnabled(false);
/* 1312 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1314 */             UnidadesDollys.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1317 */     this.jPanel12.add(this.jButton34);
/*      */     
/* 1319 */     this.jButton33.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1320 */     this.jButton33.setMnemonic('G');
/* 1321 */     this.jButton33.setText("Guardar Reporte");
/* 1322 */     this.jButton33.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1323 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1325 */             UnidadesDollys.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1328 */     this.jPanel12.add(this.jButton33);
/*      */     
/* 1330 */     this.jScrollPane8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1332 */             UnidadesDollys.this.jScrollPane8MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1336 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1344 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1349 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1352 */     this.rSTableMetro1.setAltoHead(40);
/* 1353 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1354 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1355 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1356 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1357 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1358 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1359 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1360 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1361 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1362 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1363 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1364 */     this.rSTableMetro1.setRowHeight(18);
/* 1365 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1366 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1367 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1368 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1370 */             UnidadesDollys.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1373 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1375 */             UnidadesDollys.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1378 */     this.jScrollPane8.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1380 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1381 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1382 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1384 */         .addComponent(this.jScrollPane8));
/*      */     
/* 1386 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1387 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1388 */         .addComponent(this.jScrollPane8, -1, 136, 32767));
/*      */ 
/*      */     
/* 1391 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1392 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1393 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1395 */         .addComponent(this.jPanel12, -2, 597, 32767)
/* 1396 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/* 1398 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1399 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1400 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1401 */           .addComponent(this.jPanel2, -1, -1, 32767)
/* 1402 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1403 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 1404 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1407 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1408 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1409 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1410 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1411 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 1412 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 1413 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/* 1415 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1416 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1417 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1418 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1419 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1420 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1421 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1422 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1425 */     GroupLayout layout = new GroupLayout(this);
/* 1426 */     setLayout(layout);
/* 1427 */     layout.setHorizontalGroup(layout
/* 1428 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1429 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1431 */     layout.setVerticalGroup(layout
/* 1432 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1433 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */   }
/*      */   private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane33; private JScrollPane jScrollPane8; private JTable jTable1; private JTextField jTextField100; private JTextField jTextField101; private JTextField jTextField102; private JTextField jTextField104; private JTextField jTextField105; private JTextField jTextField106; private JTextField jTextField17; private JTextField jTextField24; private JTextField jTextField60; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField63; private JTextField jTextField64; private JTextPane jTextPane1; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton24; private MaterialButton materialButton25; private MaterialButton materialButton38; private MaterialButton materialButton39; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private void jTextField60KeyReleased(KeyEvent evt) {
/* 1438 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 1442 */     if (this.PRIMERA) {
/* 1443 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1448 */     if (evt.getClickCount() == 2) {
/* 1449 */       limpiar();
/* 1450 */       desabilitar();
/* 1451 */       verUnidad();
/* 1452 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 1461 */     String[] datos = { "NÚM", "DOLLY", "MODELO", "SERIE", "PLACAS", "FACTURA / PAGO", "MARCA", "TIPO", "TARJETA DE CIRCULACIÓN", "PÓLIZA", "SCT", "ESTADO", "SUCURSAL", "USUARIO" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1467 */     this.esc = new EscribirReporte("DOLLYS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 1472 */       if (!this.rSTableMetro1.print());
/*      */     
/*      */     }
/* 1475 */     catch (PrinterException printerException) {}
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 1480 */     limpiar();
/* 1481 */     habilitar();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1487 */     this.materialButton22.setText("Guardar");
/* 1488 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 1489 */     this.materialButton22.setMnemonic('G');
/* 1490 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 1500 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1501 */     if (ind < 0) {
/* 1502 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar los datos", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1504 */       limpiar();
/* 1505 */       habilitar();
/* 1506 */       verUnidad();
/*      */       
/* 1508 */       this.materialButton22.setText("Modificar");
/* 1509 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 1510 */       this.materialButton22.setMnemonic('M');
/* 1511 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {
/* 1516 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1517 */     if (ind < 0) {
/* 1518 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder darlo de baja", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1520 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas eliminar el dolly que seleccionaste?", "Eliminar registro", 0, 3, this.ELIMINAR);
/* 1521 */       if (res == 0) {
/* 1522 */         String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 11));
/* 1523 */         if (estatus.contains("BAJA")) {
/* 1524 */           JOptionPane.showMessageDialog(this.padre, "El dolly que seleccionaste ya se encuentra dado de baja, verifica tus datos", "No se puede cancelar", 0, this.ERROR);
/*      */         } else {
/* 1526 */           this.con.inserSinMsj("update dollys set estado = 'BAJA', usuario = '" + this.utilerias.sacarUsuario(this.USUARIO) + "' where idDolly = " + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/* 1527 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 1534 */     if (this.PRIMERA) {
/* 1535 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField61KeyReleased(KeyEvent evt) {
/* 1540 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField62KeyReleased(KeyEvent evt) {
/* 1544 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField63KeyReleased(KeyEvent evt) {
/* 1548 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField64KeyReleased(KeyEvent evt) {
/* 1552 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 1556 */     if (this.PRIMERA) {
/* 1557 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 1562 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 1566 */     String marca = "";
/* 1567 */     if (this.jComboBox22.getSelectedIndex() != 0) {
/* 1568 */       marca = this.jComboBox22.getSelectedItem().toString();
/*      */     }
/*      */     
/* 1571 */     String tipo = "";
/* 1572 */     if (this.jComboBox23.getSelectedIndex() != 0) {
/* 1573 */       tipo = this.jComboBox23.getSelectedItem().toString();
/*      */     }
/* 1575 */     if (this.jTextField100.getText().equals("")) {
/* 1576 */       this.jTextField100.setBackground(Color.RED);
/* 1577 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número económico", "Ingresa el económico", 0, this.ADVER);
/* 1578 */     } else if (!this.val.validarSoloNum(this.jTextField100, this.jTextField100.getText())) {
/* 1579 */       if (this.con.consultar("ecoDolly", "dollys", "where ecoDolly = " + this.jTextField100.getText()) && this.materialButton22.getText().equals("Guardar")) {
/* 1580 */         this.jTextField100.setBackground(new Color(255, 51, 51));
/* 1581 */         JOptionPane.showMessageDialog(this.padre, "El número de Dolly que colocaste ya se encuentra registrado en la base de datos", "Número registrado", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/* 1586 */       if (this.jDateChooser1.getDate() == null) {
/* 1587 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la fecha de compra", "Falta fecha de compra", 0, this.ADVER);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1594 */       else if (this.jComboBox24.getSelectedItem().equals("")) {
/* 1595 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el estado del vehículo", "Falta Estado", 0, this.ADVER);
/* 1596 */       } else if (this.materialButton22.getText().equals("Guardar")) {
/* 1597 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar la información del nuevo vehículo?", "Crear Nuevo", 0, 3, this.PREG);
/* 1598 */         if (res == 0) {
/* 1599 */           String tc = "";
/* 1600 */           String poliza = "";
/* 1601 */           String sct = "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1607 */           for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1608 */             String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1609 */             if (v.equals("TARJETA DE CIRCULACIÓN")) {
/* 1610 */               tc = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1611 */             } else if (v.equals("PÓLIZA DE SEGURO")) {
/* 1612 */               poliza = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1613 */             } else if (v.equals("SCT")) {
/* 1614 */               sct = this.rSTableMetro2.getValueAt(i, 2).toString();
/*      */             } 
/*      */           } 
/* 1617 */           this.con.inserSinMsj("insert into dollys ( ecoDolly, modelo, no_serie,placas, num_factu,forma_pago, fechaCompra, peso, dimen, marca, tipo, tc, poliza, sct, estado, sucursal, comentarios, usuario ) values (" + this.jTextField100
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1627 */               .getText().toUpperCase() + ", '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', '" + this.jTextField101.getText().toUpperCase() + "', '" + this.jTextField102
/* 1628 */               .getText().toUpperCase() + "', '" + this.jTextField104.getText().toUpperCase() + "', '" + this.jComboBox21
/* 1629 */               .getSelectedItem().toString().toUpperCase() + "', '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "', '" + this.jTextField105
/* 1630 */               .getText().toUpperCase() + "', '" + this.jTextField106.getText().toUpperCase() + "', '" + marca + "', '" + tipo + "', '" + tc + "', '" + poliza + "', '" + sct + "', '" + this.jComboBox24
/*      */ 
/*      */               
/* 1633 */               .getSelectedItem().toString().toUpperCase() + "', '" + String.valueOf(this.jComboBox25.getSelectedItem()) + "', '" + this.jTextPane1.getText().toUpperCase() + "', '" + this.utilerias.sacarUsuario(this.USUARIO) + "')");
/*      */           
/* 1635 */           this.con.consultar("max(idDolly)", "dollys", "");
/* 1636 */           String clave = this.con.Campo;
/*      */           
/* 1638 */           for (int j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/* 1639 */             insertarDocumentos(clave, this.rSTableMetro2.getValueAt(j, 1).toString());
/*      */           }
/* 1641 */           this.jDialog1.setVisible(false);
/* 1642 */           consultar();
/*      */         } 
/*      */       } else {
/* 1645 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar la información del vehículo?", "Modificar", 0, 3, this.PREG);
/* 1646 */         if (res == 0) {
/* 1647 */           String tc = "";
/* 1648 */           String poliza = "";
/* 1649 */           String sct = "";
/*      */           
/* 1651 */           for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1652 */             String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1653 */             if (v.equals("TARJETA DE CIRCULACIÓN")) {
/* 1654 */               tc = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1655 */             } else if (v.equals("PÓLIZA DE SEGURO")) {
/* 1656 */               poliza = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1657 */             } else if (v.equals("SCT")) {
/* 1658 */               sct = this.rSTableMetro2.getValueAt(i, 2).toString();
/*      */             } 
/*      */           } 
/*      */           
/* 1662 */           this.con.inserSinMsj("update dollys set ecoDolly = " + this.jTextField100
/* 1663 */               .getText().toUpperCase() + ", modelo = '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', no_serie ='" + this.jTextField101.getText().toUpperCase() + "', placas = '" + this.jTextField102
/* 1664 */               .getText().toUpperCase() + "', num_factu='" + this.jTextField104.getText().toUpperCase() + "', forma_pago = '" + 
/* 1665 */               String.valueOf(this.jComboBox21.getSelectedItem()) + "', fechaCompra = '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "',peso = '" + this.jTextField106
/* 1666 */               .getText().toUpperCase() + "', dimen='" + this.jTextField106.getText().toUpperCase() + "', marca = '" + marca + "', tipo = '" + tipo + "', estado = '" + this.jComboBox24
/* 1667 */               .getSelectedItem().toString().toUpperCase() + "', sucursal='" + 
/* 1668 */               String.valueOf(this.jComboBox25.getSelectedItem()) + "', comentarios ='" + this.jTextPane1.getText().toUpperCase() + "', usuario = '" + this.utilerias.sacarUsuario(this.USUARIO) + "' where idDolly = " + 
/* 1669 */               String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */           
/* 1671 */           this.jDialog1.setVisible(false);
/* 1672 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 1679 */     this.TIPOSELEC = "Marca";
/* 1680 */     activarVentanas(this.jButton38);
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 1684 */     this.TIPOSELEC = "Tipo";
/* 1685 */     activarVentanas(this.jButton39);
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 1689 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1690 */     if (evt.getClickCount() == 2) {
/* 1691 */       String valor = this.rSTableMetro2.getValueAt(ind, 1).toString();
/* 1692 */       if (!valor.contains("FACTURA") || this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 1693 */         if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1694 */           UnidadesTractosDoc uni = this.DOCUMENTACION.get(this.rSTableMetro2.getValueAt(ind, 1));
/* 1695 */           uni.recibeDocumentacion(this.DOCUMENTACION);
/* 1696 */           uni.setGUARDAR("MODIFICAR TEMPORAL");
/* 1697 */           uni.cargarDatos(uni.getInformacion());
/*      */         } else {
/* 1699 */           UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, this.rSTableMetro2.getValueAt(ind, 1).toString(), "VISUALIZAR");
/* 1700 */           unidad.consultarDoc(this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1701 */           unidad.desabilitar();
/* 1702 */           unidad.activarVentana();
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
/* 1713 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 1723 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1724 */     if (ind < 0) {
/* 1725 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/* 1727 */     else if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1728 */       UnidadesTractosDoc uni = this.DOCUMENTACION.get(this.rSTableMetro2.getValueAt(ind, 1));
/* 1729 */       uni.recibeDocumentacion(this.DOCUMENTACION);
/* 1730 */       uni.recibeTipoV(this.TIPOV);
/* 1731 */       uni.setGUARDAR("MODIFICAR TEMPORAL");
/* 1732 */       uni.cargarDatos(uni.getInformacion());
/*      */     } else {
/* 1734 */       UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, this.rSTableMetro2.getValueAt(ind, 1).toString(), "MODIFICAR");
/* 1735 */       unidad.recibeTipoV(this.TIPOV);
/* 1736 */       unidad.recibeDatos(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1737 */       unidad.consultarDoc(this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1738 */       unidad.activarVentana();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 1744 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1745 */     if (ind < 0) {
/* 1746 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/* 1748 */     else if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1749 */       this.DOCUMENTACION.remove(this.rSTableMetro2.getValueAt(ind, 1).toString());
/* 1750 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/*      */     } else {
/* 1752 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Al eliminar los documentos se borrarán en el sevidor y no se podrá recuperar la información que se encuentra enlazada a las unidades,<p> ¿Estás seguro que deseas eliminar definitivamente los datos?</html>", "Eliminar...", 0, 3, this.ELIMINAR);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1757 */       if (res == 0) {
/* 1758 */         String numDoc = this.rSTableMetro2.getValueAt(ind, 0).toString();
/* 1759 */         this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Archivo", "Tipo", "Act" }, "numArch, nombreArch, tipo, fecha", "unidadesarchivos", "where numDoc = " + numDoc);
/*      */ 
/*      */         
/*      */         int i;
/*      */         
/* 1764 */         for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1765 */           File fichero = new File(this.jTable1.getValueAt(i, 1).toString());
/* 1766 */           fichero.delete();
/*      */         } 
/* 1768 */         this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Num Doc", "Num Tracto" }, "numDoc, tracto.num_tracto", "tracto, unidadesdoctractos ", "where unidadesdoctractos.tipo = 'REM' and tracto.num_tracto = unidadesdoctractos.num_tracto and numDoc = " + numDoc);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1773 */         for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1774 */           this.con.inserSinMsj("update remolque set " + convertirTipoDocCampo(this.rSTableMetro2.getValueAt(ind, 1).toString()) + " = '' where num_rem = " + String.valueOf(this.jTable1.getValueAt(i, 1)));
/*      */         }
/* 1776 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/* 1777 */         this.con.eliminar2("unidadesarchivos", "where numDoc = " + numDoc);
/* 1778 */         this.con.eliminar2("unidadesdoctractos", "where tipo = 'REM' and numDoc = " + numDoc);
/* 1779 */         this.con.eliminar2("unidadesdocumentos", "where numDoc = " + numDoc);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 1786 */     if (existeDoc()) {
/* 1787 */       JOptionPane.showMessageDialog(this.jDialog2, "El tipo de documento ya se encuentra enlistado, necesitas modificarlo", "Documento Creado", 0, this.ERROR);
/*      */     } else {
/* 1789 */       this.jDialog2.setVisible(false);
/* 1790 */       String guardar = "APLICAR";
/* 1791 */       if (this.materialButton22.getText().equals("Guardar")) {
/* 1792 */         guardar = "TEMPORAL";
/*      */       } else {
/* 1794 */         this.DOCUMENTACION = new LinkedHashMap<>();
/*      */       } 
/* 1796 */       UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, dameTipoDocSelec(), guardar);
/* 1797 */       unidad.recibeDocumentacion(this.DOCUMENTACION);
/* 1798 */       unidad.recibeTipoV(this.TIPOV);
/* 1799 */       if (this.materialButton22.getText().equals("Modificar")) {
/* 1800 */         unidad.recibeDatos(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), "0");
/*      */       }
/* 1802 */       unidad.activarVentana();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 1807 */     this.jDialog2.setVisible(false);
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
/* 1819 */     if (evt.getClickCount() == 2) {
/* 1820 */       if (this.TIPOSELEC.equals("Marca")) {
/* 1821 */         this.jComboBox22.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*      */       } else {
/* 1823 */         this.jComboBox23.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*      */       } 
/* 1825 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 1834 */     if (this.TIPOSELEC.equals("Marca")) {
/* 1835 */       this.jLabel34.setText("Ingresa el nombre de la marca del tractor");
/*      */     } else {
/* 1837 */       this.jLabel34.setText("Ingresa el nombre del tipo de tractor");
/*      */     } 
/* 1839 */     this.jTextField24.setText("");
/* 1840 */     this.materialButton25.setText("Agregar");
/* 1841 */     this.materialButton25.setMnemonic('A');
/* 1842 */     this.materialButton25.setToolTipText("Agregar (Alt+A)");
/* 1843 */     this.jDialog4.setTitle("Agregar");
/* 1844 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton59ActionPerformed(ActionEvent evt) {
/* 1848 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1849 */     if (ind < 0) {
/* 1850 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1852 */       this.materialButton25.setText("Modificar");
/* 1853 */       this.materialButton25.setMnemonic('M');
/* 1854 */       this.materialButton25.setToolTipText("Modificar tipo (Alt+M)");
/* 1855 */       this.jTextField24.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/* 1856 */       this.jDialog4.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton61ActionPerformed(ActionEvent evt) {
/* 1861 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1862 */     if (ind < 0) {
/* 1863 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 1865 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas eleiminar la información que seleccionaste?", "Eliminar...", 0, 3, this.PREG);
/* 1866 */       if (res == 0) {
/* 1867 */         if (this.TIPOSELEC.equals("Marca")) {
/* 1868 */           this.con.eliminar("marca", "where id_marca=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 1869 */           llenarMarca();
/* 1870 */           consultarMarcas();
/*      */         } else {
/* 1872 */           this.con.eliminar("tipos", "where id_tipo=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 1873 */           llenarTipo();
/* 1874 */           consultarTipos();
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
/* 1885 */     if (this.TIPOSELEC.equals("Marca")) {
/* 1886 */       consultarMarcas();
/*      */     } else {
/* 1888 */       consultarTipos();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField24ActionPerformed(ActionEvent evt) {
/* 1893 */     guardarMarcasTipos();
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 1897 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 1901 */     guardarMarcasTipos();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jScrollPane8MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   public void verUnidad() {
/* 1909 */     String[] datos = this.con.regresaRegIndex("ecoDolly, modelo, no_serie, placas, num_factu, forma_pago, fechaCompra, peso, dimen, marca, tipo, estado, sucursal, comentarios", "dollys", "where idDolly= " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1914 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */     
/* 1916 */     this.jTextField100.setText(datos[0]);
/* 1917 */     this.jComboBox20.setSelectedItem(datos[1]);
/* 1918 */     this.jTextField101.setText(datos[2]);
/* 1919 */     this.jTextField102.setText(datos[3]);
/* 1920 */     this.jTextField104.setText(datos[4]);
/* 1921 */     this.jComboBox21.setSelectedItem(datos[5]);
/* 1922 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(datos[6]));
/* 1923 */     this.jTextField105.setText(datos[7]);
/* 1924 */     this.jTextField106.setText(datos[8]);
/* 1925 */     this.jComboBox22.setSelectedItem(datos[9]);
/* 1926 */     this.jComboBox23.setSelectedItem(datos[10]);
/* 1927 */     this.jComboBox24.setSelectedItem(datos[11]);
/* 1928 */     this.jComboBox25.setSelectedItem(datos[12]);
/* 1929 */     this.jTextPane1.setText(datos[13]);
/*      */     
/* 1931 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro2, new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" }, "unidadesdocumentos.numDoc, unidadesdocumentos.tipo, unidadesdocumentos.numeroUnico,unidadesdocumentos.fechaVencimiento, unidadesdocumentos.estado", "dollys, unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.tipo = '" + this.TIPOV + "' and dollys.idDolly = unidadesdoctractos.num_tracto and unidadesdocumentos.numDoc = unidadesdoctractos.numDoc and dollys.idDolly = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1936 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + " order by unidadesdocumentos.estado asc, unidadesdocumentos.tipo asc");
/*      */     
/* 1938 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda2);
/* 1939 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 0, 50);
/* 1940 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 3, 100);
/* 1941 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 4, 60);
/* 1942 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 1943 */     this.rSTableMetro2.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void desabilitar() {
/* 1947 */     this.jTextField100.setEnabled(false);
/* 1948 */     this.jTextField101.setEnabled(false);
/* 1949 */     this.jTextField102.setEnabled(false);
/*      */     
/* 1951 */     this.jTextField104.setEnabled(false);
/* 1952 */     this.jTextField105.setEnabled(false);
/* 1953 */     this.jTextField106.setEnabled(false);
/*      */ 
/*      */     
/* 1956 */     this.jComboBox20.setEnabled(false);
/* 1957 */     this.jComboBox21.setEnabled(false);
/* 1958 */     this.jComboBox22.setEnabled(false);
/* 1959 */     this.jComboBox23.setEnabled(false);
/* 1960 */     this.jComboBox24.setEnabled(false);
/* 1961 */     this.jComboBox25.setEnabled(false);
/* 1962 */     this.jButton38.setEnabled(false);
/* 1963 */     this.jButton39.setEnabled(false);
/* 1964 */     this.jDateChooser1.setEnabled(false);
/* 1965 */     this.jButton53.setEnabled(false);
/* 1966 */     this.jButton54.setEnabled(false);
/* 1967 */     this.jButton55.setEnabled(false);
/* 1968 */     this.materialButton22.setEnabled(false);
/* 1969 */     this.jTextPane1.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 1973 */     System.out.println("priv " + (String)this.CAMPOSGENERALES.get("priv") + " " + this.PRIVILEGIOS.containsValue("SUPER USUARIO"));
/* 1974 */     if (this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 1975 */       this.jButton35.setEnabled(true);
/* 1976 */       this.jButton36.setEnabled(true);
/* 1977 */       this.jButton37.setEnabled(true);
/* 1978 */       this.materialButton22.setEnabled(true);
/* 1979 */       this.jButton53.setEnabled(true);
/* 1980 */       this.jButton54.setEnabled(true);
/* 1981 */       this.jButton55.setEnabled(true);
/*      */     } else {
/* 1983 */       this.jButton35.setEnabled(false);
/* 1984 */       this.jButton36.setEnabled(false);
/* 1985 */       this.jButton37.setEnabled(false);
/* 1986 */       this.materialButton22.setEnabled(false);
/* 1987 */       this.jButton53.setEnabled(false);
/* 1988 */       this.jButton54.setEnabled(false);
/* 1989 */       this.jButton55.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void habilitar() {
/* 1994 */     this.jTextField100.setEnabled(true);
/* 1995 */     this.jTextField101.setEnabled(true);
/* 1996 */     this.jTextField102.setEnabled(true);
/*      */     
/* 1998 */     this.jTextField104.setEnabled(true);
/* 1999 */     this.jTextField105.setEnabled(true);
/* 2000 */     this.jTextField106.setEnabled(true);
/*      */ 
/*      */     
/* 2003 */     this.jComboBox20.setEnabled(true);
/* 2004 */     this.jComboBox21.setEnabled(true);
/* 2005 */     this.jComboBox22.setEnabled(true);
/* 2006 */     this.jComboBox23.setEnabled(true);
/* 2007 */     this.jComboBox24.setEnabled(true);
/* 2008 */     this.jButton38.setEnabled(true);
/* 2009 */     this.jButton39.setEnabled(true);
/* 2010 */     this.jDateChooser1.setEnabled(true);
/* 2011 */     this.jButton53.setEnabled(true);
/* 2012 */     this.jButton54.setEnabled(true);
/* 2013 */     this.jButton55.setEnabled(true);
/* 2014 */     this.materialButton22.setEnabled(true);
/* 2015 */     this.jTextPane1.setEnabled(true);
/* 2016 */     this.jComboBox25.setEnabled(true);
/*      */   }
/*      */   
/*      */   public boolean existeValor(Map Mapa, String buscar) {
/* 2020 */     return Mapa.containsValue(buscar);
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertarDocumentos(String claveTracto, String TipoDoc) {
/* 2025 */     String claveDoc = "";
/* 2026 */     this.con.inserSinMsj("insert into unidadesdocumentos (tipo, fechaCaptura, fechaTramite, numeroUnico, periodoVencimiento, fechaInicio, fechaVencimiento, dependencia, costo, dirTramite, telefono, comentarios, estado, usuario) values ('" + ((UnidadesTractosDoc)this.DOCUMENTACION
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2033 */         .get(TipoDoc)).getInformacion().getTipo() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2034 */         .get(TipoDoc)).getInformacion().getfCaptura() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2035 */         .get(TipoDoc)).getInformacion().getFtramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2036 */         .get(TipoDoc)).getInformacion().getNumUnico() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2037 */         .get(TipoDoc)).getInformacion().getpVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2038 */         .get(TipoDoc)).getInformacion().getFinicio() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2039 */         .get(TipoDoc)).getInformacion().getfVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2040 */         .get(TipoDoc)).getInformacion().getDependencia() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2041 */         .get(TipoDoc)).getInformacion().getCosto() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2042 */         .get(TipoDoc)).getInformacion().getDirTramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2043 */         .get(TipoDoc)).getInformacion().getTel() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2044 */         .get(TipoDoc)).getInformacion().getComentarios() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2045 */         .get(TipoDoc)).getInformacion().getEstado() + "', '" + this.utilerias
/* 2046 */         .sacarUsuario(this.USUARIO) + "')");
/*      */ 
/*      */ 
/*      */     
/* 2050 */     this.con.consultar("max(numDoc)", "unidadesdocumentos", "");
/* 2051 */     claveDoc = this.con.Campo;
/*      */     
/* 2053 */     for (int i = 0; i < ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().size(); i++) {
/* 2054 */       this.con.inserSinMsj("insert into unidadesarchivos ( nombreArch, tipo, fecha, numDoc ) values ( '" + 
/*      */ 
/*      */           
/* 2057 */           copiarArchivos(((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().get("" + i)).getArchivo(), getRutaDestino(TipoDoc)) + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 2058 */           .get(TipoDoc)).getDocumentos().get("" + i)).getTipo() + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 2059 */           .get(TipoDoc)).getDocumentos().get("" + i)).getAct() + "', " + claveDoc + ")");
/*      */     }
/*      */ 
/*      */     
/* 2063 */     this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + claveTracto + " ,'" + this.TIPOV + "')");
/* 2064 */     String[] ecos = ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getlistaEcos();
/* 2065 */     for (int j = 0; j < ecos.length; j++) {
/* 2066 */       System.out.println("dentro " + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo() + " " + TipoDoc + " " + ecos[j]);
/* 2067 */       this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + ecos[j] + ",'" + this.TIPOV + "' )");
/* 2068 */       if (this.CAMPOS.containsValue(((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo())) {
/* 2069 */         this.con.inserSinMsj("update remolque set " + convertirTipoDocCampo(TipoDoc) + " = '" + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getNumUnico() + "' where num_rem= " + ecos[j]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String copiarArchivos(String origen, String destino) {
/* 2076 */     if (this.TIPOV.equals("")) {
/* 2077 */       this.TIPOV = "ECO";
/*      */     }
/* 2079 */     Path origenPath = Paths.get(origen, new String[0]);
/* 2080 */     Path destinoPath = Paths.get(destino + "/" + destino + this.TIPOV + "-" + this.utilerias.getFechaSinEspacios(), new String[0]);
/*      */     
/*      */     try {
/* 2083 */       Files.copy(origenPath, destinoPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*      */     }
/* 2085 */     catch (FileNotFoundException ex) {
/* 2086 */       System.out.println("ERROR 1: al copiar Arhivo: " + ex.getMessage());
/* 2087 */     } catch (IOException ex) {
/* 2088 */       System.out.println("ERROR 2: al copiar Arhivo: " + ex.getMessage());
/*      */     } 
/* 2090 */     String nuevaRuta = destinoPath.toString().replace("\\", "\\\\");
/* 2091 */     return nuevaRuta;
/*      */   }
/*      */   
/*      */   public String getRutaDestino(String tipo) {
/* 2095 */     String ruta = this.CARPETAS.get("OTRO");
/* 2096 */     if (tipo.equals("TARJETA DE CIRCULACIÓN")) {
/* 2097 */       ruta = this.CARPETAS.get("TC");
/* 2098 */     } else if (tipo.equals("PÓLIZA DE SEGURO")) {
/* 2099 */       ruta = this.CARPETAS.get("POLIZA");
/* 2100 */     } else if (tipo.equals("SEDEMA")) {
/* 2101 */       ruta = this.CARPETAS.get("SEDEMA");
/* 2102 */     } else if (tipo.equals("NOM 012")) {
/* 2103 */       ruta = this.CARPETAS.get("NOM012");
/* 2104 */     } else if (tipo.equals("VERIFICACIÓN")) {
/* 2105 */       ruta = this.CARPETAS.get("VERIFICACION");
/* 2106 */     } else if (tipo.equals("FISICOMECÁNICA")) {
/* 2107 */       ruta = this.CARPETAS.get("FISICOMECANICA");
/* 2108 */     } else if (tipo.equals("SCT")) {
/* 2109 */       ruta = this.CARPETAS.get("SCT");
/* 2110 */     } else if (tipo.equals("PAGO")) {
/* 2111 */       ruta = this.CARPETAS.get("PAGOS");
/*      */     } 
/*      */     
/* 2114 */     return ruta;
/*      */   }
/*      */   
/*      */   public void guardarMarcasTipos() {
/* 2118 */     String marca = this.jTextField24.getText().toUpperCase();
/* 2119 */     if (marca.equals("")) {
/* 2120 */       this.jTextField24.setBackground(Color.RED);
/* 2121 */       JOptionPane.showMessageDialog(this.jDialog4, "No puedes dejar el campo vacío, por favor verifica tu información", "Falta información", 0, this.ADVER);
/* 2122 */     } else if (this.TIPOSELEC.equals("Marca")) {
/* 2123 */       if (existeValor(this.MARCAS, this.jTextField24.getText().toUpperCase())) {
/* 2124 */         this.jTextField24.setBackground(Color.RED);
/* 2125 */         JOptionPane.showMessageDialog(this.jDialog4, "La marca que deseas agregar ya se encuentra almacenada, por favor verifica tu información", "Marca ya existe", 0, this.ADVER);
/* 2126 */       } else if (this.materialButton25.getText().equals("Agregar")) {
/* 2127 */         int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar la nueva marca?", "Agregar nueva marca", 0, 3, this.PREG);
/* 2128 */         if (res == 0) {
/* 2129 */           this.con.inserSinMsj("insert into marca(marca) values('" + marca + "')");
/* 2130 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos) values (now(),'" + this.USUARIO + "','Almacenó una nueva marca de carro.','\nMarca: " + marca + "')");
/* 2131 */           llenarMarca();
/* 2132 */           this.jDialog3.setVisible(false);
/* 2133 */           this.jDialog4.setVisible(false);
/* 2134 */           this.jComboBox22.setSelectedItem(marca);
/*      */         } 
/*      */       } else {
/* 2137 */         this.con.inserSinMsj("update marca set marca ='" + this.jTextField24.getText().toUpperCase() + "' where marca ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 2138 */         this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 2139 */         llenarMarca();
/* 2140 */         this.jComboBox22.setSelectedItem(this.jTextField24.getText().toUpperCase());
/* 2141 */         this.jDialog4.setVisible(false);
/* 2142 */         this.jDialog3.setVisible(false);
/*      */       }
/*      */     
/* 2145 */     } else if (existeValor(this.TIPOS, this.jTextField24.getText().toUpperCase())) {
/* 2146 */       this.jTextField24.setBackground(Color.RED);
/* 2147 */       JOptionPane.showMessageDialog(this.jDialog4, "El tipo de tractor que deseas agregar ya se encuentra almacenado, por favor verifica tu información", "Tipo ya existe", 0, this.ADVER);
/* 2148 */     } else if (this.materialButton25.getText().equals("Agregar")) {
/* 2149 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar el nuevo tipo?", "Agregar nuevo tipo", 0, 3, this.PREG);
/* 2150 */       if (res == 0) {
/* 2151 */         this.con.inserSinMsj("insert into tipos(tipo)values('" + marca + "')");
/* 2152 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo tipo de carro.','Tipo: " + marca + "')");
/* 2153 */         llenarTipo();
/* 2154 */         this.jDialog3.setVisible(false);
/* 2155 */         this.jDialog4.setVisible(false);
/* 2156 */         this.jComboBox23.setSelectedItem(marca);
/*      */       } 
/*      */     } else {
/* 2159 */       this.con.inserSinMsj("update tipos set tipo ='" + this.jTextField24.getText().toUpperCase() + "' where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 2160 */       this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 2161 */       llenarTipo();
/* 2162 */       this.jComboBox23.setSelectedItem(this.jTextField24.getText().toUpperCase());
/* 2163 */       this.jDialog4.setVisible(false);
/* 2164 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void activarVentanas(JButton boton) {
/* 2170 */     if (this.TIPOSELEC.equals("Marca")) {
/*      */ 
/*      */       
/* 2173 */       consultarMarcas();
/* 2174 */       Dimension di = boton.getSize();
/* 2175 */       Point p = boton.getLocationOnScreen();
/* 2176 */       this.jDialog3.setLocation(p.x + di.width + 5, p.y + 35);
/* 2177 */       this.jDialog3.setVisible(true);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 2182 */       consultarTipos();
/* 2183 */       Dimension di = boton.getSize();
/* 2184 */       Point p = boton.getLocationOnScreen();
/* 2185 */       this.jDialog3.setLocation(p.x + di.width - 300, p.y + 35);
/* 2186 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultarMarcas() {
/* 2192 */     String marca = "";
/* 2193 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 2194 */       marca = this.jTextField17.getText();
/*      */     }
/* 2196 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Marca" }, "id_marca,marca", "marca", "where marca like '%" + marca + "%' order by marca");
/*      */ 
/*      */     
/* 2199 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 2200 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */   }
/*      */   
/*      */   public void consultarTipos() {
/* 2204 */     String tipo = "";
/* 2205 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 2206 */       tipo = this.jTextField17.getText();
/*      */     }
/* 2208 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Tipo" }, "id_tipo,tipo", "tipos", "where tipo like '%" + tipo + "%' order by tipo");
/*      */ 
/*      */     
/* 2211 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 2212 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */   }
/*      */   
/*      */   public String convertirTipoDocCampo(String tipoDoc) {
/* 2216 */     String campo = "";
/* 2217 */     if (tipoDoc.equals("TARJETA DE CIRCULACIÓN")) {
/* 2218 */       campo = "tc";
/* 2219 */     } else if (tipoDoc.equals("PÓLIZA DE SEGURO")) {
/* 2220 */       campo = "poliza";
/* 2221 */     } else if (tipoDoc.equals("SEDEMA")) {
/* 2222 */       campo = "sedema";
/* 2223 */     } else if (tipoDoc.equals("NOM 012")) {
/* 2224 */       campo = "nom012";
/* 2225 */     } else if (tipoDoc.equals("VERIFICACIÓN")) {
/* 2226 */       campo = "verificacion";
/* 2227 */     } else if (tipoDoc.equals("FISICOMECÁNICA")) {
/* 2228 */       campo = "fisicomecanica";
/* 2229 */     } else if (tipoDoc.equals("SCT")) {
/* 2230 */       campo = "sct";
/* 2231 */     } else if (tipoDoc.equals("PAGO")) {
/* 2232 */       campo = "pago";
/*      */     } 
/*      */     
/* 2235 */     return campo;
/*      */   }
/*      */   
/*      */   public String dameTipoDocSelec() {
/* 2239 */     String tipo = "";
/* 2240 */     if (this.jRadioButton1.isSelected()) {
/* 2241 */       tipo = "TARJETA DE CIRCULACIÓN";
/*      */     }
/* 2243 */     if (this.jRadioButton2.isSelected()) {
/* 2244 */       tipo = "PÓLIZA DE SEGURO";
/*      */     }
/* 2246 */     if (this.jRadioButton3.isSelected()) {
/* 2247 */       tipo = "SEDEMA";
/*      */     }
/* 2249 */     if (this.jRadioButton4.isSelected()) {
/* 2250 */       tipo = "NOM 012";
/*      */     }
/* 2252 */     if (this.jRadioButton5.isSelected()) {
/* 2253 */       tipo = "VERIFICACIÓN";
/*      */     }
/* 2255 */     if (this.jRadioButton6.isSelected()) {
/* 2256 */       tipo = "FISICOMECÁNICA";
/*      */     }
/* 2258 */     if (this.jRadioButton7.isSelected()) {
/* 2259 */       tipo = "SCT";
/*      */     }
/* 2261 */     if (this.jRadioButton8.isSelected()) {
/* 2262 */       tipo = "PAGO";
/*      */     }
/* 2264 */     if (this.jRadioButton9.isSelected()) {
/* 2265 */       tipo = "OTRO";
/*      */     }
/* 2267 */     return tipo;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean existeDoc() {
/* 2272 */     boolean existe = false;
/* 2273 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2274 */       String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 2275 */       if (dameTipoDocSelec().equals(v)) {
/* 2276 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2286 */     return existe;
/*      */   }
/*      */   
/*      */   public void llenarModelo() {
/* 2290 */     int año = this.fechaActual.getYear();
/* 2291 */     año += 1901;
/* 2292 */     this.jComboBox9.removeAllItems();
/* 2293 */     this.jComboBox9.addItem("MODELO");
/* 2294 */     for (int i = año; i >= 1990; i--) {
/* 2295 */       this.jComboBox20.addItem("" + i);
/* 2296 */       this.jComboBox9.addItem("" + i);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarMarca() {
/* 2301 */     String[] depa = this.con.regresaColIndex("marca", "marca", "order by marca");
/* 2302 */     this.jComboBox22.removeAllItems();
/* 2303 */     this.jComboBox22.addItem("SELECCIONA UNO...");
/* 2304 */     this.utilerias.llenarCombo(this.jComboBox22, depa);
/* 2305 */     for (int i = 0; i < depa.length; i++) {
/* 2306 */       this.MARCAS.put("" + i, depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarTipo() {
/* 2311 */     String[] tipo = this.con.regresaColIndex("tipo", "tipos", "order by tipo");
/* 2312 */     this.jComboBox23.removeAllItems();
/* 2313 */     this.jComboBox23.addItem("SELECCIONA UNO...");
/* 2314 */     this.utilerias.llenarCombo(this.jComboBox23, tipo);
/* 2315 */     for (int i = 0; i < tipo.length; i++) {
/* 2316 */       this.TIPOS.put("" + i, tipo[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2321 */     this.pintar.colorear(this.jTextField60);
/* 2322 */     this.pintar.colorear(this.jTextField61);
/* 2323 */     this.pintar.colorear(this.jTextField62);
/* 2324 */     this.pintar.colorear(this.jTextField63);
/* 2325 */     this.pintar.colorear(this.jTextField64);
/* 2326 */     this.pintar.colorear(this.jComboBox9);
/* 2327 */     this.pintar.colorear(this.jComboBox10);
/* 2328 */     this.pintar.colorear(this.jComboBox11);
/*      */     
/* 2330 */     this.pintar.colorear(this.jTextField100);
/* 2331 */     this.pintar.colorear(this.jTextField101);
/* 2332 */     this.pintar.colorear(this.jTextField102);
/*      */     
/* 2334 */     this.pintar.colorear(this.jTextField104);
/* 2335 */     this.pintar.colorear(this.jTextField105);
/* 2336 */     this.pintar.colorear(this.jTextField106);
/*      */ 
/*      */     
/* 2339 */     this.pintar.colorear(this.jTextField17);
/* 2340 */     this.pintar.colorear(this.jTextField24);
/* 2341 */     this.pintar.colorear(this.jTextPane1);
/* 2342 */     this.pintar.colorear(this.jComboBox20);
/* 2343 */     this.pintar.colorear(this.jComboBox21);
/* 2344 */     this.pintar.colorear(this.jComboBox22);
/* 2345 */     this.pintar.colorear(this.jComboBox23);
/* 2346 */     this.pintar.colorear(this.jComboBox24);
/* 2347 */     this.pintar.colorear(this.jComboBox25);
/*      */   }
/*      */   
/*      */   public void ingresarCampos() {
/* 2351 */     this.CAMPOS.put("TARJETA DE CIRCULACIÓN", "TARJETA DE CIRCULACIÓN");
/* 2352 */     this.CAMPOS.put("PÓLIZA DE SEGURO", "PÓLIZA DE SEGURO");
/* 2353 */     this.CAMPOS.put("POLIZA", "POLIZA");
/* 2354 */     this.CAMPOS.put("SEDEMA", "SEDEMA");
/* 2355 */     this.CAMPOS.put("NOM 012", "NOM 012");
/* 2356 */     this.CAMPOS.put("VERIFICACIÓN", "VERIFICACIÓN");
/* 2357 */     this.CAMPOS.put("FISICOMECÁNICA", "FISICOMECÁNICA");
/* 2358 */     this.CAMPOS.put("SCT", "SCT");
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 2362 */     this.DOCUMENTACION = new LinkedHashMap<>();
/* 2363 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro2);
/* 2364 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda2);
/* 2365 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 0, 50);
/* 2366 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 3, 100);
/* 2367 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 4, 60);
/* 2368 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 2369 */     this.rSTableMetro2.setSelectionMode(0);
/* 2370 */     this.jTextField100.setText("");
/* 2371 */     this.jTextField101.setText("");
/* 2372 */     this.jTextField102.setText("");
/*      */     
/* 2374 */     this.jTextField104.setText("");
/* 2375 */     this.jTextField105.setText("");
/* 2376 */     this.jTextField106.setText("");
/*      */ 
/*      */     
/* 2379 */     this.jComboBox20.setSelectedIndex(0);
/* 2380 */     this.jComboBox21.setSelectedIndex(0);
/* 2381 */     this.jComboBox22.setSelectedIndex(0);
/* 2382 */     this.jComboBox23.setSelectedIndex(0);
/* 2383 */     this.jComboBox24.setSelectedIndex(0);
/* 2384 */     this.jComboBox25.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/* 2385 */     this.jDateChooser1.setDate(new Date());
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
/*      */   public void dollys(String usua) {
/* 2443 */     this.USUARIO = usua;
/* 2444 */     this.panel.setViewportView(this);
/* 2445 */     privilegios();
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
/* 2465 */     this.ESTADOS = this.con.regresaColIndex("distinct(estado)", "tracto", " order by estado");
/* 2466 */     this.jComboBox10.removeAllItems();
/* 2467 */     this.jComboBox10.addItem("ESTADO");
/* 2468 */     this.utilerias.llenarCombo(this.jComboBox10, this.ESTADOS);
/* 2469 */     this.jComboBox10.setSelectedItem("ACTIVO");
/*      */   }
/*      */   
/*      */   public void llenarComboSuc() {
/* 2473 */     this.SUCURSALES = this.con2.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 2474 */     this.jComboBox11.removeAllItems();
/* 2475 */     this.jComboBox25.removeAllItems();
/* 2476 */     this.utilerias.llenarCombo(this.jComboBox11, this.SUCURSALES);
/* 2477 */     this.utilerias.llenarCombo(this.jComboBox25, this.SUCURSALES);
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
/* 2555 */     this.PRIMERA = true;
/* 2556 */     String eco = "";
/* 2557 */     String serie = "";
/* 2558 */     String placas = "";
/* 2559 */     String marca = "";
/* 2560 */     String tipo = "";
/* 2561 */     String modelo = "";
/* 2562 */     String estado = "";
/* 2563 */     String sucursal = "";
/*      */     
/* 2565 */     if (!this.jTextField60.getText().equals(this.holderEco)) {
/* 2566 */       eco = this.jTextField60.getText();
/*      */     }
/* 2568 */     if (!this.jTextField61.getText().equals(this.holderSerie)) {
/* 2569 */       serie = this.jTextField61.getText();
/*      */     }
/* 2571 */     if (!this.jTextField62.getText().equals(this.holderPlacas)) {
/* 2572 */       placas = this.jTextField62.getText();
/*      */     }
/* 2574 */     if (!this.jTextField63.getText().equals(this.holderMarca)) {
/* 2575 */       marca = this.jTextField63.getText();
/*      */     }
/* 2577 */     if (!this.jTextField64.getText().equals(this.holderTipo)) {
/* 2578 */       tipo = this.jTextField64.getText();
/*      */     }
/*      */     
/* 2581 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 2582 */       modelo = this.jComboBox9.getSelectedItem().toString();
/*      */     }
/* 2584 */     if (this.jComboBox10.getSelectedIndex() != 0) {
/* 2585 */       estado = this.jComboBox10.getSelectedItem().toString();
/*      */     }
/* 2587 */     if (!this.jComboBox11.getSelectedItem().equals("GENERAL")) {
/* 2588 */       sucursal = this.jComboBox11.getSelectedItem().toString();
/*      */     }
/*      */     
/* 2591 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "#", "Dolly", "Modelo", "Serie", "Placas", "Factura / Pago", "Pago", "Marca", "Tipo", "Tarjeta Circualción", "Póliza", "SCT", "Estado", "Sucursal", "Usuario" }, "idDolly, ecoDolly, modelo, no_serie, placas, num_factu, forma_pago, marca, tipo, tc, poliza, sct, estado, sucursal, usuario", "dollys", "where ecoDolly like '%" + eco + "%' and no_serie like '%" + serie + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "' and marca like '%" + marca + "%' and sucursal like '%" + sucursal + "%' order by ecoDolly + 0 asc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2611 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*      */     
/* 2613 */     eliminarColumna(6, 5, "Pago");
/* 2614 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 2615 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 70);
/* 2616 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 60);
/* 2617 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 4, 60);
/* 2618 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 7, 80);
/*      */ 
/*      */     
/* 2621 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreColEliminar) {
/* 2625 */     int cont = this.rSTableMetro1.getRowCount();
/* 2626 */     String[] registros = new String[cont]; int i;
/* 2627 */     for (i = 0; i < cont; i++) {
/* 2628 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 2630 */     for (i = 0; i < cont; i++) {
/* 2631 */       registros[i] = registros[i] + " / " + registros[i];
/* 2632 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 2634 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreColEliminar);
/* 2635 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 2640 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2643 */       setEnabled((table == null || table.isEnabled()));
/* 2644 */       if (column == 0 || column == 1 || column == 2) {
/* 2645 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2647 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 2650 */       if (row % 2 == 0) {
/* 2651 */         setBackground(UnidadesDollys.this.lc.FONDOTABLA);
/*      */       } else {
/* 2653 */         setBackground((Color)null);
/*      */       } 
/* 2655 */       setForeground(UnidadesDollys.this.lc.SECUNDARIO1);
/*      */       
/* 2657 */       if (column == 8 || column == 9 || column == 10) {
/* 2658 */         setForeground(UnidadesDollys.this.lc.PRIMARIO1);
/* 2659 */         setFont(UnidadesDollys.this.fuentes.setFuente(UnidadesDollys.this.fuentes.FCentury, UnidadesDollys.this.fuentes.BOLD, 15.0F));
/*      */       } 
/*      */       
/* 2662 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2663 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender2() {
/* 2669 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2672 */       setEnabled((table == null || table.isEnabled()));
/*      */       
/* 2674 */       if (row % 2 == 0) {
/* 2675 */         setBackground(UnidadesDollys.this.lc.FONDOTABLA);
/*      */       } else {
/* 2677 */         setBackground((Color)null);
/*      */       } 
/* 2679 */       setForeground(UnidadesDollys.this.lc.SECUNDARIO1);
/* 2680 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2681 */       return this;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UnidadesDollys.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */