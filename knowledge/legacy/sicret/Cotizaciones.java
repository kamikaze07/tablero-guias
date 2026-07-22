/*      */ package sicret;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.event.CaretEvent;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ 
/*      */ public class Cotizaciones extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   44 */   Date fechaActual = new Date();
/*   45 */   Date fechaInicio = null;
/*   46 */   Date fecha = new Date();
/*   47 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   48 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   49 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   50 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   51 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   52 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   53 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   54 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   55 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   56 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   57 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   58 */   JFrame padre = null;
/*   59 */   JTabbedPane fichas = null;
/*   60 */   String[] CLAVES = null;
/*   61 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   boolean entraTermino = false;
/*   64 */   DefaultTableModel modelo = new DefaultTableModel();
/*   65 */   CeldaRender celda = new CeldaRender();
/*   66 */   CeldaRender2 celda2 = new CeldaRender2();
/*   67 */   MensajePop mensajeTry = null;
/*   68 */   Cursor micursor2 = null;
/*   69 */   String[] CONFIG = new String[2];
/*      */   EscribirReporte esc;
/*   71 */   ArrayList TODOS_CLIENTES = new ArrayList();
/*   72 */   ArrayList TODOS_DOMICILIOS = new ArrayList();
/*   73 */   ArrayList TODOS_CIUDAD = new ArrayList();
/*   74 */   ArrayList TODOS_CONTACTOS = new ArrayList();
/*   75 */   ArrayList COT_TERMINOS = new ArrayList();
/*   76 */   ArrayList TODOS_PERSONAS = new ArrayList();
/*   77 */   ArrayList TODOS_PUESTOS = new ArrayList();
/*   78 */   ArrayList TODOS_MEDIDAS = new ArrayList();
/*   79 */   TextAutoCompleter com_Clientes = null;
/*   80 */   TextAutoCompleter com_Domicilios = null;
/*   81 */   TextAutoCompleter com_Ciudad = null;
/*   82 */   TextAutoCompleter com_Contactos = null;
/*   83 */   TextAutoCompleter com_Personas = null;
/*   84 */   TextAutoCompleter com_Puestos = null;
/*   85 */   TextAutoCompleter com_Medidas = null;
/*      */   Clientes[] clientes;
/*      */   Personas[] personas;
/*   88 */   String MOTIVO = "";
/*      */   NumerosALetras numLetra;
/*   90 */   SColores lc = new SColores();
/*   91 */   PlaceHolder placeHolder = null;
/*   92 */   String holderFolio = "FOLIO";
/*   93 */   String holderCliente = "CLIENTE";
/*   94 */   String holderContacto = "CONTACTO";
/*   95 */   String holderConceptos = "CONCEPTOS"; Map<String, String> CAMPOSGENERALES; boolean PRIMERA = false; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton19; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox7; private JComboBox jComboBox8; private JDateChooser jDateChooser2; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JLabel jLabel10; private JLabel jLabel101; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel170; private JLabel jLabel171; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel55; private JLabel jLabel6; private JLabel jLabel7; private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private JPanel jPanel1;
/*      */   
/*      */   public Cotizaciones(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES) {
/*  100 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  101 */     this.mensajeTry = mensajeTry;
/*  102 */     String año = "2009";
/*  103 */     String mes = "10";
/*  104 */     String dia = "10";
/*  105 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  106 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  108 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  109 */     } catch (ParseException ex) {
/*  110 */       ex.printStackTrace();
/*      */     } 
/*  112 */     this.padre = padre;
/*  113 */     fichas = fichas;
/*      */     
/*  115 */     initComponents();
/*      */     
/*  117 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderFolio, false, "Cantarell", 11);
/*  118 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderCliente, false, "Cantarell", 11);
/*  119 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderContacto, false, "Cantarell", 11);
/*  120 */     this.placeHolder = new PlaceHolder(this.jTextField5, new Color(189, 189, 189), Color.BLACK, this.holderConceptos, false, "Cantarell", 11);
/*      */     
/*  122 */     this.USUARIO = USUARIO;
/*  123 */     panelito.setViewportView(this);
/*  124 */     this.panel = panelito;
/*  125 */     colorear();
/*      */     
/*  127 */     int w = this.tama.width;
/*  128 */     int h = this.tama.height;
/*      */     
/*  130 */     int rw = (w - 750) / 2;
/*  131 */     int rh = (h - this.tama.height + 10) / 2;
/*  132 */     this.jDialog1.setLocation(rw, rh);
/*  133 */     this.jDialog1.setSize(750, this.tama.height - 50);
/*  134 */     this.jDialog1.setResizable(false);
/*      */     
/*  136 */     rw = (w - 750) / 2;
/*  137 */     rh = (h - 130) / 2;
/*  138 */     this.jDialog2.setLocation(rw, rh);
/*  139 */     this.jDialog2.setSize(750, 130);
/*  140 */     this.jDialog2.setResizable(false);
/*      */     
/*  142 */     rw = (w - 750) / 2;
/*  143 */     rh = (h - 550) / 2;
/*  144 */     this.jDialog3.setLocation(rw, rh);
/*  145 */     this.jDialog3.setSize(750, 550);
/*  146 */     this.jDialog3.setResizable(false);
/*      */     
/*  148 */     rw = (w - 475) / 2;
/*  149 */     rh = (h - 130) / 2;
/*  150 */     this.jDialog4.setLocation(rw, rh);
/*  151 */     this.jDialog4.setSize(475, 130);
/*  152 */     this.jDialog4.setResizable(false);
/*      */     
/*  154 */     rw = (w - 390) / 2;
/*  155 */     rh = (h - 230) / 2;
/*  156 */     this.jDialog5.setLocation(rw, rh);
/*  157 */     this.jDialog5.setSize(390, 230);
/*  158 */     this.jDialog5.setVisible(false);
/*  159 */     this.jDialog5.setResizable(false);
/*      */     
/*  161 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  162 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  163 */     this.jLabel170.setCursor(micursor);
/*  164 */     this.jLabel101.setCursor(micursor);
/*  165 */     this.jLabel171.setCursor(micursor);
/*  166 */     this.jLabel31.setCursor(micursor);
/*      */     
/*  168 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  169 */     this.micursor2 = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  170 */     this.jDialog1.setCursor(this.micursor2);
/*  171 */     this.jDialog2.setCursor(this.micursor2);
/*  172 */     this.jDialog3.setCursor(this.micursor2);
/*  173 */     this.jDialog4.setCursor(this.micursor2);
/*  174 */     this.jDialog5.setCursor(this.micursor2);
/*  175 */     this.rSTableMetro1.setCursor(this.micursor2);
/*      */     
/*  177 */     this.CONFIG = new String[] { CAMPOSGENERALES.get("directiva").toString(), CAMPOSGENERALES.get("sucursal").toString() };
/*  178 */     this.jTextField8.setText(iniciales(USUARIO));
/*      */     
/*  180 */     cargarClientes();
/*  181 */     cargarPersonas();
/*      */     
/*  183 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance(Locale.US);
/*  184 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  185 */     editFormat.setGroupingUsed(false);
/*  186 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  187 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  188 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  189 */     enFormat.setAllowsInvalid(true);
/*  190 */     this.cantidad.setFormatterFactory(currFactory);
/*  191 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  192 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  193 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  194 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  195 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  196 */     this.cantidad.setValue(Integer.valueOf(0));
/*  197 */     llenarDocumento();
/*  198 */     llenarMedida();
/*  199 */     contar();
/*  200 */     consultar();
/*      */   }
/*      */   private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45;
/*      */   private JPanel jPanel46;
/*      */   
/*      */   private void initComponents() {
/*  206 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  207 */     this.jScrollPane4 = new JScrollPane();
/*  208 */     this.jPanel4 = new JPanel();
/*  209 */     this.jPanel3 = new JPanel();
/*  210 */     this.jLabel2 = new JLabel();
/*  211 */     this.jLabel3 = new JLabel();
/*  212 */     this.jLabel8 = new JLabel();
/*  213 */     this.jLabel9 = new JLabel();
/*  214 */     this.jLabel10 = new JLabel();
/*  215 */     this.jPanel6 = new JPanel();
/*  216 */     this.jLabel11 = new JLabel();
/*  217 */     this.jTextField2 = new JTextField();
/*  218 */     this.jLabel12 = new JLabel();
/*  219 */     this.jTextField6 = new JTextField();
/*  220 */     this.jLabel13 = new JLabel();
/*  221 */     this.jDateChooser2 = new JDateChooser();
/*  222 */     this.jLabel14 = new JLabel();
/*  223 */     this.jTextField8 = new JTextField();
/*  224 */     this.jPanel7 = new JPanel();
/*  225 */     this.jLabel19 = new JLabel();
/*  226 */     this.jLabel20 = new JLabel();
/*  227 */     this.jLabel21 = new JLabel();
/*  228 */     this.jLabel22 = new JLabel();
/*  229 */     this.jTextField7 = new JTextField();
/*  230 */     this.jTextField9 = new JTextField();
/*  231 */     this.jTextField10 = new JTextField();
/*  232 */     this.jTextField11 = new JTextField();
/*  233 */     this.jPanel8 = new JPanel();
/*  234 */     this.jScrollPane1 = new JScrollPane();
/*  235 */     this.jTable1 = new JTable();
/*  236 */     this.jButton5 = new JButton();
/*  237 */     this.jButton6 = new JButton();
/*  238 */     this.jButton7 = new JButton();
/*  239 */     this.jLabel28 = new JLabel();
/*  240 */     this.jPanel9 = new JPanel();
/*  241 */     this.jScrollPane2 = new JScrollPane();
/*  242 */     this.jTable2 = new JTable();
/*  243 */     this.jButton9 = new JButton();
/*  244 */     this.jLabel32 = new JLabel();
/*  245 */     this.jPanel10 = new JPanel();
/*  246 */     this.jPanel11 = new JPanel();
/*  247 */     this.jPanel12 = new JPanel();
/*  248 */     this.jLabel23 = new JLabel();
/*  249 */     this.jTextField13 = new JTextField();
/*  250 */     this.jTextField15 = new JTextField();
/*  251 */     this.jLabel24 = new JLabel();
/*  252 */     this.jPanel13 = new JPanel();
/*  253 */     this.jPanel32 = new JPanel();
/*  254 */     this.jPanel33 = new JPanel();
/*  255 */     this.materialButton21 = new MaterialButton();
/*  256 */     this.jPanel34 = new JPanel();
/*  257 */     this.materialButton20 = new MaterialButton();
/*  258 */     this.materialButton19 = new MaterialButton();
/*  259 */     this.jPanel35 = new JPanel();
/*  260 */     this.jLabel31 = new JLabel();
/*  261 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  262 */     this.jPanel14 = new JPanel();
/*  263 */     this.jPanel15 = new JPanel();
/*  264 */     this.jPanel16 = new JPanel();
/*  265 */     this.jPanel19 = new JPanel();
/*  266 */     this.jLabel5 = new JLabel();
/*  267 */     this.jLabel7 = new JLabel();
/*  268 */     this.jPanel20 = new JPanel();
/*  269 */     this.jLabel27 = new JLabel();
/*  270 */     this.jPanel21 = new JPanel();
/*  271 */     this.jLabel25 = new JLabel();
/*  272 */     this.jLabel26 = new JLabel();
/*  273 */     this.jPanel22 = new JPanel();
/*  274 */     this.jPanel23 = new JPanel();
/*  275 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  276 */     this.jTextField12 = new JTextField();
/*  277 */     this.jPanel24 = new JPanel();
/*  278 */     this.jTextField14 = new JTextField();
/*  279 */     this.jPanel25 = new JPanel();
/*  280 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  281 */     this.jPanel30 = new JPanel();
/*  282 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  283 */     this.jPanel18 = new JPanel();
/*  284 */     this.jPanel26 = new JPanel();
/*  285 */     this.jPanel27 = new JPanel();
/*  286 */     this.jPanel28 = new JPanel();
/*  287 */     this.jPanel29 = new JPanel();
/*  288 */     this.jButton4 = new JButton();
/*  289 */     this.jButton3 = new JButton();
/*  290 */     this.cantidad = new JFormattedTextField();
/*  291 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  292 */     this.jPanel36 = new JPanel();
/*  293 */     this.jScrollPane5 = new JScrollPane();
/*  294 */     this.jTable4 = new JTable();
/*  295 */     this.jButton10 = new JButton();
/*  296 */     this.jButton8 = new JButton();
/*  297 */     this.jButton12 = new JButton();
/*  298 */     this.jButton15 = new JButton();
/*  299 */     this.jLabel30 = new JLabel();
/*  300 */     this.jTextField17 = new JTextField();
/*  301 */     this.jButton17 = new JButton();
/*  302 */     this.jButton19 = new JButton();
/*  303 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  304 */     this.jPanel31 = new JPanel();
/*  305 */     this.jLabel29 = new JLabel();
/*  306 */     this.jTextField16 = new JTextField();
/*  307 */     this.jButton11 = new JButton();
/*  308 */     this.jButton16 = new JButton();
/*  309 */     this.jScrollPane6 = new JScrollPane();
/*  310 */     this.jTable5 = new JTable();
/*  311 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  312 */     this.jPanel37 = new JPanel();
/*  313 */     this.jLabel124 = new JLabel();
/*  314 */     this.jSeparator29 = new JSeparator();
/*  315 */     this.jLabel125 = new JLabel();
/*  316 */     this.jButton44 = new JButton();
/*  317 */     this.jButton45 = new JButton();
/*  318 */     this.jScrollPane18 = new JScrollPane();
/*  319 */     this.jTextArea5 = new JTextArea();
/*  320 */     this.jLabel126 = new JLabel();
/*  321 */     this.jPanel38 = new JPanel();
/*  322 */     this.jScrollPane7 = new JScrollPane();
/*  323 */     this.jTable6 = new JTable();
/*  324 */     this.jLabel6 = new JLabel();
/*  325 */     this.jPanel1 = new JPanel();
/*  326 */     this.jPanel39 = new JPanel();
/*  327 */     this.jPanel40 = new JPanel();
/*  328 */     this.jLabel55 = new JLabel();
/*  329 */     this.jPanel41 = new JPanel();
/*  330 */     this.jLabel33 = new JLabel();
/*  331 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  332 */     this.jLabel50 = new JLabel();
/*  333 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  334 */     this.jButton1 = new JButton();
/*  335 */     this.jPanel42 = new JPanel();
/*  336 */     this.jLabel170 = new JLabel();
/*  337 */     this.jLabel101 = new JLabel();
/*  338 */     this.jLabel171 = new JLabel();
/*  339 */     this.jPanel43 = new JPanel();
/*  340 */     this.jPanel17 = new JPanel();
/*  341 */     this.jTextField1 = new JTextField();
/*  342 */     this.jComboBox8 = new JComboBox();
/*  343 */     this.jTextField3 = new JTextField();
/*  344 */     this.jTextField4 = new JTextField();
/*  345 */     this.jTextField5 = new JTextField();
/*  346 */     this.jComboBox7 = new JComboBox();
/*  347 */     this.jPanel44 = new JPanel();
/*  348 */     this.jPanel45 = new JPanel();
/*  349 */     this.jPanel46 = new JPanel();
/*  350 */     this.jLabel15 = new JLabel();
/*  351 */     this.jLabel48 = new JLabel();
/*  352 */     this.jButton24 = new JButton();
/*  353 */     this.jButton27 = new JButton();
/*  354 */     this.jButton23 = new JButton();
/*  355 */     this.jButton28 = new JButton();
/*  356 */     this.jButton25 = new JButton();
/*  357 */     this.jButton26 = new JButton();
/*  358 */     this.jButton29 = new JButton();
/*  359 */     this.jScrollPane20 = new JScrollPane();
/*  360 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  362 */     this.jDialog1.setTitle("Crear cotizaciones");
/*  363 */     this.jDialog1.setModal(true);
/*      */     
/*  365 */     this.jPanel4.setDoubleBuffered(false);
/*      */     
/*  367 */     this.jLabel2.setHorizontalAlignment(0);
/*  368 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/*  370 */     this.jLabel3.setFont(new Font("Cantarell", 1, 13));
/*  371 */     this.jLabel3.setHorizontalAlignment(2);
/*  372 */     this.jLabel3.setText("FLETES Y MATERIALES FORSIS, SA DE CV");
/*      */     
/*  374 */     this.jLabel8.setFont(new Font("Cantarell", 0, 11));
/*  375 */     this.jLabel8.setHorizontalAlignment(2);
/*  376 */     this.jLabel8.setText("AUTOPISTA MONTERREY CADEREYTA KM 32.5");
/*      */     
/*  378 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/*  379 */     this.jLabel9.setHorizontalAlignment(2);
/*  380 */     this.jLabel9.setText("C.P. 67450");
/*      */     
/*  382 */     this.jLabel10.setFont(new Font("Cantarell", 0, 11));
/*  383 */     this.jLabel10.setHorizontalAlignment(2);
/*  384 */     this.jLabel10.setText("CADEREYTA JIMENEZ, NUEVO LEÓN");
/*      */     
/*  386 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  387 */     this.jPanel3.setLayout(jPanel3Layout);
/*  388 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  390 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  391 */           .addComponent(this.jLabel2, -2, 112, -2)
/*  392 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  393 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  394 */             .addComponent(this.jLabel8, -1, -1, 32767)
/*  395 */             .addComponent(this.jLabel9)
/*  396 */             .addComponent(this.jLabel10)
/*  397 */             .addComponent(this.jLabel3, -1, -1, 32767))
/*  398 */           .addContainerGap(-1, 32767)));
/*      */     
/*  400 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  402 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  403 */           .addComponent(this.jLabel3)
/*  404 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  405 */           .addComponent(this.jLabel8)
/*  406 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  407 */           .addComponent(this.jLabel9)
/*  408 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  409 */           .addComponent(this.jLabel10))
/*  410 */         .addComponent(this.jLabel2));
/*      */ 
/*      */     
/*  413 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Cotización", 2, 0, new Font("Cantarell", 0, 11)));
/*  414 */     this.jPanel6.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/*  416 */     this.jLabel11.setFont(new Font("Cantarell", 1, 11));
/*  417 */     this.jLabel11.setText("Sucursal:");
/*  418 */     this.jPanel6.add(this.jLabel11);
/*      */     
/*  420 */     this.jTextField2.setHorizontalAlignment(2);
/*  421 */     this.jPanel6.add(this.jTextField2);
/*      */     
/*  423 */     this.jLabel12.setFont(new Font("Cantarell", 1, 11));
/*  424 */     this.jLabel12.setText("Folio:");
/*  425 */     this.jPanel6.add(this.jLabel12);
/*      */     
/*  427 */     this.jTextField6.setHorizontalAlignment(2);
/*  428 */     this.jPanel6.add(this.jTextField6);
/*      */     
/*  430 */     this.jLabel13.setFont(new Font("Cantarell", 1, 11));
/*  431 */     this.jLabel13.setText("Fecha:");
/*  432 */     this.jPanel6.add(this.jLabel13);
/*      */     
/*  434 */     this.jDateChooser2.setEnabled(false);
/*  435 */     this.jDateChooser2.setIcon(this.icon);
/*  436 */     this.jPanel6.add((Component)this.jDateChooser2);
/*      */     
/*  438 */     this.jLabel14.setFont(new Font("Cantarell", 1, 11));
/*  439 */     this.jLabel14.setText("Documentó:");
/*  440 */     this.jPanel6.add(this.jLabel14);
/*      */     
/*  442 */     this.jTextField8.setHorizontalAlignment(2);
/*  443 */     this.jTextField8.setEnabled(false);
/*  444 */     this.jPanel6.add(this.jTextField8);
/*      */     
/*  446 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Dirijido a:", 2, 0, new Font("Cantarell", 0, 11)));
/*      */     
/*  448 */     this.jLabel19.setFont(new Font("Cantarell", 1, 11));
/*  449 */     this.jLabel19.setText("Cliente:");
/*      */     
/*  451 */     this.jLabel20.setFont(new Font("Cantarell", 0, 11));
/*  452 */     this.jLabel20.setText("Domicilio:");
/*      */     
/*  454 */     this.jLabel21.setFont(new Font("Cantarell", 0, 11));
/*  455 */     this.jLabel21.setText("Ciudad:");
/*      */     
/*  457 */     this.jLabel22.setFont(new Font("Cantarell", 1, 11));
/*  458 */     this.jLabel22.setText("Contacto:");
/*      */     
/*  460 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  462 */             Cotizaciones.this.jTextField7FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  466 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  467 */     this.jPanel7.setLayout(jPanel7Layout);
/*  468 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  469 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  470 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  471 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  472 */             .addComponent(this.jLabel21, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  473 */             .addComponent(this.jLabel20, GroupLayout.Alignment.LEADING, -1, 110, 32767)
/*  474 */             .addComponent(this.jLabel19, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  475 */             .addComponent(this.jLabel22, -1, -1, 32767))
/*  476 */           .addGap(3, 3, 3)
/*  477 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  478 */             .addComponent(this.jTextField7)
/*  479 */             .addComponent(this.jTextField9, GroupLayout.Alignment.TRAILING)
/*  480 */             .addComponent(this.jTextField10)
/*  481 */             .addComponent(this.jTextField11, GroupLayout.Alignment.TRAILING))));
/*      */     
/*  483 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  484 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  485 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  486 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  487 */             .addComponent(this.jLabel19, -2, 26, -2)
/*  488 */             .addComponent(this.jTextField7, -2, -1, -2))
/*  489 */           .addGap(6, 6, 6)
/*  490 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  491 */             .addComponent(this.jLabel20, -2, 26, -2)
/*  492 */             .addComponent(this.jTextField9, -2, -1, -2))
/*  493 */           .addGap(6, 6, 6)
/*  494 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  495 */             .addComponent(this.jLabel21, -2, 26, -2)
/*  496 */             .addComponent(this.jTextField10, -2, -1, -2))
/*  497 */           .addGap(6, 6, 6)
/*  498 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  499 */             .addComponent(this.jLabel22, -2, 26, -2)
/*  500 */             .addComponent(this.jTextField11, -2, -1, -2))));
/*      */ 
/*      */     
/*  503 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder(null, "Conceptos", 2, 0, new Font("Cantarell", 0, 11)));
/*      */     
/*  505 */     this.jTable1.setFont(new Font("Cantarell", 0, 10));
/*  506 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cantidad", "U de Medida", "Descripción", "P. Unitario", "P. Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  514 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  519 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  522 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  524 */             Cotizaciones.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/*  527 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  528 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  529 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(80);
/*  530 */       this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  531 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
/*  532 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(80);
/*  533 */       this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
/*  534 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
/*  535 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(80);
/*  536 */       this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
/*  537 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
/*  538 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(80);
/*  539 */       this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
/*  540 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */     } 
/*      */     
/*  543 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  544 */     this.jButton5.setToolTipText("Agregar Conceptos");
/*  545 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  547 */             Cotizaciones.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  551 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/*  552 */     this.jButton6.setToolTipText("Eliminar Conceptos");
/*  553 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  555 */             Cotizaciones.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  559 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  560 */     this.jButton7.setToolTipText("Modificar Conceptos");
/*  561 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  563 */             Cotizaciones.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  567 */     this.jLabel28.setFont(new Font("Cantarell", 2, 11));
/*  568 */     this.jLabel28.setForeground(this.lc.PRIMARIO2);
/*  569 */     this.jLabel28.setHorizontalAlignment(4);
/*  570 */     this.jLabel28.setText("Ningún dato agregado");
/*      */     
/*  572 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  573 */     this.jPanel8.setLayout(jPanel8Layout);
/*  574 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  575 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  576 */         .addComponent(this.jScrollPane1)
/*  577 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  578 */           .addComponent(this.jLabel28, -1, -1, 32767)
/*  579 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  580 */           .addComponent(this.jButton5, -2, 64, -2)
/*  581 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  582 */           .addComponent(this.jButton7, -2, 64, -2)
/*  583 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  584 */           .addComponent(this.jButton6, -2, 64, -2)));
/*      */     
/*  586 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  588 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  589 */           .addComponent(this.jScrollPane1, -2, 118, -2)
/*  590 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  591 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  592 */             .addComponent(this.jButton5, GroupLayout.Alignment.TRAILING, -2, 28, -2)
/*  593 */             .addComponent(this.jButton6, GroupLayout.Alignment.TRAILING, -2, 28, -2)
/*  594 */             .addComponent(this.jButton7, GroupLayout.Alignment.TRAILING, -2, 28, -2)
/*  595 */             .addComponent(this.jLabel28, -1, -1, 32767))));
/*      */ 
/*      */     
/*  598 */     this.jPanel9.setBorder(BorderFactory.createTitledBorder(null, "Términos, Condiciones y Consideraciones", 2, 0, new Font("Cantarell", 0, 11)));
/*      */     
/*  600 */     this.jTable2.setFont(new Font("Cantarell", 0, 10));
/*  601 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", "Condiciones" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  609 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */ 
/*      */           
/*  612 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/*  617 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  621 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  624 */     this.jScrollPane2.setViewportView(this.jTable2);
/*  625 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/*  626 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/*  627 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  628 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/*  629 */       this.jTable2.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/*      */     
/*  632 */     this.jButton9.setText("Buscar");
/*  633 */     this.jButton9.setToolTipText("Entra aqui para buscar Terminos y Condiciones");
/*  634 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  636 */             Cotizaciones.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  640 */     this.jLabel32.setFont(new Font("Cantarell", 2, 11));
/*  641 */     this.jLabel32.setForeground(this.lc.PRIMARIO2);
/*  642 */     this.jLabel32.setHorizontalAlignment(4);
/*  643 */     this.jLabel32.setText("jLabel32");
/*      */     
/*  645 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  646 */     this.jPanel9.setLayout(jPanel9Layout);
/*  647 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  648 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  649 */         .addComponent(this.jScrollPane2)
/*  650 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  651 */           .addContainerGap()
/*  652 */           .addComponent(this.jLabel32, -1, -1, 32767)
/*  653 */           .addGap(18, 18, 18)
/*  654 */           .addComponent(this.jButton9, -2, 104, -2)));
/*      */     
/*  656 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  657 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  658 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  659 */           .addComponent(this.jScrollPane2, -1, 224, 32767)
/*  660 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  661 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  662 */             .addComponent(this.jButton9, -1, -1, 32767)
/*  663 */             .addComponent(this.jLabel32, -1, -1, 32767))));
/*      */ 
/*      */     
/*  666 */     this.jPanel10.setLayout(new GridLayout(1, 3));
/*      */     
/*  668 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  669 */     this.jPanel11.setLayout(jPanel11Layout);
/*  670 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  671 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  672 */         .addGap(0, 218, 32767));
/*      */     
/*  674 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  675 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  676 */         .addGap(0, 122, 32767));
/*      */ 
/*      */     
/*  679 */     this.jPanel10.add(this.jPanel11);
/*      */     
/*  681 */     this.jPanel12.setLayout(new GridLayout(4, 0, 0, 6));
/*      */     
/*  683 */     this.jLabel23.setFont(new Font("Cantarell", 1, 13));
/*  684 */     this.jLabel23.setHorizontalAlignment(0);
/*  685 */     this.jLabel23.setText("Atentamente:");
/*  686 */     this.jPanel12.add(this.jLabel23);
/*      */     
/*  688 */     this.jTextField13.setHorizontalAlignment(0);
/*  689 */     this.jTextField13.addCaretListener(new CaretListener() {
/*      */           public void caretUpdate(CaretEvent evt) {
/*  691 */             Cotizaciones.this.jTextField13CaretUpdate(evt);
/*      */           }
/*      */         });
/*  694 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  696 */             Cotizaciones.this.jTextField13FocusLost(evt);
/*      */           }
/*      */         });
/*  699 */     this.jPanel12.add(this.jTextField13);
/*      */     
/*  701 */     this.jTextField15.setHorizontalAlignment(0);
/*  702 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  704 */             Cotizaciones.this.jTextField15FocusLost(evt);
/*      */           }
/*      */         });
/*  707 */     this.jPanel12.add(this.jTextField15);
/*  708 */     this.jPanel12.add(this.jLabel24);
/*      */     
/*  710 */     this.jPanel10.add(this.jPanel12);
/*      */     
/*  712 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  713 */     this.jPanel13.setLayout(jPanel13Layout);
/*  714 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  715 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  716 */         .addGap(0, 218, 32767));
/*      */     
/*  718 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  720 */         .addGap(0, 122, 32767));
/*      */ 
/*      */     
/*  723 */     this.jPanel10.add(this.jPanel13);
/*      */     
/*  725 */     this.jPanel32.setLayout(new GridLayout(1, 3, 10, 0));
/*      */     
/*  727 */     this.materialButton21.setBackground(this.lc.PRIMARIO1);
/*  728 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  729 */     this.materialButton21.setMnemonic('G');
/*  730 */     this.materialButton21.setText("Copiar a nueva");
/*  731 */     this.materialButton21.setToolTipText("Guardar (Alt+G)");
/*  732 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  733 */     this.materialButton21.setHorizontalTextPosition(0);
/*  734 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  736 */             Cotizaciones.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  740 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  741 */     this.jPanel33.setLayout(jPanel33Layout);
/*  742 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  743 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  744 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/*  745 */           .addGap(0, 65, 32767)
/*  746 */           .addComponent((Component)this.materialButton21, -2, 142, -2)));
/*      */     
/*  748 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/*  749 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  750 */         .addComponent((Component)this.materialButton21, -1, 41, 32767));
/*      */ 
/*      */     
/*  753 */     this.jPanel32.add(this.jPanel33);
/*      */     
/*  755 */     this.jPanel34.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  757 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/*  758 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/*  759 */     this.materialButton20.setMnemonic('G');
/*  760 */     this.materialButton20.setText("Guardar");
/*  761 */     this.materialButton20.setToolTipText("Guardar (Alt+G)");
/*  762 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/*  763 */     this.materialButton20.setHorizontalTextPosition(0);
/*  764 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  766 */             Cotizaciones.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*  769 */     this.jPanel34.add((Component)this.materialButton20);
/*      */     
/*  771 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/*  772 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  773 */     this.materialButton19.setMnemonic('C');
/*  774 */     this.materialButton19.setText("Cerrar");
/*  775 */     this.materialButton19.setToolTipText("Cerrar (Alt+C)");
/*  776 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  777 */     this.materialButton19.setHorizontalTextPosition(0);
/*  778 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  780 */             Cotizaciones.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*  783 */     this.jPanel34.add((Component)this.materialButton19);
/*      */     
/*  785 */     this.jPanel32.add(this.jPanel34);
/*      */     
/*  787 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/*  788 */     this.jPanel35.setLayout(jPanel35Layout);
/*  789 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/*  790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  791 */         .addGap(0, 204, 32767));
/*      */     
/*  793 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/*  794 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  795 */         .addGap(0, 41, 32767));
/*      */ 
/*      */     
/*  798 */     this.jPanel32.add(this.jPanel35);
/*      */     
/*  800 */     this.jLabel31.setFont(new Font("Cantarell", 3, 11));
/*  801 */     this.jLabel31.setForeground(Color.red);
/*  802 */     this.jLabel31.setText("cancelación");
/*  803 */     this.jLabel31.setAutoscrolls(true);
/*  804 */     this.jLabel31.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  806 */             Cotizaciones.this.jLabel31MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  810 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  811 */     this.jPanel4.setLayout(jPanel4Layout);
/*  812 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  813 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  814 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  815 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  816 */             .addComponent(this.jPanel3, -1, -1, 32767)
/*  817 */             .addComponent(this.jLabel31, -1, -1, 32767))
/*  818 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  819 */           .addComponent(this.jPanel6, -2, 0, 32767))
/*  820 */         .addComponent(this.jPanel7, -1, -1, 32767)
/*  821 */         .addComponent(this.jPanel8, -1, -1, 32767)
/*  822 */         .addComponent(this.jPanel9, -1, -1, 32767)
/*  823 */         .addComponent(this.jPanel10, -1, -1, 32767)
/*  824 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  825 */           .addContainerGap()
/*  826 */           .addComponent(this.jPanel32, -1, -1, 32767)
/*  827 */           .addContainerGap()));
/*      */     
/*  829 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  830 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  831 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  832 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  833 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  834 */               .addComponent(this.jPanel3, -2, -1, -2)
/*  835 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  836 */               .addComponent(this.jLabel31, -1, -1, 32767))
/*  837 */             .addComponent(this.jPanel6, -2, 138, -2))
/*  838 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  839 */           .addComponent(this.jPanel7, -2, -1, -2)
/*  840 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  841 */           .addComponent(this.jPanel8, -2, -1, -2)
/*  842 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  843 */           .addComponent(this.jPanel9, -2, -1, -2)
/*  844 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  845 */           .addComponent(this.jPanel10, -2, -1, -2)
/*  846 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  847 */           .addComponent(this.jPanel32, -2, 41, -2)
/*  848 */           .addContainerGap(37, 32767)));
/*      */ 
/*      */     
/*  851 */     this.jScrollPane4.setViewportView(this.jPanel4);
/*      */     
/*  853 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  854 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  855 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  857 */         .addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING, -1, 656, 32767));
/*      */     
/*  859 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  860 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  861 */         .addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING, -1, 966, 32767));
/*      */ 
/*      */     
/*  864 */     this.jDialog2.setTitle("Nuevo concepto");
/*  865 */     this.jDialog2.setModal(true);
/*      */     
/*  867 */     this.jPanel15.setLayout(new GridLayout(2, 0));
/*      */     
/*  869 */     this.jPanel16.setLayout(new GridLayout(1, 3));
/*      */     
/*  871 */     this.jPanel19.setLayout(new GridLayout(1, 2));
/*      */     
/*  873 */     this.jLabel5.setHorizontalAlignment(0);
/*  874 */     this.jLabel5.setText("Cantidad");
/*  875 */     this.jPanel19.add(this.jLabel5);
/*      */     
/*  877 */     this.jLabel7.setHorizontalAlignment(0);
/*  878 */     this.jLabel7.setText("U. de Medida");
/*  879 */     this.jPanel19.add(this.jLabel7);
/*      */     
/*  881 */     this.jPanel16.add(this.jPanel19);
/*      */     
/*  883 */     this.jPanel20.setLayout(new GridLayout(1, 0));
/*      */     
/*  885 */     this.jLabel27.setHorizontalAlignment(0);
/*  886 */     this.jLabel27.setText("Descripción");
/*  887 */     this.jPanel20.add(this.jLabel27);
/*      */     
/*  889 */     this.jPanel16.add(this.jPanel20);
/*      */     
/*  891 */     this.jPanel21.setLayout(new GridLayout(1, 2));
/*      */     
/*  893 */     this.jLabel25.setHorizontalAlignment(0);
/*  894 */     this.jLabel25.setText("P Unitario");
/*  895 */     this.jPanel21.add(this.jLabel25);
/*      */     
/*  897 */     this.jLabel26.setHorizontalAlignment(0);
/*  898 */     this.jLabel26.setText("Total");
/*  899 */     this.jPanel21.add(this.jLabel26);
/*      */     
/*  901 */     this.jPanel16.add(this.jPanel21);
/*      */     
/*  903 */     this.jPanel15.add(this.jPanel16);
/*      */     
/*  905 */     this.jPanel22.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  907 */     this.jPanel23.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  909 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  910 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  911 */     this.jFormattedTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  913 */             Cotizaciones.this.jFormattedTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  916 */     this.jPanel23.add(this.jFormattedTextField1);
/*      */     
/*  918 */     this.jTextField12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  920 */             Cotizaciones.this.jTextField12ActionPerformed(evt);
/*      */           }
/*      */         });
/*  923 */     this.jPanel23.add(this.jTextField12);
/*      */     
/*  925 */     this.jPanel22.add(this.jPanel23);
/*      */     
/*  927 */     this.jPanel24.setLayout(new GridLayout(1, 0));
/*      */     
/*  929 */     this.jTextField14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  931 */             Cotizaciones.this.jTextField14ActionPerformed(evt);
/*      */           }
/*      */         });
/*  934 */     this.jPanel24.add(this.jTextField14);
/*      */     
/*  936 */     this.jPanel22.add(this.jPanel24);
/*      */     
/*  938 */     this.jPanel25.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  940 */     this.jFormattedTextField2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  941 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*  942 */     this.jFormattedTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  944 */             Cotizaciones.this.jFormattedTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  947 */     this.jPanel25.add(this.jFormattedTextField2);
/*      */     
/*  949 */     this.jPanel30.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  951 */     this.jFormattedTextField3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  952 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*  953 */     this.jFormattedTextField3.setEnabled(false);
/*  954 */     this.jFormattedTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  956 */             Cotizaciones.this.jFormattedTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  959 */     this.jPanel30.add(this.jFormattedTextField3);
/*      */     
/*  961 */     this.jPanel25.add(this.jPanel30);
/*      */     
/*  963 */     this.jPanel22.add(this.jPanel25);
/*      */     
/*  965 */     this.jPanel15.add(this.jPanel22);
/*      */     
/*  967 */     this.jPanel18.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  969 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  970 */     this.jPanel26.setLayout(jPanel26Layout);
/*  971 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  972 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  973 */         .addGap(0, 110, 32767));
/*      */     
/*  975 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  976 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/*  980 */     this.jPanel18.add(this.jPanel26);
/*      */     
/*  982 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  983 */     this.jPanel27.setLayout(jPanel27Layout);
/*  984 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  985 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  986 */         .addGap(0, 110, 32767));
/*      */     
/*  988 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  989 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  990 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/*  993 */     this.jPanel18.add(this.jPanel27);
/*      */     
/*  995 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/*  996 */     this.jPanel28.setLayout(jPanel28Layout);
/*  997 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/*  998 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  999 */         .addGap(0, 110, 32767));
/*      */     
/* 1001 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 1002 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1003 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 1006 */     this.jPanel18.add(this.jPanel28);
/*      */     
/* 1008 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1009 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1010 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1011 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1012 */         .addGap(0, 110, 32767));
/*      */     
/* 1014 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1015 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1016 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 1019 */     this.jPanel18.add(this.jPanel29);
/*      */     
/* 1021 */     this.jButton4.setMnemonic('A');
/* 1022 */     this.jButton4.setText("Agregar");
/* 1023 */     this.jButton4.setToolTipText("Agregar (Alt+A)");
/* 1024 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1026 */             Cotizaciones.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1029 */     this.jPanel18.add(this.jButton4);
/*      */     
/* 1031 */     this.jButton3.setMnemonic('C');
/* 1032 */     this.jButton3.setText("Cerrar");
/* 1033 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/* 1034 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1036 */             Cotizaciones.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1039 */     this.jPanel18.add(this.jButton3);
/*      */     
/* 1041 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1042 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1043 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1044 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1045 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1046 */           .addContainerGap()
/* 1047 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1048 */             .addComponent(this.jPanel18, -1, 694, 32767)
/* 1049 */             .addComponent(this.jPanel15, -1, -1, 32767))
/* 1050 */           .addContainerGap()));
/*      */     
/* 1052 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1053 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1054 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1055 */           .addComponent(this.jPanel15, -2, -1, -2)
/* 1056 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1057 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 1058 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1061 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1062 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1063 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1064 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1065 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */     
/* 1067 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1068 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1069 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 1072 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/* 1074 */     this.jDialog3.setTitle("Catálogo de términos, condiciones y consideraciones");
/* 1075 */     this.jDialog3.setModal(true);
/*      */     
/* 1077 */     this.jTable4.setFont(new Font("Cantarell", 0, 10));
/* 1078 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", "Término" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1086 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */ 
/*      */           
/* 1089 */           boolean[] canEdit = new boolean[] { true, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1094 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1098 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1101 */     this.jScrollPane5.setViewportView(this.jTable4);
/* 1102 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/* 1103 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(50);
/* 1104 */       this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 1105 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
/* 1106 */       this.jTable4.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/*      */     
/* 1109 */     this.jButton10.setMnemonic('C');
/* 1110 */     this.jButton10.setText("Cerrar");
/* 1111 */     this.jButton10.setToolTipText("Cerrar sin guardar cambios(Alt+C)");
/* 1112 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1114 */             Cotizaciones.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1118 */     this.jButton8.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1119 */     this.jButton8.setToolTipText("Agregar nuevo término");
/* 1120 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1122 */             Cotizaciones.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1126 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1127 */     this.jButton12.setToolTipText("Modificar el término seleccionado");
/* 1128 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1130 */             Cotizaciones.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1134 */     this.jButton15.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1135 */     this.jButton15.setToolTipText("Eiminar datos");
/* 1136 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1138 */             Cotizaciones.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1142 */     this.jLabel30.setHorizontalAlignment(4);
/* 1143 */     this.jLabel30.setText("Búsqueda:");
/*      */     
/* 1145 */     this.jTextField17.addCaretListener(new CaretListener() {
/*      */           public void caretUpdate(CaretEvent evt) {
/* 1147 */             Cotizaciones.this.jTextField17CaretUpdate(evt);
/*      */           }
/*      */         });
/*      */     
/* 1151 */     this.jButton17.setMnemonic('A');
/* 1152 */     this.jButton17.setText("Aplicar");
/* 1153 */     this.jButton17.setToolTipText("Aplicar los terminos seleccionados (Alt+A)");
/* 1154 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1156 */             Cotizaciones.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1160 */     this.jButton19.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1161 */     this.jButton19.setToolTipText("Imprimir catálogo de términos y condiciones");
/* 1162 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1164 */             Cotizaciones.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1168 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 1169 */     this.jPanel36.setLayout(jPanel36Layout);
/* 1170 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 1171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1172 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1173 */           .addContainerGap()
/* 1174 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1175 */             .addComponent(this.jScrollPane5, -1, 781, 32767)
/* 1176 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 1177 */               .addComponent(this.jButton8, -2, 64, -2)
/* 1178 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1179 */               .addComponent(this.jButton12, -2, 64, -2)
/* 1180 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1181 */               .addComponent(this.jButton15, -2, 64, -2)
/* 1182 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1183 */               .addComponent(this.jButton19, -2, 64, -2)
/* 1184 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1185 */               .addComponent(this.jLabel30, -2, 75, -2)
/* 1186 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1187 */               .addComponent(this.jTextField17, -2, 163, -2)
/* 1188 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1189 */               .addComponent(this.jButton17, -2, 88, -2)
/* 1190 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1191 */               .addComponent(this.jButton10, -2, 88, -2)))
/* 1192 */           .addContainerGap()));
/*      */     
/* 1194 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1195 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1196 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 1197 */           .addContainerGap()
/* 1198 */           .addComponent(this.jScrollPane5, -1, 403, 32767)
/* 1199 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1200 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1201 */             .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1202 */               .addComponent(this.jButton8, -2, 28, -2)
/* 1203 */               .addComponent(this.jButton15, -2, 28, -2)
/* 1204 */               .addComponent(this.jButton12, -2, 28, -2)
/* 1205 */               .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1206 */                 .addComponent(this.jButton10)
/* 1207 */                 .addComponent(this.jTextField17, -2, -1, -2)
/* 1208 */                 .addComponent(this.jButton17))
/* 1209 */               .addComponent(this.jLabel30, -1, -1, 32767))
/* 1210 */             .addComponent(this.jButton19, -2, 28, -2))
/* 1211 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1214 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1215 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1216 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1217 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1218 */         .addComponent(this.jPanel36, -1, -1, 32767));
/*      */     
/* 1220 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1221 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1222 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1223 */           .addComponent(this.jPanel36, -1, -1, 32767)
/* 1224 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1227 */     this.jDialog4.setTitle("Nuevo término");
/* 1228 */     this.jDialog4.setModal(true);
/*      */     
/* 1230 */     this.jLabel29.setText("Ingresa el nuevo término:");
/*      */     
/* 1232 */     this.jTextField16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1234 */             Cotizaciones.this.jTextField16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1238 */     this.jButton11.setMnemonic('C');
/* 1239 */     this.jButton11.setText("Cerrar");
/* 1240 */     this.jButton11.setToolTipText("Cerrar (Alt+C)");
/* 1241 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1243 */             Cotizaciones.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1247 */     this.jButton16.setMnemonic('A');
/* 1248 */     this.jButton16.setText("Agregar");
/* 1249 */     this.jButton16.setToolTipText("Agregar (Alt+A)");
/* 1250 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1252 */             Cotizaciones.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1256 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1257 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1258 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1259 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1260 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1261 */           .addContainerGap()
/* 1262 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1263 */             .addComponent(this.jTextField16)
/* 1264 */             .addComponent(this.jLabel29, -1, -1, 32767)
/* 1265 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1266 */               .addGap(0, 265, 32767)
/* 1267 */               .addComponent(this.jButton16, -2, 91, -2)
/* 1268 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1269 */               .addComponent(this.jButton11, -2, 91, -2)))
/* 1270 */           .addContainerGap()));
/*      */     
/* 1272 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1273 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1274 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1275 */           .addComponent(this.jLabel29, -2, 26, -2)
/* 1276 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1277 */           .addComponent(this.jTextField16, -2, -1, -2)
/* 1278 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1279 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1280 */             .addComponent(this.jButton11)
/* 1281 */             .addComponent(this.jButton16))
/* 1282 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1285 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1286 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1287 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1288 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1289 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1290 */           .addComponent(this.jPanel31, -2, -1, -2)
/* 1291 */           .addGap(0, 0, 32767)));
/*      */     
/* 1293 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1294 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1295 */         .addComponent(this.jPanel31, -1, -1, 32767));
/*      */ 
/*      */     
/* 1298 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1309 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/* 1311 */     this.jDialog5.setTitle("Cancelar Cotización");
/* 1312 */     this.jDialog5.setModal(true);
/*      */     
/* 1314 */     this.jPanel37.setBackground(new Color(146, 193, 134));
/*      */     
/* 1316 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 1317 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 1318 */     this.jLabel124.setHorizontalAlignment(0);
/* 1319 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 1321 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 1322 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 1323 */     this.jLabel125.setHorizontalAlignment(4);
/* 1324 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1326 */     this.jButton44.setMnemonic('A');
/* 1327 */     this.jButton44.setText("Cancelar Cotización");
/* 1328 */     this.jButton44.setToolTipText("Cancelar Cotización (Alt+A)");
/* 1329 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1331 */             Cotizaciones.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1335 */     this.jButton45.setMnemonic('C');
/* 1336 */     this.jButton45.setText("Cerrar");
/* 1337 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1338 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1340 */             Cotizaciones.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1344 */     this.jTextArea5.setColumns(20);
/* 1345 */     this.jTextArea5.setLineWrap(true);
/* 1346 */     this.jTextArea5.setRows(5);
/* 1347 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1349 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar la cotización");
/*      */     
/* 1351 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/* 1352 */     this.jPanel37.setLayout(jPanel37Layout);
/* 1353 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/* 1354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1355 */         .addGroup(jPanel37Layout.createSequentialGroup()
/* 1356 */           .addContainerGap()
/* 1357 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1358 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 1359 */             .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1360 */               .addGroup(jPanel37Layout.createSequentialGroup()
/* 1361 */                 .addComponent(this.jButton44, -2, 163, -2)
/* 1362 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1363 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1364 */               .addGroup(jPanel37Layout.createSequentialGroup()
/* 1365 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 1366 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1367 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1368 */             .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1369 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1370 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1371 */           .addContainerGap()));
/*      */     
/* 1373 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/* 1374 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1375 */         .addGroup(jPanel37Layout.createSequentialGroup()
/* 1376 */           .addComponent(this.jLabel124)
/* 1377 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1378 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 1379 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1380 */           .addComponent(this.jLabel126)
/* 1381 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1382 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1383 */             .addComponent(this.jLabel125)
/* 1384 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1385 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1386 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1387 */             .addComponent(this.jButton45)
/* 1388 */             .addComponent(this.jButton44))
/* 1389 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1392 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1393 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1394 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1395 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1396 */         .addComponent(this.jPanel37, -1, -1, 32767));
/*      */     
/* 1398 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1399 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1400 */         .addComponent(this.jPanel37, -1, -1, 32767));
/*      */ 
/*      */     
/* 1403 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1414 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/* 1416 */     this.jLabel6.setText("Tabla auxiliar para consultas de terminos");
/*      */     
/* 1418 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1419 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1420 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1421 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1422 */         .addComponent(this.jScrollPane7, -1, 589, 32767)
/* 1423 */         .addComponent(this.jLabel6, -1, -1, 32767));
/*      */     
/* 1425 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1426 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1427 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 1428 */           .addGap(44, 44, 44)
/* 1429 */           .addComponent(this.jLabel6)
/* 1430 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 103, 32767)
/* 1431 */           .addComponent(this.jScrollPane7, -2, 275, -2)));
/*      */ 
/*      */     
/* 1434 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1435 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1436 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1438 */         .addGap(0, 643, 32767));
/*      */     
/* 1440 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1442 */         .addGap(0, 501, 32767));
/*      */ 
/*      */     
/* 1445 */     this.jPanel39.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1447 */     this.jPanel40.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1449 */     this.jLabel55.setFont(new Font("Cantarell", 1, 22));
/* 1450 */     this.jLabel55.setForeground(this.lc.PRIMARIO1);
/* 1451 */     this.jLabel55.setText("Cotizaciones");
/* 1452 */     this.jLabel55.setVerticalAlignment(1);
/*      */     
/* 1454 */     this.jPanel41.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1456 */     this.jLabel33.setFont(new Font("Cantarell", 0, 11));
/* 1457 */     this.jLabel33.setHorizontalAlignment(4);
/* 1458 */     this.jLabel33.setText("Visualizando información del ");
/*      */     
/* 1460 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1461 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1462 */     this.jDateChooser4.setIcon(this.icon);
/* 1463 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1464 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1466 */     this.jLabel50.setFont(new Font("Cantarell", 0, 11));
/* 1467 */     this.jLabel50.setHorizontalAlignment(0);
/* 1468 */     this.jLabel50.setText("al");
/*      */     
/* 1470 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1471 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1472 */     this.jDateChooser5.setIcon(this.icon);
/* 1473 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1475 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 1476 */     this.jButton1.setMnemonic('B');
/* 1477 */     this.jButton1.setToolTipText("Buscar información (Alt+B)");
/* 1478 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1480 */             Cotizaciones.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1484 */     this.jPanel42.setBackground(this.lc.SECUNDARIO2);
/* 1485 */     this.jPanel42.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1487 */     this.jLabel170.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 1488 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 1489 */     this.jLabel170.setHorizontalAlignment(0);
/* 1490 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 1491 */     this.jLabel170.setToolTipText("Retroceder un día en la búsqueda");
/* 1492 */     this.jLabel170.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1494 */             Cotizaciones.this.jLabel170MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1497 */             Cotizaciones.this.jLabel170MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1500 */             Cotizaciones.this.jLabel170MouseEntered(evt);
/*      */           }
/*      */         });
/* 1503 */     this.jPanel42.add(this.jLabel170);
/*      */     
/* 1505 */     this.jLabel101.setFont(new Font("Tahoma", 2, 12));
/* 1506 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 1507 */     this.jLabel101.setHorizontalAlignment(0);
/* 1508 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 1509 */     this.jLabel101.setToolTipText("Clic para filtrar los datos de HOY");
/* 1510 */     this.jLabel101.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1512 */             Cotizaciones.this.jLabel101MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1515 */             Cotizaciones.this.jLabel101MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1518 */             Cotizaciones.this.jLabel101MouseEntered(evt);
/*      */           }
/*      */         });
/* 1521 */     this.jPanel42.add(this.jLabel101);
/*      */     
/* 1523 */     this.jLabel171.setHorizontalAlignment(0);
/* 1524 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 1525 */     this.jLabel171.setToolTipText("Aumentar un día en la búsqueda");
/* 1526 */     this.jLabel171.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1528 */             Cotizaciones.this.jLabel171MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1531 */             Cotizaciones.this.jLabel171MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1534 */             Cotizaciones.this.jLabel171MouseEntered(evt);
/*      */           }
/*      */         });
/* 1537 */     this.jPanel42.add(this.jLabel171);
/*      */     
/* 1539 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 1540 */     this.jPanel41.setLayout(jPanel41Layout);
/* 1541 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 1542 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1543 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 1544 */           .addComponent(this.jLabel33, -2, 157, -2)
/* 1545 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1546 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1547 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1548 */           .addComponent(this.jLabel50, -2, 16, -2)
/* 1549 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1550 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 1551 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1552 */           .addComponent(this.jButton1, -2, 46, -2)
/* 1553 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1554 */           .addComponent(this.jPanel42, -2, 99, -2)
/* 1555 */           .addContainerGap(105, 32767)));
/*      */     
/* 1557 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 1558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1559 */         .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1560 */           .addComponent(this.jLabel50, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1561 */           .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1562 */           .addComponent(this.jLabel33, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1563 */         .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/* 1564 */         .addComponent(this.jButton1, -1, -1, 32767)
/* 1565 */         .addComponent(this.jPanel42, -1, -1, 32767));
/*      */ 
/*      */     
/* 1568 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 1569 */     this.jPanel40.setLayout(jPanel40Layout);
/* 1570 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 1571 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1572 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 1573 */           .addComponent(this.jLabel55, -2, 184, -2)
/* 1574 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1575 */           .addComponent(this.jPanel41, -1, -1, 32767)));
/*      */     
/* 1577 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 1578 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1579 */         .addComponent(this.jLabel55)
/* 1580 */         .addComponent(this.jPanel41, -2, -1, -2));
/*      */ 
/*      */     
/* 1583 */     this.jPanel43.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1585 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 1586 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Cotizaciones", 0, 1, new Font("Cantarell", 0, 11)));
/* 1587 */     this.jPanel17.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/* 1589 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1591 */             Cotizaciones.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1594 */     this.jPanel17.add(this.jTextField1);
/*      */     
/* 1596 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 1597 */     this.jComboBox8.setFont(new Font("Cantarell", 0, 11));
/* 1598 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Autorizar>", "<Autorizada>", "<Cancelada>" }));
/* 1599 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1601 */             Cotizaciones.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1604 */     this.jPanel17.add(this.jComboBox8);
/*      */     
/* 1606 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1608 */             Cotizaciones.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1611 */     this.jPanel17.add(this.jTextField3);
/*      */     
/* 1613 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1615 */             Cotizaciones.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1618 */     this.jPanel17.add(this.jTextField4);
/*      */     
/* 1620 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1622 */             Cotizaciones.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/* 1625 */     this.jPanel17.add(this.jTextField5);
/*      */     
/* 1627 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 1628 */     this.jComboBox7.setFont(new Font("Cantarell", 0, 11));
/* 1629 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1631 */             Cotizaciones.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1634 */     this.jPanel17.add(this.jComboBox7);
/*      */     
/* 1636 */     this.jPanel44.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1638 */     this.jPanel45.setBackground(this.lc.SECUNDARIO2);
/* 1639 */     this.jPanel45.setLayout(new GridLayout(1, 8, 6, 0));
/*      */     
/* 1641 */     this.jPanel46.setBackground(this.lc.SECUNDARIO1);
/* 1642 */     this.jPanel46.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1644 */     this.jLabel15.setFont(new Font("Cantarell", 0, 13));
/* 1645 */     this.jLabel15.setForeground(new Color(255, 255, 255));
/* 1646 */     this.jLabel15.setHorizontalAlignment(4);
/* 1647 */     this.jLabel15.setText("Total");
/* 1648 */     this.jPanel46.add(this.jLabel15);
/*      */     
/* 1650 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 1651 */     this.jLabel48.setForeground(this.lc.PRIMARIO2);
/* 1652 */     this.jLabel48.setHorizontalAlignment(0);
/* 1653 */     this.jLabel48.setText("t");
/* 1654 */     this.jPanel46.add(this.jLabel48);
/*      */     
/* 1656 */     this.jPanel45.add(this.jPanel46);
/*      */     
/* 1658 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1659 */     this.jButton24.setMnemonic('N');
/* 1660 */     this.jButton24.setText("Nueva");
/* 1661 */     this.jButton24.setToolTipText("Crea nuevas cotizaciones (Alt+N)");
/* 1662 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1664 */             Cotizaciones.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1667 */     this.jPanel45.add(this.jButton24);
/*      */     
/* 1669 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1670 */     this.jButton27.setMnemonic('M');
/* 1671 */     this.jButton27.setText("Modificar");
/* 1672 */     this.jButton27.setToolTipText("Modificar la cotización (Alt+M)");
/* 1673 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1675 */             Cotizaciones.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1678 */     this.jPanel45.add(this.jButton27);
/*      */     
/* 1680 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1681 */     this.jButton23.setMnemonic('V');
/* 1682 */     this.jButton23.setText("Ver");
/* 1683 */     this.jButton23.setToolTipText("Ver el detalle de la cotización seleccionada (Alt+V)");
/* 1684 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1686 */             Cotizaciones.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1689 */     this.jPanel45.add(this.jButton23);
/*      */     
/* 1691 */     this.jButton28.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Good-Shield.png")));
/* 1692 */     this.jButton28.setMnemonic('A');
/* 1693 */     this.jButton28.setText("Autorizar");
/* 1694 */     this.jButton28.setToolTipText("Autorizar Cotización (Alt+A)");
/* 1695 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1697 */             Cotizaciones.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1700 */     this.jPanel45.add(this.jButton28);
/*      */     
/* 1702 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1703 */     this.jButton25.setMnemonic('C');
/* 1704 */     this.jButton25.setText("Cancelar");
/* 1705 */     this.jButton25.setToolTipText("Cancelar cotización (Alt+C)");
/* 1706 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1708 */             Cotizaciones.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1711 */     this.jPanel45.add(this.jButton25);
/*      */     
/* 1713 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1714 */     this.jButton26.setMnemonic('G');
/* 1715 */     this.jButton26.setText("Guardar Reporte");
/* 1716 */     this.jButton26.setToolTipText("Guardar reportes (AltG)");
/* 1717 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1719 */             Cotizaciones.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1722 */     this.jPanel45.add(this.jButton26);
/*      */     
/* 1724 */     this.jButton29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1725 */     this.jButton29.setMnemonic('I');
/* 1726 */     this.jButton29.setText("Imprimir");
/* 1727 */     this.jButton29.setToolTipText("Imprimir Cotizaciones (Alt+I)");
/* 1728 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1730 */             Cotizaciones.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1733 */     this.jPanel45.add(this.jButton29);
/*      */     
/* 1735 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1743 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1748 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1751 */     this.rSTableMetro1.setAltoHead(40);
/* 1752 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1753 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1754 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1755 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1756 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1757 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1758 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1759 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 11));
/* 1760 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 1761 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1762 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1763 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1764 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1765 */     this.rSTableMetro1.setSelectionForeground(new Color(255, 255, 255));
/* 1766 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 1767 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 1768 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1769 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1770 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1772 */             Cotizaciones.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1775 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1777 */             Cotizaciones.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1780 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1782 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 1783 */     this.jPanel44.setLayout(jPanel44Layout);
/* 1784 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 1785 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1786 */         .addComponent(this.jPanel45, -2, 0, 32767)
/* 1787 */         .addComponent(this.jScrollPane20));
/*      */     
/* 1789 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 1790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1791 */         .addGroup(jPanel44Layout.createSequentialGroup()
/* 1792 */           .addComponent(this.jPanel45, -2, -1, -2)
/* 1793 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1794 */           .addComponent(this.jScrollPane20, -1, 276, 32767)));
/*      */ 
/*      */     
/* 1797 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 1798 */     this.jPanel43.setLayout(jPanel43Layout);
/* 1799 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 1800 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1801 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 1802 */         .addComponent(this.jPanel44, -1, -1, 32767));
/*      */     
/* 1804 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 1805 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1806 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 1807 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 1808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1809 */           .addComponent(this.jPanel44, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1812 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 1813 */     this.jPanel39.setLayout(jPanel39Layout);
/* 1814 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 1815 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1816 */         .addComponent(this.jPanel40, -1, -1, 32767)
/* 1817 */         .addComponent(this.jPanel43, -1, -1, 32767));
/*      */     
/* 1819 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 1820 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1821 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1822 */           .addComponent(this.jPanel40, -2, -1, -2)
/* 1823 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1824 */           .addComponent(this.jPanel43, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1827 */     GroupLayout layout = new GroupLayout(this);
/* 1828 */     setLayout(layout);
/* 1829 */     layout.setHorizontalGroup(layout
/* 1830 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1831 */         .addGroup(layout.createSequentialGroup()
/* 1832 */           .addComponent(this.jPanel39, -1, -1, 32767)
/* 1833 */           .addGap(0, 0, 0)));
/*      */     
/* 1835 */     layout.setVerticalGroup(layout
/* 1836 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1837 */         .addComponent(this.jPanel39, -1, -1, 32767));
/*      */   }
/*      */   private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane20; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JSeparator jSeparator29; private JTable jTable1; private JTable jTable2; private JTable jTable4; private JTable jTable5; private JTable jTable6; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; JTextField jTextField17; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 1842 */     verCotizacion();
/* 1843 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 1847 */     this.jDialog1.setTitle("Crear cotizaciones");
/* 1848 */     this.materialButton20.setText("Guardar");
/* 1849 */     this.materialButton20.setToolTipText("Guardar Cotización (Alt+G)");
/* 1850 */     this.materialButton20.setMnemonic('G');
/* 1851 */     limpiarCotizacion();
/* 1852 */     this.jTextField8.setText(iniciales(this.USUARIO));
/* 1853 */     sacarMayor();
/* 1854 */     this.jTextField2.setText(this.CONFIG[1]);
/* 1855 */     this.jDateChooser2.setDate(new Date());
/*      */     
/* 1857 */     this.jTable1.setFont(new Font("Cantarell", 0, 12));
/* 1858 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cantidad", "U de Medida", "Descripción", "P. Unitario", "P. Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1864 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1869 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1872 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 1873 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/* 1874 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(80);
/* 1875 */       this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 1876 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
/* 1877 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(80);
/* 1878 */       this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 1879 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
/* 1880 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(80);
/* 1881 */       this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 1882 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
/* 1883 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(80);
/* 1884 */       this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
/* 1885 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */     } 
/* 1887 */     contar();
/* 1888 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 1892 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 1893 */     if (ind < 0) {
/* 1894 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cotización para poder cancelarla", "Selecciona una cotización", 0, this.ADVER);
/*      */     } else {
/* 1896 */       String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 6));
/* 1897 */       if (!estatus.contains("<Por Autorizar>")) {
/* 1898 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar la cotización porque su estatus es: '" + String.valueOf(this.rSTableMetro1.getValueAt(ind, 6)) + "'", "No se puede cancelar", 0, this.ERROR);
/*      */       } else {
/* 1900 */         this.jTextArea5.setText("");
/* 1901 */         this.jDialog5.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 1907 */     String[] datos = { "FOIO", "FECHA", "SUCURSAL", "CLIENTE", "CONCEPTOS", "CONTACTO", "ESTATUS", "DOCUMENTO" };
/* 1908 */     this.esc = new EscribirReporte("COTIZACIONES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1912 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 1916 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1920 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1924 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 1928 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 1932 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 1936 */     if (this.jComboBox7.getItemCount() > 0 && this.PRIMERA == true) {
/* 1937 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel108MouseClicked(MouseEvent evt) {
/* 1942 */     Calendar fecha = this.jDateChooser4.getCalendar();
/* 1943 */     int aa = fecha.get(1);
/* 1944 */     int mm = fecha.get(2);
/* 1945 */     int dd = fecha.get(5);
/* 1946 */     if (dd == 1) {
/* 1947 */       if (mm == 0) {
/* 1948 */         mm = 11;
/* 1949 */         aa--;
/*      */       } else {
/* 1951 */         mm--;
/*      */       } 
/* 1953 */       int diasTotal = diasDelMes(mm, aa);
/* 1954 */       dd = diasTotal;
/*      */     } else {
/* 1956 */       dd--;
/*      */     } 
/* 1958 */     mm++;
/* 1959 */     String año = "" + aa;
/* 1960 */     String mes = "" + mm;
/* 1961 */     String dia = "" + dd;
/* 1962 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1963 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1965 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 1966 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 1967 */     } catch (ParseException ex) {
/* 1968 */       ex.printStackTrace();
/*      */     } 
/* 1970 */     consultar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel108MouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel108MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 1984 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1985 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1986 */     consultar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel110MouseClicked(MouseEvent evt) {
/* 2000 */     Calendar calendar = this.jDateChooser4.getCalendar();
/* 2001 */     calendar.setTime(this.jDateChooser4.getDate());
/* 2002 */     calendar.add(6, 1);
/* 2003 */     this.jDateChooser4.setCalendar(calendar);
/* 2004 */     this.jDateChooser5.setCalendar(calendar);
/*      */     
/* 2006 */     consultar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel110MouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel110MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField7FocusLost(FocusEvent evt) {
/* 2020 */     if (!this.jTextField7.getText().equals("") && 
/* 2021 */       this.com_Clientes.itemExists(this.jTextField7.getText())) {
/* 2022 */       int indice = this.TODOS_CLIENTES.indexOf(this.jTextField7.getText());
/* 2023 */       if (this.jTextField9.getText().equals("") || this.TODOS_DOMICILIOS.contains(this.jTextField9.getText())) {
/* 2024 */         this.jTextField9.setText(this.clientes[indice].getDireccion());
/*      */       }
/* 2026 */       if (this.jTextField10.getText().equals("") || this.TODOS_CIUDAD.contains(this.jTextField10.getText())) {
/* 2027 */         this.jTextField10.setText(this.clientes[indice].getCiudad());
/*      */       }
/* 2029 */       this.encontrado = this.con.consultar("contacto", "cotizaciones", "where cliente = '" + this.jTextField7.getText() + "' order by num_coti desc");
/* 2030 */       if (this.encontrado) {
/* 2031 */         this.jTextField11.setText(this.con.Campo);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2038 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 2042 */     this.jButton4.setText("Agregar");
/* 2043 */     this.jButton4.setMnemonic('A');
/* 2044 */     this.jButton4.setToolTipText("Agregar Concepto (Alt+A)");
/* 2045 */     this.jDialog2.setTitle("Nuevo concepto");
/* 2046 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2047 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 2048 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2049 */     this.jTextField12.setText("");
/* 2050 */     this.jTextField14.setText("");
/* 2051 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField2ActionPerformed(ActionEvent evt) {
/* 2055 */     agregarConcepto();
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1ActionPerformed(ActionEvent evt) {
/* 2059 */     agregarConcepto();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 2067 */     agregarConcepto();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2071 */     int ind = this.jTable1.getSelectedRow();
/* 2072 */     if (ind < 0) {
/* 2073 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona una partida", 0, this.ADVER);
/*      */     } else {
/* 2075 */       DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 2076 */       temp.removeRow(ind);
/* 2077 */       contar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField12ActionPerformed(ActionEvent evt) {
/* 2082 */     agregarConcepto();
/*      */   }
/*      */   
/*      */   private void jTextField14ActionPerformed(ActionEvent evt) {
/* 2086 */     agregarConcepto();
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2090 */     int ind = this.jTable1.getSelectedRow();
/* 2091 */     if (ind < 0) {
/* 2092 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona una partida", 0, this.ADVER);
/*      */     } else {
/* 2094 */       this.jTextField12.setEnabled(false);
/* 2095 */       String valor = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 2096 */       this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(valor)));
/* 2097 */       this.jTextField14.setText(this.jTable1.getValueAt(ind, 2).toString());
/* 2098 */       valor = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3));
/* 2099 */       String valorP = "";
/* 2100 */       for (int i = 0; i < valor.length(); i++) {
/* 2101 */         if (valor.charAt(i) != '$' && valor.charAt(i) != ',') {
/* 2102 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2105 */       this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(valorP)));
/* 2106 */       this.jTextField12.setText(this.jTable1.getValueAt(ind, 1).toString());
/* 2107 */       this.jTextField12.setEnabled(true);
/*      */       
/* 2109 */       this.jButton4.setText("Modificar");
/* 2110 */       this.jButton4.setMnemonic('M');
/* 2111 */       this.jButton4.setToolTipText("Modificar Concepto (Alt+M)");
/* 2112 */       this.jDialog2.setTitle("Modificar concepto");
/* 2113 */       this.jDialog2.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2118 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2122 */     this.jTextField16.setText("");
/* 2123 */     this.jButton16.setText("Agregar");
/* 2124 */     this.jButton16.setMnemonic('A');
/* 2125 */     this.jButton16.setToolTipText("Agregar Concepto (Alt+A)");
/* 2126 */     this.jDialog4.setTitle("Nuevo término");
/* 2127 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2131 */     int ind = this.jTable4.getSelectedRow();
/* 2132 */     if (ind < 0) {
/* 2133 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona un término", 0, this.ADVER);
/*      */     } else {
/* 2135 */       this.jButton16.setText("Modificar");
/* 2136 */       this.jButton16.setMnemonic('M');
/* 2137 */       this.jButton16.setToolTipText("Modificar Concepto (Alt+M)");
/* 2138 */       this.jDialog4.setTitle("Modificar término");
/* 2139 */       this.jTextField16.setText(this.jTable4.getValueAt(ind, 1).toString());
/* 2140 */       this.jDialog4.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2145 */     int ind = this.jTable4.getSelectedRow();
/* 2146 */     if (ind < 0) {
/* 2147 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 2149 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas eliminar el término que seleccionaste?", "Eliminar termino", 0, 3, this.PREG);
/* 2150 */       if (res == 0) {
/* 2151 */         this.con.eliminar2("cotizaciones_terminos", "where termino ='" + String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1)) + "'");
/* 2152 */         this.jTable5 = new JTable(this.jTable4.getRowCount(), 2); int i;
/* 2153 */         for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2154 */           this.jTable5.setValueAt(this.jTable4.getValueAt(i, 0), i, 0);
/* 2155 */           this.jTable5.setValueAt(this.jTable4.getValueAt(i, 1), i, 1);
/*      */         } 
/* 2157 */         this.jScrollPane5.setViewportView(this.jTable4);
/* 2158 */         consultarTerminos();
/* 2159 */         for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2160 */           Object valor = this.jTable5.getValueAt(i, 1);
/* 2161 */           Object act = this.jTable5.getValueAt(i, 0);
/*      */           
/* 2163 */           for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 2164 */             Object comp = this.jTable4.getValueAt(j, 1);
/* 2165 */             if (comp.equals(valor)) {
/* 2166 */               this.jTable4.setValueAt(act, j, 0);
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2176 */     if (!this.entraTermino) {
/* 2177 */       this.entraTermino = true;
/* 2178 */       String[] campos = this.con.regresaColIndex("termino", "cotizaciones_terminos", " order by termino");
/* 2179 */       for (String v : campos) {
/* 2180 */         this.COT_TERMINOS.add(v);
/*      */       }
/*      */       
/* 2183 */       DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 2184 */       for (Object termino : this.COT_TERMINOS) {
/* 2185 */         Object[] nuevo = { Boolean.valueOf(false), termino };
/* 2186 */         temp.addRow(nuevo);
/*      */       } 
/*      */     } 
/*      */     int i;
/* 2190 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2191 */       this.jTable4.setValueAt(Boolean.valueOf(false), i, 0);
/*      */     }
/* 2193 */     for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2194 */       Object valor = this.jTable2.getValueAt(i, 1);
/* 2195 */       for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 2196 */         Object comp = this.jTable4.getValueAt(j, 1);
/* 2197 */         if (comp.equals(valor)) {
/* 2198 */           this.jTable4.setValueAt(Boolean.valueOf(true), j, 0);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 2204 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2208 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 2212 */     agregarTermino();
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 2216 */     this.jTable2.setFont(new Font("Cantarell", 0, 12));
/* 2217 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", "Condiciones" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2223 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */ 
/*      */           
/* 2226 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 2231 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2235 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2238 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 2239 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/* 2240 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/* 2241 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2242 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2243 */       this.jTable2.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/* 2245 */     DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 2246 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2247 */       Object v = this.jTable4.getValueAt(i, 0);
/*      */       
/* 2249 */       if (v != null && this.jTable4.getValueAt(i, 0).equals(Boolean.valueOf(true))) {
/* 2250 */         Object[] nuevo = { this.jTable4.getValueAt(i, 0), this.jTable4.getValueAt(i, 1) };
/* 2251 */         temp.addRow(nuevo);
/*      */       } 
/*      */     } 
/* 2254 */     contarTerminos();
/* 2255 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField16ActionPerformed(ActionEvent evt) {
/* 2259 */     agregarTermino();
/*      */   }
/*      */   
/*      */   private void jTextField17CaretUpdate(CaretEvent evt) {
/* 2263 */     consultarTerminos();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField15FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField13CaretUpdate(CaretEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField13FocusLost(FocusEvent evt) {
/* 2275 */     if (this.com_Personas.itemExists(this.jTextField13.getText())) {
/* 2276 */       int indice = this.TODOS_PERSONAS.indexOf(this.jTextField13.getText());
/*      */       
/* 2278 */       if (this.jTextField15.getText().equals("") || this.TODOS_PUESTOS.contains(this.jTextField15.getText())) {
/* 2279 */         this.jTextField15.setText(this.personas[indice].getPuesto());
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2285 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2286 */     if (ind < 0) {
/* 2287 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cotización para modificar los datos", "Selecciona una cotización", 0, this.ADVER);
/*      */     } else {
/* 2289 */       String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 6));
/* 2290 */       if (!estatus.contains("<Por Autorizar>")) {
/* 2291 */         JOptionPane.showMessageDialog(this.padre, "No puedes modificar la cotización porque su estatus es: '" + String.valueOf(this.rSTableMetro1.getValueAt(ind, 6)) + "'", "No se puede modificar", 0, this.ERROR);
/*      */       } else {
/* 2293 */         verCotizacion();
/* 2294 */         this.materialButton21.setVisible(false);
/* 2295 */         this.jTextField2.setEnabled(true);
/* 2296 */         this.jTextField7.setEnabled(true);
/* 2297 */         this.jTextField9.setEnabled(true);
/* 2298 */         this.jTextField10.setEnabled(true);
/* 2299 */         this.jTextField11.setEnabled(true);
/* 2300 */         this.jTextField13.setEnabled(true);
/* 2301 */         this.jTextField15.setEnabled(true);
/* 2302 */         this.jButton5.setEnabled(true);
/* 2303 */         this.jButton6.setEnabled(true);
/* 2304 */         this.jButton7.setEnabled(true);
/* 2305 */         this.jButton9.setEnabled(true);
/*      */         
/* 2307 */         this.materialButton20.setText("Modificar");
/* 2308 */         this.materialButton20.setToolTipText("Modificar Cotización (Alt+M)");
/* 2309 */         this.materialButton20.setMnemonic('M');
/* 2310 */         this.jDateChooser2.setDate(new Date());
/* 2311 */         this.jTextField8.setText(iniciales(this.USUARIO));
/* 2312 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 2318 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 2322 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 2326 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2327 */     if (ind < 0) {
/* 2328 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cotización para poder autorizarla", "Selecciona una cotización", 0, this.ADVER);
/*      */     } else {
/* 2330 */       String estatus = String.valueOf(this.rSTableMetro1.getValueAt(ind, 6));
/* 2331 */       if (!estatus.contains("<Por Autorizar>")) {
/* 2332 */         JOptionPane.showMessageDialog(this.padre, "Para autorizar una cotización debe tener estatus: '<Por Autorizar>', selecciona otra cotización", "Selecciona otra cotización", 0, this.ERROR);
/*      */       } else {
/* 2334 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas autorizar la cotización que seleccionaste?", "Autorizar Cotización", 0, 3, this.PREG);
/* 2335 */         if (res == 0) {
/* 2336 */           this.con.inserSinMsj("update cotizaciones set estatus ='<Autorizada>' where folioCoti = '" + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)) + "'");
/* 2337 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 2345 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2346 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 2347 */       String año = cadenaFecha1.substring(0, 4);
/* 2348 */       String mes = cadenaFecha1.substring(4, 6);
/* 2349 */       String dia = cadenaFecha1.substring(6, 8);
/* 2350 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */       
/* 2352 */       cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 2353 */       año = cadenaFecha1.substring(0, 4);
/* 2354 */       mes = cadenaFecha1.substring(4, 6);
/* 2355 */       dia = cadenaFecha1.substring(6, 8);
/* 2356 */       fechaCompleta = fechaCompleta + " AL " + fechaCompleta + "/" + dia + "/" + mes;
/*      */       
/* 2358 */       String cliente = "GENERAL";
/* 2359 */       if (!this.jTextField3.getText().equals("")) {
/* 2360 */         cliente = this.jTextField3.getText();
/*      */       }
/*      */ 
/*      */       
/* 2364 */       String sicret = "sicret2.jpg";
/* 2365 */       String forsis = "forsis100x.jpg";
/* 2366 */       JTable aux = crearTablaAux((JTable)this.rSTableMetro1, new Object[] { "cont", "Folio", "Fecha", "Cliente", "Contacto", "Estatus", "Documentó" });
/* 2367 */       Map<Object, Object> datos = new HashMap<>();
/* 2368 */       datos.put("sucursal", this.CONFIG[1]);
/*      */       
/* 2370 */       datos.put("periodo", fechaCompleta);
/* 2371 */       datos.put("estatus", this.jComboBox8.getSelectedItem());
/* 2372 */       datos.put("cliente", cliente.toUpperCase());
/* 2373 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 2374 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/*      */       
/* 2376 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 2377 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/CotizacionReporteGral.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 2378 */       JasperViewer visor = new JasperViewer(print, false);
/* 2379 */       visor.setTitle("Cotizaciones");
/* 2380 */       visor.setIconImage(this.iconoImprimir);
/* 2381 */       visor.setZoomRatio(0.59F);
/* 2382 */       visor.setExtendedState(6);
/* 2383 */       visor.setVisible(true);
/*      */     }
/* 2385 */     catch (JRException e) {
/* 2386 */       System.out.println(e.getMessage());
/* 2387 */       Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel31MouseClicked(MouseEvent evt) {
/* 2392 */     String valor = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6).toString();
/* 2393 */     valor = valor.substring(1, valor.length() - 1);
/* 2394 */     JOptionPane.showMessageDialog(this.jDialog1, "<html>Estos son los datos de la cancelación:<hr> <p><b>USUARIO Y FECHA:</b>" + valor + "<p><b>MOTIVO</b>: " + this.MOTIVO + "</>", "Detalles de la cancelación", 0, this.INFO);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 2399 */     imprimirCatalogoTerminos();
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 2403 */     this.jTable1.setToolTipText("<html><b>Cantidad: </b>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "<p><b>Unidad de Medida: </b>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)) + "<p><b>Descripción: </b>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2)) + "<p><b>Precio Unitario: </b>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3)) + "<p><b>Total: </b>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4)) + " </html>");
/*      */   }
/*      */   
/*      */   private void jLabel170MouseClicked(MouseEvent evt) {
/* 2407 */     Calendar fecha = this.jDateChooser4.getCalendar();
/* 2408 */     int aa = fecha.get(1);
/* 2409 */     int mm = fecha.get(2);
/* 2410 */     int dd = fecha.get(5);
/* 2411 */     if (dd == 1) {
/* 2412 */       if (mm == 0) {
/* 2413 */         mm = 11;
/* 2414 */         aa--;
/*      */       } else {
/* 2416 */         mm--;
/*      */       } 
/* 2418 */       int diasTotal = diasDelMes(mm, aa);
/* 2419 */       dd = diasTotal;
/*      */     } else {
/* 2421 */       dd--;
/*      */     } 
/* 2423 */     mm++;
/* 2424 */     String año = "" + aa;
/* 2425 */     String mes = "" + mm;
/* 2426 */     String dia = "" + dd;
/* 2427 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2428 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2430 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 2431 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 2432 */     } catch (ParseException ex) {
/* 2433 */       ex.printStackTrace();
/*      */     } 
/* 2435 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel170MouseExited(MouseEvent evt) {
/* 2439 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 2440 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel170MouseEntered(MouseEvent evt) {
/* 2444 */     this.jLabel170.setForeground(new Color(153, 255, 153));
/* 2445 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseClicked(MouseEvent evt) {
/* 2449 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2450 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2451 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel101MouseExited(MouseEvent evt) {
/* 2455 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 2456 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseEntered(MouseEvent evt) {
/* 2460 */     this.jLabel101.setForeground(new Color(153, 255, 153));
/* 2461 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseClicked(MouseEvent evt) {
/* 2465 */     Calendar calendar = this.jDateChooser4.getCalendar();
/* 2466 */     calendar.setTime(this.jDateChooser4.getDate());
/* 2467 */     calendar.add(6, 1);
/* 2468 */     this.jDateChooser4.setCalendar(calendar);
/* 2469 */     this.jDateChooser5.setCalendar(calendar);
/* 2470 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel171MouseExited(MouseEvent evt) {
/* 2474 */     this.jLabel171.setForeground(new Color(15, 87, 51));
/* 2475 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseEntered(MouseEvent evt) {
/* 2479 */     this.jLabel171.setForeground(new Color(153, 255, 153));
/* 2480 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2484 */     if (evt.getClickCount() == 2) {
/* 2485 */       verCotizacion();
/* 2486 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 2496 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 2500 */     if (this.materialButton20.getText().equals("Imprimir")) {
/* 2501 */       imprimirCotizacion();
/*      */     } else {
/* 2503 */       guardarCotizacion();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 2508 */     verCotizacionModificar();
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux(JTable Original, Object[] columnas) {
/* 2512 */     Object[] Columnas = columnas;
/* 2513 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount()];
/* 2514 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 2515 */       registros[i][0] = Integer.valueOf(i + 1);
/* 2516 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 2517 */         if (j == 0) {
/* 2518 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 2520 */         if (j == 1) {
/* 2521 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 2523 */         if (j == 3) {
/* 2524 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 2526 */         if (j == 4) {
/* 2527 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 2529 */         if (j == 6) {
/* 2530 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 2532 */         if (j == 7) {
/* 2533 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/*      */       } 
/*      */     } 
/* 2537 */     JTable aux = new JTable(registros, Columnas);
/* 2538 */     return aux;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 2542 */     String motivo = this.jTextArea5.getText();
/* 2543 */     if (motivo.equals("")) {
/* 2544 */       this.jTextArea5.setBackground(Color.RED);
/* 2545 */       JOptionPane.showMessageDialog(this.jDialog5, "Necesitas colocar el motivo de cancelación de la cotización", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 2547 */       int res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Estás seguro que deseas cancelar la cotización que seleccionaste?", "Cancelar Cotización", 0, 3, this.PREG);
/* 2548 */       if (res == 0) {
/* 2549 */         String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 2550 */         this.con.inserSinMsj("update cotizaciones set estatus='<Cancelada:" + this.USUARIO + " " + cargarFechaHoy() + ">', motivo ='" + this.jTextArea5.getText().toUpperCase() + "' where folioCoti='" + num + "'");
/* 2551 */         this.mensajeTry.guardarConf("Se canceló una cotización, USUARIO: " + this.USUARIO, "Cotización Cancelada (" + num + ")", "ERROR", "Facturacion");
/* 2552 */         consultar();
/* 2553 */         this.jDialog5.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public JTable crearTablaAuxCotizacion(JTable Original, JTable Terminos, Object[] columnas) {
/* 2559 */     int AumentarLineas = 3;
/* 2560 */     Object[] Columnas = columnas;
/* 2561 */     Object[][] registros = new Object[Original.getRowCount() + Terminos.getRowCount() + AumentarLineas][Original.getColumnCount()];
/* 2562 */     for (int i = 0; i < registros.length; i++) {
/* 2563 */       for (int k = 0; k < (registros[i]).length; k++) {
/* 2564 */         registros[i][k] = "";
/*      */       }
/*      */     } 
/* 2567 */     int cont = 0; int j;
/* 2568 */     for (j = 0; j < Original.getRowCount(); j++) {
/* 2569 */       registros[j][0] = Original.getValueAt(j, 0);
/* 2570 */       registros[j][1] = Original.getValueAt(j, 1);
/* 2571 */       registros[j][2] = Original.getValueAt(j, 2);
/* 2572 */       registros[j][3] = Original.getValueAt(j, 3);
/* 2573 */       registros[j][4] = Original.getValueAt(j, 4);
/* 2574 */       cont++;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2580 */     for (j = 0; j < AumentarLineas - 2; j++) {
/* 2581 */       cont++;
/*      */     }
/*      */     
/* 2584 */     registros[cont][0] = "TÉRMINOS, CONDICIONES Y CONSIDERACIONES:";
/* 2585 */     cont++;
/* 2586 */     cont++;
/*      */     
/* 2588 */     for (j = 0; j < Terminos.getRowCount(); j++) {
/* 2589 */       registros[cont][0] = "" + j + 1 + ".- " + j + 1;
/* 2590 */       cont++;
/*      */     } 
/* 2592 */     JTable aux = new JTable(registros, Columnas);
/* 2593 */     return aux;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 2597 */     Calendar ahoraCal = Calendar.getInstance();
/* 2598 */     ahoraCal.setTime(this.fecha);
/* 2599 */     String mesesito = "";
/* 2600 */     String hoy = "";
/* 2601 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 2602 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 2604 */     if (ahoraCal.get(2) + 1 < 10) {
/* 2605 */       mesesito = "0" + mesesito;
/*      */     }
/* 2607 */     if (ahoraCal.get(5) < 10) {
/* 2608 */       hoy = "0" + hoy;
/*      */     }
/* 2610 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void guardarCotizacion() {
/* 2614 */     if (this.materialButton20.getText().equals("Imprimir")) {
/* 2615 */       imprimirCotizacion();
/*      */     }
/* 2617 */     else if (this.jTextField2.getText().equals("")) {
/* 2618 */       this.jTextField2.setBackground(Color.RED);
/* 2619 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar la SUCURSAL de la cotización", "Coloca la sucursal", 0, this.ADVER);
/* 2620 */     } else if (this.jTextField6.getText().equals("")) {
/* 2621 */       this.jTextField6.setBackground(Color.RED);
/* 2622 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar el FOLIO de la cotización", "Coloca el folio", 0, this.ADVER);
/* 2623 */     } else if (this.jTextField7.getText().equals("") && this.jTextField11.getText().equals("")) {
/* 2624 */       this.jTextField7.setBackground(Color.RED);
/* 2625 */       this.jTextField11.setBackground(Color.RED);
/* 2626 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar información de cliente, no puedes dejar ambos campos vacíos", "Coloca el cliente", 0, this.ADVER);
/* 2627 */     } else if (this.jTable1.getRowCount() < 1) {
/* 2628 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar información de los conceptos, por lo menos debes coloar 1.", "Coloca los conceptos", 0, this.ADVER);
/* 2629 */     } else if (this.jTable2.getRowCount() < 1) {
/* 2630 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar información de los Términos y Condiciones, por lo menos debes coloar 1.", "Coloca los términos", 0, this.ADVER);
/* 2631 */     } else if (this.jTextField13.getText().equals("")) {
/* 2632 */       this.jTextField13.setBackground(Color.RED);
/* 2633 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar la persona que firmará la cotización", "Coloca el responsable", 0, this.ADVER);
/* 2634 */     } else if (this.jTextField15.getText().equals("")) {
/* 2635 */       this.jTextField15.setBackground(Color.RED);
/* 2636 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar el puesto de la persona que firmará la cotización", "Coloca el puesto", 0, this.ADVER);
/*      */     } else {
/* 2638 */       this.encontrado = this.con.consultar("folioCoti", "cotizaciones", "where folioCoti='" + this.jTextField6.getText() + "'");
/* 2639 */       if (this.encontrado && this.materialButton20.getText().equals("Guardar")) {
/* 2640 */         this.jTextField6.setBackground(Color.RED);
/* 2641 */         JOptionPane.showMessageDialog(this.jDialog1, "El folio que ingresaste ya existe, por favor ingresa otro.", "Folio duplicado", 0, this.ADVER);
/* 2642 */       } else if (this.materialButton20.getText().equals("Guardar")) {
/* 2643 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas generar la nueva cotización?", "Guardar Cotización", 0, 3, this.PREG);
/* 2644 */         if (res == 0) {
/* 2645 */           String descripcion = "";
/* 2646 */           String contenido = ""; int i;
/* 2647 */           for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2648 */             contenido = contenido + "('" + contenido + "','" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "')";
/* 2649 */             descripcion = descripcion + descripcion + " / ";
/* 2650 */             if (i + 1 < this.jTable1.getRowCount()) {
/* 2651 */               contenido = contenido + ",";
/*      */             }
/*      */           } 
/* 2654 */           this.con.inserSinMsj("insert into cotizaciones_conceptos(cant,medida,descripcion,pUnitario,pTotal,folioCoti) values " + contenido);
/* 2655 */           contenido = "";
/* 2656 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2657 */             contenido = contenido + "('" + contenido + "','" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "')";
/* 2658 */             if (i + 1 < this.jTable2.getRowCount()) {
/* 2659 */               contenido = contenido + ",";
/*      */             }
/*      */           } 
/* 2662 */           this.con.inserSinMsj("insert into cotizaciones_terminos_cat(termino,folioCoti) values " + contenido);
/* 2663 */           this.con.inserSinMsj("insert into cotizaciones (folioCoti, fecha, sucursal, cliente, domicilio, ciudad, contacto, estatus, motivo, descripcion, nombre, puesto, documento) values ('" + this.jTextField6.getText().toUpperCase() + "', now(), '" + this.jTextField2.getText().toUpperCase() + "','" + this.jTextField7.getText().toUpperCase() + "','" + this.jTextField9.getText().toUpperCase() + "','" + this.jTextField10.getText().toUpperCase() + "','" + this.jTextField11.getText().toUpperCase() + "','<Por Autorizar>', '', '" + descripcion + "', '" + this.jTextField13.getText().toUpperCase() + "', '" + this.jTextField15.getText().toUpperCase() + "', '" + this.USUARIO + "')");
/*      */           
/* 2665 */           imprimirCotizacion();
/* 2666 */           this.mensajeTry.guardarConf("Se ha creado una nueva Cotización, usuario: " + this.USUARIO, "Nueva Cotización (" + this.jTextField6.getText().toUpperCase() + ")", "INFO", "Facturacion");
/* 2667 */           consultar();
/* 2668 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } else {
/* 2671 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html>¿Estás seguro que deseas modificar la cotización: <b>" + this.jTextField6.getText().toUpperCase() + "</b> ?</html>", "Guardar Cotización", 0, 3, this.PREG);
/* 2672 */         if (res == 0) {
/* 2673 */           this.con.inserSinMsj("delete from cotizaciones_conceptos where folioCoti='" + this.jTextField6.getText() + "'");
/* 2674 */           this.con.inserSinMsj("delete from cotizaciones_terminos_cat where folioCoti='" + this.jTextField6.getText() + "'");
/* 2675 */           String descripcion = "";
/* 2676 */           String contenido = ""; int i;
/* 2677 */           for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2678 */             contenido = contenido + "('" + contenido + "','" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "')";
/* 2679 */             if (i + 1 < this.jTable1.getRowCount()) {
/* 2680 */               contenido = contenido + ",";
/*      */             }
/* 2682 */             descripcion = descripcion + descripcion + " / ";
/*      */           } 
/* 2684 */           this.con.inserSinMsj("insert into cotizaciones_conceptos(cant,medida,descripcion,pUnitario,pTotal,folioCoti) values " + contenido);
/*      */           
/* 2686 */           contenido = "";
/* 2687 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2688 */             contenido = contenido + "('" + contenido + "','" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "')";
/* 2689 */             if (i + 1 < this.jTable2.getRowCount()) {
/* 2690 */               contenido = contenido + ",";
/*      */             }
/*      */           } 
/* 2693 */           this.con.inserSinMsj("insert into cotizaciones_terminos_cat(termino,folioCoti) values " + contenido);
/* 2694 */           this.con.inserSinMsj("update cotizaciones set fecha=now(), sucursal='" + this.jTextField2.getText().toUpperCase() + "', cliente ='" + this.jTextField7.getText().toUpperCase() + "', domicilio='" + this.jTextField9.getText().toUpperCase() + "', ciudad='" + this.jTextField10.getText().toUpperCase() + "', contacto='" + this.jTextField11.getText().toUpperCase() + "', descripcion='" + descripcion + "',nombre='" + this.jTextField13.getText().toUpperCase() + "', puesto='" + this.jTextField15.getText().toUpperCase() + "', documento='" + this.USUARIO + "' where folioCoti='" + this.jTextField6.getText().toUpperCase() + "'");
/* 2695 */           imprimirCotizacion();
/* 2696 */           this.mensajeTry.guardarConf("Se ha modificado una Cotización, usuario: " + this.USUARIO, "Cotización Modificada(" + this.jTextField6.getText().toUpperCase() + ")", "INFO", "Facturacion");
/* 2697 */           consultar();
/* 2698 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verCotizacion() {
/* 2705 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2706 */     if (ind < 0) {
/* 2707 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cotización para ver los datos", "Selecciona una cotización", 0, this.ADVER);
/*      */     } else {
/* 2709 */       this.jDialog1.setTitle("Detalle de cotización con folio: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 2710 */       this.materialButton21.setVisible(true);
/* 2711 */       this.jLabel31.setVisible(false);
/* 2712 */       this.jTextField2.setEnabled(false);
/* 2713 */       this.jTextField6.setEnabled(false);
/* 2714 */       this.jTextField7.setEnabled(false);
/* 2715 */       this.jTextField9.setEnabled(false);
/* 2716 */       this.jTextField10.setEnabled(false);
/* 2717 */       this.jTextField11.setEnabled(false);
/* 2718 */       this.jTextField13.setEnabled(false);
/* 2719 */       this.jTextField15.setEnabled(false);
/* 2720 */       this.jButton5.setEnabled(false);
/* 2721 */       this.jButton6.setEnabled(false);
/* 2722 */       this.jButton7.setEnabled(false);
/* 2723 */       this.jButton9.setEnabled(false);
/*      */       
/* 2725 */       this.materialButton20.setText("Imprimir");
/* 2726 */       this.jTextField2.setText(this.rSTableMetro1.getValueAt(ind, 2).toString());
/* 2727 */       this.jTextField6.setText(this.rSTableMetro1.getValueAt(ind, 0).toString());
/*      */       
/* 2729 */       String FECHA = String.valueOf(this.rSTableMetro1.getValueAt(ind, 1));
/* 2730 */       String año = FECHA.substring(0, 4);
/* 2731 */       String mes = FECHA.substring(5, 7);
/* 2732 */       String dia = FECHA.substring(8, 10);
/* 2733 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2734 */       String strFecha = año + "-" + año + "-" + mes;
/* 2735 */       Date fecha = null;
/*      */       try {
/* 2737 */         fecha = formatoDelTexto.parse(strFecha);
/* 2738 */       } catch (ParseException ex) {
/* 2739 */         ex.printStackTrace();
/*      */       } 
/* 2741 */       this.jDateChooser2.setDate(fecha);
/*      */       
/* 2743 */       this.jTextField8.setText(iniciales(this.rSTableMetro1.getValueAt(ind, 7).toString()));
/* 2744 */       this.jTextField7.setText(this.rSTableMetro1.getValueAt(ind, 3).toString());
/* 2745 */       this.jTextField11.setText(this.rSTableMetro1.getValueAt(ind, 4).toString());
/*      */       
/* 2747 */       this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2748 */             .buscarDatos(5, "cant,medida,descripcion,pUnitario, pTotal", "cotizaciones_conceptos", "where folioCoti = '" + this.rSTableMetro1.getValueAt(ind, 0).toString() + "' order by numConcepto asc"), (Object[])new String[] { "Cantidad", "U de Medida", "Descripción", "P Unitario", "Total" })
/*      */           {
/*      */ 
/*      */             
/* 2752 */             boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2757 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 2760 */       this.jTable1.setSelectionMode(0);
/* 2761 */       this.jTable1.setAutoCreateRowSorter(true);
/* 2762 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 2764 */       if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/* 2765 */         this.jTable1.getColumnModel().getColumn(0).setMinWidth(80);
/* 2766 */         this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 2767 */         this.jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
/* 2768 */         this.jTable1.getColumnModel().getColumn(1).setMinWidth(80);
/* 2769 */         this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 2770 */         this.jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
/* 2771 */         this.jTable1.getColumnModel().getColumn(3).setMinWidth(80);
/* 2772 */         this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 2773 */         this.jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
/* 2774 */         this.jTable1.getColumnModel().getColumn(4).setMinWidth(80);
/* 2775 */         this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
/* 2776 */         this.jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */       } 
/* 2778 */       this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2779 */       this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2780 */       this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*      */       
/* 2782 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 2783 */             .buscarDatos(1, "termino", "cotizaciones_terminos_cat", "where folioCoti = '" + this.rSTableMetro1.getValueAt(ind, 0).toString() + "' order by termino asc"), (Object[])new String[] { "Término", "" })
/*      */           {
/*      */ 
/*      */             
/* 2787 */             Class[] types = new Class[] { Object.class, Boolean.class };
/*      */ 
/*      */             
/* 2790 */             boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public Class getColumnClass(int columnIndex) {
/* 2795 */               return this.types[columnIndex];
/*      */             }
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2799 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 2802 */       this.jTable2.moveColumn(0, 1);
/*      */       
/* 2804 */       this.jTable2.setSelectionMode(0);
/* 2805 */       this.jTable2.setAutoCreateRowSorter(true);
/* 2806 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 2808 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2809 */         this.jTable2.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/* 2811 */       if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/* 2812 */         this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/* 2813 */         this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2814 */         this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2815 */         this.jTable2.getColumnModel().getColumn(1).setResizable(false);
/*      */       } 
/* 2817 */       String[] datos = this.con.regresaReg("nombre,puesto,motivo,domicilio,ciudad", "cotizaciones", "where folioCoti = '" + this.rSTableMetro1.getValueAt(ind, 0).toString() + "'", 5);
/* 2818 */       this.jTextField13.setText(datos[0]);
/* 2819 */       this.jTextField15.setText(datos[1]);
/* 2820 */       this.MOTIVO = datos[2];
/* 2821 */       if (!datos[2].equals("")) {
/* 2822 */         String valor = "";
/* 2823 */         if (this.rSTableMetro1.getValueAt(ind, 6).toString().contains("Cancelada")) {
/* 2824 */           valor = "CANCELADA: (CLICK PARA VER LOS DETALLES DE LA CANCELACIÓN)";
/*      */         }
/* 2826 */         this.jLabel31.setText(valor);
/* 2827 */         this.jLabel31.setVisible(true);
/*      */       } 
/*      */       
/* 2830 */       this.jTextField9.setText(datos[3]);
/* 2831 */       this.jTextField10.setText(datos[4]);
/* 2832 */       contar();
/* 2833 */       contarTerminos();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verCotizacionModificar() {
/* 2838 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2839 */     if (ind < 0) {
/* 2840 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cotización para modificar los datos", "Selecciona una cotización", 0, this.ADVER);
/*      */     } else {
/* 2842 */       this.materialButton21.setVisible(false);
/* 2843 */       this.jLabel31.setVisible(false);
/* 2844 */       this.jTextField2.setEnabled(true);
/* 2845 */       this.jTextField6.setEnabled(true);
/* 2846 */       this.jTextField7.setEnabled(true);
/* 2847 */       this.jTextField9.setEnabled(true);
/* 2848 */       this.jTextField10.setEnabled(true);
/* 2849 */       this.jTextField11.setEnabled(true);
/* 2850 */       this.jTextField13.setEnabled(true);
/* 2851 */       this.jTextField15.setEnabled(true);
/* 2852 */       this.jButton5.setEnabled(true);
/* 2853 */       this.jButton6.setEnabled(true);
/* 2854 */       this.jButton7.setEnabled(true);
/* 2855 */       this.jButton9.setEnabled(true);
/* 2856 */       sacarMayor();
/* 2857 */       this.materialButton20.setText("Guardar");
/* 2858 */       this.materialButton20.setToolTipText("Guardar Cotización (Alt+G)");
/* 2859 */       this.materialButton20.setMnemonic('G');
/* 2860 */       this.jDateChooser2.setDate(new Date());
/* 2861 */       this.jTextField8.setText(iniciales(this.USUARIO));
/* 2862 */       this.jDialog1.setTitle("Crear cotizaciones");
/* 2863 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirCotizacion() {
/*      */     try {
/* 2869 */       Map<Object, Object> datos = new HashMap<>();
/* 2870 */       String forsis = "/Reportes/Imagenes/forsis100x.jpg";
/* 2871 */       datos.put("sucursal", this.jTextField2.getText());
/* 2872 */       datos.put("folio", this.jTextField6.getText());
/*      */       
/* 2874 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2875 */       String cadenaFecha2 = formato.format(this.jDateChooser2.getDate());
/* 2876 */       String año = cadenaFecha2.substring(0, 4);
/* 2877 */       String mes = cadenaFecha2.substring(4, 6);
/* 2878 */       String dia = cadenaFecha2.substring(6, 8);
/* 2879 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/* 2880 */       datos.put("fecha", fechaCompleta);
/* 2881 */       datos.put("documento", this.jTextField8.getText().toUpperCase());
/* 2882 */       datos.put("cliente", this.jTextField7.getText().toUpperCase());
/* 2883 */       datos.put("domicilio", this.jTextField9.getText().toUpperCase());
/* 2884 */       datos.put("ciudad", this.jTextField10.getText().toUpperCase());
/* 2885 */       datos.put("contacto", this.jTextField11.getText().toUpperCase());
/* 2886 */       datos.put("persona", this.jTextField13.getText().toUpperCase());
/* 2887 */       datos.put("puesto", this.jTextField15.getText().toUpperCase());
/* 2888 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/*      */       
/* 2890 */       JTable aux = crearTablaAuxCotizacion(this.jTable1, this.jTable2, new Object[] { "Cantidad", "U de Medida", "Descripción", "P Unitario", "Total" });
/* 2891 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 2892 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/Cotizacion.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 2893 */       this.jDialog1.setVisible(false);
/* 2894 */       JasperViewer visor = new JasperViewer(print, false);
/* 2895 */       visor.setTitle("Cotización " + this.jTextField6.getText().toUpperCase());
/* 2896 */       visor.setIconImage(this.iconoImprimir);
/* 2897 */       visor.setZoomRatio(0.59F);
/* 2898 */       visor.setExtendedState(6);
/* 2899 */       visor.setVisible(true);
/* 2900 */     } catch (JRException e) {
/* 2901 */       System.out.println(e.getMessage());
/* 2902 */       Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirCatalogoTerminos() {
/*      */     try {
/* 2908 */       Map<Object, Object> datos = new HashMap<>();
/* 2909 */       String sicret = "/Reportes/Imagenes/sicret2.jpg";
/* 2910 */       String forsis = "/Reportes/Imagenes/forsis100x.jpg";
/* 2911 */       datos.put("usuario", this.USUARIO);
/* 2912 */       datos.put("total", Integer.valueOf(this.jTable4.getRowCount()));
/*      */       
/* 2914 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 2915 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 2916 */       String[][] matriz = new String[this.jTable4.getRowCount()][2];
/* 2917 */       for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2918 */         matriz[i][0] = "" + i + 1;
/* 2919 */         matriz[i][1] = this.jTable4.getValueAt(i, 1).toString();
/*      */       } 
/* 2921 */       JTable Aux = new JTable((Object[][])matriz, (Object[])new String[] { "cont", "descripcion" });
/* 2922 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(Aux.getModel());
/* 2923 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/Cotizacion_reporte_terminos.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 2924 */       JasperViewer visor = new JasperViewer(print, false);
/* 2925 */       visor.setTitle("Catálogo de términos y condiciones ");
/* 2926 */       visor.setIconImage(this.iconoImprimir);
/* 2927 */       visor.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
/* 2928 */       visor.setVisible(true);
/*      */     }
/* 2930 */     catch (JRException e) {
/* 2931 */       System.out.println(e.getMessage());
/* 2932 */       Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void limpiarTabla() {
/* 2937 */     this.jTable4.setFont(new Font("Cantarell", 0, 10));
/* 2938 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", "Término" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2944 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */ 
/*      */ 
/*      */           
/* 2948 */           boolean[] canEdit = new boolean[] { true, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 2953 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2957 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2960 */     this.jScrollPane5.setViewportView(this.jTable4);
/* 2961 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/* 2962 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(50);
/* 2963 */       this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2964 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2965 */       this.jTable4.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void limpiarCotizacion() {
/* 2970 */     this.jTextField7.setText("");
/* 2971 */     this.jTextField9.setText("");
/* 2972 */     this.jTextField10.setText("");
/* 2973 */     this.jTextField11.setText("");
/* 2974 */     this.jTextField13.setText("");
/* 2975 */     this.jTextField15.setText("");
/*      */     
/* 2977 */     this.jTextField13.setEnabled(true);
/* 2978 */     this.jTextField15.setEnabled(true);
/* 2979 */     this.jTextField2.setEnabled(true);
/* 2980 */     this.jTextField6.setEnabled(true);
/* 2981 */     this.jTextField7.setEnabled(true);
/* 2982 */     this.jTextField9.setEnabled(true);
/* 2983 */     this.jTextField10.setEnabled(true);
/* 2984 */     this.jTextField11.setEnabled(true);
/* 2985 */     this.jButton5.setEnabled(true);
/* 2986 */     this.jButton6.setEnabled(true);
/* 2987 */     this.jButton7.setEnabled(true);
/* 2988 */     this.jButton9.setEnabled(true);
/* 2989 */     this.materialButton21.setVisible(false);
/* 2990 */     this.jLabel31.setVisible(false);
/*      */     
/* 2992 */     this.jTable2.setFont(new Font("Cantarell", 0, 12));
/* 2993 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", "Condiciones" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2999 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */ 
/*      */ 
/*      */           
/* 3003 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3008 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3012 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3015 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 3016 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/* 3017 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/* 3018 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3019 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 3020 */       this.jTable2.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/* 3022 */     contarTerminos();
/*      */   }
/*      */   
/*      */   public void agregarTermino() {
/* 3026 */     if (existeTermino(this.jTextField16.getText().toUpperCase())) {
/* 3027 */       this.jTextField16.setBackground(Color.RED);
/* 3028 */       JOptionPane.showMessageDialog(this.jDialog4, "El término que deseas agregar ya se encuentra almacenado, por favor verifica tu información", "Término ya existe", 0, this.ADVER);
/* 3029 */     } else if (this.jButton16.getText().equals("Agregar")) {
/* 3030 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas agregar nuevo termino?", "Agregar nuevo termino", 0, 3, this.PREG);
/* 3031 */       if (res == 0) {
/* 3032 */         this.con.inserSinMsj("insert into cotizaciones_terminos (termino) values('" + this.jTextField16.getText().toUpperCase() + "')");
/* 3033 */         this.jTable5 = new JTable(this.jTable4.getRowCount(), 2); int i;
/* 3034 */         for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3035 */           this.jTable5.setValueAt(this.jTable4.getValueAt(i, 0), i, 0);
/* 3036 */           this.jTable5.setValueAt(this.jTable4.getValueAt(i, 1), i, 1);
/*      */         } 
/*      */         
/* 3039 */         this.jScrollPane5.setViewportView(this.jTable4);
/* 3040 */         consultarTerminos();
/*      */         
/* 3042 */         for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 3043 */           Object valor = this.jTable5.getValueAt(i, 1);
/* 3044 */           Object act = this.jTable5.getValueAt(i, 0);
/*      */           
/* 3046 */           for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 3047 */             Object comp = this.jTable4.getValueAt(j, 1);
/* 3048 */             if (comp.equals(valor)) {
/* 3049 */               this.jTable4.setValueAt(act, j, 0);
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 3054 */         this.jDialog4.setVisible(false);
/*      */       } 
/*      */     } else {
/* 3057 */       this.con.inserSinMsj("update cotizaciones_terminos set termino = '" + this.jTextField16.getText().toUpperCase() + "' where termino ='" + String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1)) + "'");
/* 3058 */       this.jTable4.setValueAt(this.jTextField16.getText().toUpperCase(), this.jTable4.getSelectedRow(), 1);
/*      */       
/* 3060 */       this.jTable5 = new JTable(this.jTable4.getRowCount(), 2); int i;
/* 3061 */       for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3062 */         this.jTable5.setValueAt(this.jTable4.getValueAt(i, 0), i, 0);
/* 3063 */         this.jTable5.setValueAt(this.jTable4.getValueAt(i, 1), i, 1);
/*      */       } 
/*      */       
/* 3066 */       this.jScrollPane5.setViewportView(this.jTable4);
/* 3067 */       consultarTerminos();
/*      */       
/* 3069 */       for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 3070 */         Object valor = this.jTable5.getValueAt(i, 1);
/* 3071 */         Object act = this.jTable5.getValueAt(i, 0);
/*      */         
/* 3073 */         for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 3074 */           Object comp = this.jTable4.getValueAt(j, 1);
/* 3075 */           if (comp.equals(valor)) {
/* 3076 */             this.jTable4.setValueAt(act, j, 0);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 3081 */       this.jDialog4.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean existeTermino(String buscar) {
/* 3086 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3087 */       String comp = this.jTable4.getValueAt(i, 1).toString();
/* 3088 */       if (comp.equals(buscar)) {
/* 3089 */         return true;
/*      */       }
/*      */     } 
/* 3092 */     return false;
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3096 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3098 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3102 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 3105 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3107 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3111 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 3114 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3116 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3120 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jComboBox8, evt);
/*      */           }
/*      */         });
/*      */     
/* 3124 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3126 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3130 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField3, evt);
/*      */           }
/*      */         });
/*      */     
/* 3134 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3136 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3140 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField4, evt);
/*      */           }
/*      */         });
/*      */     
/* 3144 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3146 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3150 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField5, evt);
/*      */           }
/*      */         });
/*      */     
/* 3154 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3156 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3160 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField7, evt);
/*      */           }
/*      */         });
/*      */     
/* 3164 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3166 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3170 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jComboBox7, evt);
/*      */           }
/*      */         });
/*      */     
/* 3174 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3176 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3180 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField2, evt);
/*      */           }
/*      */         });
/*      */     
/* 3184 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3186 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3190 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField6, evt);
/*      */           }
/*      */         });
/*      */     
/* 3194 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3196 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3200 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField8, evt);
/*      */           }
/*      */         });
/*      */     
/* 3204 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3206 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3210 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField16, evt);
/*      */           }
/*      */         });
/*      */     
/* 3214 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3216 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3220 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField17, evt);
/*      */           }
/*      */         });
/*      */     
/* 3224 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3226 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3230 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jComboBox7, evt);
/*      */           }
/*      */         });
/*      */     
/* 3234 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3236 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3240 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField9, evt);
/*      */           }
/*      */         });
/*      */     
/* 3244 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3246 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3250 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField10, evt);
/*      */           }
/*      */         });
/*      */     
/* 3254 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3256 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3260 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField11, evt);
/*      */           }
/*      */         });
/*      */     
/* 3264 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3266 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3270 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 3273 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3275 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3279 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 3282 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3284 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3288 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField15, evt);
/*      */           }
/*      */         });
/*      */     
/* 3292 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3294 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3298 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jTextField14, evt);
/*      */           }
/*      */         });
/*      */     
/* 3302 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3304 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3308 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 3311 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3313 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3317 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 3320 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3322 */             Cotizaciones.this.jTextGanado(Cotizaciones.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3326 */             Cotizaciones.this.jTextPerdido(Cotizaciones.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3332 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3336 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void agregarConcepto() {
/* 3340 */     String cant = this.jFormattedTextField1.getText();
/* 3341 */     String[] nombres = null;
/* 3342 */     int esp = 0;
/* 3343 */     String texto = this.jTextField14.getText(); int i;
/* 3344 */     for (i = 0; i < texto.length(); i++) {
/* 3345 */       if (texto.charAt(i) == ' ') {
/* 3346 */         esp++;
/*      */       }
/*      */     } 
/* 3349 */     nombres = new String[esp + 1];
/* 3350 */     for (i = 0; i <= esp; i++) {
/* 3351 */       nombres[i] = "";
/*      */     }
/* 3353 */     esp = 0;
/* 3354 */     for (i = 0; i < texto.length(); i++) {
/* 3355 */       if (texto.charAt(i) == ' ') {
/* 3356 */         esp++;
/*      */       } else {
/* 3358 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 3361 */     for (i = 0; i < nombres.length; i++) {
/* 3362 */       if (nombres[i].length() == 0) {
/* 3363 */         this.jTextField14.setBackground(Color.RED);
/* 3364 */         JOptionPane.showMessageDialog(this.jDialog2, "Tienes un espacio de más en la descripción de la partida", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 3369 */     if (Double.parseDouble(cant) <= 0.0D) {
/* 3370 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 3371 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/* 3372 */     } else if (this.jTextField12.getText().equals("")) {
/* 3373 */       this.jTextField12.setBackground(Color.RED);
/* 3374 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/* 3375 */     } else if (this.jTextField14.getText().equals("")) {
/* 3376 */       this.jTextField14.setBackground(Color.RED);
/* 3377 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/* 3378 */     } else if (this.jTextField14.getText().length() > 999) {
/* 3379 */       this.jTextField14.setBackground(Color.RED);
/* 3380 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar más 999 caracteres en las partidas", "Partida muy larga", 0, this.ERROR);
/* 3381 */     } else if (this.jFormattedTextField2.getText().equals("$0.00")) {
/* 3382 */       this.jFormattedTextField2.setBackground(Color.RED);
/* 3383 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     } else {
/* 3385 */       String desc = this.jTextField14.getText().toUpperCase();
/* 3386 */       String valor = String.valueOf(this.jFormattedTextField2.getValue());
/*      */       
/* 3388 */       String valorP = "";
/* 3389 */       for (int j = 0; j < valor.length(); j++) {
/* 3390 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 3391 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3394 */       double importe = Double.parseDouble(cant) * Double.parseDouble(valorP);
/* 3395 */       this.cantidad.setValue(Double.valueOf(importe));
/* 3396 */       String auxCant = this.cantidad.getText();
/* 3397 */       this.jFormattedTextField3.setValue(Double.valueOf(importe));
/*      */       
/* 3399 */       double v = Double.parseDouble(this.jFormattedTextField2.getValue().toString());
/* 3400 */       this.cantidad.setValue(Double.valueOf(v));
/*      */       
/* 3402 */       if (this.jDialog2.getTitle().equals("Modificar concepto")) {
/* 3403 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas modificar el concepto que seleccionaste?", "Modificar concepto", 0, 3, this.PREG);
/* 3404 */         if (res == 0) {
/* 3405 */           DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 3406 */           this.jTable1.setValueAt(this.jFormattedTextField1.getText(), this.jTable1.getSelectedRow(), 0);
/* 3407 */           this.jTable1.setValueAt(this.jTextField12.getText().toUpperCase(), this.jTable1.getSelectedRow(), 1);
/* 3408 */           this.jTable1.setValueAt(this.jTextField14.getText().toUpperCase(), this.jTable1.getSelectedRow(), 2);
/* 3409 */           this.jTable1.setValueAt(this.jFormattedTextField2.getText(), this.jTable1.getSelectedRow(), 3);
/* 3410 */           this.jTable1.setValueAt(this.jFormattedTextField3.getText(), this.jTable1.getSelectedRow(), 4);
/*      */           
/* 3412 */           this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 3413 */           this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 3414 */           this.jTextField14.setText("");
/* 3415 */           this.jTextField12.setText("");
/* 3416 */           this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 3417 */           this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 3418 */           this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 3419 */           this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 3420 */           this.jDialog2.setVisible(false);
/*      */         } 
/*      */       } else {
/* 3423 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 3424 */         if (res == 0) {
/* 3425 */           DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 3426 */           Object[] nuevo = { cant, this.jTextField12.getText().toUpperCase(), desc, this.cantidad.getText(), auxCant };
/* 3427 */           temp.addRow(nuevo);
/* 3428 */           this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 3429 */           this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 3430 */           this.jTextField14.setText("");
/* 3431 */           this.jTextField12.setText("");
/* 3432 */           this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 3433 */           this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 3434 */           this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 3435 */           this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 3436 */           contar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3443 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3451 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3457 */         return 30;
/*      */       
/*      */       case 1:
/* 3460 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3462 */           return 29;
/*      */         }
/* 3464 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 3468 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultarTerminos() {
/* 3473 */     this.jTable6 = this.jTable4;
/* 3474 */     for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 3475 */       System.out.println("va " + String.valueOf(this.jTable6.getValueAt(i, 0)));
/*      */     }
/*      */     
/* 3478 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 3479 */           .buscarDatos(1, "termino", "cotizaciones_terminos", "where termino like '%" + this.jTextField17.getText() + "%' order by termino"), (Object[])new String[] { "Término", "" })
/*      */         {
/*      */ 
/*      */           
/* 3483 */           Class[] types = new Class[] { Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/* 3487 */           boolean[] canEdit = new boolean[] { false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3492 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3496 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 3500 */     this.jTable4.moveColumn(0, 1);
/* 3501 */     this.jScrollPane5.setViewportView(this.jTable4);
/* 3502 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/* 3503 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(50);
/* 3504 */       this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3505 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
/* 3506 */       this.jTable4.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void Cotizaciones(String usu) {
/* 3511 */     this.USUARIO = usu;
/* 3512 */     this.jTextField8.setText(iniciales(this.USUARIO));
/* 3513 */     this.panel.setViewportView(this);
/* 3514 */     consultar();
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3518 */     this.PRIMERA = true;
/* 3519 */     boolean correcto = true;
/* 3520 */     String hora1 = "";
/* 3521 */     String hora2 = "";
/* 3522 */     if (this.jDateChooser4.getDate() == null) {
/* 3523 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 3524 */       if (res == 0) {
/* 3525 */         this.jDateChooser4.setDate(this.fechaActual);
/* 3526 */         correcto = true;
/*      */       } else {
/* 3528 */         correcto = false;
/*      */       } 
/* 3530 */     } else if (this.jDateChooser5.getDate() == null) {
/* 3531 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 3532 */       if (res == 0) {
/* 3533 */         this.jDateChooser5.setDate(this.fechaActual);
/* 3534 */         correcto = true;
/*      */       } else {
/* 3536 */         correcto = false;
/*      */       } 
/* 3538 */     } else if (correcto) {
/* 3539 */       Date fecha1 = this.jDateChooser4.getDate();
/* 3540 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 3542 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3543 */       String cadenaFecha = "";
/* 3544 */       cadenaFecha = formato.format(fecha1);
/* 3545 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3546 */       String MES = cadenaFecha.substring(4, 6);
/* 3547 */       String DIA = cadenaFecha.substring(6, 8);
/* 3548 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + " " + hora1 + "'";
/*      */       
/* 3550 */       String año = "";
/* 3551 */       String mes = "";
/* 3552 */       String dia = "";
/*      */       
/* 3554 */       cadenaFecha = formato.format(fecha2);
/* 3555 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3556 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3557 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*      */       
/* 3559 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 3560 */       cadenaFecha = "";
/* 3561 */       cadenaFecha = formato.format(fecha2);
/* 3562 */       AÑO = cadenaFecha.substring(0, 4);
/* 3563 */       MES = cadenaFecha.substring(4, 6);
/* 3564 */       DIA = cadenaFecha.substring(6, 8);
/* 3565 */       String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */       
/* 3567 */       String documento = "";
/* 3568 */       String estatus = " estatus='<Por Autorizar>' || estatus like '%<Autorizada%'";
/*      */       
/* 3570 */       if (this.jComboBox8.getSelectedIndex() == 1) {
/* 3571 */         estatus = " estatus like '%%'";
/* 3572 */       } else if (this.jComboBox8.getSelectedIndex() == 2) {
/* 3573 */         estatus = " estatus ='<Por Autorizar>'";
/* 3574 */       } else if (this.jComboBox8.getSelectedIndex() == 3) {
/* 3575 */         estatus = " estatus like '%<Autorizada%'";
/* 3576 */       } else if (this.jComboBox8.getSelectedIndex() == 4) {
/* 3577 */         estatus = " estatus like '%<Cancelada%'";
/*      */       } 
/*      */       
/* 3580 */       if (this.jComboBox7.getSelectedIndex() != 0) {
/* 3581 */         documento = String.valueOf(this.jComboBox7.getSelectedItem()) + String.valueOf(this.jComboBox7.getSelectedItem());
/*      */       }
/*      */       
/* 3584 */       String folio = "";
/* 3585 */       String cliente = "";
/* 3586 */       String contacto = "";
/* 3587 */       String conceptos = "";
/* 3588 */       if (!this.jTextField1.getText().equals(this.holderFolio)) {
/* 3589 */         folio = this.jTextField1.getText();
/*      */       }
/*      */       
/* 3592 */       if (!this.jTextField3.getText().equals(this.holderCliente)) {
/* 3593 */         cliente = this.jTextField3.getText();
/*      */       }
/*      */       
/* 3596 */       if (!this.jTextField4.getText().equals(this.holderContacto)) {
/* 3597 */         contacto = this.jTextField4.getText();
/*      */       }
/*      */       
/* 3600 */       if (!this.jTextField5.getText().equals(this.holderConceptos)) {
/* 3601 */         conceptos = this.jTextField5.getText();
/*      */       }
/*      */       
/* 3604 */       this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 3605 */             .buscarDatos(8, "folioCoti, fecha, sucursal, cliente, contacto, descripcion, estatus ,documento", "cotizaciones", "where folioCoti like '%" + folio + "%' and cliente like '%" + cliente + "%' and contacto like '%" + contacto + "%' and documento like '%" + documento + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and (" + estatus + ") and descripcion like '%" + conceptos + "%' order by num_Coti desc"), (Object[])new String[] { "Folio", "Fecha", "Sucursal", "Cliente", "Contacto", "Conceptos", "Estatus", "Documentó" })
/*      */           {
/*      */ 
/*      */             
/* 3609 */             Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */ 
/*      */             
/* 3613 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public Class getColumnClass(int columnIndex) {
/* 3618 */               return this.types[columnIndex];
/*      */             }
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3622 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */ 
/*      */       
/* 3627 */       this.celda2.pasarInd3(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Autorizar>", 0, 6, 0));
/* 3628 */       this.celda2.pasarInd5(this.con.revisarCol((JTable)this.rSTableMetro1, "<Cancelada", 0, 6, 2));
/*      */       
/* 3630 */       this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/*      */       
/* 3632 */       if (this.rSTableMetro1.getColumnModel().getColumnCount() > 0) {
/* 3633 */         this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 3634 */         this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(70);
/* 3635 */         this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(120);
/* 3636 */         this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(120);
/* 3637 */         this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 3638 */         this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(100);
/* 3639 */         this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(110);
/* 3640 */         this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(110);
/* 3641 */         this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(110);
/* 3642 */         this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(110);
/*      */       } 
/*      */ 
/*      */       
/* 3646 */       this.rSTableMetro1.setSelectionMode(0);
/* 3647 */       this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 3648 */       this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 3650 */       this.rSTableMetro1.setShowVerticalLines(true);
/*      */ 
/*      */       
/* 3653 */       this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3654 */       this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3655 */       this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3656 */       this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3657 */       this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3658 */       this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3659 */       this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3660 */       this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3661 */       this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 3666 */     this.con.consultar("max(num_coti)", "cotizaciones", "");
/* 3667 */     String mayor = this.con.Campo;
/* 3668 */     int MAYOR = 0;
/*      */     try {
/* 3670 */       MAYOR = Integer.parseInt(mayor);
/* 3671 */     } catch (NumberFormatException e) {
/* 3672 */       MAYOR = 0;
/*      */     } 
/* 3674 */     MAYOR++;
/* 3675 */     if (MAYOR < 10) {
/* 3676 */       this.jTextField6.setText(this.CONFIG[0] + "-0000" + this.CONFIG[0]);
/* 3677 */     } else if (MAYOR < 100) {
/* 3678 */       this.jTextField6.setText(this.CONFIG[0] + "-000" + this.CONFIG[0]);
/* 3679 */     } else if (MAYOR < 1000) {
/* 3680 */       this.jTextField6.setText(this.CONFIG[0] + "-00" + this.CONFIG[0]);
/* 3681 */     } else if (MAYOR < 10000) {
/* 3682 */       this.jTextField6.setText(this.CONFIG[0] + "-0" + this.CONFIG[0]);
/*      */     } else {
/* 3684 */       this.jTextField6.setText(this.CONFIG[0] + "-" + this.CONFIG[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String iniciales(String usuario) {
/* 3689 */     String iniciales = "";
/* 3690 */     String[] nombres = { ((String)this.CAMPOSGENERALES.get("empleados.nombre")).toString(), ((String)this.CAMPOSGENERALES.get("empleados.ap_pat")).toString(), ((String)this.CAMPOSGENERALES.get("empleados.ap_mat")).toString() };
/* 3691 */     iniciales = "" + nombres[0].charAt(0) + " " + nombres[0].charAt(0) + " " + nombres[1].charAt(0);
/* 3692 */     return iniciales;
/*      */   }
/*      */   
/*      */   public void contar() {
/* 3696 */     this.jLabel28.setText("" + this.jTable1.getRowCount() + " conceptos agregados.");
/*      */   }
/*      */   
/*      */   public void contarTerminos() {
/* 3700 */     this.jLabel32.setText("" + this.jTable2.getRowCount() + " términos agregados.");
/*      */   }
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 3704 */     if (!datos.contains(valor)) {
/* 3705 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void cargarPersonas() {
/* 3710 */     String[][] DATOS = this.con.buscarDatos(2, "nombre,puesto", "cotizaciones", "order by nombre");
/* 3711 */     this.personas = new Personas[DATOS.length];
/* 3712 */     for (int i = 0; i < DATOS.length; i++) {
/* 3713 */       for (int j = 0; j < (DATOS[i]).length; j++) {
/* 3714 */         this.personas[i] = new Personas(i, DATOS[i][0], DATOS[i][1]);
/*      */       }
/*      */     } 
/*      */     
/* 3718 */     for (Personas person : this.personas) {
/* 3719 */       agregarCampo(this.TODOS_PERSONAS, person.getNombre());
/* 3720 */       agregarCampo(this.TODOS_PUESTOS, person.getPuesto());
/*      */     } 
/*      */     
/* 3723 */     this.com_Personas = new TextAutoCompleter(this.jTextField13, this.TODOS_PERSONAS);
/* 3724 */     this.com_Puestos = new TextAutoCompleter(this.jTextField15, this.TODOS_PUESTOS);
/*      */   }
/*      */   
/*      */   public void cargarClientes() {
/* 3728 */     String[][] DATOS = this.con.buscarDatos(5, "empresa, calle, num, col, ciudad", "emp_generadora", "where clave_gene<>0 order by empresa");
/*      */     
/* 3730 */     this.clientes = new Clientes[DATOS.length];
/* 3731 */     int cont = 0;
/* 3732 */     for (int i = 0; i < DATOS.length; i++) {
/* 3733 */       this.clientes[i] = new Clientes(i, DATOS[i][0], DATOS[i][1] + " " + DATOS[i][1] + " " + DATOS[i][2], DATOS[i][4], "");
/* 3734 */       cont++;
/*      */     } 
/*      */     
/* 3737 */     String[] contac = this.con.regresaColIndex("distinct(contacto)", "cotizaciones", "order by contacto");
/* 3738 */     for (String c : contac) {
/* 3739 */       agregarCampo(this.TODOS_CONTACTOS, c);
/*      */     }
/* 3741 */     for (Clientes clie : this.clientes) {
/* 3742 */       agregarCampo(this.TODOS_CLIENTES, clie.getNombre());
/* 3743 */       agregarCampo(this.TODOS_DOMICILIOS, clie.getDireccion());
/* 3744 */       agregarCampo(this.TODOS_CIUDAD, clie.getCiudad());
/*      */     } 
/*      */     
/* 3747 */     this.com_Clientes = new TextAutoCompleter(this.jTextField7, this.TODOS_CLIENTES);
/* 3748 */     this.com_Domicilios = new TextAutoCompleter(this.jTextField9, this.TODOS_DOMICILIOS);
/* 3749 */     this.com_Ciudad = new TextAutoCompleter(this.jTextField10, this.TODOS_CIUDAD);
/* 3750 */     this.com_Contactos = new TextAutoCompleter(this.jTextField11, this.TODOS_CONTACTOS);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarMedida() {
/* 3755 */     String[] documento = this.con.regresaColIndex("distinct(medida)", "cotizaciones_conceptos", "order by medida");
/* 3756 */     for (String d : documento) {
/* 3757 */       this.TODOS_MEDIDAS.add(d);
/*      */     }
/* 3759 */     this.com_Medidas = new TextAutoCompleter(this.jTextField12, this.TODOS_MEDIDAS);
/*      */   }
/*      */   
/*      */   public void llenarDocumento() {
/* 3763 */     String[] documento = this.con.regresaColIndex("distinct(documento)", "cotizaciones", "order by documento");
/* 3764 */     this.jComboBox7.addItem("USUARIO");
/* 3765 */     for (String doc : documento) {
/* 3766 */       this.jComboBox7.addItem(doc);
/*      */     }
/*      */   }
/*      */   
/*      */   class Personas
/*      */   {
/* 3772 */     int ID = 0;
/*      */     String nombre;
/*      */     String puesto;
/*      */     
/*      */     public Personas(int id, String nombre, String puesto) {
/* 3777 */       this.nombre = nombre;
/* 3778 */       this.puesto = puesto;
/* 3779 */       this.ID = id;
/*      */     }
/*      */     
/*      */     public int getID() {
/* 3783 */       return this.ID;
/*      */     }
/*      */     
/*      */     public void setID(int ID) {
/* 3787 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getNombre() {
/* 3791 */       return this.nombre;
/*      */     }
/*      */     
/*      */     public void setNombre(String nombre) {
/* 3795 */       this.nombre = nombre;
/*      */     }
/*      */     
/*      */     public String getPuesto() {
/* 3799 */       return this.puesto;
/*      */     }
/*      */     
/*      */     public void setPuesto(String puesto) {
/* 3803 */       this.puesto = puesto;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class Clientes
/*      */   {
/*      */     String nombre;
/*      */     String direccion;
/*      */     String ciudad;
/*      */     String contacto;
/* 3814 */     int ID = 0;
/*      */     
/*      */     public Clientes(int ID, String nombre, String direccion, String ciudad, String contacto) {
/* 3817 */       this.nombre = nombre;
/* 3818 */       this.direccion = direccion;
/* 3819 */       this.ciudad = ciudad;
/* 3820 */       this.contacto = contacto;
/* 3821 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public void setNombre(String nombre) {
/* 3825 */       this.nombre = nombre;
/*      */     }
/*      */     
/*      */     public void setDireccion(String direccion) {
/* 3829 */       this.direccion = direccion;
/*      */     }
/*      */     
/*      */     public void setCiudad(String ciudad) {
/* 3833 */       this.ciudad = ciudad;
/*      */     }
/*      */     
/*      */     public void setContacto(String contacto) {
/* 3837 */       this.contacto = contacto;
/*      */     }
/*      */     
/*      */     public void setID(int ID) {
/* 3841 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getNombre() {
/* 3845 */       return this.nombre;
/*      */     }
/*      */     
/*      */     public String getDireccion() {
/* 3849 */       return this.direccion;
/*      */     }
/*      */     
/*      */     public String getCiudad() {
/* 3853 */       return this.ciudad;
/*      */     }
/*      */     
/*      */     public String getContacto() {
/* 3857 */       return this.contacto;
/*      */     }
/*      */     
/*      */     public int getID() {
/* 3861 */       return this.ID;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 3867 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3870 */       setEnabled((table == null || table.isEnabled()));
/* 3871 */       setHorizontalAlignment(4);
/* 3872 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3873 */       return this;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4;
/*      */     String[] indices5;
/*      */     
/*      */     public CeldaRender2() {
/* 3879 */       this.otro = -1;
/* 3880 */       this.indices = new String[0];
/* 3881 */       this.indices2 = new String[0];
/* 3882 */       this.indices3 = new String[0];
/* 3883 */       this.indices4 = new String[0];
/* 3884 */       this.indices5 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3887 */       setEnabled((table == null || table.isEnabled()));
/* 3888 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 3889 */       if (comparar2(comp)) {
/* 3890 */         setBackground(new Color(153, 102, 0));
/* 3891 */         setForeground(Color.WHITE);
/* 3892 */       } else if (comparar3(comp)) {
/* 3893 */         setBackground(new Color(102, 153, 255));
/* 3894 */         setForeground(Color.BLUE);
/* 3895 */       } else if (comparar4(comp)) {
/* 3896 */         setBackground(Color.LIGHT_GRAY);
/* 3897 */         setForeground(Color.RED);
/* 3898 */       } else if (comparar5(comp)) {
/* 3899 */         setBackground(Color.RED);
/* 3900 */         setForeground(Color.WHITE);
/*      */       } else {
/* 3902 */         setBackground((Color)null);
/* 3903 */         setForeground(Color.black);
/*      */       } 
/* 3905 */       if (column == 9 || column == 10 || column == 11 || column == 12) {
/* 3906 */         setHorizontalAlignment(4);
/*      */       } else {
/* 3908 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 3911 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3912 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 3916 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 3920 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 3924 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 3928 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 3932 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3936 */       for (int i = 0; i < this.indices.length; i++) {
/* 3937 */         if (this.indices[i].equals(reg)) {
/* 3938 */           return true;
/*      */         }
/*      */       } 
/* 3941 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 3945 */       for (int i = 0; i < this.indices2.length; i++) {
/* 3946 */         if (this.indices2[i].equals(reg)) {
/* 3947 */           return true;
/*      */         }
/*      */       } 
/* 3950 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 3954 */       for (int i = 0; i < this.indices3.length; i++) {
/* 3955 */         if (this.indices3[i].equals(reg)) {
/* 3956 */           return true;
/*      */         }
/*      */       } 
/* 3959 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 3963 */       for (int i = 0; i < this.indices4.length; i++) {
/* 3964 */         if (this.indices4[i].equals(reg)) {
/* 3965 */           return true;
/*      */         }
/*      */       } 
/* 3968 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 3972 */       for (int i = 0; i < this.indices5.length; i++) {
/* 3973 */         if (this.indices5[i].equals(reg)) {
/* 3974 */           return true;
/*      */         }
/*      */       } 
/* 3977 */       return false;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Cotizaciones.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */