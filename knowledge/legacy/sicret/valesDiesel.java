/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
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
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ 
/*      */ public class valesDiesel extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   43 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   44 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   45 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   46 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   47 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   48 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   49 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   50 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   51 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   53 */   Validaciones val = new Validaciones();
/*   54 */   Consultas con = new Consultas();
/*   55 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   59 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   62 */   Date fechaActual = new Date();
/*   63 */   Date fecha = new Date();
/*   64 */   Date fechaInicio = null;
/*   65 */   Date fechaTermino = null;
/*   66 */   Date fechaMinimo = null;
/*   67 */   CeldaRender celda = new CeldaRender();
/*   68 */   CeldaRender2 celda2 = new CeldaRender2();
/*   69 */   CeldaRender3 celda3 = new CeldaRender3();
/*   70 */   String CLAVEOP = "";
/*      */   String[] operadores;
/*   72 */   String NOMBRE = "";
/*   73 */   String[] GUIAS = new String[10];
/*   74 */   String CLAVE = "";
/*      */   boolean CONCEPTO = false;
/*   76 */   int INDICE = 0;
/*      */   
/*   78 */   String DIRECTIVA = "";
/*   79 */   Presionado presionado = null;
/*   80 */   Presionado2 presionado2 = null;
/*   81 */   Presionado3 presionado3 = null;
/*   82 */   MensajePop mensajeTry = null;
/*   83 */   PlaceHolder placeHolder = null;
/*   84 */   String holderVale = "FOLIO DEL VALE";
/*   85 */   String holderGuia = "GUIAS O DESCRIPCIÓN";
/*   86 */   String holderOperador = "NOMBRE DEL OPERADOR";
/*   87 */   String holderPaterno = "APELLIDO PATERNO";
/*   88 */   String holderMaterno = "APELLIDO MATERNO";
/*   89 */   String holderUnidad = "UNIDAD";
/*   90 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   boolean entradaPrincipal = false;
/*   93 */   Fuentes fuentes = new Fuentes();
/*   94 */   List<String> UNIDADESRAGAR = new ArrayList<>(); private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private JButton jButton1; private JButton jButton11; private JButton jButton13; private JButton jButton17; private JButton jButton2; private JButton jButton24; private JButton jButton3; private JButton jButton32; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2;
/*   95 */   GuiasFormCat utilitarios = null; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel3; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel4; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel58; private JLabel jLabel6; private JLabel jLabel61; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel8; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18;
/*      */   
/*      */   public valesDiesel(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*   98 */     this.UNIDADESRAGAR.add("2");
/*   99 */     this.UNIDADESRAGAR.add("23");
/*  100 */     this.entradaPrincipal = entradaPrincipal;
/*  101 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  102 */     this.mensajeTry = mensajeTry;
/*  103 */     String año = "2010";
/*  104 */     String mes = "03";
/*  105 */     String dia = "01";
/*  106 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  107 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  109 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  110 */     } catch (ParseException ex) {
/*  111 */       ex.printStackTrace();
/*      */     } 
/*  113 */     this.padre = padre;
/*  114 */     this.fichas = fichas;
/*  115 */     initComponents();
/*  116 */     this.jScrollPane11.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  117 */     this.jScrollPane2.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  118 */     this.jScrollPane1.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*      */     
/*  120 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderVale, false, "Cantarell", 11);
/*  121 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderGuia, false, "Cantarell", 11);
/*  122 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderOperador, false, "Cantarell", 11);
/*  123 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderPaterno, false, "Cantarell", 11);
/*  124 */     this.placeHolder = new PlaceHolder(this.jTextField5, new Color(189, 189, 189), Color.BLACK, this.holderMaterno, false, "Cantarell", 11);
/*  125 */     this.placeHolder = new PlaceHolder(this.jTextField6, new Color(189, 189, 189), Color.BLACK, this.holderUnidad, false, "Cantarell", 11);
/*      */     
/*  127 */     this.USUARIO = USUARIO;
/*  128 */     panelito.setViewportView(this);
/*  129 */     this.panel = panelito;
/*      */     
/*  131 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  132 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  133 */     this.jLabel7.setCursor(micursor);
/*  134 */     this.jLabel8.setCursor(micursor);
/*  135 */     this.jLabel9.setCursor(micursor);
/*  136 */     this.jLabel51.setCursor(micursor);
/*      */     
/*  138 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  139 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  140 */     this.jDialog1.setCursor(micursor);
/*  141 */     this.jDialog2.setCursor(micursor);
/*  142 */     this.jDialog3.setCursor(micursor);
/*  143 */     this.jDialog4.setCursor(micursor);
/*  144 */     this.jDialog8.setCursor(micursor);
/*  145 */     this.jDialog9.setCursor(micursor);
/*  146 */     this.jDialog10.setCursor(micursor);
/*  147 */     this.jDialog11.setCursor(micursor);
/*  148 */     this.rSTableMetro1.setCursor(micursor);
/*  149 */     this.rSTableMetro2.setCursor(micursor);
/*  150 */     this.rSTableMetro3.setCursor(micursor);
/*  151 */     this.rSTableMetro4.setCursor(micursor);
/*  152 */     this.rSTableMetro5.setCursor(micursor);
/*  153 */     this.rSTableMetro6.setCursor(micursor);
/*      */     
/*  155 */     int w = this.tama.width;
/*  156 */     int h = this.tama.height;
/*  157 */     int rw = (w - 490) / 2;
/*  158 */     int rh = (h - 580) / 2;
/*  159 */     this.jDialog1.setLocation(rw, rh);
/*  160 */     this.jDialog1.setSize(490, 580);
/*  161 */     this.jDialog1.setVisible(false);
/*  162 */     this.jDialog1.setResizable(false);
/*      */     
/*  164 */     rw = (w - 450) / 2;
/*  165 */     rh = (h - 495) / 2;
/*  166 */     this.jDialog2.setLocation(rw, rh);
/*  167 */     this.jDialog2.setSize(450, 510);
/*  168 */     this.jDialog2.setVisible(false);
/*  169 */     this.jDialog2.setResizable(false);
/*      */     
/*  171 */     rw = (w - 425) / 2;
/*  172 */     rh = (h - 380) / 2;
/*  173 */     this.jDialog3.setVisible(false);
/*  174 */     this.jDialog3.setLocation(rw, rh);
/*  175 */     this.jDialog3.setSize(425, 380);
/*      */     
/*  177 */     rw = (w - 400) / 2;
/*  178 */     rh = (h - 440) / 2;
/*  179 */     this.jDialog4.setLocation(rw, rh);
/*  180 */     this.jDialog4.setSize(400, 392);
/*  181 */     this.jDialog4.setVisible(false);
/*  182 */     this.jDialog4.setResizable(false);
/*      */     
/*  184 */     rw = (w - 400) / 2;
/*  185 */     rh = (h - 440) / 2;
/*  186 */     this.jDialog5.setLocation(rw, rh);
/*  187 */     this.jDialog5.setSize(400, 392);
/*  188 */     this.jDialog5.setVisible(false);
/*  189 */     this.jDialog5.setResizable(false);
/*      */     
/*  191 */     rw = (w - 400) / 2;
/*  192 */     rh = (h - 110) / 2;
/*  193 */     this.jDialog6.setLocation(rw, rh);
/*  194 */     this.jDialog6.setSize(400, 110);
/*  195 */     this.jDialog6.setVisible(false);
/*  196 */     this.jDialog6.setResizable(false);
/*      */     
/*  198 */     rw = (w - 410) / 2;
/*  199 */     rh = (h - 100) / 2;
/*  200 */     this.jDialog7.setLocation(rw, rh);
/*  201 */     this.jDialog7.setSize(410, 100);
/*  202 */     this.jDialog7.setVisible(false);
/*  203 */     this.jDialog7.setResizable(false);
/*      */     
/*  205 */     rw = (w - 390) / 2;
/*  206 */     rh = (h - 480) / 2;
/*  207 */     this.jDialog8.setLocation(rw, rh);
/*  208 */     this.jDialog8.setSize(390, 480);
/*  209 */     this.jDialog8.setVisible(false);
/*  210 */     this.jDialog8.setResizable(false);
/*      */     
/*  212 */     rw = (w - 300) / 2;
/*  213 */     rh = (h - 100) / 2;
/*  214 */     this.jDialog9.setLocation(rw, rh);
/*  215 */     this.jDialog9.setSize(300, 100);
/*  216 */     this.jDialog9.setVisible(false);
/*  217 */     this.jDialog9.setResizable(false);
/*      */     
/*  219 */     rw = (w - 617) / 2;
/*  220 */     rh = (h - 433) / 2;
/*  221 */     this.jDialog10.setLocation(rw, rh);
/*  222 */     this.jDialog10.setSize(617, 433);
/*  223 */     this.jDialog10.setVisible(false);
/*  224 */     this.jDialog10.setResizable(false);
/*      */     
/*  226 */     rw = (w - 440) / 2;
/*  227 */     rh = (h - 270) / 2;
/*  228 */     this.jDialog11.setLocation(rw, rh);
/*  229 */     this.jDialog11.setSize(440, 270);
/*  230 */     this.jDialog11.setVisible(false);
/*  231 */     this.jDialog11.setResizable(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  240 */     colorear();
/*  241 */     llenarCombo();
/*  242 */     consultar1();
/*  243 */     consultar2();
/*  244 */     consultar3();
/*  245 */     consultar4();
/*  246 */     cargarFechaHoy();
/*  247 */     sacarMayor();
/*  248 */     extraerUsuario(USUARIO);
/*  249 */     consultar();
/*  250 */     this.buttonGroup1.add(this.jRadioButton1);
/*  251 */     this.buttonGroup1.add(this.jRadioButton2);
/*  252 */     this.jRadioButton1.setSelected(true);
/*      */     
/*  254 */     this.buttonGroup2.add(this.jRadioButton3);
/*  255 */     this.buttonGroup2.add(this.jRadioButton5);
/*      */     
/*  257 */     this.buttonGroup3.add(this.jRadioButton4);
/*  258 */     this.buttonGroup3.add(this.jRadioButton6);
/*      */     
/*  260 */     this.DIRECTIVA = CAMPOSGENERALES.get("directiva");
/*  261 */     if (!entradaPrincipal) {
/*  262 */       this.con.Campo = CAMPOSGENERALES.get("priv");
/*      */       
/*  264 */       if (this.con.Campo.equals("RECURSOS HUMANOS") || this.con.Campo.equals("CAPTURISTA") || this.con.Campo.equals("GERENTE DE OPERACIONES")) {
/*  265 */         this.jButton4.setEnabled(false);
/*  266 */         this.jButton5.setEnabled(false);
/*  267 */         this.jButton11.setEnabled(false);
/*  268 */         this.jButton35.setEnabled(false);
/*  269 */         this.jButton36.setEnabled(false);
/*  270 */       } else if (this.con.Campo.equals("LIQUIDACIONES")) {
/*  271 */         this.jButton4.setEnabled(true);
/*  272 */         this.jButton5.setEnabled(true);
/*  273 */         this.jButton36.setEnabled(true);
/*      */       } else {
/*      */         
/*  276 */         this.jButton35.setEnabled(true);
/*  277 */         this.jButton4.setEnabled(true);
/*  278 */         this.jButton5.setEnabled(true);
/*  279 */         this.jButton11.setEnabled(true);
/*  280 */         this.jButton36.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  286 */     this.jButton2.setEnabled(false);
/*      */   }
/*      */   private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane2; private JScrollPane jScrollPane20; private JScrollPane jScrollPane3; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator13; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextField jTextField1; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField71; private JTextField jTextField72; private JTextPane jTextPane1; private MaterialButton materialButton16; private MaterialButton materialButton17; private MaterialButton materialButton18; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton23; private MaterialButton materialButton24; private MaterialButton materialButton25; private MaterialButton materialButton26; private MaterialButton materialButton27; private MaterialButton materialButton28; private MaterialButton materialButton29; private MaterialButton materialButton30; private MaterialButton materialButton31; private MaterialButton materialButton32; private MaterialButton materialButton33; private MaterialButton materialButton34; private MaterialButton materialButton35; private MaterialButton materialButton36; private MaterialButton materialButton37; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3; private RSTableMetro rSTableMetro4; private RSTableMetro rSTableMetro5;
/*      */   private RSTableMetro rSTableMetro6;
/*      */   
/*      */   private void initComponents() {
/*  292 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  293 */     this.jPanel6 = new JPanel();
/*  294 */     this.jPanel18 = new JPanel();
/*  295 */     this.jLabel2 = new JLabel();
/*  296 */     this.jLabel1 = new JLabel();
/*  297 */     this.jLabel67 = new JLabel();
/*  298 */     this.jPanel30 = new JPanel();
/*  299 */     this.jPanel31 = new JPanel();
/*  300 */     this.jLabel68 = new JLabel();
/*  301 */     this.jTextField61 = new JTextField();
/*  302 */     this.jLabel69 = new JLabel();
/*  303 */     this.jTextField71 = new JTextField();
/*  304 */     this.jPanel32 = new JPanel();
/*  305 */     this.jCheckBox1 = new JCheckBox();
/*  306 */     this.jPanel33 = new JPanel();
/*  307 */     this.jPanel34 = new JPanel();
/*  308 */     this.jPanel39 = new JPanel();
/*  309 */     this.jButton24 = new JButton();
/*  310 */     this.jButton7 = new JButton();
/*  311 */     this.jPanel40 = new JPanel();
/*  312 */     this.jButton8 = new JButton();
/*  313 */     this.jButton32 = new JButton();
/*  314 */     this.jButton1 = new JButton();
/*  315 */     this.jButton2 = new JButton();
/*  316 */     this.jPanel35 = new JPanel();
/*  317 */     this.jPanel38 = new JPanel();
/*  318 */     this.jLabel70 = new JLabel();
/*  319 */     this.jLabel71 = new JLabel();
/*  320 */     this.jTextField20 = new JTextField();
/*  321 */     this.jComboBox3 = new JComboBox();
/*  322 */     this.jScrollPane2 = new JScrollPane();
/*  323 */     this.rSTableMetro2 = new RSTableMetro();
/*  324 */     this.jPanel13 = new JPanel();
/*  325 */     this.jLabel94 = new JLabel();
/*  326 */     this.jTextField17 = new JTextField();
/*  327 */     this.jButton33 = new JButton();
/*  328 */     this.jRadioButton5 = new JRadioButton();
/*  329 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  330 */     this.jRadioButton3 = new JRadioButton();
/*  331 */     this.jLabel82 = new JLabel();
/*  332 */     this.jLabel83 = new JLabel();
/*  333 */     this.jTextField21 = new JTextField();
/*  334 */     this.jPanel16 = new JPanel();
/*  335 */     this.materialButton18 = new MaterialButton();
/*  336 */     this.materialButton19 = new MaterialButton();
/*  337 */     this.materialButton16 = new MaterialButton();
/*  338 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  339 */     this.jPanel14 = new JPanel();
/*  340 */     this.jPanel19 = new JPanel();
/*  341 */     this.jLabel5 = new JLabel();
/*  342 */     this.jLabel6 = new JLabel();
/*  343 */     this.jLabel75 = new JLabel();
/*  344 */     this.jPanel15 = new JPanel();
/*  345 */     this.jLabel85 = new JLabel();
/*  346 */     this.jTextField62 = new JTextField();
/*  347 */     this.jLabel86 = new JLabel();
/*  348 */     this.jTextField72 = new JTextField();
/*  349 */     this.jPanel36 = new JPanel();
/*  350 */     this.jLabel89 = new JLabel();
/*  351 */     this.jComboBox4 = new JComboBox();
/*  352 */     this.jButton17 = new JButton();
/*  353 */     this.jLabel90 = new JLabel();
/*  354 */     this.jScrollPane5 = new JScrollPane();
/*  355 */     this.jTextArea1 = new JTextArea();
/*  356 */     this.jPanel42 = new JPanel();
/*  357 */     this.jLabel102 = new JLabel();
/*  358 */     this.jTextField23 = new JTextField();
/*  359 */     this.jButton13 = new JButton();
/*  360 */     this.jLabel88 = new JLabel();
/*  361 */     this.jPanel43 = new JPanel();
/*  362 */     this.jRadioButton6 = new JRadioButton();
/*  363 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  364 */     this.jRadioButton4 = new JRadioButton();
/*  365 */     this.jLabel99 = new JLabel();
/*  366 */     this.jTextField33 = new JTextField();
/*  367 */     this.jTextField34 = new JTextField();
/*  368 */     this.jLabel100 = new JLabel();
/*  369 */     this.jButton9 = new JButton();
/*  370 */     this.materialButton31 = new MaterialButton();
/*  371 */     this.materialButton32 = new MaterialButton();
/*  372 */     this.materialButton33 = new MaterialButton();
/*  373 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  374 */     this.jPanel1 = new JPanel();
/*  375 */     this.jPanel21 = new JPanel();
/*  376 */     this.jTextField18 = new JTextField();
/*  377 */     this.jLabel32 = new JLabel();
/*  378 */     this.materialButton17 = new MaterialButton();
/*  379 */     this.jPanel22 = new JPanel();
/*  380 */     this.jScrollPane1 = new JScrollPane();
/*  381 */     this.rSTableMetro3 = new RSTableMetro();
/*  382 */     this.materialButton20 = new MaterialButton();
/*  383 */     this.materialButton21 = new MaterialButton();
/*  384 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  385 */     this.jPanel7 = new JPanel();
/*  386 */     this.jLabel58 = new JLabel();
/*  387 */     this.jTextField22 = new JTextField();
/*  388 */     this.jLabel61 = new JLabel();
/*  389 */     this.jTextField24 = new JTextField();
/*  390 */     this.jScrollPane11 = new JScrollPane();
/*  391 */     this.rSTableMetro4 = new RSTableMetro();
/*  392 */     this.materialButton22 = new MaterialButton();
/*  393 */     this.materialButton23 = new MaterialButton();
/*  394 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  395 */     this.jPanel8 = new JPanel();
/*  396 */     this.jLabel63 = new JLabel();
/*  397 */     this.jLabel64 = new JLabel();
/*  398 */     this.jTextField25 = new JTextField();
/*  399 */     this.jTextField26 = new JTextField();
/*  400 */     this.jScrollPane6 = new JScrollPane();
/*  401 */     this.rSTableMetro6 = new RSTableMetro();
/*  402 */     this.materialButton34 = new MaterialButton();
/*  403 */     this.materialButton37 = new MaterialButton();
/*  404 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  405 */     this.jPanel9 = new JPanel();
/*  406 */     this.jLabel66 = new JLabel();
/*  407 */     this.jTextField19 = new JTextField();
/*  408 */     this.materialButton29 = new MaterialButton();
/*  409 */     this.materialButton30 = new MaterialButton();
/*  410 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  411 */     this.jPanel10 = new JPanel();
/*  412 */     this.jLabel91 = new JLabel();
/*  413 */     this.jTextField27 = new JTextField();
/*  414 */     this.materialButton26 = new MaterialButton();
/*  415 */     this.materialButton27 = new MaterialButton();
/*  416 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  417 */     this.jPanel3 = new JPanel();
/*  418 */     this.jLabel33 = new JLabel();
/*  419 */     this.jTextField28 = new JTextField();
/*  420 */     this.jScrollPane3 = new JScrollPane();
/*  421 */     this.rSTableMetro5 = new RSTableMetro();
/*  422 */     this.materialButton28 = new MaterialButton();
/*  423 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  424 */     this.jPanel11 = new JPanel();
/*  425 */     this.jPanel4 = new JPanel();
/*  426 */     this.jRadioButton1 = new JRadioButton();
/*  427 */     this.jRadioButton2 = new JRadioButton();
/*  428 */     this.materialButton24 = new MaterialButton();
/*  429 */     this.materialButton25 = new MaterialButton();
/*  430 */     this.buttonGroup1 = new ButtonGroup();
/*  431 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  432 */     this.jPanel12 = new JPanel();
/*  433 */     this.jLabel93 = new JLabel();
/*  434 */     this.jSeparator13 = new JSeparator();
/*  435 */     this.jLabel13 = new JLabel();
/*  436 */     this.jLabel14 = new JLabel();
/*  437 */     this.jLabel18 = new JLabel();
/*  438 */     this.jLabel19 = new JLabel();
/*  439 */     this.jLabel21 = new JLabel();
/*  440 */     this.jLabel51 = new JLabel();
/*  441 */     this.jLabel53 = new JLabel();
/*  442 */     this.jLabel98 = new JLabel();
/*  443 */     this.jLabel101 = new JLabel();
/*  444 */     this.jScrollPane8 = new JScrollPane();
/*  445 */     this.jTextPane1 = new JTextPane();
/*  446 */     this.jLabel54 = new JLabel();
/*  447 */     this.buttonGroup2 = new ButtonGroup();
/*  448 */     this.buttonGroup3 = new ButtonGroup();
/*  449 */     this.jDialog11 = new CerrarVentana(this.padre);
/*  450 */     this.jPanel24 = new JPanel();
/*  451 */     this.jLabel72 = new JLabel();
/*  452 */     this.jTextField29 = new JTextField();
/*  453 */     this.jLabel74 = new JLabel();
/*  454 */     this.jTextField30 = new JTextField();
/*  455 */     this.jLabel73 = new JLabel();
/*  456 */     this.jScrollPane9 = new JScrollPane();
/*  457 */     this.jTextArea2 = new JTextArea();
/*  458 */     this.materialButton35 = new MaterialButton();
/*  459 */     this.materialButton36 = new MaterialButton();
/*  460 */     this.jButton6 = new JButton();
/*  461 */     this.jPanel5 = new JPanel();
/*  462 */     this.jLabel10 = new JLabel();
/*  463 */     this.jLabel11 = new JLabel();
/*  464 */     this.jLabel12 = new JLabel();
/*  465 */     this.jPanel37 = new JPanel();
/*  466 */     this.jPanel20 = new JPanel();
/*  467 */     this.jPanel23 = new JPanel();
/*  468 */     this.jLabel3 = new JLabel();
/*  469 */     this.jLabel22 = new JLabel();
/*  470 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  471 */     this.jLabel50 = new JLabel();
/*  472 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  473 */     this.jButton3 = new JButton();
/*  474 */     this.jPanel25 = new JPanel();
/*  475 */     this.jLabel7 = new JLabel();
/*  476 */     this.jLabel8 = new JLabel();
/*  477 */     this.jLabel9 = new JLabel();
/*  478 */     this.jPanel26 = new JPanel();
/*  479 */     this.jPanel17 = new JPanel();
/*  480 */     this.jComboBox1 = new JComboBox();
/*  481 */     this.jComboBox2 = new JComboBox();
/*  482 */     this.jTextField1 = new JTextField();
/*  483 */     this.jTextField2 = new JTextField();
/*  484 */     this.jTextField3 = new JTextField();
/*  485 */     this.jTextField4 = new JTextField();
/*  486 */     this.jTextField5 = new JTextField();
/*  487 */     this.jTextField6 = new JTextField();
/*  488 */     this.jPanel27 = new JPanel();
/*  489 */     this.jPanel28 = new JPanel();
/*  490 */     this.jPanel2 = new JPanel();
/*  491 */     this.jLabel4 = new JLabel();
/*  492 */     this.jLabel48 = new JLabel();
/*  493 */     this.jButton4 = new JButton();
/*  494 */     this.jButton36 = new JButton();
/*  495 */     this.jButton5 = new JButton();
/*  496 */     this.jButton11 = new JButton();
/*  497 */     this.jButton35 = new JButton();
/*  498 */     this.jButton34 = new JButton();
/*  499 */     this.jScrollPane10 = new JScrollPane();
/*  500 */     this.jPanel29 = new JPanel();
/*  501 */     this.jScrollPane20 = new JScrollPane();
/*  502 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  504 */     this.jDialog1.setTitle("Generar Vale para Tractores");
/*  505 */     this.jDialog1.setModal(true);
/*      */     
/*  507 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/*  509 */     this.jLabel1.setFont(new Font("Cantarell", 1, 13));
/*  510 */     this.jLabel1.setForeground(this.lc.PRIMARIO1);
/*  511 */     this.jLabel1.setHorizontalAlignment(0);
/*  512 */     this.jLabel1.setText("FLETES Y MATERIALES GRUPO FORSIS");
/*      */     
/*  514 */     this.jLabel67.setFont(new Font("Cantarell", 0, 13));
/*  515 */     this.jLabel67.setForeground(this.lc.SECUNDARIO1);
/*  516 */     this.jLabel67.setHorizontalAlignment(0);
/*  517 */     this.jLabel67.setText("VALE DE CONSUMO DE DIESEL");
/*      */     
/*  519 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  520 */     this.jPanel18.setLayout(jPanel18Layout);
/*  521 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  522 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  523 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  524 */           .addComponent(this.jLabel2, -2, 77, -2)
/*  525 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  526 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  527 */             .addComponent(this.jLabel1, -1, -1, 32767)
/*  528 */             .addComponent(this.jLabel67, -1, -1, 32767))));
/*      */     
/*  530 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  531 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  532 */         .addComponent(this.jLabel2)
/*  533 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  534 */           .addComponent(this.jLabel1)
/*  535 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  536 */           .addComponent(this.jLabel67)));
/*      */ 
/*      */     
/*  539 */     this.jPanel30.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  541 */     this.jPanel31.setLayout(new GridLayout(2, 2, 6, 6));
/*      */     
/*  543 */     this.jLabel68.setFont(new Font("Cantarell", 0, 11));
/*  544 */     this.jLabel68.setText("Folio del Vale");
/*  545 */     this.jPanel31.add(this.jLabel68);
/*      */     
/*  547 */     this.jTextField61.setEditable(false);
/*  548 */     this.jTextField61.setFont(new Font("Tahoma", 1, 14));
/*  549 */     this.jTextField61.setForeground(this.lc.PRIMARIO1);
/*  550 */     this.jTextField61.setText("PR-12302");
/*  551 */     this.jPanel31.add(this.jTextField61);
/*      */     
/*  553 */     this.jLabel69.setFont(new Font("Cantarell", 0, 11));
/*  554 */     this.jLabel69.setText("Fecha y hora");
/*  555 */     this.jPanel31.add(this.jLabel69);
/*      */     
/*  557 */     this.jTextField71.setEditable(false);
/*  558 */     this.jTextField71.setFont(new Font("Tahoma", 1, 12));
/*  559 */     this.jTextField71.setForeground(this.lc.PRIMARIO1);
/*  560 */     this.jTextField71.setText("02/02/2010 23:33:22");
/*  561 */     this.jPanel31.add(this.jTextField71);
/*      */     
/*  563 */     this.jPanel30.add(this.jPanel31);
/*      */     
/*  565 */     this.jPanel32.setLayout(new GridLayout(2, 0, 0, 6));
/*      */     
/*  567 */     this.jCheckBox1.setFont(new Font("Cantarell", 0, 11));
/*  568 */     this.jCheckBox1.setText("Vale Nocturno");
/*  569 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  571 */             valesDiesel.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  574 */     this.jPanel32.add(this.jCheckBox1);
/*      */     
/*  576 */     this.jPanel30.add(this.jPanel32);
/*      */     
/*  578 */     this.jPanel39.setLayout(new GridLayout(2, 1, 0, 6));
/*      */     
/*  580 */     this.jButton24.setText("Cargar");
/*  581 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  583 */             valesDiesel.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*  586 */     this.jPanel39.add(this.jButton24);
/*      */     
/*  588 */     this.jButton7.setText("Cargar Op.");
/*  589 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  591 */             valesDiesel.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  594 */     this.jPanel39.add(this.jButton7);
/*      */     
/*  596 */     this.jPanel40.setLayout(new GridLayout(5, 0, 0, 6));
/*      */     
/*  598 */     this.jButton8.setText("Quitar Todas");
/*  599 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  601 */             valesDiesel.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*  604 */     this.jPanel40.add(this.jButton8);
/*      */     
/*  606 */     this.jButton32.setText("Quitar");
/*  607 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  609 */             valesDiesel.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*  612 */     this.jPanel40.add(this.jButton32);
/*      */     
/*  614 */     this.jButton1.setText("Agregar");
/*  615 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  617 */             valesDiesel.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  620 */     this.jPanel40.add(this.jButton1);
/*      */     
/*  622 */     this.jButton2.setText("Saldar");
/*  623 */     this.jButton2.setEnabled(false);
/*  624 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  626 */             valesDiesel.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  629 */     this.jPanel40.add(this.jButton2);
/*      */     
/*  631 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  632 */     this.jPanel34.setLayout(jPanel34Layout);
/*  633 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  634 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  635 */         .addComponent(this.jPanel40, -1, -1, 32767)
/*  636 */         .addComponent(this.jPanel39, -1, -1, 32767));
/*      */     
/*  638 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  639 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  640 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  641 */           .addComponent(this.jPanel39, -2, -1, -2)
/*  642 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  643 */           .addComponent(this.jPanel40, -1, -1, 32767)));
/*      */ 
/*      */     
/*  646 */     GridBagLayout jPanel38Layout = new GridBagLayout();
/*  647 */     jPanel38Layout.columnWidths = new int[] { 0, 10, 0 };
/*  648 */     jPanel38Layout.rowHeights = new int[] { 0, 10, 0 };
/*  649 */     this.jPanel38.setLayout(jPanel38Layout);
/*      */     
/*  651 */     this.jLabel70.setFont(new Font("Cantarell", 0, 11));
/*  652 */     this.jLabel70.setText("Ruta");
/*  653 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  654 */     gridBagConstraints.gridx = 0;
/*  655 */     gridBagConstraints.gridy = 0;
/*  656 */     gridBagConstraints.anchor = 21;
/*  657 */     this.jPanel38.add(this.jLabel70, gridBagConstraints);
/*      */     
/*  659 */     this.jLabel71.setFont(new Font("Cantarell", 0, 11));
/*  660 */     this.jLabel71.setText("Operador ");
/*  661 */     gridBagConstraints = new GridBagConstraints();
/*  662 */     gridBagConstraints.gridx = 0;
/*  663 */     gridBagConstraints.gridy = 2;
/*  664 */     gridBagConstraints.anchor = 21;
/*  665 */     this.jPanel38.add(this.jLabel71, gridBagConstraints);
/*      */     
/*  667 */     this.jTextField20.setEditable(false);
/*  668 */     this.jTextField20.setFont(new Font("Tahoma", 1, 11));
/*  669 */     this.jTextField20.setForeground(Color.blue);
/*  670 */     gridBagConstraints = new GridBagConstraints();
/*  671 */     gridBagConstraints.gridx = 2;
/*  672 */     gridBagConstraints.gridy = 2;
/*  673 */     gridBagConstraints.fill = 2;
/*  674 */     this.jPanel38.add(this.jTextField20, gridBagConstraints);
/*      */     
/*  676 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  677 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Elije uno..." }));
/*  678 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  680 */             valesDiesel.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  683 */     gridBagConstraints = new GridBagConstraints();
/*  684 */     gridBagConstraints.gridx = 2;
/*  685 */     gridBagConstraints.gridy = 0;
/*  686 */     gridBagConstraints.fill = 2;
/*  687 */     gridBagConstraints.weightx = 0.1D;
/*  688 */     this.jPanel38.add(this.jComboBox3, gridBagConstraints);
/*      */     
/*  690 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  698 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  703 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  706 */     this.rSTableMetro2.setAltoHead(25);
/*  707 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  708 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  709 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  710 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  711 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  712 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  713 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  714 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  715 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  716 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  717 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  718 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  719 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  720 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  721 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  723 */             valesDiesel.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  726 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  728 */             valesDiesel.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  731 */     this.jScrollPane2.setViewportView((Component)this.rSTableMetro2);
/*  732 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/*  733 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/*  734 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  735 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     } 
/*      */     
/*  738 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/*  739 */     this.jPanel35.setLayout(jPanel35Layout);
/*  740 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/*  741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  742 */         .addComponent(this.jPanel38, -1, -1, 32767)
/*  743 */         .addComponent(this.jScrollPane2, -2, 0, 32767));
/*      */     
/*  745 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/*  746 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  747 */         .addGroup(jPanel35Layout.createSequentialGroup()
/*  748 */           .addComponent(this.jPanel38, -2, 67, -2)
/*  749 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  750 */           .addComponent(this.jScrollPane2, -2, 0, 32767)));
/*      */ 
/*      */     
/*  753 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  754 */     this.jPanel33.setLayout(jPanel33Layout);
/*  755 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  757 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/*  758 */           .addComponent(this.jPanel35, -1, -1, 32767)
/*  759 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  760 */           .addComponent(this.jPanel34, -2, -1, -2)));
/*      */     
/*  762 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/*  763 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  764 */         .addComponent(this.jPanel34, -1, -1, 32767)
/*  765 */         .addComponent(this.jPanel35, -1, -1, 32767));
/*      */ 
/*      */     
/*  768 */     this.jPanel13.setLayout(new GridBagLayout());
/*      */     
/*  770 */     this.jLabel94.setFont(new Font("Cantarell", 0, 11));
/*  771 */     this.jLabel94.setHorizontalAlignment(4);
/*  772 */     this.jLabel94.setText("Litros");
/*  773 */     gridBagConstraints = new GridBagConstraints();
/*  774 */     gridBagConstraints.gridx = 0;
/*  775 */     gridBagConstraints.gridy = 0;
/*  776 */     gridBagConstraints.fill = 3;
/*  777 */     gridBagConstraints.ipadx = 47;
/*  778 */     gridBagConstraints.ipady = 5;
/*  779 */     this.jPanel13.add(this.jLabel94, gridBagConstraints);
/*      */     
/*  781 */     this.jTextField17.setEditable(false);
/*  782 */     this.jTextField17.setFont(new Font("Tahoma", 1, 11));
/*  783 */     this.jTextField17.setForeground(Color.blue);
/*  784 */     this.jTextField17.setHorizontalAlignment(4);
/*  785 */     gridBagConstraints = new GridBagConstraints();
/*  786 */     gridBagConstraints.gridx = 1;
/*  787 */     gridBagConstraints.gridy = 1;
/*  788 */     gridBagConstraints.gridwidth = 2;
/*  789 */     gridBagConstraints.fill = 2;
/*  790 */     gridBagConstraints.ipadx = 295;
/*  791 */     gridBagConstraints.anchor = 18;
/*  792 */     gridBagConstraints.insets = new Insets(11, 6, 0, 0);
/*  793 */     this.jPanel13.add(this.jTextField17, gridBagConstraints);
/*      */     
/*  795 */     this.jButton33.setText("Otro");
/*  796 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  798 */             valesDiesel.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*  801 */     gridBagConstraints = new GridBagConstraints();
/*  802 */     gridBagConstraints.gridx = 3;
/*  803 */     gridBagConstraints.gridy = 1;
/*  804 */     gridBagConstraints.fill = 2;
/*  805 */     gridBagConstraints.anchor = 18;
/*  806 */     gridBagConstraints.insets = new Insets(6, 5, 0, 0);
/*  807 */     this.jPanel13.add(this.jButton33, gridBagConstraints);
/*      */     
/*  809 */     this.jRadioButton5.setFont(new Font("Cantarell", 0, 11));
/*  810 */     this.jRadioButton5.setText("Cantidad");
/*  811 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  813 */             valesDiesel.this.jRadioButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  816 */     gridBagConstraints = new GridBagConstraints();
/*  817 */     gridBagConstraints.gridx = 1;
/*  818 */     gridBagConstraints.gridy = 0;
/*  819 */     gridBagConstraints.fill = 1;
/*  820 */     gridBagConstraints.ipadx = 11;
/*  821 */     gridBagConstraints.ipady = -9;
/*  822 */     gridBagConstraints.anchor = 18;
/*  823 */     gridBagConstraints.insets = new Insets(0, 6, 0, 0);
/*  824 */     this.jPanel13.add(this.jRadioButton5, gridBagConstraints);
/*      */     
/*  826 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  827 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  828 */     gridBagConstraints = new GridBagConstraints();
/*  829 */     gridBagConstraints.gridx = 2;
/*  830 */     gridBagConstraints.gridy = 0;
/*  831 */     gridBagConstraints.fill = 2;
/*  832 */     gridBagConstraints.ipadx = 193;
/*  833 */     gridBagConstraints.anchor = 18;
/*  834 */     gridBagConstraints.insets = new Insets(0, 6, 0, 0);
/*  835 */     this.jPanel13.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/*  837 */     this.jRadioButton3.setFont(new Font("Cantarell", 0, 11));
/*  838 */     this.jRadioButton3.setText("Siza");
/*  839 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  841 */             valesDiesel.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  844 */     gridBagConstraints = new GridBagConstraints();
/*  845 */     gridBagConstraints.gridx = 3;
/*  846 */     gridBagConstraints.gridy = 0;
/*  847 */     gridBagConstraints.fill = 1;
/*  848 */     gridBagConstraints.ipadx = 13;
/*  849 */     gridBagConstraints.ipady = -9;
/*  850 */     gridBagConstraints.anchor = 18;
/*  851 */     gridBagConstraints.insets = new Insets(0, 6, 0, 6);
/*  852 */     this.jPanel13.add(this.jRadioButton3, gridBagConstraints);
/*      */     
/*  854 */     this.jLabel82.setFont(new Font("Cantarell", 0, 11));
/*  855 */     this.jLabel82.setHorizontalAlignment(4);
/*  856 */     this.jLabel82.setText("Económico");
/*  857 */     gridBagConstraints = new GridBagConstraints();
/*  858 */     gridBagConstraints.gridx = 0;
/*  859 */     gridBagConstraints.gridy = 1;
/*  860 */     gridBagConstraints.ipadx = 8;
/*  861 */     gridBagConstraints.anchor = 18;
/*  862 */     gridBagConstraints.insets = new Insets(15, 0, 0, 0);
/*  863 */     this.jPanel13.add(this.jLabel82, gridBagConstraints);
/*      */     
/*  865 */     this.jLabel83.setFont(new Font("Cantarell", 0, 11));
/*  866 */     this.jLabel83.setHorizontalAlignment(4);
/*  867 */     this.jLabel83.setText("Documentó");
/*  868 */     gridBagConstraints = new GridBagConstraints();
/*  869 */     gridBagConstraints.gridx = 0;
/*  870 */     gridBagConstraints.gridy = 2;
/*  871 */     gridBagConstraints.ipadx = 6;
/*  872 */     gridBagConstraints.anchor = 18;
/*  873 */     gridBagConstraints.insets = new Insets(10, 0, 0, 0);
/*  874 */     this.jPanel13.add(this.jLabel83, gridBagConstraints);
/*      */     
/*  876 */     this.jTextField21.setEditable(false);
/*  877 */     this.jTextField21.setFont(new Font("Tahoma", 1, 11));
/*  878 */     this.jTextField21.setHorizontalAlignment(0);
/*  879 */     gridBagConstraints = new GridBagConstraints();
/*  880 */     gridBagConstraints.gridx = 1;
/*  881 */     gridBagConstraints.gridy = 2;
/*  882 */     gridBagConstraints.gridwidth = 2;
/*  883 */     gridBagConstraints.fill = 2;
/*  884 */     gridBagConstraints.ipadx = 295;
/*  885 */     gridBagConstraints.anchor = 18;
/*  886 */     gridBagConstraints.insets = new Insets(6, 6, 6, 0);
/*  887 */     this.jPanel13.add(this.jTextField21, gridBagConstraints);
/*      */     
/*  889 */     this.materialButton18.setBackground(this.lc.SECUNDARIO1);
/*  890 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/*  891 */     this.materialButton18.setMnemonic('C');
/*  892 */     this.materialButton18.setText("Cerrar");
/*  893 */     this.materialButton18.setToolTipText("Cerrar (Alt+C)");
/*  894 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/*  895 */     this.materialButton18.setHorizontalTextPosition(0);
/*  896 */     this.materialButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  898 */             valesDiesel.this.materialButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  902 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/*  903 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  904 */     this.materialButton19.setMnemonic('L');
/*  905 */     this.materialButton19.setText("Limpiar");
/*  906 */     this.materialButton19.setToolTipText("Limpiar (Alt+L)");
/*  907 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  908 */     this.materialButton19.setHorizontalTextPosition(0);
/*  909 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  911 */             valesDiesel.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  915 */     this.materialButton16.setBackground(this.lc.PRIMARIO1);
/*  916 */     this.materialButton16.setForeground(new Color(255, 255, 255));
/*  917 */     this.materialButton16.setMnemonic('I');
/*  918 */     this.materialButton16.setText("Imprimir");
/*  919 */     this.materialButton16.setToolTipText("Imprimir (Alt+I)");
/*  920 */     this.materialButton16.setFont(new Font("Cantarell", 0, 12));
/*  921 */     this.materialButton16.setHorizontalTextPosition(0);
/*  922 */     this.materialButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  924 */             valesDiesel.this.materialButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  928 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/*  929 */     this.jPanel16.setLayout(jPanel16Layout);
/*  930 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/*  931 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  932 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
/*  933 */           .addGap(0, 0, 32767)
/*  934 */           .addComponent((Component)this.materialButton16, -2, 150, -2)
/*  935 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  936 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/*  937 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  938 */           .addComponent((Component)this.materialButton18, -2, 105, -2)));
/*      */     
/*  940 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/*  941 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  942 */         .addGroup(jPanel16Layout.createSequentialGroup()
/*  943 */           .addContainerGap()
/*  944 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  945 */             .addComponent((Component)this.materialButton18, -2, 38, -2)
/*  946 */             .addComponent((Component)this.materialButton19, -2, 38, -2)
/*  947 */             .addComponent((Component)this.materialButton16, -2, 38, -2))
/*  948 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  951 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  952 */     this.jPanel6.setLayout(jPanel6Layout);
/*  953 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  954 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  955 */         .addComponent(this.jPanel18, -1, -1, 32767)
/*  956 */         .addComponent(this.jPanel30, -2, 0, 32767)
/*  957 */         .addComponent(this.jPanel33, -1, -1, 32767)
/*  958 */         .addComponent(this.jPanel13, -1, -1, 32767)
/*  959 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  960 */           .addGap(0, 0, 32767)
/*  961 */           .addComponent(this.jPanel16, -2, -1, -2)));
/*      */     
/*  963 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  964 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  965 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  966 */           .addComponent(this.jPanel18, -2, -1, -2)
/*  967 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  968 */           .addComponent(this.jPanel30, -2, 53, -2)
/*  969 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  970 */           .addComponent(this.jPanel33, -1, -1, 32767)
/*  971 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  972 */           .addComponent(this.jPanel13, -2, -1, -2)
/*  973 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  974 */           .addComponent(this.jPanel16, -2, -1, -2)
/*  975 */           .addGap(8, 8, 8)));
/*      */ 
/*      */     
/*  978 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  979 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  980 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  981 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  982 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/*  984 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  985 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  986 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */ 
/*      */     
/*  989 */     this.jDialog2.setTitle("Generar Vale para Utilitarios y Retros");
/*  990 */     this.jDialog2.setModal(true);
/*      */     
/*  992 */     this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/*  994 */     this.jLabel6.setFont(new Font("Cantarell", 1, 13));
/*  995 */     this.jLabel6.setForeground(this.lc.PRIMARIO1);
/*  996 */     this.jLabel6.setHorizontalAlignment(0);
/*  997 */     this.jLabel6.setText("FLETES Y MATERIALES GRUPO FORSIS");
/*      */     
/*  999 */     this.jLabel75.setFont(new Font("Cantarell", 0, 13));
/* 1000 */     this.jLabel75.setForeground(this.lc.SECUNDARIO1);
/* 1001 */     this.jLabel75.setHorizontalAlignment(0);
/* 1002 */     this.jLabel75.setText("VALE PARA UTILITARIOS");
/*      */     
/* 1004 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 1005 */     this.jPanel19.setLayout(jPanel19Layout);
/* 1006 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 1007 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1008 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1009 */           .addComponent(this.jLabel5, -2, 77, -2)
/* 1010 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1011 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1012 */             .addComponent(this.jLabel6, -1, -1, 32767)
/* 1013 */             .addComponent(this.jLabel75, -1, -1, 32767))));
/*      */     
/* 1015 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 1016 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1017 */         .addComponent(this.jLabel5)
/* 1018 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1019 */           .addComponent(this.jLabel6)
/* 1020 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1021 */           .addComponent(this.jLabel75)));
/*      */ 
/*      */     
/* 1024 */     this.jPanel15.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 1026 */     this.jLabel85.setFont(new Font("Cantarell", 1, 11));
/* 1027 */     this.jLabel85.setHorizontalAlignment(4);
/* 1028 */     this.jLabel85.setText("Folio del Vale");
/* 1029 */     this.jPanel15.add(this.jLabel85);
/*      */     
/* 1031 */     this.jTextField62.setEditable(false);
/* 1032 */     this.jTextField62.setFont(new Font("Tahoma", 1, 14));
/* 1033 */     this.jTextField62.setForeground(this.lc.PRIMARIO1);
/* 1034 */     this.jTextField62.setText("PR-12302");
/* 1035 */     this.jPanel15.add(this.jTextField62);
/*      */     
/* 1037 */     this.jLabel86.setFont(new Font("Cantarell", 1, 11));
/* 1038 */     this.jLabel86.setHorizontalAlignment(11);
/* 1039 */     this.jLabel86.setText("Fecha y Hora");
/* 1040 */     this.jPanel15.add(this.jLabel86);
/*      */     
/* 1042 */     this.jTextField72.setEditable(false);
/* 1043 */     this.jTextField72.setFont(new Font("Tahoma", 1, 12));
/* 1044 */     this.jTextField72.setForeground(this.lc.PRIMARIO1);
/* 1045 */     this.jTextField72.setText("02/02/2010 23:33:22");
/* 1046 */     this.jPanel15.add(this.jTextField72);
/*      */     
/* 1048 */     this.jLabel89.setFont(new Font("Cantarell", 1, 11));
/* 1049 */     this.jLabel89.setHorizontalAlignment(11);
/* 1050 */     this.jLabel89.setText("Ruta");
/*      */     
/* 1052 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 1053 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Elije uno..." }));
/* 1054 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1056 */             valesDiesel.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1060 */     this.jButton17.setText("Cargar");
/* 1061 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1063 */             valesDiesel.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1067 */     this.jLabel90.setFont(new Font("Cantarell", 1, 11));
/* 1068 */     this.jLabel90.setHorizontalAlignment(4);
/* 1069 */     this.jLabel90.setText("Concepto ");
/*      */     
/* 1071 */     this.jTextArea1.setColumns(20);
/* 1072 */     this.jTextArea1.setLineWrap(true);
/* 1073 */     this.jTextArea1.setRows(5);
/* 1074 */     this.jScrollPane5.setViewportView(this.jTextArea1);
/*      */     
/* 1076 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 1077 */     this.jPanel36.setLayout(jPanel36Layout);
/* 1078 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 1079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1080 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1081 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1082 */             .addComponent(this.jLabel90, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1083 */             .addComponent(this.jLabel89, GroupLayout.Alignment.LEADING, -1, 73, 32767))
/* 1084 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1085 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1086 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 1087 */               .addComponent(this.jComboBox4, 0, -1, 32767)
/* 1088 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1089 */               .addComponent(this.jButton17))
/* 1090 */             .addComponent(this.jScrollPane5))
/* 1091 */           .addContainerGap()));
/*      */     
/* 1093 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1094 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1095 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1096 */           .addContainerGap()
/* 1097 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE, false)
/* 1098 */             .addComponent(this.jComboBox4)
/* 1099 */             .addComponent(this.jLabel89)
/* 1100 */             .addComponent(this.jButton17))
/* 1101 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1102 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1103 */             .addComponent(this.jLabel90)
/* 1104 */             .addComponent(this.jScrollPane5, -1, 126, 32767))));
/*      */ 
/*      */     
/* 1107 */     this.jLabel102.setFont(new Font("Cantarell", 1, 11));
/* 1108 */     this.jLabel102.setHorizontalAlignment(4);
/* 1109 */     this.jLabel102.setText("Empleado");
/*      */     
/* 1111 */     this.jTextField23.setEditable(false);
/* 1112 */     this.jTextField23.setFont(new Font("Tahoma", 1, 11));
/* 1113 */     this.jTextField23.setForeground(Color.blue);
/*      */     
/* 1115 */     this.jButton13.setText("Cargar");
/* 1116 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1118 */             valesDiesel.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1122 */     this.jLabel88.setFont(new Font("Cantarell", 0, 11));
/* 1123 */     this.jLabel88.setHorizontalAlignment(4);
/* 1124 */     this.jLabel88.setText("Litros");
/*      */     
/* 1126 */     this.jPanel43.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1128 */     this.jRadioButton6.setText("Cantidad");
/* 1129 */     this.jRadioButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1131 */             valesDiesel.this.jRadioButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1134 */     this.jPanel43.add(this.jRadioButton6);
/*      */     
/* 1136 */     this.jFormattedTextField2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/* 1137 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/* 1138 */     this.jPanel43.add(this.jFormattedTextField2);
/*      */     
/* 1140 */     this.jRadioButton4.setText("Lleno");
/* 1141 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1143 */             valesDiesel.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1146 */     this.jPanel43.add(this.jRadioButton4);
/*      */     
/* 1148 */     this.jLabel99.setFont(new Font("Cantarell", 1, 11));
/* 1149 */     this.jLabel99.setHorizontalAlignment(4);
/* 1150 */     this.jLabel99.setText("Utilitario ");
/*      */     
/* 1152 */     this.jTextField33.setFont(new Font("Tahoma", 1, 11));
/* 1153 */     this.jTextField33.setForeground(Color.blue);
/* 1154 */     this.jTextField33.setHorizontalAlignment(4);
/* 1155 */     this.jTextField33.setEnabled(false);
/*      */     
/* 1157 */     this.jTextField34.setEditable(false);
/* 1158 */     this.jTextField34.setFont(new Font("Tahoma", 1, 10));
/* 1159 */     this.jTextField34.setHorizontalAlignment(0);
/*      */     
/* 1161 */     this.jLabel100.setFont(new Font("Cantarell", 1, 11));
/* 1162 */     this.jLabel100.setHorizontalAlignment(4);
/* 1163 */     this.jLabel100.setText("Documentó ");
/*      */     
/* 1165 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1166 */     this.jButton9.setMnemonic('F');
/* 1167 */     this.jButton9.setToolTipText("Filtrar información (Alt+F)");
/* 1168 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1170 */             valesDiesel.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1174 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 1175 */     this.jPanel42.setLayout(jPanel42Layout);
/* 1176 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 1177 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1178 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 1179 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1180 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 1181 */               .addComponent(this.jLabel102, -2, 73, -2)
/* 1182 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1183 */               .addComponent(this.jTextField23, -2, 298, -2)
/* 1184 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1185 */               .addComponent(this.jButton13)
/* 1186 */               .addGap(0, 0, 32767))
/* 1187 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 1188 */               .addComponent(this.jLabel88, -2, 73, -2)
/* 1189 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1190 */               .addComponent(this.jPanel43, -1, -1, 32767)))
/* 1191 */           .addGap(6, 6, 6))
/* 1192 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 1193 */           .addComponent(this.jLabel99, -2, 73, -2)
/* 1194 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1195 */           .addComponent(this.jTextField33, -2, 314, -2)
/* 1196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1197 */           .addComponent(this.jButton9, -2, 20, -2)
/* 1198 */           .addContainerGap(-1, 32767))
/* 1199 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 1200 */           .addComponent(this.jLabel100, -2, 73, -2)
/* 1201 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1202 */           .addComponent(this.jTextField34)
/* 1203 */           .addContainerGap()));
/*      */     
/* 1205 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 1206 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1207 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 1208 */           .addContainerGap()
/* 1209 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1210 */             .addComponent(this.jLabel102)
/* 1211 */             .addComponent(this.jTextField23, -2, -1, -2)
/* 1212 */             .addComponent(this.jButton13))
/* 1213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1214 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1215 */             .addComponent(this.jLabel88, -1, 27, 32767)
/* 1216 */             .addComponent(this.jPanel43, -2, 0, 32767))
/* 1217 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1218 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1219 */             .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1220 */               .addComponent(this.jLabel99)
/* 1221 */               .addComponent(this.jTextField33, -2, -1, -2))
/* 1222 */             .addComponent(this.jButton9, -1, -1, 32767))
/* 1223 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1224 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1225 */             .addComponent(this.jLabel100)
/* 1226 */             .addComponent(this.jTextField34, -2, -1, -2))
/* 1227 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1230 */     this.materialButton31.setBackground(this.lc.PRIMARIO1);
/* 1231 */     this.materialButton31.setForeground(new Color(255, 255, 255));
/* 1232 */     this.materialButton31.setMnemonic('I');
/* 1233 */     this.materialButton31.setText("Imprimir");
/* 1234 */     this.materialButton31.setToolTipText("Imprimir (Alt+I)");
/* 1235 */     this.materialButton31.setFont(new Font("Cantarell", 0, 12));
/* 1236 */     this.materialButton31.setHorizontalTextPosition(0);
/* 1237 */     this.materialButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1239 */             valesDiesel.this.materialButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1243 */     this.materialButton32.setBackground(this.lc.SECUNDARIO1);
/* 1244 */     this.materialButton32.setForeground(new Color(255, 255, 255));
/* 1245 */     this.materialButton32.setMnemonic('L');
/* 1246 */     this.materialButton32.setText("Limpiar");
/* 1247 */     this.materialButton32.setToolTipText("Limpiar (Alt+L)");
/* 1248 */     this.materialButton32.setFont(new Font("Cantarell", 0, 12));
/* 1249 */     this.materialButton32.setHorizontalTextPosition(0);
/* 1250 */     this.materialButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1252 */             valesDiesel.this.materialButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1256 */     this.materialButton33.setBackground(this.lc.SECUNDARIO1);
/* 1257 */     this.materialButton33.setForeground(new Color(255, 255, 255));
/* 1258 */     this.materialButton33.setMnemonic('C');
/* 1259 */     this.materialButton33.setText("Cerrar");
/* 1260 */     this.materialButton33.setToolTipText("Cerrar (Alt+C)");
/* 1261 */     this.materialButton33.setFont(new Font("Cantarell", 0, 12));
/* 1262 */     this.materialButton33.setHorizontalTextPosition(0);
/* 1263 */     this.materialButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1265 */             valesDiesel.this.materialButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1269 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1270 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1271 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1272 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1273 */         .addComponent(this.jPanel19, -1, -1, 32767)
/* 1274 */         .addComponent(this.jPanel15, -2, 0, 32767)
/* 1275 */         .addComponent(this.jPanel36, -1, -1, 32767)
/* 1276 */         .addComponent(this.jPanel42, -1, -1, 32767)
/* 1277 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 1278 */           .addContainerGap(-1, 32767)
/* 1279 */           .addComponent((Component)this.materialButton31, -2, 150, -2)
/* 1280 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1281 */           .addComponent((Component)this.materialButton32, -2, 105, -2)
/* 1282 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1283 */           .addComponent((Component)this.materialButton33, -2, 105, -2)
/* 1284 */           .addContainerGap()));
/*      */     
/* 1286 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1287 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1288 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1289 */           .addComponent(this.jPanel19, -2, -1, -2)
/* 1290 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1291 */           .addComponent(this.jPanel15, -2, -1, -2)
/* 1292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1293 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 1294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1295 */           .addComponent(this.jPanel42, -2, -1, -2)
/* 1296 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1297 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1298 */             .addComponent((Component)this.materialButton33, -2, 38, -2)
/* 1299 */             .addComponent((Component)this.materialButton32, -2, 38, -2)
/* 1300 */             .addComponent((Component)this.materialButton31, -2, 38, -2))
/* 1301 */           .addGap(0, 44, 32767)));
/*      */ 
/*      */     
/* 1304 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1305 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1306 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1307 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1308 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */     
/* 1310 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1311 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1312 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1313 */           .addComponent(this.jPanel14, -2, -1, -2)
/* 1314 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1317 */     this.jDialog3.setTitle("Organizar Rutas");
/* 1318 */     this.jDialog3.setModal(true);
/* 1319 */     this.jDialog3.setResizable(false);
/*      */     
/* 1321 */     this.jTextField18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1323 */             valesDiesel.this.jTextField18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1327 */     this.jLabel32.setFont(new Font("Cantarell", 0, 11));
/* 1328 */     this.jLabel32.setHorizontalAlignment(4);
/* 1329 */     this.jLabel32.setText("Nombre");
/*      */     
/* 1331 */     this.materialButton17.setBackground(this.lc.PRIMARIO1);
/* 1332 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/* 1333 */     this.materialButton17.setMnemonic('A');
/* 1334 */     this.materialButton17.setText("Agregar");
/* 1335 */     this.materialButton17.setToolTipText("Agregar (Alt+A)");
/* 1336 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/* 1337 */     this.materialButton17.setHorizontalTextPosition(0);
/* 1338 */     this.materialButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1340 */             valesDiesel.this.materialButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1344 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 1345 */     this.jPanel21.setLayout(jPanel21Layout);
/* 1346 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 1347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 1349 */           .addContainerGap()
/* 1350 */           .addComponent(this.jLabel32, -2, 65, -2)
/* 1351 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1352 */           .addComponent(this.jTextField18)
/* 1353 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1354 */           .addComponent((Component)this.materialButton17, -2, 150, -2)));
/*      */     
/* 1356 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 1357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1358 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 1359 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1360 */             .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1361 */               .addComponent(this.jLabel32)
/* 1362 */               .addComponent(this.jTextField18, -2, -1, -2))
/* 1363 */             .addComponent((Component)this.materialButton17, -2, 38, -2))
/* 1364 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1367 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, " Eliminar Rutas ", 0, 1, new Font("Cantarell", 0, 11)));
/*      */     
/* 1369 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1377 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1382 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1385 */     this.rSTableMetro3.setAltoHead(25);
/* 1386 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1387 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1388 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1389 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1390 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1391 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1392 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1393 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1394 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1395 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1396 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1397 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1398 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1399 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1400 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1402 */             valesDiesel.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1405 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1407 */             valesDiesel.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1410 */     this.jScrollPane1.setViewportView((Component)this.rSTableMetro3);
/* 1411 */     if (this.rSTableMetro3.getColumnModel().getColumnCount() > 0) {
/* 1412 */       this.rSTableMetro3.getColumnModel().getColumn(0).setMinWidth(80);
/* 1413 */       this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 1414 */       this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     } 
/*      */     
/* 1417 */     this.materialButton20.setBackground(this.lc.SECUNDARIO1);
/* 1418 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 1419 */     this.materialButton20.setMnemonic('C');
/* 1420 */     this.materialButton20.setText("Cerrar");
/* 1421 */     this.materialButton20.setToolTipText("Cerrar (Alt+C)");
/* 1422 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 1423 */     this.materialButton20.setHorizontalTextPosition(0);
/* 1424 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1426 */             valesDiesel.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1430 */     this.materialButton21.setBackground(this.lc.PRIMARIO1);
/* 1431 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 1432 */     this.materialButton21.setMnemonic('E');
/* 1433 */     this.materialButton21.setText("Eliminar");
/* 1434 */     this.materialButton21.setToolTipText("Eliminar (Alt+E)");
/* 1435 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 1436 */     this.materialButton21.setHorizontalTextPosition(0);
/* 1437 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1439 */             valesDiesel.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1443 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 1444 */     this.jPanel22.setLayout(jPanel22Layout);
/* 1445 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 1446 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1447 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 1448 */           .addGap(0, 0, 32767)
/* 1449 */           .addComponent((Component)this.materialButton21, -2, 150, -2)
/* 1450 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1451 */           .addComponent((Component)this.materialButton20, -2, 105, -2))
/* 1452 */         .addComponent(this.jScrollPane1, -1, 375, 32767));
/*      */     
/* 1454 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 1455 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1456 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 1457 */           .addComponent(this.jScrollPane1, -1, 229, 32767)
/* 1458 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1459 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1460 */             .addComponent((Component)this.materialButton20, -2, 38, -2)
/* 1461 */             .addComponent((Component)this.materialButton21, -2, 38, -2))
/* 1462 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1465 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1466 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1467 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1468 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1469 */         .addComponent(this.jPanel21, -1, -1, 32767)
/* 1470 */         .addComponent(this.jPanel22, -1, -1, 32767));
/*      */     
/* 1472 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1473 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1474 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1475 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 1476 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1477 */           .addComponent(this.jPanel22, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1480 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1481 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1482 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1483 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1484 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/* 1486 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1487 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1488 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */ 
/*      */     
/* 1491 */     this.jDialog4.setTitle("Búsqueda de Operadores");
/* 1492 */     this.jDialog4.setModal(true);
/*      */     
/* 1494 */     this.jLabel58.setFont(new Font("Cantarell", 0, 11));
/* 1495 */     this.jLabel58.setHorizontalAlignment(4);
/* 1496 */     this.jLabel58.setText("Clave");
/*      */     
/* 1498 */     this.jTextField22.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1500 */             valesDiesel.this.jTextField22KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1504 */     this.jLabel61.setFont(new Font("Cantarell", 0, 11));
/* 1505 */     this.jLabel61.setHorizontalAlignment(4);
/* 1506 */     this.jLabel61.setText("Nombre");
/*      */     
/* 1508 */     this.jTextField24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1510 */             valesDiesel.this.jTextField24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1513 */     this.jTextField24.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1515 */             valesDiesel.this.jTextField24KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1519 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1527 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1532 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1535 */     this.rSTableMetro4.setAltoHead(25);
/* 1536 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1537 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1538 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1539 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1540 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1541 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1542 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1543 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1544 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1545 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1546 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1547 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO1);
/* 1548 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1549 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1550 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1552 */             valesDiesel.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1555 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1557 */             valesDiesel.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1560 */     this.jScrollPane11.setViewportView((Component)this.rSTableMetro4);
/* 1561 */     if (this.rSTableMetro4.getColumnModel().getColumnCount() > 0) {
/* 1562 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMinWidth(80);
/* 1563 */       this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 1564 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     } 
/*      */     
/* 1567 */     this.materialButton22.setBackground(this.lc.SECUNDARIO1);
/* 1568 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 1569 */     this.materialButton22.setMnemonic('C');
/* 1570 */     this.materialButton22.setText("Cerrar");
/* 1571 */     this.materialButton22.setToolTipText("Cerrar (Alt+C)");
/* 1572 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 1573 */     this.materialButton22.setHorizontalTextPosition(0);
/* 1574 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1576 */             valesDiesel.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1580 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/* 1581 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 1582 */     this.materialButton23.setMnemonic('A');
/* 1583 */     this.materialButton23.setText("Asignar");
/* 1584 */     this.materialButton23.setToolTipText("Asignar (Alt+A)");
/* 1585 */     this.materialButton23.setEnabled(false);
/* 1586 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 1587 */     this.materialButton23.setHorizontalTextPosition(0);
/* 1588 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1590 */             valesDiesel.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1594 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1595 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1596 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1597 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1598 */         .addComponent(this.jScrollPane11, -1, 512, 32767)
/* 1599 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 1600 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1601 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 1602 */               .addGap(25, 25, 25)
/* 1603 */               .addComponent(this.jLabel58, -2, 40, -2)
/* 1604 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1605 */               .addComponent(this.jTextField22, -2, 66, -2)
/* 1606 */               .addGap(18, 18, 18)
/* 1607 */               .addComponent(this.jLabel61, -2, 57, -2)
/* 1608 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1609 */               .addComponent(this.jTextField24))
/* 1610 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 1611 */               .addContainerGap(-1, 32767)
/* 1612 */               .addComponent((Component)this.materialButton23, -2, 150, -2)
/* 1613 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1614 */               .addComponent((Component)this.materialButton22, -2, 105, -2)))
/* 1615 */           .addContainerGap()));
/*      */     
/* 1617 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1618 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1619 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1620 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1621 */             .addComponent(this.jLabel58)
/* 1622 */             .addComponent(this.jTextField22, -2, -1, -2)
/* 1623 */             .addComponent(this.jLabel61)
/* 1624 */             .addComponent(this.jTextField24, -2, -1, -2))
/* 1625 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1626 */           .addComponent(this.jScrollPane11, -1, 283, 32767)
/* 1627 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1628 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1629 */             .addComponent((Component)this.materialButton22, -2, 38, -2)
/* 1630 */             .addComponent((Component)this.materialButton23, -2, 38, -2))
/* 1631 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1634 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1635 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1636 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1638 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 1640 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1641 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1642 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/* 1645 */     this.jDialog5.setTitle("Búsqueda de Empleados");
/* 1646 */     this.jDialog5.setModal(true);
/*      */     
/* 1648 */     this.jLabel63.setFont(new Font("Cantarell", 0, 11));
/* 1649 */     this.jLabel63.setHorizontalAlignment(4);
/* 1650 */     this.jLabel63.setText("Clave");
/*      */     
/* 1652 */     this.jLabel64.setFont(new Font("Cantarell", 0, 11));
/* 1653 */     this.jLabel64.setHorizontalAlignment(4);
/* 1654 */     this.jLabel64.setText("Nombre");
/*      */     
/* 1656 */     this.jTextField25.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1658 */             valesDiesel.this.jTextField25KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1662 */     this.jTextField26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1664 */             valesDiesel.this.jTextField26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1667 */     this.jTextField26.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1669 */             valesDiesel.this.jTextField26KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1673 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1681 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1686 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1689 */     this.rSTableMetro6.setAltoHead(25);
/* 1690 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1691 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/* 1692 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/* 1693 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1694 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/* 1695 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/* 1696 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/* 1697 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1698 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1699 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1700 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/* 1701 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/* 1702 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/* 1703 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 1704 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1706 */             valesDiesel.this.rSTableMetro6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1709 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1711 */             valesDiesel.this.rSTableMetro6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1714 */     this.jScrollPane6.setViewportView((Component)this.rSTableMetro6);
/* 1715 */     if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/* 1716 */       this.rSTableMetro6.getColumnModel().getColumn(0).setMinWidth(80);
/* 1717 */       this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 1718 */       this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     } 
/*      */     
/* 1721 */     this.materialButton34.setBackground(this.lc.PRIMARIO1);
/* 1722 */     this.materialButton34.setForeground(new Color(255, 255, 255));
/* 1723 */     this.materialButton34.setMnemonic('A');
/* 1724 */     this.materialButton34.setText("Asignar");
/* 1725 */     this.materialButton34.setToolTipText("Asignar (Alt+A)");
/* 1726 */     this.materialButton34.setEnabled(false);
/* 1727 */     this.materialButton34.setFont(new Font("Cantarell", 0, 12));
/* 1728 */     this.materialButton34.setHorizontalTextPosition(0);
/* 1729 */     this.materialButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1731 */             valesDiesel.this.materialButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1735 */     this.materialButton37.setBackground(this.lc.SECUNDARIO1);
/* 1736 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1737 */     this.materialButton37.setMnemonic('C');
/* 1738 */     this.materialButton37.setText("Cerrar");
/* 1739 */     this.materialButton37.setToolTipText("Cerrar (Alt+C)");
/* 1740 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1741 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1742 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1744 */             valesDiesel.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1748 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1749 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1750 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1751 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1752 */         .addComponent(this.jScrollPane6, GroupLayout.Alignment.TRAILING)
/* 1753 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1754 */           .addContainerGap()
/* 1755 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1756 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1757 */               .addComponent(this.jLabel63, -2, 40, -2)
/* 1758 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1759 */               .addComponent(this.jTextField25, -2, 52, -2)
/* 1760 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1761 */               .addComponent(this.jLabel64, -2, 57, -2)
/* 1762 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1763 */               .addComponent(this.jTextField26))
/* 1764 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1765 */               .addGap(0, 0, 32767)
/* 1766 */               .addComponent((Component)this.materialButton34, -2, 150, -2)
/* 1767 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1768 */               .addComponent((Component)this.materialButton37, -2, 105, -2)))
/* 1769 */           .addContainerGap()));
/*      */     
/* 1771 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1772 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1773 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1774 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1775 */             .addComponent(this.jLabel63)
/* 1776 */             .addComponent(this.jTextField25, -2, -1, -2)
/* 1777 */             .addComponent(this.jLabel64)
/* 1778 */             .addComponent(this.jTextField26, -2, -1, -2))
/* 1779 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1780 */           .addComponent(this.jScrollPane6, -1, 283, 32767)
/* 1781 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1782 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1783 */             .addComponent((Component)this.materialButton37, -2, 38, -2)
/* 1784 */             .addComponent((Component)this.materialButton34, -2, 38, -2))
/* 1785 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1788 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1789 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1790 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1792 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */     
/* 1794 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1795 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1796 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */ 
/*      */     
/* 1799 */     this.jDialog6.setTitle("Cancelar Vale de Diesel");
/* 1800 */     this.jDialog6.setModal(true);
/*      */     
/* 1802 */     this.jLabel66.setFont(new Font("Cantarell", 0, 11));
/* 1803 */     this.jLabel66.setHorizontalAlignment(4);
/* 1804 */     this.jLabel66.setText("Motivo");
/*      */     
/* 1806 */     this.jTextField19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1808 */             valesDiesel.this.jTextField19ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1811 */     this.jTextField19.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1813 */             valesDiesel.this.jTextField19KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1817 */     this.materialButton29.setBackground(this.lc.SECUNDARIO1);
/* 1818 */     this.materialButton29.setForeground(new Color(255, 255, 255));
/* 1819 */     this.materialButton29.setMnemonic('C');
/* 1820 */     this.materialButton29.setText("Cerrar");
/* 1821 */     this.materialButton29.setToolTipText("Cerrar (Alt+C)");
/* 1822 */     this.materialButton29.setFont(new Font("Cantarell", 0, 12));
/* 1823 */     this.materialButton29.setHorizontalTextPosition(0);
/* 1824 */     this.materialButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1826 */             valesDiesel.this.materialButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1830 */     this.materialButton30.setBackground(this.lc.PRIMARIO1);
/* 1831 */     this.materialButton30.setForeground(new Color(255, 255, 255));
/* 1832 */     this.materialButton30.setMnemonic('C');
/* 1833 */     this.materialButton30.setText("Cancelar");
/* 1834 */     this.materialButton30.setToolTipText("Cancelar (Alt+C)");
/* 1835 */     this.materialButton30.setFont(new Font("Cantarell", 0, 12));
/* 1836 */     this.materialButton30.setHorizontalTextPosition(0);
/* 1837 */     this.materialButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1839 */             valesDiesel.this.materialButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1843 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1844 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1845 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1846 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1847 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1848 */           .addContainerGap()
/* 1849 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1850 */             .addGroup(jPanel9Layout.createSequentialGroup()
/* 1851 */               .addComponent(this.jLabel66, -2, 57, -2)
/* 1852 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1853 */               .addComponent(this.jTextField19))
/* 1854 */             .addGroup(jPanel9Layout.createSequentialGroup()
/* 1855 */               .addGap(0, 80, 32767)
/* 1856 */               .addComponent((Component)this.materialButton30, -2, 150, -2)
/* 1857 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1858 */               .addComponent((Component)this.materialButton29, -2, 105, -2)))
/* 1859 */           .addContainerGap()));
/*      */     
/* 1861 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1862 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1863 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1864 */           .addContainerGap()
/* 1865 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1866 */             .addComponent(this.jLabel66)
/* 1867 */             .addComponent(this.jTextField19, -2, -1, -2))
/* 1868 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1869 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1870 */             .addComponent((Component)this.materialButton29, -2, 38, -2)
/* 1871 */             .addComponent((Component)this.materialButton30, -2, 38, -2))
/* 1872 */           .addContainerGap(32, 32767)));
/*      */ 
/*      */     
/* 1875 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1876 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1877 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1878 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1879 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/* 1881 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1882 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1883 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */ 
/*      */     
/* 1886 */     this.jDialog7.setTitle("Viajes Especiales");
/* 1887 */     this.jDialog7.setModal(true);
/*      */     
/* 1889 */     this.jLabel91.setFont(new Font("Cantarell", 0, 11));
/* 1890 */     this.jLabel91.setHorizontalAlignment(4);
/* 1891 */     this.jLabel91.setText("Conepto");
/*      */     
/* 1893 */     this.jTextField27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1895 */             valesDiesel.this.jTextField27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1899 */     this.materialButton26.setBackground(this.lc.SECUNDARIO1);
/* 1900 */     this.materialButton26.setForeground(new Color(255, 255, 255));
/* 1901 */     this.materialButton26.setMnemonic('C');
/* 1902 */     this.materialButton26.setText("Cerrar");
/* 1903 */     this.materialButton26.setToolTipText("Cerrar (Alt+C)");
/* 1904 */     this.materialButton26.setFont(new Font("Cantarell", 0, 12));
/* 1905 */     this.materialButton26.setHorizontalTextPosition(0);
/* 1906 */     this.materialButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1908 */             valesDiesel.this.materialButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1912 */     this.materialButton27.setBackground(this.lc.PRIMARIO1);
/* 1913 */     this.materialButton27.setForeground(new Color(255, 255, 255));
/* 1914 */     this.materialButton27.setMnemonic('G');
/* 1915 */     this.materialButton27.setText("Guardar");
/* 1916 */     this.materialButton27.setToolTipText("Guardar (Alt+G)");
/* 1917 */     this.materialButton27.setFont(new Font("Cantarell", 0, 12));
/* 1918 */     this.materialButton27.setHorizontalTextPosition(0);
/* 1919 */     this.materialButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1921 */             valesDiesel.this.materialButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1925 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1926 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1927 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1928 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1929 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1930 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1931 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1932 */               .addComponent(this.jLabel91, -2, 63, -2)
/* 1933 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1934 */               .addComponent(this.jTextField27, -1, 299, 32767))
/* 1935 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1936 */               .addGap(0, 0, 32767)
/* 1937 */               .addComponent((Component)this.materialButton27, -2, 150, -2)
/* 1938 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1939 */               .addComponent((Component)this.materialButton26, -2, 105, -2)))
/* 1940 */           .addContainerGap()));
/*      */     
/* 1942 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1943 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1944 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1945 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1946 */             .addComponent(this.jLabel91)
/* 1947 */             .addComponent(this.jTextField27, -2, -1, -2))
/* 1948 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1949 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1950 */             .addComponent((Component)this.materialButton26, -2, 38, -2)
/* 1951 */             .addComponent((Component)this.materialButton27, -2, 38, -2))
/* 1952 */           .addContainerGap(16, 32767)));
/*      */ 
/*      */     
/* 1955 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1956 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1957 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1958 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1959 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 1961 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1962 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1963 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/* 1966 */     this.jDialog8.setTitle("Buscar Guías");
/* 1967 */     this.jDialog8.setModal(true);
/*      */     
/* 1969 */     this.jLabel33.setFont(new Font("Cantarell", 0, 11));
/* 1970 */     this.jLabel33.setHorizontalAlignment(2);
/* 1971 */     this.jLabel33.setText("Guía");
/*      */     
/* 1973 */     this.jTextField28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1975 */             valesDiesel.this.jTextField28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1978 */     this.jTextField28.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1980 */             valesDiesel.this.jTextField28KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1984 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1992 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1997 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2000 */     this.rSTableMetro5.setAltoHead(25);
/* 2001 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2002 */     this.rSTableMetro5.setColorBordeFilas(new Color(200, 200, 200));
/* 2003 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/* 2004 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2005 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/* 2006 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/* 2007 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/* 2008 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2009 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2010 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2011 */     this.rSTableMetro5.setGrosorBordeFilas(0);
/* 2012 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/* 2013 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/* 2014 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/* 2015 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2017 */             valesDiesel.this.rSTableMetro5MouseClicked(evt);
/*      */           }
/*      */         });
/* 2020 */     this.rSTableMetro5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2022 */             valesDiesel.this.rSTableMetro5KeyReleased(evt);
/*      */           }
/*      */         });
/* 2025 */     this.jScrollPane3.setViewportView((Component)this.rSTableMetro5);
/* 2026 */     if (this.rSTableMetro5.getColumnModel().getColumnCount() > 0) {
/* 2027 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMinWidth(80);
/* 2028 */       this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 2029 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     } 
/*      */     
/* 2032 */     this.materialButton28.setBackground(this.lc.PRIMARIO1);
/* 2033 */     this.materialButton28.setForeground(new Color(255, 255, 255));
/* 2034 */     this.materialButton28.setMnemonic('A');
/* 2035 */     this.materialButton28.setText("Asignar");
/* 2036 */     this.materialButton28.setToolTipText("Asignar (Alt+A)");
/* 2037 */     this.materialButton28.setFont(new Font("Cantarell", 0, 12));
/* 2038 */     this.materialButton28.setHorizontalTextPosition(0);
/* 2039 */     this.materialButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2041 */             valesDiesel.this.materialButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2045 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 2046 */     this.jPanel3.setLayout(jPanel3Layout);
/* 2047 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 2048 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2049 */         .addComponent(this.jScrollPane3, -1, 415, 32767)
/* 2050 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 2051 */           .addContainerGap()
/* 2052 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2053 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 2054 */               .addComponent(this.jLabel33, -2, 71, -2)
/* 2055 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2056 */               .addComponent(this.jTextField28))
/* 2057 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 2058 */               .addGap(0, 0, 32767)
/* 2059 */               .addComponent((Component)this.materialButton28, -2, 150, -2)))
/* 2060 */           .addContainerGap()));
/*      */     
/* 2062 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 2063 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2064 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 2065 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2066 */             .addComponent(this.jLabel33)
/* 2067 */             .addComponent(this.jTextField28, -2, -1, -2))
/* 2068 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2069 */           .addComponent(this.jScrollPane3, -1, 273, 32767)
/* 2070 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2071 */           .addComponent((Component)this.materialButton28, -2, 38, -2)
/* 2072 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2075 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2076 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2077 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2079 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/* 2081 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2082 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2083 */         .addGroup(jDialog8Layout.createSequentialGroup()
/* 2084 */           .addComponent(this.jPanel3, -1, -1, 32767)
/* 2085 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 2088 */     this.jDialog9.setTitle("Tipo de Concepto");
/* 2089 */     this.jDialog9.setModal(true);
/*      */     
/* 2091 */     this.jPanel4.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2093 */     this.jRadioButton1.setText("Guías");
/* 2094 */     this.jPanel4.add(this.jRadioButton1);
/*      */     
/* 2096 */     this.jRadioButton2.setText("Otro Concepto");
/* 2097 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2099 */             valesDiesel.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2102 */     this.jPanel4.add(this.jRadioButton2);
/*      */     
/* 2104 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/* 2105 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 2106 */     this.materialButton24.setMnemonic('C');
/* 2107 */     this.materialButton24.setText("Cerrar");
/* 2108 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/* 2109 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 2110 */     this.materialButton24.setHorizontalTextPosition(0);
/* 2111 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2113 */             valesDiesel.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2117 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/* 2118 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/* 2119 */     this.materialButton25.setMnemonic('I');
/* 2120 */     this.materialButton25.setText("Ir");
/* 2121 */     this.materialButton25.setToolTipText("Ir (Alt + I)");
/* 2122 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/* 2123 */     this.materialButton25.setHorizontalTextPosition(0);
/* 2124 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2126 */             valesDiesel.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2130 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 2131 */     this.jPanel11.setLayout(jPanel11Layout);
/* 2132 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 2133 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2134 */         .addComponent(this.jPanel4, -1, 482, 32767)
/* 2135 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 2136 */           .addContainerGap(-1, 32767)
/* 2137 */           .addComponent((Component)this.materialButton25, -2, 150, -2)
/* 2138 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2139 */           .addComponent((Component)this.materialButton24, -2, 105, -2)
/* 2140 */           .addContainerGap()));
/*      */     
/* 2142 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 2143 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2144 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 2145 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 2146 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2147 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2148 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/* 2149 */             .addComponent((Component)this.materialButton25, -2, 38, -2))
/* 2150 */           .addContainerGap(31, 32767)));
/*      */ 
/*      */     
/* 2153 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2154 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2155 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2156 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2157 */         .addGroup(jDialog9Layout.createSequentialGroup()
/* 2158 */           .addComponent(this.jPanel11, -1, -1, 32767)
/* 2159 */           .addGap(0, 0, 0)));
/*      */     
/* 2161 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2162 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2163 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */ 
/*      */     
/* 2166 */     this.jDialog10.setTitle("Detalles del Vale");
/* 2167 */     this.jDialog10.setModal(true);
/*      */     
/* 2169 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*      */     
/* 2171 */     this.jLabel93.setFont(new Font("Cantarell", 1, 22));
/* 2172 */     this.jLabel93.setForeground(this.lc.SECUNDARIO1);
/* 2173 */     this.jLabel93.setHorizontalAlignment(0);
/* 2174 */     this.jLabel93.setText("Detalles del Vale");
/*      */     
/* 2176 */     this.jLabel13.setFont(new Font("Cantarell", 1, 11));
/* 2177 */     this.jLabel13.setForeground(this.lc.SECUNDARIO2);
/* 2178 */     this.jLabel13.setText("Vale:");
/*      */     
/* 2180 */     this.jLabel14.setFont(new Font("Cantarell", 0, 11));
/* 2181 */     this.jLabel14.setForeground(this.lc.PRIMARIO2);
/* 2182 */     this.jLabel14.setText("PR-00001");
/*      */     
/* 2184 */     this.jLabel18.setFont(new Font("Cantarell", 1, 11));
/* 2185 */     this.jLabel18.setForeground(this.lc.SECUNDARIO2);
/* 2186 */     this.jLabel18.setText("Autorizó:");
/*      */     
/* 2188 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/* 2189 */     this.jLabel19.setForeground(this.lc.PRIMARIO2);
/* 2190 */     this.jLabel19.setText("PR-00001");
/*      */     
/* 2192 */     this.jLabel21.setFont(new Font("Cantarell", 0, 11));
/* 2193 */     this.jLabel21.setForeground(this.lc.SECUNDARIO1);
/* 2194 */     this.jLabel21.setText("A continuación se muestra toda la información del vale hasta el momento");
/*      */     
/* 2196 */     this.jLabel51.setFont(new Font("Cantarell", 0, 13));
/* 2197 */     this.jLabel51.setForeground(this.lc.PRIMARIO1);
/* 2198 */     this.jLabel51.setHorizontalAlignment(0);
/* 2199 */     this.jLabel51.setText("<html><u>Cerrar</u></html>");
/* 2200 */     this.jLabel51.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2202 */             valesDiesel.this.jLabel51MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2205 */             valesDiesel.this.jLabel51MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2208 */             valesDiesel.this.jLabel51MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 2212 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/* 2213 */     this.jLabel53.setText("|");
/*      */     
/* 2215 */     this.jLabel98.setFont(new Font("Cantarell", 1, 13));
/* 2216 */     this.jLabel98.setForeground(this.lc.SECUNDARIO2);
/* 2217 */     this.jLabel98.setText("ESTATUS:");
/*      */     
/* 2219 */     this.jLabel101.setFont(new Font("Cantarell", 0, 13));
/* 2220 */     this.jLabel101.setForeground(this.lc.PRIMARIO1);
/* 2221 */     this.jLabel101.setText("jLabel99");
/*      */     
/* 2223 */     this.jTextPane1.setFont(new Font("Cantarell", 0, 11));
/* 2224 */     this.jScrollPane8.setViewportView(this.jTextPane1);
/*      */     
/* 2226 */     this.jLabel54.setFont(new Font("Tahoma", 1, 11));
/* 2227 */     this.jLabel54.setText("|");
/*      */     
/* 2229 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 2230 */     this.jPanel12.setLayout(jPanel12Layout);
/* 2231 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 2232 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2233 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2234 */           .addContainerGap()
/* 2235 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2236 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2237 */               .addComponent(this.jSeparator13, GroupLayout.Alignment.LEADING)
/* 2238 */               .addComponent(this.jLabel93, GroupLayout.Alignment.LEADING, -1, 584, 32767))
/* 2239 */             .addComponent(this.jScrollPane8, -1, 584, 32767)
/* 2240 */             .addComponent(this.jLabel21, -1, 584, 32767)
/* 2241 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 2242 */               .addComponent(this.jLabel98)
/* 2243 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2244 */               .addComponent(this.jLabel101, -1, 200, 32767)
/* 2245 */               .addGap(259, 259, 259)
/* 2246 */               .addComponent(this.jLabel54)
/* 2247 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2248 */               .addComponent(this.jLabel51, -2, -1, -2)
/* 2249 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2250 */               .addComponent(this.jLabel53))
/* 2251 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 2252 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2253 */                 .addComponent(this.jLabel18, -1, 67, 32767)
/* 2254 */                 .addComponent(this.jLabel13, -1, -1, 32767))
/* 2255 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2256 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2257 */                 .addComponent(this.jLabel14, -2, 227, -2)
/* 2258 */                 .addComponent(this.jLabel19, -2, 511, -2))))
/* 2259 */           .addContainerGap()));
/*      */     
/* 2261 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 2262 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2263 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2264 */           .addComponent(this.jLabel93)
/* 2265 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2266 */           .addComponent(this.jSeparator13, -2, 10, -2)
/* 2267 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2268 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2269 */             .addComponent(this.jLabel13)
/* 2270 */             .addComponent(this.jLabel14))
/* 2271 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2272 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2273 */             .addComponent(this.jLabel18)
/* 2274 */             .addComponent(this.jLabel19))
/* 2275 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2276 */           .addComponent(this.jLabel21)
/* 2277 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2278 */           .addComponent(this.jScrollPane8, -2, 258, -2)
/* 2279 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2280 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2281 */             .addComponent(this.jLabel53)
/* 2282 */             .addComponent(this.jLabel51, -2, -1, -2)
/* 2283 */             .addComponent(this.jLabel98)
/* 2284 */             .addComponent(this.jLabel101)
/* 2285 */             .addComponent(this.jLabel54))
/* 2286 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2289 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2290 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2291 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2292 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2293 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 2295 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2296 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2297 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */ 
/*      */     
/* 2300 */     this.jDialog11.setTitle("Complementar Vales");
/* 2301 */     this.jDialog11.setModal(true);
/*      */     
/* 2303 */     this.jLabel72.setFont(new Font("Cantarell", 0, 11));
/* 2304 */     this.jLabel72.setText("Operador ");
/*      */     
/* 2306 */     this.jTextField29.setEditable(false);
/* 2307 */     this.jTextField29.setFont(new Font("Tahoma", 1, 11));
/* 2308 */     this.jTextField29.setForeground(Color.blue);
/*      */     
/* 2310 */     this.jLabel74.setFont(new Font("Cantarell", 0, 11));
/* 2311 */     this.jLabel74.setText("Económico");
/*      */     
/* 2313 */     this.jTextField30.setFont(new Font("Tahoma", 1, 11));
/* 2314 */     this.jTextField30.setForeground(Color.blue);
/*      */     
/* 2316 */     this.jLabel73.setFont(new Font("Cantarell", 0, 11));
/* 2317 */     this.jLabel73.setText("Guías");
/*      */     
/* 2319 */     this.jTextArea2.setColumns(20);
/* 2320 */     this.jTextArea2.setRows(5);
/* 2321 */     this.jScrollPane9.setViewportView(this.jTextArea2);
/*      */     
/* 2323 */     this.materialButton35.setBackground(this.lc.SECUNDARIO1);
/* 2324 */     this.materialButton35.setForeground(new Color(255, 255, 255));
/* 2325 */     this.materialButton35.setMnemonic('C');
/* 2326 */     this.materialButton35.setText("Cerrar");
/* 2327 */     this.materialButton35.setToolTipText("Cerrar (Alt+C)");
/* 2328 */     this.materialButton35.setFont(new Font("Cantarell", 0, 12));
/* 2329 */     this.materialButton35.setHorizontalTextPosition(0);
/* 2330 */     this.materialButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2332 */             valesDiesel.this.materialButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2336 */     this.materialButton36.setBackground(this.lc.PRIMARIO1);
/* 2337 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 2338 */     this.materialButton36.setMnemonic('O');
/* 2339 */     this.materialButton36.setText("Complementar");
/* 2340 */     this.materialButton36.setToolTipText("Complementar (Alt+C)");
/* 2341 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 2342 */     this.materialButton36.setHorizontalTextPosition(0);
/* 2343 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2345 */             valesDiesel.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2349 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 2350 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2352 */             valesDiesel.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2356 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 2357 */     this.jPanel24.setLayout(jPanel24Layout);
/* 2358 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 2359 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2360 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/* 2361 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2362 */             .addGroup(jPanel24Layout.createSequentialGroup()
/* 2363 */               .addGap(0, 0, 32767)
/* 2364 */               .addComponent((Component)this.materialButton36, -2, 150, -2)
/* 2365 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2366 */               .addComponent((Component)this.materialButton35, -2, 105, -2)
/* 2367 */               .addGap(2, 2, 2))
/* 2368 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
/* 2369 */               .addContainerGap()
/* 2370 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2371 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
/* 2372 */                   .addComponent(this.jLabel73, -2, 60, -2)
/* 2373 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2374 */                   .addComponent(this.jScrollPane9, -1, 316, 32767))
/* 2375 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
/* 2376 */                   .addComponent(this.jLabel74, -2, 60, -2)
/* 2377 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2378 */                   .addComponent(this.jTextField30))
/* 2379 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
/* 2380 */                   .addComponent(this.jLabel72, -2, 60, -2)
/* 2381 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2382 */                   .addComponent(this.jTextField29)))))
/* 2383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2384 */           .addComponent(this.jButton6)
/* 2385 */           .addContainerGap()));
/*      */     
/* 2387 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 2388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2389 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 2390 */           .addContainerGap()
/* 2391 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2392 */             .addComponent(this.jButton6)
/* 2393 */             .addGroup(jPanel24Layout.createSequentialGroup()
/* 2394 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2395 */                 .addComponent(this.jTextField29, -2, -1, -2)
/* 2396 */                 .addComponent(this.jLabel72))
/* 2397 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2398 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2399 */                 .addComponent(this.jLabel74)
/* 2400 */                 .addComponent(this.jTextField30, -2, -1, -2))))
/* 2401 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2402 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2403 */             .addGroup(jPanel24Layout.createSequentialGroup()
/* 2404 */               .addComponent(this.jLabel73)
/* 2405 */               .addGap(0, 0, 32767))
/* 2406 */             .addComponent(this.jScrollPane9, -1, 115, 32767))
/* 2407 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2408 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2409 */             .addComponent((Component)this.materialButton35, -2, 38, -2)
/* 2410 */             .addComponent((Component)this.materialButton36, -2, 38, -2))));
/*      */ 
/*      */     
/* 2413 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/* 2414 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/* 2415 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/* 2416 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2417 */         .addComponent(this.jPanel24, -1, -1, 32767));
/*      */     
/* 2419 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/* 2420 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2421 */         .addComponent(this.jPanel24, -1, -1, 32767));
/*      */ 
/*      */     
/* 2424 */     this.jLabel10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 18.0F));
/* 2425 */     this.jLabel10.setForeground(new Color(39, 67, 206));
/* 2426 */     this.jLabel10.setHorizontalAlignment(0);
/* 2427 */     this.jLabel10.setText("La unidad seleccionada está asiganda a la empresa:");
/*      */     
/* 2429 */     this.jLabel11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 2430 */     this.jLabel11.setForeground(new Color(255, 130, 0));
/* 2431 */     this.jLabel11.setHorizontalAlignment(0);
/* 2432 */     this.jLabel11.setText("Servicios y Transportes Ragar, S.A. de C.V.");
/*      */     
/* 2434 */     this.jLabel12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 2435 */     this.jLabel12.setForeground(new Color(255, 130, 0));
/* 2436 */     this.jLabel12.setHorizontalAlignment(0);
/* 2437 */     this.jLabel12.setText("ECO: 23");
/* 2438 */     this.jLabel12.setBorder(BorderFactory.createLineBorder(new Color(39, 67, 206)));
/*      */     
/* 2440 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2441 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2442 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 2443 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2444 */         .addComponent(this.jLabel10, -1, -1, 32767)
/* 2445 */         .addComponent(this.jLabel11, -1, -1, 32767)
/* 2446 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2447 */           .addGap(224, 224, 224)
/* 2448 */           .addComponent(this.jLabel12, -2, 170, -2)
/* 2449 */           .addContainerGap(234, 32767)));
/*      */     
/* 2451 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 2452 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2453 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2454 */           .addComponent(this.jLabel10)
/* 2455 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2456 */           .addComponent(this.jLabel11)
/* 2457 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2458 */           .addComponent(this.jLabel12, -2, 49, -2)
/* 2459 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2462 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/* 2463 */     this.jPanel37.setLayout(jPanel37Layout);
/* 2464 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/* 2465 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2466 */         .addGap(0, 688, 32767));
/*      */     
/* 2468 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/* 2469 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2470 */         .addGap(0, 538, 32767));
/*      */ 
/*      */     
/* 2473 */     this.jPanel20.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2475 */     this.jPanel23.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2477 */     this.jLabel3.setFont(new Font("Cantarell", 1, 22));
/* 2478 */     this.jLabel3.setForeground(this.lc.PRIMARIO1);
/* 2479 */     this.jLabel3.setText("Vales de Diesel");
/*      */     
/* 2481 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/* 2482 */     this.jLabel22.setHorizontalAlignment(4);
/* 2483 */     this.jLabel22.setText("Visualizando información del ");
/*      */     
/* 2485 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2486 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 2487 */     this.jDateChooser4.setIcon(this.icon);
/* 2488 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 2489 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2491 */     this.jLabel50.setFont(new Font("Cantarell", 0, 11));
/* 2492 */     this.jLabel50.setHorizontalAlignment(0);
/* 2493 */     this.jLabel50.setText("al");
/*      */     
/* 2495 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2496 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2497 */     this.jDateChooser5.setIcon(this.icon);
/* 2498 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 2499 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2501 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 2502 */     this.jButton3.setMnemonic('F');
/* 2503 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 2504 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2506 */             valesDiesel.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2510 */     this.jPanel25.setBackground(this.lc.SECUNDARIO2);
/* 2511 */     this.jPanel25.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 2513 */     this.jLabel7.setFont(new Font("Cantarell", 0, 11));
/* 2514 */     this.jLabel7.setForeground(this.lc.PRIMARIO1);
/* 2515 */     this.jLabel7.setText("<html><u>Todos </u></html>");
/* 2516 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2518 */             valesDiesel.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2521 */             valesDiesel.this.jLabel7MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2524 */             valesDiesel.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */         });
/* 2527 */     this.jPanel25.add(this.jLabel7);
/*      */     
/* 2529 */     this.jLabel8.setFont(new Font("Cantarell", 0, 11));
/* 2530 */     this.jLabel8.setForeground(this.lc.PRIMARIO1);
/* 2531 */     this.jLabel8.setHorizontalAlignment(0);
/* 2532 */     this.jLabel8.setText("<html><u>Hoy</u></html>");
/* 2533 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2535 */             valesDiesel.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2538 */             valesDiesel.this.jLabel8MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2541 */             valesDiesel.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */         });
/* 2544 */     this.jPanel25.add(this.jLabel8);
/*      */     
/* 2546 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/* 2547 */     this.jLabel9.setForeground(this.lc.PRIMARIO1);
/* 2548 */     this.jLabel9.setText("<html><u>Ayer</u></html>");
/* 2549 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2551 */             valesDiesel.this.jLabel9MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2554 */             valesDiesel.this.jLabel9MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2557 */             valesDiesel.this.jLabel9MouseEntered(evt);
/*      */           }
/*      */         });
/* 2560 */     this.jPanel25.add(this.jLabel9);
/*      */     
/* 2562 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 2563 */     this.jPanel23.setLayout(jPanel23Layout);
/* 2564 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 2565 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2566 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 2567 */           .addComponent(this.jLabel3, -2, 233, -2)
/* 2568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2569 */           .addComponent(this.jLabel22, -2, 149, -2)
/* 2570 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2571 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 2572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2573 */           .addComponent(this.jLabel50, -2, 16, -2)
/* 2574 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2575 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2577 */           .addComponent(this.jButton3)
/* 2578 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2579 */           .addComponent(this.jPanel25, -2, -1, -2)
/* 2580 */           .addGap(0, 0, 32767)));
/*      */     
/* 2582 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 2583 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2584 */         .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2585 */           .addComponent(this.jLabel22, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2586 */           .addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2587 */         .addComponent((Component)this.jDateChooser4, -2, -1, -2)
/* 2588 */         .addComponent(this.jLabel50, -2, 29, -2)
/* 2589 */         .addComponent(this.jPanel25, -1, -1, 32767)
/* 2590 */         .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2591 */           .addComponent(this.jButton3, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/* 2592 */           .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.LEADING, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2595 */     this.jPanel26.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2597 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 2598 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, "Búsqueda de vales", 0, 1));
/* 2599 */     this.jPanel17.setLayout(new GridLayout(1, 8, 6, 0));
/*      */     
/* 2601 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2602 */     this.jComboBox1.setFont(new Font("Cantarell", 0, 11));
/* 2603 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 2604 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2606 */             valesDiesel.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2609 */     this.jPanel17.add(this.jComboBox1);
/*      */     
/* 2611 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2612 */     this.jComboBox2.setFont(new Font("Cantarell", 0, 11));
/* 2613 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "SÓLO OPERADORES", "SÓLO EMPLEADOS" }));
/* 2614 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2616 */             valesDiesel.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2619 */     this.jPanel17.add(this.jComboBox2);
/*      */     
/* 2621 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2623 */             valesDiesel.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2626 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2628 */             valesDiesel.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2631 */     this.jPanel17.add(this.jTextField1);
/*      */     
/* 2633 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2635 */             valesDiesel.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2638 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2640 */             valesDiesel.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2643 */     this.jPanel17.add(this.jTextField2);
/*      */     
/* 2645 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2647 */             valesDiesel.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2650 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2652 */             valesDiesel.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 2655 */     this.jPanel17.add(this.jTextField3);
/*      */     
/* 2657 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2659 */             valesDiesel.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2662 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2664 */             valesDiesel.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 2667 */     this.jPanel17.add(this.jTextField4);
/*      */     
/* 2669 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2671 */             valesDiesel.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2674 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2676 */             valesDiesel.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/* 2679 */     this.jPanel17.add(this.jTextField5);
/*      */     
/* 2681 */     this.jTextField6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2683 */             valesDiesel.this.jTextField6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2686 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2688 */             valesDiesel.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/* 2691 */     this.jPanel17.add(this.jTextField6);
/*      */     
/* 2693 */     this.jPanel27.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 2695 */     this.jPanel28.setBackground(this.lc.SECUNDARIO2);
/* 2696 */     this.jPanel28.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/* 2698 */     this.jPanel2.setBackground(this.lc.SECUNDARIO1);
/* 2699 */     this.jPanel2.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2701 */     this.jLabel4.setFont(new Font("Cantarell", 0, 13));
/* 2702 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 2703 */     this.jLabel4.setHorizontalAlignment(4);
/* 2704 */     this.jLabel4.setText("Total:");
/* 2705 */     this.jPanel2.add(this.jLabel4);
/*      */     
/* 2707 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 2708 */     this.jLabel48.setForeground(this.lc.PRIMARIO2);
/* 2709 */     this.jLabel48.setHorizontalAlignment(0);
/* 2710 */     this.jLabel48.setText("t");
/* 2711 */     this.jPanel2.add(this.jLabel48);
/*      */     
/* 2713 */     this.jPanel28.add(this.jPanel2);
/*      */     
/* 2715 */     this.jButton4.setMnemonic('V');
/* 2716 */     this.jButton4.setText("Cargar Vale Tractor");
/* 2717 */     this.jButton4.setToolTipText("Cargar Vale Tractor (Alt+V)");
/* 2718 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2720 */             valesDiesel.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2723 */     this.jPanel28.add(this.jButton4);
/*      */     
/* 2725 */     this.jButton36.setMnemonic('U');
/* 2726 */     this.jButton36.setText("Cargar Vale Utilitario");
/* 2727 */     this.jButton36.setToolTipText("Cargar Vale Utilitario (Alt+U)");
/* 2728 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2730 */             valesDiesel.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2733 */     this.jPanel28.add(this.jButton36);
/*      */     
/* 2735 */     this.jButton5.setMnemonic('U');
/* 2736 */     this.jButton5.setText("Complementar Vale");
/* 2737 */     this.jButton5.setToolTipText("Cargar Vale Utilitario (Alt+U)");
/* 2738 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2740 */             valesDiesel.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2743 */     this.jPanel28.add(this.jButton5);
/*      */     
/* 2745 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 2746 */     this.jButton11.setMnemonic('C');
/* 2747 */     this.jButton11.setText("Cancelar");
/* 2748 */     this.jButton11.setToolTipText("Cancelar (Alt+C)");
/* 2749 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2751 */             valesDiesel.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2754 */     this.jPanel28.add(this.jButton11);
/*      */     
/* 2756 */     this.jButton35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Refresh.png")));
/* 2757 */     this.jButton35.setMnemonic('A');
/* 2758 */     this.jButton35.setText("Activar / Desactivar");
/* 2759 */     this.jButton35.setToolTipText("Activar o Desactivar Vale (Alt+A)");
/* 2760 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2762 */             valesDiesel.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2765 */     this.jPanel28.add(this.jButton35);
/*      */     
/* 2767 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 2768 */     this.jButton34.setText("Guardar Reporte");
/* 2769 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2771 */             valesDiesel.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2774 */     this.jPanel28.add(this.jButton34);
/*      */     
/* 2776 */     this.jPanel29.setBackground(new Color(102, 102, 102));
/*      */     
/* 2778 */     this.jScrollPane20.setBackground(new Color(102, 102, 102));
/*      */     
/* 2780 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2788 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2793 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2796 */     this.rSTableMetro1.setAltoHead(40);
/* 2797 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2798 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 2799 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 2800 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2801 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 2802 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 2803 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 2804 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 11));
/* 2805 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 2806 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2807 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2808 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 2809 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 2810 */     this.rSTableMetro1.setSelectionForeground(new Color(255, 255, 255));
/* 2811 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 2812 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2813 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2815 */             valesDiesel.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 2818 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2820 */             valesDiesel.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2823 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 2825 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 2826 */     this.jPanel29.setLayout(jPanel29Layout);
/* 2827 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 2828 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2829 */         .addComponent(this.jScrollPane20, -1, 1719, 32767));
/*      */     
/* 2831 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 2832 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2833 */         .addComponent(this.jScrollPane20, -1, 345, 32767));
/*      */ 
/*      */     
/* 2836 */     this.jScrollPane10.setViewportView(this.jPanel29);
/*      */     
/* 2838 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 2839 */     this.jPanel27.setLayout(jPanel27Layout);
/* 2840 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 2841 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2842 */         .addComponent(this.jPanel28, -2, 0, 32767)
/* 2843 */         .addComponent(this.jScrollPane10, -1, 1019, 32767));
/*      */     
/* 2845 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 2846 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2847 */         .addGroup(jPanel27Layout.createSequentialGroup()
/* 2848 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 2849 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2850 */           .addComponent(this.jScrollPane10, -1, 343, 32767)));
/*      */ 
/*      */     
/* 2853 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 2854 */     this.jPanel26.setLayout(jPanel26Layout);
/* 2855 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 2856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2857 */         .addComponent(this.jPanel17, -2, 0, 32767)
/* 2858 */         .addComponent(this.jPanel27, -1, -1, 32767));
/*      */     
/* 2860 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 2861 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2862 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 2863 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 2864 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2865 */           .addComponent(this.jPanel27, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2868 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2869 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2870 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2871 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2872 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2873 */           .addComponent(this.jPanel23, -1, -1, 32767)
/* 2874 */           .addGap(6, 6, 6))
/* 2875 */         .addComponent(this.jPanel26, -1, -1, 32767));
/*      */     
/* 2877 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2878 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2879 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2880 */           .addComponent(this.jPanel23, -2, -1, -2)
/* 2881 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2882 */           .addComponent(this.jPanel26, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2885 */     GroupLayout layout = new GroupLayout(this);
/* 2886 */     setLayout(layout);
/* 2887 */     layout.setHorizontalGroup(layout
/* 2888 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2889 */         .addGroup(layout.createSequentialGroup()
/* 2890 */           .addComponent(this.jPanel20, -1, -1, 32767)
/* 2891 */           .addGap(0, 0, 0)));
/*      */     
/* 2893 */     layout.setVerticalGroup(layout
/* 2894 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2895 */         .addComponent(this.jPanel20, -1, -1, 32767));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2900 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 2904 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 2905 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2906 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 2910 */     this.jLabel7.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 2914 */     this.jLabel7.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 2918 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2919 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2920 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 2924 */     this.jLabel8.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 2928 */     this.jLabel8.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 2932 */     Calendar ca = Calendar.getInstance();
/* 2933 */     Calendar fecha = Calendar.getInstance();
/* 2934 */     int aa = fecha.get(1);
/* 2935 */     int mm = fecha.get(2);
/* 2936 */     int dd = fecha.get(5);
/* 2937 */     if (dd == 1) {
/* 2938 */       if (mm == 0) {
/* 2939 */         mm = 11;
/* 2940 */         aa--;
/*      */       } else {
/* 2942 */         mm--;
/*      */       } 
/* 2944 */       int diasTotal = diasDelMes(mm, aa);
/* 2945 */       dd = diasTotal;
/*      */     } else {
/* 2947 */       dd--;
/*      */     } 
/* 2949 */     mm++;
/* 2950 */     String año = "" + aa;
/* 2951 */     String mes = "" + mm;
/* 2952 */     String dia = "" + dd;
/* 2953 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2954 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2956 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 2957 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 2958 */     } catch (ParseException ex) {
/* 2959 */       ex.printStackTrace();
/*      */     } 
/* 2961 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 2965 */     this.jLabel9.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel9MouseExited(MouseEvent evt) {
/* 2969 */     this.jLabel9.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2973 */     String cadena = this.jTextField1.getText();
/* 2974 */     if (!cadena.equals("")) {
/* 2975 */       if (this.presionado == null) {
/* 2976 */         this.presionado = new Presionado();
/* 2977 */         this.presionado.start();
/*      */       } else {
/* 2979 */         this.presionado.detenerFuera();
/* 2980 */         this.presionado = new Presionado();
/* 2981 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2984 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2989 */     String cadena = this.jTextField3.getText();
/* 2990 */     if (!cadena.equals("")) {
/* 2991 */       if (this.presionado == null) {
/* 2992 */         this.presionado = new Presionado();
/* 2993 */         this.presionado.start();
/*      */       } else {
/* 2995 */         this.presionado.detenerFuera();
/* 2996 */         this.presionado = new Presionado();
/* 2997 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 3000 */       this.jTextField3.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 3005 */     String cadena = this.jTextField6.getText();
/* 3006 */     if (!cadena.equals("")) {
/* 3007 */       if (this.presionado == null) {
/* 3008 */         this.presionado = new Presionado();
/* 3009 */         this.presionado.start();
/*      */       } else {
/* 3011 */         this.presionado.detenerFuera();
/* 3012 */         this.presionado = new Presionado();
/* 3013 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 3016 */       this.jTextField6.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 3021 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 3025 */     String cadena = this.jTextField4.getText();
/* 3026 */     if (!cadena.equals("")) {
/* 3027 */       if (this.presionado == null) {
/* 3028 */         this.presionado = new Presionado();
/* 3029 */         this.presionado.start();
/*      */       } else {
/* 3031 */         this.presionado.detenerFuera();
/* 3032 */         this.presionado = new Presionado();
/* 3033 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 3036 */       this.jTextField4.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 3041 */     String cadena = this.jTextField5.getText();
/* 3042 */     if (!cadena.equals("")) {
/* 3043 */       if (this.presionado == null) {
/* 3044 */         this.presionado = new Presionado();
/* 3045 */         this.presionado.start();
/*      */       } else {
/* 3047 */         this.presionado.detenerFuera();
/* 3048 */         this.presionado = new Presionado();
/* 3049 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 3052 */       this.jTextField5.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 3057 */     String cadena = this.jTextField2.getText();
/* 3058 */     if (!cadena.equals("")) {
/* 3059 */       if (this.presionado == null) {
/* 3060 */         this.presionado = new Presionado();
/* 3061 */         this.presionado.start();
/*      */       } else {
/* 3063 */         this.presionado.detenerFuera();
/* 3064 */         this.presionado = new Presionado();
/* 3065 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 3068 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 3073 */     limpiar();
/* 3074 */     this.jCheckBox1.setSelected(false);
/* 3075 */     desactivarNocturno();
/* 3076 */     this.jRadioButton5.setSelected(true);
/* 3077 */     this.jFormattedTextField1.setEnabled(true);
/* 3078 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 3079 */     this.jFormattedTextField1.setBackground(Color.WHITE);
/* 3080 */     sacarMayor();
/* 3081 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 3085 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 3093 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 3097 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3101 */     int valor = this.rSTableMetro1.getSelectedRow();
/* 3102 */     if (valor < 0) {
/* 3103 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un vale de diesel para poder complementarlo", "Selecciona un vale", 0, this.ADVER);
/*      */     } else {
/* 3105 */       String nom1 = String.valueOf(this.rSTableMetro1.getValueAt(valor, 3));
/* 3106 */       String nom2 = String.valueOf(this.rSTableMetro1.getValueAt(valor, 4));
/* 3107 */       System.out.println("Nombres:" + nom1 + "-" + nom2);
/* 3108 */       if (nom1.equals("  ") && nom2.equals("  ")) {
/*      */         
/* 3110 */         this.jTextArea2.setText(String.valueOf(this.rSTableMetro1.getValueAt(valor, 6)));
/* 3111 */         this.jDialog11.setVisible(true);
/*      */       } else {
/* 3113 */         JOptionPane.showMessageDialog(this.padre, "El vale que seleccionaste ya se encuentra complementado", "Vale complementado", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField18ActionPerformed(ActionEvent evt) {
/* 3119 */     guardarRuta();
/*      */   }
/*      */   
/*      */   private void jTextField22KeyReleased(KeyEvent evt) {
/* 3123 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField24KeyReleased(KeyEvent evt) {
/* 3127 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField25KeyReleased(KeyEvent evt) {
/* 3131 */     consultar3();
/*      */   }
/*      */   
/*      */   private void jTextField26KeyReleased(KeyEvent evt) {
/* 3135 */     consultar3();
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 3139 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField19ActionPerformed(ActionEvent evt) {
/* 3143 */     cancelar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField19KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 3151 */     this.error.pasarModal(true);
/* 3152 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3153 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 3154 */     this.CLAVE = num;
/* 3155 */     String estado = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 8));
/* 3156 */     if (estado.equals("ACTIVO")) {
/* 3157 */       this.jDialog6.setVisible(true);
/*      */     } else {
/* 3159 */       JOptionPane.showMessageDialog(this.jDialog6, "No puedes cancelar este vale porque no se encuentra activo", "Vale Cancelado", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField27ActionPerformed(ActionEvent evt) {
/* 3164 */     this.error.pasarModal(true);
/* 3165 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3166 */     String motivo = this.jTextField27.getText();
/* 3167 */     if (motivo.equals("")) {
/* 3168 */       this.error.cargarError(this.jTextField27, "050");
/* 3169 */     } else if (!this.val.validarApostrofe(this.jTextField27, motivo, "020")) {
/* 3170 */       String conte = this.jTextField27.getText().toUpperCase();
/* 3171 */       for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3172 */         String valor = String.valueOf(this.rSTableMetro2.getValueAt(i, 0));
/* 3173 */         if (valor.equals("")) {
/* 3174 */           this.rSTableMetro2.setValueAt("<s/guía>", i, 0);
/* 3175 */           this.rSTableMetro2.setValueAt(conte, i, 1);
/* 3176 */           this.INDICE++;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3180 */       this.jDialog7.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3185 */     this.jTextField27.setText("");
/* 3186 */     this.jDialog9.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 3194 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" },  }, (Object[])new String[] { "Guía", "Fecha/Concepto" })
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
/* 3210 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3215 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3218 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/* 3219 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 3220 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     
/* 3222 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 3223 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 3224 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 3225 */     this.INDICE = 0;
/*      */   }
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {
/* 3229 */     int indice = this.rSTableMetro2.getSelectedRow();
/* 3230 */     String valor = String.valueOf(this.rSTableMetro2.getValueAt(indice, 0));
/* 3231 */     if (valor.equals("") || valor.equals(null)) {
/* 3232 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes quitar información porque no has seleccionado una guía", "Selecciona una guía", 0, this.ERROR);
/*      */     } else {
/* 3234 */       this.INDICE--;
/* 3235 */       this.rSTableMetro2.setValueAt("", indice, 0);
/* 3236 */       this.rSTableMetro2.setValueAt("", indice, 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField28KeyReleased(KeyEvent evt) {
/* 3241 */     String cadena = this.jTextField28.getText();
/* 3242 */     if (this.presionado2 == null) {
/* 3243 */       this.presionado2 = new Presionado2();
/* 3244 */       this.presionado2.start();
/*      */     } else {
/* 3246 */       this.presionado2.detenerFuera();
/* 3247 */       this.presionado2 = new Presionado2();
/* 3248 */       this.presionado2.start();
/*      */     } 
/* 3250 */     this.jTextField28.setBackground(new Color(237, 107, 107));
/*      */   }
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 3254 */     String num = JOptionPane.showInputDialog(this.jDialog1, "Inserta el nuevo número de tractor:", "Número de Tractor", 1);
/* 3255 */     if (num.equals("")) {
/* 3256 */       JOptionPane.showMessageDialog(this.jDialog1, "Debes insertar el número del tractor, por favor completa tu información", "Número de Tractor", 0, this.ERROR);
/*      */     } else {
/*      */       try {
/* 3259 */         int nu = Integer.parseInt(num);
/* 3260 */         this.jTextField17.setText(num);
/* 3261 */       } catch (NumberFormatException n) {
/* 3262 */         JOptionPane.showMessageDialog(this.jDialog1, "El formato que insertaste no es correcto, sólo puedes insertar números", "Sólo Números", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 3268 */     String[] datos = { "FOLIO", "FECHA", "RUTA", "EMPLEADO", "OPERADOR", "ECO", "GUÍAS", "DOCUMENTÓ", "ESTATUS" };
/* 3269 */     this.esc = new EscribirReporte("VALES DIESEL", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 3273 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField28ActionPerformed(ActionEvent evt) {
/* 3277 */     String guia = this.jTextField28.getText();
/* 3278 */     this.rSTableMetro5.selectAll();
/* 3279 */     cargarGuia();
/*      */   }
/*      */   
/*      */   private void jTextField24ActionPerformed(ActionEvent evt) {
/* 3283 */     this.rSTableMetro4.selectAll();
/* 3284 */     cargarOperador();
/*      */   }
/*      */   
/*      */   private void jTextField26ActionPerformed(ActionEvent evt) {
/* 3288 */     this.rSTableMetro6.selectAll();
/* 3289 */     cargarEmpleado();
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3293 */     int indice = this.rSTableMetro2.getSelectedRow();
/* 3294 */     String valor = String.valueOf(this.rSTableMetro2.getValueAt(indice, 0));
/* 3295 */     if (valor.equals("") || valor.equals(null)) {
/* 3296 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes quitar información porque no has seleccionado una guía", "Selecciona una guía", 0, this.ERROR);
/*      */     } else {
/* 3298 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html><b><font color = red>Una ves saldada la guía ya no se puede activar</font></b><br>¿Estás seguro que deseas saldar la guía: <font color=blue>" + String.valueOf(this.rSTableMetro2.getValueAt(this.rSTableMetro2.getSelectedRow(), 0)) + "</font>?</html>", "Saldar Guía", 0, 1, this.PREG);
/* 3299 */       if (res == 0) {
/* 3300 */         this.con.inserSinMsj("update guias set diesel = '0' where num_guia = '" + String.valueOf(this.rSTableMetro2.getValueAt(this.rSTableMetro2.getSelectedRow(), 0)) + "'");
/* 3301 */         this.INDICE--;
/* 3302 */         this.rSTableMetro2.setValueAt("", indice, 0);
/* 3303 */         this.rSTableMetro2.setValueAt("", indice, 1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 3309 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 3310 */     this.con.consultar("folio_liq", "vales_diesel", "where folio = '" + num + "'");
/* 3311 */     if (this.con.Campo.equals("")) {
/* 3312 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html><b><font color = red></font></b><br>Si desactivas el vale de diesel no se podrá visualizar en la liquidación del empleado:<br><font color=blue>¿Estás seguro que deseas desactivar?</font></html>", "Desactivar Vale", 0, 1, this.PREG);
/* 3313 */       if (res == 0) {
/* 3314 */         this.con.inserSinMsj("update vales_diesel set folio_liq='DESACTIVADO' where folio = '" + num + "'");
/*      */       }
/*      */     } else {
/* 3317 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html><b><font color = red></font></b><br>Activa este vale de diesel para que se pueda cobrar al empleado:<br><font color=blue>¿Estás seguro que deseas activarlo?</font></html>", "Activar Vale", 0, 1, this.PREG);
/* 3318 */       if (res == 0) {
/* 3319 */         this.con.inserSinMsj("update vales_diesel set folio_liq='' where folio = '" + num + "'");
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 3325 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 3329 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 3333 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {
/* 3337 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 3341 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField6ActionPerformed(ActionEvent evt) {
/* 3345 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel51MouseClicked(MouseEvent evt) {
/* 3349 */     this.jDialog10.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel51MouseEntered(MouseEvent evt) {
/* 3353 */     this.jLabel51.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel51MouseExited(MouseEvent evt) {
/* 3357 */     this.jLabel51.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 3361 */     this.jFormattedTextField1.setEnabled(true);
/* 3362 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 3366 */     this.jFormattedTextField1.setEnabled(false);
/* 3367 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jRadioButton6ActionPerformed(ActionEvent evt) {
/* 3371 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 3372 */     this.jFormattedTextField2.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 3376 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 3377 */     this.jFormattedTextField2.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 3381 */     if (this.jCheckBox1.isSelected()) {
/* 3382 */       this.jButton7.setEnabled(false);
/* 3383 */       this.jButton8.setEnabled(false);
/* 3384 */       this.jButton32.setEnabled(false);
/* 3385 */       this.jButton2.setEnabled(false);
/* 3386 */       this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" },  }, (Object[])new String[] { "Guía", "Fecha/Concepto" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 3402 */             boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3407 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 3410 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/* 3411 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 3412 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */       
/* 3414 */       this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 3415 */       this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*      */       
/* 3417 */       this.rSTableMetro2.setValueAt("<s/guía>", 0, 0);
/* 3418 */       this.rSTableMetro2.setValueAt("VALE NOCTURNO", 0, 1);
/*      */     } else {
/* 3420 */       desactivarNocturno();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 3425 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 3426 */     this.jRadioButton6.setSelected(true);
/* 3427 */     this.jFormattedTextField2.setEnabled(true);
/* 3428 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 3429 */     this.jFormattedTextField2.setBackground(Color.WHITE);
/* 3430 */     sacarMayor();
/* 3431 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 3439 */     if (evt.getClickCount() == 2) {
/* 3440 */       verVale();
/* 3441 */       this.jDialog10.setVisible(true);
/*      */     } else {
/* 3443 */       this.con.Campo = this.CAMPOSGENERALES.get("priv");
/* 3444 */       if (this.con.Campo.equals("RECURSOS HUMANOS") || this.con.Campo.equals("CAPTURISTA") || this.con.Campo.equals("GERENTE DE OPERACIONES")) {
/* 3445 */         this.jButton4.setEnabled(false);
/* 3446 */         this.jButton5.setEnabled(false);
/* 3447 */         this.jButton11.setEnabled(false);
/* 3448 */         this.jButton35.setEnabled(false);
/* 3449 */         this.jButton36.setEnabled(false);
/* 3450 */       } else if (this.con.Campo.equals("LIQUIDACIONES")) {
/* 3451 */         this.jButton4.setEnabled(true);
/* 3452 */         this.jButton5.setEnabled(true);
/* 3453 */         this.jButton36.setEnabled(true);
/*      */       } else {
/*      */         
/* 3456 */         this.jButton35.setEnabled(true);
/* 3457 */         this.jButton4.setEnabled(true);
/* 3458 */         this.jButton5.setEnabled(true);
/* 3459 */         this.jButton11.setEnabled(true);
/* 3460 */         this.jButton36.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton18ActionPerformed(ActionEvent evt) {
/* 3470 */     this.jDialog1.setVisible(false);
/* 3471 */     limpiar();
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 3475 */     limpiar();
/*      */   }
/*      */   
/*      */   private void materialButton16ActionPerformed(ActionEvent evt) {
/* 3479 */     this.error.pasarModal(true);
/* 3480 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3481 */     this.con.consultar("num_concep", "vales_diesel_conceptos", "where concepto  = '" + String.valueOf(this.jComboBox3.getSelectedItem()) + "'");
/* 3482 */     String ruta = this.con.Campo;
/* 3483 */     double litros = Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()));
/* 3484 */     if (this.jComboBox3.getSelectedIndex() == 0) {
/* 3485 */       this.error.cargarError(this.jComboBox3, "050");
/* 3486 */     } else if (this.jTextField20.getText().equals("") && !this.jCheckBox1.isSelected()) {
/* 3487 */       JOptionPane.showMessageDialog(this.jDialog1, "No has agregado al operador para asignarle el vale de diesel", "Sin Operador", 0, this.ERROR);
/* 3488 */     } else if (this.INDICE <= 0 && !this.jCheckBox1.isSelected()) {
/* 3489 */       JOptionPane.showMessageDialog(this.jDialog1, "El operador que seleccionaste no tiene guías asignadas para este viaje y no se puede dar diesel sin viajes", "Ningín Viaje", 0, this.ERROR);
/* 3490 */     } else if (litros <= 0.0D && this.jFormattedTextField1.isEnabled()) {
/* 3491 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 3492 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes colocar un litraje con valores negativos o valor a cero", "Cero Litros", 0, this.ERROR);
/*      */     } else {
/* 3494 */       String litrosLetra = "";
/* 3495 */       if (this.jRadioButton5.isSelected()) {
/* 3496 */         litrosLetra = String.valueOf(this.jFormattedTextField1.getValue());
/*      */       } else {
/* 3498 */         litrosLetra = "SISA";
/*      */       } 
/*      */       
/* 3501 */       this.GUIAS = new String[10];
/* 3502 */       String guias = "";
/* 3503 */       for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3504 */         String concep = String.valueOf(this.rSTableMetro2.getValueAt(i, 0));
/* 3505 */         if (concep.equals("<s/guía>")) {
/* 3506 */           concep = String.valueOf(this.rSTableMetro2.getValueAt(i, 1));
/* 3507 */           this.GUIAS[i] = concep;
/*      */         } else {
/* 3509 */           this.GUIAS[i] = concep;
/* 3510 */           String fecha = String.valueOf(this.rSTableMetro2.getValueAt(i, 1));
/* 3511 */           if (fecha.equals("Guía Extra")) {
/* 3512 */             concep = concep + " G.E.";
/*      */           }
/*      */         } 
/* 3515 */         if (!concep.equals("")) {
/* 3516 */           guias = guias + guias + "/";
/*      */         }
/*      */       } 
/* 3519 */       String[] campos = { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guía", "Autorizó" };
/* 3520 */       String[] info = { this.jTextField61.getText(), this.jTextField71.getText(), String.valueOf(this.jComboBox3.getSelectedItem()), this.jTextField20.getText(), this.jTextField17.getText(), guias, this.jTextField21.getText() };
/* 3521 */       int res = this.error.cargarDatos(campos, info);
/* 3522 */       if (res == 0) {
/* 3523 */         sacarMayor();
/* 3524 */         String eco = this.jTextField17.getText();
/* 3525 */         for (int j = 0; j < this.GUIAS.length; j++) {
/* 3526 */           if (!this.GUIAS[j].equals("")) {
/* 3527 */             this.con.inserSinMsj("update guias set diesel = '" + this.jTextField61.getText() + "' where num_guia = '" + this.GUIAS[j] + "'");
/* 3528 */             this.con.inserSinMsj("insert into vales_diesel_guias(folio,num_guia)values('" + this.jTextField61.getText().toUpperCase() + "','" + this.GUIAS[j] + "')");
/*      */           } 
/*      */         } 
/* 3531 */         if (this.jCheckBox1.isSelected()) {
/* 3532 */           this.CLAVEOP = "0";
/* 3533 */           eco = "0";
/*      */         } 
/*      */         
/* 3536 */         this.con.inserSinMsj("insert into vales_diesel(folio,fecha,num_emp,num_ope,guias,eco,eco_letra,num_concep,litros,precioLitro,precioLitroLetra,total,totalLetra,folio_liq,documento,estado,empresa) values('" + this.jTextField61.getText() + "',now(),0," + this.CLAVEOP + ",'" + guias + "'," + eco + ",'T-" + this.jTextField17.getText() + "'," + ruta + "," + litros + ",0,'',0,'','','" + this.jTextField21.getText() + "','ACTIVO','')");
/* 3537 */         String[] campos1 = { this.jTextField61.getText(), this.jTextField71.getText(), String.valueOf(this.jComboBox3.getSelectedItem()), this.jTextField20.getText(), this.jTextField17.getText(), this.jTextField21.getText(), guias, litrosLetra };
/* 3538 */         ImprimirValeD imp = new ImprimirValeD();
/* 3539 */         imp.recibeDatos(campos1, 0);
/*      */ 
/*      */         
/* 3542 */         res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Se imprimió correctamente el vale de diesel?", "¿Impresión Correcta?", 0, 3, this.PREG);
/* 3543 */         if (res == 1) {
/* 3544 */           imp.recibeDatos(campos1, 0);
/*      */         }
/* 3546 */         limpiar();
/* 3547 */         consultar();
/* 3548 */         this.jDialog1.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton17ActionPerformed(ActionEvent evt) {
/* 3562 */     guardarRuta();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 3574 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 3578 */     String ind = "";
/* 3579 */     int contar = 0;
/* 3580 */     int contador = 0;
/* 3581 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 3582 */       String val = String.valueOf(this.rSTableMetro3.getValueAt(i, 0));
/* 3583 */       if (val.equals("true")) {
/* 3584 */         String valor = String.valueOf(this.rSTableMetro3.getValueAt(i, 1));
/* 3585 */         this.encontrado = this.con.consultar("num_concep", "vales_diesel", " where num_concep = " + valor);
/* 3586 */         if (this.encontrado) {
/* 3587 */           JOptionPane.showMessageDialog(this.padre, "No puedes eliminar la siguiente ruta " + String.valueOf(this.rSTableMetro3.getValueAt(i, 2)) + ", porque existen vales asignados a ésta.", "Error al Eliminar Rutas", 0, this.ERROR);
/*      */           return;
/*      */         } 
/* 3590 */         contar++;
/*      */       } 
/*      */     } 
/* 3593 */     if (contar == 0) {
/* 3594 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar Rutas", "Selecciona Una Ruta", 0, this.INFO);
/* 3595 */     } else if (contar == 1) {
/* 3596 */       int doc = 0;
/* 3597 */       for (int j = 0; j < this.rSTableMetro3.getRowCount(); j++) {
/* 3598 */         String val = String.valueOf(this.rSTableMetro3.getValueAt(j, 0));
/* 3599 */         if (val.equals("true")) {
/* 3600 */           String str = String.valueOf(this.rSTableMetro3.getValueAt(j, 1));
/* 3601 */           doc = j;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3605 */       String valor = "<html><b>Clave de la Ruta: </b>" + String.valueOf(this.rSTableMetro3.getValueAt(doc, 1)) + "<br><b>Ruta: </b>" + String.valueOf(this.rSTableMetro3.getValueAt(doc, 2)) + "<br></html>";
/* 3606 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Ruta", 0, 3, this.ELIMINAR);
/* 3607 */       if (res == 0) {
/* 3608 */         String val = String.valueOf(this.rSTableMetro3.getValueAt(doc, 1));
/* 3609 */         String[] reg = this.con.regresaReg("num_concep,concepto", "vales_diesel_conceptos", "where num_concep = " + val, 2);
/* 3610 */         this.con.eliminar("vales_diesel_conceptos", "where num_concep=" + val);
/* 3611 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó la Ruta " + val + " definitivamente.','Clave de la Ruta: " + val + "\nRuta: " + reg[1] + "')");
/* 3612 */         consultar1();
/* 3613 */         llenarCombo();
/*      */       } 
/*      */     } else {
/*      */       
/* 3617 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Departamentos", 0, 3, this.ELIMINAR);
/* 3618 */       if (res == 0) {
/* 3619 */         for (int j = 0; j < this.rSTableMetro3.getRowCount(); j++) {
/* 3620 */           String val = String.valueOf(this.rSTableMetro3.getValueAt(j, 0));
/* 3621 */           if (val.equals("true")) {
/* 3622 */             String valor = String.valueOf(this.rSTableMetro3.getValueAt(j, 1));
/* 3623 */             String[] reg = this.con.regresaReg("clave_depa,nombre", "departamentos", "where clave_depa = " + valor, 2);
/* 3624 */             contador++;
/* 3625 */             this.con.eliminar2("departamentos", "where clave_depa=" + valor);
/* 3626 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el departamento " + val + " definitivamente.','Clave del Departamento: " + val + "\nNombre: " + reg[1] + "')");
/*      */           } 
/*      */         } 
/* 3629 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + contador + " departamentos.", "Departamentos Eliminados", 0, this.INFO);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 3635 */     if (evt.getClickCount() == 2) {
/* 3636 */       if (this.jDialog11.isVisible()) {
/* 3637 */         String clave = String.valueOf(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0));
/* 3638 */         this.CLAVEOP = clave;
/* 3639 */         this.operadores = this.con.regresaReg("num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope =" + clave, 4);
/* 3640 */         this.jTextField29.setText(this.operadores[1] + " " + this.operadores[1] + " " + this.operadores[2]);
/* 3641 */         this.con.consultar("num_tracto", "llamadas_historicas", "where num_ope = " + this.CLAVEOP + " order by num_llama desc");
/* 3642 */         this.jTextField30.setText(this.con.Campo);
/* 3643 */         this.jDialog4.setVisible(false);
/*      */       } else {
/* 3645 */         cargarOperador();
/*      */       } 
/*      */     } else {
/* 3648 */       int ind = this.rSTableMetro4.getSelectedRow();
/* 3649 */       String nombre = String.valueOf(this.rSTableMetro4.getValueAt(ind, 0));
/* 3650 */       String ap = String.valueOf(this.rSTableMetro4.getValueAt(ind, 1));
/* 3651 */       this.materialButton23.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 3660 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 3664 */     if (this.jDialog11.isVisible()) {
/* 3665 */       String clave = String.valueOf(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0));
/* 3666 */       this.CLAVEOP = clave;
/* 3667 */       this.operadores = this.con.regresaReg("num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope =" + clave, 4);
/* 3668 */       this.jTextField29.setText(this.operadores[1] + " " + this.operadores[1] + " " + this.operadores[2]);
/* 3669 */       this.con.consultar("num_tracto", "llamadas_historicas", "where num_ope = " + this.CLAVEOP + " order by num_llama desc");
/* 3670 */       this.jTextField30.setText(this.con.Campo);
/* 3671 */       this.jDialog4.setVisible(false);
/*      */     } else {
/* 3673 */       cargarOperador();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 3678 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 3682 */     if (this.jRadioButton1.isSelected()) {
/*      */       
/* 3684 */       this.jDialog9.setVisible(false);
/* 3685 */       this.jDialog8.setVisible(true);
/*      */     } else {
/* 3687 */       this.jDialog9.setVisible(false);
/* 3688 */       this.jDialog7.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton26ActionPerformed(ActionEvent evt) {
/* 3693 */     this.jTextField27.setText("");
/* 3694 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton27ActionPerformed(ActionEvent evt) {
/* 3698 */     this.error.pasarModal(true);
/* 3699 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3700 */     String motivo = this.jTextField27.getText();
/* 3701 */     if (motivo.equals("")) {
/* 3702 */       this.error.cargarError(this.jTextField27, "050");
/* 3703 */     } else if (!this.val.validarApostrofe(this.jTextField27, motivo, "020")) {
/* 3704 */       String conte = this.jTextField27.getText().toUpperCase();
/* 3705 */       for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3706 */         String valor = String.valueOf(this.rSTableMetro2.getValueAt(i, 0));
/* 3707 */         if (valor.equals("")) {
/* 3708 */           this.rSTableMetro2.setValueAt("<s/guía>", i, 0);
/* 3709 */           this.rSTableMetro2.setValueAt(conte, i, 1);
/* 3710 */           this.INDICE++;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 3715 */       this.jDialog7.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro5MouseClicked(MouseEvent evt) {
/* 3720 */     if (evt.getClickCount() == 2) {
/* 3721 */       cargarGuia();
/*      */     } else {
/* 3723 */       this.materialButton28.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro5KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton28ActionPerformed(ActionEvent evt) {
/* 3732 */     cargarGuia();
/*      */   }
/*      */   
/*      */   private void materialButton29ActionPerformed(ActionEvent evt) {
/* 3736 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton30ActionPerformed(ActionEvent evt) {
/* 3740 */     cancelar();
/*      */   }
/*      */   
/*      */   private void materialButton35ActionPerformed(ActionEvent evt) {
/* 3744 */     this.jDialog11.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 3748 */     if (this.jTextField29.getText().equals("")) {
/* 3749 */       JOptionPane.showMessageDialog(this.padre, "Te falta agregar el nombre del operador", "Falta Operador", 0, this.ERROR);
/* 3750 */     } else if (this.jTextField30.getText().equals("")) {
/* 3751 */       this.jTextField30.setBackground(Color.RED);
/* 3752 */       JOptionPane.showMessageDialog(this.padre, "Te falta agregar el número de económico", "Falta Económico", 0, this.ERROR);
/* 3753 */     } else if (this.jTextArea2.getText().equals("")) {
/* 3754 */       this.jTextArea2.setBackground(Color.RED);
/* 3755 */       JOptionPane.showMessageDialog(this.padre, "Te falta agregar las guías", "Faltan Guías", 0, this.ERROR);
/*      */     } else {
/* 3757 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas complementar el vale de diesel que seleccionaste?", "Complementar Vale", 0, 1, this.PREG);
/* 3758 */       if (res == 0) {
/* 3759 */         this.con.inserSinMsj("update vales_diesel set num_ope= " + this.CLAVEOP + ", guias='" + this.jTextArea2.getText().toUpperCase() + "', eco_Letra = 'T-" + this.jTextField30.getText() + "' where folio='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/* 3760 */         this.jDialog11.setVisible(false);
/* 3761 */         this.jTextField30.setText("");
/* 3762 */         this.jTextField29.setText("");
/* 3763 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 3769 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton31ActionPerformed(ActionEvent evt) {
/* 3773 */     this.error.pasarModal(true);
/* 3774 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3775 */     double litros = Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 3776 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/* 3777 */       this.error.cargarError(this.jComboBox4, "050");
/* 3778 */     } else if (this.jTextArea1.getText().equals("")) {
/* 3779 */       this.error.cargarError(this.jTextArea1, "050");
/* 3780 */     } else if (!this.val.validarApostrofe(this.jTextArea1, this.jTextArea1.getText(), "020")) {
/* 3781 */       if (this.jTextField23.getText().equals("")) {
/* 3782 */         JOptionPane.showMessageDialog(this.jDialog2, "No has agregado al empleado para asignarle el vale de diesel", "Sin Empleado", 0, this.ERROR);
/* 3783 */       } else if (this.jTextField33.getText().equals("")) {
/* 3784 */         this.error.cargarError(this.jTextField33, "050");
/* 3785 */       } else if (litros <= 0.0D && this.jFormattedTextField2.isEnabled()) {
/* 3786 */         this.jFormattedTextField2.setBackground(Color.RED);
/* 3787 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes colocar un litraje con valores negativos o valor a cero", "Cero Litros", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 3790 */         String litrosLetra = "";
/* 3791 */         if (this.jRadioButton6.isSelected()) {
/* 3792 */           litrosLetra = String.valueOf(this.jFormattedTextField2.getValue());
/*      */         } else {
/* 3794 */           litrosLetra = "LLENO";
/*      */         } 
/*      */         
/* 3797 */         this.con.consultar("num_concep", "vales_diesel_conceptos", "where concepto = '" + String.valueOf(this.jComboBox4.getSelectedItem()) + "'");
/* 3798 */         String ruta = this.con.Campo;
/* 3799 */         String[] campos = { "Folio", "Fecha", "Ruta", "Empleado", "Utilitario", "Autorizó" };
/* 3800 */         String[] info = { this.jTextField62.getText(), this.jTextField72.getText(), String.valueOf(this.jComboBox4.getSelectedItem()), this.jTextField23.getText(), this.jTextField33.getText(), this.jTextField34.getText() };
/* 3801 */         int res = this.error.cargarDatos(campos, info);
/* 3802 */         if (res == 0) {
/* 3803 */           sacarMayor();
/* 3804 */           this.con.inserSinMsj("insert into vales_diesel(folio,fecha,num_emp,num_ope,guias,eco,eco_letra,num_concep,litros,precioLitro,precioLitroLetra,total,totalLetra,folio_liq,documento,estado,empresa) values('" + this.jTextField62
/*      */               
/* 3806 */               .getText() + "',now()," + this.CLAVEOP + ",0,'" + this.jTextArea1
/*      */ 
/*      */ 
/*      */               
/* 3810 */               .getText().toUpperCase() + "'," + this.utilitarios.utilitarios
/* 3811 */               .getNum() + ",'U-" + this.jTextField33
/* 3812 */               .getText() + "'," + ruta + "," + litros + ",0,'',0,'','','" + this.jTextField34
/*      */               
/* 3814 */               .getText().toUpperCase() + "','ACTIVO','')");
/* 3815 */           String[] campos1 = { this.jTextField62.getText(), this.jTextField72.getText(), String.valueOf(this.jComboBox4.getSelectedItem()), this.jTextArea1.getText().toUpperCase(), this.jTextField23.getText(), this.jTextField33.getText(), this.jTextField34.getText(), litrosLetra };
/* 3816 */           ImprimirValeD imp = new ImprimirValeD();
/* 3817 */           imp.recibeDatos(campos1, 1);
/* 3818 */           res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Se imprimió correctamente el vale de diesel?", "¿Impresión Correcta?", 0, 3, this.PREG);
/* 3819 */           if (res == 1) {
/* 3820 */             imp.recibeDatos(campos1, 1);
/*      */           }
/*      */           
/* 3823 */           limpiar();
/* 3824 */           consultar();
/* 3825 */           this.jDialog2.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton32ActionPerformed(ActionEvent evt) {
/* 3832 */     limpiar();
/*      */   }
/*      */   
/*      */   private void materialButton33ActionPerformed(ActionEvent evt) {
/* 3836 */     this.jDialog2.setVisible(false);
/* 3837 */     limpiar();
/*      */   }
/*      */   
/*      */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/* 3841 */     if (evt.getClickCount() == 2) {
/* 3842 */       cargarEmpleado();
/*      */     } else {
/* 3844 */       int ind = this.rSTableMetro6.getSelectedRow();
/* 3845 */       String nombre = String.valueOf(this.rSTableMetro6.getValueAt(ind, 0));
/* 3846 */       String ap = String.valueOf(this.rSTableMetro6.getValueAt(ind, 1));
/* 3847 */       this.materialButton34.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton34ActionPerformed(ActionEvent evt) {
/* 3856 */     cargarEmpleado();
/* 3857 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 3861 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 3865 */     this.utilitarios = new GuiasFormCat(this.jDialog2, true, "vales_diesel", this.jButton9);
/* 3866 */     if (this.utilitarios.seleccionado)
/* 3867 */       this.jTextField33.setText(this.utilitarios.utilitarios.getEco()); 
/*      */   }
/*      */   
/*      */   public void desactivarNocturno() {
/* 3871 */     this.jButton7.setEnabled(true);
/* 3872 */     this.jButton8.setEnabled(true);
/* 3873 */     this.jButton32.setEnabled(true);
/* 3874 */     this.jButton2.setEnabled(true);
/* 3875 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" },  }, (Object[])new String[] { "Guía", "Fecha/Concepto" })
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
/* 3891 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3896 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3899 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/* 3900 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 3901 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     
/* 3903 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 3904 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public void verVale() {
/* 3908 */     this.jTextPane1.setEditable(false);
/* 3909 */     this.jTextPane1.setText("");
/* 3910 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 3911 */     this.jLabel14.setText(String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/* 3912 */     this.jLabel19.setText(String.valueOf(this.rSTableMetro1.getValueAt(ind, 7)));
/* 3913 */     this.jLabel101.setText(String.valueOf(this.rSTableMetro1.getValueAt(ind, 8)));
/*      */     
/* 3915 */     String nombre = String.valueOf(this.rSTableMetro1.getValueAt(ind, 3));
/* 3916 */     System.out.println("nombre" + nombre + "o");
/* 3917 */     if (nombre.equals("  ")) {
/* 3918 */       nombre = String.valueOf(this.rSTableMetro1.getValueAt(ind, 4));
/*      */     }
/* 3920 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 3921 */     StyleConstants.setBold(attrs, true);
/*      */     try {
/* 3923 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Folio:  ", attrs);
/* 3924 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)) + "\n", null);
/* 3925 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Fecha:  ", attrs);
/* 3926 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 1)) + "\n", null);
/* 3927 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Ruta:  ", attrs);
/* 3928 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 2)) + "\n", null);
/* 3929 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Asignado a:  ", attrs);
/* 3930 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), nombre + "\n", null);
/* 3931 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Económico:  ", attrs);
/* 3932 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 5)) + "\n", null);
/* 3933 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Guías a comprobar:  ", attrs);
/* 3934 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 6)) + "\n", null);
/* 3935 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Documentó:  ", attrs);
/* 3936 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 7)) + "\n", null);
/* 3937 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Estatus:  ", attrs);
/* 3938 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), String.valueOf(this.rSTableMetro1.getValueAt(ind, 8)) + "\n", null);
/* 3939 */     } catch (BadLocationException ex) {
/* 3940 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3945 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3953 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3959 */         return 30;
/*      */       
/*      */       case 1:
/* 3962 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3964 */           return 29;
/*      */         }
/* 3966 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 3970 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void cargarGuia() {
/* 3975 */     String guia = String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 0));
/* 3976 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3977 */       if (guia.equals(this.rSTableMetro2.getValueAt(i, 0))) {
/* 3978 */         JOptionPane.showMessageDialog(this.jDialog8, "La guía que deseas insertar ya se encuentra registrada", "Guía ya Asignada", 0, this.ERROR);
/*      */         return;
/*      */       } 
/*      */     } 
/* 3982 */     String[] vales = this.con.regresaColIndex("folio", "vales_diesel_guias", "where num_guia = '" + guia + "'");
/* 3983 */     String val = ""; int j;
/* 3984 */     for (j = 0; j < vales.length; j++) {
/* 3985 */       val = val + val + " - ";
/*      */     }
/* 3987 */     if (vales.length >= 2) {
/* 3988 */       JOptionPane.showMessageDialog(this.jDialog8, "La guía que deseas insertar ya se encuentra registrada dos veces, los vales son los siguientes:\n<html><b>" + val + "<b></html>", "Guía Saldada", 0, this.ADVER);
/*      */     } else {
/* 3990 */       for (j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/* 3991 */         String valor = String.valueOf(this.rSTableMetro2.getValueAt(j, 0));
/* 3992 */         if (valor.equals("")) {
/* 3993 */           this.rSTableMetro2.setValueAt(guia, j, 0);
/* 3994 */           this.rSTableMetro2.setValueAt("Guía Extra", j, 1);
/* 3995 */           this.INDICE++;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3999 */       this.jDialog8.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void guardarRuta() {
/* 4004 */     this.error.pasarModal(true);
/* 4005 */     this.val.pasarModal(Boolean.valueOf(true));
/* 4006 */     String marca = this.jTextField18.getText().toUpperCase();
/* 4007 */     if (marca.equals("")) {
/* 4008 */       this.error.cargarError(this.jTextField18, "050");
/* 4009 */     } else if (!this.val.validarApostrofe(this.jTextField18, marca, "020")) {
/* 4010 */       this.encontrado = this.con.consultar("concepto", "vales_diesel_conceptos", "where concepto = '" + this.jTextField18.getText() + "'");
/* 4011 */       if (this.encontrado) {
/* 4012 */         JOptionPane.showMessageDialog(this.jDialog3, "No puedes crear la ruta porque ya existe en la base de datos", "Ruta Duplicada", 0, this.ERROR);
/*      */       } else {
/* 4014 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas crear un nueva ruta?", "Crear Ruta", 0, 1, this.PREG);
/* 4015 */         if (res == 0) {
/* 4016 */           this.con.insertar("insert into vales_diesel_conceptos(concepto)values('" + marca + "')");
/* 4017 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó una Nueva Ruta.','Ruta: " + this.jTextField18.getText() + "')");
/* 4018 */           llenarCombo();
/* 4019 */           consultar1();
/* 4020 */           this.jTextField18.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 4027 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4029 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField1, evt);
/* 4030 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4034 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField1, evt);
/* 4035 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4038 */     this.jTextField30.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4040 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField30, evt);
/* 4041 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4045 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField30, evt);
/* 4046 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4049 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4051 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField2, evt);
/* 4052 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4056 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField2, evt);
/* 4057 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4060 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4062 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField3, evt);
/* 4063 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4067 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField3, evt);
/* 4068 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4071 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4073 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField4, evt);
/* 4074 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4078 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField4, evt);
/* 4079 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4082 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4084 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextArea2, evt);
/* 4085 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4089 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextArea2, evt);
/* 4090 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4093 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4095 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField5, evt);
/* 4096 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4100 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField5, evt);
/* 4101 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4104 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4106 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField27, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4110 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 4113 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4115 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField28, evt);
/* 4116 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4120 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField28, evt);
/* 4121 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4124 */     this.jTextField25.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4126 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField25, evt);
/* 4127 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4131 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField25, evt);
/* 4132 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4135 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4137 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField26, evt);
/* 4138 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4142 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField26, evt);
/* 4143 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4146 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4148 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextArea1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4152 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 4155 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4157 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField6, evt);
/* 4158 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4162 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField6, evt);
/* 4163 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4166 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4168 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4172 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField18, evt);
/*      */           }
/*      */         });
/*      */     
/* 4176 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4178 */             valesDiesel.this.jTextGanado(valesDiesel.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4182 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 4185 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4187 */             valesDiesel.this.jTextGanado(valesDiesel.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4191 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/*      */     
/* 4195 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4197 */             valesDiesel.this.jTextGanado(valesDiesel.this.jComboBox1, evt);
/* 4198 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4202 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jComboBox1, evt);
/* 4203 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4206 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4208 */             valesDiesel.this.jTextGanado(valesDiesel.this.jComboBox2, evt);
/* 4209 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4213 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jComboBox2, evt);
/* 4214 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/*      */     
/* 4218 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4220 */             valesDiesel.this.jTextGanado(valesDiesel.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4224 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 4227 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4229 */             valesDiesel.this.jTextGanado(valesDiesel.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4233 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jComboBox4, evt);
/*      */           }
/*      */         });
/*      */     
/* 4237 */     this.jTextField33.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4239 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField33, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4243 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField33, evt);
/*      */           }
/*      */         });
/* 4246 */     this.jTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4248 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField22, evt);
/* 4249 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4253 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField22, evt);
/* 4254 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4257 */     this.jTextField24.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4259 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField24, evt);
/* 4260 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4264 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField24, evt);
/* 4265 */             valesDiesel.this.tieneTexto();
/*      */           }
/*      */         });
/* 4268 */     this.jTextField33.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4270 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField33, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4274 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField33, evt);
/*      */           }
/*      */         });
/* 4277 */     this.jTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4279 */             valesDiesel.this.jTextGanado(valesDiesel.this.jTextField19, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4283 */             valesDiesel.this.jTextPerdido(valesDiesel.this.jTextField19, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 4289 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 4293 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void jPintarTexto(JComponent campo) {
/* 4297 */     campo.setBackground(this.lc.PRIMARIO2);
/*      */   }
/*      */   
/*      */   public void tieneTexto() {
/* 4301 */     if (!this.jTextField1.getText().equals("") && !this.jTextField1.getText().equals(this.holderVale)) {
/* 4302 */       jPintarTexto(this.jTextField1);
/*      */     }
/* 4304 */     if (!this.jTextField2.getText().equals("") && !this.jTextField2.getText().equals(this.holderGuia)) {
/* 4305 */       jPintarTexto(this.jTextField2);
/*      */     }
/* 4307 */     if (!this.jTextField3.getText().equals("") && !this.jTextField3.getText().equals(this.holderOperador)) {
/* 4308 */       jPintarTexto(this.jTextField3);
/*      */     }
/* 4310 */     if (!this.jTextField4.getText().equals("") && !this.jTextField4.getText().equals(this.holderPaterno)) {
/* 4311 */       jPintarTexto(this.jTextField4);
/*      */     }
/* 4313 */     if (!this.jTextField5.getText().equals("") && !this.jTextField5.getText().equals(this.holderMaterno)) {
/* 4314 */       jPintarTexto(this.jTextField5);
/*      */     }
/* 4316 */     if (!this.jTextField6.getText().equals("") && !this.jTextField6.getText().equals(this.holderUnidad)) {
/* 4317 */       jPintarTexto(this.jTextField6);
/*      */     }
/* 4319 */     if (!this.jTextField22.getText().equals("")) {
/* 4320 */       jPintarTexto(this.jTextField22);
/*      */     }
/* 4322 */     if (!this.jTextField24.getText().equals("")) {
/* 4323 */       jPintarTexto(this.jTextField24);
/*      */     }
/* 4325 */     if (!this.jTextField25.getText().equals("")) {
/* 4326 */       jPintarTexto(this.jTextField25);
/*      */     }
/* 4328 */     if (!this.jTextField26.getText().equals("")) {
/* 4329 */       jPintarTexto(this.jTextField26);
/*      */     }
/* 4331 */     if (!this.jTextField28.getText().equals("")) {
/* 4332 */       jPintarTexto(this.jTextField28);
/*      */     }
/* 4334 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 4335 */       jPintarTexto(this.jComboBox1);
/*      */     }
/* 4337 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 4338 */       jPintarTexto(this.jComboBox2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void vales(String usu) {
/* 4343 */     this.jRadioButton1.setSelected(true);
/* 4344 */     this.USUARIO = usu;
/* 4345 */     extraerUsuario(usu);
/* 4346 */     this.fecha = new Date();
/*      */     
/* 4348 */     this.fechaActual = new Date();
/* 4349 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4350 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 4351 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4352 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 4353 */     cargarFechaHoy();
/* 4354 */     consultar();
/* 4355 */     this.jButton2.setEnabled(false);
/* 4356 */     this.panel.setViewportView(this);
/*      */     
/* 4358 */     this.con.Campo = this.CAMPOSGENERALES.get("priv");
/* 4359 */     if (this.con.Campo.equals("RECURSOS HUMANOS") || this.con.Campo.equals("CAPTURISTA") || this.con.Campo.equals("GERENTE DE OPERACIONES")) {
/* 4360 */       this.jButton4.setEnabled(false);
/* 4361 */       this.jButton5.setEnabled(false);
/* 4362 */       this.jButton11.setEnabled(false);
/* 4363 */       this.jButton35.setEnabled(false);
/* 4364 */       this.jButton36.setEnabled(false);
/* 4365 */     } else if (this.con.Campo.equals("LIQUIDACIONES")) {
/* 4366 */       this.jButton4.setEnabled(true);
/* 4367 */       this.jButton5.setEnabled(true);
/* 4368 */       this.jButton36.setEnabled(true);
/*      */     } else {
/* 4370 */       this.jButton35.setEnabled(true);
/* 4371 */       this.jButton4.setEnabled(true);
/* 4372 */       this.jButton5.setEnabled(true);
/* 4373 */       this.jButton11.setEnabled(true);
/* 4374 */       this.jButton36.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 4380 */     int otro = -1;
/* 4381 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4384 */       setEnabled((table == null || table.isEnabled()));
/* 4385 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4386 */       if (comparar(comp)) {
/* 4387 */         setBackground(Color.red);
/* 4388 */         setForeground(Color.white);
/* 4389 */       } else if (row % 2 == 0 && (column == 0 || column == 4)) {
/* 4390 */         setBackground(new Color(120, 200, 104));
/* 4391 */         setForeground(valesDiesel.this.lc.SECUNDARIO1);
/* 4392 */       } else if (row % 2 == 0 && column == 3) {
/* 4393 */         setBackground(new Color(136, 191, 173));
/* 4394 */         setForeground(valesDiesel.this.lc.SECUNDARIO1);
/* 4395 */       } else if (row % 2 == 0) {
/* 4396 */         setBackground(valesDiesel.this.lc.FONDOTABLA);
/* 4397 */         setForeground(valesDiesel.this.lc.SECUNDARIO1);
/*      */       } else {
/* 4399 */         setBackground((Color)null);
/* 4400 */         setForeground(valesDiesel.this.lc.SECUNDARIO1);
/*      */       } 
/* 4402 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4403 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4407 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4411 */       for (int i = 0; i < this.indices.length; i++) {
/* 4412 */         if (this.indices[i].equals(reg)) {
/* 4413 */           return true;
/*      */         }
/*      */       } 
/* 4416 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 4421 */     this.materialButton23.setEnabled(false);
/* 4422 */     String num_ope = this.jTextField22.getText();
/* 4423 */     this.rSTableMetro4.setModel(new DefaultTableModel((Object[][])this.con
/* 4424 */           .buscarDatos(4, "num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope<>0 and num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField24.getText() + "%' and actual = 0 order by nombre"), (Object[])new String[] { "Núm", "Nombre", "Apellido Paterno", "Apellido Materno" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4429 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4434 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4437 */     eliminarColumna(2, 1, "Apellido Paterno");
/* 4438 */     eliminarColumna(2, 1, "Apellido Materno");
/*      */     
/* 4440 */     this.rSTableMetro4.setShowVerticalLines(false);
/*      */     
/* 4442 */     this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4443 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 4445 */     this.rSTableMetro4.setSelectionMode(0);
/* 4446 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 4447 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4449 */     this.rSTableMetro4.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4450 */     this.rSTableMetro4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4451 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 4455 */     this.materialButton34.setEnabled(false);
/* 4456 */     String num_ope = this.jTextField25.getText();
/* 4457 */     this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/* 4458 */           .buscarDatos(4, "clave_emp,nombre,ap_pat,ap_mat", "empleados", "where clave_emp<>0 and clave_emp like '%" + num_ope + "%' and nombre like '%" + this.jTextField26.getText() + "%' and actual=0 order by nombre"), (Object[])new String[] { "Núm", "Nombre", "Apellido Paterno", "Apellido Materno" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4463 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4468 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4471 */     eliminarColumna2(2, 1, "Apellido Paterno");
/* 4472 */     eliminarColumna2(2, 1, "Apellido Materno");
/*      */     
/* 4474 */     this.rSTableMetro6.setShowVerticalLines(false);
/*      */     
/* 4476 */     this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4477 */     this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 4479 */     this.rSTableMetro6.setSelectionMode(0);
/* 4480 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 4481 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4483 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4484 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4485 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultar4() {
/* 4489 */     Calendar ca = Calendar.getInstance();
/* 4490 */     Calendar fecha = Calendar.getInstance();
/* 4491 */     int aa = fecha.get(1);
/* 4492 */     int mm = fecha.get(2);
/* 4493 */     int dd = fecha.get(5);
/* 4494 */     mm++;
/* 4495 */     if (mm == 1) {
/* 4496 */       mm = 11;
/* 4497 */       aa--;
/* 4498 */     } else if (mm == 2) {
/* 4499 */       mm = 12;
/* 4500 */       aa--;
/*      */     } else {
/* 4502 */       mm--;
/*      */     } 
/* 4504 */     this.materialButton28.setEnabled(false);
/* 4505 */     String guia = this.jTextField28.getText();
/* 4506 */     this.rSTableMetro5.setModel(new DefaultTableModel((Object[][])this.con
/* 4507 */           .buscarDatos(2, "guias.num_guia,operador", "guias", "where guias.num_guia like '%" + guia + "%' and fecha>'" + aa + "-" + mm + "-01'"), (Object[])new String[] { "Guía", "Nombre" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4512 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4517 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 4521 */     this.rSTableMetro5.setShowVerticalLines(false);
/*      */     
/* 4523 */     this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 4524 */     this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     
/* 4526 */     this.rSTableMetro5.setSelectionMode(0);
/* 4527 */     this.rSTableMetro5.setAutoCreateRowSorter(true);
/* 4528 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4530 */     CeldaRender2 celda = new CeldaRender2();
/* 4531 */     this.rSTableMetro5.getColumnModel().getColumn(0).setCellRenderer(celda);
/* 4532 */     this.rSTableMetro5.getColumnModel().getColumn(1).setCellRenderer(celda);
/* 4533 */     this.rSTableMetro5.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 4537 */     int cont = this.rSTableMetro4.getRowCount();
/* 4538 */     String[] registros = new String[cont]; int i;
/* 4539 */     for (i = 0; i < cont; i++) {
/* 4540 */       registros[i] = this.rSTableMetro4.getValueAt(i, destino).toString();
/*      */     }
/* 4542 */     for (i = 0; i < cont; i++) {
/* 4543 */       registros[i] = registros[i] + " " + registros[i];
/* 4544 */       this.rSTableMetro4.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4546 */     TableColumn columna = this.rSTableMetro4.getColumn(nombreCol);
/* 4547 */     this.rSTableMetro4.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void eliminarColumna2(int origen, int destino, String nombreCol) {
/* 4551 */     int cont = this.rSTableMetro6.getRowCount();
/* 4552 */     String[] registros = new String[cont]; int i;
/* 4553 */     for (i = 0; i < cont; i++) {
/* 4554 */       registros[i] = this.rSTableMetro6.getValueAt(i, destino).toString();
/*      */     }
/* 4556 */     for (i = 0; i < cont; i++) {
/* 4557 */       registros[i] = registros[i] + " " + registros[i];
/* 4558 */       this.rSTableMetro6.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4560 */     TableColumn columna = this.rSTableMetro6.getColumn(nombreCol);
/* 4561 */     this.rSTableMetro6.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void eliminarColumna3(int origen, int destino, String nombreCol) {
/* 4565 */     int cont = this.rSTableMetro1.getRowCount();
/* 4566 */     String[] registros = new String[cont]; int i;
/* 4567 */     for (i = 0; i < cont; i++) {
/* 4568 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 4570 */     for (i = 0; i < cont; i++) {
/* 4571 */       registros[i] = registros[i] + " " + registros[i];
/* 4572 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4574 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 4575 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void eliminarColumna4(int origen, int destino, String nombreCol) {
/* 4579 */     int cont = this.rSTableMetro5.getRowCount();
/* 4580 */     String[] registros = new String[cont]; int i;
/* 4581 */     for (i = 0; i < cont; i++) {
/* 4582 */       registros[i] = this.rSTableMetro5.getValueAt(i, destino).toString();
/*      */     }
/* 4584 */     for (i = 0; i < cont; i++) {
/* 4585 */       registros[i] = registros[i] + " " + registros[i];
/* 4586 */       this.rSTableMetro5.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4588 */     TableColumn columna = this.rSTableMetro5.getColumn(nombreCol);
/* 4589 */     this.rSTableMetro5.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void sacarFecha() {
/* 4593 */     String año = "";
/* 4594 */     String mes = "";
/* 4595 */     String dia = "";
/* 4596 */     Calendar ca = Calendar.getInstance();
/* 4597 */     Calendar fecha = Calendar.getInstance();
/* 4598 */     int aa = fecha.get(1);
/* 4599 */     int mm = fecha.get(2);
/* 4600 */     int dd = fecha.get(5);
/*      */     
/* 4602 */     System.out.println("mes " + mm);
/*      */     
/* 4604 */     int diasTotal = diasDelMes(mm, aa);
/* 4605 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4606 */     String strFecha = "";
/* 4607 */     if (diasTotal == dd) {
/* 4608 */       dd = 1;
/* 4609 */       if (mm == 11) {
/* 4610 */         aa++;
/* 4611 */         mm = 0;
/*      */       } else {
/* 4613 */         mm++;
/*      */       } 
/*      */     } else {
/* 4616 */       dd++;
/*      */     } 
/* 4618 */     mm++;
/* 4619 */     año = "" + aa;
/* 4620 */     mes = "" + mm;
/* 4621 */     dia = "" + dd;
/* 4622 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4623 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 4625 */       this.fechaTermino = formatoDelTexto.parse(strFecha);
/* 4626 */     } catch (ParseException ex) {
/* 4627 */       ex.printStackTrace();
/*      */     } 
/* 4629 */     this.fechaActual = new Date();
/* 4630 */     this.jDateChooser5.setDate(this.fechaTermino);
/* 4631 */     this.jDateChooser5.setMaxSelectableDate(this.fechaTermino);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 4635 */     this.jComboBox4.removeAllItems();
/* 4636 */     this.jComboBox3.removeAllItems();
/* 4637 */     String[] depa = this.con.regresaColIndex("concepto", "vales_diesel_conceptos", "where num_concep<>0 order by concepto");
/* 4638 */     this.jComboBox4.addItem("Selecciona uno...");
/* 4639 */     this.jComboBox3.addItem("Selecciona uno...");
/* 4640 */     for (int i = 0; i < depa.length; i++) {
/* 4641 */       this.jComboBox4.addItem(depa[i]);
/* 4642 */       this.jComboBox3.addItem(depa[i]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 4647 */     boolean correcto = true;
/* 4648 */     if (this.jDateChooser4.getDate() == null) {
/* 4649 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 4650 */       if (res == 0) {
/* 4651 */         this.jDateChooser4.setDate(this.fechaActual);
/* 4652 */         correcto = true;
/*      */       } else {
/* 4654 */         correcto = false;
/*      */       } 
/* 4656 */     } else if (this.jDateChooser5.getDate() == null) {
/* 4657 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 4658 */       if (res == 0) {
/* 4659 */         this.jDateChooser5.setDate(this.fechaActual);
/* 4660 */         correcto = true;
/*      */       } else {
/* 4662 */         correcto = false;
/*      */       } 
/* 4664 */     } else if (correcto) {
/* 4665 */       Date fecha1 = this.jDateChooser4.getDate();
/* 4666 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 4668 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4669 */       String cadenaFecha = "";
/* 4670 */       cadenaFecha = formato.format(fecha1);
/* 4671 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4672 */       String MES = cadenaFecha.substring(4, 6);
/* 4673 */       String DIA = cadenaFecha.substring(6, 8);
/* 4674 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 4676 */       cadenaFecha = formato.format(fecha2);
/* 4677 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 4678 */       cadenaFecha = "";
/* 4679 */       cadenaFecha = formato.format(fecha2);
/* 4680 */       AÑO = cadenaFecha.substring(0, 4);
/* 4681 */       MES = cadenaFecha.substring(4, 6);
/* 4682 */       DIA = cadenaFecha.substring(6, 8);
/* 4683 */       String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */       
/* 4685 */       this.jButton11.setEnabled(false);
/* 4686 */       this.jButton35.setEnabled(false);
/* 4687 */       String num_ope = this.jTextField22.getText();
/* 4688 */       String estado = "";
/* 4689 */       String operador = "";
/* 4690 */       String folio = "";
/* 4691 */       String guias = "";
/* 4692 */       String nombre = "";
/* 4693 */       String paterno = "";
/* 4694 */       String materno = "";
/* 4695 */       String eco = "";
/* 4696 */       String tipoV = " and clave_emp like '%%' ";
/*      */       
/* 4698 */       if (!this.jTextField1.getText().equals(this.holderVale)) {
/* 4699 */         folio = this.jTextField1.getText();
/*      */       }
/* 4701 */       if (!this.jTextField2.getText().equals(this.holderGuia)) {
/* 4702 */         guias = this.jTextField2.getText();
/*      */       }
/* 4704 */       if (!this.jTextField3.getText().equals(this.holderOperador)) {
/* 4705 */         operador = this.jTextField3.getText();
/*      */       }
/* 4707 */       if (!this.jTextField4.getText().equals(this.holderPaterno)) {
/* 4708 */         paterno = this.jTextField4.getText();
/*      */       }
/* 4710 */       if (!this.jTextField5.getText().equals(this.holderMaterno)) {
/* 4711 */         materno = this.jTextField5.getText();
/*      */       }
/* 4713 */       if (!this.jTextField6.getText().equals(this.holderUnidad)) {
/* 4714 */         eco = this.jTextField6.getText();
/*      */       }
/*      */       
/* 4717 */       if (this.jComboBox1.getSelectedIndex() != 2) {
/* 4718 */         estado = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 4720 */       if (this.jComboBox2.getSelectedIndex() == 2) {
/* 4721 */         tipoV = " and clave_emp !=0 ";
/* 4722 */       } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 4723 */         tipoV = " and clave_emp =0 ";
/*      */       } 
/* 4725 */       this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 4726 */             .buscarDatos(14, "folio,fecha,concepto,empleados.nombre,empleados.ap_pat,empleados.ap_mat,operadores.nombre,operadores.ap_pat,operadores.ap_mat,eco_letra,litros,guias,documento,vales_diesel.estado", "vales_diesel,empleados,vales_diesel_conceptos,operadores", "where operadores.num_ope = vales_diesel.num_ope and vales_diesel.num_concep = vales_diesel_conceptos.num_concep and vales_diesel.num_emp = empleados.clave_emp and estado like '%" + estado + "%' and folio like '%" + folio + "%' and guias like '%" + guias + "%' and ((operadores.nombre like '%" + operador + "%' and operadores.ap_pat like '%" + paterno + "%' and operadores.ap_mat like '%" + materno + "%') or (empleados.nombre like '%" + operador + "%'  and empleados.ap_pat like '%" + paterno + "%' and empleados.ap_mat like '%" + materno + "%')) and eco_letra like '%" + eco + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + tipoV + " and vales_diesel.num <> 0 order by vales_diesel.num desc"), (Object[])new String[] { "Folio", "Fecha", "Ruta", "Empleado", "Emp Paterno", "Emp Materno", "Operador", "Op Paterno", "Op Materno", "Eco", "Litros", "Guías A Comprobar / Concepto", "Documentó", "Estado" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 4734 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4739 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 4742 */       this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 4743 */       eliminarColumna3(4, 3, "Emp Paterno");
/* 4744 */       eliminarColumna3(4, 3, "Emp Materno");
/*      */       
/* 4746 */       eliminarColumna3(5, 4, "Op Paterno");
/* 4747 */       eliminarColumna3(5, 4, "Op Materno");
/*      */       
/* 4749 */       this.rSTableMetro1.setShowVerticalLines(false);
/*      */ 
/*      */       
/* 4752 */       this.rSTableMetro1.getColumnModel().getColumn(0).setMinWidth(80);
/* 4753 */       this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(80);
/* 4754 */       this.rSTableMetro1.getColumnModel().getColumn(1).setMinWidth(100);
/* 4755 */       this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(100);
/* 4756 */       this.rSTableMetro1.getColumnModel().getColumn(2).setMinWidth(150);
/* 4757 */       this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(150);
/* 4758 */       this.rSTableMetro1.getColumnModel().getColumn(3).setMinWidth(230);
/* 4759 */       this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(230);
/* 4760 */       this.rSTableMetro1.getColumnModel().getColumn(4).setMinWidth(230);
/* 4761 */       this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(230);
/* 4762 */       this.rSTableMetro1.getColumnModel().getColumn(5).setMinWidth(80);
/* 4763 */       this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(80);
/* 4764 */       this.rSTableMetro1.getColumnModel().getColumn(6).setMinWidth(550);
/* 4765 */       this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(550);
/* 4766 */       this.rSTableMetro1.getColumnModel().getColumn(7).setMinWidth(210);
/* 4767 */       this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(210);
/*      */       
/* 4769 */       this.rSTableMetro1.setSelectionMode(0);
/* 4770 */       this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 4771 */       this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 4773 */       if (this.jComboBox1.getSelectedIndex() == 2) {
/* 4774 */         this.celda.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "ACTIVO", 0, 8, 1));
/*      */       } else {
/*      */         
/* 4777 */         String[] arre = new String[0];
/* 4778 */         this.celda.pasarInd(arre);
/*      */       } 
/* 4780 */       this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 4781 */       this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4782 */       this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 4783 */       this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 4784 */       this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 4785 */       this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 4786 */       this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 4787 */       this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 4788 */       this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 4789 */       this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar1() {
/* 4794 */     this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con
/* 4795 */           .buscarDatos(2, "num_concep,concepto", "vales_diesel_conceptos", "where num_concep<>0 order by concepto"), (Object[])new String[] { "Num", "Conceptos", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4800 */           Class[] types = new Class[] { Object.class, Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4805 */             return this.types[columnIndex];
/*      */           }
/* 4807 */           boolean[] canEdit = new boolean[] { false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4812 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4815 */     this.rSTableMetro3.setShowVerticalLines(false);
/*      */     
/* 4817 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4818 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 4819 */     this.rSTableMetro3.getColumnModel().getColumn(2).setPreferredWidth(30);
/* 4820 */     this.rSTableMetro3.getColumnModel().getColumn(2).setMaxWidth(30);
/* 4821 */     this.rSTableMetro3.setSelectionMode(0);
/* 4822 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 4823 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 4824 */     this.rSTableMetro3.getColumnModel().moveColumn(2, 0);
/*      */     
/* 4826 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4827 */     this.rSTableMetro3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4828 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 4832 */     this.con.consultar("max(num)", "VALES_DIESEL", "");
/* 4833 */     String mayor = this.con.Campo;
/* 4834 */     int MAYOR = Integer.parseInt(mayor);
/* 4835 */     MAYOR++;
/* 4836 */     if (MAYOR < 10) {
/* 4837 */       this.jTextField61.setText(this.DIRECTIVA + "-0000" + this.DIRECTIVA);
/* 4838 */       this.jTextField62.setText(this.DIRECTIVA + "-0000" + this.DIRECTIVA);
/* 4839 */     } else if (MAYOR < 100) {
/* 4840 */       this.jTextField61.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/* 4841 */       this.jTextField62.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/* 4842 */     } else if (MAYOR < 1000) {
/* 4843 */       this.jTextField61.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/* 4844 */       this.jTextField62.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/* 4845 */     } else if (MAYOR < 10000) {
/* 4846 */       this.jTextField61.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/* 4847 */       this.jTextField62.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/* 4849 */       this.jTextField61.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/* 4850 */       this.jTextField62.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarFechaHoy() {
/* 4855 */     Calendar ahoraCal = Calendar.getInstance();
/* 4856 */     ahoraCal.setTime(this.fecha);
/* 4857 */     String mesesito = "";
/* 4858 */     String hoy = "";
/* 4859 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 4860 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 4862 */     if (ahoraCal.get(2) + 1 < 10) {
/* 4863 */       mesesito = "0" + mesesito;
/*      */     }
/* 4865 */     if (ahoraCal.get(5) < 10) {
/* 4866 */       hoy = "0" + hoy;
/*      */     }
/* 4868 */     this.jTextField71.setText(hoy + "/" + hoy + "/" + mesesito);
/* 4869 */     this.jTextField72.setText(hoy + "/" + hoy + "/" + mesesito);
/*      */   }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices;
/*      */     
/*      */     CeldaRender2() {
/* 4874 */       this.otro = -1;
/* 4875 */       this.indices = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4878 */       setEnabled((table == null || table.isEnabled()));
/* 4879 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4880 */       if (comparar(comp)) {
/* 4881 */         setBackground(Color.red);
/* 4882 */         setForeground(Color.white);
/* 4883 */       } else if (row % 2 == 0) {
/* 4884 */         setBackground(valesDiesel.this.lc.FONDOTABLA);
/*      */       } else {
/* 4886 */         setBackground((Color)null);
/*      */       } 
/* 4888 */       setForeground(valesDiesel.this.lc.SECUNDARIO1);
/* 4889 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4890 */       return this;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4894 */       for (int i = 0; i < this.indices.length; i++) {
/* 4895 */         if (this.indices[i].equals(reg)) {
/* 4896 */           return true;
/*      */         }
/*      */       } 
/* 4899 */       return false;
/*      */     } }
/*      */   class CeldaRender3 extends DefaultTableCellRenderer { int otro;
/*      */     String[] indices;
/*      */     
/*      */     CeldaRender3() {
/* 4905 */       this.otro = -1;
/* 4906 */       this.indices = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4909 */       setEnabled((table == null || table.isEnabled()));
/* 4910 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4911 */       if (comparar(comp)) {
/* 4912 */         setBackground(Color.red);
/* 4913 */         setForeground(Color.white);
/* 4914 */       } else if (row % 2 == 0) {
/* 4915 */         setBackground(valesDiesel.this.lc.FONDOTABLA);
/* 4916 */         setForeground(valesDiesel.this.lc.SECUNDARIO1);
/*      */       } else {
/* 4918 */         setBackground((Color)null);
/*      */         
/* 4920 */         setForeground(valesDiesel.this.lc.SECUNDARIO1);
/*      */       } 
/* 4922 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4923 */       return this;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4927 */       for (int i = 0; i < this.indices.length; i++) {
/* 4928 */         if (this.indices[i].equals(reg)) {
/* 4929 */           return true;
/*      */         }
/*      */       } 
/* 4932 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public void cargarEmpleado() {
/* 4937 */     int indice = this.rSTableMetro6.getSelectedRow();
/* 4938 */     this.jTextField23.setText(String.valueOf(this.rSTableMetro6.getValueAt(indice, 1)));
/* 4939 */     this.CLAVEOP = String.valueOf(this.rSTableMetro6.getValueAt(indice, 0));
/* 4940 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   public void cargarOperador() {
/* 4944 */     System.out.println("ENtraaaa--Z");
/* 4945 */     this.INDICE = 0;
/*      */     
/* 4947 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" },  }, (Object[])new String[] { "Guía", "Fecha/Concepto" })
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
/* 4963 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4968 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4971 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/* 4972 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 4973 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     
/* 4975 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 4976 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 4977 */     String año = "2010";
/* 4978 */     String mes = "03";
/* 4979 */     String dia = "12";
/* 4980 */     String completa = "'" + año + "-" + mes + "-" + dia + "'";
/* 4981 */     String clave = String.valueOf(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0));
/* 4982 */     this.CLAVEOP = clave;
/* 4983 */     this.operadores = this.con.regresaReg("num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope =" + clave, 4);
/* 4984 */     this.jTextField20.setText(this.operadores[1] + " " + this.operadores[1] + " " + this.operadores[2]);
/* 4985 */     this.jTextField23.setText(this.operadores[1] + " " + this.operadores[1] + " " + this.operadores[2]);
/*      */ 
/*      */     
/* 4988 */     String[][] datos = this.con.buscarDatos(3, "guias.num_guia, guias.fecha, llamadas_historicas.num_tracto", "guias,llamadas_historicas", "where llamadas_historicas.num_llama = guias.num_llama and  num_ope = " + this.CLAVEOP + " and fecha>" + completa + " and diesel='' and guias.estado = 'ACTIVA' order by guias.fecha asc");
/* 4989 */     int tot = datos.length;
/* 4990 */     if (tot > 0) {
/* 4991 */       for (int i = 0; i < tot; i++) {
/* 4992 */         if (!datos[i][0].equals("")) {
/* 4993 */           System.out.println("Dat " + String.valueOf(datos[0]) + " " + i);
/* 4994 */           this.rSTableMetro2.setValueAt(datos[i][0], i, 0);
/* 4995 */           this.rSTableMetro2.setValueAt(datos[i][1], i, 1);
/* 4996 */           this.INDICE++;
/*      */         } 
/* 4998 */         if (i == 9) {
/*      */           break;
/*      */         }
/*      */       } 
/* 5002 */       this.con.Campo = datos[0][2];
/* 5003 */       this.UNIDADESRAGAR.stream().filter(eco -> eco.equals(this.con.Campo)).forEach(eco -> {
/*      */             this.jLabel12.setText("ECO: " + this.con.Campo);
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             JOptionPane.showMessageDialog(this.jDialog4, this.jPanel5, "Recordatorio amistoso", 0, this.ADVER);
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             this.rSTableMetro2.setValueAt("RAGAR", datos.length, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             this.rSTableMetro2.setValueAt("Viajes de Ragar", datos.length, 1);
/*      */           });
/*      */ 
/*      */ 
/*      */       
/* 5024 */       this.jTextField17.setText(this.con.Campo);
/* 5025 */       this.jDialog4.setVisible(false);
/*      */     } else {
/* 5027 */       this.con.consultar("num_tracto", "llamadas_historicas", "where num_ope = " + this.CLAVEOP + " order by num_llama desc");
/* 5028 */       this.jTextField17.setText(this.con.Campo);
/* 5029 */       this.jDialog4.setVisible(false);
/* 5030 */       this.CONCEPTO = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void extraerUsuario(String nombre) {
/* 5035 */     this.USUARIO = nombre;
/* 5036 */     String[] NomComp = { this.CAMPOSGENERALES.get("empleados.nombre"), this.CAMPOSGENERALES.get("empleados.ap_pat"), this.CAMPOSGENERALES.get("empleados.ap_mat") };
/* 5037 */     this.NOMBRE = NomComp[0] + " " + NomComp[0] + " " + NomComp[1];
/* 5038 */     this.jTextField34.setText(this.NOMBRE);
/* 5039 */     this.jTextField21.setText(this.NOMBRE);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 5043 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" }, , { "", "" },  }, (Object[])new String[] { "Guía", "Fecha/Concepto" })
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
/* 5059 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5064 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5067 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/* 5068 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 5069 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*      */     
/* 5071 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 5072 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*      */     
/* 5074 */     this.jComboBox3.setSelectedIndex(0);
/* 5075 */     this.jComboBox4.setSelectedIndex(0);
/* 5076 */     this.CLAVEOP = "";
/* 5077 */     this.jTextField20.setText("");
/* 5078 */     this.jTextField17.setText("");
/* 5079 */     this.jTextField23.setText("");
/* 5080 */     this.jTextField33.setText("");
/* 5081 */     this.jTextArea1.setText("");
/* 5082 */     this.CONCEPTO = false;
/* 5083 */     this.INDICE = 0;
/* 5084 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 5085 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*      */   }
/*      */ 
/*      */   
/*      */   public void cancelar() {
/* 5090 */     String motivo = this.jTextField19.getText();
/* 5091 */     if (motivo.equals("")) {
/* 5092 */       this.error.cargarError(this.jTextField19, "050");
/* 5093 */     } else if (!this.val.validarApostrofe(this.jTextField19, motivo, "020")) {
/* 5094 */       int res = JOptionPane.showConfirmDialog(this.jDialog6, "¿Estás seguro que deseas cancelar el vale?", "Cancelar Vales", 0, 3, this.PREG);
/* 5095 */       if (res == 0) {
/* 5096 */         this.con.inserSinMsj("update vales_diesel set estado = 'CANCELADO/" + this.jTextField19.getText().toUpperCase() + "' where folio = '" + this.CLAVE + "'");
/* 5097 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Canceló el Vale','Se ha cancelado el vale: " + this.CLAVE + "')");
/* 5098 */         consultar();
/* 5099 */         this.jDialog6.setVisible(false);
/* 5100 */         this.jTextField19.setText("");
/* 5101 */         JOptionPane.showMessageDialog(this.padre, "El vale ha sido cancelado satisfactoriamente", "Vale Cancelado", 0, this.INFO);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   class ImprimirValeD implements Printable { String[] DATOS;
/*      */     int opc;
/*      */     
/* 5109 */     ImprimirValeD() { this.DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 5110 */       this.opc = 0; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; Calendar calendario; int hora, minutos, segundos; String hh, mm, ss;
/*      */       int x;
/*      */       String cad1, cad2;
/* 5113 */       Graphics2D g2 = (Graphics2D)g;
/* 5114 */       switch (pageIndex) {
/*      */         case 0:
/* 5116 */           if (this.opc == 0) {
/* 5117 */             g.setColor(Color.black);
/* 5118 */             g2 = (Graphics2D)g;
/* 5119 */             Font font = new Font("ARIAL", 0, 10);
/* 5120 */             g.setFont(font);
/* 5121 */             g.drawString(this.DATOS[0], 55, 113);
/* 5122 */             font = new Font("ARIAL", 0, 9);
/* 5123 */             g.setFont(font);
/* 5124 */             g.drawString(this.DATOS[1], 123, 109);
/* 5125 */             Calendar calendar = new GregorianCalendar();
/* 5126 */             int i = calendar.get(11);
/* 5127 */             int j = calendar.get(12);
/* 5128 */             int k = calendar.get(13);
/* 5129 */             String str1 = "" + i;
/* 5130 */             String str2 = "" + j;
/* 5131 */             String str3 = "" + k;
/* 5132 */             if (i < 10) {
/* 5133 */               str1 = "0" + i;
/*      */             }
/* 5135 */             if (j < 10) {
/* 5136 */               str2 = "0" + j;
/*      */             }
/* 5138 */             if (k < 10) {
/* 5139 */               str3 = "0" + k;
/*      */             }
/* 5141 */             g.drawString(str1 + ":" + str1 + ":" + str2, 123, 120);
/* 5142 */             font = new Font("ARIAL", 0, 9);
/* 5143 */             g.setFont(font);
/* 5144 */             g.drawString(this.DATOS[2], 189, 113);
/* 5145 */             int m = 54;
/* 5146 */             String str4 = "";
/* 5147 */             String str5 = "";
/* 5148 */             if (this.DATOS[6].length() > 45) {
/* 5149 */               str4 = this.DATOS[6].substring(0, 45);
/* 5150 */               str5 = this.DATOS[6].substring(45, this.DATOS[6].length());
/* 5151 */               g.drawString(str4, 54, 150);
/* 5152 */               g.drawString(str5, 54, 169);
/*      */             } else {
/* 5154 */               str4 = this.DATOS[6];
/* 5155 */               g.drawString(str4, 54, 150);
/*      */             } 
/* 5157 */             g.drawString(this.DATOS[3], 60, 212);
/* 5158 */             font = new Font("ARIAL", 0, 11);
/* 5159 */             g.setFont(font);
/* 5160 */             g.drawString(this.DATOS[4], 270, 212);
/* 5161 */             font = new Font("ARIAL", 0, 12);
/* 5162 */             g.setFont(font);
/* 5163 */             g.drawString(this.DATOS[7], 55, 255);
/* 5164 */             font = new Font("ARIAL", 0, 9);
/* 5165 */             g.setFont(font);
/* 5166 */             g.drawString(this.DATOS[5], 80, 305);
/* 5167 */             return 0;
/*      */           } 
/* 5169 */           g.setColor(Color.black);
/* 5170 */           g2 = (Graphics2D)g;
/* 5171 */           fuente = new Font("ARIAL", 0, 10);
/* 5172 */           g.setFont(fuente);
/* 5173 */           g.drawString(this.DATOS[0], 55, 113);
/* 5174 */           fuente = new Font("ARIAL", 0, 9);
/* 5175 */           g.setFont(fuente);
/* 5176 */           g.drawString(this.DATOS[1], 123, 109);
/* 5177 */           calendario = new GregorianCalendar();
/* 5178 */           hora = calendario.get(11);
/* 5179 */           minutos = calendario.get(12);
/* 5180 */           segundos = calendario.get(13);
/* 5181 */           hh = "" + hora;
/* 5182 */           mm = "" + minutos;
/* 5183 */           ss = "" + segundos;
/* 5184 */           if (hora < 10) {
/* 5185 */             hh = "0" + hora;
/*      */           }
/* 5187 */           if (minutos < 10) {
/* 5188 */             mm = "0" + minutos;
/*      */           }
/* 5190 */           if (segundos < 10) {
/* 5191 */             ss = "0" + segundos;
/*      */           }
/* 5193 */           g.drawString(hh + ":" + hh + ":" + mm, 123, 118);
/* 5194 */           fuente = new Font("ARIAL", 0, 9);
/* 5195 */           g.setFont(fuente);
/* 5196 */           g.drawString(this.DATOS[2], 189, 115);
/*      */ 
/*      */           
/* 5199 */           x = 54;
/* 5200 */           cad1 = "";
/* 5201 */           cad2 = "";
/* 5202 */           if (this.DATOS[3].length() > 45) {
/* 5203 */             cad1 = this.DATOS[3].substring(0, 43);
/* 5204 */             cad2 = this.DATOS[3].substring(45, this.DATOS[3].length());
/* 5205 */             g.drawString(cad1 + "-", 54, 150);
/* 5206 */             g.drawString(cad2, 54, 169);
/*      */           } else {
/* 5208 */             cad1 = this.DATOS[3];
/* 5209 */             g.drawString(cad1, 54, 150);
/*      */           } 
/* 5211 */           fuente = new Font("ARIAL", 0, 11);
/* 5212 */           g.setFont(fuente);
/* 5213 */           g.drawString(this.DATOS[4], 60, 212);
/* 5214 */           g.drawString(this.DATOS[5], 270, 212);
/* 5215 */           fuente = new Font("ARIAL", 0, 12);
/* 5216 */           g.setFont(fuente);
/* 5217 */           g.drawString(this.DATOS[7], 55, 255);
/* 5218 */           fuente = new Font("ARIAL", 0, 9);
/* 5219 */           g.setFont(fuente);
/* 5220 */           g.drawString(this.DATOS[6], 80, 305);
/* 5221 */           return 0;
/*      */       } 
/*      */       
/* 5224 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos(String[] datos, int opcion) {
/* 5229 */       ImprimirValeD im = new ImprimirValeD();
/* 5230 */       im.DATOS = datos;
/* 5231 */       im.opc = opcion;
/* 5232 */       System.out.println("Datos de vale");
/* 5233 */       for (int i = 0; i < this.DATOS.length; i++) {
/* 5234 */         System.out.println("" + i + " - " + i);
/*      */       }
/* 5236 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5237 */       job.setPrintable(im);
/* 5238 */       job.setJobName("Vale de Diesel " + im.DATOS[0]);
/* 5239 */       if (job.printDialog())
/*      */         try {
/* 5241 */           job.print();
/* 5242 */         } catch (PrinterException e) {
/* 5243 */           System.out.println(e);
/*      */         }  
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 5252 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 5255 */       this.t = new Thread(this);
/* 5256 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5264 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5265 */         detener();
/* 5266 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 5271 */       valesDiesel.this.consultar();
/* 5272 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 5276 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado2
/*      */     implements Runnable {
/*      */     Thread t;
/* 5283 */     int cont = 0;
/*      */     
/*      */     public Presionado2() {
/* 5286 */       this.t = new Thread(this);
/* 5287 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5295 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5296 */         detener();
/* 5297 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 5302 */       valesDiesel.this.consultar4();
/* 5303 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 5307 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado3
/*      */     implements Runnable {
/*      */     Thread t;
/* 5314 */     int cont = 0;
/*      */     
/*      */     public Presionado3() {
/* 5317 */       this.t = new Thread(this);
/* 5318 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5326 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5327 */         detener();
/* 5328 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 5333 */       valesDiesel.this.consultar3();
/* 5334 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 5338 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/valesDiesel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */