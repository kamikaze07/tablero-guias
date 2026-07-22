/*      */ package sicret;
/*      */ import Switch.Switch;
/*      */ import com.itextpdf.text.Document;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.LayoutManager;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Paper;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.io.File;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableColumn;
/*      */ import jxl.format.Alignment;
/*      */ import jxl.format.CellFormat;
/*      */ import jxl.format.Colour;
/*      */ import jxl.write.Label;
/*      */ import jxl.write.WritableCell;
/*      */ import jxl.write.WritableCellFormat;
/*      */ import jxl.write.WritableFont;
/*      */ import jxl.write.WritableSheet;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import principal.MaterialButton;
/*      */ 
/*      */ public class EmpleadosBuscar extends JPanel {
/*      */   Color color;
/*      */   JFrame frame;
/*      */   JScrollPane panel;
/*   67 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   68 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   69 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   70 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   71 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   72 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   73 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   74 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   75 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   String USUARIO;
/*   77 */   Consultas con = new Consultas();
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   81 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   84 */   CeldaRender celda = new CeldaRender();
/*   85 */   CeldaRender2 celda2 = new CeldaRender2();
/*   86 */   String RUTA = "";
/*      */   ReporteIndividualEmp indi;
/*   88 */   String VIGENCIA = "";
/*      */   
/*   90 */   String FOTO = "";
/*   91 */   cargarFoto cargar = null;
/*   92 */   fotoIndividual ind = null;
/*   93 */   String[] DIRECTIVA = null;
/*   94 */   String AGENTE = "VACJ 710806 TU8 0013";
/*   95 */   String CLAVEOP = "";
/*   96 */   fotoCredencial fotoC = null;
/*   97 */   String[] CONFIG = null;
/*   98 */   String PRIVILEGIOS = "";
/*   99 */   fotoFirmas fotoF = null;
/*  100 */   SColores lc = new SColores();
/*  101 */   PlaceHolder placeHolder = null;
/*  102 */   String holderClave = "CLAVE";
/*  103 */   String holderNombre = "NOMBRE";
/*  104 */   String holderPaterno = "APELLIDO PATERNO";
/*  105 */   String holderMaterno = "APELLIDO MATERNO";
/*      */   private int xx;
/*      */   private int xy;
/*  108 */   int clicPanel = 0;
/*  109 */   Fuentes fuentes = new Fuentes();
/*  110 */   String nombreArchivo = ""; Map<String, String> CAMPOSGENERALES; boolean entraPrimera = false; private ButtonGroup buttonGroup1; private CLabel cLabel1; private JButton jButton1; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton3; private JButton jButton5; private JButton jButton6; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox3; private JComboBox jComboBox4; private JDateChooser jDateChooser1; private JDateChooser jDateChooser8; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel15; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel153; private JLabel jLabel154; private JLabel jLabel155; private JLabel jLabel156; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81;
/*      */   private JLabel jLabel82;
/*      */   private JLabel jLabel83;
/*      */   
/*      */   public EmpleadosBuscar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  115 */     this.padre = padre;
/*  116 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  117 */     initComponents();
/*      */     
/*  119 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  120 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  121 */     this.rSTableMetro1.setCursor(micursor);
/*  122 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Century Gothic", 11);
/*  123 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderNombre, false, "Century Gothic", 11);
/*  124 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderPaterno, false, "Century Gothic", 11);
/*  125 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderMaterno, false, "Century Gothic", 11);
/*      */     
/*  127 */     this.RUTA = CAMPOSGENERALES.get("fotosEmpleados").toString();
/*  128 */     fichas = fichas;
/*  129 */     colorear();
/*  130 */     this.USUARIO = USUARIO;
/*  131 */     panelito.setViewportView(this);
/*  132 */     this.panel = panelito;
/*  133 */     llenarCombo();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  138 */     int w = this.tama.width;
/*  139 */     int h = this.tama.height;
/*  140 */     this.jDialog1.setLocation(w - 255, 5);
/*  141 */     this.jDialog1.setSize(250, 365);
/*  142 */     this.jDialog1.setVisible(false);
/*  143 */     this.jDialog1.setResizable(false);
/*      */     
/*  145 */     int rw = (w - 730) / 2;
/*  146 */     int rh = (h - 675) / 2;
/*  147 */     this.jDialog2.setLocation(rw, rh);
/*  148 */     this.jDialog2.setSize(730, 665);
/*  149 */     this.jDialog2.setVisible(false);
/*  150 */     this.jDialog2.setResizable(false);
/*      */     
/*  152 */     rw = (w - 420) / 2;
/*  153 */     rh = (h - 230) / 2;
/*  154 */     this.jDialog3.setLocation(rw, rh);
/*  155 */     this.jDialog3.setSize(420, 230);
/*  156 */     this.jDialog3.setVisible(false);
/*  157 */     this.jDialog3.setResizable(false);
/*      */     
/*  159 */     rw = (w - 378) / 2;
/*  160 */     rh = (h - 155) / 2;
/*  161 */     this.jDialog4.setLocation(rw, rh);
/*  162 */     this.jDialog4.setSize(378, 155);
/*  163 */     this.jDialog4.setVisible(false);
/*  164 */     this.jDialog4.setResizable(false);
/*      */     
/*  166 */     rw = (w - 475) / 2;
/*  167 */     rh = (h - 690) / 2;
/*  168 */     this.jDialog5.setLocation(rw, rh);
/*  169 */     this.jDialog5.setSize(475, 690);
/*  170 */     this.jDialog5.setVisible(false);
/*  171 */     this.jDialog5.setResizable(false);
/*      */     
/*  173 */     rw = (w - 443) / 2;
/*  174 */     rh = (h - 655) / 2;
/*  175 */     this.jDialog6.setLocation(rw, rh);
/*  176 */     this.jDialog6.setSize(443, 650);
/*  177 */     this.jDialog6.setVisible(false);
/*  178 */     this.jDialog6.setResizable(false);
/*      */     
/*  180 */     rw = (w - 650) / 2;
/*  181 */     rh = (h - 750) / 2;
/*  182 */     this.jDialog7.setLocation(rw, rh);
/*  183 */     this.jDialog7.setSize(650, 750);
/*  184 */     this.jDialog7.setVisible(false);
/*  185 */     this.jDialog7.setResizable(false);
/*      */     
/*  187 */     this.jDialog8.setLocation(w - 591, 5);
/*  188 */     this.jDialog8.setSize(591, 350);
/*  189 */     this.jDialog8.setVisible(false);
/*  190 */     this.jDialog8.setResizable(false);
/*      */     
/*  192 */     rw = (w - 765) / 2;
/*  193 */     rh = (h - 570) / 2;
/*  194 */     this.jDialog9.setLocation(rw, rh);
/*  195 */     this.jDialog9.setSize(765, 570);
/*  196 */     this.jDialog9.setVisible(false);
/*  197 */     this.jDialog9.setResizable(false);
/*      */     
/*  199 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  200 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  201 */     this.jLabel60.setCursor(micursor);
/*  202 */     this.jLabel86.setCursor(micursor);
/*  203 */     this.jLabel136.setCursor(micursor);
/*      */     
/*  205 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  206 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  207 */     this.jDialog2.setCursor(micursor);
/*  208 */     this.jDialog1.setCursor(micursor);
/*  209 */     this.jDialog3.setCursor(micursor);
/*  210 */     this.jDialog4.setCursor(micursor);
/*  211 */     this.jDialog5.setCursor(micursor);
/*  212 */     this.jDialog6.setCursor(micursor);
/*  213 */     this.jDialog7.setCursor(micursor);
/*  214 */     this.jDialog8.setCursor(micursor);
/*  215 */     this.jDialog9.setCursor(micursor);
/*  216 */     this.rSTableMetro2.setCursor(micursor);
/*      */     
/*  218 */     this.jLabel11.setVisible(false);
/*      */     
/*  220 */     if (!entradaPrincipal) {
/*  221 */       this.PRIVILEGIOS = CAMPOSGENERALES.get("priv").toString();
/*  222 */       sacarPrivilegios();
/*  223 */       consultar();
/*      */     } 
/*      */ 
/*      */     
/*  227 */     this.DIRECTIVA = new String[] { CAMPOSGENERALES.get("fotosEmpleados").toString(), CAMPOSGENERALES.get("directiva").toString(), CAMPOSGENERALES.get("capacitadorQHSE").toString() };
/*  228 */     this.AGENTE = this.DIRECTIVA[2];
/*      */ 
/*      */     
/*  231 */     this.CONFIG = new String[] { CAMPOSGENERALES.get("fotosEmpleados").toString(), CAMPOSGENERALES.get("directiva").toString(), CAMPOSGENERALES.get("capacitadorQHSE").toString(), CAMPOSGENERALES.get("nombreCapacitador").toString() };
/*  232 */     this.buttonGroup1.add(this.jRadioButton7);
/*  233 */     this.buttonGroup1.add(this.jRadioButton8);
/*      */   }
/*      */   private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel67; private JPanel jPanel68; private JPanel jPanel69;
/*      */   private JPanel jPanel7;
/*      */   
/*      */   private void initComponents() {
/*  239 */     this.jDialog1 = new JDialog(this.padre);
/*  240 */     this.jPanel3 = new JPanel();
/*  241 */     this.jLabel11 = new JLabel();
/*  242 */     this.jLabel1 = new JLabel();
/*  243 */     this.jPanel59 = new JPanel();
/*  244 */     this.jLabel123 = new JLabel();
/*  245 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  246 */     this.jPanel1 = new JPanel();
/*  247 */     this.jPanel51 = new JPanel();
/*  248 */     this.cLabel1 = new CLabel();
/*  249 */     this.jPanel57 = new JPanel();
/*  250 */     this.jPanel58 = new JPanel();
/*  251 */     this.jPanel62 = new JPanel();
/*  252 */     this.jLabel16 = new JLabel();
/*  253 */     this.jPanel67 = new JPanel();
/*  254 */     this.jPanel68 = new JPanel();
/*  255 */     this.jLabel17 = new JLabel();
/*  256 */     this.jPanel69 = new JPanel();
/*  257 */     this.jPanel70 = new JPanel();
/*  258 */     this.jLabel18 = new JLabel();
/*  259 */     this.jPanel71 = new JPanel();
/*  260 */     this.jPanel72 = new JPanel();
/*  261 */     this.jLabel19 = new JLabel();
/*  262 */     this.jPanel4 = new JPanel();
/*  263 */     this.jLabel68 = new JLabel();
/*  264 */     this.jPanel50 = new JPanel();
/*  265 */     this.jLabel2 = new JLabel();
/*  266 */     this.jPanel61 = new JPanel();
/*  267 */     this.jLabel126 = new JLabel();
/*  268 */     this.jLabel20 = new JLabel();
/*  269 */     this.jLabel3 = new JLabel();
/*  270 */     this.jPanel52 = new JPanel();
/*  271 */     this.jPanel56 = new JPanel();
/*  272 */     this.jLabel5 = new JLabel();
/*  273 */     this.jTextField7 = new JTextField();
/*  274 */     this.jLabel22 = new JLabel();
/*  275 */     this.jTextField5 = new JTextField();
/*  276 */     this.jLabel28 = new JLabel();
/*  277 */     this.jTextField6 = new JTextField();
/*  278 */     this.jLabel29 = new JLabel();
/*  279 */     this.jTextField18 = new JTextField();
/*  280 */     this.jLabel23 = new JLabel();
/*  281 */     this.jTextField14 = new JTextField();
/*  282 */     this.jLabel24 = new JLabel();
/*  283 */     this.jTextField15 = new JTextField();
/*  284 */     this.jLabel30 = new JLabel();
/*  285 */     this.jTextField19 = new JTextField();
/*  286 */     this.jLabel25 = new JLabel();
/*  287 */     this.jTextField16 = new JTextField();
/*  288 */     this.jLabel31 = new JLabel();
/*  289 */     this.jTextField25 = new JTextField();
/*  290 */     this.jLabel43 = new JLabel();
/*  291 */     this.jTextField20 = new JTextField();
/*  292 */     this.jLabel32 = new JLabel();
/*  293 */     this.jTextField26 = new JTextField();
/*  294 */     this.jLabel38 = new JLabel();
/*  295 */     this.jTextField21 = new JTextField();
/*  296 */     this.jLabel50 = new JLabel();
/*  297 */     this.jTextField22 = new JTextField();
/*  298 */     this.jLabel53 = new JLabel();
/*  299 */     this.jTextField23 = new JTextField();
/*  300 */     this.jLabel39 = new JLabel();
/*  301 */     this.jTextField30 = new JTextField();
/*  302 */     this.jLabel41 = new JLabel();
/*  303 */     this.jTextField31 = new JTextField();
/*  304 */     this.jLabel42 = new JLabel();
/*  305 */     this.jTextField32 = new JTextField();
/*  306 */     this.jPanel53 = new JPanel();
/*  307 */     this.materialButton38 = new MaterialButton();
/*  308 */     this.materialButton39 = new MaterialButton();
/*  309 */     this.materialButton40 = new MaterialButton();
/*  310 */     this.materialButton41 = new MaterialButton();
/*  311 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  312 */     this.jPanel29 = new JPanel();
/*  313 */     this.jLabel125 = new JLabel();
/*  314 */     this.jScrollPane18 = new JScrollPane();
/*  315 */     this.jTextArea5 = new JTextArea();
/*  316 */     this.materialButton36 = new MaterialButton();
/*  317 */     this.materialButton37 = new MaterialButton();
/*  318 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  319 */     this.jPanel7 = new JPanel();
/*  320 */     this.jLabel12 = new JLabel();
/*  321 */     this.jPanel5 = new JPanel();
/*  322 */     this.jRadioButton7 = new JRadioButton();
/*  323 */     this.jRadioButton8 = new JRadioButton();
/*  324 */     this.materialButton27 = new MaterialButton();
/*  325 */     this.materialButton28 = new MaterialButton();
/*  326 */     this.jPanel20 = new JPanel();
/*  327 */     this.jLabel119 = new JLabel();
/*  328 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  329 */     this.buttonGroup1 = new ButtonGroup();
/*  330 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  331 */     this.jPanel25 = new JPanel();
/*  332 */     this.jLabel67 = new JLabel();
/*  333 */     this.jSeparator6 = new JSeparator();
/*  334 */     this.jLabel69 = new JLabel();
/*  335 */     this.jLabel70 = new JLabel();
/*  336 */     this.jButton19 = new JButton();
/*  337 */     this.jButton20 = new JButton();
/*  338 */     this.jButton21 = new JButton();
/*  339 */     this.jPanel26 = new JPanel();
/*  340 */     this.jLabel107 = new JLabel();
/*  341 */     this.jLabel108 = new JLabel();
/*  342 */     this.jLabel109 = new JLabel();
/*  343 */     this.jLabel111 = new JLabel();
/*  344 */     this.jLabel112 = new JLabel();
/*  345 */     this.jLabel113 = new JLabel();
/*  346 */     this.jLabel114 = new JLabel();
/*  347 */     this.jLabel116 = new JLabel();
/*  348 */     this.jLabel117 = new JLabel();
/*  349 */     this.jLabel110 = new JLabel();
/*  350 */     this.jLabel115 = new JLabel();
/*  351 */     this.jLabel120 = new JLabel();
/*  352 */     this.jPanel27 = new JPanel();
/*  353 */     this.jLabel121 = new JLabel();
/*  354 */     this.jLabel129 = new JLabel();
/*  355 */     this.jLabel130 = new JLabel();
/*  356 */     this.jLabel131 = new JLabel();
/*  357 */     this.jLabel132 = new JLabel();
/*  358 */     this.jLabel133 = new JLabel();
/*  359 */     this.jLabel134 = new JLabel();
/*  360 */     this.jLabel135 = new JLabel();
/*  361 */     this.jLabel136 = new JLabel();
/*  362 */     this.jLabel71 = new JLabel();
/*  363 */     this.jLabel137 = new JLabel();
/*  364 */     this.jLabel118 = new JLabel();
/*  365 */     this.jLabel138 = new JLabel();
/*  366 */     this.jLabel139 = new JLabel();
/*  367 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  368 */     this.jPanel14 = new JPanel();
/*  369 */     this.jLabel62 = new JLabel();
/*  370 */     this.jSeparator7 = new JSeparator();
/*  371 */     this.jLabel63 = new JLabel();
/*  372 */     this.jPanel15 = new JPanel();
/*  373 */     this.jLabel13 = new JLabel();
/*  374 */     this.jLabel33 = new JLabel();
/*  375 */     this.jLabel64 = new JLabel();
/*  376 */     this.jLabel78 = new JLabel();
/*  377 */     this.jLabel80 = new JLabel();
/*  378 */     this.jLabel82 = new JLabel();
/*  379 */     this.jLabel84 = new JLabel();
/*  380 */     this.jLabel85 = new JLabel();
/*  381 */     this.jLabel86 = new JLabel();
/*  382 */     this.jPanel16 = new JPanel();
/*  383 */     this.jLabel81 = new JLabel();
/*  384 */     this.jLabel87 = new JLabel();
/*  385 */     this.jPanel19 = new JPanel();
/*  386 */     this.jLabel88 = new JLabel();
/*  387 */     this.jLabel89 = new JLabel();
/*  388 */     this.jLabel65 = new JLabel();
/*  389 */     this.jPanel21 = new JPanel();
/*  390 */     this.jLabel79 = new JLabel();
/*  391 */     this.jLabel90 = new JLabel();
/*  392 */     this.jLabel91 = new JLabel();
/*  393 */     this.jLabel94 = new JLabel();
/*  394 */     this.jLabel95 = new JLabel();
/*  395 */     this.jLabel96 = new JLabel();
/*  396 */     this.jLabel97 = new JLabel();
/*  397 */     this.jLabel99 = new JLabel();
/*  398 */     this.jLabel100 = new JLabel();
/*  399 */     this.jLabel102 = new JLabel();
/*  400 */     this.jLabel103 = new JLabel();
/*  401 */     this.jLabel104 = new JLabel();
/*  402 */     this.jLabel105 = new JLabel();
/*  403 */     this.jLabel92 = new JLabel();
/*  404 */     this.jLabel106 = new JLabel();
/*  405 */     this.materialButton32 = new MaterialButton();
/*  406 */     this.materialButton33 = new MaterialButton();
/*  407 */     this.materialButton34 = new MaterialButton();
/*  408 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  409 */     this.materialButton42 = new MaterialButton();
/*  410 */     this.jScrollPane32 = new JScrollPane();
/*  411 */     this.rSTableMetro2 = new RSTableMetro();
/*  412 */     this.jPanel64 = new JPanel();
/*  413 */     this.jLabel34 = new JLabel();
/*  414 */     this.jLabel58 = new JLabel();
/*  415 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  416 */     this.jPanel9 = new JPanel();
/*  417 */     this.jPanel60 = new JPanel();
/*  418 */     this.jLabel124 = new JLabel();
/*  419 */     this.jLabel72 = new JLabel();
/*  420 */     this.jLabel73 = new JLabel();
/*  421 */     this.jSeparator5 = new JSeparator();
/*  422 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  423 */     this.jPanel13 = new JPanel();
/*  424 */     this.jPanel33 = new JPanel();
/*  425 */     this.jPanel11 = new JPanel();
/*  426 */     this.jPanel22 = new JPanel();
/*  427 */     this.jLabel74 = new JLabel();
/*  428 */     this.jLabel75 = new JLabel();
/*  429 */     this.jPanel23 = new JPanel();
/*  430 */     this.jLabel76 = new JLabel();
/*  431 */     this.jPanel24 = new JPanel();
/*  432 */     this.jPanel30 = new JPanel();
/*  433 */     this.jPanel31 = new JPanel();
/*  434 */     this.jLabel83 = new JLabel();
/*  435 */     this.jLabel93 = new JLabel();
/*  436 */     this.jPanel28 = new JPanel();
/*  437 */     this.jLabel77 = new JLabel();
/*  438 */     this.jPanel32 = new JPanel();
/*  439 */     this.jLabel98 = new JLabel();
/*  440 */     this.jPanel34 = new JPanel();
/*  441 */     this.jLabel101 = new JLabel();
/*  442 */     this.jPanel35 = new JPanel();
/*  443 */     this.jLabel122 = new JLabel();
/*  444 */     this.jPanel36 = new JPanel();
/*  445 */     this.jSpinner1 = new JSpinner();
/*  446 */     this.jLabel146 = new JLabel();
/*  447 */     this.jLabel140 = new JLabel();
/*  448 */     this.jDateChooser1 = new JDateChooser();
/*  449 */     this.jLabel142 = new JLabel();
/*  450 */     this.jLabel143 = new JLabel();
/*  451 */     this.jLabel144 = new JLabel();
/*  452 */     this.jTextField29 = new JTextField();
/*  453 */     this.jPanel37 = new JPanel();
/*  454 */     this.jPanel38 = new JPanel();
/*  455 */     this.jLabel128 = new JLabel();
/*  456 */     this.jLabel141 = new JLabel();
/*  457 */     this.jPanel39 = new JPanel();
/*  458 */     this.jLabel145 = new JLabel();
/*  459 */     this.jPanel40 = new JPanel();
/*  460 */     this.jPanel41 = new JPanel();
/*  461 */     this.jPanel42 = new JPanel();
/*  462 */     this.jLabel35 = new JLabel();
/*  463 */     this.jPanel43 = new JPanel();
/*  464 */     this.jPanel44 = new JPanel();
/*  465 */     this.jLabel148 = new JLabel();
/*  466 */     this.jLabel149 = new JLabel();
/*  467 */     this.jPanel45 = new JPanel();
/*  468 */     this.jPanel46 = new JPanel();
/*  469 */     this.jLabel151 = new JLabel();
/*  470 */     this.jLabel147 = new JLabel();
/*  471 */     this.jPanel47 = new JPanel();
/*  472 */     this.materialButton29 = new MaterialButton();
/*  473 */     this.materialButton30 = new MaterialButton();
/*  474 */     this.materialButton31 = new MaterialButton();
/*  475 */     this.jPanel54 = new JPanel();
/*  476 */     this.jLabel7 = new JLabel();
/*  477 */     this.jTextField9 = new JTextField();
/*  478 */     this.jLabel8 = new JLabel();
/*  479 */     this.jTextField10 = new JTextField();
/*  480 */     this.jLabel9 = new JLabel();
/*  481 */     this.jLabel10 = new JLabel();
/*  482 */     this.jTextField12 = new JTextField();
/*  483 */     this.jLabel21 = new JLabel();
/*  484 */     this.jTextField13 = new JTextField();
/*  485 */     this.jTextField11 = new JTextField();
/*  486 */     this.jLabel155 = new JLabel();
/*  487 */     this.jTextField45 = new JTextField();
/*  488 */     this.jPanel55 = new JPanel();
/*  489 */     this.jLabel27 = new JLabel();
/*  490 */     this.jTextField33 = new JTextField();
/*  491 */     this.jLabel49 = new JLabel();
/*  492 */     this.jTextField34 = new JTextField();
/*  493 */     this.jLabel51 = new JLabel();
/*  494 */     this.jLabel52 = new JLabel();
/*  495 */     this.jTextField35 = new JTextField();
/*  496 */     this.jTextField36 = new JTextField();
/*  497 */     this.jLabel54 = new JLabel();
/*  498 */     this.jTextField37 = new JTextField();
/*  499 */     this.jLabel57 = new JLabel();
/*  500 */     this.jTextField38 = new JTextField();
/*  501 */     this.jLabel59 = new JLabel();
/*  502 */     this.jTextField39 = new JTextField();
/*  503 */     this.jLabel127 = new JLabel();
/*  504 */     this.jTextField40 = new JTextField();
/*  505 */     this.jLabel152 = new JLabel();
/*  506 */     this.jTextField42 = new JTextField();
/*  507 */     this.jLabel47 = new JLabel();
/*  508 */     this.jTextField24 = new JTextField();
/*  509 */     this.jLabel150 = new JLabel();
/*  510 */     this.jLabel154 = new JLabel();
/*  511 */     this.switch2 = new Switch();
/*  512 */     this.switch3 = new Switch();
/*  513 */     this.jLabel4 = new JLabel();
/*  514 */     this.jLabel6 = new JLabel();
/*  515 */     this.jPanel63 = new JPanel();
/*  516 */     this.jLabel44 = new JLabel();
/*  517 */     this.jTextField43 = new JTextField();
/*  518 */     this.jLabel153 = new JLabel();
/*  519 */     this.jTextField44 = new JTextField();
/*  520 */     this.jLabel66 = new JLabel();
/*  521 */     this.jTextField27 = new JTextField();
/*  522 */     this.jLabel46 = new JLabel();
/*  523 */     this.jTextField41 = new JTextField();
/*  524 */     this.jLabel26 = new JLabel();
/*  525 */     this.jTextField17 = new JTextField();
/*  526 */     this.jScrollPane1 = new JScrollPane();
/*  527 */     this.jTextArea1 = new JTextArea();
/*  528 */     this.jLabel56 = new JLabel();
/*  529 */     this.jLabel60 = new JLabel();
/*  530 */     this.jPanel2 = new JPanel();
/*  531 */     this.jPanel8 = new JPanel();
/*  532 */     this.jLabel55 = new JLabel();
/*  533 */     this.jPanel17 = new JPanel();
/*  534 */     this.jTextField1 = new JTextField();
/*  535 */     this.jTextField2 = new JTextField();
/*  536 */     this.jTextField3 = new JTextField();
/*  537 */     this.jComboBox1 = new JComboBox();
/*  538 */     this.jTextField4 = new JTextField();
/*  539 */     this.jComboBox3 = new JComboBox();
/*  540 */     this.jComboBox4 = new JComboBox();
/*  541 */     this.jPanel10 = new JPanel();
/*  542 */     this.jScrollPane2 = new JScrollPane();
/*  543 */     this.jPanel12 = new JPanel();
/*  544 */     this.jScrollPane29 = new JScrollPane();
/*  545 */     this.rSTableMetro1 = new RSTableMetro();
/*  546 */     this.jPanel48 = new JPanel();
/*  547 */     this.jPanel49 = new JPanel();
/*  548 */     this.jLabel14 = new JLabel();
/*  549 */     this.jLabel48 = new JLabel();
/*  550 */     this.jLabel156 = new JLabel();
/*  551 */     this.jLabel15 = new JLabel();
/*  552 */     this.jButton2 = new JButton();
/*  553 */     this.jButton1 = new JButton();
/*  554 */     this.jButton6 = new JButton();
/*  555 */     this.jButton9 = new JButton();
/*  556 */     this.jButton5 = new JButton();
/*  557 */     this.switch1 = new Switch();
/*  558 */     this.jButton3 = new JButton();
/*      */     
/*  560 */     this.jDialog1.setTitle("FOTOS");
/*  561 */     this.jDialog1.setAlwaysOnTop(true);
/*  562 */     this.jDialog1.setFocusable(false);
/*  563 */     this.jDialog1.setUndecorated(true);
/*  564 */     this.jDialog1.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  566 */             EmpleadosBuscar.this.jDialog1WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  570 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/*  571 */     this.jPanel3.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/*  572 */     this.jPanel3.setLayout((LayoutManager)null);
/*      */     
/*  574 */     this.jLabel11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*  575 */     this.jLabel11.setForeground(Color.orange);
/*  576 */     this.jLabel11.setHorizontalAlignment(0);
/*  577 */     this.jLabel11.setText("DISTINTIVO");
/*  578 */     this.jLabel11.setVerticalAlignment(3);
/*  579 */     this.jPanel3.add(this.jLabel11);
/*  580 */     this.jLabel11.setBounds(0, 280, 260, 50);
/*      */     
/*  582 */     this.jLabel1.setHorizontalAlignment(0);
/*  583 */     this.jLabel1.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  585 */             EmpleadosBuscar.this.jLabel1MouseDragged(evt);
/*      */           }
/*      */         });
/*  588 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  590 */             EmpleadosBuscar.this.jLabel1MouseClicked(evt);
/*      */           }
/*      */         });
/*  593 */     this.jPanel3.add(this.jLabel1);
/*  594 */     this.jLabel1.setBounds(0, 20, 250, 290);
/*      */     
/*  596 */     this.jPanel59.setBackground(this.lc.PRIMARIO1);
/*  597 */     this.jPanel59.setLayout(new GridLayout(1, 0));
/*      */     
/*  599 */     this.jLabel123.setHorizontalAlignment(0);
/*  600 */     this.jLabel123.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  601 */     this.jLabel123.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  603 */             EmpleadosBuscar.this.jLabel123MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  606 */             EmpleadosBuscar.this.jLabel123MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  609 */             EmpleadosBuscar.this.jLabel123MouseEntered(evt);
/*      */           }
/*      */         });
/*  612 */     this.jPanel59.add(this.jLabel123);
/*      */     
/*  614 */     this.jPanel3.add(this.jPanel59);
/*  615 */     this.jPanel59.setBounds(219, 1, 30, 31);
/*      */     
/*  617 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  618 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  619 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  620 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  621 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  622 */           .addComponent(this.jPanel3, -1, 254, 32767)
/*  623 */           .addGap(0, 0, 0)));
/*      */     
/*  625 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  626 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  627 */         .addComponent(this.jPanel3, -1, 328, 32767));
/*      */ 
/*      */     
/*  630 */     this.jDialog2.setTitle("Reporte Individual");
/*  631 */     this.jDialog2.setModal(true);
/*  632 */     this.jDialog2.setUndecorated(true);
/*  633 */     this.jDialog2.setType(Window.Type.UTILITY);
/*      */     
/*  635 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*  636 */     this.jPanel1.setMaximumSize(new Dimension(730, 665));
/*  637 */     this.jPanel1.setMinimumSize(new Dimension(730, 665));
/*  638 */     this.jPanel1.setPreferredSize(new Dimension(730, 665));
/*  639 */     this.jPanel1.setLayout((LayoutManager)null);
/*      */     
/*  641 */     this.jPanel51.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  643 */     this.cLabel1.setBackground(this.lc.FONDOTABLA);
/*  644 */     this.cLabel1.setForeground(this.lc.PRIMARIO2);
/*  645 */     this.cLabel1.setText("");
/*  646 */     this.cLabel1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  647 */     this.cLabel1.setLineColor(this.lc.SECUNDARIO1);
/*      */     
/*  649 */     this.jPanel57.setBackground(this.lc.SECUNDARIO2);
/*  650 */     this.jPanel57.setLayout(new GridLayout(6, 1, 0, 8));
/*      */     
/*  652 */     this.jPanel58.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  654 */     this.jPanel62.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  656 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/*  657 */     this.jPanel62.setLayout(jPanel62Layout);
/*  658 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/*  659 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  660 */         .addGap(0, 6, 32767));
/*      */     
/*  662 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/*  663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  664 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/*  667 */     this.jLabel16.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  669 */     this.jLabel16.setForeground(this.lc.SECUNDARIO1);
/*  670 */     this.jLabel16.setText("Información Personal");
/*  671 */     this.jLabel16.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  673 */             EmpleadosBuscar.this.jLabel16MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  676 */             EmpleadosBuscar.this.jLabel16MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  679 */             EmpleadosBuscar.this.jLabel16MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  683 */     GroupLayout jPanel58Layout = new GroupLayout(this.jPanel58);
/*  684 */     this.jPanel58.setLayout(jPanel58Layout);
/*  685 */     jPanel58Layout.setHorizontalGroup(jPanel58Layout
/*  686 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  687 */         .addGroup(jPanel58Layout.createSequentialGroup()
/*  688 */           .addComponent(this.jPanel62, -2, -1, -2)
/*  689 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  690 */           .addComponent(this.jLabel16, -1, 168, 32767)));
/*      */     
/*  692 */     jPanel58Layout.setVerticalGroup(jPanel58Layout
/*  693 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  694 */         .addComponent(this.jLabel16, -1, 39, 32767)
/*  695 */         .addComponent(this.jPanel62, -1, -1, 32767));
/*      */ 
/*      */     
/*  698 */     this.jPanel57.add(this.jPanel58);
/*      */     
/*  700 */     this.jPanel67.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  702 */     this.jPanel68.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  704 */     GroupLayout jPanel68Layout = new GroupLayout(this.jPanel68);
/*  705 */     this.jPanel68.setLayout(jPanel68Layout);
/*  706 */     jPanel68Layout.setHorizontalGroup(jPanel68Layout
/*  707 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  708 */         .addGap(0, 6, 32767));
/*      */     
/*  710 */     jPanel68Layout.setVerticalGroup(jPanel68Layout
/*  711 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  712 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/*  715 */     this.jLabel17.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  717 */     this.jLabel17.setForeground(this.lc.SECUNDARIO1);
/*  718 */     this.jLabel17.setText("Dirección");
/*  719 */     this.jLabel17.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  721 */             EmpleadosBuscar.this.jLabel17MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  724 */             EmpleadosBuscar.this.jLabel17MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  727 */             EmpleadosBuscar.this.jLabel17MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  731 */     GroupLayout jPanel67Layout = new GroupLayout(this.jPanel67);
/*  732 */     this.jPanel67.setLayout(jPanel67Layout);
/*  733 */     jPanel67Layout.setHorizontalGroup(jPanel67Layout
/*  734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  735 */         .addGroup(jPanel67Layout.createSequentialGroup()
/*  736 */           .addComponent(this.jPanel68, -2, -1, -2)
/*  737 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  738 */           .addComponent(this.jLabel17, -1, 168, 32767)));
/*      */     
/*  740 */     jPanel67Layout.setVerticalGroup(jPanel67Layout
/*  741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  742 */         .addComponent(this.jLabel17, -1, 39, 32767)
/*  743 */         .addComponent(this.jPanel68, -1, -1, 32767));
/*      */ 
/*      */     
/*  746 */     this.jPanel57.add(this.jPanel67);
/*      */     
/*  748 */     this.jPanel69.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  750 */     this.jPanel70.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  752 */     GroupLayout jPanel70Layout = new GroupLayout(this.jPanel70);
/*  753 */     this.jPanel70.setLayout(jPanel70Layout);
/*  754 */     jPanel70Layout.setHorizontalGroup(jPanel70Layout
/*  755 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  756 */         .addGap(0, 6, 32767));
/*      */     
/*  758 */     jPanel70Layout.setVerticalGroup(jPanel70Layout
/*  759 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  760 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/*  763 */     this.jLabel18.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  765 */     this.jLabel18.setForeground(this.lc.SECUNDARIO1);
/*  766 */     this.jLabel18.setText("Datos del Contrato");
/*  767 */     this.jLabel18.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  769 */             EmpleadosBuscar.this.jLabel18MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  772 */             EmpleadosBuscar.this.jLabel18MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  775 */             EmpleadosBuscar.this.jLabel18MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  779 */     GroupLayout jPanel69Layout = new GroupLayout(this.jPanel69);
/*  780 */     this.jPanel69.setLayout(jPanel69Layout);
/*  781 */     jPanel69Layout.setHorizontalGroup(jPanel69Layout
/*  782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  783 */         .addGroup(jPanel69Layout.createSequentialGroup()
/*  784 */           .addComponent(this.jPanel70, -2, -1, -2)
/*  785 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  786 */           .addComponent(this.jLabel18, -1, 168, 32767)));
/*      */     
/*  788 */     jPanel69Layout.setVerticalGroup(jPanel69Layout
/*  789 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  790 */         .addComponent(this.jLabel18, -1, 39, 32767)
/*  791 */         .addComponent(this.jPanel70, -1, -1, 32767));
/*      */ 
/*      */     
/*  794 */     this.jPanel57.add(this.jPanel69);
/*      */     
/*  796 */     this.jPanel71.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  798 */     this.jPanel72.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  800 */     GroupLayout jPanel72Layout = new GroupLayout(this.jPanel72);
/*  801 */     this.jPanel72.setLayout(jPanel72Layout);
/*  802 */     jPanel72Layout.setHorizontalGroup(jPanel72Layout
/*  803 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  804 */         .addGap(0, 6, 32767));
/*      */     
/*  806 */     jPanel72Layout.setVerticalGroup(jPanel72Layout
/*  807 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  808 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/*  811 */     this.jLabel19.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  813 */     this.jLabel19.setForeground(this.lc.SECUNDARIO1);
/*  814 */     this.jLabel19.setText("Otros Datos");
/*  815 */     this.jLabel19.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  817 */             EmpleadosBuscar.this.jLabel19MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  820 */             EmpleadosBuscar.this.jLabel19MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  823 */             EmpleadosBuscar.this.jLabel19MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  827 */     GroupLayout jPanel71Layout = new GroupLayout(this.jPanel71);
/*  828 */     this.jPanel71.setLayout(jPanel71Layout);
/*  829 */     jPanel71Layout.setHorizontalGroup(jPanel71Layout
/*  830 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  831 */         .addGroup(jPanel71Layout.createSequentialGroup()
/*  832 */           .addComponent(this.jPanel72, -2, -1, -2)
/*  833 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  834 */           .addComponent(this.jLabel19, -1, 168, 32767)));
/*      */     
/*  836 */     jPanel71Layout.setVerticalGroup(jPanel71Layout
/*  837 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  838 */         .addComponent(this.jLabel19, -1, 39, 32767)
/*  839 */         .addComponent(this.jPanel72, -1, -1, 32767));
/*      */ 
/*      */     
/*  842 */     this.jPanel57.add(this.jPanel71);
/*      */     
/*  844 */     this.jPanel4.setBackground(this.lc.SECUNDARIO1);
/*  845 */     this.jPanel4.setLayout(new GridLayout(1, 0));
/*      */     
/*  847 */     this.jLabel68.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*  848 */     this.jLabel68.setForeground(this.lc.SECUNDARIO2);
/*  849 */     this.jLabel68.setHorizontalAlignment(0);
/*  850 */     this.jLabel68.setText("ACTIVO");
/*  851 */     this.jPanel4.add(this.jLabel68);
/*      */     
/*  853 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/*  854 */     this.jPanel51.setLayout(jPanel51Layout);
/*  855 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/*  856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  857 */         .addComponent(this.jPanel57, -1, -1, 32767)
/*  858 */         .addGroup(jPanel51Layout.createSequentialGroup()
/*  859 */           .addGap(14, 14, 14)
/*  860 */           .addComponent((Component)this.cLabel1, -2, 150, -2)
/*  861 */           .addGap(0, 0, 32767))
/*  862 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/*  864 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/*  865 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  866 */         .addGroup(jPanel51Layout.createSequentialGroup()
/*  867 */           .addContainerGap(67, 32767)
/*  868 */           .addComponent((Component)this.cLabel1, -2, 150, -2)
/*  869 */           .addGap(18, 18, 18)
/*  870 */           .addComponent(this.jPanel57, -2, 274, -2)
/*  871 */           .addGap(87, 87, 87)
/*  872 */           .addComponent(this.jPanel4, -2, 38, -2)));
/*      */ 
/*      */     
/*  875 */     this.jPanel1.add(this.jPanel51);
/*  876 */     this.jPanel51.setBounds(1, 30, 180, 634);
/*      */     
/*  878 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  880 */     this.jLabel2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  881 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/*  882 */     this.jLabel2.setHorizontalAlignment(0);
/*  883 */     this.jLabel2.setText("Información del empleado");
/*  884 */     this.jLabel2.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  886 */             EmpleadosBuscar.this.jLabel2MouseDragged(evt);
/*      */           }
/*      */         });
/*  889 */     this.jLabel2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  891 */             EmpleadosBuscar.this.jLabel2MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  895 */     this.jPanel61.setBackground(this.lc.PRIMARIO1);
/*  896 */     this.jPanel61.setLayout(new GridLayout(1, 0));
/*      */     
/*  898 */     this.jLabel126.setHorizontalAlignment(0);
/*  899 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  900 */     this.jLabel126.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  902 */             EmpleadosBuscar.this.jLabel126MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  905 */             EmpleadosBuscar.this.jLabel126MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  908 */             EmpleadosBuscar.this.jLabel126MouseEntered(evt);
/*      */           }
/*      */         });
/*  911 */     this.jPanel61.add(this.jLabel126);
/*      */     
/*  913 */     this.jLabel20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  914 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/*  915 */     this.jLabel20.setHorizontalAlignment(0);
/*  916 */     this.jLabel20.setText("Clave: 923");
/*  917 */     this.jLabel20.setHorizontalTextPosition(0);
/*      */     
/*  919 */     this.jLabel3.setHorizontalAlignment(0);
/*  920 */     this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/user.png")));
/*      */     
/*  922 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/*  923 */     this.jPanel50.setLayout(jPanel50Layout);
/*  924 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/*  925 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  926 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  927 */           .addGap(1, 1, 1)
/*  928 */           .addComponent(this.jLabel3, -2, 36, -2)
/*  929 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  930 */           .addComponent(this.jLabel20, -2, 116, -2)
/*  931 */           .addGap(34, 34, 34)
/*  932 */           .addComponent(this.jLabel2, -1, 497, 32767)
/*  933 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  934 */           .addComponent(this.jPanel61, -2, 34, -2)));
/*      */     
/*  936 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/*  937 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  938 */         .addComponent(this.jPanel61, -1, -1, 32767)
/*  939 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  940 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  941 */             .addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  942 */             .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  943 */               .addComponent(this.jLabel2, -2, 30, -2)
/*  944 */               .addComponent(this.jLabel20, -2, 30, -2)))
/*  945 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  948 */     this.jPanel1.add(this.jPanel50);
/*  949 */     this.jPanel50.setBounds(1, 1, 730, 30);
/*      */     
/*  951 */     GridBagLayout jPanel56Layout = new GridBagLayout();
/*  952 */     jPanel56Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  953 */     jPanel56Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  954 */     this.jPanel56.setLayout(jPanel56Layout);
/*      */     
/*  956 */     this.jLabel5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  958 */     this.jLabel5.setText("Nombre:");
/*  959 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  960 */     gridBagConstraints.gridx = 2;
/*  961 */     gridBagConstraints.gridy = 0;
/*  962 */     gridBagConstraints.fill = 2;
/*  963 */     gridBagConstraints.anchor = 17;
/*  964 */     this.jPanel56.add(this.jLabel5, gridBagConstraints);
/*      */     
/*  966 */     this.jTextField7.setEditable(false);
/*  967 */     this.jTextField7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  969 */     gridBagConstraints = new GridBagConstraints();
/*  970 */     gridBagConstraints.gridx = 4;
/*  971 */     gridBagConstraints.gridy = 0;
/*  972 */     gridBagConstraints.gridwidth = 5;
/*  973 */     gridBagConstraints.fill = 2;
/*  974 */     gridBagConstraints.anchor = 18;
/*  975 */     gridBagConstraints.weightx = 1.0D;
/*  976 */     this.jPanel56.add(this.jTextField7, gridBagConstraints);
/*      */     
/*  978 */     this.jLabel22.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  980 */     this.jLabel22.setText("Apellido Paterno");
/*  981 */     gridBagConstraints = new GridBagConstraints();
/*  982 */     gridBagConstraints.gridx = 2;
/*  983 */     gridBagConstraints.gridy = 2;
/*  984 */     gridBagConstraints.fill = 2;
/*  985 */     gridBagConstraints.anchor = 17;
/*  986 */     this.jPanel56.add(this.jLabel22, gridBagConstraints);
/*      */     
/*  988 */     this.jTextField5.setEditable(false);
/*  989 */     this.jTextField5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/*  991 */     gridBagConstraints = new GridBagConstraints();
/*  992 */     gridBagConstraints.gridx = 4;
/*  993 */     gridBagConstraints.gridy = 2;
/*  994 */     gridBagConstraints.gridwidth = 5;
/*  995 */     gridBagConstraints.fill = 2;
/*  996 */     gridBagConstraints.weightx = 1.0D;
/*  997 */     this.jPanel56.add(this.jTextField5, gridBagConstraints);
/*      */     
/*  999 */     this.jLabel28.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1001 */     this.jLabel28.setText("Apellido Materno");
/* 1002 */     gridBagConstraints = new GridBagConstraints();
/* 1003 */     gridBagConstraints.gridx = 2;
/* 1004 */     gridBagConstraints.gridy = 4;
/* 1005 */     gridBagConstraints.fill = 2;
/* 1006 */     gridBagConstraints.anchor = 17;
/* 1007 */     this.jPanel56.add(this.jLabel28, gridBagConstraints);
/*      */     
/* 1009 */     this.jTextField6.setEditable(false);
/* 1010 */     this.jTextField6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1012 */     gridBagConstraints = new GridBagConstraints();
/* 1013 */     gridBagConstraints.gridx = 4;
/* 1014 */     gridBagConstraints.gridy = 4;
/* 1015 */     gridBagConstraints.gridwidth = 5;
/* 1016 */     gridBagConstraints.fill = 2;
/* 1017 */     gridBagConstraints.weightx = 1.0D;
/* 1018 */     this.jPanel56.add(this.jTextField6, gridBagConstraints);
/*      */     
/* 1020 */     this.jLabel29.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1022 */     this.jLabel29.setText("Sexo");
/* 1023 */     gridBagConstraints = new GridBagConstraints();
/* 1024 */     gridBagConstraints.gridx = 2;
/* 1025 */     gridBagConstraints.gridy = 6;
/* 1026 */     gridBagConstraints.fill = 2;
/* 1027 */     gridBagConstraints.anchor = 17;
/* 1028 */     this.jPanel56.add(this.jLabel29, gridBagConstraints);
/*      */     
/* 1030 */     this.jTextField18.setEditable(false);
/* 1031 */     this.jTextField18.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1033 */     gridBagConstraints = new GridBagConstraints();
/* 1034 */     gridBagConstraints.gridx = 4;
/* 1035 */     gridBagConstraints.gridy = 6;
/* 1036 */     gridBagConstraints.gridwidth = 5;
/* 1037 */     gridBagConstraints.fill = 2;
/* 1038 */     gridBagConstraints.weightx = 1.0D;
/* 1039 */     this.jPanel56.add(this.jTextField18, gridBagConstraints);
/*      */     
/* 1041 */     this.jLabel23.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1043 */     this.jLabel23.setText("Teléfono");
/* 1044 */     gridBagConstraints = new GridBagConstraints();
/* 1045 */     gridBagConstraints.gridx = 2;
/* 1046 */     gridBagConstraints.gridy = 8;
/* 1047 */     gridBagConstraints.fill = 2;
/* 1048 */     gridBagConstraints.anchor = 17;
/* 1049 */     this.jPanel56.add(this.jLabel23, gridBagConstraints);
/*      */     
/* 1051 */     this.jTextField14.setEditable(false);
/* 1052 */     this.jTextField14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1054 */     gridBagConstraints = new GridBagConstraints();
/* 1055 */     gridBagConstraints.gridx = 4;
/* 1056 */     gridBagConstraints.gridy = 8;
/* 1057 */     gridBagConstraints.gridwidth = 5;
/* 1058 */     gridBagConstraints.fill = 2;
/* 1059 */     gridBagConstraints.weightx = 1.0D;
/* 1060 */     this.jPanel56.add(this.jTextField14, gridBagConstraints);
/*      */     
/* 1062 */     this.jLabel24.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1064 */     this.jLabel24.setText("Celular");
/* 1065 */     gridBagConstraints = new GridBagConstraints();
/* 1066 */     gridBagConstraints.gridx = 2;
/* 1067 */     gridBagConstraints.gridy = 10;
/* 1068 */     gridBagConstraints.fill = 2;
/* 1069 */     gridBagConstraints.anchor = 17;
/* 1070 */     this.jPanel56.add(this.jLabel24, gridBagConstraints);
/*      */     
/* 1072 */     this.jTextField15.setEditable(false);
/* 1073 */     this.jTextField15.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1075 */     gridBagConstraints = new GridBagConstraints();
/* 1076 */     gridBagConstraints.gridx = 4;
/* 1077 */     gridBagConstraints.gridy = 10;
/* 1078 */     gridBagConstraints.gridwidth = 5;
/* 1079 */     gridBagConstraints.fill = 2;
/* 1080 */     gridBagConstraints.weightx = 1.0D;
/* 1081 */     this.jPanel56.add(this.jTextField15, gridBagConstraints);
/*      */     
/* 1083 */     this.jLabel30.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1085 */     this.jLabel30.setText("Nextel");
/* 1086 */     gridBagConstraints = new GridBagConstraints();
/* 1087 */     gridBagConstraints.gridx = 2;
/* 1088 */     gridBagConstraints.gridy = 12;
/* 1089 */     gridBagConstraints.fill = 2;
/* 1090 */     gridBagConstraints.anchor = 17;
/* 1091 */     this.jPanel56.add(this.jLabel30, gridBagConstraints);
/*      */     
/* 1093 */     this.jTextField19.setEditable(false);
/* 1094 */     this.jTextField19.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1096 */     this.jTextField19.setText("jTextField19");
/* 1097 */     gridBagConstraints = new GridBagConstraints();
/* 1098 */     gridBagConstraints.gridx = 4;
/* 1099 */     gridBagConstraints.gridy = 12;
/* 1100 */     gridBagConstraints.gridwidth = 5;
/* 1101 */     gridBagConstraints.fill = 2;
/* 1102 */     gridBagConstraints.weightx = 1.0D;
/* 1103 */     this.jPanel56.add(this.jTextField19, gridBagConstraints);
/*      */     
/* 1105 */     this.jLabel25.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1107 */     this.jLabel25.setText("Fecha de Nacimiento");
/* 1108 */     gridBagConstraints = new GridBagConstraints();
/* 1109 */     gridBagConstraints.gridx = 2;
/* 1110 */     gridBagConstraints.gridy = 16;
/* 1111 */     gridBagConstraints.fill = 2;
/* 1112 */     gridBagConstraints.anchor = 17;
/* 1113 */     this.jPanel56.add(this.jLabel25, gridBagConstraints);
/*      */     
/* 1115 */     this.jTextField16.setEditable(false);
/* 1116 */     this.jTextField16.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1118 */     gridBagConstraints = new GridBagConstraints();
/* 1119 */     gridBagConstraints.gridx = 4;
/* 1120 */     gridBagConstraints.gridy = 16;
/* 1121 */     gridBagConstraints.gridwidth = 5;
/* 1122 */     gridBagConstraints.fill = 2;
/* 1123 */     gridBagConstraints.weightx = 1.0D;
/* 1124 */     this.jPanel56.add(this.jTextField16, gridBagConstraints);
/*      */     
/* 1126 */     this.jLabel31.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1128 */     this.jLabel31.setText("Lugar de Nacimiento");
/* 1129 */     gridBagConstraints = new GridBagConstraints();
/* 1130 */     gridBagConstraints.gridx = 2;
/* 1131 */     gridBagConstraints.gridy = 14;
/* 1132 */     gridBagConstraints.fill = 2;
/* 1133 */     gridBagConstraints.anchor = 17;
/* 1134 */     this.jPanel56.add(this.jLabel31, gridBagConstraints);
/*      */     
/* 1136 */     this.jTextField25.setEditable(false);
/* 1137 */     this.jTextField25.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1139 */     this.jTextField25.setText("jTextField25");
/* 1140 */     gridBagConstraints = new GridBagConstraints();
/* 1141 */     gridBagConstraints.gridx = 4;
/* 1142 */     gridBagConstraints.gridy = 14;
/* 1143 */     gridBagConstraints.gridwidth = 5;
/* 1144 */     gridBagConstraints.fill = 2;
/* 1145 */     gridBagConstraints.weightx = 1.0D;
/* 1146 */     this.jPanel56.add(this.jTextField25, gridBagConstraints);
/*      */     
/* 1148 */     this.jLabel43.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1150 */     this.jLabel43.setText("Número de Seguro Social");
/* 1151 */     gridBagConstraints = new GridBagConstraints();
/* 1152 */     gridBagConstraints.gridx = 2;
/* 1153 */     gridBagConstraints.gridy = 18;
/* 1154 */     gridBagConstraints.fill = 2;
/* 1155 */     gridBagConstraints.anchor = 17;
/* 1156 */     this.jPanel56.add(this.jLabel43, gridBagConstraints);
/*      */     
/* 1158 */     this.jTextField20.setEditable(false);
/* 1159 */     this.jTextField20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1161 */     this.jTextField20.setHorizontalAlignment(4);
/* 1162 */     gridBagConstraints = new GridBagConstraints();
/* 1163 */     gridBagConstraints.gridx = 4;
/* 1164 */     gridBagConstraints.gridy = 18;
/* 1165 */     gridBagConstraints.gridwidth = 5;
/* 1166 */     gridBagConstraints.fill = 2;
/* 1167 */     gridBagConstraints.weightx = 1.0D;
/* 1168 */     this.jPanel56.add(this.jTextField20, gridBagConstraints);
/*      */     
/* 1170 */     this.jLabel32.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1172 */     this.jLabel32.setText("RFC");
/* 1173 */     gridBagConstraints = new GridBagConstraints();
/* 1174 */     gridBagConstraints.gridx = 2;
/* 1175 */     gridBagConstraints.gridy = 20;
/* 1176 */     gridBagConstraints.fill = 2;
/* 1177 */     gridBagConstraints.anchor = 17;
/* 1178 */     this.jPanel56.add(this.jLabel32, gridBagConstraints);
/*      */     
/* 1180 */     this.jTextField26.setEditable(false);
/* 1181 */     this.jTextField26.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1183 */     this.jTextField26.setText("jTextField26");
/* 1184 */     gridBagConstraints = new GridBagConstraints();
/* 1185 */     gridBagConstraints.gridx = 4;
/* 1186 */     gridBagConstraints.gridy = 20;
/* 1187 */     gridBagConstraints.gridwidth = 5;
/* 1188 */     gridBagConstraints.fill = 2;
/* 1189 */     gridBagConstraints.weightx = 1.0D;
/* 1190 */     this.jPanel56.add(this.jTextField26, gridBagConstraints);
/*      */     
/* 1192 */     this.jLabel38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1194 */     this.jLabel38.setText("CURP");
/* 1195 */     gridBagConstraints = new GridBagConstraints();
/* 1196 */     gridBagConstraints.gridx = 2;
/* 1197 */     gridBagConstraints.gridy = 22;
/* 1198 */     gridBagConstraints.fill = 2;
/* 1199 */     gridBagConstraints.anchor = 17;
/* 1200 */     this.jPanel56.add(this.jLabel38, gridBagConstraints);
/*      */     
/* 1202 */     this.jTextField21.setEditable(false);
/* 1203 */     this.jTextField21.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1205 */     gridBagConstraints = new GridBagConstraints();
/* 1206 */     gridBagConstraints.gridx = 4;
/* 1207 */     gridBagConstraints.gridy = 22;
/* 1208 */     gridBagConstraints.gridwidth = 5;
/* 1209 */     gridBagConstraints.fill = 2;
/* 1210 */     gridBagConstraints.weightx = 1.0D;
/* 1211 */     this.jPanel56.add(this.jTextField21, gridBagConstraints);
/*      */     
/* 1213 */     this.jLabel50.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1215 */     this.jLabel50.setText("Infonavit");
/* 1216 */     gridBagConstraints = new GridBagConstraints();
/* 1217 */     gridBagConstraints.gridx = 2;
/* 1218 */     gridBagConstraints.gridy = 26;
/* 1219 */     gridBagConstraints.fill = 2;
/* 1220 */     gridBagConstraints.anchor = 17;
/* 1221 */     this.jPanel56.add(this.jLabel50, gridBagConstraints);
/*      */     
/* 1223 */     this.jTextField22.setEditable(false);
/* 1224 */     this.jTextField22.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1226 */     gridBagConstraints = new GridBagConstraints();
/* 1227 */     gridBagConstraints.gridx = 4;
/* 1228 */     gridBagConstraints.gridy = 26;
/* 1229 */     gridBagConstraints.fill = 2;
/* 1230 */     gridBagConstraints.weightx = 1.0D;
/* 1231 */     this.jPanel56.add(this.jTextField22, gridBagConstraints);
/*      */     
/* 1233 */     this.jLabel53.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1235 */     this.jLabel53.setText("Cantidad");
/* 1236 */     gridBagConstraints = new GridBagConstraints();
/* 1237 */     gridBagConstraints.gridx = 6;
/* 1238 */     gridBagConstraints.gridy = 26;
/* 1239 */     gridBagConstraints.fill = 2;
/* 1240 */     this.jPanel56.add(this.jLabel53, gridBagConstraints);
/*      */     
/* 1242 */     this.jTextField23.setEditable(false);
/* 1243 */     this.jTextField23.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1245 */     this.jTextField23.setHorizontalAlignment(4);
/* 1246 */     gridBagConstraints = new GridBagConstraints();
/* 1247 */     gridBagConstraints.gridx = 8;
/* 1248 */     gridBagConstraints.gridy = 26;
/* 1249 */     gridBagConstraints.fill = 2;
/* 1250 */     gridBagConstraints.weightx = 0.5D;
/* 1251 */     this.jPanel56.add(this.jTextField23, gridBagConstraints);
/*      */     
/* 1253 */     this.jLabel39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1255 */     this.jLabel39.setText("Cargo Automático de Infornavit");
/* 1256 */     gridBagConstraints = new GridBagConstraints();
/* 1257 */     gridBagConstraints.gridx = 2;
/* 1258 */     gridBagConstraints.gridy = 24;
/* 1259 */     gridBagConstraints.fill = 2;
/* 1260 */     gridBagConstraints.anchor = 17;
/* 1261 */     this.jPanel56.add(this.jLabel39, gridBagConstraints);
/*      */     
/* 1263 */     this.jTextField30.setEditable(false);
/* 1264 */     this.jTextField30.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1266 */     this.jTextField30.setText("jTextField30");
/* 1267 */     gridBagConstraints = new GridBagConstraints();
/* 1268 */     gridBagConstraints.gridx = 4;
/* 1269 */     gridBagConstraints.gridy = 24;
/* 1270 */     gridBagConstraints.gridwidth = 5;
/* 1271 */     gridBagConstraints.fill = 2;
/* 1272 */     gridBagConstraints.weightx = 1.0D;
/* 1273 */     this.jPanel56.add(this.jTextField30, gridBagConstraints);
/*      */     
/* 1275 */     this.jLabel41.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1277 */     this.jLabel41.setText("Estado Civil");
/* 1278 */     gridBagConstraints = new GridBagConstraints();
/* 1279 */     gridBagConstraints.gridx = 2;
/* 1280 */     gridBagConstraints.gridy = 28;
/* 1281 */     gridBagConstraints.fill = 2;
/* 1282 */     gridBagConstraints.anchor = 17;
/* 1283 */     this.jPanel56.add(this.jLabel41, gridBagConstraints);
/*      */     
/* 1285 */     this.jTextField31.setEditable(false);
/* 1286 */     this.jTextField31.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1288 */     this.jTextField31.setText("jTextField31");
/* 1289 */     gridBagConstraints = new GridBagConstraints();
/* 1290 */     gridBagConstraints.gridx = 4;
/* 1291 */     gridBagConstraints.gridy = 28;
/* 1292 */     gridBagConstraints.gridwidth = 5;
/* 1293 */     gridBagConstraints.fill = 2;
/* 1294 */     gridBagConstraints.weightx = 1.0D;
/* 1295 */     this.jPanel56.add(this.jTextField31, gridBagConstraints);
/*      */     
/* 1297 */     this.jLabel42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1299 */     this.jLabel42.setText("Número de hijos");
/* 1300 */     gridBagConstraints = new GridBagConstraints();
/* 1301 */     gridBagConstraints.gridx = 2;
/* 1302 */     gridBagConstraints.gridy = 30;
/* 1303 */     gridBagConstraints.fill = 2;
/* 1304 */     gridBagConstraints.anchor = 17;
/* 1305 */     this.jPanel56.add(this.jLabel42, gridBagConstraints);
/*      */     
/* 1307 */     this.jTextField32.setEditable(false);
/* 1308 */     this.jTextField32.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 1310 */     this.jTextField32.setHorizontalAlignment(4);
/* 1311 */     this.jTextField32.setText("jTextField32");
/* 1312 */     gridBagConstraints = new GridBagConstraints();
/* 1313 */     gridBagConstraints.gridx = 4;
/* 1314 */     gridBagConstraints.gridy = 30;
/* 1315 */     gridBagConstraints.gridwidth = 5;
/* 1316 */     gridBagConstraints.fill = 2;
/* 1317 */     gridBagConstraints.weightx = 1.0D;
/* 1318 */     this.jPanel56.add(this.jTextField32, gridBagConstraints);
/*      */     
/* 1320 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/* 1321 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/* 1322 */     this.materialButton38.setMnemonic('C');
/* 1323 */     this.materialButton38.setText("Cerrar");
/* 1324 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/* 1325 */     this.materialButton38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 1326 */     this.materialButton38.setHorizontalTextPosition(0);
/* 1327 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1329 */             EmpleadosBuscar.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1333 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/* 1334 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/* 1335 */     this.materialButton39.setMnemonic('I');
/* 1336 */     this.materialButton39.setText("Imprimir");
/* 1337 */     this.materialButton39.setToolTipText("Imprimir (Alt+I)");
/* 1338 */     this.materialButton39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 1339 */     this.materialButton39.setHorizontalTextPosition(0);
/* 1340 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1342 */             EmpleadosBuscar.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1346 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/* 1347 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/* 1348 */     this.materialButton40.setMnemonic('E');
/* 1349 */     this.materialButton40.setText(" Enviar Correo");
/* 1350 */     this.materialButton40.setToolTipText("Enviar por correo (Alt+E)");
/* 1351 */     this.materialButton40.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 1352 */     this.materialButton40.setHorizontalAlignment(4);
/* 1353 */     this.materialButton40.setHorizontalTextPosition(4);
/* 1354 */     this.materialButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1356 */             EmpleadosBuscar.this.materialButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1360 */     this.materialButton41.setBackground(this.lc.PRIMARIO1);
/* 1361 */     this.materialButton41.setForeground(new Color(255, 255, 255));
/* 1362 */     this.materialButton41.setMnemonic('G');
/* 1363 */     this.materialButton41.setText("Gafetes");
/* 1364 */     this.materialButton41.setToolTipText("Gafetes (Alt+G)");
/* 1365 */     this.materialButton41.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 1366 */     this.materialButton41.setHorizontalTextPosition(0);
/* 1367 */     this.materialButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1369 */             EmpleadosBuscar.this.materialButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1373 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/* 1374 */     this.jPanel53.setLayout(jPanel53Layout);
/* 1375 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/* 1376 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1377 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/* 1378 */           .addContainerGap(-1, 32767)
/* 1379 */           .addComponent((Component)this.materialButton41, -2, 105, -2)
/* 1380 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1381 */           .addComponent((Component)this.materialButton40, -2, 105, -2)
/* 1382 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1383 */           .addComponent((Component)this.materialButton39, -2, 105, -2)
/* 1384 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1385 */           .addComponent((Component)this.materialButton38, -2, 105, -2)
/* 1386 */           .addContainerGap()));
/*      */     
/* 1388 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/* 1389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1390 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/* 1391 */           .addContainerGap(-1, 32767)
/* 1392 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1393 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/* 1394 */             .addComponent((Component)this.materialButton39, -2, 38, -2)
/* 1395 */             .addComponent((Component)this.materialButton40, -2, 38, -2)
/* 1396 */             .addComponent((Component)this.materialButton41, -2, 38, -2))
/* 1397 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1400 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 1401 */     this.jPanel52.setLayout(jPanel52Layout);
/* 1402 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 1403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1404 */         .addComponent(this.jPanel53, -1, -1, 32767)
/* 1405 */         .addComponent(this.jPanel56, -1, -1, 32767));
/*      */     
/* 1407 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 1408 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1409 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
/* 1410 */           .addComponent(this.jPanel56, -1, 574, 32767)
/* 1411 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1412 */           .addComponent(this.jPanel53, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1415 */     this.jPanel1.add(this.jPanel52);
/* 1416 */     this.jPanel52.setBounds(190, 33, 535, 630);
/*      */     
/* 1418 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1419 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1420 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1421 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1422 */         .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1424 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1425 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1426 */         .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */ 
/*      */     
/* 1429 */     this.jDialog3.setTitle("Agregar Comentario");
/* 1430 */     this.jDialog3.setModal(true);
/*      */     
/* 1432 */     this.jLabel125.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1433 */     this.jLabel125.setHorizontalAlignment(4);
/* 1434 */     this.jLabel125.setText("Comentario");
/*      */     
/* 1436 */     this.jTextArea5.setColumns(20);
/* 1437 */     this.jTextArea5.setLineWrap(true);
/* 1438 */     this.jTextArea5.setRows(5);
/* 1439 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1441 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1442 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1443 */     this.materialButton36.setMnemonic('C');
/* 1444 */     this.materialButton36.setText("Cerrar");
/* 1445 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1446 */     this.materialButton36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1447 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1448 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1450 */             EmpleadosBuscar.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1454 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1455 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1456 */     this.materialButton37.setMnemonic('G');
/* 1457 */     this.materialButton37.setText("Guardar");
/* 1458 */     this.materialButton37.setToolTipText("Guardar (Alt+G)");
/* 1459 */     this.materialButton37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1460 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1461 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1463 */             EmpleadosBuscar.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1467 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1468 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1469 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1470 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1471 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1472 */           .addComponent(this.jLabel125, -2, 74, -2)
/* 1473 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767)
/* 1474 */           .addComponent(this.jScrollPane18, -2, 302, -2)
/* 1475 */           .addContainerGap())
/* 1476 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1477 */           .addGap(0, 0, 32767)
/* 1478 */           .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 1479 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1480 */           .addComponent((Component)this.materialButton36, -2, 105, -2)));
/*      */     
/* 1482 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1483 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1484 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1485 */           .addContainerGap()
/* 1486 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1487 */             .addComponent(this.jLabel125)
/* 1488 */             .addComponent(this.jScrollPane18, -2, 121, -2))
/* 1489 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1490 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1491 */             .addComponent((Component)this.materialButton36, -2, 38, -2)
/* 1492 */             .addComponent((Component)this.materialButton37, -2, 38, -2))
/* 1493 */           .addContainerGap(28, 32767)));
/*      */ 
/*      */     
/* 1496 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1497 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1498 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1499 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1500 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */     
/* 1502 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1503 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1504 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */ 
/*      */     
/* 1507 */     this.jDialog4.setTitle("Impresión de Gafetes");
/* 1508 */     this.jDialog4.setModal(true);
/*      */     
/* 1510 */     this.jLabel12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1511 */     this.jLabel12.setText("<html>Selecciona el tipo de gafete que deseas crear y a continuación pulsa el botón siguiente</html>");
/*      */     
/* 1513 */     this.jPanel5.setLayout(new GridLayout(1, 2, 10, 0));
/*      */     
/* 1515 */     this.jRadioButton7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1516 */     this.jRadioButton7.setSelected(true);
/* 1517 */     this.jRadioButton7.setText("Credencial Forsis");
/* 1518 */     this.jPanel5.add(this.jRadioButton7);
/*      */     
/* 1520 */     this.jRadioButton8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1521 */     this.jRadioButton8.setText("Curso Básico");
/* 1522 */     this.jRadioButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1524 */             EmpleadosBuscar.this.jRadioButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1527 */     this.jPanel5.add(this.jRadioButton8);
/*      */     
/* 1529 */     this.materialButton27.setBackground(this.lc.SECUNDARIO1);
/* 1530 */     this.materialButton27.setForeground(new Color(255, 255, 255));
/* 1531 */     this.materialButton27.setMnemonic('C');
/* 1532 */     this.materialButton27.setText("Cancelar");
/* 1533 */     this.materialButton27.setToolTipText("Cancelar (Alt+C)");
/* 1534 */     this.materialButton27.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 1535 */     this.materialButton27.setHorizontalTextPosition(0);
/* 1536 */     this.materialButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1538 */             EmpleadosBuscar.this.materialButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1542 */     this.materialButton28.setBackground(this.lc.SECUNDARIO1);
/* 1543 */     this.materialButton28.setForeground(new Color(255, 255, 255));
/* 1544 */     this.materialButton28.setMnemonic('C');
/* 1545 */     this.materialButton28.setText("Siguiente >");
/* 1546 */     this.materialButton28.setToolTipText("Cancelar (Alt+C)");
/* 1547 */     this.materialButton28.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 1548 */     this.materialButton28.setHorizontalTextPosition(0);
/* 1549 */     this.materialButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1551 */             EmpleadosBuscar.this.materialButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1555 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1556 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1557 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1559 */         .addComponent(this.jLabel12, -1, 379, 32767)
/* 1560 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 1561 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 1562 */           .addContainerGap(-1, 32767)
/* 1563 */           .addComponent((Component)this.materialButton28, -2, 105, -2)
/* 1564 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1565 */           .addComponent((Component)this.materialButton27, -2, 105, -2)
/* 1566 */           .addContainerGap()));
/*      */     
/* 1568 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1569 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1570 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1571 */           .addComponent(this.jLabel12, -2, 42, -2)
/* 1572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1573 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 1574 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1575 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1576 */             .addComponent((Component)this.materialButton27, -2, 38, -2)
/* 1577 */             .addComponent((Component)this.materialButton28, -2, 38, -2))
/* 1578 */           .addContainerGap(72, 32767)));
/*      */ 
/*      */     
/* 1581 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1582 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1583 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1584 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1585 */         .addComponent(this.jPanel7, -2, -1, -2));
/*      */     
/* 1587 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1588 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1589 */         .addComponent(this.jPanel7, -2, -1, -2));
/*      */ 
/*      */     
/* 1592 */     this.jLabel119.setText("Coloca la vigencia");
/*      */     
/* 1594 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 1595 */     this.jDateChooser8.setIcon(this.icon);
/*      */     
/* 1597 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1598 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1599 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1600 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1601 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1602 */           .addContainerGap()
/* 1603 */           .addComponent(this.jLabel119, -2, 115, 32767)
/* 1604 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1605 */           .addComponent((Component)this.jDateChooser8, -2, 108, -2)
/* 1606 */           .addContainerGap()));
/*      */     
/* 1608 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1609 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1610 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1611 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1612 */             .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1613 */             .addComponent(this.jLabel119, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1614 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1617 */     this.jDialog5.setTitle("Impresión de Gafetes");
/* 1618 */     this.jDialog5.setModal(true);
/*      */     
/* 1620 */     this.jPanel25.setBackground(new Color(255, 255, 255));
/*      */     
/* 1622 */     this.jLabel67.setFont(new Font("Times New Roman", 1, 20));
/* 1623 */     this.jLabel67.setHorizontalAlignment(0);
/* 1624 */     this.jLabel67.setText("Credencial RigPass para Locaciones");
/*      */     
/* 1626 */     this.jLabel69.setFont(new Font("Tahoma", 1, 12));
/* 1627 */     this.jLabel69.setForeground(new Color(153, 153, 153));
/* 1628 */     this.jLabel69.setText("Frente       Frente       Frente       Frente       Frente       Frente       Frente");
/*      */     
/* 1630 */     this.jLabel70.setFont(new Font("Tahoma", 1, 12));
/* 1631 */     this.jLabel70.setForeground(new Color(153, 153, 153));
/* 1632 */     this.jLabel70.setText("Reverso      Reverso      Reverso      Reverso      Reverso      Reverso ");
/*      */     
/* 1634 */     this.jButton19.setMnemonic('C');
/* 1635 */     this.jButton19.setText("Cancelar");
/* 1636 */     this.jButton19.setToolTipText("Cancelar (Alt+C)");
/* 1637 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1639 */             EmpleadosBuscar.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1643 */     this.jButton20.setMnemonic('I');
/* 1644 */     this.jButton20.setText("Imprimir");
/* 1645 */     this.jButton20.setToolTipText("Imprimir (Alt+I)");
/* 1646 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1648 */             EmpleadosBuscar.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1652 */     this.jButton21.setMnemonic('R');
/* 1653 */     this.jButton21.setText("< Regresar");
/* 1654 */     this.jButton21.setToolTipText("Regresar (Alt+R)");
/* 1655 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1657 */             EmpleadosBuscar.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1661 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/* 1662 */     this.jPanel26.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1663 */     this.jPanel26.setLayout((LayoutManager)null);
/*      */     
/* 1665 */     this.jLabel107.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis50.png")));
/* 1666 */     this.jPanel26.add(this.jLabel107);
/* 1667 */     this.jLabel107.setBounds(10, 10, 50, 50);
/*      */     
/* 1669 */     this.jLabel108.setFont(new Font("Tahoma", 1, 13));
/* 1670 */     this.jLabel108.setForeground(new Color(0, 51, 204));
/* 1671 */     this.jLabel108.setHorizontalAlignment(0);
/* 1672 */     this.jLabel108.setText("<html><u>CURSO DE SEGURIDAD BÁSICA</u></html>");
/* 1673 */     this.jPanel26.add(this.jLabel108);
/* 1674 */     this.jLabel108.setBounds(110, 120, 300, 20);
/*      */     
/* 1676 */     this.jLabel109.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png")));
/* 1677 */     this.jPanel26.add(this.jLabel109);
/* 1678 */     this.jLabel109.setBounds(70, 30, 350, 40);
/*      */     
/* 1680 */     this.jLabel111.setFont(new Font("Tahoma", 1, 14));
/* 1681 */     this.jLabel111.setForeground(new Color(0, 51, 204));
/* 1682 */     this.jLabel111.setHorizontalAlignment(0);
/* 1683 */     this.jLabel111.setText("FLETES Y MATERIALES FORSIS S.A. DE C.V.");
/* 1684 */     this.jPanel26.add(this.jLabel111);
/* 1685 */     this.jLabel111.setBounds(60, 10, 340, 20);
/*      */     
/* 1687 */     this.jLabel112.setFont(new Font("Tahoma", 1, 11));
/* 1688 */     this.jLabel112.setHorizontalAlignment(0);
/* 1689 */     this.jLabel112.setText("ACREDITA A:");
/* 1690 */     this.jPanel26.add(this.jLabel112);
/* 1691 */     this.jLabel112.setBounds(110, 70, 290, 16);
/*      */     
/* 1693 */     this.jLabel113.setFont(new Font("Tahoma", 1, 11));
/* 1694 */     this.jLabel113.setForeground(new Color(0, 51, 204));
/* 1695 */     this.jLabel113.setHorizontalAlignment(0);
/* 1696 */     this.jLabel113.setText("UZZIEL CONTRERAS PORTILLA");
/* 1697 */     this.jPanel26.add(this.jLabel113);
/* 1698 */     this.jLabel113.setBounds(110, 90, 300, 16);
/*      */     
/* 1700 */     this.jLabel114.setHorizontalAlignment(0);
/* 1701 */     this.jLabel114.setText("DE HABER:");
/* 1702 */     this.jPanel26.add(this.jLabel114);
/* 1703 */     this.jLabel114.setBounds(110, 110, 290, 19);
/*      */     
/* 1705 */     this.jLabel116.setHorizontalAlignment(0);
/* 1706 */     this.jLabel116.setText("<html><center>Certificado por:<br>SECRETARÍA DEL TRABAJO Y PREVISION SOCIAL\n</center></html>");
/* 1707 */     this.jPanel26.add(this.jLabel116);
/* 1708 */     this.jLabel116.setBounds(110, 190, 300, 30);
/*      */     
/* 1710 */     this.jLabel117.setHorizontalAlignment(0);
/* 1711 */     this.jLabel117.setText("VACJ 710806 TU8 0013");
/* 1712 */     this.jPanel26.add(this.jLabel117);
/* 1713 */     this.jLabel117.setBounds(110, 154, 300, 30);
/*      */     
/* 1715 */     this.jLabel110.setFont(new Font("Tahoma", 0, 10));
/* 1716 */     this.jLabel110.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/* 1717 */     this.jPanel26.add(this.jLabel110);
/* 1718 */     this.jLabel110.setBounds(0, 220, 450, 30);
/*      */     
/* 1720 */     this.jLabel115.setHorizontalAlignment(0);
/* 1721 */     this.jLabel115.setText("sin foto");
/* 1722 */     this.jLabel115.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1723 */     this.jPanel26.add(this.jLabel115);
/* 1724 */     this.jLabel115.setBounds(10, 80, 110, 130);
/*      */     
/* 1726 */     this.jLabel120.setHorizontalAlignment(0);
/* 1727 */     this.jLabel120.setText("AGENTE CAPACITADOR");
/* 1728 */     this.jPanel26.add(this.jLabel120);
/* 1729 */     this.jLabel120.setBounds(110, 140, 300, 19);
/*      */     
/* 1731 */     this.jPanel27.setBackground(new Color(255, 255, 255));
/* 1732 */     this.jPanel27.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1733 */     this.jPanel27.setLayout((LayoutManager)null);
/*      */     
/* 1735 */     this.jLabel121.setFont(new Font("Tahoma", 1, 14));
/* 1736 */     this.jLabel121.setForeground(new Color(0, 51, 204));
/* 1737 */     this.jLabel121.setHorizontalAlignment(0);
/* 1738 */     this.jLabel121.setText("CURSO DE SEGURIDAD BÁSICA");
/* 1739 */     this.jPanel27.add(this.jLabel121);
/* 1740 */     this.jLabel121.setBounds(60, 10, 340, 20);
/*      */     
/* 1742 */     this.jLabel129.setFont(new Font("Tahoma", 0, 12));
/* 1743 */     this.jLabel129.setForeground(new Color(0, 51, 153));
/* 1744 */     this.jLabel129.setText("COPU01087464");
/* 1745 */     this.jPanel27.add(this.jLabel129);
/* 1746 */     this.jLabel129.setBounds(160, 70, 260, 17);
/*      */     
/* 1748 */     this.jLabel130.setFont(new Font("Tahoma", 1, 11));
/* 1749 */     this.jLabel130.setText("CURP:");
/* 1750 */     this.jPanel27.add(this.jLabel130);
/* 1751 */     this.jLabel130.setBounds(10, 70, 140, 16);
/*      */     
/* 1753 */     this.jLabel131.setFont(new Font("Tahoma", 1, 11));
/* 1754 */     this.jLabel131.setText("NOMBRE DEL EMPLEADO:");
/* 1755 */     this.jPanel27.add(this.jLabel131);
/* 1756 */     this.jLabel131.setBounds(10, 40, 140, 16);
/*      */     
/* 1758 */     this.jLabel132.setFont(new Font("Tahoma", 0, 12));
/* 1759 */     this.jLabel132.setForeground(new Color(0, 51, 153));
/* 1760 */     this.jLabel132.setText("NOMBRE DEL EMPLEADO:");
/* 1761 */     this.jPanel27.add(this.jLabel132);
/* 1762 */     this.jLabel132.setBounds(160, 40, 260, 17);
/*      */     
/* 1764 */     this.jLabel133.setFont(new Font("Tahoma", 1, 11));
/* 1765 */     this.jLabel133.setText("IMSS:");
/* 1766 */     this.jPanel27.add(this.jLabel133);
/* 1767 */     this.jLabel133.setBounds(10, 100, 140, 16);
/*      */     
/* 1769 */     this.jLabel134.setFont(new Font("Tahoma", 0, 12));
/* 1770 */     this.jLabel134.setForeground(new Color(0, 51, 153));
/* 1771 */     this.jLabel134.setText("9837476276343");
/* 1772 */     this.jPanel27.add(this.jLabel134);
/* 1773 */     this.jLabel134.setBounds(160, 100, 260, 17);
/*      */     
/* 1775 */     this.jLabel135.setFont(new Font("Tahoma", 1, 11));
/* 1776 */     this.jLabel135.setForeground(new Color(0, 51, 153));
/* 1777 */     this.jLabel135.setText("00001");
/* 1778 */     this.jPanel27.add(this.jLabel135);
/* 1779 */     this.jLabel135.setBounds(380, 220, 60, 16);
/*      */     
/* 1781 */     this.jLabel136.setFont(new Font("Tahoma", 0, 12));
/* 1782 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/* 1783 */     this.jLabel136.setText("ENERO 2011");
/* 1784 */     this.jLabel136.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1786 */             EmpleadosBuscar.this.jLabel136MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1789 */             EmpleadosBuscar.this.jLabel136MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1792 */             EmpleadosBuscar.this.jLabel136MouseExited(evt);
/*      */           }
/*      */         });
/* 1795 */     this.jPanel27.add(this.jLabel136);
/* 1796 */     this.jLabel136.setBounds(160, 130, 260, 17);
/*      */     
/* 1798 */     this.jLabel71.setFont(new Font("Tahoma", 1, 11));
/* 1799 */     this.jLabel71.setHorizontalAlignment(0);
/* 1800 */     this.jLabel71.setText("<html><center>DE ACUERDO A LOS LINEAMIENTOS DE:<br>\"INTERNATIONAL ASSOCIATION OF DRILLI NG CONTRACTORS\"</center></html>");
/* 1801 */     this.jPanel27.add(this.jLabel71);
/* 1802 */     this.jLabel71.setBounds(10, 150, 420, 40);
/*      */     
/* 1804 */     this.jLabel137.setFont(new Font("Tahoma", 1, 11));
/* 1805 */     this.jLabel137.setText("VIGENCIA:");
/* 1806 */     this.jPanel27.add(this.jLabel137);
/* 1807 */     this.jLabel137.setBounds(10, 130, 140, 16);
/*      */     
/* 1809 */     this.jLabel118.setText("__________________");
/* 1810 */     this.jPanel27.add(this.jLabel118);
/* 1811 */     this.jLabel118.setBounds(60, 220, 160, 19);
/*      */     
/* 1813 */     this.jLabel138.setFont(new Font("Tahoma", 1, 11));
/* 1814 */     this.jLabel138.setText("Firma:");
/* 1815 */     this.jPanel27.add(this.jLabel138);
/* 1816 */     this.jLabel138.setBounds(10, 220, 50, 16);
/*      */     
/* 1818 */     this.jLabel139.setFont(new Font("Tahoma", 1, 11));
/* 1819 */     this.jLabel139.setHorizontalAlignment(4);
/* 1820 */     this.jLabel139.setText("FPR-");
/* 1821 */     this.jPanel27.add(this.jLabel139);
/* 1822 */     this.jLabel139.setBounds(320, 220, 50, 16);
/*      */     
/* 1824 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1825 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1826 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1827 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1828 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1829 */           .addContainerGap()
/* 1830 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1831 */             .addGroup(jPanel25Layout.createSequentialGroup()
/* 1832 */               .addComponent(this.jButton21, -2, 97, -2)
/* 1833 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1834 */               .addComponent(this.jButton20, -2, 97, -2)
/* 1835 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1836 */               .addComponent(this.jButton19, -2, 97, -2))
/* 1837 */             .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1838 */               .addComponent(this.jPanel27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1839 */               .addComponent(this.jLabel70, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1840 */               .addComponent(this.jLabel67, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1841 */               .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING)
/* 1842 */               .addComponent(this.jPanel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1843 */               .addComponent(this.jLabel69, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1844 */           .addContainerGap(23, 32767)));
/*      */     
/* 1846 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1847 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1848 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1849 */           .addComponent(this.jLabel67, -2, 34, -2)
/* 1850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1851 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1852 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1853 */           .addComponent(this.jLabel69)
/* 1854 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1855 */           .addComponent(this.jPanel26, -2, 248, -2)
/* 1856 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1857 */           .addComponent(this.jLabel70)
/* 1858 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1859 */           .addComponent(this.jPanel27, -2, 248, -2)
/* 1860 */           .addGap(18, 18, 18)
/* 1861 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1862 */             .addComponent(this.jButton19)
/* 1863 */             .addComponent(this.jButton20)
/* 1864 */             .addComponent(this.jButton21))
/* 1865 */           .addContainerGap(23, 32767)));
/*      */ 
/*      */     
/* 1868 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1869 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1870 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1871 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1872 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */     
/* 1874 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1875 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1876 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */ 
/*      */     
/* 1879 */     this.jDialog6.setTitle("Impresión de Gafetes");
/* 1880 */     this.jDialog6.setModal(true);
/*      */     
/* 1882 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/* 1884 */     this.jLabel62.setFont(new Font("Times New Roman", 1, 20));
/* 1885 */     this.jLabel62.setHorizontalAlignment(0);
/* 1886 */     this.jLabel62.setText("Gafette para empleados");
/*      */     
/* 1888 */     this.jLabel63.setFont(new Font("Tahoma", 1, 12));
/* 1889 */     this.jLabel63.setForeground(new Color(153, 153, 153));
/* 1890 */     this.jLabel63.setText("Frente        Frente        Frente        Frente        Frente        Frente    ");
/*      */     
/* 1892 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/* 1893 */     this.jPanel15.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1894 */     this.jPanel15.setLayout((LayoutManager)null);
/*      */     
/* 1896 */     this.jLabel13.setFont(new Font("Times New Roman", 0, 19));
/* 1897 */     this.jLabel13.setForeground(new Color(153, 0, 0));
/* 1898 */     this.jLabel13.setText("Fletes y Materiales Forsis S.A. de C.V.");
/* 1899 */     this.jPanel15.add(this.jLabel13);
/* 1900 */     this.jLabel13.setBounds(40, 0, 330, 27);
/*      */     
/* 1902 */     this.jLabel33.setText("____________________________________________________");
/* 1903 */     this.jPanel15.add(this.jLabel33);
/* 1904 */     this.jLabel33.setBounds(40, 20, 370, 19);
/*      */     
/* 1906 */     this.jLabel64.setText("___________________________________________________");
/* 1907 */     this.jPanel15.add(this.jLabel64);
/* 1908 */     this.jLabel64.setBounds(20, 10, 370, 19);
/*      */     
/* 1910 */     this.jLabel78.setHorizontalAlignment(0);
/* 1911 */     this.jLabel78.setText("sin foto");
/* 1912 */     this.jLabel78.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1913 */     this.jPanel15.add(this.jLabel78);
/* 1914 */     this.jLabel78.setBounds(10, 40, 110, 130);
/*      */     
/* 1916 */     this.jLabel80.setFont(new Font("Tahoma", 1, 11));
/* 1917 */     this.jLabel80.setHorizontalAlignment(0);
/* 1918 */     this.jLabel80.setText("OP-00001");
/* 1919 */     this.jPanel15.add(this.jLabel80);
/* 1920 */     this.jLabel80.setBounds(10, 170, 110, 16);
/*      */     
/* 1922 */     this.jLabel82.setFont(new Font("Tahoma", 1, 10));
/* 1923 */     this.jLabel82.setText("Nombre Completo");
/* 1924 */     this.jPanel15.add(this.jLabel82);
/* 1925 */     this.jLabel82.setBounds(130, 40, 280, 14);
/*      */     
/* 1927 */     this.jLabel84.setText("Tipo");
/* 1928 */     this.jPanel15.add(this.jLabel84);
/* 1929 */     this.jLabel84.setBounds(130, 90, 230, 19);
/*      */     
/* 1931 */     this.jLabel85.setText("Nss");
/* 1932 */     this.jPanel15.add(this.jLabel85);
/* 1933 */     this.jLabel85.setBounds(130, 110, 230, 19);
/*      */     
/* 1935 */     this.jLabel86.setText("Vigencia");
/* 1936 */     this.jLabel86.setToolTipText("Clic para cambiar la vigencia");
/* 1937 */     this.jLabel86.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1939 */             EmpleadosBuscar.this.jLabel86MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1942 */             EmpleadosBuscar.this.jLabel86MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1945 */             EmpleadosBuscar.this.jLabel86MouseExited(evt);
/*      */           }
/*      */         });
/* 1948 */     this.jPanel15.add(this.jLabel86);
/* 1949 */     this.jLabel86.setBounds(130, 150, 230, 19);
/*      */     
/* 1951 */     this.jPanel16.setBackground(new Color(247, 150, 70));
/*      */     
/* 1953 */     this.jLabel81.setFont(new Font("Tahoma", 1, 11));
/* 1954 */     this.jLabel81.setHorizontalAlignment(0);
/* 1955 */     this.jLabel81.setText("Categoría del Empleado");
/* 1956 */     this.jLabel81.setToolTipText("Clic para cambiar la categoría");
/*      */     
/* 1958 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 1959 */     this.jPanel16.setLayout(jPanel16Layout);
/* 1960 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 1961 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1962 */         .addComponent(this.jLabel81, -1, 280, 32767));
/*      */     
/* 1964 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 1965 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1966 */         .addComponent(this.jLabel81, -1, 20, 32767));
/*      */ 
/*      */     
/* 1969 */     this.jPanel15.add(this.jPanel16);
/* 1970 */     this.jPanel16.setBounds(130, 170, 280, 20);
/*      */     
/* 1972 */     this.jLabel87.setHorizontalAlignment(0);
/* 1973 */     this.jLabel87.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisCreden.png")));
/* 1974 */     this.jPanel15.add(this.jLabel87);
/* 1975 */     this.jLabel87.setBounds(230, 40, 220, 150);
/*      */     
/* 1977 */     this.jPanel19.setBackground(new Color(153, 0, 0));
/*      */     
/* 1979 */     this.jLabel88.setFont(new Font("Tahoma", 0, 10));
/* 1980 */     this.jLabel88.setForeground(new Color(255, 255, 255));
/* 1981 */     this.jLabel88.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/*      */     
/* 1983 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 1984 */     this.jPanel19.setLayout(jPanel19Layout);
/* 1985 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 1986 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1987 */         .addComponent(this.jLabel88, -1, 400, 32767));
/*      */     
/* 1989 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 1990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1991 */         .addComponent(this.jLabel88, -1, 30, 32767));
/*      */ 
/*      */     
/* 1994 */     this.jPanel15.add(this.jPanel19);
/* 1995 */     this.jPanel19.setBounds(10, 200, 400, 30);
/*      */     
/* 1997 */     this.jLabel89.setText("Curp");
/* 1998 */     this.jPanel15.add(this.jLabel89);
/* 1999 */     this.jLabel89.setBounds(130, 130, 230, 19);
/*      */     
/* 2001 */     this.jLabel65.setFont(new Font("Tahoma", 1, 12));
/* 2002 */     this.jLabel65.setForeground(new Color(153, 153, 153));
/* 2003 */     this.jLabel65.setHorizontalAlignment(0);
/* 2004 */     this.jLabel65.setText("Reverso        Reverso        Reverso        Reverso        Reverso        ");
/*      */     
/* 2006 */     this.jPanel21.setBackground(new Color(255, 255, 255));
/* 2007 */     this.jPanel21.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2008 */     this.jPanel21.setLayout((LayoutManager)null);
/*      */     
/* 2010 */     this.jLabel79.setFont(new Font("Times New Roman", 0, 19));
/* 2011 */     this.jLabel79.setForeground(new Color(153, 0, 0));
/* 2012 */     this.jLabel79.setHorizontalAlignment(0);
/* 2013 */     this.jLabel79.setText("Políticas de la empresa");
/* 2014 */     this.jPanel21.add(this.jLabel79);
/* 2015 */     this.jLabel79.setBounds(40, 0, 330, 27);
/*      */     
/* 2017 */     this.jLabel90.setText("____________________________________________________");
/* 2018 */     this.jPanel21.add(this.jLabel90);
/* 2019 */     this.jLabel90.setBounds(40, 20, 370, 19);
/*      */     
/* 2021 */     this.jLabel91.setText("___________________________________________________");
/* 2022 */     this.jPanel21.add(this.jLabel91);
/* 2023 */     this.jLabel91.setBounds(20, 10, 370, 19);
/*      */     
/* 2025 */     this.jLabel94.setFont(new Font("Tahoma", 0, 8));
/* 2026 */     this.jLabel94.setText("<html>•  Brindar  trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos considerando que el fin de la empresa es el servicio del cliente.</html>");
/* 2027 */     this.jPanel21.add(this.jLabel94);
/* 2028 */     this.jLabel94.setBounds(20, 40, 380, 20);
/*      */     
/* 2030 */     this.jLabel95.setFont(new Font("Tahoma", 0, 8));
/* 2031 */     this.jLabel95.setText("<html>• Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo, es mi responsabilidad.</html>");
/* 2032 */     this.jPanel21.add(this.jLabel95);
/* 2033 */     this.jLabel95.setBounds(20, 60, 400, 30);
/*      */     
/* 2035 */     this.jLabel96.setFont(new Font("Tahoma", 0, 8));
/* 2036 */     this.jLabel96.setText("<html>• Como integrante de la empresa debo mantener un comportamiento ético, desterrar toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de FORSIS y de todos los clientes.</html>");
/* 2037 */     this.jPanel21.add(this.jLabel96);
/* 2038 */     this.jLabel96.setBounds(20, 90, 390, 20);
/*      */     
/* 2040 */     this.jLabel97.setFont(new Font("Tahoma", 0, 10));
/* 2041 */     this.jLabel97.setHorizontalAlignment(0);
/* 2042 */     this.jLabel97.setText("Roger Garza Cantú");
/* 2043 */     this.jPanel21.add(this.jLabel97);
/* 2044 */     this.jLabel97.setBounds(300, 170, 110, 14);
/*      */     
/* 2046 */     this.jLabel99.setHorizontalAlignment(0);
/* 2047 */     this.jLabel99.setText("_______________");
/* 2048 */     this.jPanel21.add(this.jLabel99);
/* 2049 */     this.jLabel99.setBounds(300, 200, 110, 19);
/*      */     
/* 2051 */     this.jLabel100.setFont(new Font("Tahoma", 0, 10));
/* 2052 */     this.jLabel100.setHorizontalAlignment(0);
/* 2053 */     this.jLabel100.setText("Director");
/* 2054 */     this.jPanel21.add(this.jLabel100);
/* 2055 */     this.jLabel100.setBounds(310, 210, 100, 14);
/*      */     
/* 2057 */     this.jLabel102.setFont(new Font("Tahoma", 0, 10));
/* 2058 */     this.jLabel102.setHorizontalAlignment(0);
/* 2059 */     this.jLabel102.setText("Nombre Completo");
/* 2060 */     this.jPanel21.add(this.jLabel102);
/* 2061 */     this.jLabel102.setBounds(10, 170, 170, 14);
/*      */     
/* 2063 */     this.jLabel103.setHorizontalAlignment(0);
/* 2064 */     this.jLabel103.setText("_________________");
/* 2065 */     this.jPanel21.add(this.jLabel103);
/* 2066 */     this.jLabel103.setBounds(10, 200, 150, 19);
/*      */     
/* 2068 */     this.jLabel104.setFont(new Font("Tahoma", 0, 10));
/* 2069 */     this.jLabel104.setHorizontalAlignment(0);
/* 2070 */     this.jLabel104.setText("Categoría");
/* 2071 */     this.jPanel21.add(this.jLabel104);
/* 2072 */     this.jLabel104.setBounds(10, 210, 160, 14);
/*      */     
/* 2074 */     this.jLabel105.setFont(new Font("Tahoma", 0, 8));
/* 2075 */     this.jLabel105.setText("<html>• Como operador capacitado atender al cliente es mi responsabilidad, para lo cual debo conocer los procedimientos a fin de realizarlos con excelencia..</html>");
/* 2076 */     this.jPanel21.add(this.jLabel105);
/* 2077 */     this.jLabel105.setBounds(20, 120, 390, 20);
/* 2078 */     this.jPanel21.add(this.jLabel92);
/* 2079 */     this.jLabel92.setBounds(330, 170, 50, 60);
/*      */     
/* 2081 */     this.jLabel106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png")));
/* 2082 */     this.jLabel106.setText("l");
/* 2083 */     this.jPanel21.add(this.jLabel106);
/* 2084 */     this.jLabel106.setBounds(10, 60, 400, 120);
/*      */     
/* 2086 */     this.materialButton32.setBackground(this.lc.SECUNDARIO1);
/* 2087 */     this.materialButton32.setForeground(new Color(255, 255, 255));
/* 2088 */     this.materialButton32.setMnemonic('C');
/* 2089 */     this.materialButton32.setText("Cancelar");
/* 2090 */     this.materialButton32.setToolTipText("Cancelar (Alt+C)");
/* 2091 */     this.materialButton32.setFont(new Font("Cantarell", 0, 12));
/* 2092 */     this.materialButton32.setHorizontalTextPosition(0);
/* 2093 */     this.materialButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2095 */             EmpleadosBuscar.this.materialButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2099 */     this.materialButton33.setBackground(this.lc.SECUNDARIO1);
/* 2100 */     this.materialButton33.setForeground(new Color(255, 255, 255));
/* 2101 */     this.materialButton33.setMnemonic('I');
/* 2102 */     this.materialButton33.setText("Imprimir");
/* 2103 */     this.materialButton33.setToolTipText("Imprimir (Alt+A)");
/* 2104 */     this.materialButton33.setFont(new Font("Cantarell", 0, 12));
/* 2105 */     this.materialButton33.setHorizontalTextPosition(0);
/* 2106 */     this.materialButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2108 */             EmpleadosBuscar.this.materialButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2112 */     this.materialButton34.setBackground(this.lc.SECUNDARIO1);
/* 2113 */     this.materialButton34.setForeground(new Color(255, 255, 255));
/* 2114 */     this.materialButton34.setMnemonic('R');
/* 2115 */     this.materialButton34.setText("< Regresar");
/* 2116 */     this.materialButton34.setToolTipText("Regresar (Alt+R)");
/* 2117 */     this.materialButton34.setFont(new Font("Cantarell", 0, 12));
/* 2118 */     this.materialButton34.setHorizontalTextPosition(0);
/* 2119 */     this.materialButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2121 */             EmpleadosBuscar.this.materialButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2125 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 2126 */     this.jPanel14.setLayout(jPanel14Layout);
/* 2127 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 2128 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2129 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2130 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2131 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2132 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
/* 2133 */                 .addContainerGap()
/* 2134 */                 .addComponent(this.jSeparator7))
/* 2135 */               .addComponent(this.jLabel62, GroupLayout.Alignment.LEADING, -2, 423, -2))
/* 2136 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 2137 */               .addContainerGap()
/* 2138 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2139 */                 .addComponent(this.jLabel63, -1, -1, 32767)
/* 2140 */                 .addComponent(this.jLabel65, -1, -1, 32767)
/* 2141 */                 .addGroup(jPanel14Layout.createSequentialGroup()
/* 2142 */                   .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2143 */                     .addGroup(jPanel14Layout.createSequentialGroup()
/* 2144 */                       .addComponent((Component)this.materialButton34, -2, 105, -2)
/* 2145 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2146 */                       .addComponent((Component)this.materialButton33, -2, 105, -2)
/* 2147 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2148 */                       .addComponent((Component)this.materialButton32, -2, 105, -2))
/* 2149 */                     .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2150 */                       .addComponent(this.jPanel15, -2, 419, -2)
/* 2151 */                       .addComponent(this.jPanel21, -2, 419, -2)))
/* 2152 */                   .addGap(0, 0, 32767)))))
/* 2153 */           .addContainerGap()));
/*      */     
/* 2155 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 2156 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2157 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2158 */           .addComponent(this.jLabel62, -2, 22, -2)
/* 2159 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2160 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 2161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2162 */           .addComponent(this.jLabel63)
/* 2163 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2164 */           .addComponent(this.jPanel15, -2, 235, -2)
/* 2165 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2166 */           .addComponent(this.jLabel65)
/* 2167 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2168 */           .addComponent(this.jPanel21, -2, 235, -2)
/* 2169 */           .addGap(18, 18, 18)
/* 2170 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2171 */             .addComponent((Component)this.materialButton32, -2, 38, -2)
/* 2172 */             .addComponent((Component)this.materialButton33, -2, 38, -2)
/* 2173 */             .addComponent((Component)this.materialButton34, -2, 38, -2))
/* 2174 */           .addContainerGap(19, 32767)));
/*      */ 
/*      */     
/* 2177 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2178 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2179 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2181 */         .addComponent(this.jPanel14, -2, 437, -2));
/*      */     
/* 2183 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2185 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 2188 */     this.jDialog7.setTitle("Lista de cumpleaños");
/* 2189 */     this.jDialog7.setModal(true);
/*      */     
/* 2191 */     this.materialButton42.setBackground(this.lc.SECUNDARIO1);
/* 2192 */     this.materialButton42.setForeground(new Color(255, 255, 255));
/* 2193 */     this.materialButton42.setMnemonic('C');
/* 2194 */     this.materialButton42.setText("Cerrar");
/* 2195 */     this.materialButton42.setToolTipText("Cerrar (Alt+C)");
/* 2196 */     this.materialButton42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 2197 */     this.materialButton42.setHorizontalTextPosition(0);
/* 2198 */     this.materialButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2200 */             EmpleadosBuscar.this.materialButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2204 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, , { null, null, null },  }, (Object[])new String[] { "Clave", "Nombre completo", "Fecha" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2213 */     this.rSTableMetro2.setAltoHead(25);
/* 2214 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2215 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 2216 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 2217 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2218 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 2219 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 2220 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 2221 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2222 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2223 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2224 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 2225 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 2226 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 2227 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 2228 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2230 */             EmpleadosBuscar.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 2233 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2235 */             EmpleadosBuscar.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2238 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/*      */     
/* 2240 */     this.jPanel64.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2242 */     this.jLabel34.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 2244 */     this.jLabel34.setForeground(this.lc.SECUNDARIO1);
/* 2245 */     this.jLabel34.setHorizontalAlignment(4);
/* 2246 */     this.jLabel34.setText("Total ");
/* 2247 */     this.jPanel64.add(this.jLabel34);
/*      */     
/* 2249 */     this.jLabel58.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*      */     
/* 2251 */     this.jLabel58.setForeground(this.lc.PRIMARIO1);
/* 2252 */     this.jLabel58.setHorizontalAlignment(0);
/* 2253 */     this.jLabel58.setText("t");
/* 2254 */     this.jPanel64.add(this.jLabel58);
/*      */     
/* 2256 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2257 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2258 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2259 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2260 */         .addGroup(jDialog7Layout.createSequentialGroup()
/* 2261 */           .addContainerGap()
/* 2262 */           .addGroup(jDialog7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2263 */             .addGroup(GroupLayout.Alignment.TRAILING, jDialog7Layout.createSequentialGroup()
/* 2264 */               .addComponent(this.jPanel64, -2, 132, -2)
/* 2265 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2266 */               .addComponent((Component)this.materialButton42, -2, 105, -2))
/* 2267 */             .addComponent(this.jScrollPane32, -1, 656, 32767))
/* 2268 */           .addContainerGap()));
/*      */     
/* 2270 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2272 */         .addGroup(jDialog7Layout.createSequentialGroup()
/* 2273 */           .addContainerGap()
/* 2274 */           .addComponent(this.jScrollPane32, -1, 300, 32767)
/* 2275 */           .addGroup(jDialog7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2276 */             .addGroup(jDialog7Layout.createSequentialGroup()
/* 2277 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2278 */               .addComponent((Component)this.materialButton42, -2, 38, -2))
/* 2279 */             .addGroup(jDialog7Layout.createSequentialGroup()
/* 2280 */               .addGap(16, 16, 16)
/* 2281 */               .addComponent(this.jPanel64, -2, -1, -2)))
/* 2282 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2285 */     this.jDialog8.setTitle("Firmas");
/* 2286 */     this.jDialog8.setModal(true);
/* 2287 */     this.jDialog8.setUndecorated(true);
/*      */     
/* 2289 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/* 2290 */     this.jPanel9.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/* 2291 */     this.jPanel9.setLayout((LayoutManager)null);
/*      */     
/* 2293 */     this.jPanel60.setBackground(this.lc.PRIMARIO1);
/* 2294 */     this.jPanel60.setLayout(new GridLayout(1, 0));
/*      */     
/* 2296 */     this.jLabel124.setHorizontalAlignment(0);
/* 2297 */     this.jLabel124.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 2298 */     this.jLabel124.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2300 */             EmpleadosBuscar.this.jLabel124MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2303 */             EmpleadosBuscar.this.jLabel124MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2306 */             EmpleadosBuscar.this.jLabel124MouseEntered(evt);
/*      */           }
/*      */         });
/* 2309 */     this.jPanel60.add(this.jLabel124);
/*      */     
/* 2311 */     this.jPanel9.add(this.jPanel60);
/* 2312 */     this.jPanel60.setBounds(560, 1, 30, 31);
/*      */     
/* 2314 */     this.jLabel72.setHorizontalAlignment(0);
/* 2315 */     this.jLabel72.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/* 2317 */             EmpleadosBuscar.this.jLabel72MouseDragged(evt);
/*      */           }
/*      */         });
/* 2320 */     this.jLabel72.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2322 */             EmpleadosBuscar.this.jLabel72MouseClicked(evt);
/*      */           }
/*      */         });
/* 2325 */     this.jPanel9.add(this.jLabel72);
/* 2326 */     this.jLabel72.setBounds(2, 2, 590, 251);
/*      */     
/* 2328 */     this.jLabel73.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 2329 */     this.jLabel73.setForeground(this.lc.PRIMARIO1);
/* 2330 */     this.jLabel73.setHorizontalAlignment(0);
/* 2331 */     this.jLabel73.setText("Firma");
/* 2332 */     this.jPanel9.add(this.jLabel73);
/* 2333 */     this.jLabel73.setBounds(2, 275, 580, 46);
/*      */     
/* 2335 */     this.jSeparator5.setBackground(this.lc.PRIMARIO1);
/* 2336 */     this.jSeparator5.setForeground(this.lc.PRIMARIO2);
/* 2337 */     this.jPanel9.add(this.jSeparator5);
/* 2338 */     this.jSeparator5.setBounds(12, 264, 570, 10);
/*      */     
/* 2340 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2341 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2342 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2344 */         .addGroup(jDialog8Layout.createSequentialGroup()
/* 2345 */           .addComponent(this.jPanel9, -1, 592, 32767)
/* 2346 */           .addGap(0, 0, 0)));
/*      */     
/* 2348 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2349 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2350 */         .addComponent(this.jPanel9, -1, 339, 32767));
/*      */ 
/*      */     
/* 2353 */     this.jDialog9.setTitle("Curso Básico de Seguridad");
/* 2354 */     this.jDialog9.setModal(true);
/*      */     
/* 2356 */     this.jPanel33.setLayout(new GridLayout(1, 2, 10, 0));
/*      */     
/* 2358 */     this.jPanel11.setBackground(Color.white);
/* 2359 */     this.jPanel11.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 2361 */     this.jPanel22.setBackground(Color.white);
/*      */     
/* 2363 */     this.jLabel74.setHorizontalAlignment(0);
/* 2364 */     this.jLabel74.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 2366 */     this.jLabel75.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 2368 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 2369 */     this.jPanel22.setLayout(jPanel22Layout);
/* 2370 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 2371 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2372 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 2373 */           .addComponent(this.jLabel74, -2, 127, -2)
/* 2374 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2375 */           .addComponent(this.jLabel75, -1, 239, 32767)));
/*      */     
/* 2377 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 2378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2379 */         .addComponent(this.jLabel75)
/* 2380 */         .addComponent(this.jLabel74, -1, -1, 32767));
/*      */ 
/*      */     
/* 2383 */     this.jPanel23.setBackground(new Color(255, 0, 0));
/*      */     
/* 2385 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 2386 */     this.jPanel23.setLayout(jPanel23Layout);
/* 2387 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 2388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2389 */         .addGap(0, 0, 32767));
/*      */     
/* 2391 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 2392 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2393 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 2396 */     this.jLabel76.setHorizontalAlignment(0);
/* 2397 */     this.jLabel76.setText("FOLIO");
/*      */     
/* 2399 */     this.jPanel24.setBackground(Color.white);
/* 2400 */     this.jPanel24.setLayout((LayoutManager)null);
/*      */     
/* 2402 */     this.jPanel30.setBackground(new Color(177, 189, 188));
/*      */     
/* 2404 */     this.jPanel31.setBackground(new Color(177, 189, 188));
/* 2405 */     this.jPanel31.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 2407 */     this.jLabel83.setHorizontalAlignment(0);
/* 2408 */     this.jLabel83.setText("NOMBRE:");
/* 2409 */     this.jPanel31.add(this.jLabel83);
/*      */     
/* 2411 */     this.jLabel93.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2412 */     this.jLabel93.setHorizontalAlignment(0);
/* 2413 */     this.jLabel93.setText("NOMBRE DEL EMPLEADO");
/* 2414 */     this.jPanel31.add(this.jLabel93);
/*      */     
/* 2416 */     this.jPanel28.setBackground(new Color(255, 0, 0));
/*      */     
/* 2418 */     this.jLabel77.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2419 */     this.jLabel77.setForeground(Color.white);
/* 2420 */     this.jLabel77.setHorizontalAlignment(0);
/* 2421 */     this.jLabel77.setText("<html><center>EL PORTADOR DE ESTA TARJETA A ACREDITADO UN CURSO DE ORIENTACIÓN BÁSICA DE SEGURIDAD PARA INGRESAR A INSTALACIONES PETROLERAS</center></html>");
/*      */     
/* 2423 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 2424 */     this.jPanel28.setLayout(jPanel28Layout);
/* 2425 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 2426 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2427 */         .addComponent(this.jLabel77, -1, 340, 32767));
/*      */     
/* 2429 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 2430 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2431 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 2432 */           .addComponent(this.jLabel77, -2, 86, -2)
/* 2433 */           .addGap(0, 14, 32767)));
/*      */ 
/*      */     
/* 2436 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2437 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2438 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2440 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2441 */           .addGap(15, 15, 15)
/* 2442 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 2443 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2444 */           .addComponent(this.jPanel31, -2, 381, -2)
/* 2445 */           .addGap(121, 121, 121)));
/*      */     
/* 2447 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2449 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2450 */           .addGap(20, 20, 20)
/* 2451 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 2452 */           .addContainerGap(48, 32767))
/* 2453 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
/* 2454 */           .addContainerGap(-1, 32767)
/* 2455 */           .addComponent(this.jPanel31, -2, -1, -2)
/* 2456 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2459 */     this.jPanel24.add(this.jPanel30);
/* 2460 */     this.jPanel30.setBounds(0, 12, 370, 0);
/*      */     
/* 2462 */     this.jPanel32.setBackground(new Color(177, 189, 188));
/* 2463 */     this.jPanel32.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2464 */     this.jPanel32.setLayout(new GridLayout(1, 0));
/*      */     
/* 2466 */     this.jLabel98.setHorizontalAlignment(0);
/* 2467 */     this.jPanel32.add(this.jLabel98);
/*      */     
/* 2469 */     this.jPanel34.setBackground(Color.white);
/*      */     
/* 2471 */     this.jLabel101.setBackground(new Color(255, 0, 0));
/* 2472 */     this.jLabel101.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2473 */     this.jLabel101.setForeground(new Color(255, 0, 0));
/* 2474 */     this.jLabel101.setText("CURSO BÁSICO DE SEGURIDAD");
/*      */     
/* 2476 */     this.jPanel35.setBackground(Color.white);
/* 2477 */     this.jPanel35.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/* 2479 */     this.jLabel122.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2480 */     this.jLabel122.setText("DURACIÓN:");
/* 2481 */     this.jPanel35.add(this.jLabel122);
/*      */     
/* 2483 */     this.jPanel36.setBackground(Color.white);
/* 2484 */     this.jPanel36.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2486 */     this.jSpinner1.setModel(new SpinnerNumberModel(8, 1, 480, 1));
/* 2487 */     this.jPanel36.add(this.jSpinner1);
/*      */     
/* 2489 */     this.jLabel146.setText("hrs.");
/* 2490 */     this.jPanel36.add(this.jLabel146);
/*      */     
/* 2492 */     this.jPanel35.add(this.jPanel36);
/*      */     
/* 2494 */     this.jLabel140.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2495 */     this.jLabel140.setText("VIGENCIA:");
/* 2496 */     this.jPanel35.add(this.jLabel140);
/*      */     
/* 2498 */     this.jDateChooser1.setIcon(this.icon);
/* 2499 */     this.jPanel35.add((Component)this.jDateChooser1);
/*      */     
/* 2501 */     this.jLabel142.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2502 */     this.jLabel142.setText("FECHA:");
/* 2503 */     this.jPanel35.add(this.jLabel142);
/*      */     
/* 2505 */     this.jLabel143.setText("jLabel143");
/* 2506 */     this.jPanel35.add(this.jLabel143);
/*      */     
/* 2508 */     this.jLabel144.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2509 */     this.jLabel144.setText("CATEGORÍA:");
/* 2510 */     this.jPanel35.add(this.jLabel144);
/*      */     
/* 2512 */     this.jTextField29.setText("jTextField29");
/* 2513 */     this.jPanel35.add(this.jTextField29);
/*      */     
/* 2515 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 2516 */     this.jPanel34.setLayout(jPanel34Layout);
/* 2517 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 2518 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2519 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 2520 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2521 */             .addComponent(this.jPanel35, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/* 2522 */             .addComponent(this.jLabel101, -1, -1, 32767))
/* 2523 */           .addContainerGap()));
/*      */     
/* 2525 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 2526 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2527 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 2528 */           .addComponent(this.jLabel101)
/* 2529 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2530 */           .addComponent(this.jPanel35, -1, 124, 32767)));
/*      */ 
/*      */     
/* 2533 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 2534 */     this.jPanel11.setLayout(jPanel11Layout);
/* 2535 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 2536 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2537 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2538 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2539 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 2540 */               .addComponent(this.jPanel32, -2, 114, -2)
/* 2541 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2542 */               .addComponent(this.jPanel34, -1, -1, 32767))
/* 2543 */             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2544 */               .addComponent(this.jPanel23, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2545 */               .addComponent(this.jPanel22, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2546 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 2547 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2548 */                 .addComponent(this.jPanel24, GroupLayout.Alignment.LEADING, -1, 369, 32767)
/* 2549 */                 .addComponent(this.jLabel76, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2550 */               .addGap(3, 3, 3)))
/* 2551 */           .addGap(12, 12, 12)));
/*      */     
/* 2553 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 2554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2555 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2556 */           .addComponent(this.jPanel22, -2, -1, -2)
/* 2557 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2558 */           .addComponent(this.jPanel23, -2, -1, -2)
/* 2559 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2560 */           .addComponent(this.jLabel76)
/* 2561 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2562 */           .addComponent(this.jPanel24, -2, 178, -2)
/* 2563 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2564 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2565 */             .addComponent(this.jPanel34, -1, -1, 32767)
/* 2566 */             .addComponent(this.jPanel32, -1, -1, 32767))
/* 2567 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2570 */     this.jPanel33.add(this.jPanel11);
/*      */     
/* 2572 */     this.jPanel37.setBackground(Color.white);
/* 2573 */     this.jPanel37.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 2575 */     this.jPanel38.setBackground(Color.white);
/*      */     
/* 2577 */     this.jLabel128.setHorizontalAlignment(0);
/* 2578 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 2580 */     this.jLabel141.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 2582 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 2583 */     this.jPanel38.setLayout(jPanel38Layout);
/* 2584 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 2585 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2586 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 2587 */           .addComponent(this.jLabel128, -2, 127, -2)
/* 2588 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2589 */           .addComponent(this.jLabel141, -1, 238, 32767)));
/*      */     
/* 2591 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 2592 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2593 */         .addComponent(this.jLabel141)
/* 2594 */         .addComponent(this.jLabel128, -1, -1, 32767));
/*      */ 
/*      */     
/* 2597 */     this.jPanel39.setBackground(new Color(255, 0, 0));
/*      */     
/* 2599 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 2600 */     this.jPanel39.setLayout(jPanel39Layout);
/* 2601 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 2602 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2603 */         .addGap(0, 0, 32767));
/*      */     
/* 2605 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 2606 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2607 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 2610 */     this.jLabel145.setHorizontalAlignment(0);
/* 2611 */     this.jLabel145.setText("FOLIO");
/*      */     
/* 2613 */     this.jPanel40.setBackground(Color.white);
/* 2614 */     this.jPanel40.setLayout((LayoutManager)null);
/*      */     
/* 2616 */     this.jPanel41.setBackground(new Color(255, 0, 0));
/*      */     
/* 2618 */     this.jPanel42.setBackground(Color.white);
/*      */     
/* 2620 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 2621 */     this.jPanel42.setLayout(jPanel42Layout);
/* 2622 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 2623 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2624 */         .addGap(0, 328, 32767));
/*      */     
/* 2626 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 2627 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2628 */         .addGap(0, 76, 32767));
/*      */ 
/*      */     
/* 2631 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 2632 */     this.jPanel41.setLayout(jPanel41Layout);
/* 2633 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 2634 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2635 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 2636 */           .addContainerGap()
/* 2637 */           .addComponent(this.jPanel42, -1, -1, 32767)
/* 2638 */           .addContainerGap()));
/*      */     
/* 2640 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 2641 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2642 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 2643 */           .addContainerGap()
/* 2644 */           .addComponent(this.jPanel42, -1, -1, 32767)
/* 2645 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2648 */     this.jPanel40.add(this.jPanel41);
/* 2649 */     this.jPanel41.setBounds(20, 10, 340, 0);
/*      */     
/* 2651 */     this.jLabel35.setHorizontalAlignment(0);
/* 2652 */     this.jLabel35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/FirmaQHSE.jpg")));
/* 2653 */     this.jPanel40.add(this.jLabel35);
/* 2654 */     this.jLabel35.setBounds(20, 10, 340, 90);
/*      */     
/* 2656 */     this.jPanel43.setBackground(new Color(177, 189, 188));
/*      */     
/* 2658 */     this.jPanel44.setBackground(new Color(177, 189, 188));
/* 2659 */     this.jPanel44.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 2661 */     this.jLabel148.setHorizontalAlignment(0);
/* 2662 */     this.jLabel148.setText("AGENTE CAPACITADOR:");
/* 2663 */     this.jPanel44.add(this.jLabel148);
/*      */     
/* 2665 */     this.jLabel149.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2666 */     this.jLabel149.setHorizontalAlignment(0);
/* 2667 */     this.jLabel149.setText("NOMBRE DEL EMPLEADO");
/* 2668 */     this.jPanel44.add(this.jLabel149);
/*      */     
/* 2670 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 2671 */     this.jPanel43.setLayout(jPanel43Layout);
/* 2672 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 2673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2674 */         .addComponent(this.jPanel44, -1, -1, 32767));
/*      */     
/* 2676 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 2677 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2678 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 2679 */           .addContainerGap(64, 32767)
/* 2680 */           .addComponent(this.jPanel44, -2, -1, -2)
/* 2681 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2684 */     this.jPanel40.add(this.jPanel43);
/* 2685 */     this.jPanel43.setBounds(0, 60, 370, 120);
/*      */     
/* 2687 */     this.jPanel45.setBackground(new Color(177, 189, 188));
/* 2688 */     this.jPanel45.setLayout(new GridLayout(1, 0));
/*      */     
/* 2690 */     this.jPanel46.setBackground(Color.white);
/*      */     
/* 2692 */     this.jLabel151.setBackground(new Color(255, 0, 0));
/* 2693 */     this.jLabel151.setText("<html><b><center>CAPACITACIÓN ACREDITADA ANTE LA SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL CON EL NÚMERO DE REGISTRO:</center><b></html>");
/*      */     
/* 2695 */     this.jLabel147.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2696 */     this.jLabel147.setHorizontalAlignment(0);
/* 2697 */     this.jLabel147.setText("jLabel147");
/*      */     
/* 2699 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/* 2700 */     this.jPanel46.setLayout(jPanel46Layout);
/* 2701 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/* 2702 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2703 */         .addComponent(this.jLabel147, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2704 */         .addGroup(jPanel46Layout.createSequentialGroup()
/* 2705 */           .addComponent(this.jLabel151, -2, 248, -2)
/* 2706 */           .addGap(0, 0, 32767)));
/*      */     
/* 2708 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/* 2709 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2710 */         .addGroup(jPanel46Layout.createSequentialGroup()
/* 2711 */           .addComponent(this.jLabel151, -2, 103, -2)
/* 2712 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2713 */           .addComponent(this.jLabel147)
/* 2714 */           .addGap(0, 21, 32767)));
/*      */ 
/*      */     
/* 2717 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/* 2718 */     this.jPanel37.setLayout(jPanel37Layout);
/* 2719 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/* 2720 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2721 */         .addGroup(jPanel37Layout.createSequentialGroup()
/* 2722 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2723 */             .addGroup(jPanel37Layout.createSequentialGroup()
/* 2724 */               .addComponent(this.jPanel45, -2, 114, -2)
/* 2725 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2726 */               .addComponent(this.jPanel46, -1, -1, 32767))
/* 2727 */             .addGroup(jPanel37Layout.createSequentialGroup()
/* 2728 */               .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2729 */                 .addComponent(this.jPanel40, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2730 */                 .addComponent(this.jLabel145, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2731 */                 .addComponent(this.jPanel39, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2732 */                 .addComponent(this.jPanel38, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2733 */               .addGap(0, 0, 32767)))
/* 2734 */           .addGap(11, 11, 11)));
/*      */     
/* 2736 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/* 2737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2738 */         .addGroup(jPanel37Layout.createSequentialGroup()
/* 2739 */           .addComponent(this.jPanel38, -2, -1, -2)
/* 2740 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2741 */           .addComponent(this.jPanel39, -2, -1, -2)
/* 2742 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2743 */           .addComponent(this.jLabel145)
/* 2744 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2745 */           .addComponent(this.jPanel40, -2, 178, -2)
/* 2746 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2747 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2748 */             .addComponent(this.jPanel46, -1, -1, 32767)
/* 2749 */             .addComponent(this.jPanel45, -1, -1, 32767))
/* 2750 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2753 */     this.jPanel33.add(this.jPanel37);
/*      */     
/* 2755 */     this.materialButton29.setBackground(this.lc.SECUNDARIO1);
/* 2756 */     this.materialButton29.setForeground(new Color(255, 255, 255));
/* 2757 */     this.materialButton29.setMnemonic('C');
/* 2758 */     this.materialButton29.setText("Cancelar");
/* 2759 */     this.materialButton29.setToolTipText("Cancelar (Alt+C)");
/* 2760 */     this.materialButton29.setFont(new Font("Cantarell", 0, 12));
/* 2761 */     this.materialButton29.setHorizontalTextPosition(0);
/* 2762 */     this.materialButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2764 */             EmpleadosBuscar.this.materialButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2768 */     this.materialButton30.setBackground(this.lc.SECUNDARIO1);
/* 2769 */     this.materialButton30.setForeground(new Color(255, 255, 255));
/* 2770 */     this.materialButton30.setMnemonic('I');
/* 2771 */     this.materialButton30.setText("Imprimir");
/* 2772 */     this.materialButton30.setToolTipText("Imprimir (Alt+I)");
/* 2773 */     this.materialButton30.setFont(new Font("Cantarell", 0, 12));
/* 2774 */     this.materialButton30.setHorizontalTextPosition(0);
/* 2775 */     this.materialButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2777 */             EmpleadosBuscar.this.materialButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2781 */     this.materialButton31.setBackground(this.lc.SECUNDARIO1);
/* 2782 */     this.materialButton31.setForeground(new Color(255, 255, 255));
/* 2783 */     this.materialButton31.setMnemonic('R');
/* 2784 */     this.materialButton31.setText("< Regresar");
/* 2785 */     this.materialButton31.setToolTipText("Regresar (Alt+R)");
/* 2786 */     this.materialButton31.setFont(new Font("Cantarell", 0, 12));
/* 2787 */     this.materialButton31.setHorizontalTextPosition(0);
/* 2788 */     this.materialButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2790 */             EmpleadosBuscar.this.materialButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2794 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/* 2795 */     this.jPanel47.setLayout(jPanel47Layout);
/* 2796 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/* 2797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2798 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
/* 2799 */           .addContainerGap(-1, 32767)
/* 2800 */           .addComponent((Component)this.materialButton31, -2, 105, -2)
/* 2801 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2802 */           .addComponent((Component)this.materialButton30, -2, 105, -2)
/* 2803 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2804 */           .addComponent((Component)this.materialButton29, -2, 105, -2)
/* 2805 */           .addContainerGap()));
/*      */     
/* 2807 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/* 2808 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2809 */         .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2810 */           .addComponent((Component)this.materialButton29, -2, 38, -2)
/* 2811 */           .addComponent((Component)this.materialButton30, -2, 38, -2)
/* 2812 */           .addComponent((Component)this.materialButton31, -2, 38, -2)));
/*      */ 
/*      */     
/* 2815 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2816 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2817 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2818 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2819 */         .addComponent(this.jPanel47, -1, -1, 32767)
/* 2820 */         .addComponent(this.jPanel33, -2, 0, 32767));
/*      */     
/* 2822 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2824 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2825 */           .addComponent(this.jPanel33, -1, 507, 32767)
/* 2826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2827 */           .addComponent(this.jPanel47, -2, -1, -2)
/* 2828 */           .addGap(17, 17, 17)));
/*      */ 
/*      */     
/* 2831 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2832 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2833 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2834 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2835 */         .addGap(0, 775, 32767)
/* 2836 */         .addGroup(jDialog9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2837 */           .addComponent(this.jPanel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767)));
/*      */     
/* 2839 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2840 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2841 */         .addGap(0, 568, 32767)
/* 2842 */         .addGroup(jDialog9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2843 */           .addComponent(this.jPanel13, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2846 */     GridBagLayout jPanel54Layout = new GridBagLayout();
/* 2847 */     jPanel54Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2848 */     jPanel54Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2849 */     this.jPanel54.setLayout(jPanel54Layout);
/*      */     
/* 2851 */     this.jLabel7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2852 */     this.jLabel7.setText("Calle");
/* 2853 */     gridBagConstraints = new GridBagConstraints();
/* 2854 */     gridBagConstraints.gridx = 2;
/* 2855 */     gridBagConstraints.gridy = 0;
/* 2856 */     gridBagConstraints.fill = 1;
/* 2857 */     gridBagConstraints.weightx = 0.2D;
/* 2858 */     this.jPanel54.add(this.jLabel7, gridBagConstraints);
/*      */     
/* 2860 */     this.jTextField9.setEditable(false);
/* 2861 */     this.jTextField9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2862 */     gridBagConstraints = new GridBagConstraints();
/* 2863 */     gridBagConstraints.gridx = 4;
/* 2864 */     gridBagConstraints.gridy = 0;
/* 2865 */     gridBagConstraints.fill = 2;
/* 2866 */     gridBagConstraints.weightx = 1.0D;
/* 2867 */     this.jPanel54.add(this.jTextField9, gridBagConstraints);
/*      */     
/* 2869 */     this.jLabel8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2870 */     this.jLabel8.setText("Número");
/* 2871 */     gridBagConstraints = new GridBagConstraints();
/* 2872 */     gridBagConstraints.gridx = 2;
/* 2873 */     gridBagConstraints.gridy = 2;
/* 2874 */     gridBagConstraints.fill = 1;
/* 2875 */     gridBagConstraints.weightx = 0.2D;
/* 2876 */     this.jPanel54.add(this.jLabel8, gridBagConstraints);
/*      */     
/* 2878 */     this.jTextField10.setEditable(false);
/* 2879 */     this.jTextField10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2880 */     gridBagConstraints = new GridBagConstraints();
/* 2881 */     gridBagConstraints.gridx = 4;
/* 2882 */     gridBagConstraints.gridy = 2;
/* 2883 */     gridBagConstraints.fill = 2;
/* 2884 */     gridBagConstraints.weightx = 1.0D;
/* 2885 */     this.jPanel54.add(this.jTextField10, gridBagConstraints);
/*      */     
/* 2887 */     this.jLabel9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2888 */     this.jLabel9.setText("Colonia");
/* 2889 */     gridBagConstraints = new GridBagConstraints();
/* 2890 */     gridBagConstraints.gridx = 2;
/* 2891 */     gridBagConstraints.gridy = 4;
/* 2892 */     gridBagConstraints.fill = 1;
/* 2893 */     gridBagConstraints.weightx = 0.2D;
/* 2894 */     this.jPanel54.add(this.jLabel9, gridBagConstraints);
/*      */     
/* 2896 */     this.jLabel10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2897 */     this.jLabel10.setText("Código Postal");
/* 2898 */     gridBagConstraints = new GridBagConstraints();
/* 2899 */     gridBagConstraints.gridx = 2;
/* 2900 */     gridBagConstraints.gridy = 8;
/* 2901 */     gridBagConstraints.fill = 2;
/* 2902 */     gridBagConstraints.weightx = 0.2D;
/* 2903 */     this.jPanel54.add(this.jLabel10, gridBagConstraints);
/*      */     
/* 2905 */     this.jTextField12.setEditable(false);
/* 2906 */     this.jTextField12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2907 */     this.jTextField12.setHorizontalAlignment(4);
/* 2908 */     gridBagConstraints = new GridBagConstraints();
/* 2909 */     gridBagConstraints.gridx = 4;
/* 2910 */     gridBagConstraints.gridy = 8;
/* 2911 */     gridBagConstraints.fill = 2;
/* 2912 */     gridBagConstraints.weightx = 1.0D;
/* 2913 */     this.jPanel54.add(this.jTextField12, gridBagConstraints);
/*      */     
/* 2915 */     this.jLabel21.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2916 */     this.jLabel21.setText("Ciudad");
/* 2917 */     gridBagConstraints = new GridBagConstraints();
/* 2918 */     gridBagConstraints.gridx = 2;
/* 2919 */     gridBagConstraints.gridy = 6;
/* 2920 */     gridBagConstraints.fill = 1;
/* 2921 */     gridBagConstraints.weightx = 0.2D;
/* 2922 */     this.jPanel54.add(this.jLabel21, gridBagConstraints);
/*      */     
/* 2924 */     this.jTextField13.setEditable(false);
/* 2925 */     this.jTextField13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2926 */     gridBagConstraints = new GridBagConstraints();
/* 2927 */     gridBagConstraints.gridx = 4;
/* 2928 */     gridBagConstraints.gridy = 6;
/* 2929 */     gridBagConstraints.fill = 2;
/* 2930 */     gridBagConstraints.weightx = 1.0D;
/* 2931 */     this.jPanel54.add(this.jTextField13, gridBagConstraints);
/*      */     
/* 2933 */     this.jTextField11.setEditable(false);
/* 2934 */     this.jTextField11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2935 */     gridBagConstraints = new GridBagConstraints();
/* 2936 */     gridBagConstraints.gridx = 4;
/* 2937 */     gridBagConstraints.gridy = 4;
/* 2938 */     gridBagConstraints.fill = 2;
/* 2939 */     gridBagConstraints.weightx = 1.0D;
/* 2940 */     this.jPanel54.add(this.jTextField11, gridBagConstraints);
/*      */     
/* 2942 */     this.jLabel155.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2943 */     this.jLabel155.setText("Estado");
/* 2944 */     gridBagConstraints = new GridBagConstraints();
/* 2945 */     gridBagConstraints.gridx = 2;
/* 2946 */     gridBagConstraints.gridy = 10;
/* 2947 */     gridBagConstraints.anchor = 21;
/* 2948 */     this.jPanel54.add(this.jLabel155, gridBagConstraints);
/*      */     
/* 2950 */     this.jTextField45.setEditable(false);
/* 2951 */     this.jTextField45.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2952 */     this.jTextField45.setText("jTextField45");
/* 2953 */     gridBagConstraints = new GridBagConstraints();
/* 2954 */     gridBagConstraints.gridx = 4;
/* 2955 */     gridBagConstraints.gridy = 10;
/* 2956 */     gridBagConstraints.fill = 2;
/* 2957 */     this.jPanel54.add(this.jTextField45, gridBagConstraints);
/*      */     
/* 2959 */     GridBagLayout jPanel55Layout = new GridBagLayout();
/* 2960 */     jPanel55Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2961 */     jPanel55Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2962 */     this.jPanel55.setLayout(jPanel55Layout);
/*      */     
/* 2964 */     this.jLabel27.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2965 */     this.jLabel27.setText("Contratador por");
/* 2966 */     gridBagConstraints = new GridBagConstraints();
/* 2967 */     gridBagConstraints.gridx = 2;
/* 2968 */     gridBagConstraints.gridy = 2;
/* 2969 */     gridBagConstraints.anchor = 17;
/* 2970 */     gridBagConstraints.weightx = 0.2D;
/* 2971 */     this.jPanel55.add(this.jLabel27, gridBagConstraints);
/*      */     
/* 2973 */     this.jTextField33.setEditable(false);
/* 2974 */     this.jTextField33.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2975 */     this.jTextField33.setText("jTextField33");
/* 2976 */     gridBagConstraints = new GridBagConstraints();
/* 2977 */     gridBagConstraints.gridx = 4;
/* 2978 */     gridBagConstraints.gridy = 2;
/* 2979 */     gridBagConstraints.gridwidth = 5;
/* 2980 */     gridBagConstraints.fill = 2;
/* 2981 */     gridBagConstraints.anchor = 18;
/* 2982 */     gridBagConstraints.weightx = 1.0D;
/* 2983 */     this.jPanel55.add(this.jTextField33, gridBagConstraints);
/*      */     
/* 2985 */     this.jLabel49.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2986 */     this.jLabel49.setText("Testigo 1");
/* 2987 */     gridBagConstraints = new GridBagConstraints();
/* 2988 */     gridBagConstraints.gridx = 2;
/* 2989 */     gridBagConstraints.gridy = 4;
/* 2990 */     gridBagConstraints.anchor = 17;
/* 2991 */     gridBagConstraints.weightx = 0.2D;
/* 2992 */     this.jPanel55.add(this.jLabel49, gridBagConstraints);
/*      */     
/* 2994 */     this.jTextField34.setEditable(false);
/* 2995 */     this.jTextField34.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2996 */     this.jTextField34.setText("jTextField34");
/* 2997 */     gridBagConstraints = new GridBagConstraints();
/* 2998 */     gridBagConstraints.gridx = 4;
/* 2999 */     gridBagConstraints.gridy = 4;
/* 3000 */     gridBagConstraints.gridwidth = 5;
/* 3001 */     gridBagConstraints.fill = 2;
/* 3002 */     gridBagConstraints.anchor = 18;
/* 3003 */     gridBagConstraints.weightx = 1.0D;
/* 3004 */     this.jPanel55.add(this.jTextField34, gridBagConstraints);
/*      */     
/* 3006 */     this.jLabel51.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3007 */     this.jLabel51.setText("Testigo 2");
/* 3008 */     gridBagConstraints = new GridBagConstraints();
/* 3009 */     gridBagConstraints.gridx = 2;
/* 3010 */     gridBagConstraints.gridy = 6;
/* 3011 */     gridBagConstraints.anchor = 17;
/* 3012 */     gridBagConstraints.weightx = 0.2D;
/* 3013 */     this.jPanel55.add(this.jLabel51, gridBagConstraints);
/*      */     
/* 3015 */     this.jLabel52.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3016 */     this.jLabel52.setText("Recomendado por");
/* 3017 */     gridBagConstraints = new GridBagConstraints();
/* 3018 */     gridBagConstraints.gridx = 2;
/* 3019 */     gridBagConstraints.gridy = 8;
/* 3020 */     gridBagConstraints.anchor = 17;
/* 3021 */     gridBagConstraints.weightx = 0.2D;
/* 3022 */     this.jPanel55.add(this.jLabel52, gridBagConstraints);
/*      */     
/* 3024 */     this.jTextField35.setEditable(false);
/* 3025 */     this.jTextField35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3026 */     this.jTextField35.setText("jTextField35");
/* 3027 */     gridBagConstraints = new GridBagConstraints();
/* 3028 */     gridBagConstraints.gridx = 4;
/* 3029 */     gridBagConstraints.gridy = 6;
/* 3030 */     gridBagConstraints.gridwidth = 5;
/* 3031 */     gridBagConstraints.fill = 2;
/* 3032 */     gridBagConstraints.weightx = 1.0D;
/* 3033 */     this.jPanel55.add(this.jTextField35, gridBagConstraints);
/*      */     
/* 3035 */     this.jTextField36.setEditable(false);
/* 3036 */     this.jTextField36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3037 */     this.jTextField36.setText("jTextField36");
/* 3038 */     gridBagConstraints = new GridBagConstraints();
/* 3039 */     gridBagConstraints.gridx = 4;
/* 3040 */     gridBagConstraints.gridy = 8;
/* 3041 */     gridBagConstraints.gridwidth = 5;
/* 3042 */     gridBagConstraints.fill = 2;
/* 3043 */     gridBagConstraints.weightx = 1.0D;
/* 3044 */     this.jPanel55.add(this.jTextField36, gridBagConstraints);
/*      */     
/* 3046 */     this.jLabel54.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3047 */     this.jLabel54.setText("Salario Nominal");
/* 3048 */     gridBagConstraints = new GridBagConstraints();
/* 3049 */     gridBagConstraints.gridx = 2;
/* 3050 */     gridBagConstraints.gridy = 10;
/* 3051 */     gridBagConstraints.anchor = 17;
/* 3052 */     gridBagConstraints.weightx = 0.2D;
/* 3053 */     this.jPanel55.add(this.jLabel54, gridBagConstraints);
/*      */     
/* 3055 */     this.jTextField37.setEditable(false);
/* 3056 */     this.jTextField37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3057 */     this.jTextField37.setHorizontalAlignment(4);
/* 3058 */     this.jTextField37.setText("jTextField37");
/* 3059 */     gridBagConstraints = new GridBagConstraints();
/* 3060 */     gridBagConstraints.gridx = 4;
/* 3061 */     gridBagConstraints.gridy = 10;
/* 3062 */     gridBagConstraints.fill = 2;
/* 3063 */     gridBagConstraints.weightx = 1.0D;
/* 3064 */     this.jPanel55.add(this.jTextField37, gridBagConstraints);
/*      */     
/* 3066 */     this.jLabel57.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3067 */     this.jLabel57.setText("Salario Real");
/* 3068 */     gridBagConstraints = new GridBagConstraints();
/* 3069 */     gridBagConstraints.gridx = 2;
/* 3070 */     gridBagConstraints.gridy = 12;
/* 3071 */     gridBagConstraints.anchor = 17;
/* 3072 */     gridBagConstraints.weightx = 0.2D;
/* 3073 */     this.jPanel55.add(this.jLabel57, gridBagConstraints);
/*      */     
/* 3075 */     this.jTextField38.setEditable(false);
/* 3076 */     this.jTextField38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3077 */     this.jTextField38.setHorizontalAlignment(4);
/* 3078 */     this.jTextField38.setText("jTextField38");
/* 3079 */     gridBagConstraints = new GridBagConstraints();
/* 3080 */     gridBagConstraints.gridx = 4;
/* 3081 */     gridBagConstraints.gridy = 12;
/* 3082 */     gridBagConstraints.fill = 2;
/* 3083 */     gridBagConstraints.weightx = 1.0D;
/* 3084 */     this.jPanel55.add(this.jTextField38, gridBagConstraints);
/*      */     
/* 3086 */     this.jLabel59.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3087 */     this.jLabel59.setText("Distintivo");
/* 3088 */     gridBagConstraints = new GridBagConstraints();
/* 3089 */     gridBagConstraints.gridx = 2;
/* 3090 */     gridBagConstraints.gridy = 14;
/* 3091 */     gridBagConstraints.anchor = 17;
/* 3092 */     gridBagConstraints.weightx = 0.2D;
/* 3093 */     this.jPanel55.add(this.jLabel59, gridBagConstraints);
/*      */     
/* 3095 */     this.jTextField39.setEditable(false);
/* 3096 */     this.jTextField39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3097 */     this.jTextField39.setText("jTextField39");
/* 3098 */     gridBagConstraints = new GridBagConstraints();
/* 3099 */     gridBagConstraints.gridx = 4;
/* 3100 */     gridBagConstraints.gridy = 14;
/* 3101 */     gridBagConstraints.gridwidth = 5;
/* 3102 */     gridBagConstraints.fill = 2;
/* 3103 */     gridBagConstraints.weightx = 1.0D;
/* 3104 */     this.jPanel55.add(this.jTextField39, gridBagConstraints);
/*      */     
/* 3106 */     this.jLabel127.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3107 */     this.jLabel127.setText("Días del contrato");
/* 3108 */     gridBagConstraints = new GridBagConstraints();
/* 3109 */     gridBagConstraints.gridx = 2;
/* 3110 */     gridBagConstraints.gridy = 16;
/* 3111 */     gridBagConstraints.anchor = 17;
/* 3112 */     gridBagConstraints.weightx = 0.2D;
/* 3113 */     this.jPanel55.add(this.jLabel127, gridBagConstraints);
/*      */     
/* 3115 */     this.jTextField40.setEditable(false);
/* 3116 */     this.jTextField40.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3117 */     this.jTextField40.setHorizontalAlignment(4);
/* 3118 */     this.jTextField40.setText("jTextField40");
/* 3119 */     gridBagConstraints = new GridBagConstraints();
/* 3120 */     gridBagConstraints.gridx = 4;
/* 3121 */     gridBagConstraints.gridy = 16;
/* 3122 */     gridBagConstraints.gridwidth = 5;
/* 3123 */     gridBagConstraints.fill = 2;
/* 3124 */     gridBagConstraints.weightx = 1.0D;
/* 3125 */     this.jPanel55.add(this.jTextField40, gridBagConstraints);
/*      */     
/* 3127 */     this.jLabel152.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3128 */     this.jLabel152.setText("Último Ingreso");
/* 3129 */     gridBagConstraints = new GridBagConstraints();
/* 3130 */     gridBagConstraints.gridx = 2;
/* 3131 */     gridBagConstraints.gridy = 20;
/* 3132 */     gridBagConstraints.anchor = 17;
/* 3133 */     gridBagConstraints.weightx = 0.2D;
/* 3134 */     this.jPanel55.add(this.jLabel152, gridBagConstraints);
/*      */     
/* 3136 */     this.jTextField42.setEditable(false);
/* 3137 */     this.jTextField42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3138 */     this.jTextField42.setText("jTextField42");
/* 3139 */     gridBagConstraints = new GridBagConstraints();
/* 3140 */     gridBagConstraints.gridx = 4;
/* 3141 */     gridBagConstraints.gridy = 20;
/* 3142 */     gridBagConstraints.gridwidth = 5;
/* 3143 */     gridBagConstraints.fill = 2;
/* 3144 */     gridBagConstraints.weightx = 1.0D;
/* 3145 */     this.jPanel55.add(this.jTextField42, gridBagConstraints);
/*      */     
/* 3147 */     this.jLabel47.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3148 */     this.jLabel47.setHorizontalAlignment(4);
/* 3149 */     this.jLabel47.setText("Ingreso");
/* 3150 */     gridBagConstraints = new GridBagConstraints();
/* 3151 */     gridBagConstraints.gridx = 2;
/* 3152 */     gridBagConstraints.gridy = 18;
/* 3153 */     gridBagConstraints.anchor = 21;
/* 3154 */     this.jPanel55.add(this.jLabel47, gridBagConstraints);
/*      */     
/* 3156 */     this.jTextField24.setEditable(false);
/* 3157 */     this.jTextField24.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3158 */     gridBagConstraints = new GridBagConstraints();
/* 3159 */     gridBagConstraints.gridx = 4;
/* 3160 */     gridBagConstraints.gridy = 18;
/* 3161 */     gridBagConstraints.gridwidth = 5;
/* 3162 */     gridBagConstraints.fill = 2;
/* 3163 */     this.jPanel55.add(this.jTextField24, gridBagConstraints);
/*      */     
/* 3165 */     this.jLabel150.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3166 */     this.jLabel150.setText("Firma del Empleado");
/* 3167 */     gridBagConstraints = new GridBagConstraints();
/* 3168 */     gridBagConstraints.gridx = 2;
/* 3169 */     gridBagConstraints.gridy = 24;
/* 3170 */     gridBagConstraints.gridwidth = 7;
/* 3171 */     this.jPanel55.add(this.jLabel150, gridBagConstraints);
/*      */     
/* 3173 */     this.jLabel154.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3174 */     this.jLabel154.setHorizontalAlignment(0);
/* 3175 */     this.jLabel154.setText("jLabel154");
/* 3176 */     this.jLabel154.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 3177 */     gridBagConstraints = new GridBagConstraints();
/* 3178 */     gridBagConstraints.gridx = 2;
/* 3179 */     gridBagConstraints.gridy = 26;
/* 3180 */     gridBagConstraints.gridwidth = 7;
/* 3181 */     gridBagConstraints.fill = 1;
/* 3182 */     gridBagConstraints.weighty = 0.1D;
/* 3183 */     this.jPanel55.add(this.jLabel154, gridBagConstraints);
/*      */     
/* 3185 */     this.switch2.setBackgroundColor(this.lc.PRIMARIO1);
/* 3186 */     this.switch2.setMinimumSize(new Dimension(60, 25));
/* 3187 */     this.switch2.setOnOff(true);
/* 3188 */     this.switch2.setPreferredSize(new Dimension(60, 25));
/* 3189 */     this.switch2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3191 */             EmpleadosBuscar.this.switch2MouseClicked(evt);
/*      */           }
/*      */         });
/* 3194 */     gridBagConstraints = new GridBagConstraints();
/* 3195 */     gridBagConstraints.gridx = 6;
/* 3196 */     gridBagConstraints.gridy = 10;
/* 3197 */     this.jPanel55.add((Component)this.switch2, gridBagConstraints);
/*      */     
/* 3199 */     this.switch3.setBackgroundColor(this.lc.PRIMARIO1);
/* 3200 */     this.switch3.setMinimumSize(new Dimension(60, 25));
/* 3201 */     this.switch3.setOnOff(true);
/* 3202 */     this.switch3.setPreferredSize(new Dimension(60, 25));
/* 3203 */     this.switch3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3205 */             EmpleadosBuscar.this.switch3MouseClicked(evt);
/*      */           }
/*      */         });
/* 3208 */     gridBagConstraints = new GridBagConstraints();
/* 3209 */     gridBagConstraints.gridx = 6;
/* 3210 */     gridBagConstraints.gridy = 12;
/* 3211 */     this.jPanel55.add((Component)this.switch3, gridBagConstraints);
/*      */     
/* 3213 */     this.jLabel4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 3215 */     this.jLabel4.setText("Ocultar");
/* 3216 */     gridBagConstraints = new GridBagConstraints();
/* 3217 */     gridBagConstraints.gridx = 8;
/* 3218 */     gridBagConstraints.gridy = 10;
/* 3219 */     this.jPanel55.add(this.jLabel4, gridBagConstraints);
/*      */     
/* 3221 */     this.jLabel6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 3223 */     this.jLabel6.setText("Ocultar");
/* 3224 */     gridBagConstraints = new GridBagConstraints();
/* 3225 */     gridBagConstraints.gridx = 8;
/* 3226 */     gridBagConstraints.gridy = 12;
/* 3227 */     this.jPanel55.add(this.jLabel6, gridBagConstraints);
/*      */     
/* 3229 */     GridBagLayout jPanel63Layout = new GridBagLayout();
/* 3230 */     jPanel63Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 3231 */     jPanel63Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 3232 */     this.jPanel63.setLayout(jPanel63Layout);
/*      */     
/* 3234 */     this.jLabel44.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3235 */     this.jLabel44.setText("Fecha de última actualización");
/* 3236 */     gridBagConstraints = new GridBagConstraints();
/* 3237 */     gridBagConstraints.gridx = 2;
/* 3238 */     gridBagConstraints.gridy = 8;
/* 3239 */     gridBagConstraints.anchor = 17;
/* 3240 */     gridBagConstraints.weightx = 0.2D;
/* 3241 */     this.jPanel63.add(this.jLabel44, gridBagConstraints);
/*      */     
/* 3243 */     this.jTextField43.setEditable(false);
/* 3244 */     this.jTextField43.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3245 */     this.jTextField43.setText("jTextField43");
/* 3246 */     gridBagConstraints = new GridBagConstraints();
/* 3247 */     gridBagConstraints.gridx = 4;
/* 3248 */     gridBagConstraints.gridy = 8;
/* 3249 */     gridBagConstraints.fill = 2;
/* 3250 */     gridBagConstraints.anchor = 18;
/* 3251 */     gridBagConstraints.weightx = 1.0D;
/* 3252 */     this.jPanel63.add(this.jTextField43, gridBagConstraints);
/*      */     
/* 3254 */     this.jLabel153.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3255 */     this.jLabel153.setText("Usuario que actualizó");
/* 3256 */     gridBagConstraints = new GridBagConstraints();
/* 3257 */     gridBagConstraints.gridx = 2;
/* 3258 */     gridBagConstraints.gridy = 10;
/* 3259 */     gridBagConstraints.anchor = 17;
/* 3260 */     gridBagConstraints.weightx = 0.2D;
/* 3261 */     this.jPanel63.add(this.jLabel153, gridBagConstraints);
/*      */     
/* 3263 */     this.jTextField44.setEditable(false);
/* 3264 */     this.jTextField44.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3265 */     this.jTextField44.setText("jTextField44");
/* 3266 */     gridBagConstraints = new GridBagConstraints();
/* 3267 */     gridBagConstraints.gridx = 4;
/* 3268 */     gridBagConstraints.gridy = 10;
/* 3269 */     gridBagConstraints.fill = 2;
/* 3270 */     gridBagConstraints.weightx = 1.0D;
/* 3271 */     this.jPanel63.add(this.jTextField44, gridBagConstraints);
/*      */     
/* 3273 */     this.jLabel66.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3274 */     this.jLabel66.setText("Departamento");
/* 3275 */     gridBagConstraints = new GridBagConstraints();
/* 3276 */     gridBagConstraints.gridx = 2;
/* 3277 */     gridBagConstraints.gridy = 2;
/* 3278 */     gridBagConstraints.anchor = 17;
/* 3279 */     gridBagConstraints.weightx = 0.2D;
/* 3280 */     this.jPanel63.add(this.jLabel66, gridBagConstraints);
/*      */     
/* 3282 */     this.jTextField27.setEditable(false);
/* 3283 */     this.jTextField27.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3284 */     gridBagConstraints = new GridBagConstraints();
/* 3285 */     gridBagConstraints.gridx = 4;
/* 3286 */     gridBagConstraints.gridy = 2;
/* 3287 */     gridBagConstraints.fill = 2;
/* 3288 */     gridBagConstraints.weightx = 1.0D;
/* 3289 */     this.jPanel63.add(this.jTextField27, gridBagConstraints);
/*      */     
/* 3291 */     this.jLabel46.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3292 */     this.jLabel46.setText("Tipo");
/* 3293 */     gridBagConstraints = new GridBagConstraints();
/* 3294 */     gridBagConstraints.gridx = 2;
/* 3295 */     gridBagConstraints.gridy = 4;
/* 3296 */     gridBagConstraints.anchor = 17;
/* 3297 */     gridBagConstraints.weightx = 0.2D;
/* 3298 */     this.jPanel63.add(this.jLabel46, gridBagConstraints);
/*      */     
/* 3300 */     this.jTextField41.setEditable(false);
/* 3301 */     this.jTextField41.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3302 */     this.jTextField41.setText("jTextField41");
/* 3303 */     gridBagConstraints = new GridBagConstraints();
/* 3304 */     gridBagConstraints.gridx = 4;
/* 3305 */     gridBagConstraints.gridy = 4;
/* 3306 */     gridBagConstraints.fill = 2;
/* 3307 */     gridBagConstraints.weightx = 1.0D;
/* 3308 */     this.jPanel63.add(this.jTextField41, gridBagConstraints);
/*      */     
/* 3310 */     this.jLabel26.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3311 */     this.jLabel26.setText("Correo");
/* 3312 */     gridBagConstraints = new GridBagConstraints();
/* 3313 */     gridBagConstraints.gridx = 2;
/* 3314 */     gridBagConstraints.gridy = 6;
/* 3315 */     gridBagConstraints.anchor = 17;
/* 3316 */     gridBagConstraints.weightx = 0.2D;
/* 3317 */     this.jPanel63.add(this.jLabel26, gridBagConstraints);
/*      */     
/* 3319 */     this.jTextField17.setEditable(false);
/* 3320 */     this.jTextField17.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3321 */     gridBagConstraints = new GridBagConstraints();
/* 3322 */     gridBagConstraints.gridx = 4;
/* 3323 */     gridBagConstraints.gridy = 6;
/* 3324 */     gridBagConstraints.fill = 2;
/* 3325 */     this.jPanel63.add(this.jTextField17, gridBagConstraints);
/*      */     
/* 3327 */     this.jTextArea1.setEditable(false);
/* 3328 */     this.jTextArea1.setColumns(20);
/* 3329 */     this.jTextArea1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3330 */     this.jTextArea1.setRows(5);
/* 3331 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*      */     
/* 3333 */     gridBagConstraints = new GridBagConstraints();
/* 3334 */     gridBagConstraints.gridx = 2;
/* 3335 */     gridBagConstraints.gridy = 14;
/* 3336 */     gridBagConstraints.gridwidth = 3;
/* 3337 */     gridBagConstraints.fill = 1;
/* 3338 */     gridBagConstraints.weighty = 1.0D;
/* 3339 */     this.jPanel63.add(this.jScrollPane1, gridBagConstraints);
/*      */     
/* 3341 */     this.jLabel56.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.ITALIC, 11.0F));
/* 3342 */     this.jLabel56.setForeground(this.lc.PRIMARIO1);
/* 3343 */     this.jLabel56.setText("Aquí se muestran algunos comentarios adicionales");
/* 3344 */     gridBagConstraints = new GridBagConstraints();
/* 3345 */     gridBagConstraints.gridx = 2;
/* 3346 */     gridBagConstraints.gridy = 12;
/* 3347 */     gridBagConstraints.gridwidth = 3;
/* 3348 */     this.jPanel63.add(this.jLabel56, gridBagConstraints);
/*      */     
/* 3350 */     this.jLabel60.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3351 */     this.jLabel60.setForeground(this.lc.PRIMARIO1);
/* 3352 */     this.jLabel60.setHorizontalAlignment(0);
/* 3353 */     this.jLabel60.setText("Aquí puedes agregar un comentario");
/* 3354 */     this.jLabel60.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3356 */             EmpleadosBuscar.this.jLabel60MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3359 */             EmpleadosBuscar.this.jLabel60MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3362 */             EmpleadosBuscar.this.jLabel60MouseEntered(evt);
/*      */           }
/*      */         });
/* 3365 */     gridBagConstraints = new GridBagConstraints();
/* 3366 */     gridBagConstraints.gridx = 2;
/* 3367 */     gridBagConstraints.gridy = 16;
/* 3368 */     gridBagConstraints.gridwidth = 3;
/* 3369 */     gridBagConstraints.anchor = 21;
/* 3370 */     this.jPanel63.add(this.jLabel60, gridBagConstraints);
/*      */     
/* 3372 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3374 */     this.jPanel8.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 3376 */     this.jLabel55.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 3377 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 3378 */     this.jLabel55.setHorizontalAlignment(0);
/* 3379 */     this.jLabel55.setText("Buscar Empleados");
/*      */     
/* 3381 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 3382 */     this.jPanel8.setLayout(jPanel8Layout);
/* 3383 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 3384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3385 */         .addComponent(this.jLabel55, -1, -1, 32767));
/*      */     
/* 3387 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 3388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3389 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 3390 */           .addContainerGap()
/* 3391 */           .addComponent(this.jLabel55)
/* 3392 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3395 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 3396 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/* 3397 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/* 3398 */     GridBagLayout jPanel17Layout = new GridBagLayout();
/* 3399 */     jPanel17Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 3400 */     jPanel17Layout.rowHeights = new int[] { 0 };
/* 3401 */     this.jPanel17.setLayout(jPanel17Layout);
/*      */     
/* 3403 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3405 */             EmpleadosBuscar.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 3408 */     gridBagConstraints = new GridBagConstraints();
/* 3409 */     gridBagConstraints.gridx = 4;
/* 3410 */     gridBagConstraints.gridy = 0;
/* 3411 */     gridBagConstraints.fill = 2;
/* 3412 */     gridBagConstraints.weightx = 1.5D;
/* 3413 */     this.jPanel17.add(this.jTextField1, gridBagConstraints);
/*      */     
/* 3415 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3417 */             EmpleadosBuscar.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 3420 */     gridBagConstraints = new GridBagConstraints();
/* 3421 */     gridBagConstraints.gridx = 6;
/* 3422 */     gridBagConstraints.gridy = 0;
/* 3423 */     gridBagConstraints.fill = 2;
/* 3424 */     gridBagConstraints.weightx = 1.5D;
/* 3425 */     this.jPanel17.add(this.jTextField2, gridBagConstraints);
/*      */     
/* 3427 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3429 */             EmpleadosBuscar.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 3432 */     gridBagConstraints = new GridBagConstraints();
/* 3433 */     gridBagConstraints.gridx = 8;
/* 3434 */     gridBagConstraints.gridy = 0;
/* 3435 */     gridBagConstraints.fill = 2;
/* 3436 */     gridBagConstraints.weightx = 1.5D;
/* 3437 */     this.jPanel17.add(this.jTextField3, gridBagConstraints);
/*      */     
/* 3439 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 3440 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3441 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 3442 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3444 */             EmpleadosBuscar.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3447 */     gridBagConstraints = new GridBagConstraints();
/* 3448 */     gridBagConstraints.gridx = 12;
/* 3449 */     gridBagConstraints.gridy = 0;
/* 3450 */     gridBagConstraints.fill = 2;
/* 3451 */     gridBagConstraints.weightx = 2.0D;
/* 3452 */     this.jPanel17.add(this.jComboBox1, gridBagConstraints);
/*      */     
/* 3454 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3456 */             EmpleadosBuscar.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 3459 */     gridBagConstraints = new GridBagConstraints();
/* 3460 */     gridBagConstraints.gridx = 2;
/* 3461 */     gridBagConstraints.gridy = 0;
/* 3462 */     gridBagConstraints.fill = 2;
/* 3463 */     gridBagConstraints.weightx = 1.0D;
/* 3464 */     this.jPanel17.add(this.jTextField4, gridBagConstraints);
/*      */     
/* 3466 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 3467 */     this.jComboBox3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3468 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "ELIMINADOS", "TODOS" }));
/* 3469 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3471 */             EmpleadosBuscar.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3474 */     gridBagConstraints = new GridBagConstraints();
/* 3475 */     gridBagConstraints.gridx = 14;
/* 3476 */     gridBagConstraints.gridy = 0;
/* 3477 */     gridBagConstraints.fill = 2;
/* 3478 */     gridBagConstraints.weightx = 1.5D;
/* 3479 */     this.jPanel17.add(this.jComboBox3, gridBagConstraints);
/*      */     
/* 3481 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 3482 */     this.jComboBox4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3483 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "EMPLEADOS", "FUNCIONARIOS", "TODOS" }));
/* 3484 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3486 */             EmpleadosBuscar.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3489 */     gridBagConstraints = new GridBagConstraints();
/* 3490 */     gridBagConstraints.gridx = 10;
/* 3491 */     gridBagConstraints.gridy = 0;
/* 3492 */     gridBagConstraints.fill = 2;
/* 3493 */     gridBagConstraints.weightx = 1.5D;
/* 3494 */     this.jPanel17.add(this.jComboBox4, gridBagConstraints);
/*      */     
/* 3496 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3498 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3506 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3511 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3514 */     this.rSTableMetro1.setAltoHead(40);
/* 3515 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3516 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 3517 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 3518 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3519 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 3520 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 3521 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 3522 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3523 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3524 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3525 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 3526 */     this.rSTableMetro1.setRowHeight(18);
/* 3527 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 3528 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 3529 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 3530 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3532 */             EmpleadosBuscar.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 3535 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3537 */             EmpleadosBuscar.this.rSTableMetro1KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3540 */             EmpleadosBuscar.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 3543 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 3545 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 3546 */     this.jPanel12.setLayout(jPanel12Layout);
/* 3547 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 3548 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3549 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 3550 */           .addComponent(this.jScrollPane29, -2, 4396, -2)
/* 3551 */           .addGap(0, 0, 32767)));
/*      */     
/* 3553 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 3554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3555 */         .addComponent(this.jScrollPane29, -1, 329, 32767));
/*      */ 
/*      */     
/* 3558 */     this.jScrollPane2.setViewportView(this.jPanel12);
/*      */     
/* 3560 */     this.jPanel48.setBackground(this.lc.SECUNDARIO2);
/* 3561 */     this.jPanel48.setPreferredSize(new Dimension(220, 36));
/* 3562 */     GridBagLayout jPanel48Layout = new GridBagLayout();
/* 3563 */     jPanel48Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 3564 */     jPanel48Layout.rowHeights = new int[] { 0 };
/* 3565 */     this.jPanel48.setLayout(jPanel48Layout);
/*      */     
/* 3567 */     this.jPanel49.setBackground(this.lc.SECUNDARIO2);
/* 3568 */     this.jPanel49.setLayout(new GridLayout(1, 0));
/*      */     
/* 3570 */     this.jLabel14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 3572 */     this.jLabel14.setForeground(this.lc.SECUNDARIO1);
/* 3573 */     this.jLabel14.setHorizontalAlignment(4);
/* 3574 */     this.jLabel14.setText("Total ");
/* 3575 */     this.jPanel49.add(this.jLabel14);
/*      */     
/* 3577 */     this.jLabel48.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*      */     
/* 3579 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 3580 */     this.jLabel48.setHorizontalAlignment(0);
/* 3581 */     this.jLabel48.setText("t");
/* 3582 */     this.jPanel49.add(this.jLabel48);
/*      */     
/* 3584 */     gridBagConstraints = new GridBagConstraints();
/* 3585 */     gridBagConstraints.gridx = 0;
/* 3586 */     gridBagConstraints.gridy = 0;
/* 3587 */     gridBagConstraints.fill = 2;
/* 3588 */     gridBagConstraints.weightx = 1.0D;
/* 3589 */     this.jPanel48.add(this.jPanel49, gridBagConstraints);
/*      */     
/* 3591 */     this.jLabel156.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*      */     
/* 3593 */     this.jLabel156.setText("Vsualizador de fotografías");
/* 3594 */     gridBagConstraints = new GridBagConstraints();
/* 3595 */     gridBagConstraints.gridx = 4;
/* 3596 */     gridBagConstraints.gridy = 0;
/* 3597 */     gridBagConstraints.anchor = 21;
/* 3598 */     this.jPanel48.add(this.jLabel156, gridBagConstraints);
/* 3599 */     gridBagConstraints = new GridBagConstraints();
/* 3600 */     gridBagConstraints.gridx = 6;
/* 3601 */     gridBagConstraints.gridy = 0;
/* 3602 */     gridBagConstraints.weightx = 1.0D;
/* 3603 */     this.jPanel48.add(this.jLabel15, gridBagConstraints);
/*      */     
/* 3605 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3606 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 3607 */     this.jButton2.setText("Cumpleaños");
/* 3608 */     this.jButton2.setToolTipText("Imprimir lista de cumpleaños (Alt+C)");
/* 3609 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3611 */             EmpleadosBuscar.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3614 */     gridBagConstraints = new GridBagConstraints();
/* 3615 */     gridBagConstraints.gridx = 8;
/* 3616 */     gridBagConstraints.gridy = 0;
/* 3617 */     gridBagConstraints.fill = 1;
/* 3618 */     gridBagConstraints.weightx = 0.5D;
/* 3619 */     this.jPanel48.add(this.jButton2, gridBagConstraints);
/*      */     
/* 3621 */     this.jButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3622 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 3623 */     this.jButton1.setText("Ver Detalle");
/* 3624 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3626 */             EmpleadosBuscar.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3629 */     gridBagConstraints = new GridBagConstraints();
/* 3630 */     gridBagConstraints.gridx = 14;
/* 3631 */     gridBagConstraints.gridy = 0;
/* 3632 */     gridBagConstraints.fill = 1;
/* 3633 */     gridBagConstraints.weightx = 1.0D;
/* 3634 */     this.jPanel48.add(this.jButton1, gridBagConstraints);
/*      */     
/* 3636 */     this.jButton6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3637 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 3638 */     this.jButton6.setText("Gafetes");
/* 3639 */     this.jButton6.setToolTipText("Imprimir Gafetes");
/* 3640 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3642 */             EmpleadosBuscar.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3645 */     gridBagConstraints = new GridBagConstraints();
/* 3646 */     gridBagConstraints.gridx = 12;
/* 3647 */     gridBagConstraints.gridy = 0;
/* 3648 */     gridBagConstraints.fill = 1;
/* 3649 */     gridBagConstraints.weightx = 0.5D;
/* 3650 */     this.jPanel48.add(this.jButton6, gridBagConstraints);
/*      */     
/* 3652 */     this.jButton9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3653 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/sign.png")));
/* 3654 */     this.jButton9.setMnemonic('V');
/* 3655 */     this.jButton9.setText("Ver Firma");
/* 3656 */     this.jButton9.setToolTipText("Ver a Detalle datos del Operador (Alt+V)");
/* 3657 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3659 */             EmpleadosBuscar.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3662 */     gridBagConstraints = new GridBagConstraints();
/* 3663 */     gridBagConstraints.gridx = 16;
/* 3664 */     gridBagConstraints.gridy = 0;
/* 3665 */     gridBagConstraints.fill = 1;
/* 3666 */     gridBagConstraints.weightx = 1.0D;
/* 3667 */     this.jPanel48.add(this.jButton9, gridBagConstraints);
/*      */     
/* 3669 */     this.jButton5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3670 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 3671 */     this.jButton5.setMnemonic('G');
/* 3672 */     this.jButton5.setText("Guardar Reporte");
/* 3673 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 3674 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3676 */             EmpleadosBuscar.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3679 */     gridBagConstraints = new GridBagConstraints();
/* 3680 */     gridBagConstraints.gridx = 18;
/* 3681 */     gridBagConstraints.gridy = 0;
/* 3682 */     gridBagConstraints.fill = 1;
/* 3683 */     gridBagConstraints.weightx = 1.0D;
/* 3684 */     this.jPanel48.add(this.jButton5, gridBagConstraints);
/*      */     
/* 3686 */     this.switch1.setBackgroundColor(this.lc.PRIMARIO1);
/* 3687 */     this.switch1.setMinimumSize(new Dimension(60, 25));
/* 3688 */     this.switch1.setPreferredSize(new Dimension(60, 25));
/* 3689 */     this.switch1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3691 */             EmpleadosBuscar.this.switch1MouseClicked(evt);
/*      */           }
/*      */         });
/* 3694 */     gridBagConstraints = new GridBagConstraints();
/* 3695 */     gridBagConstraints.gridx = 2;
/* 3696 */     gridBagConstraints.gridy = 0;
/* 3697 */     this.jPanel48.add((Component)this.switch1, gridBagConstraints);
/*      */     
/* 3699 */     this.jButton3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3700 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 3701 */     this.jButton3.setMnemonic('D');
/* 3702 */     this.jButton3.setText("Lista");
/* 3703 */     this.jButton3.setToolTipText("Imprimir Datos (Alt+D)");
/* 3704 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3706 */             EmpleadosBuscar.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3709 */     gridBagConstraints = new GridBagConstraints();
/* 3710 */     gridBagConstraints.gridx = 10;
/* 3711 */     gridBagConstraints.gridy = 0;
/* 3712 */     gridBagConstraints.fill = 1;
/* 3713 */     gridBagConstraints.weightx = 0.5D;
/* 3714 */     this.jPanel48.add(this.jButton3, gridBagConstraints);
/*      */     
/* 3716 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 3717 */     this.jPanel10.setLayout(jPanel10Layout);
/* 3718 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 3719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3720 */         .addComponent(this.jScrollPane2, -1, 960, 32767)
/* 3721 */         .addComponent(this.jPanel48, -2, 0, 32767));
/*      */     
/* 3723 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 3724 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3725 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 3726 */           .addComponent(this.jScrollPane2, -1, 345, 32767)
/* 3727 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3728 */           .addComponent(this.jPanel48, -2, 40, -2)));
/*      */ 
/*      */     
/* 3731 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 3732 */     this.jPanel2.setLayout(jPanel2Layout);
/* 3733 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 3734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3735 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 3736 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 3737 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 3739 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 3740 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3741 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 3742 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 3743 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3744 */           .addComponent(this.jPanel17, -2, 26, -2)
/* 3745 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3746 */           .addComponent(this.jPanel10, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3749 */     GroupLayout layout = new GroupLayout(this);
/* 3750 */     setLayout(layout);
/* 3751 */     layout.setHorizontalGroup(layout
/* 3752 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3753 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/* 3755 */     layout.setVerticalGroup(layout
/* 3756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3757 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */   }
/*      */   private JPanel jPanel70; private JPanel jPanel71; private JPanel jPanel72; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane29; private JScrollPane jScrollPane32; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSpinner jSpinner1; private JTextArea jTextArea1; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField35; private JTextField jTextField36; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField43; private JTextField jTextField44; private JTextField jTextField45; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField9; private MaterialButton materialButton27; private MaterialButton materialButton28; private MaterialButton materialButton29; private MaterialButton materialButton30; private MaterialButton materialButton31; private MaterialButton materialButton32; private MaterialButton materialButton33; private MaterialButton materialButton34; private MaterialButton materialButton36; private MaterialButton materialButton37; private MaterialButton materialButton38; private MaterialButton materialButton39; private MaterialButton materialButton40; private MaterialButton materialButton41; private MaterialButton materialButton42; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private Switch switch1; private Switch switch2; private Switch switch3;
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 3762 */     consultar();
/*      */   }
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 3765 */     consultar();
/*      */   }
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 3768 */     consultar();
/*      */   }
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 3771 */     if (this.entraPrimera) {
/* 3772 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 3777 */     consultar();
/*      */   }
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3780 */     if (!this.PRIVILEGIOS.equals("SUPER USUARIO") && !this.PRIVILEGIOS.equals("RECURSOS HUMANOS")) {
/* 3781 */       String[] datos = { "CLAVE", "NOMBRE COMPLETO", "DIRECCIÓN", "TELÉFONO", "CELULAR", "NEXTEL", "CARGO", "AUTOM", "F NACIMIENTO", "LUGAR DE NAC", "NSS", "RFC", "CURP", "INFONAVIT", "CARGO", "AUTOM", "ESTADO CIVIL", "HIJOS", "CONTRATADO POR", "TESTIGO 1", "TESTIGO 2", "RECOMENDADO POR", "DISTINTIVO", "CONTRATADO(DÍAS)", "F INGRESO", "U INGRESO", "ACTUALIZACIÓN", "RESPONSABLE", "SEXO", "DEPARTAMENTO", "TIPO", "COMENTARIOS", "CORREO" };
/* 3782 */       this.esc = new EscribirReporte("EMPLEADOS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */     } else {
/* 3784 */       String[] datos = { "CLAVE", "NOMBRE COMPLETO", "DIRECCIÓN", "TELÉFONO", "CELULAR", "NEXTEL", "CARGO", "AUTOM", "F NACIMIENTO", "LUGAR DE NAC", "NSS", "RFC", "CURP", "INFONAVIT", "CARGO", "AUTOM", "ESTADO CIVIL", "HIJOS", "CONTRATADO POR", "TESTIGO 1", "TESTIGO 2", "RECOMENDADO POR", "SALARIO IMSS", "SALARIO REAL", "DISTINTIVO", "CONTRATADO(DÍAS)", "F INGRESO", "U INGRESO", "ACTUALIZACIÓN", "RESPONSABLE", "SEXO", "DEPARTAMENTO", "TIPO", "COMENTARIOS", "CORREO" };
/* 3785 */       this.esc = new EscribirReporte("EMPLEADOS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 3790 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jDialog1WindowClosing(WindowEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel60MouseClicked(MouseEvent evt) {
/* 3798 */     this.jTextArea5.setText("");
/* 3799 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel60MouseEntered(MouseEvent evt) {
/* 3803 */     this.jLabel60.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel60MouseExited(MouseEvent evt) {
/* 3807 */     this.jLabel60.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3811 */     cargarPerfil();
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 3815 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3819 */     Map<String, String> FECHANAC = new TreeMap<>();
/* 3820 */     Map<String, String> ordenado = new LinkedHashMap<>();
/* 3821 */     Map<String, String> nombres = new TreeMap<>();
/* 3822 */     Map<String, String> departamentos = new TreeMap<>();
/*      */     
/* 3824 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 3825 */       String clave = this.rSTableMetro1.getValueAt(i, 0).toString();
/* 3826 */       String nombre = this.rSTableMetro1.getValueAt(i, 1).toString();
/* 3827 */       String depa = this.rSTableMetro1.getValueAt(i, 31).toString();
/* 3828 */       String f = this.rSTableMetro1.getValueAt(i, 8).toString();
/* 3829 */       String mes = f.substring(5, 7);
/* 3830 */       String dia = f.substring(8, 10);
/* 3831 */       String fecha = mes + "/" + mes;
/* 3832 */       FECHANAC.put(clave, fecha);
/* 3833 */       nombres.put(clave, nombre);
/* 3834 */       departamentos.put(clave, depa);
/*      */     } 
/* 3836 */     FECHANAC.entrySet()
/* 3837 */       .stream()
/* 3838 */       .sorted(Map.Entry.comparingByValue()).forEach(k -> ordenado.put((String)k.getKey(), (String)k.getValue()));
/*      */     
/* 3840 */     String[] mesNum = (String[])ordenado.values().toArray((Object[])new String[0]);
/* 3841 */     ordenado.forEach((k, v) -> {
/*      */           String mes = v.substring(0, 2);
/*      */           String mesLetra = "";
/*      */           switch (mes) {
/*      */             case "01":
/*      */               mesLetra = "ENERO";
/*      */               break;
/*      */             
/*      */             case "02":
/*      */               mesLetra = "FEBRERO";
/*      */               break;
/*      */             case "03":
/*      */               mesLetra = "MARZO";
/*      */               break;
/*      */             case "04":
/*      */               mesLetra = "ABRIL";
/*      */               break;
/*      */             case "05":
/*      */               mesLetra = "MAYO";
/*      */               break;
/*      */             case "06":
/*      */               mesLetra = "JUNIO";
/*      */               break;
/*      */             case "07":
/*      */               mesLetra = "JULIO";
/*      */               break;
/*      */             case "08":
/*      */               mesLetra = "AGOSTO";
/*      */               break;
/*      */             case "09":
/*      */               mesLetra = "SEPTIEMBRE";
/*      */               break;
/*      */             case "10":
/*      */               mesLetra = "OCTUBRE";
/*      */               break;
/*      */             case "11":
/*      */               mesLetra = "NOVIEMBRE";
/*      */               break;
/*      */             case "12":
/*      */               mesLetra = "DICIEMBRE";
/*      */               break;
/*      */           } 
/*      */           ordenado.put(k, mesLetra + "/" + mesLetra);
/*      */         });
/* 3885 */     String[] key = (String[])ordenado.keySet().toArray((Object[])new String[0]);
/* 3886 */     String[] value = (String[])ordenado.values().toArray((Object[])new String[0]);
/* 3887 */     Object[][] datos = new Object[this.rSTableMetro1.getRowCount()][4];
/* 3888 */     for (int j = 0; j < datos.length; j++) {
/* 3889 */       datos[j][0] = key[j];
/* 3890 */       datos[j][1] = nombres.get(key[j]);
/* 3891 */       datos[j][2] = value[j];
/* 3892 */       datos[j][3] = departamentos.get(key[j]);
/*      */     } 
/*      */     
/* 3895 */     this.jLabel58.setText("" + ordenado.size());
/* 3896 */     Object[] titulos = { "Clave", "Nombre", "Cumpleaños", "Departamento" };
/* 3897 */     this.rSTableMetro2.setModel(new DefaultTableModel(datos, titulos));
/*      */ 
/*      */ 
/*      */     
/* 3901 */     this.rSTableMetro2.setAltoHead(25);
/* 3902 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3903 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3904 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3905 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3906 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3907 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3908 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3909 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3910 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3911 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3912 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3913 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3914 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 3915 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 3916 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3917 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3918 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3920 */             EmpleadosBuscar.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 3923 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3925 */             EmpleadosBuscar.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 3928 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 3929 */     DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 3930 */     LocalDate fechaHoy = LocalDate.now();
/* 3931 */     fechaHoy.format(formatoFecha);
/* 3932 */     int mesHoy = fechaHoy.getMonthValue();
/* 3933 */     int diaHoy = fechaHoy.getDayOfMonth();
/* 3934 */     int pintar = 0;
/* 3935 */     for (int k = 0; k < mesNum.length; k++) {
/* 3936 */       String m = mesNum[k].substring(0, 2);
/* 3937 */       String d = mesNum[k].substring(3, 5);
/* 3938 */       if (mesHoy <= Integer.parseInt(m) && diaHoy <= Integer.parseInt(d)) {
/* 3939 */         pintar = k;
/*      */         break;
/*      */       } 
/*      */     } 
/* 3943 */     this.celda2.setPintar(pintar);
/* 3944 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3945 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3946 */     this.rSTableMetro2.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 3947 */     this.rSTableMetro2.getColumnModel().getColumn(2).setMaxWidth(100);
/* 3948 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3949 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3950 */     this.rSTableMetro2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3951 */     this.rSTableMetro2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3952 */     this.jDialog7.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 3956 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 3957 */     if (ind >= 0) {
/* 3958 */       this.jDialog4.setVisible(true);
/*      */     } else {
/* 3960 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder observar los datos", "Selecciona un registro", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel86MouseClicked(MouseEvent evt) {
/* 3965 */     this.jDateChooser8.setDate(new Date());
/* 3966 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 3967 */     if (res == 0) {
/* 3968 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3969 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 3970 */       String año = cadenaFecha1.substring(0, 4);
/* 3971 */       String mes = cadenaFecha1.substring(4, 6);
/* 3972 */       String dia = cadenaFecha1.substring(6, 8);
/* 3973 */       String mm = dameMes(mes);
/* 3974 */       this.jLabel86.setText("<html><b>Vigencia: </b>" + mm.toUpperCase() + " " + año + "</html>");
/* 3975 */       this.VIGENCIA = mm + " " + mm;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel86MouseEntered(MouseEvent evt) {
/* 3980 */     this.jLabel86.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel86MouseExited(MouseEvent evt) {
/* 3984 */     this.jLabel86.setForeground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 3988 */     this.jDialog5.setVisible(false);
/* 3989 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 3993 */     ImprimirRigPass rig = new ImprimirRigPass();
/* 3994 */     rig.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 3998 */     this.jDialog5.setVisible(false);
/* 3999 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel136MouseClicked(MouseEvent evt) {
/* 4003 */     this.jDateChooser8.setDate(new Date());
/* 4004 */     int res = JOptionPane.showConfirmDialog(this.jDialog5, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 4005 */     if (res == 0) {
/* 4006 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4007 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 4008 */       String año = cadenaFecha1.substring(0, 4);
/* 4009 */       String mes = cadenaFecha1.substring(4, 6);
/* 4010 */       String dia = cadenaFecha1.substring(6, 8);
/* 4011 */       String mm = dameMes(mes);
/* 4012 */       this.jLabel136.setText(mm.toUpperCase() + " " + mm.toUpperCase());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel136MouseEntered(MouseEvent evt) {
/* 4017 */     this.jLabel136.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel136MouseExited(MouseEvent evt) {
/* 4021 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 4025 */     if (this.rSTableMetro1.getSelectedRow() < 0) {
/* 4026 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un empleado para que se visualice la firma", "Selecciona un empleado", 0, this.ERROR);
/*      */     } else {
/* 4028 */       verFirmas();
/* 4029 */       this.jDialog8.setTitle("Firma de: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 4030 */       this.jDialog8.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton8ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 4039 */     if (evt.getClickCount() == 2) {
/* 4040 */       cargarPerfil();
/*      */     } else {
/* 4042 */       verFotos();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {
/* 4047 */     verFotos();
/*      */   }
/*      */   
/*      */   private void jLabel123MouseClicked(MouseEvent evt) {
/* 4051 */     this.switch1.setOnOff(false);
/* 4052 */     this.switch1.repaint();
/* 4053 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel123MouseExited(MouseEvent evt) {
/* 4057 */     this.jLabel123.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel123MouseEntered(MouseEvent evt) {
/* 4061 */     this.jLabel123.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel1MouseClicked(MouseEvent evt) {
/* 4065 */     this.xx = evt.getX();
/* 4066 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel1MouseDragged(MouseEvent evt) {
/* 4070 */     int x = evt.getXOnScreen();
/* 4071 */     int y = evt.getYOnScreen();
/* 4072 */     this.jDialog1.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 4076 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 4080 */     if (this.jTextArea5.getText().equals("")) {
/* 4081 */       this.jTextArea5.setBackground(Color.red);
/* 4082 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar el campo vacío, por favor completa tu información", "Campo Vacío", 0, this.ERROR);
/*      */     } else {
/* 4084 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas agregar un nuevo comentario a este empleado?", "Grabar Comentario", 0, 3, this.PREG);
/* 4085 */       if (res == 0) {
/* 4086 */         String var = this.jTextArea1.getText();
/* 4087 */         String nuevo = this.jTextArea5.getText();
/* 4088 */         this.con.inserSinMsj("update empleados set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where clave_emp = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 4089 */         this.jTextArea1.setText(var + "\n" + var + cargarFechaHoy());
/* 4090 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton27ActionPerformed(ActionEvent evt) {
/* 4096 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton28ActionPerformed(ActionEvent evt) {
/* 4100 */     this.jDialog4.setVisible(false);
/* 4101 */     this.jDateChooser8.setDate(new Date());
/* 4102 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4103 */     String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 4104 */     String año = cadenaFecha1.substring(0, 4);
/* 4105 */     int colDepa = 0;
/* 4106 */     if (this.jRadioButton7.isSelected()) {
/* 4107 */       this.jDialog4.setVisible(false);
/*      */ 
/*      */       
/* 4110 */       if (!this.PRIVILEGIOS.equals("SUPER USUARIO") && !this.PRIVILEGIOS.equals("RECURSOS HUMANOS")) {
/* 4111 */         colDepa = 27;
/*      */       } else {
/* 4113 */         colDepa = 31;
/*      */       } 
/* 4115 */       String clave = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 4116 */       String nombre = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/* 4117 */       String tipo = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3));
/* 4118 */       String nss = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10));
/* 4119 */       String curp = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 12));
/* 4120 */       this.jLabel82.setText(nombre);
/* 4121 */       this.jLabel84.setText("<html><b>TELÉFONO: </b>" + tipo + "</html>");
/* 4122 */       this.jLabel85.setText("<html><b>NSS: </b>" + nss + "</html>");
/* 4123 */       this.jLabel89.setText("<html><b>CURP: </b>" + curp + "</html>");
/* 4124 */       this.jLabel102.setText(nombre);
/* 4125 */       this.jLabel81.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), colDepa)));
/* 4126 */       this.VIGENCIA = "DICIEMBRE " + año;
/* 4127 */       String depa = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), colDepa));
/* 4128 */       this.jLabel86.setText("<html><b>Vigencia: </b>DICIEMBRE " + año + "</html>");
/* 4129 */       String claveOp = sacarClave(clave);
/* 4130 */       this.jLabel80.setText("EMP-" + claveOp);
/* 4131 */       this.CLAVEOP = (String)this.CAMPOSGENERALES.get("directiva") + "-EMP-" + (String)this.CAMPOSGENERALES.get("directiva");
/* 4132 */       verFotos2();
/*      */ 
/*      */       
/* 4135 */       Gafete2020 gafete2020 = new Gafete2020(this.padre, true, this.CAMPOSGENERALES, new String[] { clave, this.CLAVEOP, nombre, this.VIGENCIA, nss, curp, depa });
/*      */     } 
/* 4137 */     if (this.jRadioButton8.isSelected()) {
/* 4138 */       if (!this.PRIVILEGIOS.equals("SUPER USUARIO") && !this.PRIVILEGIOS.equals("RECURSOS HUMANOS")) {
/* 4139 */         colDepa = 27;
/*      */       } else {
/* 4141 */         colDepa = 31;
/*      */       } 
/* 4143 */       this.jLabel76.setText("<html><center>FOLIO: <b>" + this.DIRECTIVA[1] + "-EM" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "-" + año + "</b></center></html>");
/* 4144 */       this.jLabel145.setText("<html><center>FOLIO: <b>" + this.DIRECTIVA[1] + "-EM" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "-" + año + "</b></center></html>");
/* 4145 */       this.jLabel93.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString());
/* 4146 */       this.jSpinner1.setValue(Integer.valueOf(8));
/* 4147 */       String mes = cadenaFecha1.substring(4, 6);
/* 4148 */       String dia = cadenaFecha1.substring(6, 8);
/* 4149 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */       
/* 4151 */       int aa = Integer.parseInt(año);
/* 4152 */       aa++;
/* 4153 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4154 */       String strFecha = "" + aa + "-" + aa + "-01";
/* 4155 */       Date fecha = null;
/*      */       try {
/* 4157 */         fecha = formatoDelTexto.parse(strFecha);
/* 4158 */       } catch (ParseException ex) {
/* 4159 */         ex.printStackTrace();
/*      */       } 
/* 4161 */       this.jDateChooser1.setDate(fecha);
/*      */       
/* 4163 */       this.jLabel143.setText(fechaCompleta);
/* 4164 */       this.jTextField29.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), colDepa).toString());
/* 4165 */       this.jLabel149.setText(this.CONFIG[3]);
/* 4166 */       this.jLabel147.setText(this.CONFIG[2]);
/* 4167 */       verFotos2();
/* 4168 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton32ActionPerformed(ActionEvent evt) {
/* 4173 */     this.jDialog6.setVisible(false);
/* 4174 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void materialButton33ActionPerformed(ActionEvent evt) {
/* 4180 */     imprimirGafete2020();
/*      */   }
/*      */   
/*      */   private void materialButton34ActionPerformed(ActionEvent evt) {
/* 4184 */     this.jDialog6.setVisible(false);
/* 4185 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton29ActionPerformed(ActionEvent evt) {
/* 4189 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton30ActionPerformed(ActionEvent evt) {
/* 4193 */     Date fecha = this.jDateChooser1.getDate();
/* 4194 */     if (fecha == null) {
/* 4195 */       JOptionPane.showMessageDialog(this, "Ingresa la fecha de la vigencia", "Falta la fecha de vigencia", 0, this.ERROR);
/* 4196 */     } else if (this.jTextField29.getText().equals("")) {
/* 4197 */       this.jTextField29.setBackground(Color.RED);
/* 4198 */       JOptionPane.showMessageDialog(this.jDialog9, "Falta ingresar la categoría de la persona, no la puedes dejar vacía", "Falta la categoria", 0, this.ERROR);
/*      */     } else {
/* 4200 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4201 */       String cadenaFecha1 = formato.format(new Date());
/*      */       try {
/* 4203 */         String foto = this.CONFIG[0] + "/" + this.CONFIG[0] + ".png";
/*      */         
/* 4205 */         String año = cadenaFecha1.substring(0, 4);
/* 4206 */         String mes = cadenaFecha1.substring(4, 6);
/* 4207 */         String dia = cadenaFecha1.substring(6, 8);
/* 4208 */         String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */         
/* 4210 */         Date fecha1 = this.jDateChooser1.getDate();
/* 4211 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 4212 */         String cadenaFecha = "";
/* 4213 */         cadenaFecha = formato.format(fecha1);
/* 4214 */         String AÑO = cadenaFecha.substring(0, 4);
/* 4215 */         String MES = cadenaFecha.substring(4, 6);
/* 4216 */         String DIA = cadenaFecha.substring(6, 8);
/* 4217 */         String fechaCompleta1 = dameMes(MES).toUpperCase() + " " + dameMes(MES).toUpperCase();
/* 4218 */         Map<Object, Object> datos = new HashMap<>();
/*      */         
/* 4220 */         datos.put("folio", this.CONFIG[1] + "-EM" + this.CONFIG[1] + "-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 4221 */         datos.put("nombre", this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/* 4222 */         datos.put("vigencia", fechaCompleta1);
/* 4223 */         datos.put("fecha", fechaCompleta);
/* 4224 */         datos.put("capacitador", this.CONFIG[3]);
/* 4225 */         datos.put("registro", this.CONFIG[2]);
/* 4226 */         datos.put("foto", foto);
/* 4227 */         datos.put("categoria", this.jTextField29.getText().toUpperCase());
/* 4228 */         datos.put("horas", String.valueOf(this.jSpinner1.getValue()) + " HRS.");
/* 4229 */         JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/qhse/curso_basico.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 4230 */         JasperViewer visor = new JasperViewer(print, false);
/* 4231 */         visor.setTitle("Gafete " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 4232 */         visor.setIconImage(this.iconoImprimir);
/* 4233 */         this.jDialog9.setVisible(false);
/* 4234 */         visor.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
/*      */         
/* 4236 */         visor.setVisible(true);
/*      */       }
/* 4238 */       catch (JRException e) {
/* 4239 */         System.out.println(e.getMessage());
/* 4240 */         Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 4241 */         JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton31ActionPerformed(ActionEvent evt) {
/* 4247 */     this.jDialog9.setVisible(false);
/* 4248 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel124MouseClicked(MouseEvent evt) {
/* 4252 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel124MouseExited(MouseEvent evt) {
/* 4256 */     this.jLabel124.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel124MouseEntered(MouseEvent evt) {
/* 4260 */     this.jLabel124.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel72MouseClicked(MouseEvent evt) {
/* 4264 */     this.xx = evt.getX();
/* 4265 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel72MouseDragged(MouseEvent evt) {
/* 4269 */     int x = evt.getXOnScreen();
/* 4270 */     int y = evt.getYOnScreen();
/* 4271 */     this.jDialog8.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel126MouseClicked(MouseEvent evt) {
/* 4275 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel126MouseExited(MouseEvent evt) {
/* 4279 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel126MouseEntered(MouseEvent evt) {
/* 4283 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel2MouseClicked(MouseEvent evt) {
/* 4287 */     this.xx = evt.getX();
/* 4288 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel2MouseDragged(MouseEvent evt) {
/* 4292 */     int x = evt.getXOnScreen();
/* 4293 */     int y = evt.getYOnScreen();
/* 4294 */     this.jDialog2.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 4298 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 4302 */     ImprimirDatos imp = new ImprimirDatos();
/* 4303 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void materialButton40ActionPerformed(ActionEvent evt) {
/* 4307 */     CrearPDF crear = new CrearPDF();
/* 4308 */     String asunto = "Reporte del Empleado: [" + this.jDialog2.getTitle() + "]";
/*      */ 
/*      */ 
/*      */     
/* 4312 */     String textoDesc = "Se adjunta el reporte completo del empleado con Clave: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + ", Nombre: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)) + ", Fecha de Ingreso: " + this.jTextField42.getText() + ".";
/* 4313 */     EnviarCorreo correo = new EnviarCorreo(this.padre, asunto, textoDesc, this.USUARIO, this.nombreArchivo);
/*      */   }
/*      */   
/*      */   private void materialButton41ActionPerformed(ActionEvent evt) {
/* 4317 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseEntered(MouseEvent evt) {
/* 4321 */     ingresaMouse(this.jLabel16, this.jPanel62, this.jPanel58);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseExited(MouseEvent evt) {
/* 4325 */     if (this.clicPanel != 0) {
/* 4326 */       saleMouse(this.jLabel16, this.jPanel62, this.jPanel58);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel17MouseExited(MouseEvent evt) {
/* 4331 */     if (this.clicPanel != 1) {
/* 4332 */       saleMouse(this.jLabel17, this.jPanel68, this.jPanel67);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel17MouseEntered(MouseEvent evt) {
/* 4337 */     ingresaMouse(this.jLabel17, this.jPanel68, this.jPanel67);
/*      */   }
/*      */   
/*      */   private void jLabel18MouseExited(MouseEvent evt) {
/* 4341 */     if (this.clicPanel != 2) {
/* 4342 */       saleMouse(this.jLabel18, this.jPanel70, this.jPanel69);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel18MouseEntered(MouseEvent evt) {
/* 4347 */     ingresaMouse(this.jLabel18, this.jPanel70, this.jPanel69);
/*      */   }
/*      */   
/*      */   private void jLabel19MouseExited(MouseEvent evt) {
/* 4351 */     if (this.clicPanel != 3) {
/* 4352 */       saleMouse(this.jLabel19, this.jPanel72, this.jPanel71);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel19MouseEntered(MouseEvent evt) {
/* 4357 */     ingresaMouse(this.jLabel19, this.jPanel72, this.jPanel71);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseClicked(MouseEvent evt) {
/* 4361 */     this.clicPanel = 0;
/* 4362 */     clicMouse(this.jLabel16);
/* 4363 */     cambiarPanel(this.jPanel56);
/*      */   }
/*      */   
/*      */   private void jLabel17MouseClicked(MouseEvent evt) {
/* 4367 */     this.clicPanel = 1;
/* 4368 */     clicMouse(this.jLabel17);
/* 4369 */     cambiarPanel(this.jPanel54);
/*      */   }
/*      */   
/*      */   private void jLabel18MouseClicked(MouseEvent evt) {
/* 4373 */     this.clicPanel = 2;
/* 4374 */     clicMouse(this.jLabel18);
/* 4375 */     cambiarPanel(this.jPanel55);
/*      */   }
/*      */   
/*      */   private void jLabel19MouseClicked(MouseEvent evt) {
/* 4379 */     this.clicPanel = 3;
/* 4380 */     clicMouse(this.jLabel19);
/* 4381 */     cambiarPanel(this.jPanel63);
/*      */   }
/*      */   
/*      */   private void switch1MouseClicked(MouseEvent evt) {
/* 4385 */     if (this.switch1.isOnOff()) {
/* 4386 */       this.jDialog1.setVisible(true);
/* 4387 */       this.jLabel1.setIcon((Icon)null);
/*      */     } else {
/* 4389 */       this.jLabel1.setIcon((Icon)null);
/* 4390 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void switch2MouseClicked(MouseEvent evt) {
/* 4395 */     if (this.switch2.isOnOff()) {
/* 4396 */       this.jTextField37.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 22).toString());
/*      */     } else {
/* 4398 */       this.jTextField37.setText("$0.00");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void switch3MouseClicked(MouseEvent evt) {
/* 4403 */     if (this.switch3.isOnOff()) {
/* 4404 */       this.jTextField38.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 23).toString());
/*      */     } else {
/* 4406 */       this.jTextField38.setText("$0.00");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 4411 */     ImprimirLista imp = new ImprimirLista();
/* 4412 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void materialButton42ActionPerformed(ActionEvent evt) {
/* 4416 */     this.jDialog7.setVisible(false);
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
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyPressed(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> void printMap(Map<K, V> map) {
/* 4460 */     for (Map.Entry<K, V> entry : map.entrySet()) {
/* 4461 */       System.out.println("Key : " + String.valueOf(entry.getKey()) + " Value : " + 
/* 4462 */           String.valueOf(entry.getValue()));
/*      */     }
/*      */   }
/*      */   
/*      */   public void cambiarPanel(JPanel panelito) {
/* 4467 */     this.jPanel52.removeAll();
/* 4468 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 4469 */     this.jPanel52.setLayout(jPanel52Layout);
/* 4470 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 4471 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4472 */         .addComponent(this.jPanel53, -1, -1, 32767)
/* 4473 */         .addComponent(panelito, -1, -1, 32767));
/*      */     
/* 4475 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 4476 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4477 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
/* 4478 */           .addComponent(panelito, -1, -1, 32767)
/* 4479 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4480 */           .addComponent(this.jPanel53, -2, -1, -2)));
/*      */     
/* 4482 */     this.jPanel52.repaint();
/*      */   }
/*      */   
/*      */   public void clicMouse(JLabel Etiqueta) {
/* 4486 */     this.jLabel16.setForeground(this.lc.PRIMARIO1);
/* 4487 */     this.jLabel17.setForeground(this.lc.PRIMARIO1);
/* 4488 */     this.jLabel18.setForeground(this.lc.PRIMARIO1);
/* 4489 */     this.jLabel19.setForeground(this.lc.PRIMARIO1);
/* 4490 */     this.jLabel16.setFont(new Font("Cantarell", 0, 11));
/* 4491 */     this.jLabel17.setFont(new Font("Cantarell", 0, 11));
/* 4492 */     this.jLabel18.setFont(new Font("Cantarell", 0, 11));
/* 4493 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/*      */     
/* 4495 */     if (this.clicPanel != 0) {
/* 4496 */       this.jPanel58.setBackground(this.lc.SECUNDARIO2);
/* 4497 */       this.jPanel62.setBackground(this.lc.SECUNDARIO2);
/*      */     } 
/*      */     
/* 4500 */     if (this.clicPanel != 1) {
/* 4501 */       this.jPanel68.setBackground(this.lc.SECUNDARIO2);
/* 4502 */       this.jPanel67.setBackground(this.lc.SECUNDARIO2);
/*      */     } 
/*      */     
/* 4505 */     if (this.clicPanel != 2) {
/* 4506 */       this.jPanel70.setBackground(this.lc.SECUNDARIO2);
/* 4507 */       this.jPanel69.setBackground(this.lc.SECUNDARIO2);
/*      */     } 
/*      */     
/* 4510 */     if (this.clicPanel != 3) {
/* 4511 */       this.jPanel71.setBackground(this.lc.SECUNDARIO2);
/* 4512 */       this.jPanel72.setBackground(this.lc.SECUNDARIO2);
/*      */     } 
/*      */     
/* 4515 */     Etiqueta.setFont(new Font("Cantarell", 1, 11));
/* 4516 */     Etiqueta.setForeground(this.lc.TERCERO1);
/*      */   }
/*      */   
/*      */   public void ingresaMouse(JLabel Etiqueta, JPanel Activador, JPanel Fondo) {
/* 4520 */     Etiqueta.setForeground(this.lc.TERCERO1);
/* 4521 */     Activador.setBackground(this.lc.TERCERO1);
/* 4522 */     Fondo.setBackground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   public void saleMouse(JLabel Etiqueta, JPanel Activador, JPanel Fondo) {
/* 4526 */     Etiqueta.setForeground(this.lc.PRIMARIO1);
/* 4527 */     Activador.setBackground(this.lc.SECUNDARIO2);
/* 4528 */     Fondo.setBackground(this.lc.SECUNDARIO2);
/*      */   }
/*      */   
/*      */   public void sacarPrivilegios() {
/* 4532 */     if (this.PRIVILEGIOS.equals("SUPER USUARIO") || this.PRIVILEGIOS.equals("LIQUIDACIONES") || this.PRIVILEGIOS.equals("RECURSOS HUMANOS")) {
/* 4533 */       this.jButton9.setEnabled(true);
/*      */     } else {
/* 4535 */       this.jButton2.setEnabled(false);
/* 4536 */       this.jButton1.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verFirmas() {
/* 4541 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 4542 */     String nombre = String.valueOf(this.rSTableMetro1.getValueAt(ind, 0));
/* 4543 */     String ap = String.valueOf(this.rSTableMetro1.getValueAt(ind, 1));
/* 4544 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/*      */     
/* 4546 */     this.jLabel72.setText("Cargando...");
/* 4547 */     this.jLabel154.setText("Cargando...");
/* 4548 */     this.jLabel72.setIcon((Icon)null);
/* 4549 */     this.jLabel154.setIcon((Icon)null);
/* 4550 */     this.fotoF = new fotoFirmas(num);
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 4554 */     int quitar = 4 * letras;
/* 4555 */     x -= quitar;
/* 4556 */     return x;
/*      */   }
/*      */   
/*      */   public void verFotos() {
/* 4560 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 4561 */     String nombre = String.valueOf(this.rSTableMetro1.getValueAt(ind, 0));
/* 4562 */     String ap = String.valueOf(this.rSTableMetro1.getValueAt(ind, 1));
/* 4563 */     this.jButton5.setEnabled(true);
/*      */     
/* 4565 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 4566 */     if (this.switch1.isOnOff()) {
/* 4567 */       this.jLabel1.setText("Cargando...");
/* 4568 */       this.jLabel1.setIcon((Icon)null);
/* 4569 */       this.ind = new fotoIndividual(num);
/*      */     } else {
/* 4571 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verFotos2() {
/* 4576 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 4577 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 4578 */     this.jLabel78.setText("Cargando...");
/* 4579 */     this.jLabel115.setText("Cargando...");
/* 4580 */     this.jLabel98.setText("Cargando...");
/* 4581 */     this.cLabel1.setText("Cargando...");
/* 4582 */     this.jLabel78.setIcon((Icon)null);
/* 4583 */     this.jLabel115.setIcon((Icon)null);
/* 4584 */     this.jLabel98.setIcon((Icon)null);
/* 4585 */     this.cLabel1.setIcon(null);
/* 4586 */     this.fotoC = new fotoCredencial(num);
/*      */   }
/*      */   
/*      */   public void imprimirGafete2020() {
/*      */     try {
/* 4591 */       String foto = this.CONFIG[0] + "/" + this.CONFIG[0] + ".png";
/* 4592 */       Map<Object, Object> datos = new HashMap<>();
/*      */       
/* 4594 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/qhse/GafeteReverso2020.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 4595 */       JasperViewer visor = new JasperViewer(print, false);
/* 4596 */       visor.setTitle("Gafete " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 4597 */       visor.setIconImage(this.iconoImprimir);
/* 4598 */       this.jDialog9.setVisible(false);
/* 4599 */       visor.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
/*      */       
/* 4601 */       visor.setVisible(true);
/* 4602 */     } catch (JRException e) {
/* 4603 */       System.out.println(e.getMessage());
/* 4604 */       Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 4605 */       JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
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
/*      */   public void consultar() {
/* 4640 */     this.entraPrimera = true;
/* 4641 */     String clave = "";
/* 4642 */     String nombre = "";
/* 4643 */     String paterno = "";
/* 4644 */     String materno = "";
/*      */     
/* 4646 */     if (!this.jTextField4.getText().equals(this.holderClave)) {
/* 4647 */       clave = this.jTextField4.getText();
/*      */     }
/*      */     
/* 4650 */     if (!this.jTextField1.getText().equals(this.holderNombre)) {
/* 4651 */       nombre = this.jTextField1.getText();
/*      */     }
/*      */     
/* 4654 */     if (!this.jTextField2.getText().equals(this.holderPaterno)) {
/* 4655 */       paterno = this.jTextField2.getText();
/*      */     }
/*      */     
/* 4658 */     if (!this.jTextField3.getText().equals(this.holderMaterno)) {
/* 4659 */       materno = this.jTextField3.getText();
/*      */     }
/*      */     
/* 4662 */     String tipo = "";
/* 4663 */     String clave_depa = "";
/* 4664 */     String actual = "0";
/* 4665 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/* 4666 */       actual = "1";
/* 4667 */     } else if (this.jComboBox3.getSelectedIndex() == 2) {
/* 4668 */       actual = "";
/*      */     } 
/* 4670 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 4671 */       tipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 4672 */       this.con.consultar("clave_depa", "departamentos", "where nombre = '" + tipo + "'");
/* 4673 */       clave_depa = this.con.Campo;
/*      */     } 
/* 4675 */     String tipoEmp = "";
/* 4676 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/* 4677 */       tipoEmp = "Empleado";
/* 4678 */     } else if (this.jComboBox4.getSelectedIndex() == 1) {
/* 4679 */       tipoEmp = "Funcionario";
/*      */     } else {
/* 4681 */       tipoEmp = "";
/*      */     } 
/* 4683 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 4684 */           .buscarDatos(42, "clave_emp,ap_pat,ap_mat,empleados.nombre,calle,num,col,cp,ciudad,estado,tel_casa,celular,Nextel,cantNextel,cargoNextel,fecha_nac,lugarNacimiento,nss,rfcOriginal,rfc,numInfo,infonavitLetra,cargoInfo,estadoCivil,hijos,personaContrato,testigo1,testigo2,recomendado,salarioImss,salarioReal,etiqueta,diasContrato,ingreso,ultimoIngreso,UltimaAct,responsable,sexo,departamentos.nombre,tipoEmp,comentarios,correo", "empleados,estados,departamentos", "where clave_emp like '%" + clave + "%' and empleados.nombre like '%" + nombre + "%' and ap_pat like '%" + paterno + "%' and ap_mat like '%" + materno + "%' and empleados.id_edo = estados.id_edo and empleados.clave_depa = departamentos.clave_depa and departamentos.clave_depa like '%" + clave_depa + "%' and actual like '%" + actual + "%' and tipoEmp like '%" + tipoEmp + "%' order by ap_pat"), (Object[])new String[] { "Clave", "Nombre Completo", "Apellido Materno", "Nombre", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "Teléfono", "Celular", "Nextel", "Cargo", "Autom", "Nacimiento", "Lugar Nac", "NSS", "RFC", "CURP", "Infonavit", "Infonavit $", "Autom", "Estado Civil", "Hijos", "Contratado Por", "Testigo 1", "Testigo 2", "Recomendado Por", "Salario IMSS", "Salario REAL", "Distintivo", "Contrato(Días)", "F Ingreso", "U Ingreso", "Actualización", "Responsable", "Sexo", "Departamento", "Tipo", "Comentarios", "Correo" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4689 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, true, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/* 4694 */               false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */         
/*      */         });
/* 4697 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 4698 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 4699 */     eliminarColumna(2, 1, "Apellido Materno");
/* 4700 */     eliminarColumna(2, 1, "Nombre");
/* 4701 */     eliminarColumna(3, 2, "Número");
/* 4702 */     eliminarColumna(3, 2, "Colonia");
/* 4703 */     eliminarColumna(3, 2, "CP");
/* 4704 */     eliminarColumna(3, 2, "Ciudad");
/* 4705 */     eliminarColumna(3, 2, "Estado");
/*      */ 
/*      */     
/* 4708 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4709 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4710 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(220);
/* 4711 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(220);
/* 4712 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(270);
/* 4713 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(270);
/* 4714 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(75);
/* 4715 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(75);
/* 4716 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(75);
/* 4717 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(75);
/* 4718 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(75);
/* 4719 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(75);
/* 4720 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(50);
/* 4721 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(50);
/* 4722 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(50);
/* 4723 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(50);
/* 4724 */     this.rSTableMetro1.getColumnModel().getColumn(8).setPreferredWidth(75);
/* 4725 */     this.rSTableMetro1.getColumnModel().getColumn(8).setMaxWidth(75);
/* 4726 */     this.rSTableMetro1.getColumnModel().getColumn(9).setPreferredWidth(140);
/* 4727 */     this.rSTableMetro1.getColumnModel().getColumn(9).setMaxWidth(140);
/* 4728 */     this.rSTableMetro1.getColumnModel().getColumn(10).setPreferredWidth(90);
/* 4729 */     this.rSTableMetro1.getColumnModel().getColumn(10).setMaxWidth(90);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4735 */     this.rSTableMetro1.getColumnModel().getColumn(13).setPreferredWidth(90);
/* 4736 */     this.rSTableMetro1.getColumnModel().getColumn(13).setMaxWidth(90);
/* 4737 */     this.rSTableMetro1.getColumnModel().getColumn(14).setPreferredWidth(50);
/* 4738 */     this.rSTableMetro1.getColumnModel().getColumn(14).setMaxWidth(50);
/* 4739 */     this.rSTableMetro1.getColumnModel().getColumn(15).setPreferredWidth(50);
/* 4740 */     this.rSTableMetro1.getColumnModel().getColumn(15).setMaxWidth(50);
/*      */ 
/*      */     
/* 4743 */     this.rSTableMetro1.getColumnModel().getColumn(17).setPreferredWidth(80);
/* 4744 */     this.rSTableMetro1.getColumnModel().getColumn(17).setMaxWidth(80);
/*      */     
/* 4746 */     this.rSTableMetro1.getColumnModel().getColumn(21).setPreferredWidth(80);
/* 4747 */     this.rSTableMetro1.getColumnModel().getColumn(21).setMaxWidth(80);
/* 4748 */     this.rSTableMetro1.getColumnModel().getColumn(22).setPreferredWidth(80);
/* 4749 */     this.rSTableMetro1.getColumnModel().getColumn(22).setMaxWidth(80);
/* 4750 */     this.rSTableMetro1.getColumnModel().getColumn(25).setPreferredWidth(65);
/* 4751 */     this.rSTableMetro1.getColumnModel().getColumn(25).setMaxWidth(65);
/* 4752 */     this.rSTableMetro1.getColumnModel().getColumn(26).setPreferredWidth(65);
/* 4753 */     this.rSTableMetro1.getColumnModel().getColumn(26).setMaxWidth(65);
/* 4754 */     this.rSTableMetro1.getColumnModel().getColumn(29).setPreferredWidth(70);
/* 4755 */     this.rSTableMetro1.getColumnModel().getColumn(29).setMaxWidth(70);
/* 4756 */     this.rSTableMetro1.getColumnModel().getColumn(31).setPreferredWidth(80);
/* 4757 */     this.rSTableMetro1.getColumnModel().getColumn(31).setMaxWidth(80);
/*      */     
/* 4759 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 4760 */     this.rSTableMetro1.setSelectionMode(0);
/* 4761 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/*      */     
/* 4763 */     if (this.jComboBox3.getSelectedIndex() == 2) {
/* 4764 */       String[] arre = this.con.regresaColIndex("clave_emp", "empleados", "where actual =1");
/* 4765 */       this.celda.pasarInd(arre);
/*      */     } else {
/* 4767 */       String[] arre = new String[0];
/* 4768 */       this.celda.pasarInd(arre);
/*      */     } 
/* 4770 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 4771 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4772 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 4773 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 4774 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 4775 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 4776 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 4777 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 4778 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 4779 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 4780 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 4781 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 4782 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 4783 */     this.rSTableMetro1.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 4784 */     this.rSTableMetro1.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 4785 */     this.rSTableMetro1.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 4786 */     this.rSTableMetro1.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 4787 */     this.rSTableMetro1.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 4788 */     this.rSTableMetro1.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/* 4789 */     this.rSTableMetro1.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/* 4790 */     this.rSTableMetro1.getColumnModel().getColumn(20).setCellRenderer(this.celda);
/* 4791 */     this.rSTableMetro1.getColumnModel().getColumn(21).setCellRenderer(this.celda);
/* 4792 */     this.rSTableMetro1.getColumnModel().getColumn(22).setCellRenderer(this.celda);
/* 4793 */     this.rSTableMetro1.getColumnModel().getColumn(23).setCellRenderer(this.celda);
/* 4794 */     this.rSTableMetro1.getColumnModel().getColumn(24).setCellRenderer(this.celda);
/* 4795 */     this.rSTableMetro1.getColumnModel().getColumn(25).setCellRenderer(this.celda);
/* 4796 */     this.rSTableMetro1.getColumnModel().getColumn(26).setCellRenderer(this.celda);
/* 4797 */     this.rSTableMetro1.getColumnModel().getColumn(27).setCellRenderer(this.celda);
/* 4798 */     this.rSTableMetro1.getColumnModel().getColumn(28).setCellRenderer(this.celda);
/* 4799 */     this.rSTableMetro1.getColumnModel().getColumn(29).setCellRenderer(this.celda);
/* 4800 */     this.rSTableMetro1.getColumnModel().getColumn(30).setCellRenderer(this.celda);
/* 4801 */     this.rSTableMetro1.getColumnModel().getColumn(31).setCellRenderer(this.celda);
/* 4802 */     this.rSTableMetro1.getColumnModel().getColumn(32).setCellRenderer(this.celda);
/* 4803 */     this.rSTableMetro1.getColumnModel().getColumn(33).setCellRenderer(this.celda);
/* 4804 */     this.rSTableMetro1.getColumnModel().getColumn(34).setCellRenderer(this.celda);
/* 4805 */     this.rSTableMetro1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 10.0F));
/*      */     
/* 4807 */     if (!this.PRIVILEGIOS.equals("SUPER USUARIO") && (!this.PRIVILEGIOS.equals("RECURSOS HUMANOS") || !this.PRIVILEGIOS.equals("CONTRALORIA"))) {
/* 4808 */       TableColumn columna = this.rSTableMetro1.getColumn("Salario IMSS");
/* 4809 */       this.rSTableMetro1.removeColumn(columna);
/*      */       
/* 4811 */       columna = this.rSTableMetro1.getColumn("Salario REAL");
/* 4812 */       this.rSTableMetro1.removeColumn(columna);
/*      */       
/* 4814 */       columna = this.rSTableMetro1.getColumn("Infonavit");
/* 4815 */       this.rSTableMetro1.removeColumn(columna);
/*      */       
/* 4817 */       columna = this.rSTableMetro1.getColumn("Infonavit $");
/* 4818 */       this.rSTableMetro1.removeColumn(columna);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 4823 */     Date fecha = new Date();
/* 4824 */     Calendar ahoraCal = Calendar.getInstance();
/* 4825 */     ahoraCal.setTime(fecha);
/* 4826 */     String mesesito = "";
/* 4827 */     String hoy = "";
/* 4828 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 4829 */     hoy = "" + ahoraCal.get(5);
/* 4830 */     if (ahoraCal.get(2) + 1 < 10) {
/* 4831 */       mesesito = "0" + mesesito;
/*      */     }
/* 4833 */     if (ahoraCal.get(5) < 10) {
/* 4834 */       hoy = "0" + hoy;
/*      */     }
/* 4836 */     return "(" + hoy + "/" + mesesito + "/" + ahoraCal.get(1) + "): ";
/*      */   }
/*      */   
/*      */   public String sacarClave(String clave) {
/* 4840 */     String mayor = clave;
/* 4841 */     int MAYOR = Integer.parseInt(mayor);
/* 4842 */     String clave1 = "";
/* 4843 */     if (MAYOR < 10) {
/* 4844 */       clave1 = "0000" + MAYOR;
/* 4845 */     } else if (MAYOR < 100) {
/* 4846 */       clave1 = "000" + MAYOR;
/* 4847 */     } else if (MAYOR < 1000) {
/* 4848 */       clave1 = "00" + MAYOR;
/* 4849 */     } else if (MAYOR < 10000) {
/* 4850 */       clave1 = "0" + MAYOR;
/*      */     } else {
/* 4852 */       clave1 = "OP-" + MAYOR;
/*      */     } 
/* 4854 */     return clave1;
/*      */   }
/*      */   
/*      */   public void cargarPerfil() {
/* 4858 */     verFirmas();
/* 4859 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 4860 */     for (int i = 0; i < this.rSTableMetro1.getColumnCount(); i++) {
/* 4861 */       System.out.println("" + i + ": " + i + " - " + this.rSTableMetro1.getColumnName(i));
/*      */     }
/* 4863 */     this.switch2.setOnOff(true);
/* 4864 */     this.switch3.setOnOff(true);
/* 4865 */     this.jLabel16.setForeground(this.lc.TERCERO1);
/* 4866 */     this.jLabel16.setFont(new Font("Cantarell", 1, 11));
/* 4867 */     this.jPanel62.setBackground(this.lc.TERCERO1);
/* 4868 */     this.jPanel58.setBackground(this.lc.PRIMARIO1);
/*      */     
/* 4870 */     this.jLabel20.setText("CLAVE " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)));
/* 4871 */     this.jLabel2.setText(" INFORMACIÓN DE " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 1)));
/* 4872 */     setCursor(Cursor.getPredefinedCursor(3));
/*      */     
/* 4874 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(indice, 0));
/* 4875 */     String[] campos = this.con.regresaReg("empleados.nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,correo,fecha_nac,nss,rfc,sexo,ingreso,infonavitLetra,numInfo,comentarios,departamentos.nombre,actual, estado", "empleados,departamentos, estados", "where empleados.id_edo = estados.id_edo and empleados.clave_depa = departamentos.clave_depa and clave_emp = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 22);
/*      */     
/* 4877 */     this.jDialog2.setTitle(String.valueOf(this.rSTableMetro1.getValueAt(indice, 1)));
/*      */     
/* 4879 */     this.cLabel1.setIcon(null);
/* 4880 */     this.cLabel1.setText("Cargando...");
/* 4881 */     this.cargar = new cargarFoto(num);
/*      */     
/* 4883 */     this.jTextField7.setText(campos[0]);
/* 4884 */     if (campos[3].equals("")) {
/* 4885 */       this.jTextField9.setText("No Disponible");
/*      */     } else {
/* 4887 */       this.jTextField9.setText(campos[3]);
/*      */     } 
/* 4889 */     if (campos[4].equals("")) {
/* 4890 */       this.jTextField10.setText("No Disponible");
/*      */     } else {
/* 4892 */       this.jTextField10.setText(campos[4]);
/*      */     } 
/* 4894 */     if (campos[5].equals("")) {
/* 4895 */       this.jTextField11.setText("No Disponible");
/*      */     } else {
/* 4897 */       this.jTextField11.setText(campos[5]);
/*      */     } 
/* 4899 */     this.jTextField12.setText(campos[6]);
/* 4900 */     if (campos[7].equals("")) {
/* 4901 */       this.jTextField13.setText("No Disponible");
/*      */     } else {
/* 4903 */       this.jTextField13.setText(campos[7]);
/*      */     } 
/* 4905 */     if (campos[8].equals("")) {
/* 4906 */       this.jTextField14.setText("No Disponible");
/*      */     } else {
/* 4908 */       this.jTextField14.setText(campos[8]);
/*      */     } 
/* 4910 */     if (campos[9].equals("")) {
/* 4911 */       this.jTextField15.setText("No Disponible");
/*      */     } else {
/* 4913 */       this.jTextField15.setText(campos[9]);
/*      */     } 
/* 4915 */     if (campos[10].equals("")) {
/* 4916 */       this.jTextField17.setText("No Disponible");
/*      */     } else {
/* 4918 */       this.jTextField17.setText(campos[10]);
/*      */     } 
/* 4920 */     if (campos[11] != null) {
/* 4921 */       String str1 = campos[11].substring(0, 4);
/* 4922 */       String str2 = campos[11].substring(5, 7);
/* 4923 */       String str3 = campos[11].substring(8, 10);
/* 4924 */       String str4 = str3 + "/" + str3 + "/" + str2;
/* 4925 */       this.jTextField16.setText(str4);
/*      */     } else {
/* 4927 */       this.jTextField16.setText("");
/*      */     } 
/* 4929 */     this.jTextField20.setText(campos[12]);
/* 4930 */     this.jTextField21.setText(campos[13]);
/*      */     
/* 4932 */     if (!campos[14].equals("")) {
/* 4933 */       this.jTextField18.setText(campos[14]);
/*      */     } else {
/* 4935 */       this.jTextField18.setText("No Disponible");
/*      */     } 
/*      */     
/* 4938 */     this.jTextField23.setText(campos[16]);
/* 4939 */     this.jTextArea1.setText(campos[18]);
/*      */     
/* 4941 */     String año = campos[15].substring(0, 4);
/* 4942 */     String mes = campos[15].substring(5, 7);
/* 4943 */     String dia = campos[15].substring(8, 10);
/* 4944 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 4945 */     this.jTextField42.setText(this.rSTableMetro1.getValueAt(indice, 27).toString());
/*      */     
/* 4947 */     if (!campos[16].equals("")) {
/* 4948 */       this.jTextField22.setText(campos[17]);
/* 4949 */       this.jTextField23.setText(campos[16]);
/*      */     } else {
/* 4951 */       this.jTextField23.setText("No Disponible");
/* 4952 */       this.jTextField22.setText("No Disponible");
/*      */     } 
/* 4954 */     if (campos[20].equals("0")) {
/* 4955 */       this.jLabel68.setText("Activo");
/*      */     } else {
/* 4957 */       this.jLabel68.setText("Baja");
/*      */     } 
/* 4959 */     this.jTextField27.setText(campos[19]);
/*      */     
/* 4961 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 4962 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 4963 */     this.jTextField5.setText(campos[1]);
/* 4964 */     this.jTextField6.setText(campos[2]);
/*      */     
/* 4966 */     this.jTextField45.setText(campos[21]);
/*      */     
/* 4968 */     this.jTextField19.setText(this.rSTableMetro1.getValueAt(indice, 5).toString());
/* 4969 */     this.jTextField25.setText(this.rSTableMetro1.getValueAt(indice, 9).toString());
/* 4970 */     this.jTextField26.setText(this.rSTableMetro1.getValueAt(indice, 11).toString());
/* 4971 */     this.jTextField30.setText(this.rSTableMetro1.getValueAt(indice, 15).toString());
/* 4972 */     this.jTextField31.setText(this.rSTableMetro1.getValueAt(indice, 16).toString());
/* 4973 */     this.jTextField32.setText(this.rSTableMetro1.getValueAt(indice, 17).toString());
/*      */     
/* 4975 */     this.jTextField33.setText(this.rSTableMetro1.getValueAt(indice, 18).toString());
/* 4976 */     this.jTextField34.setText(this.rSTableMetro1.getValueAt(indice, 19).toString());
/* 4977 */     this.jTextField35.setText(this.rSTableMetro1.getValueAt(indice, 20).toString());
/* 4978 */     this.jTextField36.setText(this.rSTableMetro1.getValueAt(indice, 21).toString());
/* 4979 */     this.jTextField37.setText(this.rSTableMetro1.getValueAt(indice, 22).toString());
/* 4980 */     this.jTextField38.setText(this.rSTableMetro1.getValueAt(indice, 23).toString());
/* 4981 */     this.jTextField39.setText(this.rSTableMetro1.getValueAt(indice, 24).toString());
/* 4982 */     this.jTextField40.setText(this.rSTableMetro1.getValueAt(indice, 25).toString());
/* 4983 */     this.jTextField24.setText(this.rSTableMetro1.getValueAt(indice, 26).toString());
/*      */     
/* 4985 */     this.jTextField43.setText(this.rSTableMetro1.getValueAt(indice, 28).toString());
/* 4986 */     this.jTextField44.setText(this.rSTableMetro1.getValueAt(indice, 29).toString());
/* 4987 */     this.jTextField41.setText(this.rSTableMetro1.getValueAt(indice, 32).toString());
/*      */     
/* 4989 */     this.clicPanel = 0;
/* 4990 */     this.switch3.setOnOff(false);
/* 4991 */     clicMouse(this.jLabel16);
/* 4992 */     cambiarPanel(this.jPanel56);
/* 4993 */     this.jDialog2.setCursor(micursor);
/* 4994 */     this.jDialog2.setVisible(true);
/* 4995 */     setCursor(micursor);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 4999 */     int cont = this.rSTableMetro1.getRowCount();
/* 5000 */     String[] registros = new String[cont]; int i;
/* 5001 */     for (i = 0; i < cont; i++) {
/* 5002 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 5004 */     for (i = 0; i < cont; i++) {
/* 5005 */       registros[i] = registros[i] + " " + registros[i];
/* 5006 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 5008 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 5009 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void empleados(String usu) {
/* 5013 */     this.USUARIO = usu;
/*      */ 
/*      */     
/* 5016 */     this.PRIVILEGIOS = this.CAMPOSGENERALES.get("priv");
/* 5017 */     this.panel.setViewportView(this);
/* 5018 */     sacarPrivilegios();
/*      */     
/* 5020 */     consultar();
/*      */   }
/*      */   
/*      */   public String dameMes(String mes) {
/* 5024 */     String mesLetra = "";
/* 5025 */     if (mes.equals("01")) {
/* 5026 */       mesLetra = "Enero";
/* 5027 */     } else if (mes.equals("02")) {
/* 5028 */       mesLetra = "Febrero";
/* 5029 */     } else if (mes.equals("03")) {
/* 5030 */       mesLetra = "Marzo";
/* 5031 */     } else if (mes.equals("04")) {
/* 5032 */       mesLetra = "Abril";
/* 5033 */     } else if (mes.equals("05")) {
/* 5034 */       mesLetra = "Mayo";
/* 5035 */     } else if (mes.equals("06")) {
/* 5036 */       mesLetra = "Junio";
/* 5037 */     } else if (mes.equals("07")) {
/* 5038 */       mesLetra = "Julio";
/* 5039 */     } else if (mes.equals("08")) {
/* 5040 */       mesLetra = "Agosto";
/* 5041 */     } else if (mes.equals("09")) {
/* 5042 */       mesLetra = "Septiembre";
/* 5043 */     } else if (mes.equals("10")) {
/* 5044 */       mesLetra = "Octubre";
/* 5045 */     } else if (mes.equals("11")) {
/* 5046 */       mesLetra = "Noviembre";
/* 5047 */     } else if (mes.equals("12")) {
/* 5048 */       mesLetra = "Diciembre";
/*      */     } 
/* 5050 */     return mesLetra;
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 5054 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5056 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5060 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 5063 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5065 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5069 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 5072 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5074 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5078 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 5081 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5083 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5087 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 5090 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5092 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5096 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 5099 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5101 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5105 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 5108 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5110 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5114 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 5117 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5119 */             EmpleadosBuscar.this.jTextGanado(EmpleadosBuscar.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 5123 */             EmpleadosBuscar.this.jTextPerdido(EmpleadosBuscar.this.jComboBox4, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 5129 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 5133 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 5138 */     int otro = -1;
/* 5139 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5142 */       setEnabled((table == null || table.isEnabled()));
/* 5143 */       String valor = String.valueOf(value);
/* 5144 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 5145 */       if (comparar(comp)) {
/* 5146 */         setBackground(Color.red);
/* 5147 */         setForeground(Color.white);
/* 5148 */       } else if (row % 2 == 0 && (column == 3 || column == 4)) {
/* 5149 */         setBackground(new Color(120, 200, 104));
/* 5150 */         setForeground(Color.black);
/* 5151 */       } else if (row % 2 == 0 && (column == 10 || column == 11)) {
/* 5152 */         setBackground(new Color(136, 191, 173));
/* 5153 */         setForeground(Color.black);
/* 5154 */       } else if (row % 2 == 0) {
/* 5155 */         setBackground(EmpleadosBuscar.this.lc.FONDOTABLA);
/* 5156 */         setForeground(EmpleadosBuscar.this.lc.SECUNDARIO1);
/*      */       } else {
/* 5158 */         setBackground((Color)null);
/* 5159 */         setForeground(EmpleadosBuscar.this.lc.SECUNDARIO1);
/*      */       } 
/* 5161 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5162 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 5166 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 5170 */       for (int i = 0; i < this.indices.length; i++) {
/* 5171 */         if (this.indices[i].equals(reg)) {
/* 5172 */           return true;
/*      */         }
/*      */       } 
/* 5175 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 5180 */     String[] depa = this.con.regresaColIndex("nombre", "departamentos", " order by nombre");
/* 5181 */     this.jComboBox1.removeAllItems();
/* 5182 */     this.jComboBox1.addItem("GENERAL");
/* 5183 */     for (int i = 0; i < depa.length; i++) {
/* 5184 */       this.jComboBox1.addItem(depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   class ReporteIndividualEmp
/*      */   {
/* 5190 */     String archivo = "";
/* 5191 */     Calendar calendario = Calendar.getInstance(); int hora; int minutos;
/*      */     int segundos;
/*      */     
/*      */     public ReporteIndividualEmp(String Titulo, String[] Campitos, String Usuario) {
/* 5195 */       this.archivo = direccion();
/* 5196 */       this.hora = this.calendario.get(11);
/* 5197 */       this.minutos = this.calendario.get(12);
/* 5198 */       this.segundos = this.calendario.get(13);
/* 5199 */       if (!this.archivo.equals("no")) {
/* 5200 */         String cadenaFecha = "";
/* 5201 */         SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/* 5202 */         Date fecha = new Date();
/* 5203 */         cadenaFecha = formato.format(fecha);
/* 5204 */         String[] nombre = EmpleadosBuscar.this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + Usuario + "'", 3);
/* 5205 */         FileOutputStream fos = null;
/* 5206 */         PrintWriter pw = null;
/* 5207 */         File f = new File(this.archivo + ".xls");
/*      */         try {
/* 5209 */           Workbook libro1 = Workbook.getWorkbook(new File("Formatos/FormatoIndividualEmp.xls"));
/* 5210 */           WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/* 5211 */           WritableSheet hoja2 = copy.getSheet(0);
/*      */           
/* 5213 */           WritableFont fuente = new WritableFont(WritableFont.createFont("Aquaduct"), 12);
/* 5214 */           fuente.setColour(Colour.RED);
/* 5215 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 5216 */           WritableCellFormat forma = new WritableCellFormat(fuente);
/* 5217 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 5218 */           forma = new WritableCellFormat(fuente);
/* 5219 */           forma.setAlignment(Alignment.CENTRE);
/*      */           
/* 5221 */           for (int i = 0; i < Campitos.length; i++) {
/* 5222 */             System.out.println("" + i + " " + i);
/*      */           }
/*      */           
/* 5225 */           Label label = new Label(1, 2, Titulo);
/* 5226 */           label.setCellFormat((CellFormat)forma);
/* 5227 */           hoja2.addCell((WritableCell)label);
/*      */           try {
/* 5229 */             if ((new File(Campitos[21])).exists()) {
/* 5230 */               WritableImage wi = new WritableImage(0.0D, 7.0D, 3.0D, 14.0D, new File(Campitos[21]));
/* 5231 */               hoja2.addImage(wi);
/*      */             } 
/* 5233 */           } catch (Exception e) {
/* 5234 */             System.out.println(e.getMessage());
/*      */           } 
/*      */           
/* 5237 */           fuente = new WritableFont(WritableFont.createFont("Calibri"), 11);
/* 5238 */           fuente.setColour(Colour.RED);
/* 5239 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 5240 */           forma = new WritableCellFormat(fuente);
/* 5241 */           forma.setAlignment(Alignment.LEFT);
/*      */           
/* 5243 */           label = new Label(1, 4, Campitos[0]);
/* 5244 */           label.setCellFormat((CellFormat)forma);
/* 5245 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5247 */           label = new Label(6, 4, nombre[0] + " " + nombre[0] + " " + nombre[1]);
/* 5248 */           label.setCellFormat((CellFormat)forma);
/* 5249 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5251 */           fuente = new WritableFont(WritableFont.createFont("Calibri"), 12);
/* 5252 */           fuente.setColour(Colour.BLACK);
/* 5253 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 5254 */           forma = new WritableCellFormat(fuente);
/* 5255 */           forma.setAlignment(Alignment.CENTRE);
/* 5256 */           forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 5257 */           forma.setBackground(Colour.YELLOW);
/*      */           
/* 5259 */           label = new Label(7, 7, Campitos[1]);
/* 5260 */           label.setCellFormat((CellFormat)forma);
/* 5261 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5263 */           fuente = new WritableFont(WritableFont.createFont("Calibri"), 9);
/* 5264 */           fuente.setColour(Colour.BLUE);
/* 5265 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 5266 */           forma = new WritableCellFormat(fuente);
/* 5267 */           forma.setAlignment(Alignment.LEFT);
/* 5268 */           forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/*      */           
/* 5270 */           label = new Label(5, 8, Campitos[2]);
/* 5271 */           label.setCellFormat((CellFormat)forma);
/* 5272 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5274 */           label = new Label(5, 9, Campitos[3]);
/* 5275 */           label.setCellFormat((CellFormat)forma);
/* 5276 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5278 */           label = new Label(5, 10, Campitos[4]);
/* 5279 */           label.setCellFormat((CellFormat)forma);
/* 5280 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5282 */           label = new Label(5, 11, Campitos[5]);
/* 5283 */           label.setCellFormat((CellFormat)forma);
/* 5284 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5286 */           label = new Label(5, 12, Campitos[6]);
/* 5287 */           label.setCellFormat((CellFormat)forma);
/* 5288 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5290 */           label = new Label(5, 13, Campitos[7]);
/* 5291 */           label.setCellFormat((CellFormat)forma);
/* 5292 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5294 */           label = new Label(7, 13, Campitos[8]);
/* 5295 */           label.setCellFormat((CellFormat)forma);
/* 5296 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5298 */           label = new Label(5, 14, Campitos[9]);
/* 5299 */           label.setCellFormat((CellFormat)forma);
/* 5300 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5302 */           label = new Label(5, 15, Campitos[10]);
/* 5303 */           label.setCellFormat((CellFormat)forma);
/* 5304 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5306 */           label = new Label(5, 16, Campitos[11]);
/* 5307 */           label.setCellFormat((CellFormat)forma);
/* 5308 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5310 */           label = new Label(5, 17, Campitos[12]);
/* 5311 */           label.setCellFormat((CellFormat)forma);
/* 5312 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5314 */           label = new Label(5, 18, Campitos[13]);
/* 5315 */           label.setCellFormat((CellFormat)forma);
/* 5316 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5318 */           label = new Label(5, 19, Campitos[14]);
/* 5319 */           label.setCellFormat((CellFormat)forma);
/* 5320 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5322 */           label = new Label(7, 19, Campitos[15]);
/* 5323 */           label.setCellFormat((CellFormat)forma);
/* 5324 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5326 */           label = new Label(5, 20, Campitos[16]);
/* 5327 */           label.setCellFormat((CellFormat)forma);
/* 5328 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5330 */           label = new Label(7, 20, Campitos[17]);
/* 5331 */           label.setCellFormat((CellFormat)forma);
/* 5332 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5334 */           label = new Label(1, 22, Campitos[18]);
/* 5335 */           label.setCellFormat((CellFormat)forma);
/* 5336 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5338 */           label = new Label(6, 22, Campitos[19]);
/* 5339 */           label.setCellFormat((CellFormat)forma);
/* 5340 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5342 */           fuente = new WritableFont(WritableFont.createFont("Calibri"), 13);
/* 5343 */           fuente.setColour(Colour.BLACK);
/* 5344 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 5345 */           forma = new WritableCellFormat(fuente);
/* 5346 */           forma.setAlignment(Alignment.JUSTIFY);
/* 5347 */           forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 5348 */           forma.setWrap(true);
/* 5349 */           forma.setLocked(true);
/*      */           
/* 5351 */           label = new Label(0, 26, Campitos[20]);
/* 5352 */           label.setCellFormat((CellFormat)forma);
/* 5353 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 5355 */           copy.write();
/* 5356 */           copy.close();
/* 5357 */           JOptionPane.showMessageDialog(null, "<HTML>El reporte se creó satisfactoriamente en la siguiente dirección<HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, EmpleadosBuscar.this.INFO);
/* 5358 */         } catch (Exception e) {
/* 5359 */           JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + e.getMessage());
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     public String direccion() {
/* 5365 */       JFileChooser fileChooser = new JFileChooser();
/* 5366 */       String fileName = "";
/* 5367 */       int retVal = fileChooser.showSaveDialog(null);
/* 5368 */       if (retVal == 0) {
/* 5369 */         fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 5370 */         return fileName;
/*      */       } 
/* 5372 */       return "no";
/*      */     }
/*      */   }
/*      */   
/*      */   class cargarFoto
/*      */     implements Runnable {
/*      */     Thread t;
/* 5379 */     String num = "";
/*      */     
/*      */     cargarFoto(String valor) {
/* 5382 */       this.t = new Thread(this);
/* 5383 */       this.num = valor;
/* 5384 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5391 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosBuscar.this.RUTA + "/" + EmpleadosBuscar.this.RUTA + ".png");
/* 5392 */       EmpleadosBuscar.this.FOTO = EmpleadosBuscar.this.RUTA + "/" + EmpleadosBuscar.this.RUTA + ".png";
/* 5393 */       System.out.println("RUTA " + EmpleadosBuscar.this.RUTA + " FOTO " + EmpleadosBuscar.this.FOTO);
/* 5394 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(185, -1, 1));
/* 5395 */       EmpleadosBuscar.this.cLabel1.setText("");
/* 5396 */       if (temporal.getImageLoadStatus() == 4) {
/* 5397 */         EmpleadosBuscar.this.cLabel1.setText("Sin Fotogafías");
/*      */       } else {
/* 5399 */         EmpleadosBuscar.this.cLabel1.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   class fotoIndividual
/*      */     implements Runnable {
/*      */     Thread t;
/* 5407 */     String num = "";
/*      */     
/*      */     fotoIndividual(String valor) {
/* 5410 */       this.t = new Thread(this);
/* 5411 */       this.num = valor;
/* 5412 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5419 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosBuscar.this.RUTA + "/" + EmpleadosBuscar.this.RUTA + ".png");
/*      */       
/* 5421 */       System.out.println("dir " + tmpIcon.getDescription());
/* 5422 */       EmpleadosBuscar.this.FOTO = EmpleadosBuscar.this.RUTA + "/" + EmpleadosBuscar.this.RUTA + ".png";
/*      */       
/* 5424 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(190, -1, 1));
/* 5425 */       EmpleadosBuscar.this.jLabel1.setText("");
/* 5426 */       if (temporal.getImageLoadStatus() == 4) {
/* 5427 */         EmpleadosBuscar.this.jLabel1.setText("Sin Fotogafía");
/*      */       } else {
/* 5429 */         EmpleadosBuscar.this.jLabel1.setText("");
/* 5430 */         EmpleadosBuscar.this.jLabel1.setIcon(temporal);
/*      */       } 
/* 5432 */       String valor = String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(EmpleadosBuscar.this.rSTableMetro1.getSelectedRow(), 24));
/* 5433 */       if (!valor.equals("VACÍO")) {
/* 5434 */         EmpleadosBuscar.this.jLabel11.setVisible(true);
/* 5435 */         EmpleadosBuscar.this.jLabel11.setText("<html><center>" + valor + "</center></html>");
/*      */       } else {
/* 5437 */         EmpleadosBuscar.this.jLabel11.setVisible(false);
/*      */       } 
/*      */     } }
/*      */   
/*      */   public class ImprimirCredencial implements Printable { int opc;
/*      */     Graphics2D g2;
/*      */     
/* 5444 */     public ImprimirCredencial() { this.opc = 0;
/* 5445 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; ImageIcon tmpIcon; String nombre;
/*      */       int cuenta, esp3;
/*      */       String nombre1, nombre2;
/* 5448 */       this.g2 = (Graphics2D)g;
/* 5449 */       f.setOrientation(1);
/* 5450 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 5456 */           fuente = new Font("Dialog", 1, 12);
/* 5457 */           this.g2.setFont(fuente);
/* 5458 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5466 */           this.g2.setColor(Color.BLACK);
/* 5467 */           this.g2.drawRect(30, 45, 244, 154);
/* 5468 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 5470 */           fuente = new Font("Times New Roman", 1, 11);
/* 5471 */           this.g2.setFont(fuente);
/* 5472 */           this.g2.setColor(new Color(153, 0, 0));
/* 5473 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 34, 57);
/*      */           
/* 5475 */           fuente = new Font("Dialog", 1, 9);
/* 5476 */           this.g2.setFont(fuente);
/* 5477 */           this.g2.setColor(Color.BLACK);
/* 5478 */           this.g2.drawLine(35, 60, 255, 60);
/* 5479 */           this.g2.drawLine(45, 63, 265, 63);
/* 5480 */           this.g2.drawRect(32, 69, 68, 90);
/*      */           
/* 5482 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/mosaico.png"));
/* 5483 */           img = imagen.getImage();
/* 5484 */           this.g2.drawImage(img, 193, 80, 80, 85, null);
/*      */           
/* 5486 */           tmpIcon = new ImageIcon(EmpleadosBuscar.this.DIRECTIVA[0] + "/" + EmpleadosBuscar.this.DIRECTIVA[0] + ".png");
/* 5487 */           img = tmpIcon.getImage();
/* 5488 */           this.g2.drawImage(img, 33, 70, 66, 88, null);
/*      */           
/* 5490 */           fuente = new Font("Dialog", 1, 9);
/* 5491 */           this.g2.setFont(fuente);
/* 5492 */           this.g2.setColor(Color.BLACK);
/* 5493 */           nombre = String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(EmpleadosBuscar.this.rSTableMetro1.getSelectedRow(), 1));
/* 5494 */           cuenta = 0;
/* 5495 */           esp3 = 0;
/* 5496 */           nombre1 = "";
/* 5497 */           nombre2 = "";
/* 5498 */           if (nombre.length() > 26) {
/* 5499 */             for (int i = 0; i < nombre.length(); i++) {
/* 5500 */               if (nombre.charAt(i) == ' ') {
/* 5501 */                 cuenta++;
/*      */               }
/* 5503 */               if (cuenta < 3) {
/* 5504 */                 nombre1 = nombre1 + nombre1;
/*      */               } else {
/* 5506 */                 nombre2 = nombre2 + nombre2;
/*      */               } 
/*      */             } 
/*      */           } else {
/* 5510 */             nombre1 = nombre;
/*      */           } 
/* 5512 */           this.g2.drawString(nombre1, 105, 77);
/* 5513 */           this.g2.drawString(nombre2, 103, 88);
/*      */           
/* 5515 */           fuente = new Font("Dialog", 1, 8);
/* 5516 */           this.g2.setFont(fuente);
/*      */           
/* 5518 */           this.g2.drawString("TELÉFONO:", 105, 102);
/* 5519 */           this.g2.drawString("NSS:", 105, 126);
/* 5520 */           this.g2.drawString("CURP:", 105, 138);
/* 5521 */           this.g2.drawString("VIGENCIA:", 105, 151);
/*      */           
/* 5523 */           fuente = new Font("Dialog", 0, 9);
/* 5524 */           this.g2.setFont(fuente);
/* 5525 */           this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(EmpleadosBuscar.this.rSTableMetro1.getSelectedRow(), 3)), 105, 112);
/* 5526 */           this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(EmpleadosBuscar.this.rSTableMetro1.getSelectedRow(), 10)), 127, 126);
/* 5527 */           this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(EmpleadosBuscar.this.rSTableMetro1.getSelectedRow(), 12)), 134, 138);
/* 5528 */           this.g2.drawString(EmpleadosBuscar.this.VIGENCIA, 105, 161);
/*      */           
/* 5530 */           fuente = new Font("DialogInput", 1, 10);
/* 5531 */           this.g2.setFont(fuente);
/* 5532 */           this.g2.drawString(EmpleadosBuscar.this.CLAVEOP, 39, 173);
/*      */           
/* 5534 */           this.g2.setColor(new Color(247, 150, 70));
/* 5535 */           this.g2.fill3DRect(102, 164, 170, 12, true);
/*      */           
/* 5537 */           this.g2.setColor(Color.BLACK);
/* 5538 */           this.g2.drawString(EmpleadosBuscar.this.jLabel81.getText(), 114, 173);
/*      */           
/* 5540 */           this.g2.setColor(new Color(153, 0, 0));
/* 5541 */           this.g2.fill3DRect(32, 180, 240, 18, true);
/*      */           
/* 5543 */           fuente = new Font("Dialog", 0, 7);
/* 5544 */           this.g2.setColor(Color.WHITE);
/* 5545 */           this.g2.setFont(fuente);
/* 5546 */           this.g2.drawString("Carretera México - Tuxpan Km. 8.5  Ejido Lázaro Cárdenas", 60, 187);
/* 5547 */           this.g2.drawString(" Tihuatlán, Veracruz México C.P. 92901 (01 782)-825-6455 al 58 ", 53, 195);
/*      */           
/* 5549 */           fuente = new Font("Dialog", 1, 10);
/* 5550 */           this.g2.setColor(Color.BLACK);
/* 5551 */           this.g2.drawString("|                                                         |", 58, 187);
/* 5552 */           this.g2.drawString("|                               |            |                  |                                       |", 53, 195);
/*      */ 
/*      */           
/* 5555 */           fuente = new Font("Times New Roman", 1, 11);
/* 5556 */           this.g2.setFont(fuente);
/* 5557 */           this.g2.setColor(new Color(153, 0, 0));
/* 5558 */           this.g2.drawString("POLÍTICAS DE LA EMPRESA", 325, 57);
/*      */           
/* 5560 */           fuente = new Font("Dialog", 1, 9);
/* 5561 */           this.g2.setFont(fuente);
/* 5562 */           this.g2.setColor(Color.BLACK);
/* 5563 */           this.g2.drawLine(285, 60, 505, 60);
/* 5564 */           this.g2.drawLine(290, 63, 515, 63);
/*      */ 
/*      */           
/* 5567 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/codigoBarras.png"));
/* 5568 */           img = imagen.getImage();
/* 5569 */           this.g2.drawImage(img, 492, 70, 30, 120, null);
/*      */           
/* 5571 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png"));
/* 5572 */           img = imagen.getImage();
/*      */           
/* 5574 */           this.g2.drawImage(img, 281, 100, 211, 60, null);
/*      */           
/* 5576 */           fuente = new Font("Dialog", 0, 5);
/* 5577 */           this.g2.setFont(fuente);
/* 5578 */           this.g2.drawString("•   Brindar trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos", 282, 73);
/* 5579 */           this.g2.drawString("     considerando que el fin de la empresa es el servicio del cliente.", 282, 79);
/* 5580 */           this.g2.drawString("•   Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo", 282, 88);
/* 5581 */           this.g2.drawString("     es mi responsabilidad.", 282, 94);
/* 5582 */           this.g2.drawString("•   Como integrante de la empresa debo mantener un comportamiento ético, desterrar", 282, 103);
/* 5583 */           this.g2.drawString("     toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de", 282, 109);
/* 5584 */           this.g2.drawString("     FORSIS y de todos los clientes.", 282, 115);
/* 5585 */           this.g2.drawString("•   Realizar evaluaciones periódicas, permanentes a todos los procesos donde se está", 282, 124);
/* 5586 */           this.g2.drawString("     involucrado mi desempeño.", 282, 130);
/* 5587 */           this.g2.drawString("•   Preservar el entorno ambiental y la seguridad de la comunidad en todo trabajo.", 282, 139);
/* 5588 */           this.g2.drawString("•   Difundir permanentemente la gestión de la empresa en forma interna y externa.", 282, 145);
/*      */           
/* 5590 */           fuente = new Font("Dialog", 1, 5);
/* 5591 */           this.g2.setFont(fuente);
/* 5592 */           this.g2.drawString(EmpleadosBuscar.this.jLabel82.getText(), 290, 165);
/* 5593 */           this.g2.drawString("ROGER GARZA CANTÚ", 420, 165);
/* 5594 */           this.g2.drawString("____________________________", 295, 185);
/* 5595 */           this.g2.drawString("____________________________", 410, 185);
/* 5596 */           this.g2.drawString(EmpleadosBuscar.this.jLabel81.getText().toUpperCase(), 295, 195);
/* 5597 */           this.g2.drawString("DIRECTOR", 438, 195);
/*      */           
/* 5599 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/firma.png"));
/* 5600 */           img = imagen.getImage();
/* 5601 */           this.g2.drawImage(img, 432, 159, 38, 38, null);
/*      */           
/* 5603 */           return 0;
/*      */       } 
/* 5605 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 5610 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5611 */       job.setPrintable(this);
/*      */       
/* 5613 */       PageFormat pf = job.defaultPage();
/* 5614 */       Paper papel = pf.getPaper();
/* 5615 */       papel.setSize(612.0D, 792.0D);
/* 5616 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5617 */       pf.setPaper(papel);
/* 5618 */       pf.setOrientation(1);
/* 5619 */       ImprimirCredencial im = new ImprimirCredencial();
/* 5620 */       job.setPrintable(im, pf);
/* 5621 */       job.defaultPage(pf);
/*      */       
/* 5623 */       boolean ok = job.printDialog();
/* 5624 */       if (ok) {
/*      */         try {
/* 5626 */           job.print();
/* 5627 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     } }
/*      */ 
/*      */   
/*      */   public class fotoCredencial
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 5636 */     String num = "";
/*      */     
/*      */     fotoCredencial(String valor) {
/* 5639 */       this.t = new Thread(this);
/* 5640 */       this.num = valor;
/* 5641 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5648 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosBuscar.this.DIRECTIVA[0] + "/" + EmpleadosBuscar.this.DIRECTIVA[0] + ".png");
/* 5649 */       EmpleadosBuscar.this.FOTO = EmpleadosBuscar.this.DIRECTIVA[0] + "/" + EmpleadosBuscar.this.DIRECTIVA[0] + ".png";
/* 5650 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(98, -1, 1));
/* 5651 */       EmpleadosBuscar.this.jLabel78.setText("");
/* 5652 */       EmpleadosBuscar.this.jLabel98.setText("");
/* 5653 */       EmpleadosBuscar.this.cLabel1.setText("");
/* 5654 */       if (temporal.getImageLoadStatus() == 4) {
/* 5655 */         EmpleadosBuscar.this.jLabel78.setText("Sin fotografía");
/* 5656 */         EmpleadosBuscar.this.jLabel115.setText("Sin fotografía");
/* 5657 */         EmpleadosBuscar.this.jLabel98.setText("Sin fotografía");
/*      */       } else {
/*      */         
/* 5660 */         EmpleadosBuscar.this.jLabel78.setText("");
/* 5661 */         EmpleadosBuscar.this.jLabel115.setText("");
/* 5662 */         EmpleadosBuscar.this.jLabel98.setText("");
/* 5663 */         EmpleadosBuscar.this.cLabel1.setText("");
/* 5664 */         EmpleadosBuscar.this.jLabel78.setIcon(temporal);
/* 5665 */         EmpleadosBuscar.this.jLabel115.setIcon(temporal);
/* 5666 */         EmpleadosBuscar.this.jLabel98.setIcon(temporal);
/*      */       } 
/*      */     } }
/*      */   
/*      */   public class ImprimirRigPass implements Printable { int opc;
/*      */     Graphics2D g2;
/*      */     
/* 5673 */     public ImprimirRigPass() { this.opc = 0;
/* 5674 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen;
/*      */       Image img;
/*      */       ImageIcon tmpIcon;
/* 5677 */       this.g2 = (Graphics2D)g;
/* 5678 */       f.setOrientation(1);
/* 5679 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 5685 */           fuente = new Font("Dialog", 1, 12);
/* 5686 */           this.g2.setFont(fuente);
/* 5687 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5695 */           this.g2.setColor(Color.BLUE);
/* 5696 */           this.g2.drawRect(30, 45, 244, 154);
/* 5697 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 5699 */           fuente = new Font("Times New Roman", 1, 8);
/* 5700 */           this.g2.setFont(fuente);
/* 5701 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 82, 61);
/* 5702 */           this.g2.drawRoundRect(34, 49, 237, 147, 10, 10);
/* 5703 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisOriginal.png"));
/* 5704 */           img = imagen.getImage();
/* 5705 */           this.g2.drawImage(img, 37, 52, 36, 38, null);
/*      */           
/* 5707 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png"));
/* 5708 */           img = imagen.getImage();
/* 5709 */           this.g2.drawImage(img, 78, 65, 177, 19, null);
/*      */           
/* 5711 */           tmpIcon = new ImageIcon(EmpleadosBuscar.this.DIRECTIVA[0] + "/" + EmpleadosBuscar.this.DIRECTIVA[0] + ".png");
/* 5712 */           img = tmpIcon.getImage();
/* 5713 */           this.g2.drawImage(img, 39, 94, 56, 78, null);
/*      */           
/* 5715 */           this.g2.setColor(Color.BLACK);
/* 5716 */           this.g2.drawRect(38, 93, 58, 80);
/*      */           
/* 5718 */           fuente = new Font("Dialog", 0, 6);
/* 5719 */           this.g2.setFont(fuente);
/* 5720 */           this.g2.drawString("ACREDITA  A:", 155, 95);
/* 5721 */           this.g2.drawString("DE HABER TENIDO EL:", 150, 120);
/*      */           
/* 5723 */           this.g2.setColor(Color.BLUE);
/* 5724 */           fuente = new Font("Dialog", 1, 7);
/* 5725 */           this.g2.setFont(fuente);
/* 5726 */           this.g2.drawString(EmpleadosBuscar.this.jLabel113.getText(), 125, 105);
/* 5727 */           fuente = new Font("Dialog", 1, 8);
/* 5728 */           this.g2.setFont(fuente);
/* 5729 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 114, 130);
/* 5730 */           this.g2.drawString("____________________________", 114, 131);
/*      */           
/* 5732 */           fuente = new Font("Dialog", 1, 5);
/* 5733 */           this.g2.setFont(fuente);
/* 5734 */           this.g2.setColor(Color.BLACK);
/* 5735 */           this.g2.drawString("POR EL AGENTE CAPACITADOR:", 140, 138);
/* 5736 */           this.g2.drawString(EmpleadosBuscar.this.CONFIG[3], 135, 145);
/* 5737 */           this.g2.drawString(EmpleadosBuscar.this.CONFIG[2], 150, 152);
/*      */           
/* 5739 */           this.g2.drawString("Certificado por:", 160, 163);
/* 5740 */           this.g2.drawString("SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL", 114, 170);
/*      */           
/* 5742 */           fuente = new Font("Dialog", 0, 6);
/* 5743 */           this.g2.setFont(fuente);
/* 5744 */           this.g2.drawString("|Carretera México - Tuxpan Km. 8.5|Ejido Lázaro Cárdenas|", 70, 183);
/* 5745 */           this.g2.drawString("|Tihuatlán, Veracruz|México|C.P. 92901|(01 782)-825-6455 al 58|", 64, 192);
/*      */ 
/*      */           
/* 5748 */           this.g2.setColor(Color.BLUE);
/* 5749 */           this.g2.drawRoundRect(284, 49, 237, 147, 10, 10);
/* 5750 */           fuente = new Font("Dialog", 1, 8);
/* 5751 */           this.g2.setFont(fuente);
/* 5752 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 340, 61);
/* 5753 */           this.g2.drawString("____________________________", 340, 62);
/*      */           
/* 5755 */           this.g2.setColor(Color.BLACK);
/* 5756 */           fuente = new Font("Dialog", 0, 6);
/* 5757 */           this.g2.setFont(fuente);
/* 5758 */           this.g2.drawString("NOMBRE DEL EMPLEADO:", 290, 80);
/* 5759 */           this.g2.drawString("CURP:", 290, 95);
/* 5760 */           this.g2.drawString("IMSS:", 290, 110);
/* 5761 */           this.g2.drawString("VIGENCIA:", 290, 125);
/*      */           
/* 5763 */           this.g2.setColor(Color.BLUE);
/* 5764 */           fuente = new Font("Dialog", 1, 7);
/* 5765 */           this.g2.setFont(fuente);
/* 5766 */           this.g2.drawString(EmpleadosBuscar.this.jLabel113.getText().toUpperCase(), 370, 80);
/* 5767 */           this.g2.drawString(EmpleadosBuscar.this.jLabel129.getText().toUpperCase(), 370, 95);
/* 5768 */           this.g2.drawString(EmpleadosBuscar.this.jLabel134.getText().toUpperCase(), 370, 110);
/* 5769 */           this.g2.drawString(EmpleadosBuscar.this.jLabel136.getText().toUpperCase(), 370, 125);
/*      */           
/* 5771 */           this.g2.setColor(Color.BLACK);
/* 5772 */           this.g2.drawString("DE ACUERDO A LOS LINEAMIENTOS DE:", 333, 147);
/* 5773 */           this.g2.drawString("'INTERNATIONAL ASSOCIATION OF DRILLING CONTRACTORS'", 296, 157);
/*      */           
/* 5775 */           fuente = new Font("Dialog", 1, 5);
/* 5776 */           this.g2.setFont(fuente);
/* 5777 */           this.g2.drawString("Firma:______________________", 290, 188);
/*      */           
/* 5779 */           fuente = new Font("Dialog", 1, 8);
/* 5780 */           this.g2.setFont(fuente);
/* 5781 */           this.g2.drawString("F" + EmpleadosBuscar.this.CONFIG[1] + "-", 470, 190);
/*      */           
/* 5783 */           this.g2.setColor(Color.BLUE);
/* 5784 */           this.g2.drawString(EmpleadosBuscar.this.jLabel135.getText().toUpperCase(), 490, 190);
/*      */           
/* 5786 */           return 0;
/*      */       } 
/* 5788 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 5793 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5794 */       job.setPrintable(this);
/*      */       
/* 5796 */       PageFormat pf = job.defaultPage();
/* 5797 */       Paper papel = pf.getPaper();
/* 5798 */       papel.setSize(612.0D, 792.0D);
/* 5799 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5800 */       pf.setPaper(papel);
/* 5801 */       pf.setOrientation(1);
/* 5802 */       ImprimirRigPass im = new ImprimirRigPass();
/* 5803 */       job.setPrintable(im, pf);
/* 5804 */       job.defaultPage(pf);
/*      */       
/* 5806 */       boolean ok = job.printDialog();
/* 5807 */       if (ok) {
/*      */         try {
/* 5809 */           job.print();
/* 5810 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     } }
/*      */ 
/*      */   
/*      */   public class ImprimirLista
/*      */     implements Printable
/*      */   {
/*      */     int[] pageBreaks;
/*      */     String[] textLines;
/* 5820 */     Graphics g2 = null;
/* 5821 */     int Pag = 0;
/*      */     String[][] Lineas;
/* 5823 */     int linesPerPage = 50;
/* 5824 */     int orientacion = 0;
/* 5825 */     double X = 0.0D;
/* 5826 */     double Y = 0.0D;
/* 5827 */     int YINICIA = 75;
/* 5828 */     int[] PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 5829 */     int NumLineas = 0;
/* 5830 */     int numBreaks = 0;
/*      */     
/*      */     private void initTextLines() {
/* 5833 */       if (this.textLines == null) {
/* 5834 */         int numLines = EmpleadosBuscar.this.rSTableMetro1.getRowCount();
/* 5835 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 5840 */       Font font = new Font("Serif", 0, 8);
/* 5841 */       FontMetrics metrics = g.getFontMetrics(font);
/* 5842 */       int lineHeight = metrics.getHeight();
/* 5843 */       if (this.pageBreaks == null) {
/* 5844 */         initTextLines();
/* 5845 */         this.orientacion = pf.getOrientation();
/* 5846 */         if (pf.getOrientation() == 1) {
/* 5847 */           this.linesPerPage = 46;
/* 5848 */           this.X = pf.getWidth();
/* 5849 */           this.Y = pf.getHeight();
/*      */         } else {
/* 5851 */           this.linesPerPage = 38;
/* 5852 */           this.X = pf.getWidth();
/* 5853 */           this.Y = pf.getHeight();
/*      */         } 
/* 5855 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 5856 */         this.Pag = this.numBreaks;
/* 5857 */         this.pageBreaks = new int[this.numBreaks];
/* 5858 */         for (int b = 0; b < this.numBreaks; b++) {
/* 5859 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 5862 */       if (pageIndex > this.pageBreaks.length) {
/* 5863 */         return 1;
/*      */       }
/* 5865 */       Graphics2D g2d = (Graphics2D)g;
/* 5866 */       this.g2 = g;
/* 5867 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 5868 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 5869 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 5870 */       encabezado();
/* 5871 */       int y = this.YINICIA;
/* 5872 */       int lineas = 0;
/*      */       
/* 5874 */       this.g2.drawRect(25, 140, 550, 12);
/* 5875 */       this.g2.setColor(new Color(204, 0, 0));
/* 5876 */       this.g2.fillRect(26, 141, 548, 10);
/*      */       
/* 5878 */       Font fuente = new Font("Dialog", 1, 8);
/* 5879 */       this.g2.setFont(fuente);
/* 5880 */       this.g2.setColor(Color.WHITE);
/* 5881 */       this.g2.drawString("CLAVE", 29, 149);
/* 5882 */       this.g2.drawString("NOMBRE", 100, 149);
/* 5883 */       this.g2.drawString("CELULAR", 208, 149);
/* 5884 */       this.g2.drawString("NEXTEL", 260, 149);
/* 5885 */       this.g2.drawString("NSS", 305, 149);
/* 5886 */       this.g2.drawString("CURP", 347, 149);
/*      */       
/* 5888 */       this.g2.drawString("DEPARTAMENTO", 435, 149);
/* 5889 */       this.g2.drawString("INGRESO", 527, 149);
/*      */       
/* 5891 */       this.g2.setColor(Color.BLACK);
/* 5892 */       y = 150;
/* 5893 */       for (int line = start; line < end; line++) {
/* 5894 */         y += 12;
/* 5895 */         this.g2.drawLine(25, y, 575, y);
/*      */         
/* 5897 */         String valor = "";
/* 5898 */         if (line < 9) {
/* 5899 */           valor = "0" + line + 1;
/*      */         } else {
/* 5901 */           valor = "" + line + 1;
/*      */         } 
/* 5903 */         fuente = new Font("Dialog", 1, 7);
/* 5904 */         this.g2.setFont(fuente);
/* 5905 */         this.g2.drawString(valor, EmpleadosBuscar.this.alinearDer(23, valor.toString().length()), y - 2);
/*      */         
/* 5907 */         fuente = new Font("Dialog", 0, 6);
/* 5908 */         this.g2.setFont(fuente);
/*      */         
/* 5910 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 0)), EmpleadosBuscar.this.alinearDer(45, EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 0).toString().length()), y - 2);
/* 5911 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 1)), 60, y - 2);
/* 5912 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 4)), 207, y - 2);
/* 5913 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 5)), 260, y - 2);
/* 5914 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 10)), 302, y - 2);
/* 5915 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 12)), 347, y - 2);
/*      */         
/* 5917 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 31)), 440, y - 2);
/* 5918 */         this.g2.drawString(String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(line, 27)), 530, y - 2);
/*      */       } 
/* 5920 */       this.g2.drawLine(25, 151, 25, y);
/* 5921 */       this.g2.drawLine(575, 151, 575, y);
/* 5922 */       fuente = new Font("Dialog", 0, 7);
/* 5923 */       this.g2.setFont(fuente);
/* 5924 */       g.drawString("Página " + pageIndex + 1, 548, 755);
/* 5925 */       this.g2.setColor(Color.WHITE);
/* 5926 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/*      */       
/* 5928 */       if (this.Pag == pageIndex) {
/* 5929 */         fuente = new Font("Dialog", 1, 7);
/* 5930 */         this.g2.setFont(fuente);
/* 5931 */         this.g2.setColor(Color.BLACK);
/* 5932 */         this.g2.drawString("ELABORÓ", 300, 720);
/* 5933 */         this.g2.drawString("_____________________________________", 250, 752);
/* 5934 */         this.g2.drawString("NOMBRE Y FIRMA", 288, 765);
/*      */       } 
/* 5936 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 5940 */       Font fuente = new Font("Dialog", 0, 8);
/* 5941 */       this.g2.setFont(fuente);
/* 5942 */       this.g2.setColor(Color.BLACK);
/* 5943 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5944 */       Image img = imagen.getImage();
/* 5945 */       this.g2.drawImage(img, 518, 9, 60, 60, null);
/*      */       
/* 5947 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 5948 */       img = imagen.getImage();
/* 5949 */       this.g2.drawImage(img, 27, 16, 60, 50, null);
/*      */       
/* 5951 */       fuente = new Font("Times New Roman", 1, 16);
/* 5952 */       this.g2.setFont(fuente);
/* 5953 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 30);
/* 5954 */       fuente = new Font("Dialog", 0, 11);
/* 5955 */       this.g2.setFont(fuente);
/* 5956 */       this.g2.drawString("LISTA DE EMPLEADOS", 225, 47);
/* 5957 */       this.g2.drawLine(25, 71, 575, 71);
/*      */       
/* 5959 */       fuente = new Font("Dialog", 1, 8);
/* 5960 */       this.g2.setFont(fuente);
/*      */       
/* 5962 */       fuente = new Font("Dialog", 0, 8);
/* 5963 */       this.g2.setFont(fuente);
/*      */       
/* 5965 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5966 */       String cadenaFecha1 = formato.format(new Date());
/* 5967 */       String año = cadenaFecha1.substring(0, 4);
/* 5968 */       String mes = cadenaFecha1.substring(4, 6);
/* 5969 */       String dia = cadenaFecha1.substring(6, 8);
/*      */       
/* 5971 */       this.g2.drawRect(25, 77, 550, 50);
/*      */       
/* 5973 */       this.g2.setColor(new Color(204, 0, 0));
/* 5974 */       this.g2.fillRect(25, 78, 550, 12);
/*      */       
/* 5976 */       this.g2.setColor(Color.BLACK);
/* 5977 */       this.g2.drawLine(25, 90, 575, 90);
/*      */       
/* 5979 */       this.g2.drawLine(287, 90, 287, 127);
/*      */       
/* 5981 */       fuente = new Font("Dialog", 0, 8);
/* 5982 */       this.g2.setFont(fuente);
/* 5983 */       this.g2.setColor(Color.WHITE);
/* 5984 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 235, 87);
/*      */       
/* 5986 */       fuente = new Font("Dialog", 0, 7);
/* 5987 */       this.g2.setFont(fuente);
/* 5988 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 5990 */       this.g2.drawString("RESPONSABLE: ", 27, 100);
/* 5991 */       this.g2.drawString("REPORTE DE: ", 27, 111);
/* 5992 */       this.g2.drawString("FECHA DE IMP: ", 27, 122);
/*      */       
/* 5994 */       this.g2.drawString("DEPARTAMENTO: ", 292, 100);
/* 5995 */       this.g2.drawString("ESTATUS:", 292, 111);
/* 5996 */       this.g2.drawString("SUCURSAL:", 292, 122);
/*      */       
/* 5998 */       fuente = new Font("Dialog", 1, 7);
/* 5999 */       this.g2.setFont(fuente);
/*      */       
/* 6001 */       String tipo = "";
/* 6002 */       if (EmpleadosBuscar.this.jComboBox4.getSelectedIndex() == 0) {
/* 6003 */         tipo = "EMPLEADOS";
/* 6004 */       } else if (EmpleadosBuscar.this.jComboBox4.getSelectedIndex() == 1) {
/* 6005 */         tipo = "FUNCIONARIOS";
/*      */       } else {
/* 6007 */         tipo = "GENERAL";
/*      */       } 
/*      */       
/* 6010 */       String[] USU = EmpleadosBuscar.this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu = '" + EmpleadosBuscar.this.USUARIO + "'", 3);
/*      */       
/* 6012 */       this.g2.drawString(USU[1] + " " + USU[1] + " " + USU[2], 95, 100);
/* 6013 */       this.g2.drawString(tipo, 95, 111);
/* 6014 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 95, 122);
/*      */       
/* 6016 */       EmpleadosBuscar.this.con.consultar("sucursal", "configuraciones", "");
/* 6017 */       String espe = "GENERAL";
/* 6018 */       if (EmpleadosBuscar.this.jComboBox1.getSelectedIndex() != 0) {
/* 6019 */         espe = String.valueOf(EmpleadosBuscar.this.jComboBox1.getSelectedItem());
/*      */       }
/* 6021 */       String estatus = String.valueOf(EmpleadosBuscar.this.jComboBox3.getSelectedItem());
/* 6022 */       this.g2.drawString(espe.toUpperCase(), 375, 100);
/* 6023 */       this.g2.drawString(estatus.toUpperCase(), 375, 111);
/* 6024 */       this.g2.drawString(EmpleadosBuscar.this.con.Campo, 375, 122);
/*      */     }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6029 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6030 */       job.setPrintable(this);
/*      */       
/* 6032 */       PageFormat pf = job.defaultPage();
/* 6033 */       Paper papel = pf.getPaper();
/* 6034 */       papel.setSize(612.0D, 792.0D);
/* 6035 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6036 */       pf.setPaper(papel);
/* 6037 */       pf.setOrientation(1);
/* 6038 */       job.setPrintable(new ImprimirLista(), pf);
/* 6039 */       job.defaultPage(pf);
/*      */       
/* 6041 */       boolean ok = job.printDialog();
/* 6042 */       if (ok) {
/*      */         try {
/* 6044 */           job.print();
/* 6045 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public class fotoFirmas
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 6054 */     String num = "";
/*      */     
/*      */     fotoFirmas(String valor) {
/* 6057 */       this.t = new Thread(this);
/* 6058 */       this.num = valor;
/* 6059 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 6066 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosBuscar.this.DIRECTIVA[0] + "/Firmas/" + EmpleadosBuscar.this.DIRECTIVA[0] + ".png");
/*      */       
/* 6068 */       EmpleadosBuscar.this.FOTO = EmpleadosBuscar.this.DIRECTIVA[0] + "/Firmas/" + EmpleadosBuscar.this.DIRECTIVA[0] + ".png";
/* 6069 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(550, -1, 1));
/* 6070 */       ImageIcon temporal2 = new ImageIcon(tmpIcon.getImage().getScaledInstance(450, -1, 1));
/* 6071 */       EmpleadosBuscar.this.jLabel72.setText("");
/* 6072 */       EmpleadosBuscar.this.jLabel154.setText("");
/* 6073 */       if (temporal.getImageLoadStatus() == 4) {
/* 6074 */         EmpleadosBuscar.this.jLabel72.setText("Sin Firma");
/* 6075 */         EmpleadosBuscar.this.jLabel154.setText("Sin Firma");
/*      */       } else {
/* 6077 */         EmpleadosBuscar.this.jLabel72.setText("");
/* 6078 */         EmpleadosBuscar.this.jLabel154.setText("");
/* 6079 */         EmpleadosBuscar.this.jLabel72.setIcon(temporal);
/* 6080 */         EmpleadosBuscar.this.jLabel154.setIcon(temporal2);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class ImprimirDatos
/*      */     implements Printable
/*      */   {
/*      */     String[] DATOS;
/*      */     int opc;
/*      */     Graphics g2;
/*      */     
/*      */     public ImprimirDatos()
/*      */     {
/* 6095 */       this.DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 6096 */       this.opc = 0;
/* 6097 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { int ind; Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; ImageIcon tmpIcon; String c1, c2, valor; int inicia, lineas;
/*      */       String[] DES;
/*      */       int i, cont, l, j;
/* 6100 */       this.g2 = g;
/* 6101 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 6107 */           ind = EmpleadosBuscar.this.rSTableMetro1.getSelectedRow();
/* 6108 */           fuente = new Font("Dialog", 1, 7);
/* 6109 */           g.setFont(fuente);
/* 6110 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 425, 25);
/* 6111 */           fuente = new Font("Dialog", 0, 7);
/* 6112 */           g.setFont(fuente);
/* 6113 */           this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA, KM 32.5", 425, 35);
/* 6114 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN 67451", 425, 45);
/* 6115 */           this.g2.drawString("FMF901004UZ9", 425, 55);
/* 6116 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 6117 */           img = imagen.getImage();
/* 6118 */           this.g2.drawImage(img, 485, 52, 55, 55, null);
/* 6119 */           formato = new SimpleDateFormat("yyyyMMdd");
/*      */           
/* 6121 */           tmpIcon = new ImageIcon(EmpleadosBuscar.this.RUTA + "/" + EmpleadosBuscar.this.RUTA + ".png");
/* 6122 */           img = tmpIcon.getImage();
/* 6123 */           this.g2.drawImage(img, 20, 17, 68, 90, null);
/* 6124 */           this.g2.drawLine(415, 17, 415, 105);
/* 6125 */           fuente = new Font("Dialog", 1, 11);
/* 6126 */           this.g2.setFont(fuente);
/* 6127 */           this.g2.drawString("EMP-" + String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 0)) + ": " + String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 1)), 105, 25);
/*      */           
/* 6129 */           this.g2.setColor(Color.RED);
/* 6130 */           this.g2.drawRect(105, 30, 300, 60);
/* 6131 */           this.g2.setColor(new Color(204, 0, 0));
/* 6132 */           this.g2.fillRect(106, 31, 90, 58);
/*      */           
/* 6134 */           fuente = new Font("Dialog", 1, 9);
/* 6135 */           this.g2.setFont(fuente);
/* 6136 */           this.g2.setColor(Color.WHITE);
/* 6137 */           this.g2.drawString("TELÉFONO", 107, 42);
/* 6138 */           this.g2.drawString("NSS", 107, 56);
/* 6139 */           this.g2.drawString("CATEGORÍA", 107, 69);
/* 6140 */           this.g2.drawString("FECHA DE IMP", 107, 82);
/*      */           
/* 6142 */           fuente = new Font("Dialog", 0, 9);
/* 6143 */           this.g2.setFont(fuente);
/* 6144 */           this.g2.setColor(Color.BLACK);
/* 6145 */           this.g2.drawString(EmpleadosBuscar.this.jTextField14.getText(), 205, 42);
/* 6146 */           this.g2.drawString(EmpleadosBuscar.this.jTextField20.getText().toUpperCase(), 205, 56);
/* 6147 */           this.g2.drawString(EmpleadosBuscar.this.jTextField27.getText(), 205, 69);
/* 6148 */           this.g2.drawString(EmpleadosBuscar.this.cargarFechaHoy().substring(1, EmpleadosBuscar.this.cargarFechaHoy().length() - 3), 205, 82);
/*      */           
/* 6150 */           this.g2.setColor(new Color(56, 93, 138));
/* 6151 */           this.g2.drawRoundRect(16, 15, 76, 94, 10, 10);
/*      */           
/* 6153 */           this.g2.setColor(Color.RED);
/* 6154 */           this.g2.fill3DRect(15, 112, 580, 7, true);
/*      */           
/* 6156 */           this.g2.setColor(Color.RED);
/* 6157 */           this.g2.drawLine(125, 136, 125, 252);
/* 6158 */           this.g2.drawRect(15, 135, 285, 118);
/* 6159 */           this.g2.setColor(Color.GRAY);
/* 6160 */           this.g2.fillRect(16, 136, 18, 116);
/* 6161 */           fuente = new Font("Dialog", 1, 5);
/* 6162 */           this.g2.setFont(fuente);
/* 6163 */           this.g2.setColor(Color.WHITE);
/* 6164 */           this.g2.drawString("D", 19, 183);
/* 6165 */           this.g2.drawString("A", 19, 190);
/* 6166 */           this.g2.drawString("T", 19, 197);
/* 6167 */           this.g2.drawString("O", 19, 204);
/* 6168 */           this.g2.drawString("S", 19, 209);
/*      */           
/* 6170 */           this.g2.drawString("P", 26, 164);
/* 6171 */           this.g2.drawString("E", 26, 169);
/* 6172 */           this.g2.drawString("R", 26, 178);
/* 6173 */           this.g2.drawString("S", 26, 185);
/* 6174 */           this.g2.drawString("O", 26, 192);
/* 6175 */           this.g2.drawString("N", 26, 199);
/* 6176 */           this.g2.drawString("A", 26, 206);
/* 6177 */           this.g2.drawString("L", 26, 213);
/* 6178 */           this.g2.drawString("E", 26, 220);
/* 6179 */           this.g2.drawString("S", 26, 227);
/*      */           
/* 6181 */           fuente = new Font("Dialog", 1, 7);
/* 6182 */           this.g2.setFont(fuente);
/* 6183 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6185 */           this.g2.drawString("FECHA DE NAC", 37, 145);
/* 6186 */           this.g2.drawString("LUGAR DE NACIMIENTO", 37, 158);
/* 6187 */           this.g2.drawString("NÚM DE SEG SOCIAL", 37, 171);
/* 6188 */           this.g2.drawString("CURP", 37, 184);
/*      */           
/* 6190 */           this.g2.drawString("CARGO AUTOM NEXTEL", 37, 197);
/* 6191 */           this.g2.drawString("NEXTEL", 37, 210);
/* 6192 */           this.g2.drawString("CARGO", 200, 210);
/* 6193 */           this.g2.drawString("CARGO AUTOM INFON", 37, 223);
/* 6194 */           this.g2.drawString("INFONAVIT", 37, 236);
/* 6195 */           this.g2.drawString("CARGO", 200, 236);
/* 6196 */           this.g2.drawString("TIPO", 37, 249);
/*      */           
/* 6198 */           fuente = new Font("Dialog", 0, 8);
/* 6199 */           this.g2.setFont(fuente);
/*      */           
/* 6201 */           c1 = "NO";
/* 6202 */           c2 = "NO";
/*      */           
/* 6204 */           this.g2.drawString(EmpleadosBuscar.this.jTextField16.getText(), 130, 145);
/* 6205 */           this.g2.drawString(EmpleadosBuscar.this.jTextField25.getText().toUpperCase(), 130, 158);
/* 6206 */           this.g2.drawString(EmpleadosBuscar.this.jTextField20.getText().toUpperCase(), 130, 171);
/* 6207 */           this.g2.drawString(EmpleadosBuscar.this.jTextField21.getText().toUpperCase(), 130, 184);
/* 6208 */           this.g2.drawString(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 7).toString().toUpperCase(), 130, 197);
/* 6209 */           this.g2.drawString(EmpleadosBuscar.this.jTextField19.getText().toUpperCase(), 130, 210);
/* 6210 */           this.g2.drawString(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 6).toString(), 233, 210);
/* 6211 */           this.g2.drawString(EmpleadosBuscar.this.jTextField30.getText().toUpperCase(), 130, 223);
/* 6212 */           this.g2.drawString(EmpleadosBuscar.this.jTextField22.getText().toUpperCase(), 130, 236);
/* 6213 */           this.g2.drawString(EmpleadosBuscar.this.jTextField23.getText(), 233, 236);
/* 6214 */           this.g2.drawString(EmpleadosBuscar.this.jTextField41.getText(), 130, 249);
/* 6215 */           this.g2.setColor(Color.RED);
/* 6216 */           this.g2.drawLine(125, 136, 125, 239);
/*      */           
/* 6218 */           this.g2.setColor(Color.WHITE);
/* 6219 */           this.g2.fillRect(301, 130, 80, 190);
/*      */           
/* 6221 */           this.g2.setColor(Color.RED);
/* 6222 */           this.g2.drawRect(310, 135, 285, 80);
/* 6223 */           this.g2.setColor(Color.GRAY);
/* 6224 */           this.g2.fillRect(311, 136, 18, 78);
/* 6225 */           this.g2.setColor(Color.WHITE);
/* 6226 */           this.g2.fillRect(329, 136, 85, 78);
/* 6227 */           this.g2.fillRect(414, 136, 180, 78);
/* 6228 */           fuente = new Font("Dialog", 1, 5);
/* 6229 */           this.g2.setFont(fuente);
/* 6230 */           this.g2.setColor(Color.WHITE);
/* 6231 */           this.g2.drawString("D", 318, 144);
/* 6232 */           this.g2.drawString("O", 318, 152);
/* 6233 */           this.g2.drawString("M", 318, 160);
/* 6234 */           this.g2.drawString("I", 318, 168);
/* 6235 */           this.g2.drawString("C", 318, 176);
/* 6236 */           this.g2.drawString("I", 318, 184);
/* 6237 */           this.g2.drawString("L", 318, 192);
/* 6238 */           this.g2.drawString("I", 318, 200);
/* 6239 */           this.g2.drawString("O", 318, 208);
/*      */           
/* 6241 */           fuente = new Font("Dialog", 1, 7);
/* 6242 */           this.g2.setFont(fuente);
/* 6243 */           this.g2.setColor(Color.BLACK);
/* 6244 */           this.g2.drawString("CALLE", 332, 145);
/* 6245 */           this.g2.drawString("NÚMERO", 332, 158);
/* 6246 */           this.g2.drawString("COLONIA", 332, 171);
/* 6247 */           this.g2.drawString("CIUDAD", 332, 184);
/* 6248 */           this.g2.drawString("CÓDIGO POSTAL", 332, 197);
/* 6249 */           this.g2.drawString("ESTADO", 332, 210);
/*      */           
/* 6251 */           fuente = new Font("Dialog", 0, 8);
/* 6252 */           this.g2.setFont(fuente);
/* 6253 */           this.g2.setColor(Color.BLACK);
/* 6254 */           this.g2.drawString(EmpleadosBuscar.this.jTextField9.getText().toUpperCase(), 425, 145);
/* 6255 */           this.g2.drawString(EmpleadosBuscar.this.jTextField10.getText().toUpperCase(), 425, 158);
/* 6256 */           this.g2.drawString(EmpleadosBuscar.this.jTextField11.getText().toUpperCase(), 425, 171);
/* 6257 */           this.g2.drawString(EmpleadosBuscar.this.jTextField13.getText().toUpperCase(), 425, 184);
/* 6258 */           this.g2.drawString(EmpleadosBuscar.this.jTextField12.getText().toUpperCase(), 425, 197);
/* 6259 */           this.g2.drawString(EmpleadosBuscar.this.jTextField45.getText(), 425, 210);
/* 6260 */           this.g2.setColor(Color.RED);
/* 6261 */           this.g2.drawLine(420, 136, 420, 215);
/*      */           
/* 6263 */           this.g2.setColor(Color.RED);
/* 6264 */           this.g2.drawRect(310, 225, 285, 132);
/* 6265 */           this.g2.setColor(Color.GRAY);
/* 6266 */           this.g2.fillRect(311, 226, 18, 130);
/* 6267 */           this.g2.setColor(Color.WHITE);
/* 6268 */           this.g2.fillRect(329, 226, 85, 130);
/* 6269 */           this.g2.fillRect(414, 226, 180, 130);
/* 6270 */           fuente = new Font("Dialog", 1, 5);
/* 6271 */           this.g2.setFont(fuente);
/* 6272 */           this.g2.drawString("D", 314, 260);
/* 6273 */           this.g2.drawString("A", 314, 268);
/* 6274 */           this.g2.drawString("T", 314, 276);
/* 6275 */           this.g2.drawString("O", 314, 284);
/* 6276 */           this.g2.drawString("S", 314, 292);
/*      */           
/* 6278 */           this.g2.drawString("D", 314, 308);
/* 6279 */           this.g2.drawString("E", 314, 316);
/* 6280 */           this.g2.drawString("L", 314, 324);
/*      */           
/* 6282 */           this.g2.drawString("C", 321, 262);
/* 6283 */           this.g2.drawString("O", 321, 270);
/* 6284 */           this.g2.drawString("N", 321, 278);
/* 6285 */           this.g2.drawString("T", 321, 289);
/* 6286 */           this.g2.drawString("R", 321, 297);
/* 6287 */           this.g2.drawString("A", 321, 305);
/* 6288 */           this.g2.drawString("T", 321, 313);
/* 6289 */           this.g2.drawString("O", 321, 321);
/*      */           
/* 6291 */           fuente = new Font("Dialog", 1, 7);
/* 6292 */           this.g2.setFont(fuente);
/* 6293 */           this.g2.setColor(Color.BLACK);
/* 6294 */           this.g2.drawString("FECHA DE INGRESO", 332, 235);
/* 6295 */           this.g2.drawString("DÍAS DEL CONTRATO", 332, 248);
/* 6296 */           this.g2.drawString("DISTINTIVO", 332, 261);
/* 6297 */           this.g2.drawString("CONTRATADO POR", 332, 274);
/* 6298 */           this.g2.drawString("TESTIGO 1", 332, 287);
/* 6299 */           this.g2.drawString("TESTIGO 2", 332, 300);
/* 6300 */           this.g2.drawString("RECOMENDADO POR", 332, 313);
/* 6301 */           this.g2.drawString("SALARIO NOMINAL", 332, 326);
/* 6302 */           this.g2.drawString("SALARIO REAL", 332, 339);
/*      */           
/* 6304 */           this.g2.drawString("ÚLTIMO INGRESO", 332, 352);
/*      */           
/* 6306 */           fuente = new Font("Dialog", 0, 8);
/* 6307 */           this.g2.setFont(fuente);
/* 6308 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6310 */           this.g2.drawString(EmpleadosBuscar.this.jTextField24.getText(), 425, 235);
/* 6311 */           this.g2.drawString(EmpleadosBuscar.this.jTextField40.getText().toUpperCase(), 425, 248);
/* 6312 */           this.g2.drawString(EmpleadosBuscar.this.jTextField39.getText(), 425, 261);
/* 6313 */           this.g2.drawString(EmpleadosBuscar.this.jTextField33.getText().toUpperCase(), 425, 274);
/* 6314 */           this.g2.drawString(EmpleadosBuscar.this.jTextField34.getText().toUpperCase(), 425, 287);
/* 6315 */           this.g2.drawString(EmpleadosBuscar.this.jTextField35.getText().toUpperCase(), 425, 300);
/* 6316 */           this.g2.drawString(EmpleadosBuscar.this.jTextField36.getText().toUpperCase(), 425, 313);
/* 6317 */           this.g2.drawString(EmpleadosBuscar.this.jTextField37.getText(), 425, 326);
/* 6318 */           this.g2.drawString(EmpleadosBuscar.this.jTextField38.getText(), 425, 339);
/* 6319 */           this.g2.drawString(EmpleadosBuscar.this.jTextField42.getText(), 425, 352);
/* 6320 */           this.g2.setColor(Color.RED);
/* 6321 */           this.g2.drawLine(420, 225, 420, 357);
/*      */ 
/*      */           
/* 6324 */           this.g2.setColor(Color.RED);
/* 6325 */           this.g2.drawRect(15, 288, 285, 69);
/* 6326 */           this.g2.setColor(Color.GRAY);
/* 6327 */           this.g2.fillRect(16, 289, 18, 67);
/* 6328 */           this.g2.setColor(Color.WHITE);
/* 6329 */           this.g2.fillRect(34, 289, 85, 67);
/* 6330 */           this.g2.fillRect(119, 289, 180, 67);
/* 6331 */           fuente = new Font("Dialog", 1, 5);
/* 6332 */           this.g2.setFont(fuente);
/* 6333 */           this.g2.setColor(Color.WHITE);
/* 6334 */           this.g2.drawString("O", 19, 311);
/* 6335 */           this.g2.drawString("T", 19, 318);
/* 6336 */           this.g2.drawString("R", 19, 325);
/* 6337 */           this.g2.drawString("O", 19, 332);
/* 6338 */           this.g2.drawString("S", 19, 339);
/*      */           
/* 6340 */           this.g2.drawString("D", 26, 311);
/* 6341 */           this.g2.drawString("A", 26, 318);
/* 6342 */           this.g2.drawString("T", 26, 325);
/* 6343 */           this.g2.drawString("O", 26, 332);
/* 6344 */           this.g2.drawString("S", 26, 339);
/*      */           
/* 6346 */           fuente = new Font("Dialog", 1, 7);
/* 6347 */           this.g2.setFont(fuente);
/* 6348 */           this.g2.setColor(Color.BLACK);
/* 6349 */           this.g2.drawString("NÚMERO DE HIJOS", 37, 298);
/* 6350 */           this.g2.drawString("ESTADO CIVIL", 37, 311);
/* 6351 */           this.g2.drawString("TELÉFONO", 37, 324);
/* 6352 */           this.g2.drawString("CELULAR", 37, 337);
/* 6353 */           this.g2.drawString("CORREO", 37, 351);
/*      */           
/* 6355 */           fuente = new Font("Dialog", 0, 8);
/* 6356 */           this.g2.setFont(fuente);
/* 6357 */           this.g2.setColor(Color.BLACK);
/* 6358 */           this.g2.drawString(EmpleadosBuscar.this.jTextField32.getText(), 130, 298);
/* 6359 */           this.g2.drawString(EmpleadosBuscar.this.jTextField31.getText(), 130, 311);
/* 6360 */           this.g2.drawString(EmpleadosBuscar.this.jTextField14.getText(), 130, 324);
/* 6361 */           this.g2.drawString(EmpleadosBuscar.this.jTextField15.getText(), 130, 337);
/* 6362 */           this.g2.drawString(EmpleadosBuscar.this.jTextField17.getText().toUpperCase(), 130, 351);
/* 6363 */           this.g2.setColor(Color.RED);
/* 6364 */           this.g2.drawLine(125, 288, 125, 357);
/*      */ 
/*      */           
/* 6367 */           this.g2.setColor(Color.RED);
/* 6368 */           this.g2.drawRect(15, 367, 580, 140);
/* 6369 */           this.g2.setColor(Color.GRAY);
/* 6370 */           this.g2.fillRect(16, 368, 18, 138);
/* 6371 */           this.g2.setColor(Color.WHITE);
/* 6372 */           this.g2.fillRect(34, 368, 560, 138);
/*      */           
/* 6374 */           fuente = new Font("Dialog", 1, 5);
/* 6375 */           this.g2.setFont(fuente);
/* 6376 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 6378 */           this.g2.drawString("A", 19, 417);
/* 6379 */           this.g2.drawString("L", 19, 424);
/* 6380 */           this.g2.drawString("G", 19, 431);
/* 6381 */           this.g2.drawString("U", 19, 438);
/* 6382 */           this.g2.drawString("N", 19, 445);
/* 6383 */           this.g2.drawString("A", 19, 452);
/* 6384 */           this.g2.drawString("S", 19, 459);
/*      */           
/* 6386 */           this.g2.drawString("R", 26, 403);
/* 6387 */           this.g2.drawString("E", 26, 410);
/* 6388 */           this.g2.drawString("F", 26, 417);
/* 6389 */           this.g2.drawString("E", 26, 424);
/* 6390 */           this.g2.drawString("R", 26, 431);
/* 6391 */           this.g2.drawString("E", 26, 438);
/* 6392 */           this.g2.drawString("N", 26, 445);
/* 6393 */           this.g2.drawString("C", 26, 452);
/* 6394 */           this.g2.drawString("I", 26, 459);
/* 6395 */           this.g2.drawString("A", 26, 466);
/* 6396 */           this.g2.drawString("S", 26, 473);
/*      */ 
/*      */           
/* 6399 */           fuente = new Font("Dialog", 0, 7);
/* 6400 */           this.g2.setFont(fuente);
/* 6401 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6403 */           valor = EmpleadosBuscar.this.jTextArea1.getText().toUpperCase();
/*      */           
/* 6405 */           inicia = 377;
/* 6406 */           lineas = valor.length() / 150;
/* 6407 */           lineas += 2;
/* 6408 */           DES = new String[lineas];
/* 6409 */           for (i = 0; i < DES.length; i++) {
/* 6410 */             DES[i] = new String("");
/*      */           }
/* 6412 */           cont = 0;
/* 6413 */           l = 0;
/* 6414 */           for (j = 0; j < valor.length(); j++) {
/* 6415 */             if (cont <= 150) {
/* 6416 */               DES[l] = DES[l] + DES[l];
/* 6417 */               cont++;
/*      */             } else {
/* 6419 */               DES[l] = DES[l] + DES[l];
/* 6420 */               cont = 0;
/* 6421 */               l++;
/*      */             } 
/*      */           } 
/* 6424 */           for (j = 0; j < DES.length; j++) {
/* 6425 */             g.drawString(DES[j], 37, inicia);
/* 6426 */             inicia += 8;
/*      */           } 
/*      */           
/* 6429 */           this.g2.drawString("_________________________________________", 15, 565);
/* 6430 */           this.g2.drawString(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 1).toString(), 15, 575);
/* 6431 */           this.g2.drawString("EMPLEADO", 15, 585);
/*      */ 
/*      */           
/* 6434 */           this.g2.drawString("_________________________________________", 15, 645);
/* 6435 */           this.g2.drawString(this.DATOS[0] + " " + this.DATOS[0] + " " + this.DATOS[1], 15, 655);
/* 6436 */           this.g2.drawString("EMPRESA", 15, 665);
/*      */           
/* 6438 */           this.g2.setColor(Color.RED);
/* 6439 */           this.g2.drawRect(310, 517, 285, 150);
/* 6440 */           this.g2.setColor(Color.GRAY);
/* 6441 */           this.g2.fillRect(311, 518, 18, 148);
/* 6442 */           this.g2.setColor(Color.WHITE);
/* 6443 */           this.g2.fillRect(329, 517, 85, 148);
/* 6444 */           this.g2.fillRect(414, 517, 180, 148);
/*      */           
/* 6446 */           this.g2.setColor(Color.RED);
/* 6447 */           this.g2.drawLine(310, 592, 595, 592);
/*      */           
/* 6449 */           fuente = new Font("Dialog", 1, 7);
/* 6450 */           this.g2.setFont(fuente);
/* 6451 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 6453 */           this.g2.drawString("A", 318, 539);
/* 6454 */           this.g2.drawString("L", 318, 552);
/* 6455 */           this.g2.drawString("T", 318, 565);
/* 6456 */           this.g2.drawString("A", 318, 578);
/*      */           
/* 6458 */           this.g2.drawString("B", 318, 612);
/* 6459 */           this.g2.drawString("A", 318, 625);
/* 6460 */           this.g2.drawString("J", 318, 638);
/* 6461 */           this.g2.drawString("A", 318, 651);
/*      */           
/* 6463 */           fuente = new Font("Dialog", 1, 7);
/* 6464 */           this.g2.setFont(fuente);
/* 6465 */           this.g2.setColor(Color.BLACK);
/* 6466 */           this.g2.drawString("_____________________________________", 390, 567);
/* 6467 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 580);
/*      */           
/* 6469 */           this.g2.drawString("_____________________________________", 390, 640);
/* 6470 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 653);
/*      */           
/* 6472 */           this.g2.setColor(new Color(56, 93, 138));
/* 6473 */           this.g2.drawRect(15, 730, 580, 40);
/* 6474 */           fuente = new Font("Dialog", 1, 6);
/* 6475 */           this.g2.setFont(fuente);
/* 6476 */           this.g2.setColor(Color.BLACK);
/* 6477 */           this.g2.drawString("          EN COMPLETO USO DE MIS FACULTADES DECLARO BAJO PROTESTA DECIR VERDAD QUE LA INFORMACIÓN PROPORCIONADA EN EL PRESENTE ES CORRECTA Y ESTOY CONFORME", 17, 747);
/* 6478 */           this.g2.drawString("                                                                     CON LAS POLÍTICAS DE LA EMPRESA. QUEDANDO A SUS ÓRDENES DESDE EL PRIMER DÍA DEL CONTRATO", 26, 759);
/*      */           
/* 6480 */           return 0;
/*      */       } 
/* 6482 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6487 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6488 */       job.setPrintable(this);
/*      */       
/* 6490 */       PageFormat pf = job.defaultPage();
/* 6491 */       Paper papel = pf.getPaper();
/* 6492 */       papel.setSize(612.0D, 792.0D);
/* 6493 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6494 */       pf.setPaper(papel);
/* 6495 */       pf.setOrientation(1);
/* 6496 */       job.setPrintable(new ImprimirDatos(), pf);
/* 6497 */       job.defaultPage(pf);
/*      */       
/* 6499 */       boolean ok = job.printDialog();
/* 6500 */       if (ok) {
/*      */         try {
/* 6502 */           job.print();
/* 6503 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class CrearPDF
/*      */   {
/* 6512 */     int w = 0; int h = 0;
/*      */     int[] pageBreaks;
/*      */     String[] textLines;
/* 6515 */     Graphics g2 = null;
/* 6516 */     int Pag = 0;
/*      */     String[] Lineas;
/* 6518 */     int linesPerPage = 0;
/* 6519 */     int orientacion = 0;
/* 6520 */     double X = 0.0D;
/* 6521 */     double Y = 0.0D;
/* 6522 */     int pageIndex = 0;
/*      */ 
/*      */     
/*      */     public CrearPDF() {
/* 6526 */       if (this.textLines == null) {
/* 6527 */         int numLines = EmpleadosBuscar.this.rSTableMetro1.getRowCount();
/* 6528 */         this.textLines = new String[numLines];
/* 6529 */         this.X = (this.w = 612);
/* 6530 */         this.Y = (this.h = 792);
/*      */       } 
/* 6532 */       this.linesPerPage = 90;
/* 6533 */       int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 6534 */       this.Pag = numBreaks;
/* 6535 */       this.pageBreaks = new int[numBreaks];
/* 6536 */       for (int b = 0; b < numBreaks; b++) {
/* 6537 */         this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 6549 */       createPdf();
/*      */     }
/*      */     
/*      */     public void createPdf() {
/* 6553 */       Document document = new Document(new Rectangle(this.w, this.h));
/*      */       try {
/* 6555 */         EmpleadosBuscar.this.nombreArchivo = "Reporte de empleado.pdf";
/* 6556 */         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Archivos/" + EmpleadosBuscar.this.nombreArchivo));
/* 6557 */         document.open();
/* 6558 */         PdfContentByte cb = writer.getDirectContent();
/* 6559 */         Graphics2D g2 = cb.createGraphics(this.w, this.h);
/*      */         
/* 6561 */         this.g2 = g2;
/* 6562 */         for (int i = 0; i <= this.pageBreaks.length; i++) {
/* 6563 */           this.pageIndex = i;
/* 6564 */           paint(g2);
/* 6565 */           g2.dispose();
/* 6566 */           document.newPage();
/*      */         } 
/* 6568 */       } catch (DocumentException de) {
/* 6569 */         System.err.println(de.getMessage());
/* 6570 */       } catch (IOException ioe) {
/* 6571 */         System.err.println(ioe.getMessage());
/*      */       } 
/* 6573 */       document.close();
/*      */     }
/*      */     
/*      */     public void paint(Graphics g) {
/* 6577 */       Graphics2D g2d = (Graphics2D)g;
/* 6578 */       int start = (this.pageIndex == 0) ? 0 : this.pageBreaks[this.pageIndex - 1];
/* 6579 */       int end = (this.pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[this.pageIndex];
/* 6580 */       this.g2 = g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 6585 */       int ind = EmpleadosBuscar.this.rSTableMetro1.getSelectedRow();
/* 6586 */       Font fuente = new Font("Dialog", 1, 7);
/* 6587 */       g.setFont(fuente);
/* 6588 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 425, 25);
/* 6589 */       fuente = new Font("Dialog", 0, 7);
/* 6590 */       g.setFont(fuente);
/* 6591 */       this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA, KM 32.5", 425, 35);
/* 6592 */       this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN 67451", 425, 45);
/* 6593 */       this.g2.drawString("FMF901004UZ9", 425, 55);
/* 6594 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 6595 */       Image img = imagen.getImage();
/* 6596 */       this.g2.drawImage(img, 485, 52, 55, 55, null);
/* 6597 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*      */       
/* 6599 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosBuscar.this.RUTA + "/" + EmpleadosBuscar.this.RUTA + ".png");
/* 6600 */       boolean aux = false;
/* 6601 */       if (tmpIcon.getIconWidth() == -1) {
/* 6602 */         tmpIcon = new ImageIcon(getClass().getResource("/entrada/Imagenes/sinFoto.png"));
/* 6603 */         aux = true;
/*      */       } 
/* 6605 */       img = tmpIcon.getImage();
/* 6606 */       if (aux) {
/* 6607 */         this.g2.drawImage(img, 20, 25, 68, 68, null);
/*      */       } else {
/* 6609 */         this.g2.drawImage(img, 20, 17, 68, 90, null);
/*      */       } 
/*      */       
/* 6612 */       this.g2.drawLine(415, 17, 415, 105);
/* 6613 */       fuente = new Font("Dialog", 1, 11);
/* 6614 */       this.g2.setFont(fuente);
/* 6615 */       this.g2.drawString("EMP-" + String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 0)) + ": " + String.valueOf(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 1)), 105, 25);
/*      */       
/* 6617 */       this.g2.setColor(Color.RED);
/* 6618 */       this.g2.drawRect(105, 30, 300, 60);
/* 6619 */       this.g2.setColor(new Color(204, 0, 0));
/* 6620 */       this.g2.fillRect(106, 31, 90, 58);
/*      */       
/* 6622 */       fuente = new Font("Dialog", 1, 9);
/* 6623 */       this.g2.setFont(fuente);
/* 6624 */       this.g2.setColor(Color.WHITE);
/* 6625 */       this.g2.drawString("TELÉFONO", 107, 42);
/* 6626 */       this.g2.drawString("NSS", 107, 56);
/* 6627 */       this.g2.drawString("CATEGORÍA", 107, 69);
/* 6628 */       this.g2.drawString("FECHA DE IMP", 107, 82);
/*      */       
/* 6630 */       fuente = new Font("Dialog", 0, 9);
/* 6631 */       this.g2.setFont(fuente);
/* 6632 */       this.g2.setColor(Color.BLACK);
/* 6633 */       this.g2.drawString(EmpleadosBuscar.this.jTextField14.getText(), 205, 42);
/* 6634 */       this.g2.drawString(EmpleadosBuscar.this.jTextField20.getText().toUpperCase(), 205, 56);
/* 6635 */       this.g2.drawString(EmpleadosBuscar.this.jTextField27.getText(), 205, 69);
/* 6636 */       this.g2.drawString(EmpleadosBuscar.this.cargarFechaHoy().substring(1, EmpleadosBuscar.this.cargarFechaHoy().length() - 3), 205, 82);
/*      */       
/* 6638 */       this.g2.setColor(new Color(56, 93, 138));
/* 6639 */       this.g2.drawRoundRect(16, 15, 76, 94, 10, 10);
/*      */       
/* 6641 */       this.g2.setColor(Color.RED);
/* 6642 */       this.g2.fill3DRect(15, 112, 580, 7, true);
/*      */       
/* 6644 */       this.g2.setColor(Color.RED);
/* 6645 */       this.g2.drawLine(125, 136, 125, 252);
/* 6646 */       this.g2.drawRect(15, 135, 285, 118);
/* 6647 */       this.g2.setColor(Color.GRAY);
/* 6648 */       this.g2.fillRect(16, 136, 18, 116);
/* 6649 */       fuente = new Font("Dialog", 1, 5);
/* 6650 */       this.g2.setFont(fuente);
/* 6651 */       this.g2.setColor(Color.WHITE);
/* 6652 */       this.g2.drawString("D", 19, 183);
/* 6653 */       this.g2.drawString("A", 19, 190);
/* 6654 */       this.g2.drawString("T", 19, 197);
/* 6655 */       this.g2.drawString("O", 19, 204);
/* 6656 */       this.g2.drawString("S", 19, 209);
/*      */       
/* 6658 */       this.g2.drawString("P", 26, 164);
/* 6659 */       this.g2.drawString("E", 26, 169);
/* 6660 */       this.g2.drawString("R", 26, 178);
/* 6661 */       this.g2.drawString("S", 26, 185);
/* 6662 */       this.g2.drawString("O", 26, 192);
/* 6663 */       this.g2.drawString("N", 26, 199);
/* 6664 */       this.g2.drawString("A", 26, 206);
/* 6665 */       this.g2.drawString("L", 26, 213);
/* 6666 */       this.g2.drawString("E", 26, 220);
/* 6667 */       this.g2.drawString("S", 26, 227);
/*      */       
/* 6669 */       fuente = new Font("Dialog", 1, 7);
/* 6670 */       this.g2.setFont(fuente);
/* 6671 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 6673 */       this.g2.drawString("FECHA DE NAC", 37, 145);
/* 6674 */       this.g2.drawString("LUGAR DE NACIMIENTO", 37, 158);
/* 6675 */       this.g2.drawString("NÚM DE SEG SOCIAL", 37, 171);
/* 6676 */       this.g2.drawString("CURP", 37, 184);
/*      */       
/* 6678 */       this.g2.drawString("CARGO AUTOM NEXTEL", 37, 197);
/* 6679 */       this.g2.drawString("NEXTEL", 37, 210);
/* 6680 */       this.g2.drawString("CARGO", 200, 210);
/* 6681 */       this.g2.drawString("CARGO AUTOM INFON", 37, 223);
/* 6682 */       this.g2.drawString("INFONAVIT", 37, 236);
/* 6683 */       this.g2.drawString("CARGO", 200, 236);
/* 6684 */       this.g2.drawString("TIPO", 37, 249);
/*      */       
/* 6686 */       fuente = new Font("Dialog", 0, 8);
/* 6687 */       this.g2.setFont(fuente);
/*      */       
/* 6689 */       String c1 = "NO";
/* 6690 */       String c2 = "NO";
/*      */       
/* 6692 */       this.g2.drawString(EmpleadosBuscar.this.jTextField16.getText(), 130, 145);
/* 6693 */       this.g2.drawString(EmpleadosBuscar.this.jTextField25.getText().toUpperCase(), 130, 158);
/* 6694 */       this.g2.drawString(EmpleadosBuscar.this.jTextField20.getText().toUpperCase(), 130, 171);
/* 6695 */       this.g2.drawString(EmpleadosBuscar.this.jTextField21.getText().toUpperCase(), 130, 184);
/* 6696 */       this.g2.drawString(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 7).toString().toUpperCase(), 130, 197);
/* 6697 */       this.g2.drawString(EmpleadosBuscar.this.jTextField19.getText().toUpperCase(), 130, 210);
/* 6698 */       this.g2.drawString(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 6).toString(), 233, 210);
/* 6699 */       this.g2.drawString(EmpleadosBuscar.this.jTextField30.getText().toUpperCase(), 130, 223);
/* 6700 */       this.g2.drawString(EmpleadosBuscar.this.jTextField22.getText().toUpperCase(), 130, 236);
/* 6701 */       this.g2.drawString(EmpleadosBuscar.this.jTextField23.getText(), 233, 236);
/* 6702 */       this.g2.drawString(EmpleadosBuscar.this.jTextField41.getText(), 130, 249);
/* 6703 */       this.g2.setColor(Color.RED);
/* 6704 */       this.g2.drawLine(125, 136, 125, 239);
/*      */       
/* 6706 */       this.g2.setColor(Color.WHITE);
/* 6707 */       this.g2.fillRect(301, 130, 80, 190);
/*      */       
/* 6709 */       this.g2.setColor(Color.RED);
/* 6710 */       this.g2.drawRect(310, 135, 285, 80);
/* 6711 */       this.g2.setColor(Color.GRAY);
/* 6712 */       this.g2.fillRect(311, 136, 18, 78);
/* 6713 */       this.g2.setColor(Color.WHITE);
/* 6714 */       this.g2.fillRect(329, 136, 85, 78);
/* 6715 */       this.g2.fillRect(414, 136, 180, 78);
/* 6716 */       fuente = new Font("Dialog", 1, 5);
/* 6717 */       this.g2.setFont(fuente);
/* 6718 */       this.g2.setColor(Color.WHITE);
/* 6719 */       this.g2.drawString("D", 318, 144);
/* 6720 */       this.g2.drawString("O", 318, 152);
/* 6721 */       this.g2.drawString("M", 318, 160);
/* 6722 */       this.g2.drawString("I", 318, 168);
/* 6723 */       this.g2.drawString("C", 318, 176);
/* 6724 */       this.g2.drawString("I", 318, 184);
/* 6725 */       this.g2.drawString("L", 318, 192);
/* 6726 */       this.g2.drawString("I", 318, 200);
/* 6727 */       this.g2.drawString("O", 318, 208);
/*      */       
/* 6729 */       fuente = new Font("Dialog", 1, 7);
/* 6730 */       this.g2.setFont(fuente);
/* 6731 */       this.g2.setColor(Color.BLACK);
/* 6732 */       this.g2.drawString("CALLE", 332, 145);
/* 6733 */       this.g2.drawString("NÚMERO", 332, 158);
/* 6734 */       this.g2.drawString("COLONIA", 332, 171);
/* 6735 */       this.g2.drawString("CIUDAD", 332, 184);
/* 6736 */       this.g2.drawString("CÓDIGO POSTAL", 332, 197);
/* 6737 */       this.g2.drawString("ESTADO", 332, 210);
/*      */       
/* 6739 */       fuente = new Font("Dialog", 0, 8);
/* 6740 */       this.g2.setFont(fuente);
/* 6741 */       this.g2.setColor(Color.BLACK);
/* 6742 */       this.g2.drawString(EmpleadosBuscar.this.jTextField9.getText().toUpperCase(), 425, 145);
/* 6743 */       this.g2.drawString(EmpleadosBuscar.this.jTextField10.getText().toUpperCase(), 425, 158);
/* 6744 */       this.g2.drawString(EmpleadosBuscar.this.jTextField11.getText().toUpperCase(), 425, 171);
/* 6745 */       this.g2.drawString(EmpleadosBuscar.this.jTextField13.getText().toUpperCase(), 425, 184);
/* 6746 */       this.g2.drawString(EmpleadosBuscar.this.jTextField12.getText().toUpperCase(), 425, 197);
/* 6747 */       this.g2.drawString(EmpleadosBuscar.this.jTextField45.getText(), 425, 210);
/* 6748 */       this.g2.setColor(Color.RED);
/* 6749 */       this.g2.drawLine(420, 136, 420, 215);
/*      */       
/* 6751 */       this.g2.setColor(Color.RED);
/* 6752 */       this.g2.drawRect(310, 225, 285, 132);
/* 6753 */       this.g2.setColor(Color.GRAY);
/* 6754 */       this.g2.fillRect(311, 226, 18, 130);
/* 6755 */       this.g2.setColor(Color.WHITE);
/* 6756 */       this.g2.fillRect(329, 226, 85, 130);
/* 6757 */       this.g2.fillRect(414, 226, 180, 130);
/* 6758 */       fuente = new Font("Dialog", 1, 5);
/* 6759 */       this.g2.setFont(fuente);
/* 6760 */       this.g2.drawString("D", 314, 260);
/* 6761 */       this.g2.drawString("A", 314, 268);
/* 6762 */       this.g2.drawString("T", 314, 276);
/* 6763 */       this.g2.drawString("O", 314, 284);
/* 6764 */       this.g2.drawString("S", 314, 292);
/*      */       
/* 6766 */       this.g2.drawString("D", 314, 308);
/* 6767 */       this.g2.drawString("E", 314, 316);
/* 6768 */       this.g2.drawString("L", 314, 324);
/*      */       
/* 6770 */       this.g2.drawString("C", 321, 262);
/* 6771 */       this.g2.drawString("O", 321, 270);
/* 6772 */       this.g2.drawString("N", 321, 278);
/* 6773 */       this.g2.drawString("T", 321, 289);
/* 6774 */       this.g2.drawString("R", 321, 297);
/* 6775 */       this.g2.drawString("A", 321, 305);
/* 6776 */       this.g2.drawString("T", 321, 313);
/* 6777 */       this.g2.drawString("O", 321, 321);
/*      */       
/* 6779 */       fuente = new Font("Dialog", 1, 7);
/* 6780 */       this.g2.setFont(fuente);
/* 6781 */       this.g2.setColor(Color.BLACK);
/* 6782 */       this.g2.drawString("FECHA DE INGRESO", 332, 235);
/* 6783 */       this.g2.drawString("DÍAS DEL CONTRATO", 332, 248);
/* 6784 */       this.g2.drawString("DISTINTIVO", 332, 261);
/* 6785 */       this.g2.drawString("CONTRATADO POR", 332, 274);
/* 6786 */       this.g2.drawString("TESTIGO 1", 332, 287);
/* 6787 */       this.g2.drawString("TESTIGO 2", 332, 300);
/* 6788 */       this.g2.drawString("RECOMENDADO POR", 332, 313);
/* 6789 */       this.g2.drawString("SALARIO NOMINAL", 332, 326);
/* 6790 */       this.g2.drawString("SALARIO REAL", 332, 339);
/*      */       
/* 6792 */       this.g2.drawString("ÚLTIMO INGRESO", 332, 352);
/*      */       
/* 6794 */       fuente = new Font("Dialog", 0, 8);
/* 6795 */       this.g2.setFont(fuente);
/* 6796 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 6798 */       this.g2.drawString(EmpleadosBuscar.this.jTextField24.getText(), 425, 235);
/* 6799 */       this.g2.drawString(EmpleadosBuscar.this.jTextField40.getText().toUpperCase(), 425, 248);
/* 6800 */       this.g2.drawString(EmpleadosBuscar.this.jTextField39.getText(), 425, 261);
/* 6801 */       this.g2.drawString(EmpleadosBuscar.this.jTextField33.getText().toUpperCase(), 425, 274);
/* 6802 */       this.g2.drawString(EmpleadosBuscar.this.jTextField34.getText().toUpperCase(), 425, 287);
/* 6803 */       this.g2.drawString(EmpleadosBuscar.this.jTextField35.getText().toUpperCase(), 425, 300);
/* 6804 */       this.g2.drawString(EmpleadosBuscar.this.jTextField36.getText().toUpperCase(), 425, 313);
/* 6805 */       this.g2.drawString(EmpleadosBuscar.this.jTextField37.getText(), 425, 326);
/* 6806 */       this.g2.drawString(EmpleadosBuscar.this.jTextField38.getText(), 425, 339);
/* 6807 */       this.g2.drawString(EmpleadosBuscar.this.jTextField42.getText(), 425, 352);
/* 6808 */       this.g2.setColor(Color.RED);
/* 6809 */       this.g2.drawLine(420, 225, 420, 357);
/*      */ 
/*      */       
/* 6812 */       this.g2.setColor(Color.RED);
/* 6813 */       this.g2.drawRect(15, 288, 285, 69);
/* 6814 */       this.g2.setColor(Color.GRAY);
/* 6815 */       this.g2.fillRect(16, 289, 18, 67);
/* 6816 */       this.g2.setColor(Color.WHITE);
/* 6817 */       this.g2.fillRect(34, 289, 85, 67);
/* 6818 */       this.g2.fillRect(119, 289, 180, 67);
/* 6819 */       fuente = new Font("Dialog", 1, 5);
/* 6820 */       this.g2.setFont(fuente);
/* 6821 */       this.g2.setColor(Color.WHITE);
/* 6822 */       this.g2.drawString("O", 19, 311);
/* 6823 */       this.g2.drawString("T", 19, 318);
/* 6824 */       this.g2.drawString("R", 19, 325);
/* 6825 */       this.g2.drawString("O", 19, 332);
/* 6826 */       this.g2.drawString("S", 19, 339);
/*      */       
/* 6828 */       this.g2.drawString("D", 26, 311);
/* 6829 */       this.g2.drawString("A", 26, 318);
/* 6830 */       this.g2.drawString("T", 26, 325);
/* 6831 */       this.g2.drawString("O", 26, 332);
/* 6832 */       this.g2.drawString("S", 26, 339);
/*      */       
/* 6834 */       fuente = new Font("Dialog", 1, 7);
/* 6835 */       this.g2.setFont(fuente);
/* 6836 */       this.g2.setColor(Color.BLACK);
/* 6837 */       this.g2.drawString("NÚMERO DE HIJOS", 37, 298);
/* 6838 */       this.g2.drawString("ESTADO CIVIL", 37, 311);
/* 6839 */       this.g2.drawString("TELÉFONO", 37, 324);
/* 6840 */       this.g2.drawString("CELULAR", 37, 337);
/* 6841 */       this.g2.drawString("CORREO", 37, 351);
/*      */       
/* 6843 */       fuente = new Font("Dialog", 0, 8);
/* 6844 */       this.g2.setFont(fuente);
/* 6845 */       this.g2.setColor(Color.BLACK);
/* 6846 */       this.g2.drawString(EmpleadosBuscar.this.jTextField32.getText(), 130, 298);
/* 6847 */       this.g2.drawString(EmpleadosBuscar.this.jTextField31.getText(), 130, 311);
/* 6848 */       this.g2.drawString(EmpleadosBuscar.this.jTextField14.getText(), 130, 324);
/* 6849 */       this.g2.drawString(EmpleadosBuscar.this.jTextField15.getText(), 130, 337);
/* 6850 */       this.g2.drawString(EmpleadosBuscar.this.jTextField17.getText().toUpperCase(), 130, 351);
/* 6851 */       this.g2.setColor(Color.RED);
/* 6852 */       this.g2.drawLine(125, 288, 125, 357);
/*      */ 
/*      */       
/* 6855 */       this.g2.setColor(Color.RED);
/* 6856 */       this.g2.drawRect(15, 367, 580, 140);
/* 6857 */       this.g2.setColor(Color.GRAY);
/* 6858 */       this.g2.fillRect(16, 368, 18, 138);
/* 6859 */       this.g2.setColor(Color.WHITE);
/* 6860 */       this.g2.fillRect(34, 368, 560, 138);
/*      */       
/* 6862 */       fuente = new Font("Dialog", 1, 5);
/* 6863 */       this.g2.setFont(fuente);
/* 6864 */       this.g2.setColor(Color.WHITE);
/*      */       
/* 6866 */       this.g2.drawString("A", 19, 417);
/* 6867 */       this.g2.drawString("L", 19, 424);
/* 6868 */       this.g2.drawString("G", 19, 431);
/* 6869 */       this.g2.drawString("U", 19, 438);
/* 6870 */       this.g2.drawString("N", 19, 445);
/* 6871 */       this.g2.drawString("A", 19, 452);
/* 6872 */       this.g2.drawString("S", 19, 459);
/*      */       
/* 6874 */       this.g2.drawString("R", 26, 403);
/* 6875 */       this.g2.drawString("E", 26, 410);
/* 6876 */       this.g2.drawString("F", 26, 417);
/* 6877 */       this.g2.drawString("E", 26, 424);
/* 6878 */       this.g2.drawString("R", 26, 431);
/* 6879 */       this.g2.drawString("E", 26, 438);
/* 6880 */       this.g2.drawString("N", 26, 445);
/* 6881 */       this.g2.drawString("C", 26, 452);
/* 6882 */       this.g2.drawString("I", 26, 459);
/* 6883 */       this.g2.drawString("A", 26, 466);
/* 6884 */       this.g2.drawString("S", 26, 473);
/*      */ 
/*      */       
/* 6887 */       fuente = new Font("Dialog", 0, 7);
/* 6888 */       this.g2.setFont(fuente);
/* 6889 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 6891 */       String valor = EmpleadosBuscar.this.jTextArea1.getText().toUpperCase();
/*      */       
/* 6893 */       int inicia = 377;
/* 6894 */       int lineas = valor.length() / 150;
/* 6895 */       lineas += 2;
/* 6896 */       String[] DES = new String[lineas];
/* 6897 */       for (int i = 0; i < DES.length; i++) {
/* 6898 */         DES[i] = new String("");
/*      */       }
/* 6900 */       int cont = 0;
/* 6901 */       int l = 0; int j;
/* 6902 */       for (j = 0; j < valor.length(); j++) {
/* 6903 */         if (cont <= 150) {
/* 6904 */           DES[l] = DES[l] + DES[l];
/* 6905 */           cont++;
/*      */         } else {
/* 6907 */           DES[l] = DES[l] + DES[l];
/* 6908 */           cont = 0;
/* 6909 */           l++;
/*      */         } 
/*      */       } 
/* 6912 */       for (j = 0; j < DES.length; j++) {
/* 6913 */         g.drawString(DES[j], 37, inicia);
/* 6914 */         inicia += 8;
/*      */       } 
/*      */       
/* 6917 */       this.g2.drawString("_________________________________________", 15, 565);
/* 6918 */       this.g2.drawString(EmpleadosBuscar.this.rSTableMetro1.getValueAt(ind, 1).toString(), 15, 575);
/* 6919 */       this.g2.drawString("EMPLEADO", 15, 585);
/*      */       
/* 6921 */       String[] DATOS = EmpleadosBuscar.this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu = '" + EmpleadosBuscar.this.USUARIO + "'", 3);
/* 6922 */       this.g2.drawString("_________________________________________", 15, 645);
/* 6923 */       this.g2.drawString(DATOS[0] + " " + DATOS[0] + " " + DATOS[1], 15, 655);
/* 6924 */       this.g2.drawString("EMPRESA", 15, 665);
/*      */       
/* 6926 */       this.g2.setColor(Color.RED);
/* 6927 */       this.g2.drawRect(310, 517, 285, 150);
/* 6928 */       this.g2.setColor(Color.GRAY);
/* 6929 */       this.g2.fillRect(311, 518, 18, 148);
/* 6930 */       this.g2.setColor(Color.WHITE);
/* 6931 */       this.g2.fillRect(329, 517, 85, 148);
/* 6932 */       this.g2.fillRect(414, 517, 180, 148);
/*      */       
/* 6934 */       this.g2.setColor(Color.RED);
/* 6935 */       this.g2.drawLine(310, 592, 595, 592);
/*      */       
/* 6937 */       fuente = new Font("Dialog", 1, 7);
/* 6938 */       this.g2.setFont(fuente);
/* 6939 */       this.g2.setColor(Color.WHITE);
/*      */       
/* 6941 */       this.g2.drawString("A", 318, 539);
/* 6942 */       this.g2.drawString("L", 318, 552);
/* 6943 */       this.g2.drawString("T", 318, 565);
/* 6944 */       this.g2.drawString("A", 318, 578);
/*      */       
/* 6946 */       this.g2.drawString("B", 318, 612);
/* 6947 */       this.g2.drawString("A", 318, 625);
/* 6948 */       this.g2.drawString("J", 318, 638);
/* 6949 */       this.g2.drawString("A", 318, 651);
/*      */       
/* 6951 */       fuente = new Font("Dialog", 1, 7);
/* 6952 */       this.g2.setFont(fuente);
/* 6953 */       this.g2.setColor(Color.BLACK);
/* 6954 */       this.g2.drawString("_____________________________________", 390, 567);
/* 6955 */       this.g2.drawString("NOMBRE Y FIRMA", 430, 580);
/*      */       
/* 6957 */       this.g2.drawString("_____________________________________", 390, 640);
/* 6958 */       this.g2.drawString("NOMBRE Y FIRMA", 430, 653);
/*      */       
/* 6960 */       this.g2.setColor(new Color(56, 93, 138));
/* 6961 */       this.g2.drawRect(15, 730, 580, 40);
/* 6962 */       fuente = new Font("Dialog", 1, 6);
/* 6963 */       this.g2.setFont(fuente);
/* 6964 */       this.g2.setColor(Color.BLACK);
/* 6965 */       this.g2.drawString("          EN COMPLETO USO DE MIS FACULTADES DECLARO BAJO PROTESTA DECIR VERDAD QUE LA INFORMACIÓN PROPORCIONADA EN EL PRESENTE ES CORRECTA Y ESTOY CONFORME", 17, 747);
/* 6966 */       this.g2.drawString("                                                                     CON LAS POLÍTICAS DE LA EMPRESA. QUEDANDO A SUS ÓRDENES DESDE EL PRIMER DÍA DEL CONTRATO", 26, 759);
/*      */     } }
/*      */   
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     int pintar;
/*      */     
/*      */     CeldaRender2() {
/* 6973 */       this.otro = -1;
/* 6974 */       this.pintar = 0;
/*      */     }
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 6978 */       setEnabled((table == null || table.isEnabled()));
/* 6979 */       if (row < this.pintar) {
/* 6980 */         setBackground(EmpleadosBuscar.this.lc.FONDOTABLA);
/*      */       } else {
/* 6982 */         setBackground((Color)null);
/*      */       } 
/* 6984 */       setForeground(EmpleadosBuscar.this.lc.SECUNDARIO1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 6992 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 6993 */       return this;
/*      */     }
/*      */     
/*      */     public void setPintar(int indicePintar) {
/* 6997 */       this.pintar = indicePintar;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/EmpleadosBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */