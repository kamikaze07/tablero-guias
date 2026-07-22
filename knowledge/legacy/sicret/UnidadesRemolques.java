/*      */ package sicret;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import javax.swing.GroupLayout;
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
/*      */ public class UnidadesRemolques extends JPanel {
/*   31 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   32 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   33 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   34 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   35 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   36 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   40 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   41 */   Utilerias utilerias = new Utilerias();
/*   42 */   Date fechaActual = new Date();
/*   43 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   44 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   46 */   SColores lc = new SColores();
/*   47 */   Fuentes fuentes = new Fuentes();
/*   48 */   PlaceHolder placeHolder = null;
/*   49 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*   51 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   53 */   Map<String, String> ESTADOSBAJA = new TreeMap<>();
/*   54 */   Date fechaInicio = null;
/*   55 */   Consultas2 con = new Consultas2();
/*   56 */   Consultas2 con2 = new Consultas2();
/*   57 */   MensajePop mensajeTry = null;
/*   58 */   String holderEco = "ECO REMOLQUE";
/*   59 */   String holderSerie = "SERIE";
/*   60 */   String holderPlacas = "PLACAS";
/*   61 */   String holderMarca = "MARCA";
/*   62 */   String holderTipo = "TIPO";
/*   63 */   String holderBuscarM = "BUSCAR...";
/*   64 */   pintarComponentes pintar = new pintarComponentes();
/*   65 */   Map<String, String> CARPETAS = new TreeMap<>();
/*      */   Map<String, UnidadesTractosDoc> DOCUMENTACION;
/*   67 */   Map<String, String> MARCAS = new TreeMap<>();
/*   68 */   private Map<String, String> CAMPOS = new TreeMap<>();
/*   69 */   String[] ESTADOS = null;
/*   70 */   String[] SUCURSALES = null;
/*      */   boolean PRIMERA = false;
/*   72 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   EscribirReporte esc;
/*   74 */   Date fecha = null;
/*   75 */   Cursor micursor = null;
/*   76 */   Validaciones val = new Validaciones();
/*   77 */   String TIPOV = "REM";
/*   78 */   Map<String, String> CLAVECONFIGAUT = new TreeMap<>();
/*   79 */   String ClaveTipoAut = ""; boolean encontrado = false; private ButtonGroup buttonGroup1; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton38; private JButton jButton53; private JButton jButton54; private JButton jButton55; private JButton jButton56; private JButton jButton58; private JButton jButton59; private JButton jButton61; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox23; private JComboBox jComboBox24; private JComboBox jComboBox25; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel2; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel34; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel133;
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
/*      */   public UnidadesRemolques(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*   93 */     this.con2.setBaseDatos("sicre2PR");
/*   94 */     this.PRIVILEGIOS.put("1", "SUPER USUARIO");
/*   95 */     this.PRIVILEGIOS.put("2", "QHSE");
/*   96 */     this.PRIVILEGIOS.put("3", "ADMINISTRADOR");
/*      */     
/*   98 */     this.ESTADOSBAJA.put("1", "BAJA");
/*   99 */     this.ESTADOSBAJA.put("2", "DESMANTELADO");
/*  100 */     this.ESTADOSBAJA.put("3", "ROBADO");
/*  101 */     this.ESTADOSBAJA.put("4", "SINIESTRADO");
/*  102 */     this.ESTADOSBAJA.put("5", "VENDIDO");
/*      */     
/*  104 */     String año = "2010";
/*  105 */     String mes = "03";
/*  106 */     String dia = "01";
/*  107 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  108 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  110 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  111 */     } catch (ParseException ex) {
/*  112 */       ex.printStackTrace();
/*      */     } 
/*  114 */     this.con2.setBaseDatos("sicre2PR");
/*  115 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  116 */     this.mensajeTry = mensajeTry;
/*  117 */     this.padre = padre;
/*  118 */     this.fichas = fichas;
/*  119 */     this.USUARIO = USUARIO;
/*  120 */     this.panel = panelito;
/*  121 */     this.panel.setViewportView(this);
/*  122 */     initComponents();
/*      */     
/*  124 */     String[][] carpetas = this.con.buscarDatos("tipo, direccion", "unidadescarpetas", "");
/*  125 */     for (int i = 0; i < carpetas.length; i++) {
/*  126 */       this.CARPETAS.put(carpetas[i][0], carpetas[i][1]);
/*      */     }
/*  128 */     this.utilerias.imprimirMapa(this.CARPETAS);
/*      */     
/*  130 */     colorear();
/*  131 */     this.placeHolder = new PlaceHolder(this.jTextField60, new Color(189, 189, 189), Color.BLACK, this.holderEco, false, "Century Gothic", 11);
/*  132 */     this.placeHolder = new PlaceHolder(this.jTextField61, new Color(189, 189, 189), Color.BLACK, this.holderSerie, false, "Century Gothic", 11);
/*  133 */     this.placeHolder = new PlaceHolder(this.jTextField62, new Color(189, 189, 189), Color.BLACK, this.holderPlacas, false, "Century Gothic", 11);
/*  134 */     this.placeHolder = new PlaceHolder(this.jTextField63, new Color(189, 189, 189), Color.BLACK, this.holderMarca, false, "Century Gothic", 11);
/*  135 */     this.placeHolder = new PlaceHolder(this.jTextField64, new Color(189, 189, 189), Color.BLACK, this.holderTipo, false, "Century Gothic", 11);
/*  136 */     this.placeHolder = new PlaceHolder(this.jTextField17, new Color(189, 189, 189), Color.BLACK, this.holderBuscarM, false, "Century Gothic", 11);
/*      */     
/*  138 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  139 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  140 */     this.rSTableMetro1.setCursor(this.micursor);
/*  141 */     this.rSTableMetro2.setCursor(this.micursor);
/*      */     
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
/*  153 */     ingresarCampos();
/*  154 */     llenarComboEstados();
/*  155 */     llenarComboSuc();
/*  156 */     llenarModelo();
/*  157 */     llenarMarca();
/*  158 */     llenarTipo();
/*  159 */     this.jComboBox11.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*  160 */     consultar();
/*      */     
/*  162 */     this.utilerias.activarVentanajDialog(this.jDialog1, 1000, 550);
/*  163 */     this.utilerias.activarVentanajDialog(this.jDialog2, 280, 390);
/*  164 */     this.utilerias.activarVentanajDialog(this.jDialog3, 475, 260);
/*  165 */     this.utilerias.activarVentanajDialog(this.jDialog4, 495, 140);
/*  166 */     privilegios();
/*      */   }
/*      */   private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel59; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel70; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5;
/*      */   private JRadioButton jRadioButton6;
/*      */   private JRadioButton jRadioButton7;
/*      */   
/*      */   private void initComponents() {
/*  173 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  174 */     this.jPanel16 = new JPanel();
/*  175 */     this.jPanel36 = new JPanel();
/*  176 */     this.jPanel37 = new JPanel();
/*  177 */     this.jLabel2 = new JLabel();
/*  178 */     this.jTextField100 = new JTextField();
/*  179 */     this.jPanel38 = new JPanel();
/*  180 */     this.jLabel3 = new JLabel();
/*  181 */     this.jComboBox20 = new JComboBox();
/*  182 */     this.jPanel39 = new JPanel();
/*  183 */     this.jLabel4 = new JLabel();
/*  184 */     this.jTextField101 = new JTextField();
/*  185 */     this.jPanel41 = new JPanel();
/*  186 */     this.materialButton21 = new MaterialButton();
/*  187 */     this.materialButton22 = new MaterialButton();
/*  188 */     this.jPanel42 = new JPanel();
/*  189 */     this.jPanel43 = new JPanel();
/*  190 */     this.jLabel6 = new JLabel();
/*  191 */     this.jTextField102 = new JTextField();
/*  192 */     this.jPanel44 = new JPanel();
/*  193 */     this.jPanel45 = new JPanel();
/*  194 */     this.jPanel46 = new JPanel();
/*  195 */     this.jPanel47 = new JPanel();
/*  196 */     this.jLabel29 = new JLabel();
/*  197 */     this.jTextField104 = new JTextField();
/*  198 */     this.jPanel48 = new JPanel();
/*  199 */     this.jLabel101 = new JLabel();
/*  200 */     this.jComboBox21 = new JComboBox();
/*  201 */     this.jPanel49 = new JPanel();
/*  202 */     this.jLabel102 = new JLabel();
/*  203 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  204 */     this.jPanel40 = new JPanel();
/*  205 */     this.jPanel50 = new JPanel();
/*  206 */     this.jLabel5 = new JLabel();
/*  207 */     this.jTextField105 = new JTextField();
/*  208 */     this.jPanel51 = new JPanel();
/*  209 */     this.jLabel103 = new JLabel();
/*  210 */     this.jTextField106 = new JTextField();
/*  211 */     this.jPanel52 = new JPanel();
/*  212 */     this.jLabel104 = new JLabel();
/*  213 */     this.jTextField107 = new JTextField();
/*  214 */     this.jPanel53 = new JPanel();
/*  215 */     this.jPanel54 = new JPanel();
/*  216 */     this.jLabel105 = new JLabel();
/*  217 */     this.jPanel57 = new JPanel();
/*  218 */     this.jButton38 = new JButton();
/*  219 */     this.jComboBox22 = new JComboBox();
/*  220 */     this.jPanel56 = new JPanel();
/*  221 */     this.jLabel107 = new JLabel();
/*  222 */     this.jComboBox23 = new JComboBox();
/*  223 */     this.jPanel55 = new JPanel();
/*  224 */     this.jLabel112 = new JLabel();
/*  225 */     this.jPanel133 = new JPanel();
/*  226 */     this.jTextField85 = new JTextField();
/*  227 */     this.jButton56 = new JButton();
/*  228 */     this.jPanel64 = new JPanel();
/*  229 */     this.jPanel65 = new JPanel();
/*  230 */     this.jLabel109 = new JLabel();
/*  231 */     this.jComboBox24 = new JComboBox();
/*  232 */     this.jPanel66 = new JPanel();
/*  233 */     this.jLabel110 = new JLabel();
/*  234 */     this.jComboBox25 = new JComboBox();
/*  235 */     this.jPanel67 = new JPanel();
/*  236 */     this.jPanel59 = new JPanel();
/*  237 */     this.jPanel60 = new JPanel();
/*  238 */     this.jLabel108 = new JLabel();
/*  239 */     this.jLabel111 = new JLabel();
/*  240 */     this.jPanel61 = new JPanel();
/*  241 */     this.jPanel63 = new JPanel();
/*  242 */     this.jScrollPane10 = new JScrollPane();
/*  243 */     this.rSTableMetro2 = new RSTableMetro();
/*  244 */     this.jButton53 = new JButton();
/*  245 */     this.jButton54 = new JButton();
/*  246 */     this.jButton55 = new JButton();
/*  247 */     this.jScrollPane11 = new JScrollPane();
/*  248 */     this.jTextPane1 = new JTextPane();
/*  249 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  250 */     this.jPanel70 = new JPanel();
/*  251 */     this.jRadioButton1 = new JRadioButton();
/*  252 */     this.jRadioButton2 = new JRadioButton();
/*  253 */     this.jRadioButton3 = new JRadioButton();
/*  254 */     this.jRadioButton4 = new JRadioButton();
/*  255 */     this.jRadioButton5 = new JRadioButton();
/*  256 */     this.jRadioButton6 = new JRadioButton();
/*  257 */     this.jRadioButton7 = new JRadioButton();
/*  258 */     this.jRadioButton8 = new JRadioButton();
/*  259 */     this.jRadioButton9 = new JRadioButton();
/*  260 */     this.materialButton39 = new MaterialButton();
/*  261 */     this.materialButton38 = new MaterialButton();
/*  262 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  263 */     this.jPanel136 = new JPanel();
/*  264 */     this.jScrollPane33 = new JScrollPane();
/*  265 */     this.rSTableMetro3 = new RSTableMetro();
/*  266 */     this.jButton58 = new JButton();
/*  267 */     this.jButton59 = new JButton();
/*  268 */     this.jButton61 = new JButton();
/*  269 */     this.jTextField17 = new JTextField();
/*  270 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  271 */     this.jPanel62 = new JPanel();
/*  272 */     this.jLabel34 = new JLabel();
/*  273 */     this.jTextField24 = new JTextField();
/*  274 */     this.materialButton24 = new MaterialButton();
/*  275 */     this.materialButton25 = new MaterialButton();
/*  276 */     this.jPanel1 = new JPanel();
/*  277 */     this.jScrollPane1 = new JScrollPane();
/*  278 */     this.jTable1 = new JTable();
/*  279 */     this.buttonGroup1 = new ButtonGroup();
/*  280 */     this.jPanel9 = new JPanel();
/*  281 */     this.jPanel10 = new JPanel();
/*  282 */     this.jLabel98 = new JLabel();
/*  283 */     this.jPanel35 = new JPanel();
/*  284 */     this.jTextField60 = new JTextField();
/*  285 */     this.jTextField61 = new JTextField();
/*  286 */     this.jTextField62 = new JTextField();
/*  287 */     this.jTextField63 = new JTextField();
/*  288 */     this.jTextField64 = new JTextField();
/*  289 */     this.jComboBox9 = new JComboBox();
/*  290 */     this.jComboBox10 = new JComboBox();
/*  291 */     this.jComboBox11 = new JComboBox();
/*  292 */     this.jPanel11 = new JPanel();
/*  293 */     this.jPanel12 = new JPanel();
/*  294 */     this.jPanel15 = new JPanel();
/*  295 */     this.jLabel99 = new JLabel();
/*  296 */     this.jLabel100 = new JLabel();
/*  297 */     this.jPanel14 = new JPanel();
/*  298 */     this.jButton35 = new JButton();
/*  299 */     this.jButton36 = new JButton();
/*  300 */     this.jButton37 = new JButton();
/*  301 */     this.jButton34 = new JButton();
/*  302 */     this.jButton33 = new JButton();
/*  303 */     this.jScrollPane9 = new JScrollPane();
/*  304 */     this.jPanel13 = new JPanel();
/*  305 */     this.jScrollPane8 = new JScrollPane();
/*  306 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  308 */     this.jDialog1.setTitle("Remolques");
/*  309 */     this.jDialog1.setModal(true);
/*  310 */     this.jDialog1.setResizable(false);
/*      */     
/*  312 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/*      */     
/*  314 */     this.jPanel36.setBackground(new Color(255, 255, 255));
/*  315 */     this.jPanel36.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  317 */     this.jPanel37.setBackground(new Color(255, 255, 255));
/*  318 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  320 */     this.jLabel2.setHorizontalAlignment(4);
/*  321 */     this.jLabel2.setText("Remolque");
/*  322 */     this.jPanel37.add(this.jLabel2);
/*      */     
/*  324 */     this.jTextField100.setText("jTextField100");
/*  325 */     this.jPanel37.add(this.jTextField100);
/*      */     
/*  327 */     this.jPanel36.add(this.jPanel37);
/*      */     
/*  329 */     this.jPanel38.setBackground(new Color(255, 255, 255));
/*  330 */     this.jPanel38.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  332 */     this.jLabel3.setHorizontalAlignment(4);
/*  333 */     this.jLabel3.setText("Modelo");
/*  334 */     this.jPanel38.add(this.jLabel3);
/*      */     
/*  336 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  337 */     this.jPanel38.add(this.jComboBox20);
/*      */     
/*  339 */     this.jPanel36.add(this.jPanel38);
/*      */     
/*  341 */     this.jPanel39.setBackground(new Color(255, 255, 255));
/*  342 */     this.jPanel39.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  344 */     this.jLabel4.setHorizontalAlignment(4);
/*  345 */     this.jLabel4.setText("Serie");
/*  346 */     this.jPanel39.add(this.jLabel4);
/*      */     
/*  348 */     this.jTextField101.setText("jTextField101");
/*  349 */     this.jPanel39.add(this.jTextField101);
/*      */     
/*  351 */     this.jPanel36.add(this.jPanel39);
/*      */     
/*  353 */     this.jPanel41.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  355 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  356 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  357 */     this.materialButton21.setMnemonic('C');
/*  358 */     this.materialButton21.setText("Cerrar");
/*  359 */     this.materialButton21.setToolTipText("Cerrar (Al t + C)");
/*  360 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  361 */     this.materialButton21.setHorizontalTextPosition(0);
/*  362 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  364 */             UnidadesRemolques.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  368 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  369 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  370 */     this.materialButton22.setMnemonic('A');
/*  371 */     this.materialButton22.setText("Guardar");
/*  372 */     this.materialButton22.setToolTipText("Guardar (Alt+G)");
/*  373 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  374 */     this.materialButton22.setHorizontalTextPosition(0);
/*  375 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  377 */             UnidadesRemolques.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  381 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/*  382 */     this.jPanel41.setLayout(jPanel41Layout);
/*  383 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/*  384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  385 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  386 */           .addContainerGap(-1, 32767)
/*  387 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  388 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  389 */           .addComponent((Component)this.materialButton21, -2, 105, -2)));
/*      */     
/*  391 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/*  392 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  393 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/*  394 */           .addGap(0, 0, 32767)
/*  395 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  396 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  397 */             .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*      */ 
/*      */     
/*  400 */     this.jPanel42.setBackground(new Color(255, 255, 255));
/*  401 */     this.jPanel42.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  403 */     this.jPanel43.setBackground(new Color(255, 255, 255));
/*  404 */     this.jPanel43.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  406 */     this.jLabel6.setHorizontalAlignment(4);
/*  407 */     this.jLabel6.setText("Placas");
/*  408 */     this.jPanel43.add(this.jLabel6);
/*      */     
/*  410 */     this.jTextField102.setText("jTextField102");
/*  411 */     this.jPanel43.add(this.jTextField102);
/*      */     
/*  413 */     this.jPanel42.add(this.jPanel43);
/*      */     
/*  415 */     this.jPanel44.setBackground(new Color(255, 255, 255));
/*  416 */     this.jPanel44.setLayout(new GridLayout(1, 2, 6, 0));
/*  417 */     this.jPanel42.add(this.jPanel44);
/*      */     
/*  419 */     this.jPanel45.setBackground(new Color(255, 255, 255));
/*  420 */     this.jPanel45.setLayout(new GridLayout(1, 2, 6, 0));
/*  421 */     this.jPanel42.add(this.jPanel45);
/*      */     
/*  423 */     this.jPanel46.setBackground(new Color(255, 255, 255));
/*  424 */     this.jPanel46.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  426 */     this.jPanel47.setBackground(new Color(255, 255, 255));
/*  427 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  429 */     this.jLabel29.setHorizontalAlignment(4);
/*  430 */     this.jLabel29.setText("Factura");
/*  431 */     this.jPanel47.add(this.jLabel29);
/*      */     
/*  433 */     this.jTextField104.setText("jTextField104");
/*  434 */     this.jPanel47.add(this.jTextField104);
/*      */     
/*  436 */     this.jPanel46.add(this.jPanel47);
/*      */     
/*  438 */     this.jPanel48.setBackground(new Color(255, 255, 255));
/*  439 */     this.jPanel48.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  441 */     this.jLabel101.setHorizontalAlignment(4);
/*  442 */     this.jLabel101.setText("Forma de Pago");
/*  443 */     this.jPanel48.add(this.jLabel101);
/*      */     
/*  445 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  446 */     this.jComboBox21.setEditable(true);
/*  447 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "EFECTIVO", "OTRO" }));
/*  448 */     this.jPanel48.add(this.jComboBox21);
/*      */     
/*  450 */     this.jPanel46.add(this.jPanel48);
/*      */     
/*  452 */     this.jPanel49.setBackground(new Color(255, 255, 255));
/*  453 */     this.jPanel49.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  455 */     this.jLabel102.setHorizontalAlignment(4);
/*  456 */     this.jLabel102.setText("Fecha de Compra");
/*  457 */     this.jPanel49.add(this.jLabel102);
/*      */     
/*  459 */     this.jDateChooser1.setDate(this.fechaActual);
/*  460 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/*  461 */     this.jDateChooser1.setIcon(this.icon);
/*  462 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/*  463 */     this.jPanel49.add((Component)this.jDateChooser1);
/*      */     
/*  465 */     this.jPanel46.add(this.jPanel49);
/*      */     
/*  467 */     this.jPanel40.setBackground(new Color(255, 255, 255));
/*  468 */     this.jPanel40.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  470 */     this.jPanel50.setBackground(new Color(255, 255, 255));
/*  471 */     this.jPanel50.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  473 */     this.jLabel5.setHorizontalAlignment(4);
/*  474 */     this.jLabel5.setText("Color");
/*  475 */     this.jPanel50.add(this.jLabel5);
/*      */     
/*  477 */     this.jTextField105.setText("jTextField105");
/*  478 */     this.jPanel50.add(this.jTextField105);
/*      */     
/*  480 */     this.jPanel40.add(this.jPanel50);
/*      */     
/*  482 */     this.jPanel51.setBackground(new Color(255, 255, 255));
/*  483 */     this.jPanel51.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  485 */     this.jLabel103.setHorizontalAlignment(4);
/*  486 */     this.jLabel103.setText("Peso");
/*  487 */     this.jPanel51.add(this.jLabel103);
/*      */     
/*  489 */     this.jTextField106.setHorizontalAlignment(4);
/*  490 */     this.jTextField106.setText("jTextField106");
/*  491 */     this.jPanel51.add(this.jTextField106);
/*      */     
/*  493 */     this.jPanel40.add(this.jPanel51);
/*      */     
/*  495 */     this.jPanel52.setBackground(new Color(255, 255, 255));
/*  496 */     this.jPanel52.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  498 */     this.jLabel104.setHorizontalAlignment(4);
/*  499 */     this.jLabel104.setText("Dimensión");
/*  500 */     this.jPanel52.add(this.jLabel104);
/*      */     
/*  502 */     this.jTextField107.setText("jTextField107");
/*  503 */     this.jPanel52.add(this.jTextField107);
/*      */     
/*  505 */     this.jPanel40.add(this.jPanel52);
/*      */     
/*  507 */     this.jPanel53.setBackground(new Color(255, 255, 255));
/*  508 */     this.jPanel53.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  510 */     this.jPanel54.setBackground(new Color(255, 255, 255));
/*  511 */     this.jPanel54.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  513 */     this.jLabel105.setHorizontalAlignment(4);
/*  514 */     this.jLabel105.setText("Marca");
/*  515 */     this.jPanel54.add(this.jLabel105);
/*      */     
/*  517 */     this.jPanel57.setBackground(new Color(255, 255, 255));
/*      */     
/*  519 */     this.jButton38.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  520 */     this.jButton38.setMnemonic('F');
/*  521 */     this.jButton38.setToolTipText("Filtrar información (Alt+F)");
/*  522 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  524 */             UnidadesRemolques.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  528 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/*      */     
/*  530 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  531 */     this.jPanel57.setLayout(jPanel57Layout);
/*  532 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  533 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  534 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  535 */           .addComponent(this.jComboBox22, 0, 68, 32767)
/*  536 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  537 */           .addComponent(this.jButton38, -2, 20, -2)
/*  538 */           .addGap(0, 0, 0)));
/*      */     
/*  540 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  542 */         .addComponent(this.jButton38, -2, 24, -2)
/*  543 */         .addComponent(this.jComboBox22, GroupLayout.Alignment.TRAILING, -2, 25, -2));
/*      */ 
/*      */     
/*  546 */     this.jPanel54.add(this.jPanel57);
/*      */     
/*  548 */     this.jPanel53.add(this.jPanel54);
/*      */     
/*  550 */     this.jPanel56.setBackground(new Color(255, 255, 255));
/*  551 */     this.jPanel56.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  553 */     this.jLabel107.setHorizontalAlignment(4);
/*  554 */     this.jLabel107.setText("Tipo");
/*  555 */     this.jPanel56.add(this.jLabel107);
/*      */     
/*  557 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/*  558 */     this.jComboBox23.setEditable(true);
/*  559 */     this.jPanel56.add(this.jComboBox23);
/*      */     
/*  561 */     this.jPanel53.add(this.jPanel56);
/*      */     
/*  563 */     this.jPanel55.setBackground(new Color(255, 255, 255));
/*  564 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  566 */     this.jLabel112.setHorizontalAlignment(4);
/*  567 */     this.jLabel112.setText("Tipo de remolque");
/*  568 */     this.jPanel55.add(this.jLabel112);
/*      */     
/*  570 */     this.jPanel133.setBackground(new Color(255, 255, 255));
/*      */     
/*  572 */     this.jTextField85.setEditable(false);
/*      */     
/*  574 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  575 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  577 */             UnidadesRemolques.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  581 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/*  582 */     this.jPanel133.setLayout(jPanel133Layout);
/*  583 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/*  584 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  585 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  586 */           .addComponent(this.jTextField85, -1, 70, 32767)
/*  587 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  588 */           .addComponent(this.jButton56, -2, 18, -2)));
/*      */     
/*  590 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/*  591 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  592 */         .addComponent(this.jTextField85)
/*  593 */         .addComponent(this.jButton56, -2, 0, 32767));
/*      */ 
/*      */     
/*  596 */     this.jPanel55.add(this.jPanel133);
/*      */     
/*  598 */     this.jPanel53.add(this.jPanel55);
/*      */     
/*  600 */     this.jPanel64.setBackground(new Color(255, 255, 255));
/*  601 */     this.jPanel64.setLayout(new GridLayout(1, 3, 18, 0));
/*      */     
/*  603 */     this.jPanel65.setBackground(new Color(255, 255, 255));
/*  604 */     this.jPanel65.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  606 */     this.jLabel109.setHorizontalAlignment(4);
/*  607 */     this.jLabel109.setText("Estado");
/*  608 */     this.jPanel65.add(this.jLabel109);
/*      */     
/*  610 */     this.jComboBox24.setBackground(new Color(244, 244, 244));
/*  611 */     this.jComboBox24.setEditable(true);
/*  612 */     this.jComboBox24.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "BAJA", "DESMANTELADO", "PLAN DE PISO", "ROBADO", "SINIESTRADO", "VENDIDO", "OTRO" }));
/*  613 */     this.jPanel65.add(this.jComboBox24);
/*      */     
/*  615 */     this.jPanel64.add(this.jPanel65);
/*      */     
/*  617 */     this.jPanel66.setBackground(new Color(255, 255, 255));
/*  618 */     this.jPanel66.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  620 */     this.jLabel110.setHorizontalAlignment(4);
/*  621 */     this.jLabel110.setText("Sucursal");
/*  622 */     this.jPanel66.add(this.jLabel110);
/*      */     
/*  624 */     this.jComboBox25.setBackground(new Color(244, 244, 244));
/*  625 */     this.jComboBox25.setModel(new DefaultComboBoxModel<>(new String[] { "CRÉDITO", "CONTADO", "OTRO" }));
/*  626 */     this.jPanel66.add(this.jComboBox25);
/*      */     
/*  628 */     this.jPanel64.add(this.jPanel66);
/*      */     
/*  630 */     this.jPanel67.setBackground(new Color(255, 255, 255));
/*  631 */     this.jPanel67.setLayout(new GridLayout(1, 2, 6, 0));
/*  632 */     this.jPanel64.add(this.jPanel67);
/*      */     
/*  634 */     this.jPanel59.setBackground(new Color(255, 255, 255));
/*      */     
/*  636 */     this.jPanel60.setBackground(this.lc.SECUNDARIO1);
/*  637 */     this.jPanel60.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/*  639 */     this.jLabel108.setFont(new Font("Quicksand", 1, 13));
/*  640 */     this.jLabel108.setForeground(new Color(255, 255, 255));
/*  641 */     this.jLabel108.setHorizontalAlignment(0);
/*  642 */     this.jLabel108.setText(" Sección de Permisos, Seguro y Documentación");
/*  643 */     this.jPanel60.add(this.jLabel108);
/*      */     
/*  645 */     this.jLabel111.setFont(new Font("Quicksand", 1, 13));
/*  646 */     this.jLabel111.setForeground(new Color(255, 255, 255));
/*  647 */     this.jLabel111.setHorizontalAlignment(0);
/*  648 */     this.jLabel111.setText("Comentarios");
/*  649 */     this.jPanel60.add(this.jLabel111);
/*      */     
/*  651 */     this.jPanel61.setBackground(new Color(255, 255, 255));
/*  652 */     this.jPanel61.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/*  654 */     this.jPanel63.setBackground(new Color(255, 255, 255));
/*      */     
/*  656 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  664 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  669 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  672 */     this.rSTableMetro2.setAltoHead(25);
/*  673 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  674 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  675 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  676 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  677 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  678 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  679 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  680 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  681 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  682 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  683 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  684 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  685 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  686 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  687 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  689 */             UnidadesRemolques.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  692 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  694 */             UnidadesRemolques.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  697 */     this.jScrollPane10.setViewportView((Component)this.rSTableMetro2);
/*      */     
/*  699 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  700 */     this.jButton53.setToolTipText("Nuevo");
/*  701 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  703 */             UnidadesRemolques.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  707 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  708 */     this.jButton54.setToolTipText("Modificar");
/*  709 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  711 */             UnidadesRemolques.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  715 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  716 */     this.jButton55.setToolTipText("Eliminar");
/*  717 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  719 */             UnidadesRemolques.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  723 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/*  724 */     this.jPanel63.setLayout(jPanel63Layout);
/*  725 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/*  726 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  727 */         .addComponent(this.jScrollPane10, -2, 0, 32767)
/*  728 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  729 */           .addGap(0, 215, 32767)
/*  730 */           .addComponent(this.jButton53)
/*  731 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  732 */           .addComponent(this.jButton54)
/*  733 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  734 */           .addComponent(this.jButton55)));
/*      */     
/*  736 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/*  737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  738 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  739 */           .addComponent(this.jScrollPane10, -1, 221, 32767)
/*  740 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  741 */           .addGroup(jPanel63Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  742 */             .addComponent(this.jButton53, -2, 26, -2)
/*  743 */             .addComponent(this.jButton54, -2, 26, -2)
/*  744 */             .addComponent(this.jButton55, -2, 26, -2))));
/*      */ 
/*      */     
/*  747 */     this.jPanel61.add(this.jPanel63);
/*      */     
/*  749 */     this.jScrollPane11.setViewportView(this.jTextPane1);
/*      */     
/*  751 */     this.jPanel61.add(this.jScrollPane11);
/*      */     
/*  753 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/*  754 */     this.jPanel59.setLayout(jPanel59Layout);
/*  755 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/*  756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  757 */         .addComponent(this.jPanel60, -1, -1, 32767)
/*  758 */         .addComponent(this.jPanel61, -2, 0, 32767));
/*      */     
/*  760 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/*  761 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  762 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  763 */           .addComponent(this.jPanel60, -2, -1, -2)
/*  764 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  765 */           .addComponent(this.jPanel61, -1, -1, 32767)));
/*      */ 
/*      */     
/*  768 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/*  769 */     this.jPanel16.setLayout(jPanel16Layout);
/*  770 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/*  771 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  772 */         .addComponent(this.jPanel41, -1, -1, 32767)
/*  773 */         .addComponent(this.jPanel59, -1, -1, 32767)
/*  774 */         .addComponent(this.jPanel36, -1, -1, 32767)
/*  775 */         .addComponent(this.jPanel42, -1, -1, 32767)
/*  776 */         .addComponent(this.jPanel46, -2, 0, 32767)
/*  777 */         .addComponent(this.jPanel40, -1, -1, 32767)
/*  778 */         .addComponent(this.jPanel53, -2, 0, 32767)
/*  779 */         .addComponent(this.jPanel64, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/*  781 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/*  782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  783 */         .addGroup(jPanel16Layout.createSequentialGroup()
/*  784 */           .addComponent(this.jPanel36, -2, -1, -2)
/*  785 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  786 */           .addComponent(this.jPanel42, -2, -1, -2)
/*  787 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  788 */           .addComponent(this.jPanel46, -2, 24, -2)
/*  789 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  790 */           .addComponent(this.jPanel40, -2, -1, -2)
/*  791 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  792 */           .addComponent(this.jPanel53, -2, 26, -2)
/*  793 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  794 */           .addComponent(this.jPanel64, -2, 25, -2)
/*  795 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  796 */           .addComponent(this.jPanel59, -1, -1, 32767)
/*  797 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  798 */           .addComponent(this.jPanel41, -2, -1, -2)));
/*      */ 
/*      */     
/*  801 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  802 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  803 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  804 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  805 */         .addComponent(this.jPanel16, -1, -1, 32767));
/*      */     
/*  807 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  808 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  809 */         .addComponent(this.jPanel16, -2, -1, -2));
/*      */ 
/*      */     
/*  812 */     this.jDialog2.setTitle("Tipo de documento");
/*  813 */     this.jDialog2.setModal(true);
/*      */     
/*  815 */     this.jPanel70.setLayout(new GridLayout(10, 0, 0, 2));
/*      */     
/*  817 */     this.jRadioButton1.setSelected(true);
/*  818 */     this.jRadioButton1.setText("Tarjetas de Circulación");
/*  819 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  821 */             UnidadesRemolques.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  824 */     this.jPanel70.add(this.jRadioButton1);
/*      */     
/*  826 */     this.jRadioButton2.setText("Póliza de Seguro");
/*  827 */     this.jPanel70.add(this.jRadioButton2);
/*      */     
/*  829 */     this.jRadioButton3.setText("Sedema");
/*  830 */     this.jPanel70.add(this.jRadioButton3);
/*      */     
/*  832 */     this.jRadioButton4.setText("Nom 012");
/*  833 */     this.jPanel70.add(this.jRadioButton4);
/*      */     
/*  835 */     this.jRadioButton5.setText("Inspección");
/*  836 */     this.jPanel70.add(this.jRadioButton5);
/*      */     
/*  838 */     this.jRadioButton6.setText("Fisicomecánica");
/*  839 */     this.jPanel70.add(this.jRadioButton6);
/*      */     
/*  841 */     this.jRadioButton7.setText("Sct");
/*  842 */     this.jPanel70.add(this.jRadioButton7);
/*      */     
/*  844 */     this.jRadioButton8.setText("Pago");
/*  845 */     this.jPanel70.add(this.jRadioButton8);
/*      */     
/*  847 */     this.jRadioButton9.setText("Otro");
/*  848 */     this.jPanel70.add(this.jRadioButton9);
/*      */     
/*  850 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/*  851 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/*  852 */     this.materialButton39.setMnemonic('S');
/*  853 */     this.materialButton39.setText("Siguiente >>");
/*  854 */     this.materialButton39.setToolTipText("Siguiente (Alt+S)");
/*  855 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/*  856 */     this.materialButton39.setHorizontalTextPosition(0);
/*  857 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  859 */             UnidadesRemolques.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  863 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  864 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  865 */     this.materialButton38.setMnemonic('C');
/*  866 */     this.materialButton38.setText("Cerrar");
/*  867 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/*  868 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/*  869 */     this.materialButton38.setHorizontalTextPosition(0);
/*  870 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  872 */             UnidadesRemolques.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  876 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  877 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  878 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  879 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  880 */         .addComponent(this.jPanel70, -1, -1, 32767)
/*  881 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  882 */           .addGap(0, 0, 32767)
/*  883 */           .addComponent((Component)this.materialButton39, -2, 150, -2)
/*  884 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  885 */           .addComponent((Component)this.materialButton38, -2, 105, -2)));
/*      */     
/*  887 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  888 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  889 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  890 */           .addComponent(this.jPanel70, -1, -1, 32767)
/*  891 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  892 */           .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  893 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/*  894 */             .addComponent((Component)this.materialButton39, -2, 38, -2))
/*  895 */           .addContainerGap()));
/*      */ 
/*      */     
/*  898 */     this.jDialog3.setTitle("Marcas");
/*  899 */     this.jDialog3.setUndecorated(true);
/*      */     
/*  901 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  909 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  914 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  917 */     this.rSTableMetro3.setAltoHead(25);
/*  918 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  919 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  920 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  921 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  922 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  923 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  924 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  925 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  926 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  927 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  928 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  929 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  930 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  931 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  932 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  934 */             UnidadesRemolques.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  937 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  939 */             UnidadesRemolques.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  942 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  944 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  945 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  947 */             UnidadesRemolques.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  951 */     this.jButton59.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  952 */     this.jButton59.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  954 */             UnidadesRemolques.this.jButton59ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  958 */     this.jButton61.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  959 */     this.jButton61.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  961 */             UnidadesRemolques.this.jButton61ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  965 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  967 */             UnidadesRemolques.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/*  970 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  972 */             UnidadesRemolques.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  976 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/*  977 */     this.jPanel136.setLayout(jPanel136Layout);
/*  978 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/*  979 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  980 */         .addComponent(this.jScrollPane33, -1, 418, 32767)
/*  981 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/*  982 */           .addContainerGap()
/*  983 */           .addComponent(this.jTextField17, -2, 179, -2)
/*  984 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  985 */           .addComponent(this.jButton58)
/*  986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */           .addComponent(this.jButton59)
/*  988 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  989 */           .addComponent(this.jButton61)
/*  990 */           .addContainerGap()));
/*      */     
/*  992 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/*  993 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  994 */         .addGroup(jPanel136Layout.createSequentialGroup()
/*  995 */           .addComponent(this.jScrollPane33, -1, 172, 32767)
/*  996 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  997 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  998 */             .addComponent(this.jButton58, -2, 26, -2)
/*  999 */             .addComponent(this.jButton59, -2, 26, -2)
/* 1000 */             .addComponent(this.jButton61, -2, 26, -2)
/* 1001 */             .addComponent(this.jTextField17, -2, -1, -2))));
/*      */ 
/*      */     
/* 1004 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1005 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1006 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1007 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1008 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
/* 1009 */           .addGap(0, 0, 0)
/* 1010 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/*      */     
/* 1012 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1013 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1014 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1015 */           .addComponent(this.jPanel136, -1, -1, 32767)
/* 1016 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1019 */     this.jDialog4.setTitle("Marcas");
/* 1020 */     this.jDialog4.setModal(true);
/*      */     
/* 1022 */     this.jLabel34.setText("Ingresa el nombre de la marca");
/*      */     
/* 1024 */     this.jTextField24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1026 */             UnidadesRemolques.this.jTextField24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1030 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/* 1031 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 1032 */     this.materialButton24.setMnemonic('C');
/* 1033 */     this.materialButton24.setText("Cerrar");
/* 1034 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/* 1035 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 1036 */     this.materialButton24.setHorizontalTextPosition(0);
/* 1037 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1039 */             UnidadesRemolques.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1043 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/* 1044 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/* 1045 */     this.materialButton25.setMnemonic('G');
/* 1046 */     this.materialButton25.setText("Guardar");
/* 1047 */     this.materialButton25.setToolTipText("Guardar (Alt +G)");
/* 1048 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/* 1049 */     this.materialButton25.setHorizontalTextPosition(0);
/* 1050 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1052 */             UnidadesRemolques.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1056 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/* 1057 */     this.jPanel62.setLayout(jPanel62Layout);
/* 1058 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/* 1059 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1060 */         .addGroup(jPanel62Layout.createSequentialGroup()
/* 1061 */           .addContainerGap()
/* 1062 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1063 */             .addComponent(this.jTextField24)
/* 1064 */             .addComponent(this.jLabel34, -1, 455, 32767)
/* 1065 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/* 1066 */               .addGap(0, 0, 32767)
/* 1067 */               .addComponent((Component)this.materialButton25, -2, 150, -2)
/* 1068 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1069 */               .addComponent((Component)this.materialButton24, -2, 105, -2)))
/* 1070 */           .addContainerGap()));
/*      */     
/* 1072 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/* 1073 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1074 */         .addGroup(jPanel62Layout.createSequentialGroup()
/* 1075 */           .addComponent(this.jLabel34, -2, 26, -2)
/* 1076 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1077 */           .addComponent(this.jTextField24, -2, -1, -2)
/* 1078 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1079 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1080 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/* 1081 */             .addComponent((Component)this.materialButton25, -2, 38, -2))
/* 1082 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1085 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1086 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1087 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1088 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1089 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1090 */           .addComponent(this.jPanel62, -2, -1, -2)
/* 1091 */           .addGap(0, 0, 32767)));
/*      */     
/* 1093 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1094 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1095 */         .addComponent(this.jPanel62, -1, -1, 32767));
/*      */ 
/*      */     
/* 1098 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1109 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 1111 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1112 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1113 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1114 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1115 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1116 */           .addContainerGap()
/* 1117 */           .addComponent(this.jScrollPane1, -2, -1, -2)
/* 1118 */           .addContainerGap(52, 32767)));
/*      */     
/* 1120 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1121 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1122 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1123 */           .addContainerGap()
/* 1124 */           .addComponent(this.jScrollPane1, -2, -1, -2)
/* 1125 */           .addContainerGap(30, 32767)));
/*      */ 
/*      */     
/* 1128 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1130 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1132 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 1133 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/* 1134 */     this.jLabel98.setHorizontalAlignment(0);
/* 1135 */     this.jLabel98.setText("Remolques");
/*      */     
/* 1137 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1138 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1139 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1141 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*      */     
/* 1143 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1144 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1145 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1146 */           .addContainerGap()
/* 1147 */           .addComponent(this.jLabel98)
/* 1148 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1151 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 1152 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1154 */     this.jTextField60.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1156 */             UnidadesRemolques.this.jTextField60KeyReleased(evt);
/*      */           }
/*      */         });
/* 1159 */     this.jPanel35.add(this.jTextField60);
/*      */     
/* 1161 */     this.jTextField61.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1163 */             UnidadesRemolques.this.jTextField61KeyReleased(evt);
/*      */           }
/*      */         });
/* 1166 */     this.jPanel35.add(this.jTextField61);
/*      */     
/* 1168 */     this.jTextField62.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1170 */             UnidadesRemolques.this.jTextField62KeyReleased(evt);
/*      */           }
/*      */         });
/* 1173 */     this.jPanel35.add(this.jTextField62);
/*      */     
/* 1175 */     this.jTextField63.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1177 */             UnidadesRemolques.this.jTextField63ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1180 */     this.jTextField63.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1182 */             UnidadesRemolques.this.jTextField63KeyReleased(evt);
/*      */           }
/*      */         });
/* 1185 */     this.jPanel35.add(this.jTextField63);
/*      */     
/* 1187 */     this.jTextField64.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1189 */             UnidadesRemolques.this.jTextField64KeyReleased(evt);
/*      */           }
/*      */         });
/* 1192 */     this.jPanel35.add(this.jTextField64);
/*      */     
/* 1194 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1195 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "MODELO" }));
/* 1196 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1198 */             UnidadesRemolques.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1201 */     this.jPanel35.add(this.jComboBox9);
/*      */     
/* 1203 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 1204 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 1205 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1207 */             UnidadesRemolques.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1210 */     this.jPanel35.add(this.jComboBox10);
/*      */     
/* 1212 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 1213 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL" }));
/* 1214 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1216 */             UnidadesRemolques.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1219 */     this.jPanel35.add(this.jComboBox11);
/*      */     
/* 1221 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1223 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 1224 */     this.jPanel12.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1226 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 1227 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1229 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1230 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 1231 */     this.jLabel99.setHorizontalAlignment(4);
/* 1232 */     this.jLabel99.setText("Total");
/* 1233 */     this.jPanel15.add(this.jLabel99);
/*      */     
/* 1235 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1236 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 1237 */     this.jLabel100.setHorizontalAlignment(2);
/* 1238 */     this.jLabel100.setText("t");
/* 1239 */     this.jPanel15.add(this.jLabel100);
/*      */     
/* 1241 */     this.jPanel12.add(this.jPanel15);
/*      */     
/* 1243 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1245 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1246 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1247 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1248 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1249 */         .addGap(0, 66, 32767));
/*      */     
/* 1251 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1252 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1253 */         .addGap(0, 37, 32767));
/*      */ 
/*      */     
/* 1256 */     this.jPanel12.add(this.jPanel14);
/*      */     
/* 1258 */     this.jButton35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1259 */     this.jButton35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1260 */     this.jButton35.setMnemonic('N');
/* 1261 */     this.jButton35.setText("Nuevo");
/* 1262 */     this.jButton35.setToolTipText("Nuevo Reseteo (Alt + N)");
/* 1263 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1265 */             UnidadesRemolques.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1268 */     this.jPanel12.add(this.jButton35);
/*      */     
/* 1270 */     this.jButton36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1271 */     this.jButton36.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1272 */     this.jButton36.setMnemonic('M');
/* 1273 */     this.jButton36.setText("Modificar");
/* 1274 */     this.jButton36.setToolTipText("Modificar (Alt + M)");
/* 1275 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1277 */             UnidadesRemolques.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1280 */     this.jPanel12.add(this.jButton36);
/*      */     
/* 1282 */     this.jButton37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1283 */     this.jButton37.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1284 */     this.jButton37.setMnemonic('E');
/* 1285 */     this.jButton37.setText("Eliminar");
/* 1286 */     this.jButton37.setToolTipText("Eliminar (Alt+E)");
/* 1287 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1289 */             UnidadesRemolques.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1292 */     this.jPanel12.add(this.jButton37);
/*      */     
/* 1294 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1295 */     this.jButton34.setMnemonic('I');
/* 1296 */     this.jButton34.setText("Imprimir");
/* 1297 */     this.jButton34.setToolTipText("Imprimir Reporte (Alt+I)");
/* 1298 */     this.jButton34.setEnabled(false);
/* 1299 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1301 */             UnidadesRemolques.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1304 */     this.jPanel12.add(this.jButton34);
/*      */     
/* 1306 */     this.jButton33.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1307 */     this.jButton33.setMnemonic('G');
/* 1308 */     this.jButton33.setText("Guardar Reporte");
/* 1309 */     this.jButton33.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1310 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1312 */             UnidadesRemolques.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1315 */     this.jPanel12.add(this.jButton33);
/*      */     
/* 1317 */     this.jScrollPane8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1319 */             UnidadesRemolques.this.jScrollPane8MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1323 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1331 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1336 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1339 */     this.rSTableMetro1.setAltoHead(40);
/* 1340 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1341 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1342 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1343 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1344 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1345 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1346 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1347 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1348 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1349 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1350 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1351 */     this.rSTableMetro1.setRowHeight(18);
/* 1352 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1353 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1354 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1355 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1357 */             UnidadesRemolques.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1360 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1362 */             UnidadesRemolques.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1365 */     this.jScrollPane8.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1367 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1368 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1369 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1370 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1371 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1372 */           .addComponent(this.jScrollPane8, -2, 2032, -2)
/* 1373 */           .addGap(0, 0, 32767)));
/*      */     
/* 1375 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1376 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1377 */         .addComponent(this.jScrollPane8, -1, 195, 32767));
/*      */ 
/*      */     
/* 1380 */     this.jScrollPane9.setViewportView(this.jPanel13);
/*      */     
/* 1382 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1383 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1384 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1386 */         .addComponent(this.jPanel12, -2, 0, 32767)
/* 1387 */         .addComponent(this.jScrollPane9, -1, 498, 32767));
/*      */     
/* 1389 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1390 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1391 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1392 */           .addComponent(this.jScrollPane9, -1, 207, 32767)
/* 1393 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1394 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 1395 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1398 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1399 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1400 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1402 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 1403 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 1404 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/* 1406 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1407 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1408 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1409 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1410 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1411 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1412 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1413 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1416 */     GroupLayout layout = new GroupLayout(this);
/* 1417 */     setLayout(layout);
/* 1418 */     layout.setHorizontalGroup(layout
/* 1419 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1420 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1422 */     layout.setVerticalGroup(layout
/* 1423 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1424 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */   }
/*      */   private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane33; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JTable jTable1; private JTextField jTextField100; private JTextField jTextField101; private JTextField jTextField102; private JTextField jTextField104; private JTextField jTextField105; private JTextField jTextField106; private JTextField jTextField107; private JTextField jTextField17; private JTextField jTextField24; private JTextField jTextField60; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField63; private JTextField jTextField64; private JTextField jTextField85; private JTextPane jTextPane1; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton24; private MaterialButton materialButton25; private MaterialButton materialButton38; private MaterialButton materialButton39; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private void jTextField60KeyReleased(KeyEvent evt) {
/* 1429 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField61KeyReleased(KeyEvent evt) {
/* 1433 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField62KeyReleased(KeyEvent evt) {
/* 1437 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField63ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField63KeyReleased(KeyEvent evt) {
/* 1445 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField64KeyReleased(KeyEvent evt) {
/* 1449 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 1453 */     if (this.PRIMERA) {
/* 1454 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 1459 */     if (this.PRIMERA) {
/* 1460 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 1465 */     if (this.PRIMERA) {
/* 1466 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 1471 */     limpiar();
/* 1472 */     habilitar();
/*      */     
/* 1474 */     this.materialButton22.setText("Guardar");
/* 1475 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 1476 */     this.materialButton22.setMnemonic('G');
/* 1477 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 1481 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1482 */     if (ind < 0) {
/* 1483 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar los datos", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1485 */       limpiar();
/* 1486 */       habilitar();
/* 1487 */       verUnidad();
/*      */       
/* 1489 */       this.materialButton22.setText("Modificar");
/* 1490 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 1491 */       this.materialButton22.setMnemonic('M');
/* 1492 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {
/* 1497 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1498 */     if (ind < 0) {
/* 1499 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder darlo de baja", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1501 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Al eliminar la unidad, todos los documentos registrados pasarán a BAJA<p><b> ¿Estás seguro que deseas eliminar el remolque que seleccionaste?</b></html>", "Eliminar registro", 0, 3, this.ELIMINAR);
/* 1502 */       if (res == 0) {
/* 1503 */         String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 14));
/* 1504 */         if (estatus.contains("BAJA")) {
/* 1505 */           JOptionPane.showMessageDialog(this.padre, "El remolque que seleccionaste ya se encuentra dado de baja, verifica tus datos", "No se puede cancelar", 0, this.ERROR);
/*      */         } else {
/* 1507 */           String numEco = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 1508 */           eliminarDoc(numEco);
/* 1509 */           this.con.inserSinMsj("update remolque set estado = 'BAJA' where num_rem = " + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/* 1510 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 1518 */       if (!this.rSTableMetro1.print());
/*      */     }
/* 1520 */     catch (PrinterException printerException) {}
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 1525 */     String[] datos = { "ECO", "MODELO", "SERIE", "PLACAS", "FACTURA / PAGO", "MARCA", "TIPO", "TARJETA DE CIRCULACIÓN", "PÓLIZA", "SEDEMA", "NOM 012", "INSPECCIÓN", "FISICOMECÁNICA", "SCT", "ESTADO", "SUCURSAL", "USUARIO" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1532 */     this.esc = new EscribirReporte("REMOLQUES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1536 */     if (evt.getClickCount() == 2) {
/* 1537 */       limpiar();
/* 1538 */       desabilitar();
/* 1539 */       verUnidad();
/* 1540 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jScrollPane8MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 1553 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 1557 */     if (this.jTextField100.getText().equals("")) {
/* 1558 */       this.jTextField100.setBackground(Color.RED);
/* 1559 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número económico del remolque", "Ingresa el Remolque", 0, this.ADVER);
/* 1560 */     } else if (!this.val.validarSoloNum(this.jTextField100, this.jTextField100.getText())) {
/* 1561 */       if (this.con.consultar("num_rem", "remolque", "where num_rem = " + this.jTextField100.getText()) && this.materialButton22.getText().equals("Guardar")) {
/* 1562 */         this.jTextField100.setBackground(new Color(255, 51, 51));
/* 1563 */         JOptionPane.showMessageDialog(this.padre, "El número de REMOLQUE que colocaste ya se encuentra registrado en la base de datos", "Número registrado", 0, this.ERROR); return;
/*      */       } 
/* 1565 */       if (this.jTextField102.getText().equals("")) {
/* 1566 */         this.jTextField102.setBackground(Color.RED);
/* 1567 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el número de placas", "Ingresa las placas", 0, this.ADVER);
/* 1568 */       } else if (this.jDateChooser1.getDate() == null) {
/* 1569 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la fecha de compra", "Falta fecha de compra", 0, this.ADVER);
/* 1570 */       } else if (this.jComboBox22.getSelectedIndex() == 0) {
/* 1571 */         this.jComboBox22.setBackground(Color.RED);
/* 1572 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar la marca del vehículo", "Falta marca", 0, this.ADVER);
/* 1573 */       } else if (this.jComboBox23.getSelectedItem().equals("")) {
/* 1574 */         this.jComboBox23.setBackground(Color.RED);
/* 1575 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar el tipo del vehículo", "Falta tipo", 0, this.ADVER);
/* 1576 */       } else if (this.jTextField85.getText().equals("")) {
/* 1577 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar el tipo de Vehículo de acuerdo al catálogo del SAT", "Falta Tipo", 0, this.ADVER);
/* 1578 */       } else if (this.jComboBox24.getSelectedItem().equals("")) {
/* 1579 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar el estado del vehículo", "Falta Estado", 0, this.ADVER);
/* 1580 */       } else if (this.materialButton22.getText().equals("Guardar")) {
/* 1581 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar la información del nuevo vehículo?", "Crear Nuevo", 0, 3, this.PREG);
/* 1582 */         if (res == 0) {
/* 1583 */           String tc = "";
/* 1584 */           String poliza = "";
/* 1585 */           String sedema = "";
/* 1586 */           String nom012 = "";
/* 1587 */           String verificacion = "";
/* 1588 */           String fisicomecanica = "";
/* 1589 */           String sct = "";
/*      */           
/* 1591 */           for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1592 */             String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1593 */             if (v.equals("TARJETA DE CIRCULACIÓN")) {
/* 1594 */               tc = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1595 */             } else if (v.equals("PÓLIZA DE SEGURO")) {
/* 1596 */               poliza = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1597 */             } else if (v.equals("SEDEMA")) {
/* 1598 */               sedema = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1599 */             } else if (v.equals("NOM 012")) {
/* 1600 */               nom012 = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1601 */             } else if (v.equals("INSPECCIÓN")) {
/* 1602 */               verificacion = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1603 */             } else if (v.equals("FISICOMECÁNICA")) {
/* 1604 */               fisicomecanica = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1605 */             } else if (v.equals("SCT")) {
/* 1606 */               sct = this.rSTableMetro2.getValueAt(i, 2).toString();
/*      */             } 
/*      */           } 
/* 1609 */           this.con.inserSinMsj("insert into remolque ( num_rem, modelo, no_serie,placas, num_factu,forma_pago, fecha_compra, color,peso, dimen, marca, tipo, tc, poliza, sedema, nom012, inspeccion, fisicomecanica, sct, estado, sucursal, comentarios, usuario, claveTipoRem ) values (" + this.jTextField100
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1619 */               .getText().toUpperCase() + ", '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', '" + this.jTextField101.getText().toUpperCase() + "', '" + this.jTextField102
/* 1620 */               .getText().toUpperCase() + "', '" + this.jTextField104.getText().toUpperCase() + "', '" + this.jComboBox21
/* 1621 */               .getSelectedItem().toString().toUpperCase() + "', '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "', '" + this.jTextField105.getText().toUpperCase() + "', '" + this.jTextField106
/* 1622 */               .getText().toUpperCase() + "', '" + this.jTextField107.getText().toUpperCase() + "', '" + 
/* 1623 */               String.valueOf(this.jComboBox22.getSelectedItem()) + "', '" + this.jComboBox23.getSelectedItem().toString().toUpperCase() + "', '" + tc + "', '" + poliza + "', '" + sedema + "', '" + nom012 + "', '" + verificacion + "', '" + fisicomecanica + "','" + sct + "', '" + this.jComboBox24
/*      */ 
/*      */               
/* 1626 */               .getSelectedItem().toString().toUpperCase() + "', '" + String.valueOf(this.jComboBox25.getSelectedItem()) + "', '" + this.jTextPane1.getText().toUpperCase() + "', '" + this.utilerias.sacarUsuario(this.USUARIO) + "', '" + this.ClaveTipoAut + "')");
/*      */           
/* 1628 */           String clave = this.jTextField100.getText();
/* 1629 */           for (int j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/* 1630 */             insertarDocumentos(clave, this.rSTableMetro2.getValueAt(j, 1).toString());
/*      */           }
/* 1632 */           this.jDialog1.setVisible(false);
/* 1633 */           consultar();
/*      */         } 
/*      */       } else {
/*      */         
/* 1637 */         String estado = this.jComboBox24.getSelectedItem().toString().toUpperCase();
/* 1638 */         if (this.ESTADOSBAJA.containsValue(estado)) {
/* 1639 */           JOptionPane.showMessageDialog(this.jDialog1, "<html>Al seleccionar la unidad en estado: <b>" + estado + "</b>, los documentos se darán de baja en automático</html>", "Recordatorio", 0, this.ADVER);
/*      */         }
/*      */         
/* 1642 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar la información del vehículo?", "Modificar", 0, 3, this.PREG);
/* 1643 */         if (res == 0) {
/* 1644 */           String tc = "";
/* 1645 */           String poliza = "";
/* 1646 */           String sedema = "";
/* 1647 */           String nom012 = "";
/* 1648 */           String verificacion = "";
/* 1649 */           String fisicomecanica = "";
/* 1650 */           String sct = "";
/*      */           
/* 1652 */           for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1653 */             String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1654 */             if (v.equals("TARJETA DE CIRCULACIÓN")) {
/* 1655 */               tc = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1656 */             } else if (v.equals("PÓLIZA DE SEGURO")) {
/* 1657 */               poliza = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1658 */             } else if (v.equals("SEDEMA")) {
/* 1659 */               sedema = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1660 */             } else if (v.equals("NOM 012")) {
/* 1661 */               nom012 = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1662 */             } else if (v.equals("INSPECCIÓN")) {
/* 1663 */               verificacion = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1664 */             } else if (v.equals("FISICOMECÁNICA")) {
/* 1665 */               fisicomecanica = this.rSTableMetro2.getValueAt(i, 2).toString();
/* 1666 */             } else if (v.equals("SCT")) {
/* 1667 */               sct = this.rSTableMetro2.getValueAt(i, 2).toString();
/*      */             } 
/*      */           } 
/*      */           
/* 1671 */           this.con.inserSinMsj("update remolque set num_rem = " + this.jTextField100
/* 1672 */               .getText().toUpperCase() + ", modelo = '" + String.valueOf(this.jComboBox20.getSelectedItem()) + "', no_serie ='" + this.jTextField101.getText().toUpperCase() + "', placas = '" + this.jTextField102
/* 1673 */               .getText().toUpperCase() + "', num_factu='" + this.jTextField104.getText().toUpperCase() + "', forma_pago = '" + 
/* 1674 */               String.valueOf(this.jComboBox21.getSelectedItem()) + "', fecha_compra = '" + this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()) + "', color='" + this.jTextField105.getText().toUpperCase() + "', peso = '" + this.jTextField106
/* 1675 */               .getText().toUpperCase() + "', dimen='" + this.jTextField107.getText().toUpperCase() + "', marca = '" + 
/* 1676 */               String.valueOf(this.jComboBox22.getSelectedItem()) + "', tipo = '" + this.jComboBox23.getSelectedItem().toString().toUpperCase() + "', estado = '" + this.jComboBox24.getSelectedItem().toString().toUpperCase() + "', sucursal='" + 
/* 1677 */               String.valueOf(this.jComboBox25.getSelectedItem()) + "', comentarios ='" + this.jTextPane1.getText().toUpperCase() + "', usuario = '" + this.utilerias.sacarUsuario(this.USUARIO) + "', claveTipoRem = '" + this.ClaveTipoAut + "' where num_rem = " + 
/* 1678 */               String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */ 
/*      */           
/* 1681 */           if (this.ESTADOSBAJA.containsValue(estado)) {
/* 1682 */             String numEco = this.jTextField100.getText();
/* 1683 */             eliminarDoc(numEco);
/*      */           } 
/* 1685 */           this.jDialog1.setVisible(false);
/* 1686 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 1694 */     activarVentanas(this.jButton38);
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 1698 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1699 */     if (evt.getClickCount() == 2) {
/* 1700 */       String valor = this.rSTableMetro2.getValueAt(ind, 1).toString();
/* 1701 */       if (!valor.contains("FACTURA") || this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 1702 */         if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1703 */           UnidadesTractosDoc uni = this.DOCUMENTACION.get(this.rSTableMetro2.getValueAt(ind, 1));
/* 1704 */           uni.recibeDocumentacion(this.DOCUMENTACION);
/* 1705 */           uni.recibeTipoV("REM");
/* 1706 */           uni.setGUARDAR("MODIFICAR TEMPORAL");
/* 1707 */           uni.cargarDatos(uni.getInformacion());
/*      */         } else {
/* 1709 */           UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, this.rSTableMetro2.getValueAt(ind, 1).toString(), "VISUALIZAR");
/* 1710 */           unidad.recibeTipoV("REM");
/* 1711 */           unidad.consultarDoc(this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1712 */           unidad.desabilitar();
/* 1713 */           unidad.activarVentana();
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
/* 1724 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 1728 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1729 */     if (ind < 0) {
/* 1730 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/* 1732 */     else if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1733 */       UnidadesTractosDoc uni = this.DOCUMENTACION.get(this.rSTableMetro2.getValueAt(ind, 1));
/* 1734 */       uni.recibeDocumentacion(this.DOCUMENTACION);
/* 1735 */       uni.recibeTipoV("REM");
/* 1736 */       uni.setGUARDAR("MODIFICAR TEMPORAL");
/* 1737 */       uni.cargarDatos(uni.getInformacion());
/*      */     } else {
/* 1739 */       UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, this.rSTableMetro2.getValueAt(ind, 1).toString(), "MODIFICAR");
/* 1740 */       unidad.recibeTipoV("REM");
/* 1741 */       unidad.recibeDatos(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1742 */       unidad.consultarDoc(this.rSTableMetro2.getValueAt(ind, 0).toString());
/* 1743 */       unidad.activarVentana();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 1749 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 1750 */     if (ind < 0) {
/* 1751 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/* 1753 */     else if (this.rSTableMetro2.getValueAt(ind, 0).toString().equals("0")) {
/* 1754 */       this.DOCUMENTACION.remove(this.rSTableMetro2.getValueAt(ind, 1).toString());
/* 1755 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/*      */     } else {
/* 1757 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Al eliminar los documentos se borrarán en el sevidor y no se podrá recuperar la información que se encuentra enlazada a las unidades,<p> ¿Estás seguro que deseas eliminar definitivamente los datos?</html>", "Eliminar...", 0, 3, this.ELIMINAR);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1762 */       if (res == 0) {
/* 1763 */         String numDoc = this.rSTableMetro2.getValueAt(ind, 0).toString();
/* 1764 */         this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Archivo", "Tipo", "Act" }, "numArch, nombreArch, tipo, fecha", "unidadesarchivos", "where numDoc = " + numDoc);
/*      */ 
/*      */         
/*      */         int i;
/*      */         
/* 1769 */         for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1770 */           File fichero = new File(this.jTable1.getValueAt(i, 1).toString());
/* 1771 */           fichero.delete();
/*      */         } 
/* 1773 */         this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Num Doc", "Num Tracto" }, "numDoc, tracto.num_tracto", "tracto, unidadesdoctractos ", "where unidadesdoctractos.tipo = 'REM' and tracto.num_tracto = unidadesdoctractos.num_tracto and numDoc = " + numDoc);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1778 */         for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1779 */           this.con.inserSinMsj("update remolque set " + convertirTipoDocCampo(this.rSTableMetro2.getValueAt(ind, 1).toString()) + " = '' where num_rem = " + String.valueOf(this.jTable1.getValueAt(i, 1)));
/*      */         }
/* 1781 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/* 1782 */         this.con.eliminar2("unidadesarchivos", "where numDoc = " + numDoc);
/* 1783 */         this.con.eliminar2("unidadesdoctractos", "where tipo = 'REM' and numDoc = " + numDoc);
/* 1784 */         this.con.eliminar2("unidadesdocumentos", "where numDoc = " + numDoc);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 1795 */     if (existeDoc()) {
/* 1796 */       JOptionPane.showMessageDialog(this.jDialog2, "El tipo de documento ya se encuentra enlistado, necesitas modificarlo", "Documento Creado", 0, this.ERROR);
/*      */     } else {
/* 1798 */       this.jDialog2.setVisible(false);
/* 1799 */       String guardar = "APLICAR";
/* 1800 */       if (this.materialButton22.getText().equals("Guardar")) {
/* 1801 */         guardar = "TEMPORAL";
/*      */       } else {
/* 1803 */         this.DOCUMENTACION = new LinkedHashMap<>();
/*      */       } 
/* 1805 */       UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro2, this.CAMPOSGENERALES, this.CARPETAS, dameTipoDocSelec(), guardar);
/* 1806 */       unidad.recibeDocumentacion(this.DOCUMENTACION);
/* 1807 */       unidad.recibeTipoV("REM");
/* 1808 */       if (this.materialButton22.getText().equals("Modificar")) {
/* 1809 */         unidad.recibeDatos(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), "0");
/*      */       }
/* 1811 */       unidad.activarVentana();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 1816 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 1820 */     if (evt.getClickCount() == 2) {
/*      */       
/* 1822 */       this.jComboBox22.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*      */ 
/*      */ 
/*      */       
/* 1826 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 1836 */     this.jLabel34.setText("Ingresa el nombre de la marca");
/*      */ 
/*      */ 
/*      */     
/* 1840 */     this.jTextField24.setText("");
/* 1841 */     this.materialButton25.setText("Agregar");
/* 1842 */     this.materialButton25.setMnemonic('A');
/* 1843 */     this.materialButton25.setToolTipText("Agregar (Alt+A)");
/* 1844 */     this.jDialog4.setTitle("Agregar");
/* 1845 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton59ActionPerformed(ActionEvent evt) {
/* 1849 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1850 */     if (ind < 0) {
/* 1851 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1853 */       this.materialButton25.setText("Modificar");
/* 1854 */       this.materialButton25.setMnemonic('M');
/* 1855 */       this.materialButton25.setToolTipText("Modificar tipo (Alt+M)");
/* 1856 */       this.jTextField24.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/* 1857 */       this.jDialog4.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton61ActionPerformed(ActionEvent evt) {
/* 1862 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 1863 */     if (ind < 0) {
/* 1864 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 1866 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas eleiminar la información que seleccionaste?", "Eliminar...", 0, 3, this.PREG);
/* 1867 */       if (res == 0) {
/*      */         
/* 1869 */         this.con.eliminar("marca", "where id_marca=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 1870 */         llenarMarca();
/* 1871 */         consultarMarcas();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField17ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {
/* 1887 */     consultarMarcas();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField24ActionPerformed(ActionEvent evt) {
/* 1894 */     guardarMarcasTipos();
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 1898 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 1902 */     guardarMarcasTipos();
/*      */   }
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 1906 */     new TrasCatalogos(this.padre, true, this.jButton56, "tras_tipo_remolque", this.CLAVECONFIGAUT, "", true);
/* 1907 */     this.CLAVECONFIGAUT.forEach((x, y) -> this.jTextField85.setText(x + " - " + x));
/* 1908 */     this.jTextField85.setToolTipText(this.jTextField85.getText());
/* 1909 */     Set<String> keys = this.CLAVECONFIGAUT.keySet();
/* 1910 */     for (String key : keys) {
/* 1911 */       this.ClaveTipoAut = key;
/*      */     }
/*      */   }
/*      */   
/*      */   public void eliminarDoc(String numEco) {
/* 1916 */     String[] doc = this.con.regresaColIndex("unidadesdocumentos.numDoc", "unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.numDoc = unidadesdocumentos.numDoc and unidadesdocumentos.estado = 'ACTIVO' and unidadesdoctractos.tipo = '" + this.TIPOV + "' and unidadesdoctractos.num_tracto = " + numEco);
/*      */ 
/*      */ 
/*      */     
/* 1920 */     for (String d : doc) {
/* 1921 */       this.con.inserSinMsj("update unidadesdocumentos set estado = 'BAJA' where numDoc = " + d);
/*      */     }
/*      */   }
/*      */   
/*      */   public void guardarMarcasTipos() {
/* 1926 */     String marca = this.jTextField24.getText().toUpperCase();
/* 1927 */     if (marca.equals("")) {
/* 1928 */       this.jTextField24.setBackground(Color.RED);
/* 1929 */       JOptionPane.showMessageDialog(this.jDialog4, "No puedes dejar el campo vacío, por favor verifica tu información", "Falta información", 0, this.ADVER);
/*      */     }
/* 1931 */     else if (existeValor(this.MARCAS, this.jTextField24.getText().toUpperCase())) {
/* 1932 */       this.jTextField24.setBackground(Color.RED);
/* 1933 */       JOptionPane.showMessageDialog(this.jDialog4, "La marca que deseas agregar ya se encuentra almacenada, por favor verifica tu información", "Marca ya existe", 0, this.ADVER);
/* 1934 */     } else if (this.materialButton25.getText().equals("Agregar")) {
/* 1935 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar la nueva marca?", "Agregar nueva marca", 0, 3, this.PREG);
/* 1936 */       if (res == 0) {
/* 1937 */         this.con.inserSinMsj("insert into marca(marca) values('" + marca + "')");
/* 1938 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos) values (now(),'" + this.USUARIO + "','Almacenó una nueva marca de carro.','\nMarca: " + marca + "')");
/* 1939 */         llenarMarca();
/* 1940 */         this.jDialog3.setVisible(false);
/* 1941 */         this.jDialog4.setVisible(false);
/* 1942 */         this.jComboBox22.setSelectedItem(marca);
/*      */       } 
/*      */     } else {
/* 1945 */       this.con.inserSinMsj("update marca set marca ='" + this.jTextField24.getText().toUpperCase() + "' where marca ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 1946 */       this.rSTableMetro3.setValueAt(this.jTextField24.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 1947 */       llenarMarca();
/* 1948 */       this.jComboBox22.setSelectedItem(this.jTextField24.getText().toUpperCase());
/* 1949 */       this.jDialog4.setVisible(false);
/* 1950 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void verUnidad() {
/* 1956 */     String[] datos = this.con.regresaRegIndex("num_rem, modelo, no_serie, placas, num_factu, forma_pago, fecha_compra, color, peso, dimen, marca, tipo, estado, sucursal, comentarios, claveTipoRem", "remolque", "where num_rem= " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1961 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */     
/* 1963 */     this.jTextField100.setText(datos[0]);
/* 1964 */     this.jComboBox20.setSelectedItem(datos[1]);
/* 1965 */     this.jTextField101.setText(datos[2]);
/* 1966 */     this.jTextField102.setText(datos[3]);
/* 1967 */     this.jTextField104.setText(datos[4]);
/* 1968 */     this.jComboBox21.setSelectedItem(datos[5]);
/* 1969 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(datos[6]));
/* 1970 */     this.jTextField105.setText(datos[7]);
/* 1971 */     this.jTextField106.setText(datos[8]);
/* 1972 */     this.jTextField107.setText(datos[9]);
/* 1973 */     this.jComboBox22.setSelectedItem(datos[10]);
/* 1974 */     this.jComboBox23.setSelectedItem(datos[11]);
/* 1975 */     this.jComboBox24.setSelectedItem(datos[12]);
/* 1976 */     this.jComboBox25.setSelectedItem(datos[13]);
/* 1977 */     this.jTextPane1.setText(datos[14]);
/*      */     
/* 1979 */     this.encontrado = this.con2.consultar("descripcion", "tras_tipo_remolque", "where claveTipoRem = '" + datos[15] + "'");
/* 1980 */     if (this.encontrado) {
/* 1981 */       this.jTextField85.setText(datos[15] + " - " + datos[15]);
/* 1982 */       this.jTextField85.setToolTipText(datos[15] + " - " + datos[15]);
/*      */     } else {
/* 1984 */       this.jTextField85.setText("");
/* 1985 */       this.jTextField85.setToolTipText("");
/*      */     } 
/*      */     
/* 1988 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro2, new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" }, "unidadesdocumentos.numDoc, unidadesdocumentos.tipo, unidadesdocumentos.numeroUnico,unidadesdocumentos.fechaVencimiento, unidadesdocumentos.estado", "remolque, unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.tipo = 'REM' and remolque.num_rem = unidadesdoctractos.num_tracto and unidadesdocumentos.numDoc = unidadesdoctractos.numDoc and remolque.num_rem = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1993 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + " order by unidadesdocumentos.estado asc, unidadesdocumentos.tipo asc");
/*      */     
/* 1995 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2);
/* 1996 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 0, 50);
/* 1997 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 3, 100);
/* 1998 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 4, 60);
/* 1999 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 2000 */     this.rSTableMetro2.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 2004 */     System.out.println("priv " + (String)this.CAMPOSGENERALES.get("priv") + " " + this.PRIVILEGIOS.containsValue("SUPER USUARIO"));
/* 2005 */     if (this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 2006 */       this.jButton35.setEnabled(true);
/* 2007 */       this.jButton36.setEnabled(true);
/* 2008 */       this.jButton37.setEnabled(true);
/* 2009 */       this.materialButton22.setEnabled(true);
/* 2010 */       this.jButton53.setEnabled(true);
/* 2011 */       this.jButton54.setEnabled(true);
/* 2012 */       this.jButton55.setEnabled(true);
/*      */     } else {
/* 2014 */       this.jButton35.setEnabled(false);
/* 2015 */       this.jButton36.setEnabled(false);
/* 2016 */       this.jButton37.setEnabled(false);
/* 2017 */       this.materialButton22.setEnabled(false);
/* 2018 */       this.jButton53.setEnabled(false);
/* 2019 */       this.jButton54.setEnabled(false);
/* 2020 */       this.jButton55.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void habilitar() {
/* 2025 */     this.jTextField100.setEnabled(true);
/* 2026 */     this.jTextField101.setEnabled(true);
/* 2027 */     this.jTextField102.setEnabled(true);
/*      */     
/* 2029 */     this.jTextField104.setEnabled(true);
/* 2030 */     this.jTextField105.setEnabled(true);
/* 2031 */     this.jTextField106.setEnabled(true);
/* 2032 */     this.jTextField107.setEnabled(true);
/*      */     
/* 2034 */     this.jComboBox20.setEnabled(true);
/* 2035 */     this.jComboBox21.setEnabled(true);
/* 2036 */     this.jComboBox22.setEnabled(true);
/* 2037 */     this.jComboBox23.setEnabled(true);
/* 2038 */     this.jComboBox24.setEnabled(true);
/* 2039 */     this.jButton38.setEnabled(true);
/*      */     
/* 2041 */     this.jDateChooser1.setEnabled(true);
/* 2042 */     this.jButton53.setEnabled(true);
/* 2043 */     this.jButton54.setEnabled(true);
/* 2044 */     this.jButton55.setEnabled(true);
/* 2045 */     this.materialButton22.setEnabled(true);
/* 2046 */     this.jTextPane1.setEnabled(true);
/* 2047 */     this.jComboBox25.setEnabled(true);
/* 2048 */     this.jButton56.setEnabled(true);
/*      */   }
/*      */   
/*      */   public boolean existeValor(Map Mapa, String buscar) {
/* 2052 */     return Mapa.containsValue(buscar);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean existeDoc() {
/* 2057 */     boolean existe = false;
/* 2058 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2059 */       String v = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 2060 */       if (dameTipoDocSelec().equals(v)) {
/* 2061 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2071 */     return existe;
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertarDocumentos(String claveTracto, String TipoDoc) {
/* 2076 */     String claveDoc = "";
/* 2077 */     this.con.inserSinMsj("insert into unidadesdocumentos (tipo, fechaCaptura, fechaTramite, numeroUnico, periodoVencimiento, fechaInicio, fechaVencimiento, dependencia, costo, dirTramite, telefono, comentarios, estado, usuario) values ('" + ((UnidadesTractosDoc)this.DOCUMENTACION
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2084 */         .get(TipoDoc)).getInformacion().getTipo() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2085 */         .get(TipoDoc)).getInformacion().getfCaptura() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2086 */         .get(TipoDoc)).getInformacion().getFtramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2087 */         .get(TipoDoc)).getInformacion().getNumUnico() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2088 */         .get(TipoDoc)).getInformacion().getpVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2089 */         .get(TipoDoc)).getInformacion().getFinicio() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2090 */         .get(TipoDoc)).getInformacion().getfVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2091 */         .get(TipoDoc)).getInformacion().getDependencia() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2092 */         .get(TipoDoc)).getInformacion().getCosto() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2093 */         .get(TipoDoc)).getInformacion().getDirTramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2094 */         .get(TipoDoc)).getInformacion().getTel() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2095 */         .get(TipoDoc)).getInformacion().getComentarios() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 2096 */         .get(TipoDoc)).getInformacion().getEstado() + "', '" + this.utilerias
/* 2097 */         .sacarUsuario(this.USUARIO) + "')");
/*      */ 
/*      */ 
/*      */     
/* 2101 */     this.con.consultar("max(numDoc)", "unidadesdocumentos", "");
/* 2102 */     claveDoc = this.con.Campo;
/*      */     
/* 2104 */     for (int i = 0; i < ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().size(); i++) {
/* 2105 */       this.con.inserSinMsj("insert into unidadesarchivos ( nombreArch, tipo, fecha, numDoc ) values ( '" + 
/*      */ 
/*      */           
/* 2108 */           copiarArchivos(((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().get("" + i)).getArchivo(), getRutaDestino(TipoDoc)) + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 2109 */           .get(TipoDoc)).getDocumentos().get("" + i)).getTipo() + "', '" + ((UnidadesTractosDoc.Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 2110 */           .get(TipoDoc)).getDocumentos().get("" + i)).getAct() + "', " + claveDoc + ")");
/*      */     }
/*      */ 
/*      */     
/* 2114 */     this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + claveTracto + " ,'REM')");
/* 2115 */     String[] ecos = ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getlistaEcos();
/* 2116 */     for (int j = 0; j < ecos.length; j++) {
/* 2117 */       System.out.println("dentro " + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo() + " " + TipoDoc + " " + ecos[j]);
/* 2118 */       this.con.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + ecos[j] + ",'REM' )");
/* 2119 */       if (this.CAMPOS.containsValue(((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getTipo())) {
/* 2120 */         this.con.inserSinMsj("update remolque set " + convertirTipoDocCampo(TipoDoc) + " = '" + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getNumUnico() + "' where num_rem= " + ecos[j]);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void desabilitar() {
/* 2126 */     this.jTextField100.setEnabled(false);
/* 2127 */     this.jTextField101.setEnabled(false);
/* 2128 */     this.jTextField102.setEnabled(false);
/*      */     
/* 2130 */     this.jTextField104.setEnabled(false);
/* 2131 */     this.jTextField105.setEnabled(false);
/* 2132 */     this.jTextField106.setEnabled(false);
/* 2133 */     this.jTextField107.setEnabled(false);
/*      */     
/* 2135 */     this.jComboBox20.setEnabled(false);
/* 2136 */     this.jComboBox21.setEnabled(false);
/* 2137 */     this.jComboBox22.setEnabled(false);
/* 2138 */     this.jComboBox23.setEnabled(false);
/* 2139 */     this.jComboBox24.setEnabled(false);
/* 2140 */     this.jComboBox25.setEnabled(false);
/* 2141 */     this.jButton38.setEnabled(false);
/*      */     
/* 2143 */     this.jDateChooser1.setEnabled(false);
/* 2144 */     this.jButton53.setEnabled(false);
/* 2145 */     this.jButton54.setEnabled(false);
/* 2146 */     this.jButton55.setEnabled(false);
/* 2147 */     this.materialButton22.setEnabled(false);
/* 2148 */     this.jTextPane1.setEnabled(false);
/* 2149 */     this.jButton56.setEnabled(true);
/*      */   }
/*      */   
/*      */   public String convertirTipoDocCampo(String tipoDoc) {
/* 2153 */     String campo = "";
/* 2154 */     if (tipoDoc.equals("TARJETA DE CIRCULACIÓN")) {
/* 2155 */       campo = "tc";
/* 2156 */     } else if (tipoDoc.equals("PÓLIZA DE SEGURO")) {
/* 2157 */       campo = "poliza";
/* 2158 */     } else if (tipoDoc.equals("SEDEMA")) {
/* 2159 */       campo = "sedema";
/* 2160 */     } else if (tipoDoc.equals("NOM 012")) {
/* 2161 */       campo = "nom012";
/* 2162 */     } else if (tipoDoc.equals("VERIFICACIÓN")) {
/* 2163 */       campo = "verificacion";
/* 2164 */     } else if (tipoDoc.equals("FISICOMECÁNICA")) {
/* 2165 */       campo = "fisicomecanica";
/* 2166 */     } else if (tipoDoc.equals("SCT")) {
/* 2167 */       campo = "sct";
/* 2168 */     } else if (tipoDoc.equals("PAGO")) {
/* 2169 */       campo = "pago";
/* 2170 */     } else if (tipoDoc.equals("INSPECCIÓN")) {
/* 2171 */       campo = "inspeccion";
/*      */     } 
/* 2173 */     return campo;
/*      */   }
/*      */   
/*      */   public String getRutaDestino(String tipo) {
/* 2177 */     String ruta = this.CARPETAS.get("OTRO");
/* 2178 */     if (tipo.equals("TARJETA DE CIRCULACIÓN")) {
/* 2179 */       ruta = this.CARPETAS.get("TC");
/* 2180 */     } else if (tipo.equals("PÓLIZA DE SEGURO")) {
/* 2181 */       ruta = this.CARPETAS.get("POLIZA");
/* 2182 */     } else if (tipo.equals("SEDEMA")) {
/* 2183 */       ruta = this.CARPETAS.get("SEDEMA");
/* 2184 */     } else if (tipo.equals("NOM 012")) {
/* 2185 */       ruta = this.CARPETAS.get("NOM012");
/* 2186 */     } else if (tipo.equals("VERIFICACIÓN")) {
/* 2187 */       ruta = this.CARPETAS.get("VERIFICACION");
/* 2188 */     } else if (tipo.equals("FISICOMECÁNICA")) {
/* 2189 */       ruta = this.CARPETAS.get("FISICOMECANICA");
/* 2190 */     } else if (tipo.equals("SCT")) {
/* 2191 */       ruta = this.CARPETAS.get("SCT");
/* 2192 */     } else if (tipo.equals("PAGO")) {
/* 2193 */       ruta = this.CARPETAS.get("PAGOS");
/* 2194 */     } else if (tipo.equals("INSPECCIÓN")) {
/* 2195 */       ruta = this.CARPETAS.get("INSPECCION");
/*      */     } 
/*      */     
/* 2198 */     return ruta;
/*      */   }
/*      */   
/*      */   public String copiarArchivos(String origen, String destino) {
/* 2202 */     if (this.TIPOV.equals("")) {
/* 2203 */       this.TIPOV = "ECO";
/*      */     }
/* 2205 */     Path origenPath = Paths.get(origen, new String[0]);
/* 2206 */     Path destinoPath = Paths.get(destino + "/" + destino + this.TIPOV + "-" + this.utilerias.getFechaSinEspacios(), new String[0]);
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 2211 */       Files.copy(origenPath, destinoPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*      */     }
/* 2213 */     catch (FileNotFoundException ex) {
/* 2214 */       System.out.println("ERROR 1: al copiar Arhivo: " + ex.getMessage());
/* 2215 */     } catch (IOException ex) {
/* 2216 */       System.out.println("ERROR 2: al copiar Arhivo: " + ex.getMessage());
/*      */     } 
/* 2218 */     String nuevaRuta = destinoPath.toString().replace("\\", "\\\\");
/* 2219 */     return nuevaRuta;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void activarVentanas(JButton boton) {
/* 2225 */     consultarMarcas();
/* 2226 */     Dimension di = boton.getSize();
/* 2227 */     Point p = boton.getLocationOnScreen();
/* 2228 */     this.jDialog3.setLocation(p.x + di.width + 5, p.y + 35);
/* 2229 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultarMarcas() {
/* 2234 */     String marca = "";
/* 2235 */     if (!this.jTextField17.getText().equals(this.holderBuscarM)) {
/* 2236 */       marca = this.jTextField17.getText();
/*      */     }
/* 2238 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro3, new String[] { "Clave", "Marca" }, "id_marca,marca", "marca", "where marca like '%" + marca + "%' order by marca");
/*      */ 
/*      */     
/* 2241 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/* 2242 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3);
/*      */   }
/*      */   
/*      */   public String dameTipoDocSelec() {
/* 2246 */     String tipo = "";
/* 2247 */     if (this.jRadioButton1.isSelected()) {
/* 2248 */       tipo = "TARJETA DE CIRCULACIÓN";
/*      */     }
/* 2250 */     if (this.jRadioButton2.isSelected()) {
/* 2251 */       tipo = "PÓLIZA DE SEGURO";
/*      */     }
/* 2253 */     if (this.jRadioButton3.isSelected()) {
/* 2254 */       tipo = "SEDEMA";
/*      */     }
/* 2256 */     if (this.jRadioButton4.isSelected()) {
/* 2257 */       tipo = "NOM 012";
/*      */     }
/* 2259 */     if (this.jRadioButton5.isSelected()) {
/* 2260 */       tipo = "INSPECCIÓN";
/*      */     }
/* 2262 */     if (this.jRadioButton6.isSelected()) {
/* 2263 */       tipo = "FISICOMECÁNICA";
/*      */     }
/* 2265 */     if (this.jRadioButton7.isSelected()) {
/* 2266 */       tipo = "SCT";
/*      */     }
/* 2268 */     if (this.jRadioButton8.isSelected()) {
/* 2269 */       tipo = "PAGO";
/*      */     }
/* 2271 */     if (this.jRadioButton9.isSelected()) {
/* 2272 */       tipo = "OTRO";
/*      */     }
/* 2274 */     return tipo;
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2278 */     this.PRIMERA = true;
/* 2279 */     String eco = "";
/* 2280 */     String serie = "";
/* 2281 */     String placas = "";
/* 2282 */     String marca = "";
/* 2283 */     String tipo = "";
/* 2284 */     String modelo = "";
/* 2285 */     String estado = "";
/* 2286 */     String sucursal = "";
/*      */     
/* 2288 */     if (!this.jTextField60.getText().equals(this.holderEco)) {
/* 2289 */       eco = this.jTextField60.getText();
/*      */     }
/* 2291 */     if (!this.jTextField61.getText().equals(this.holderSerie)) {
/* 2292 */       serie = this.jTextField61.getText();
/*      */     }
/* 2294 */     if (!this.jTextField62.getText().equals(this.holderPlacas)) {
/* 2295 */       placas = this.jTextField62.getText();
/*      */     }
/* 2297 */     if (!this.jTextField63.getText().equals(this.holderMarca)) {
/* 2298 */       marca = this.jTextField63.getText();
/*      */     }
/* 2300 */     if (!this.jTextField64.getText().equals(this.holderTipo)) {
/* 2301 */       tipo = this.jTextField64.getText();
/*      */     }
/*      */     
/* 2304 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 2305 */       modelo = this.jComboBox9.getSelectedItem().toString();
/*      */     }
/* 2307 */     if (this.jComboBox10.getSelectedIndex() != 0) {
/* 2308 */       estado = this.jComboBox10.getSelectedItem().toString();
/*      */     }
/* 2310 */     if (!this.jComboBox11.getSelectedItem().equals("GENERAL")) {
/* 2311 */       sucursal = this.jComboBox11.getSelectedItem().toString();
/*      */     }
/*      */     
/* 2314 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Remolque", "Modelo", "Serie", "Placas", "Factura / Pago", "Pago", "Marca", "Tipo", "Tarjeta Circualción", "Póliza", "Sedema", "Nom 012", "Inspección", "Fisicomecanica", "SCT", "Estado", "Sucursal", "Usuario" }, "num_rem, modelo, no_serie, placas, num_factu, forma_pago, marca, tipo, tc, poliza, sedema, nom012, inspeccion, fisicomecanica, sct, estado, sucursal, usuario", "remolque", "where num_rem like '%" + eco + "%' and no_serie like '%" + serie + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "' and marca like '%" + marca + "%' and sucursal like '%" + sucursal + "%' order by num_rem asc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2334 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*      */     
/* 2336 */     eliminarColumna(5, 4, "Pago");
/* 2337 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 70);
/* 2338 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 60);
/* 2339 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 60);
/* 2340 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 6, 120);
/* 2341 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 16, 70);
/*      */     
/* 2343 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 2347 */     this.DOCUMENTACION = new LinkedHashMap<>();
/* 2348 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro2);
/*      */     
/* 2350 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 0, 50);
/* 2351 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 3, 100);
/* 2352 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 4, 60);
/*      */ 
/*      */     
/* 2355 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2);
/*      */     
/* 2357 */     this.jTextField100.setText("");
/* 2358 */     this.jTextField101.setText("");
/* 2359 */     this.jTextField102.setText("");
/*      */     
/* 2361 */     this.jTextField104.setText("");
/* 2362 */     this.jTextField105.setText("");
/* 2363 */     this.jTextField106.setText("");
/* 2364 */     this.jTextField107.setText("");
/*      */     
/* 2366 */     this.jComboBox20.setSelectedIndex(0);
/* 2367 */     this.jComboBox21.setSelectedIndex(0);
/* 2368 */     this.jComboBox22.setSelectedIndex(0);
/*      */     
/* 2370 */     this.jComboBox24.setSelectedIndex(0);
/* 2371 */     this.jComboBox25.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/* 2372 */     this.jDateChooser1.setDate(new Date());
/* 2373 */     this.jTextField85.setText("");
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreColEliminar) {
/* 2377 */     int cont = this.rSTableMetro1.getRowCount();
/* 2378 */     String[] registros = new String[cont]; int i;
/* 2379 */     for (i = 0; i < cont; i++) {
/* 2380 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 2382 */     for (i = 0; i < cont; i++) {
/* 2383 */       registros[i] = registros[i] + " / " + registros[i];
/* 2384 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 2386 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreColEliminar);
/* 2387 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void remolque(String usua) {
/* 2391 */     this.USUARIO = usua;
/* 2392 */     this.panel.setViewportView(this);
/* 2393 */     privilegios();
/*      */   }
/*      */   
/*      */   public void ingresarCampos() {
/* 2397 */     this.CAMPOS.put("TARJETA DE CIRCULACIÓN", "TARJETA DE CIRCULACIÓN");
/* 2398 */     this.CAMPOS.put("PÓLIZA DE SEGURO", "PÓLIZA DE SEGURO");
/* 2399 */     this.CAMPOS.put("POLIZA", "POLIZA");
/* 2400 */     this.CAMPOS.put("SEDEMA", "SEDEMA");
/* 2401 */     this.CAMPOS.put("NOM 012", "NOM 012");
/* 2402 */     this.CAMPOS.put("INSPECCIÓN", "INSPECCIÓN");
/* 2403 */     this.CAMPOS.put("FISICOMECÁNICA", "FISICOMECÁNICA");
/* 2404 */     this.CAMPOS.put("SCT", "SCT");
/* 2405 */     this.CAMPOS.put("PAGOS", "PAGOS");
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2409 */     this.pintar.colorear(this.jTextField60);
/* 2410 */     this.pintar.colorear(this.jTextField61);
/* 2411 */     this.pintar.colorear(this.jTextField62);
/* 2412 */     this.pintar.colorear(this.jTextField63);
/* 2413 */     this.pintar.colorear(this.jTextField64);
/* 2414 */     this.pintar.colorear(this.jComboBox9);
/* 2415 */     this.pintar.colorear(this.jComboBox10);
/* 2416 */     this.pintar.colorear(this.jComboBox11);
/*      */     
/* 2418 */     this.pintar.colorear(this.jTextField100);
/* 2419 */     this.pintar.colorear(this.jTextField101);
/* 2420 */     this.pintar.colorear(this.jTextField102);
/*      */     
/* 2422 */     this.pintar.colorear(this.jTextField104);
/* 2423 */     this.pintar.colorear(this.jTextField105);
/* 2424 */     this.pintar.colorear(this.jTextField106);
/* 2425 */     this.pintar.colorear(this.jTextField107);
/*      */     
/* 2427 */     this.pintar.colorear(this.jTextField17);
/* 2428 */     this.pintar.colorear(this.jTextField24);
/* 2429 */     this.pintar.colorear(this.jTextPane1);
/* 2430 */     this.pintar.colorear(this.jComboBox20);
/* 2431 */     this.pintar.colorear(this.jComboBox21);
/* 2432 */     this.pintar.colorear(this.jComboBox22);
/* 2433 */     this.pintar.colorear(this.jComboBox23);
/* 2434 */     this.pintar.colorear(this.jComboBox24);
/* 2435 */     this.pintar.colorear(this.jComboBox25);
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
/*      */   public void llenarComboEstados() {
/* 2459 */     this.ESTADOS = this.con.regresaColIndex("distinct(estado)", "remolque", " order by estado");
/* 2460 */     this.jComboBox10.removeAllItems();
/* 2461 */     this.jComboBox10.addItem("ESTADO");
/* 2462 */     this.utilerias.llenarCombo(this.jComboBox10, this.ESTADOS);
/* 2463 */     this.jComboBox10.setSelectedItem("ACTIVO");
/*      */   }
/*      */   
/*      */   public void llenarComboSuc() {
/* 2467 */     this.SUCURSALES = this.con2.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 2468 */     this.jComboBox11.removeAllItems();
/* 2469 */     this.jComboBox25.removeAllItems();
/* 2470 */     this.utilerias.llenarCombo(this.jComboBox11, this.SUCURSALES);
/* 2471 */     this.utilerias.llenarCombo(this.jComboBox25, this.SUCURSALES);
/*      */   }
/*      */   
/*      */   public void llenarMarca() {
/* 2475 */     String[] depa = this.con.regresaColIndex("marca", "marca", "order by marca");
/* 2476 */     this.jComboBox22.removeAllItems();
/* 2477 */     this.jComboBox22.addItem("SELECCIONA UNO...");
/* 2478 */     this.utilerias.llenarCombo(this.jComboBox22, depa);
/* 2479 */     for (int i = 0; i < depa.length; i++) {
/* 2480 */       this.MARCAS.put("" + i, depa[i]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarTipo() {
/* 2486 */     String[] tipo = this.con.regresaColIndex("distinct(tipo)", "guias", "where tipo <>'' order by tipo");
/* 2487 */     this.jComboBox23.removeAllItems();
/* 2488 */     this.utilerias.llenarCombo(this.jComboBox23, tipo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void llenarModelo() {
/* 2495 */     int año = this.fechaActual.getYear();
/* 2496 */     año += 1901;
/* 2497 */     this.jComboBox9.removeAllItems();
/* 2498 */     this.jComboBox9.addItem("MODELO");
/* 2499 */     for (int i = año; i >= 1990; i--) {
/* 2500 */       this.jComboBox20.addItem("" + i);
/* 2501 */       this.jComboBox9.addItem("" + i);
/*      */     } 
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 2507 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2510 */       setEnabled((table == null || table.isEnabled()));
/* 2511 */       if (column == 0 || column == 1) {
/* 2512 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2514 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 2517 */       if (row % 2 == 0) {
/* 2518 */         setBackground(UnidadesRemolques.this.lc.FONDOTABLA);
/*      */       } else {
/* 2520 */         setBackground((Color)null);
/*      */       } 
/* 2522 */       setForeground(UnidadesRemolques.this.lc.SECUNDARIO1);
/*      */       
/* 2524 */       if (column == 7 || column == 8 || column == 9 || column == 10 || column == 11 || column == 12 || column == 13) {
/* 2525 */         setForeground(UnidadesRemolques.this.lc.PRIMARIO1);
/* 2526 */         setFont(UnidadesRemolques.this.fuentes.setFuente(UnidadesRemolques.this.fuentes.FCentury, UnidadesRemolques.this.fuentes.BOLD, 15.0F));
/*      */       } 
/*      */       
/* 2529 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2530 */       return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UnidadesRemolques.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */