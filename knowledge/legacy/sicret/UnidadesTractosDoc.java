/*      */ package sicret;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Desktop;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.LayoutManager;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.nio.file.Path;
/*      */ import java.nio.file.Paths;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import javax.swing.Action;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.InputMap;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JEditorPane;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRootPane;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.MaskFormatter;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import utilerias.Utilerias;
/*      */ import utilerias.pintarComponentes;
/*      */ import utilerias.verDocumento;
/*      */ 
/*      */ public class UnidadesTractosDoc extends JDialog {
/*   57 */   private Cursor micursor = null;
/*   58 */   private SColores lc = new SColores();
/*   59 */   private Toolkit tk = Toolkit.getDefaultToolkit();
/*   60 */   private Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   61 */   private Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   62 */   private Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   63 */   private Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   64 */   private Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   private Border borde;
/*      */   private Color color;
/*      */   private JScrollPane panel;
/*   68 */   private Dimension tama = new Dimension(this.tk.getScreenSize());
/*   69 */   private Utilerias utilerias = new Utilerias();
/*   70 */   private Date fechaActual = new Date();
/*   71 */   private URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   72 */   private ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   private JFrame padre;
/*   74 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   75 */   private String USUARIO = "";
/*      */   
/*      */   private JTabbedPane fichas;
/*      */   private String id;
/*   79 */   private Consultas2 con2 = new Consultas2();
/*   80 */   private CeldaRender1 celda1 = new CeldaRender1();
/*   81 */   private CeldaRender2 celda2 = new CeldaRender2();
/*   82 */   private Date fechaInicio = null;
/*      */   private verDocumento docs;
/*   84 */   private int INDICE = 0;
/*   85 */   private String RUTAGRAL = "";
/*   86 */   private int INDICEGRAL = 0;
/*   87 */   private pintarComponentes pintar = new pintarComponentes();
/*      */   private Informacion inf;
/*      */   private RSTableMetro TABLA;
/*      */   private Map<String, String> CAMPOSGENERALES;
/*      */   private Map<String, UnidadesTractosDoc> DOCUMENTACION;
/*   92 */   private Map<String, Documentos> Documentos = new TreeMap<>();
/*   93 */   private String GUARDAR = "";
/*   94 */   private String holderEco = "Buscar...";
/*   95 */   private PlaceHolder placeHolder = null;
/*   96 */   private JTable unidadesGral = null;
/*   97 */   private String CLAVEDOC = "";
/*   98 */   private String NUMTRACTO = "";
/*   99 */   private Map<String, String> CARPETAS = new TreeMap<>();
/*  100 */   private Map<String, String> CAMPOS = new TreeMap<>(); private JButton jButton56; private JButton jButton57; private JButton jButton58; private JComboBox<String> jComboBox1; private JComboBox<String> jComboBox2; private JDateChooser jDateChooser1; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDialog jDialog1; private JEditorPane jEditorPane1; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel111; private JLabel jLabel112;
/*  101 */   private String TIPOV = ""; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel2; private JLabel jLabel3; private JPanel jPanel1; private JPanel jPanel2;
/*      */   
/*      */   public UnidadesTractosDoc(Frame parent, boolean modal, RSTableMetro TABLA, Map<String, String> CAMPOSGENERALES, Map<String, String> CARPETAS, String TIPO, String GUARDAR) {
/*  104 */     super(parent, modal);
/*  105 */     this.TABLA = TABLA;
/*  106 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  107 */     this.GUARDAR = GUARDAR;
/*  108 */     this.CARPETAS = CARPETAS;
/*  109 */     if (this.CAMPOSGENERALES != null) {
/*  110 */       this.USUARIO = this.CAMPOSGENERALES.get("usuario");
/*      */     }
/*  112 */     ingresarCampos();
/*  113 */     initComponents();
/*  114 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  115 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  116 */     this.rSTableMetro1.setCursor(this.micursor);
/*  117 */     this.rSTableMetro2.setCursor(this.micursor);
/*  118 */     this.rSTableMetro3.setCursor(this.micursor);
/*  119 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/*  120 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 35);
/*  121 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 70);
/*  122 */     this.utilerias.formatearAPesos(this.jFormattedTextField1);
/*  123 */     this.placeHolder = new PlaceHolder(this.jTextField6, new Color(189, 189, 189), Color.BLACK, this.holderEco, false, "Century Gothic", 11);
/*      */     
/*  125 */     if (TIPO.equals("OTRO")) {
/*  126 */       this.jTextField1.setText(TIPO);
/*  127 */       this.jTextField1.setEditable(true);
/*      */     } else {
/*  129 */       this.jTextField1.setEditable(false);
/*  130 */       this.jTextField1.setText(TIPO.toUpperCase());
/*      */     } 
/*      */     
/*  133 */     if (GUARDAR.equals("MODIFICAR")) {
/*  134 */       this.jTextField1.setEditable(true);
/*      */     }
/*      */     
/*  137 */     this.jDateChooser4.setEnabled(false);
/*  138 */     colorear();
/*  139 */     this.utilerias.activarVentanajDialog(this.jDialog1, 500, 420);
/*  140 */     this.materialButton42.setText("Asignar a grupo de Económicos: " + this.rSTableMetro3.getRowCount() + 1);
/*      */   }
/*      */   private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel72; private JPanel jPanel73; private JPanel jPanel74; private JPanel jPanel75; private JPanel jPanel76; private JPanel jPanel79; private JPanel jPanel80; private JPanel jPanel81; private JPanel jPanel82; private JPanel jPanel83; private JPanel jPanel84; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane15; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private MaterialButton materialButton38; private MaterialButton materialButton40; private MaterialButton materialButton41; private MaterialButton materialButton42; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2;
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private void initComponents() {
/*  146 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  147 */     this.jPanel2 = new JPanel();
/*  148 */     this.jScrollPane14 = new JScrollPane();
/*  149 */     this.rSTableMetro2 = new RSTableMetro();
/*  150 */     this.jLabel1 = new JLabel();
/*  151 */     this.jLabel2 = new JLabel();
/*  152 */     this.jScrollPane15 = new JScrollPane();
/*  153 */     this.rSTableMetro3 = new RSTableMetro();
/*  154 */     this.materialButton38 = new MaterialButton();
/*  155 */     this.jTextField6 = new JTextField();
/*  156 */     this.jLabel3 = new JLabel();
/*  157 */     this.materialButton40 = new MaterialButton();
/*  158 */     this.materialButton41 = new MaterialButton();
/*  159 */     this.jPanel1 = new JPanel();
/*  160 */     this.jPanel72 = new JPanel();
/*  161 */     this.jLabel111 = new JLabel();
/*  162 */     this.jTextField1 = new JTextField();
/*  163 */     this.jLabel112 = new JLabel();
/*  164 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  165 */     this.jLabel116 = new JLabel();
/*  166 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  167 */     this.jPanel73 = new JPanel();
/*  168 */     this.jLabel113 = new JLabel();
/*  169 */     this.jTextField2 = new JTextField();
/*  170 */     this.jLabel114 = new JLabel();
/*  171 */     this.jComboBox1 = new JComboBox<>();
/*  172 */     this.jPanel75 = new JPanel();
/*  173 */     this.jPanel76 = new JPanel();
/*  174 */     this.jPanel74 = new JPanel();
/*  175 */     this.jLabel117 = new JLabel();
/*  176 */     this.jDateChooser3 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  177 */     this.jLabel118 = new JLabel();
/*  178 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  179 */     this.jPanel3 = new JPanel();
/*  180 */     this.jPanel4 = new JPanel();
/*  181 */     this.jPanel79 = new JPanel();
/*  182 */     this.jLabel119 = new JLabel();
/*  183 */     this.jTextField3 = new JTextField();
/*  184 */     this.jLabel120 = new JLabel();
/*  185 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  186 */     this.jPanel84 = new JPanel();
/*  187 */     this.jLabel122 = new JLabel();
/*  188 */     this.jTextField4 = new JTextField();
/*  189 */     this.jLabel123 = new JLabel();
/*  190 */     this.jTextField5 = new JTextField();
/*  191 */     this.jPanel80 = new JPanel();
/*  192 */     this.jLabel121 = new JLabel();
/*  193 */     this.jScrollPane12 = new JScrollPane();
/*  194 */     this.jEditorPane1 = new JEditorPane();
/*  195 */     this.jPanel81 = new JPanel();
/*  196 */     this.jPanel82 = new JPanel();
/*  197 */     this.jScrollPane13 = new JScrollPane();
/*  198 */     this.rSTableMetro1 = new RSTableMetro();
/*  199 */     this.jButton57 = new JButton();
/*  200 */     this.jButton56 = new JButton();
/*  201 */     this.jButton58 = new JButton();
/*  202 */     this.jPanel83 = new JPanel();
/*  203 */     this.materialButton42 = new MaterialButton();
/*  204 */     this.jComboBox2 = new JComboBox<>();
/*      */     
/*  206 */     this.jDialog1.setTitle("Listado de unidades");
/*  207 */     this.jDialog1.setModal(true);
/*      */     
/*  209 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "#", "Eco", "Modelo", "Serie", "Placas" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  217 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  222 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  225 */     this.rSTableMetro2.setAltoHead(25);
/*  226 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  227 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  228 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  229 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  230 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  231 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  232 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  233 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  234 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  235 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  236 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  237 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  238 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  239 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  240 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  242 */             UnidadesTractosDoc.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  245 */             UnidadesTractosDoc.this.rSTableMetro2MouseEntered(evt);
/*      */           }
/*      */         });
/*  248 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  250 */             UnidadesTractosDoc.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  253 */     this.jScrollPane14.setViewportView((Component)this.rSTableMetro2);
/*      */     
/*  255 */     this.jLabel1.setText(" Listado de unidades general");
/*      */     
/*  257 */     this.jLabel2.setText(" Listado de unidades con el mismo documento");
/*      */     
/*  259 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "#", "Eco", "Modelo", "Serie", "Placas" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  267 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  272 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  275 */     this.rSTableMetro3.setAltoHead(25);
/*  276 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  277 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  278 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  279 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  280 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  281 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  282 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  283 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*  284 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 10));
/*  285 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/*  286 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  287 */     this.rSTableMetro3.setGrosorBordeFilas(2);
/*  288 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  289 */     this.rSTableMetro3.setShowGrid(false);
/*  290 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  291 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  292 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  294 */             UnidadesTractosDoc.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  297 */             UnidadesTractosDoc.this.rSTableMetro3MouseEntered(evt);
/*      */           }
/*      */         });
/*  300 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  302 */             UnidadesTractosDoc.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  305 */     this.jScrollPane15.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  307 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  308 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  309 */     this.materialButton38.setMnemonic('C');
/*  310 */     this.materialButton38.setText("Cerrar");
/*  311 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/*  312 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/*  313 */     this.materialButton38.setHorizontalTextPosition(0);
/*  314 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  316 */             UnidadesTractosDoc.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  320 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  322 */             UnidadesTractosDoc.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  326 */     this.jLabel3.setText("jLabel3");
/*      */     
/*  328 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  329 */     this.jPanel2.setLayout(jPanel2Layout);
/*  330 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  331 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  332 */         .addComponent(this.jScrollPane14, -2, 0, 32767)
/*  333 */         .addComponent(this.jLabel2, -1, -1, 32767)
/*  334 */         .addComponent(this.jScrollPane15, -1, 443, 32767)
/*  335 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/*  336 */           .addContainerGap()
/*  337 */           .addComponent(this.jLabel3, -2, 128, -2)
/*  338 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  339 */           .addComponent((Component)this.materialButton38, -2, 105, -2))
/*  340 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  341 */           .addComponent(this.jLabel1, -2, 194, -2)
/*  342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  343 */           .addComponent(this.jTextField6, -2, 148, -2)
/*  344 */           .addContainerGap()));
/*      */     
/*  346 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  348 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/*  349 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  350 */             .addComponent(this.jLabel1)
/*  351 */             .addComponent(this.jTextField6, -2, -1, -2))
/*  352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  353 */           .addComponent(this.jScrollPane14, -2, 136, -2)
/*  354 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  355 */           .addComponent(this.jLabel2)
/*  356 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  357 */           .addComponent(this.jScrollPane15, -2, 136, -2)
/*  358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  359 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  360 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/*  361 */             .addComponent(this.jLabel3))
/*  362 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  365 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  366 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  367 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  369 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/*  371 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  372 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  373 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */ 
/*      */     
/*  376 */     setDefaultCloseOperation(2);
/*  377 */     setTitle("Archivos");
/*      */     
/*  379 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/*  380 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/*  381 */     this.materialButton40.setMnemonic('A');
/*  382 */     this.materialButton40.setText("Aplicar");
/*  383 */     this.materialButton40.setToolTipText("Aplicar (Alt+A)");
/*  384 */     this.materialButton40.setFont(new Font("Cantarell", 0, 12));
/*  385 */     this.materialButton40.setHorizontalTextPosition(0);
/*  386 */     this.materialButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  388 */             UnidadesTractosDoc.this.materialButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  392 */     this.materialButton41.setBackground(this.lc.SECUNDARIO1);
/*  393 */     this.materialButton41.setForeground(new Color(255, 255, 255));
/*  394 */     this.materialButton41.setMnemonic('C');
/*  395 */     this.materialButton41.setText("Cerrar");
/*  396 */     this.materialButton41.setToolTipText("Cerrar (Alt+C)");
/*  397 */     this.materialButton41.setFont(new Font("Cantarell", 0, 12));
/*  398 */     this.materialButton41.setHorizontalTextPosition(0);
/*  399 */     this.materialButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  401 */             UnidadesTractosDoc.this.materialButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  405 */     this.jPanel72.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  407 */     this.jLabel111.setText("Tipo");
/*  408 */     this.jPanel72.add(this.jLabel111);
/*  409 */     this.jPanel72.add(this.jTextField1);
/*      */     
/*  411 */     this.jLabel112.setHorizontalAlignment(0);
/*  412 */     this.jLabel112.setText("Fecha Captura");
/*  413 */     this.jPanel72.add(this.jLabel112);
/*      */     
/*  415 */     this.jDateChooser1.setDate(this.fechaActual);
/*  416 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/*  417 */     this.jDateChooser1.setEnabled(false);
/*  418 */     this.jDateChooser1.setIcon(this.icon);
/*  419 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/*  420 */     this.jPanel72.add((Component)this.jDateChooser1);
/*      */     
/*  422 */     this.jLabel116.setHorizontalAlignment(0);
/*  423 */     this.jLabel116.setText("Fecha de Trámite");
/*  424 */     this.jPanel72.add(this.jLabel116);
/*      */     
/*  426 */     this.jDateChooser2.setDate(this.fechaActual);
/*  427 */     this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
/*  428 */     this.jDateChooser2.setIcon(this.icon);
/*  429 */     this.jDateChooser2.setMinSelectableDate(this.fechaInicio);
/*  430 */     this.jPanel72.add((Component)this.jDateChooser2);
/*      */     
/*  432 */     this.jPanel73.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  434 */     this.jLabel113.setText("Número único");
/*  435 */     this.jPanel73.add(this.jLabel113);
/*  436 */     this.jPanel73.add(this.jTextField2);
/*      */     
/*  438 */     this.jLabel114.setHorizontalAlignment(0);
/*  439 */     this.jLabel114.setText("Periodo Vencimiento");
/*  440 */     this.jPanel73.add(this.jLabel114);
/*      */     
/*  442 */     this.jComboBox1.setBackground(new Color(255, 255, 255));
/*  443 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ÚNICO", "MENSUAL", "BIMESTRAL", "TRIMESTRAL", "CUATRIMESTRAL", "SEMESTRAL", "CADA AÑO", "CADA 2 AÑOS", "CADA 3 AÑOS", "CADA 4 AÑOS", "CADA 5 AÑOS", "OTRO" }));
/*  444 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  446 */             UnidadesTractosDoc.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  449 */     this.jPanel73.add(this.jComboBox1);
/*      */     
/*  451 */     GroupLayout jPanel75Layout = new GroupLayout(this.jPanel75);
/*  452 */     this.jPanel75.setLayout(jPanel75Layout);
/*  453 */     jPanel75Layout.setHorizontalGroup(jPanel75Layout
/*  454 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  455 */         .addGap(0, 141, 32767));
/*      */     
/*  457 */     jPanel75Layout.setVerticalGroup(jPanel75Layout
/*  458 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  459 */         .addGap(0, 25, 32767));
/*      */ 
/*      */     
/*  462 */     this.jPanel73.add(this.jPanel75);
/*      */     
/*  464 */     GroupLayout jPanel76Layout = new GroupLayout(this.jPanel76);
/*  465 */     this.jPanel76.setLayout(jPanel76Layout);
/*  466 */     jPanel76Layout.setHorizontalGroup(jPanel76Layout
/*  467 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  468 */         .addGap(0, 141, 32767));
/*      */     
/*  470 */     jPanel76Layout.setVerticalGroup(jPanel76Layout
/*  471 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  472 */         .addGap(0, 25, 32767));
/*      */ 
/*      */     
/*  475 */     this.jPanel73.add(this.jPanel76);
/*      */     
/*  477 */     this.jPanel74.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  479 */     this.jLabel117.setText("Fecha de Inicio");
/*  480 */     this.jPanel74.add(this.jLabel117);
/*      */     
/*  482 */     this.jDateChooser3.setDate(this.fechaActual);
/*  483 */     this.jDateChooser3.setDateFormatString("dd/MM/yyyy");
/*  484 */     this.jDateChooser3.setIcon(this.icon);
/*  485 */     this.jDateChooser3.setMinSelectableDate(this.fechaInicio);
/*  486 */     this.jPanel74.add((Component)this.jDateChooser3);
/*      */     
/*  488 */     this.jLabel118.setHorizontalAlignment(0);
/*  489 */     this.jLabel118.setText("Fecha de Vencimiento");
/*  490 */     this.jPanel74.add(this.jLabel118);
/*      */     
/*  492 */     this.jDateChooser4.setDate(this.fechaActual);
/*  493 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/*  494 */     this.jDateChooser4.setIcon(this.icon);
/*  495 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*  496 */     this.jPanel74.add((Component)this.jDateChooser4);
/*      */     
/*  498 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  499 */     this.jPanel3.setLayout(jPanel3Layout);
/*  500 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  501 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  502 */         .addGap(0, 141, 32767));
/*      */     
/*  504 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  505 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  506 */         .addGap(0, 21, 32767));
/*      */ 
/*      */     
/*  509 */     this.jPanel74.add(this.jPanel3);
/*      */     
/*  511 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  512 */     this.jPanel4.setLayout(jPanel4Layout);
/*  513 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  514 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  515 */         .addGap(0, 141, 32767));
/*      */     
/*  517 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  518 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  519 */         .addGap(0, 21, 32767));
/*      */ 
/*      */     
/*  522 */     this.jPanel74.add(this.jPanel4);
/*      */     
/*  524 */     this.jPanel79.setLayout((LayoutManager)null);
/*      */     
/*  526 */     this.jLabel119.setText("Dependencia");
/*  527 */     this.jPanel79.add(this.jLabel119);
/*  528 */     this.jLabel119.setBounds(0, 0, 130, 21);
/*      */     
/*  530 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  532 */             UnidadesTractosDoc.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  535 */     this.jPanel79.add(this.jTextField3);
/*  536 */     this.jTextField3.setBounds(150, 0, 433, 25);
/*      */     
/*  538 */     this.jLabel120.setHorizontalAlignment(0);
/*  539 */     this.jLabel120.setText("Costo");
/*  540 */     this.jPanel79.add(this.jLabel120);
/*  541 */     this.jLabel120.setBounds(592, 0, 130, 21);
/*      */     
/*  543 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  544 */     this.jPanel79.add(this.jFormattedTextField1);
/*  545 */     this.jFormattedTextField1.setBounds(739, 0, 140, 25);
/*      */     
/*  547 */     this.jPanel84.setLayout((LayoutManager)null);
/*      */     
/*  549 */     this.jLabel122.setText("Dirección");
/*  550 */     this.jPanel84.add(this.jLabel122);
/*  551 */     this.jLabel122.setBounds(0, 0, 120, 21);
/*      */     
/*  553 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  555 */             UnidadesTractosDoc.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  558 */     this.jPanel84.add(this.jTextField4);
/*  559 */     this.jTextField4.setBounds(150, 0, 433, 25);
/*      */     
/*  561 */     this.jLabel123.setHorizontalAlignment(0);
/*  562 */     this.jLabel123.setText("Teléfonos");
/*  563 */     this.jPanel84.add(this.jLabel123);
/*  564 */     this.jLabel123.setBounds(592, 0, 130, 21);
/*  565 */     this.jPanel84.add(this.jTextField5);
/*  566 */     this.jTextField5.setBounds(740, 0, 140, 25);
/*      */     
/*  568 */     this.jPanel80.setLayout((LayoutManager)null);
/*      */     
/*  570 */     this.jLabel121.setText("Comentarios");
/*  571 */     this.jPanel80.add(this.jLabel121);
/*  572 */     this.jLabel121.setBounds(0, 0, 130, 21);
/*      */     
/*  574 */     this.jScrollPane12.setViewportView(this.jEditorPane1);
/*      */     
/*  576 */     this.jPanel80.add(this.jScrollPane12);
/*  577 */     this.jScrollPane12.setBounds(150, 0, 730, 70);
/*      */     
/*  579 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Archivo", "Tipo", "Act" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  587 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  592 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  595 */     this.rSTableMetro1.setAltoHead(25);
/*  596 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  597 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/*  598 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  599 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/*  600 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  601 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  602 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  603 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  604 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  605 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  606 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  607 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  608 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  609 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  610 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  612 */             UnidadesTractosDoc.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  615 */             UnidadesTractosDoc.this.rSTableMetro1MouseEntered(evt);
/*      */           }
/*      */         });
/*  618 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  620 */             UnidadesTractosDoc.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/*  623 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*      */     
/*  625 */     this.jButton57.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  626 */     this.jButton57.setToolTipText("Eliminar");
/*  627 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  629 */             UnidadesTractosDoc.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  633 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  634 */     this.jButton56.setToolTipText("Agregar Nuevo");
/*  635 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  637 */             UnidadesTractosDoc.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  641 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/button.png")));
/*  642 */     this.jButton58.setToolTipText("Descargar");
/*  643 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  645 */             UnidadesTractosDoc.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  649 */     GroupLayout jPanel82Layout = new GroupLayout(this.jPanel82);
/*  650 */     this.jPanel82.setLayout(jPanel82Layout);
/*  651 */     jPanel82Layout.setHorizontalGroup(jPanel82Layout
/*  652 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  653 */         .addGroup(jPanel82Layout.createSequentialGroup()
/*  654 */           .addComponent(this.jScrollPane13, -2, 333, -2)
/*  655 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  656 */           .addGroup(jPanel82Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  657 */             .addComponent(this.jButton56, -1, -1, 32767)
/*  658 */             .addComponent(this.jButton57, -1, -1, 32767)
/*  659 */             .addComponent(this.jButton58, -1, -1, 32767))));
/*      */     
/*  661 */     jPanel82Layout.setVerticalGroup(jPanel82Layout
/*  662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  663 */         .addComponent(this.jScrollPane13, -2, 0, 32767)
/*  664 */         .addGroup(jPanel82Layout.createSequentialGroup()
/*  665 */           .addComponent(this.jButton56, -2, 26, -2)
/*  666 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  667 */           .addComponent(this.jButton57, -2, 26, -2)
/*  668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  669 */           .addComponent(this.jButton58, -2, 26, -2)
/*  670 */           .addGap(0, 125, 32767)));
/*      */ 
/*      */     
/*  673 */     this.jPanel83.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2), "Vista Previa", 2, 0, new Font("Quicksand", 0, 12), this.lc.SECUNDARIO1));
/*      */     
/*  675 */     GroupLayout jPanel83Layout = new GroupLayout(this.jPanel83);
/*  676 */     this.jPanel83.setLayout(jPanel83Layout);
/*  677 */     jPanel83Layout.setHorizontalGroup(jPanel83Layout
/*  678 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  679 */         .addGap(0, 0, 32767));
/*      */     
/*  681 */     jPanel83Layout.setVerticalGroup(jPanel83Layout
/*  682 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  683 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/*  686 */     GroupLayout jPanel81Layout = new GroupLayout(this.jPanel81);
/*  687 */     this.jPanel81.setLayout(jPanel81Layout);
/*  688 */     jPanel81Layout.setHorizontalGroup(jPanel81Layout
/*  689 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  690 */         .addGroup(jPanel81Layout.createSequentialGroup()
/*  691 */           .addComponent(this.jPanel82, -2, -1, -2)
/*  692 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  693 */           .addComponent(this.jPanel83, -1, -1, 32767)));
/*      */     
/*  695 */     jPanel81Layout.setVerticalGroup(jPanel81Layout
/*  696 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  697 */         .addComponent(this.jPanel82, -1, -1, 32767)
/*  698 */         .addComponent(this.jPanel83, -1, -1, 32767));
/*      */ 
/*      */     
/*  701 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  702 */     this.jPanel1.setLayout(jPanel1Layout);
/*  703 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  704 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  705 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  706 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  707 */             .addComponent(this.jPanel72, -2, 880, -2)
/*  708 */             .addComponent(this.jPanel73, -2, 880, -2)
/*  709 */             .addComponent(this.jPanel74, -2, 880, -2)
/*  710 */             .addComponent(this.jPanel79, -2, 880, -2)
/*  711 */             .addComponent(this.jPanel84, -2, 880, -2)
/*  712 */             .addComponent(this.jPanel80, -2, 885, -2))
/*  713 */           .addGap(0, 0, 32767))
/*  714 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  715 */           .addComponent(this.jPanel81, -1, -1, 32767)
/*  716 */           .addContainerGap()));
/*      */     
/*  718 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  720 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  721 */           .addComponent(this.jPanel72, -2, -1, -2)
/*  722 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  723 */           .addComponent(this.jPanel73, -2, 25, -2)
/*  724 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  725 */           .addComponent(this.jPanel74, -2, -1, -2)
/*  726 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  727 */           .addComponent(this.jPanel79, -2, 25, -2)
/*  728 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  729 */           .addComponent(this.jPanel84, -2, 25, -2)
/*  730 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  731 */           .addComponent(this.jPanel80, -2, 71, -2)
/*  732 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  733 */           .addComponent(this.jPanel81, -1, -1, 32767)));
/*      */ 
/*      */     
/*  736 */     this.materialButton42.setBackground(this.lc.PRIMARIO1);
/*  737 */     this.materialButton42.setForeground(new Color(255, 255, 255));
/*  738 */     this.materialButton42.setMnemonic('S');
/*  739 */     this.materialButton42.setText("Asignar a grupo de Económicos");
/*  740 */     this.materialButton42.setToolTipText("Asiganar a más económicos");
/*  741 */     this.materialButton42.setFont(new Font("Cantarell", 0, 12));
/*  742 */     this.materialButton42.setHorizontalTextPosition(0);
/*  743 */     this.materialButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  745 */             UnidadesTractosDoc.this.materialButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  749 */     this.jComboBox2.setBackground(new Color(255, 255, 255));
/*  750 */     this.jComboBox2.setEditable(true);
/*  751 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "BAJA" }));
/*      */     
/*  753 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  754 */     getContentPane().setLayout(layout);
/*  755 */     layout.setHorizontalGroup(layout
/*  756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  757 */         .addGroup(layout.createSequentialGroup()
/*  758 */           .addComponent(this.jPanel1, -2, -1, -2)
/*  759 */           .addContainerGap(-1, 32767))
/*  760 */         .addGroup(layout.createSequentialGroup()
/*  761 */           .addComponent(this.jComboBox2, -2, 150, -2)
/*  762 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  763 */           .addComponent((Component)this.materialButton42, -2, 239, -2)
/*  764 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  765 */           .addComponent((Component)this.materialButton40, -2, 150, -2)
/*  766 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  767 */           .addComponent((Component)this.materialButton41, -2, 105, -2)
/*  768 */           .addGap(19, 19, 19)));
/*      */     
/*  770 */     layout.setVerticalGroup(layout
/*  771 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  772 */         .addGroup(layout.createSequentialGroup()
/*  773 */           .addComponent(this.jPanel1, -1, -1, 32767)
/*  774 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  775 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  776 */             .addComponent((Component)this.materialButton41, -2, 38, -2)
/*  777 */             .addComponent((Component)this.materialButton40, -2, 38, -2)
/*  778 */             .addComponent((Component)this.materialButton42, -2, 38, -2)
/*  779 */             .addComponent(this.jComboBox2, -2, -1, -2))
/*  780 */           .addContainerGap()));
/*      */ 
/*      */     
/*  783 */     pack();
/*      */   }
/*      */   
/*      */   private void materialButton40ActionPerformed(ActionEvent evt) {
/*  787 */     String CAMPO = "";
/*  788 */     if (this.TIPOV.equals("")) {
/*  789 */       this.TIPOV = "TRACTO";
/*      */     }
/*      */     
/*  792 */     String TABLAGRAL = "";
/*  793 */     if (this.TIPOV.equals("TRACTO")) {
/*  794 */       CAMPO = "num_tracto";
/*  795 */       TABLAGRAL = "tracto";
/*  796 */     } else if (this.TIPOV.equals("REM")) {
/*  797 */       CAMPO = "num_rem";
/*  798 */       TABLAGRAL = "remolque";
/*      */     }
/*  800 */     else if (this.TIPOV.equals("DOLLY")) {
/*  801 */       CAMPO = "idDolly";
/*  802 */       TABLAGRAL = "dollys";
/*      */     } 
/*      */     
/*  805 */     if (this.jTextField1.getText().equals("")) {
/*  806 */       this.jTextField1.setBackground(Color.red);
/*  807 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar el tipo de documento", "Falta el tipo", 0, this.ADVER);
/*  808 */     } else if (this.jDateChooser2.getDate() == null) {
/*  809 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar la fecha del trámite", "Fecha del trámite", 0, this.ADVER);
/*  810 */     } else if (this.jTextField2.getText().equals("")) {
/*  811 */       this.jTextField2.setBackground(Color.RED);
/*  812 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar el número único del documento, referencia, matrícula o ID", "Falta número", 0, this.ADVER);
/*  813 */     } else if (this.jDateChooser3.getDate() == null) {
/*  814 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar la fecha de inicio", "Fecha de Inicio", 0, this.ADVER);
/*  815 */     } else if (this.jDateChooser4.getDate() == null) {
/*  816 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar la fecha de vencimiento", "Fecha de Vencimiento", 0, this.ADVER);
/*  817 */     } else if (this.jComboBox2.getSelectedItem().toString().equals("")) {
/*  818 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar el estado del documento", "Falta estado", 0, this.ADVER);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */       
/*  827 */       boolean sigue = true;
/*  828 */       if (getGUARDAR().equals("TEMPORAL") && 
/*  829 */         this.DOCUMENTACION.containsKey(this.jTextField1.getText().toUpperCase())) {
/*  830 */         this.jTextField1.setBackground(Color.red);
/*  831 */         JOptionPane.showMessageDialog(this, "El tipo de documento que deseas ingresar ya se encuentra registrado, por favor coloca otro tipo", "Documento Duplicado", 0, this.ADVER);
/*  832 */         sigue = false;
/*      */       } 
/*      */       
/*  835 */       if (sigue) {
/*  836 */         int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas guardar el documento?", "Guardar Documento", 0, 1, this.PREG);
/*  837 */         if (res == 0) {
/*  838 */           if (getGUARDAR().equals("MODIFICAR")) {
/*  839 */             this.inf = new Informacion();
/*  840 */             this.inf.setTipo(this.jTextField1.getText().toUpperCase());
/*  841 */             this.inf.setfCaptura(this.utilerias.convertirFechaDateString(new Date()));
/*  842 */             this.inf.setNumUnico(this.jTextField2.getText().toUpperCase());
/*  843 */             this.inf.setpVencimiento(this.jComboBox1.getSelectedItem().toString());
/*  844 */             this.inf.setFtramite(this.utilerias.convertirFechaDateString(this.jDateChooser2.getDate()));
/*  845 */             this.inf.setFinicio(this.utilerias.convertirFechaDateString(this.jDateChooser3.getDate()));
/*  846 */             this.inf.setfVencimiento(this.utilerias.convertirFechaDateString(this.jDateChooser4.getDate()));
/*  847 */             this.inf.setDependencia(this.jTextField3.getText().toUpperCase());
/*  848 */             this.inf.setCosto(this.jFormattedTextField1.getText());
/*  849 */             this.inf.setDirTramite(this.jTextField4.getText().toUpperCase());
/*  850 */             this.inf.setTel(this.jTextField5.getText().toUpperCase());
/*  851 */             this.inf.setComentarios(this.jEditorPane1.getText().toUpperCase());
/*  852 */             this.inf.setEstado(this.jComboBox2.getSelectedItem().toString().toUpperCase());
/*      */             
/*  854 */             this.con2.inserSinMsj("update unidadesdocumentos set tipo = '" + this.inf
/*  855 */                 .getTipo() + "', fechaCaptura = '" + this.inf.getfCaptura() + "', fechaTramite = '" + this.inf.getFtramite() + "', numeroUnico = '" + this.inf
/*  856 */                 .getNumUnico() + "', periodoVencimiento = '" + this.inf.getpVencimiento() + "', fechaInicio ='" + this.inf.getFinicio() + "', fechaVencimiento = '" + this.inf
/*  857 */                 .getfVencimiento() + "', dependencia = '" + this.inf.getDependencia() + "', costo ='" + this.inf.getCosto() + "', dirTramite = '" + this.inf
/*  858 */                 .getDirTramite() + "', telefono = '" + this.inf.getTel() + "', comentarios = '" + this.inf.getComentarios() + "', estado = '" + this.inf.getEstado() + "', usuario = '" + this.utilerias
/*  859 */                 .sacarUsuario(this.CAMPOSGENERALES.get("usuario")) + "' where numDoc = " + this.CLAVEDOC);
/*      */ 
/*      */             
/*  862 */             this.con2.eliminar2("unidadesdoctractos", "where numDoc = " + this.CLAVEDOC);
/*  863 */             this.con2.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values (" + this.CLAVEDOC + ", " + this.NUMTRACTO + ",'" + this.TIPOV + "' )");
/*  864 */             for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/*  865 */               if (!this.rSTableMetro3.getValueAt(i, 0).toString().equals(this.NUMTRACTO)) {
/*  866 */                 this.con2.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values (" + this.CLAVEDOC + ", " + String.valueOf(this.rSTableMetro3.getValueAt(i, 0)) + ",'" + this.TIPOV + "' )");
/*      */               }
/*      */             } 
/*      */             
/*  870 */             String[] ecos = getlistaEcos();
/*  871 */             boolean actualiza = false; int j;
/*  872 */             for (j = 0; j < ecos.length; j++) {
/*  873 */               if (this.CAMPOS.containsValue(this.jTextField1.getText().toUpperCase())) {
/*  874 */                 actualiza = true;
/*  875 */                 this.con2.inserSinMsj("update " + TABLAGRAL + " set " + convertirTipoDocCampo(this.jTextField1.getText().toUpperCase()) + " = '" + getInformacion().getNumUnico() + "', usuario='" + this.utilerias.sacarUsuario(this.USUARIO) + "' where " + CAMPO + "= " + ecos[j]);
/*      */               } 
/*      */             } 
/*  878 */             if (actualiza) {
/*  879 */               this.con2.inserSinMsj("update " + TABLAGRAL + " set " + convertirTipoDocCampo(this.inf.getTipo()) + " = '" + this.inf.getNumUnico().toUpperCase() + "', usuario='" + this.utilerias.sacarUsuario(this.CAMPOSGENERALES.get("usuario")) + "' where " + CAMPO + " = " + this.NUMTRACTO);
/*      */             }
/*      */             
/*  882 */             for (j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  883 */               String clave = this.rSTableMetro1.getValueAt(j, 0).toString();
/*  884 */               if (clave.equals("")) {
/*  885 */                 this.con2.inserSinMsj("insert into unidadesarchivos ( nombreArch, tipo, fecha, numDoc ) values ( '" + 
/*      */ 
/*      */                     
/*  888 */                     copiarArchivos(this.rSTableMetro1.getValueAt(j, 1).toString(), getRutaDestino(this.CLAVEDOC)) + "', '" + this.rSTableMetro1
/*  889 */                     .getValueAt(j, 2).toString() + "', '" + this.rSTableMetro1
/*  890 */                     .getValueAt(j, 3).toString() + "', " + this.CLAVEDOC + ")");
/*      */               }
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  896 */             verTablaDocs();
/*      */           } else {
/*      */             
/*  899 */             if (getGUARDAR().equals("MODIFICAR TEMPORAL")) {
/*  900 */               System.out.println("Tipo Origin " + getInformacion().getTipo() + " " + this.jTextField1.getText());
/*  901 */               if (!getInformacion().getTipo().equals(this.jTextField1.getText().toUpperCase())) {
/*  902 */                 this.DOCUMENTACION.remove(getInformacion().getTipo());
/*      */               }
/*      */             } 
/*      */             
/*  906 */             this.inf = new Informacion();
/*  907 */             this.inf.setTipo(this.jTextField1.getText().toUpperCase());
/*  908 */             this.inf.setfCaptura(this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate()));
/*  909 */             this.inf.setNumUnico(this.jTextField2.getText().toUpperCase());
/*  910 */             this.inf.setpVencimiento(this.jComboBox1.getSelectedItem().toString());
/*  911 */             this.inf.setFtramite(this.utilerias.convertirFechaDateString(this.jDateChooser2.getDate()));
/*  912 */             this.inf.setFinicio(this.utilerias.convertirFechaDateString(this.jDateChooser3.getDate()));
/*  913 */             this.inf.setfVencimiento(this.utilerias.convertirFechaDateString(this.jDateChooser4.getDate()));
/*  914 */             this.inf.setDependencia(this.jTextField3.getText().toUpperCase());
/*  915 */             this.inf.setCosto(this.jFormattedTextField1.getText());
/*  916 */             this.inf.setDirTramite(this.jTextField4.getText().toUpperCase());
/*  917 */             this.inf.setTel(this.jTextField5.getText().toUpperCase());
/*  918 */             this.inf.setComentarios(this.jEditorPane1.getText().toUpperCase());
/*  919 */             this.inf.setEstado(this.jComboBox2.getSelectedItem().toString().toUpperCase());
/*  920 */             this.Documentos.clear();
/*  921 */             for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  922 */               this.Documentos.put("" + i, new Documentos("" + i, this.rSTableMetro1
/*      */                     
/*  924 */                     .getValueAt(i, 1).toString(), this.rSTableMetro1
/*  925 */                     .getValueAt(i, 2).toString(), this.rSTableMetro1
/*  926 */                     .getValueAt(i, 3).toString()));
/*      */             }
/*      */             
/*  929 */             this.unidadesGral = (JTable)this.rSTableMetro3;
/*  930 */             this.inf.setID("0");
/*  931 */             this.DOCUMENTACION.put(this.jTextField1.getText().toUpperCase(), this);
/*      */             
/*  933 */             this.utilerias.vaciarTabla((JTable)this.TABLA);
/*      */             
/*  935 */             if (getGUARDAR().equals("APLICAR")) {
/*  936 */               insertarDocumentos(this.NUMTRACTO, this.jTextField1.getText().toUpperCase());
/*  937 */               verTablaDocs();
/*  938 */               if (this.CAMPOS.containsValue(this.jTextField1.getText().toUpperCase())) {
/*  939 */                 this.con2.inserSinMsj("update " + TABLAGRAL + " set " + convertirTipoDocCampo(this.inf.getTipo()) + " = '" + this.inf.getNumUnico().toUpperCase() + "', usuario='" + this.utilerias.sacarUsuario(this.USUARIO) + "' where " + CAMPO + " = " + this.NUMTRACTO);
/*      */               }
/*      */             } else {
/*  942 */               visualizarListadoDoc();
/*      */             } 
/*      */           } 
/*      */           
/*  946 */           setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton41ActionPerformed(ActionEvent evt) {
/*  953 */     setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/*  961 */     if (evt.getClickCount() == 1) {
/*  962 */       verDocumento();
/*      */     } else {
/*  964 */       int ind = this.rSTableMetro1.getRowCount();
/*  965 */       if (ind > 0) {
/*      */         try {
/*  967 */           File path = new File(this.rSTableMetro1.getValueAt(this.INDICEGRAL, 1).toString());
/*  968 */           Desktop.getDesktop().open(path);
/*  969 */         } catch (IOException ex) {
/*  970 */           ex.printStackTrace();
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {
/*  982 */     verDocumento();
/*      */   }
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/*  986 */     int ind = this.rSTableMetro1.getSelectedRow();
/*  987 */     if (ind < 0) {
/*  988 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar un registro para poder eliminar los datos", "Selecciona un registro", 0, this.ADVER);
/*      */     }
/*  990 */     else if (this.GUARDAR.equals("MODIFICAR")) {
/*  991 */       int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas eliminar el documento por completo?", "Eliminar...", 0, 3, this.ELIMINAR);
/*  992 */       if (res == 0) {
/*  993 */         File fichero = new File(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString());
/*  994 */         this.con2.eliminar2("unidadesarchivos", "where numArch = " + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/*  995 */         fichero.delete();
/*  996 */         limpiarPanelDer();
/*  997 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro1, ind);
/*  998 */         this.INDICE = this.rSTableMetro1.getRowCount();
/*      */       } 
/*      */     } else {
/* 1001 */       limpiarPanelDer();
/* 1002 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro1, ind);
/* 1003 */       this.INDICE = this.rSTableMetro1.getRowCount();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 1009 */     cargarArchivo();
/* 1010 */     int ind = this.rSTableMetro1.getRowCount() - 1;
/* 1011 */     this
/*      */       
/* 1013 */       .docs = new verDocumento(this.rSTableMetro1.getValueAt(ind, 1).toString(), this.rSTableMetro1.getValueAt(ind, 2).toString());
/*      */     
/* 1015 */     pintarPanel();
/* 1016 */     this.INDICEGRAL = ind;
/* 1017 */     this.jPanel83.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2), this.rSTableMetro1.getValueAt(ind, 1).toString(), 2, 0, new Font("Quicksand", 1, 12), this.lc.SECUNDARIO1));
/*      */   }
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 1021 */     int ind = this.rSTableMetro1.getRowCount();
/* 1022 */     if (ind > 0) {
/*      */       try {
/* 1024 */         File path = new File(this.rSTableMetro1.getValueAt(this.INDICEGRAL, 1).toString());
/* 1025 */         Desktop.getDesktop().open(path);
/* 1026 */       } catch (IOException ex) {
/* 1027 */         ex.printStackTrace();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton42ActionPerformed(ActionEvent evt) {
/* 1037 */     if (this.jTextField2.isEnabled()) {
/* 1038 */       consultar();
/*      */     } else {
/* 1040 */       consultarMismos();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1048 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1052 */     this.jDateChooser3.setDate(this.jDateChooser2.getDate());
/* 1053 */     if (this.jComboBox1.getSelectedItem().toString().equals("ÚNICO")) {
/* 1054 */       this.jDateChooser4.setEnabled(false);
/* 1055 */       this.jDateChooser4.setDate(this.jDateChooser1.getDate());
/* 1056 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("MENSUAL")) {
/* 1057 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 1));
/* 1058 */       this.jDateChooser4.setEnabled(true);
/* 1059 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("BIMESTRAL")) {
/* 1060 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 2));
/* 1061 */       this.jDateChooser4.setEnabled(true);
/* 1062 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("TRIMESTRAL")) {
/* 1063 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 3));
/* 1064 */       this.jDateChooser4.setEnabled(true);
/* 1065 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("CUATRIMESTRAL")) {
/* 1066 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 4));
/* 1067 */       this.jDateChooser4.setEnabled(true);
/* 1068 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("SEMESTRAL")) {
/* 1069 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 6));
/* 1070 */       this.jDateChooser4.setEnabled(true);
/* 1071 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("CADA AÑO")) {
/* 1072 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 12));
/* 1073 */       this.jDateChooser4.setEnabled(true);
/* 1074 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("CADA 2 AÑOS")) {
/* 1075 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 24));
/* 1076 */       this.jDateChooser4.setEnabled(true);
/* 1077 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("CADA 3 AÑOS")) {
/* 1078 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 36));
/* 1079 */       this.jDateChooser4.setEnabled(true);
/* 1080 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("CADA 4 AÑOS")) {
/* 1081 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 48));
/* 1082 */       this.jDateChooser4.setEnabled(true);
/* 1083 */     } else if (this.jComboBox1.getSelectedItem().toString().equals("CADA 5 AÑOS")) {
/* 1084 */       this.jDateChooser4.setDate(desplazarMeses(this.jDateChooser3.getDate(), 60));
/* 1085 */       this.jDateChooser4.setEnabled(true);
/*      */     } else {
/* 1087 */       this.jDateChooser4.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 1092 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 1096 */     if (evt.getClickCount() == 2) {
/* 1097 */       boolean esta = false;
/* 1098 */       int ind = this.rSTableMetro2.getSelectedRow();
/* 1099 */       String nuevoEco = this.rSTableMetro2.getValueAt(ind, 0).toString();
/*      */       
/* 1101 */       for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 1102 */         String eco = this.rSTableMetro3.getValueAt(i, 0).toString();
/* 1103 */         if (eco.equals(nuevoEco)) {
/* 1104 */           esta = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1108 */       if (!esta) {
/* 1109 */         this.utilerias.agregarCampoTablas(new String[] { this.rSTableMetro2
/* 1110 */               .getValueAt(ind, 0).toString(), this.rSTableMetro2.getValueAt(ind, 1).toString(), this.rSTableMetro2.getValueAt(ind, 2).toString(), this.rSTableMetro2.getValueAt(ind, 3).toString(), this.rSTableMetro2.getValueAt(ind, 4).toString() }(JTable)this.rSTableMetro3);
/*      */       }
/*      */       
/* 1113 */       this.jLabel3.setText("Total: " + this.rSTableMetro3.getRowCount());
/* 1114 */       this.materialButton42.setText("Asignar a grupo de Económicos: " + this.rSTableMetro3.getRowCount());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 1127 */     if (evt.getClickCount() == 2 && (this.GUARDAR.contains("TEMPORAL") || this.GUARDAR.contains("MODIFICAR"))) {
/* 1128 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro3, this.rSTableMetro3.getSelectedRow());
/* 1129 */       this.jLabel3.setText("Total: " + this.rSTableMetro3.getRowCount());
/* 1130 */       this.materialButton42.setText("Asignar a grupo de Económicos: " + this.rSTableMetro3.getRowCount());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 1143 */     consultar();
/*      */   }
/*      */   
/*      */   public void actualizarUsuario(String numTracto) {
/* 1147 */     if (this.TIPOV.equals("")) {
/* 1148 */       this.TIPOV = "TRACTO";
/*      */     }
/* 1150 */     String CAMPO = "";
/* 1151 */     String TABLAGRAL = "";
/* 1152 */     if (this.TIPOV.equals("TRACTO")) {
/* 1153 */       CAMPO = "num_tracto";
/* 1154 */       TABLAGRAL = "tracto";
/* 1155 */     } else if (this.TIPOV.equals("REM")) {
/* 1156 */       TABLAGRAL = "remolque";
/* 1157 */       CAMPO = "num_tracto";
/*      */     } 
/* 1159 */     this.con2.inserSinMsj("update " + TABLAGRAL + " set usuario = '" + this.utilerias.sacarUsuario(this.CAMPOSGENERALES.get("usuario")) + "' where " + CAMPO + " = " + numTracto);
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertarDocumentos(String claveTracto, String TipoDoc) {
/* 1164 */     String claveDoc = "";
/* 1165 */     this.con2.inserSinMsj("insert into unidadesdocumentos (tipo, fechaCaptura, fechaTramite, numeroUnico, periodoVencimiento, fechaInicio, fechaVencimiento, dependencia, costo, dirTramite, telefono, comentarios, estado, usuario) values ('" + ((UnidadesTractosDoc)this.DOCUMENTACION
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1172 */         .get(TipoDoc)).getInformacion().getTipo() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1173 */         .get(TipoDoc)).getInformacion().getfCaptura() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1174 */         .get(TipoDoc)).getInformacion().getFtramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1175 */         .get(TipoDoc)).getInformacion().getNumUnico() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1176 */         .get(TipoDoc)).getInformacion().getpVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1177 */         .get(TipoDoc)).getInformacion().getFinicio() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1178 */         .get(TipoDoc)).getInformacion().getfVencimiento() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1179 */         .get(TipoDoc)).getInformacion().getDependencia() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1180 */         .get(TipoDoc)).getInformacion().getCosto() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1181 */         .get(TipoDoc)).getInformacion().getDirTramite() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1182 */         .get(TipoDoc)).getInformacion().getTel() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1183 */         .get(TipoDoc)).getInformacion().getComentarios() + "', '" + ((UnidadesTractosDoc)this.DOCUMENTACION
/* 1184 */         .get(TipoDoc)).getInformacion().getEstado() + "', '" + this.utilerias
/* 1185 */         .sacarUsuario(this.USUARIO) + "')");
/*      */ 
/*      */ 
/*      */     
/* 1189 */     if (this.TIPOV.equals("")) {
/* 1190 */       this.TIPOV = "TRACTO";
/*      */     }
/* 1192 */     String CAMPO = "";
/* 1193 */     String TABLAGRAL = "";
/* 1194 */     if (this.TIPOV.equals("TRACTO")) {
/* 1195 */       CAMPO = "num_tracto";
/* 1196 */       TABLAGRAL = "tracto";
/* 1197 */     } else if (this.TIPOV.equals("REM")) {
/* 1198 */       TABLAGRAL = "remolque";
/* 1199 */       CAMPO = "num_rem";
/*      */     } 
/*      */     
/* 1202 */     this.con2.consultar("max(numDoc)", "unidadesdocumentos", "");
/* 1203 */     claveDoc = this.con2.Campo;
/*      */     
/* 1205 */     for (int i = 0; i < ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().size(); i++) {
/* 1206 */       this.con2.inserSinMsj("insert into unidadesarchivos ( nombreArch, tipo, fecha, numDoc ) values ( '" + 
/*      */ 
/*      */           
/* 1209 */           copiarArchivos(((Documentos)((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getDocumentos().get("" + i)).getArchivo(), getRutaDestino(TipoDoc)) + "', '" + ((Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 1210 */           .get(TipoDoc)).getDocumentos().get("" + i)).getTipo() + "', '" + ((Documentos)((UnidadesTractosDoc)this.DOCUMENTACION
/* 1211 */           .get(TipoDoc)).getDocumentos().get("" + i)).getAct() + "', " + claveDoc + ")");
/*      */     }
/*      */ 
/*      */     
/* 1215 */     this.con2.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto,tipo) values(" + claveDoc + ", " + claveTracto + ", '" + this.TIPOV + "' )");
/* 1216 */     String[] ecos = ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getlistaEcos();
/* 1217 */     for (int j = 0; j < ecos.length; j++) {
/* 1218 */       if (!ecos[j].equals(this.NUMTRACTO)) {
/* 1219 */         this.con2.inserSinMsj("insert into unidadesdoctractos(numDoc, num_tracto, tipo) values(" + claveDoc + ", " + ecos[j] + ",'" + this.TIPOV + "' )");
/*      */       }
/*      */       
/* 1222 */       if (this.CAMPOS.containsValue(this.jTextField1.getText().toUpperCase())) {
/* 1223 */         this.con2.inserSinMsj("update " + TABLAGRAL + " set " + convertirTipoDocCampo(TipoDoc) + " = '" + ((UnidadesTractosDoc)this.DOCUMENTACION.get(TipoDoc)).getInformacion().getNumUnico() + "' where " + CAMPO + "= " + ecos[j]);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public String copiarArchivos(String origen, String destino) {
/* 1229 */     if (this.TIPOV.equals("")) {
/* 1230 */       this.TIPOV = "ECO";
/*      */     }
/* 1232 */     Path origenPath = Paths.get(origen, new String[0]);
/* 1233 */     Path destinoPath = Paths.get(destino + "/" + destino + this.TIPOV + "-" + this.utilerias.getFechaSinEspacios(), new String[0]);
/*      */     
/*      */     try {
/* 1236 */       Files.copy(origenPath, destinoPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*      */     }
/* 1238 */     catch (FileNotFoundException ex) {
/* 1239 */       System.out.println("ERROR 1: al copiar Arhivo: " + ex.getMessage());
/* 1240 */     } catch (IOException ex) {
/* 1241 */       System.out.println("ERROR 2: al copiar Arhivo: " + ex.getMessage());
/*      */     } 
/*      */ 
/*      */     
/* 1245 */     String nuevaRuta = destinoPath.toString().replace("\\", "\\\\");
/* 1246 */     return nuevaRuta;
/*      */   }
/*      */ 
/*      */   
/*      */   public String convertirTipoDocCampo(String tipoDoc) {
/* 1251 */     String campo = "";
/* 1252 */     if (tipoDoc.equals("TARJETA DE CIRCULACIÓN")) {
/* 1253 */       campo = "tc";
/* 1254 */     } else if (tipoDoc.equals("PÓLIZA DE SEGURO")) {
/* 1255 */       campo = "poliza";
/* 1256 */     } else if (tipoDoc.equals("SEDEMA")) {
/* 1257 */       campo = "sedema";
/* 1258 */     } else if (tipoDoc.equals("NOM 012")) {
/* 1259 */       campo = "nom012";
/* 1260 */     } else if (tipoDoc.equals("VERIFICACIÓN")) {
/* 1261 */       campo = "verificacion";
/* 1262 */     } else if (tipoDoc.equals("FISICOMECÁNICA")) {
/* 1263 */       campo = "fisicomecanica";
/* 1264 */     } else if (tipoDoc.equals("SCT")) {
/* 1265 */       campo = "sct";
/* 1266 */     } else if (tipoDoc.equals("PAGO")) {
/* 1267 */       campo = "pago";
/* 1268 */     } else if (tipoDoc.equals("INSPECCIÓN")) {
/* 1269 */       campo = "inspeccion";
/*      */     } 
/*      */     
/* 1272 */     return campo;
/*      */   }
/*      */   
/*      */   public String getRutaDestino(String tipo) {
/* 1276 */     String ruta = this.CARPETAS.get("OTRO");
/* 1277 */     if (tipo.equals("TARJETA DE CIRCULACIÓN")) {
/* 1278 */       ruta = this.CARPETAS.get("TC");
/* 1279 */     } else if (tipo.equals("PÓLIZA DE SEGURO")) {
/* 1280 */       ruta = this.CARPETAS.get("POLIZA");
/* 1281 */     } else if (tipo.equals("SEDEMA")) {
/* 1282 */       ruta = this.CARPETAS.get("SEDEMA");
/* 1283 */     } else if (tipo.equals("NOM 012")) {
/* 1284 */       ruta = this.CARPETAS.get("NOM012");
/* 1285 */     } else if (tipo.equals("VERIFICACIÓN")) {
/* 1286 */       ruta = this.CARPETAS.get("VERIFICACION");
/* 1287 */     } else if (tipo.equals("FISICOMECÁNICA")) {
/* 1288 */       ruta = this.CARPETAS.get("FISICOMECANICA");
/* 1289 */     } else if (tipo.equals("SCT")) {
/* 1290 */       ruta = this.CARPETAS.get("SCT");
/* 1291 */     } else if (tipo.equals("PAGO")) {
/* 1292 */       ruta = this.CARPETAS.get("PAGOS");
/* 1293 */     } else if (tipo.equals("INSPECCIÓN")) {
/* 1294 */       ruta = this.CARPETAS.get("INSPECCION");
/*      */     } 
/*      */     
/* 1297 */     return ruta;
/*      */   }
/*      */   
/*      */   public void desabilitar() {
/* 1301 */     this.jTextField1.setEditable(false);
/* 1302 */     this.jTextField2.setEnabled(false);
/* 1303 */     this.jTextField3.setEnabled(false);
/* 1304 */     this.jTextField4.setEnabled(false);
/* 1305 */     this.jTextField5.setEnabled(false);
/* 1306 */     this.jTextField6.setEnabled(false);
/* 1307 */     this.jComboBox1.setEnabled(false);
/* 1308 */     this.jComboBox2.setEnabled(false);
/* 1309 */     this.jDateChooser2.setEnabled(false);
/* 1310 */     this.jDateChooser3.setEnabled(false);
/* 1311 */     this.jDateChooser4.setEnabled(false);
/* 1312 */     this.jFormattedTextField1.setEnabled(false);
/* 1313 */     this.jButton56.setEnabled(false);
/* 1314 */     this.jButton57.setEnabled(false);
/* 1315 */     this.materialButton40.setEnabled(false);
/* 1316 */     this.jEditorPane1.setEnabled(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGUARDAR() {
/* 1323 */     return this.GUARDAR;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGUARDAR(String GUARDAR) {
/* 1330 */     this.GUARDAR = GUARDAR;
/*      */   }
/*      */   
/*      */   public void verTablaDocs() {
/* 1334 */     if (this.TIPOV.equals("")) {
/* 1335 */       this.TIPOV = "TRACTO";
/*      */     }
/* 1337 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.TABLA, new String[] { "ID", "Información", "Número", "Vencimiento", "Estado" }, "unidadesdocumentos.numDoc, unidadesdocumentos.tipo, unidadesdocumentos.numeroUnico,unidadesdocumentos.fechaVencimiento, unidadesdocumentos.estado", "unidadesdocumentos, unidadesdoctractos", "where unidadesdoctractos.tipo = '" + this.TIPOV + "' and unidadesdocumentos.numDoc = unidadesdoctractos.numDoc and num_tracto = " + this.NUMTRACTO + " order by unidadesdocumentos.numDoc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1344 */     this.utilerias.pintarTablaReg((JTable)this.TABLA, this.celda1);
/* 1345 */     this.utilerias.ajustarTamañoTabla((JTable)this.TABLA, 0, 50);
/* 1346 */     this.utilerias.ajustarTamañoTabla((JTable)this.TABLA, 3, 80);
/* 1347 */     this.utilerias.ajustarTamañoTabla((JTable)this.TABLA, 4, 60);
/* 1348 */     this.TABLA.setFont(new Font("Cantarell", 0, 10));
/* 1349 */     this.TABLA.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void visualizarListadoDoc() {
/* 1353 */     this.DOCUMENTACION.forEach((x, y) -> this.utilerias.agregarCampoTablas(new String[] { y.getInformacion().getID(), y.getInformacion().getTipo(), y.getInformacion().getNumUnico(), y.getInformacion().getfVencimiento(), y.getInformacion().getEstado() }, (JTable)this.TABLA));
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
/*      */   public String[] getlistaEcos() {
/* 1367 */     String[] reg = new String[this.rSTableMetro3.getRowCount()];
/* 1368 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 1369 */       reg[i] = this.rSTableMetro3.getValueAt(i, 0).toString();
/*      */     }
/* 1371 */     return reg;
/*      */   }
/*      */   
/*      */   public Date desplazarMeses(Date fechaAnterior, int mes) {
/* 1375 */     Calendar calendar = Calendar.getInstance();
/* 1376 */     calendar.setTime(fechaAnterior);
/* 1377 */     calendar.setTimeInMillis(System.currentTimeMillis());
/* 1378 */     calendar.add(2, mes);
/* 1379 */     return calendar.getTime();
/*      */   }
/*      */   
/*      */   public void recibeDocumentacion(Map<String, UnidadesTractosDoc> DOCUMENTACION) {
/* 1383 */     this.DOCUMENTACION = DOCUMENTACION;
/*      */   }
/*      */   
/*      */   public void recibeDatos(String NUMTRACTO, String CLAVEDOC) {
/* 1387 */     this.NUMTRACTO = NUMTRACTO;
/* 1388 */     this.CLAVEDOC = CLAVEDOC;
/*      */   }
/*      */   
/*      */   public void recibeTipoV(String TIPOV) {
/* 1392 */     this.TIPOV = TIPOV;
/*      */   }
/*      */   
/*      */   public void activarVentana() {
/* 1396 */     int w = this.tama.width;
/* 1397 */     int h = this.tama.height;
/* 1398 */     int rw = (w - 900) / 2;
/* 1399 */     int rh = (h - 650) / 2;
/* 1400 */     setLocation(rw, rh);
/* 1401 */     setSize(900, 650);
/* 1402 */     setResizable(false);
/* 1403 */     setVisible(true);
/*      */   }
/*      */   
/*      */   public void consultarDoc(String CLAVEDOC) {
/* 1407 */     this.CLAVEDOC = CLAVEDOC;
/* 1408 */     String[] datos = this.con2.regresaRegIndex("fechaCaptura, fechaTramite, numeroUnico, periodoVencimiento, fechaInicio, fechaVencimiento, dependencia, costo, dirTramite, telefono, comentarios, estado, usuario", "unidadesdocumentos", "where numDoc= " + CLAVEDOC);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1415 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(datos[0]));
/*      */     
/* 1417 */     this.jDateChooser2.setDate(this.utilerias.convertirFechaStringADate(datos[1]));
/* 1418 */     this.jTextField2.setText(datos[2]);
/* 1419 */     this.jComboBox1.setSelectedItem(datos[3]);
/* 1420 */     this.jDateChooser3.setDate(this.utilerias.convertirFechaStringADate(datos[4]));
/* 1421 */     this.jDateChooser4.setDate(this.utilerias.convertirFechaStringADate(datos[5]));
/* 1422 */     this.jTextField3.setText(datos[6]);
/* 1423 */     this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(datos[7])));
/* 1424 */     this.jTextField4.setText(datos[8]);
/* 1425 */     this.jTextField5.setText(datos[9]);
/* 1426 */     this.jEditorPane1.setText(datos[10]);
/* 1427 */     this.jComboBox2.setSelectedItem(datos[11]);
/*      */     
/* 1429 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro1, new String[] { "Núm", "Archivo", "Tipo", "Act" }, "numArch, nombreArch, tipo, fecha", "unidadesarchivos", "where numDoc = " + CLAVEDOC);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1434 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 1435 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 35);
/* 1436 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 70);
/*      */     
/* 1438 */     consultarMismos();
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 1442 */     this.pintar.colorear(this.jTextField1);
/* 1443 */     this.pintar.colorear(this.jTextField2);
/* 1444 */     this.pintar.colorear(this.jTextField3);
/* 1445 */     this.pintar.colorear(this.jTextField4);
/* 1446 */     this.pintar.colorear(this.jTextField5);
/* 1447 */     this.pintar.colorear(this.jTextField6);
/* 1448 */     this.pintar.colorear(this.jComboBox1);
/* 1449 */     this.pintar.colorear(this.jFormattedTextField1);
/* 1450 */     this.pintar.colorear(this.jEditorPane1);
/*      */   }
/*      */   
/*      */   public void cargarDatos(Informacion inf) {
/* 1454 */     this.jTextField1.setText(inf.getTipo());
/* 1455 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(inf.getfCaptura()));
/* 1456 */     this.jDateChooser2.setDate(this.utilerias.convertirFechaStringADate(inf.getFtramite()));
/* 1457 */     this.jTextField2.setText(inf.getNumUnico());
/* 1458 */     this.jComboBox1.setSelectedItem(inf.getpVencimiento());
/* 1459 */     this.jDateChooser3.setDate(this.utilerias.convertirFechaStringADate(inf.getFinicio()));
/* 1460 */     this.jDateChooser4.setDate(this.utilerias.convertirFechaStringADate(inf.getfVencimiento()));
/* 1461 */     this.jTextField3.setText(inf.getDependencia());
/* 1462 */     this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(inf.getCosto())));
/* 1463 */     this.jTextField4.setText(inf.getDirTramite());
/* 1464 */     this.jTextField5.setText(inf.getTel());
/* 1465 */     this.jEditorPane1.setText(inf.getComentarios());
/* 1466 */     this.jTextField1.setEditable(true);
/* 1467 */     this.jComboBox2.setSelectedItem(inf.getEstado());
/* 1468 */     this.Documentos = ((UnidadesTractosDoc)this.DOCUMENTACION.get(getInformacion().getTipo())).Documentos;
/* 1469 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro1);
/* 1470 */     this.Documentos.forEach((x, y) -> this.utilerias.agregarCampoTablas(new String[] { y.getNum(), y.getArchivo(), y.getTipo(), y.getAct() }, (JTable)this.rSTableMetro1));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1475 */     setVisible(true);
/*      */   }
/*      */   
/*      */   public Informacion getInformacion() {
/* 1479 */     return this.inf;
/*      */   }
/*      */   
/*      */   public Map<String, Documentos> getDocumentos() {
/* 1483 */     return this.Documentos;
/*      */   }
/*      */   
/*      */   public void cargarArchivo() {
/* 1487 */     JFileChooser selector = new JFileChooser();
/* 1488 */     selector.setDialogTitle("Seleccione el archivo");
/* 1489 */     selector.setCurrentDirectory(new File(this.RUTAGRAL));
/* 1490 */     File file = null;
/* 1491 */     int flag = selector.showOpenDialog(null);
/* 1492 */     if (flag == 0) {
/* 1493 */       file = selector.getSelectedFile();
/*      */       
/* 1495 */       String nombre = file.getAbsolutePath();
/* 1496 */       this.RUTAGRAL = nombre;
/*      */       
/* 1498 */       String tipo = FilenameUtils.getExtension(nombre);
/*      */       
/* 1500 */       this.utilerias.agregarCampoTablas(new String[] { "", nombre, tipo.toLowerCase(), this.utilerias.convertirFechaDateString(new Date()) }, (JTable)this.rSTableMetro1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verDocumento() {
/* 1505 */     int ind = 0;
/* 1506 */     if (this.rSTableMetro1.getRowCount() != 1) {
/* 1507 */       ind = this.rSTableMetro1.getSelectedRow();
/*      */     }
/* 1509 */     this.jPanel83.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2), this.rSTableMetro1.getValueAt(ind, 1).toString(), 2, 0, new Font("Quicksand", 1, 12), this.lc.SECUNDARIO1));
/* 1510 */     this
/*      */       
/* 1512 */       .docs = new verDocumento(this.rSTableMetro1.getValueAt(ind, 1).toString(), this.rSTableMetro1.getValueAt(ind, 2).toString());
/*      */     
/* 1514 */     pintarPanel();
/* 1515 */     this.INDICEGRAL = ind;
/*      */   }
/*      */   
/*      */   public void ingresarCampos() {
/* 1519 */     this.CAMPOS.put("TARJETA DE CIRCULACIÓN", "TARJETA DE CIRCULACIÓN");
/* 1520 */     this.CAMPOS.put("PÓLIZA DE SEGURO", "PÓLIZA DE SEGURO");
/* 1521 */     this.CAMPOS.put("POLIZA", "POLIZA");
/* 1522 */     this.CAMPOS.put("SEDEMA", "SEDEMA");
/* 1523 */     this.CAMPOS.put("NOM 012", "NOM 012");
/* 1524 */     this.CAMPOS.put("VERIFICACIÓN", "VERIFICACIÓN");
/* 1525 */     this.CAMPOS.put("FISICOMECÁNICA", "FISICOMECÁNICA");
/* 1526 */     this.CAMPOS.put("SCT", "SCT");
/* 1527 */     this.CAMPOS.put("INSPECCIÓN", "INSPECCIÓN");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void limpiarPanelDer() {
/* 1533 */     this.jPanel83.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2), "Vista Previa", 2, 0, new Font("Quicksand", 1, 12), this.lc.SECUNDARIO1));
/* 1534 */     this.jPanel83.removeAll();
/* 1535 */     this.jPanel83.repaint();
/*      */   }
/*      */   
/*      */   protected JRootPane createRootPane() {
/* 1539 */     JRootPane rootPane = new JRootPane();
/* 1540 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 1541 */     Action actionListener = new AbstractAction() {
/*      */         public void actionPerformed(ActionEvent actionEvent) {
/* 1543 */           UnidadesTractosDoc.this.setVisible(false);
/*      */         }
/*      */       };
/* 1546 */     InputMap inputMap = rootPane.getInputMap(2);
/* 1547 */     inputMap.put(stroke, "ESCAPE");
/* 1548 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 1549 */     return rootPane;
/*      */   }
/*      */   
/*      */   public void pintarPanel() {
/* 1553 */     this.jPanel83.removeAll();
/* 1554 */     GroupLayout jPanel83Layout = new GroupLayout(this.jPanel83);
/* 1555 */     this.jPanel83.setLayout(jPanel83Layout);
/* 1556 */     jPanel83Layout.setHorizontalGroup(jPanel83Layout
/* 1557 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1558 */         .addComponent((Component)this.docs, -1, -1, 32767));
/*      */     
/* 1560 */     jPanel83Layout.setVerticalGroup(jPanel83Layout
/* 1561 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1562 */         .addComponent((Component)this.docs, -1, -1, 32767));
/*      */     
/* 1564 */     this.jPanel83.repaint();
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 1568 */     String eco = "";
/* 1569 */     if (!this.jTextField6.getText().equals(this.holderEco)) {
/* 1570 */       eco = this.jTextField6.getText();
/*      */     }
/*      */     
/* 1573 */     if (this.TIPOV.equals("")) {
/* 1574 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro2, new String[] { "Eco", "Marca", "Modelo", "Serie", "Placas" }, "num_tracto, marca, modelo, no_serie, placas", "tracto", "where num_tracto like '%" + eco + "%' and num_tracto<>0  order by num_tracto asc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1581 */     else if (this.TIPOV.equals("REM")) {
/* 1582 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro2, new String[] { "Eco", "Marca", "Modelo", "Serie", "Placas" }, "num_rem, marca, modelo, no_serie, placas", "remolque", "where num_rem like '%" + eco + "%' and num_rem<>0  order by num_rem asc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1591 */     else if (this.TIPOV.equals("DOLLY")) {
/* 1592 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro2, new String[] { "#", "Eco", "Marca", "Modelo", "Serie", "Placas" }, "idDolly, ecoDolly, marca, modelo, no_serie, placas", "dollys", "where ecoDolly like '%" + eco + "%' and ecoDolly<>0  order by ecoDolly asc");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1600 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 60);
/*      */     
/* 1602 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 2, 60);
/* 1603 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3);
/*      */     
/* 1605 */     this.jLabel3.setText("Total: " + this.rSTableMetro3.getRowCount());
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultarMismos() {
/* 1610 */     if (this.TIPOV.equals("")) {
/* 1611 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro3, new String[] { "Eco", "Marca", "Modelo", "Serie", "Placas" }, "tracto.num_tracto, marca, modelo, no_serie, placas", "tracto, unidadesdoctractos", "where tracto.num_tracto = unidadesdoctractos.num_tracto and numDoc = " + this.CLAVEDOC + " order by tracto.num_tracto asc");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1617 */     else if (this.TIPOV.equals("REM")) {
/* 1618 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro3, new String[] { "Eco", "Marca", "Modelo", "Serie", "Placas" }, "remolque.num_rem, marca, modelo, no_serie, placas", "remolque, unidadesdoctractos", "where remolque.num_rem = unidadesdoctractos.num_tracto and numDoc = " + this.CLAVEDOC + " order by remolque.num_rem asc");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1626 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 60);
/* 1627 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 2, 60);
/* 1628 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3, this.celda2);
/*      */     
/* 1630 */     this.jLabel3.setText("Total: " + this.rSTableMetro3.getRowCount());
/* 1631 */     this.materialButton42.setText("Asignar a grupo de Económicos: " + this.rSTableMetro3.getRowCount());
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 1636 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1639 */       setEnabled((table == null || table.isEnabled()));
/*      */       
/* 1641 */       if (row % 2 == 0) {
/* 1642 */         setBackground(UnidadesTractosDoc.this.lc.FONDOTABLA);
/*      */       } else {
/* 1644 */         setBackground((Color)null);
/*      */       } 
/* 1646 */       setForeground(UnidadesTractosDoc.this.lc.SECUNDARIO1);
/* 1647 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1648 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender2() {
/* 1654 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1657 */       setEnabled((table == null || table.isEnabled()));
/* 1658 */       if (column == 0 || column == 1 || column == 2) {
/* 1659 */         setHorizontalAlignment(4);
/*      */       } else {
/* 1661 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 1664 */       if (row % 2 == 0) {
/* 1665 */         setBackground(UnidadesTractosDoc.this.lc.FONDOTABLA);
/*      */       } else {
/* 1667 */         setBackground((Color)null);
/*      */       } 
/* 1669 */       setForeground(UnidadesTractosDoc.this.lc.SECUNDARIO1);
/* 1670 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1671 */       return this;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Informacion
/*      */   {
/*      */     private String ID;
/*      */     private String tipo;
/*      */     private String fCaptura;
/*      */     private String numUnico;
/*      */     private String pVencimiento;
/*      */     private String ftramite;
/*      */     private String finicio;
/*      */     private String fVencimiento;
/*      */     private String dependencia;
/*      */     private String costo;
/*      */     private String dirTramite;
/*      */     private String tel;
/*      */     private String comentarios;
/*      */     private String estado;
/*      */     
/*      */     public String getEstado() {
/* 1693 */       return this.estado;
/*      */     }
/*      */     
/*      */     public void setEstado(String estado) {
/* 1697 */       this.estado = estado;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getID() {
/* 1704 */       return this.ID;
/*      */     }
/*      */     
/*      */     public void setID(String ID) {
/* 1708 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getTipo() {
/* 1712 */       return this.tipo;
/*      */     }
/*      */     
/*      */     public void setTipo(String tipo) {
/* 1716 */       this.tipo = tipo;
/*      */     }
/*      */     
/*      */     public String getfCaptura() {
/* 1720 */       return this.fCaptura;
/*      */     }
/*      */     
/*      */     public void setfCaptura(String fCaptura) {
/* 1724 */       this.fCaptura = fCaptura;
/*      */     }
/*      */     
/*      */     public String getNumUnico() {
/* 1728 */       return this.numUnico;
/*      */     }
/*      */     
/*      */     public void setNumUnico(String numUnico) {
/* 1732 */       this.numUnico = numUnico;
/*      */     }
/*      */     
/*      */     public String getpVencimiento() {
/* 1736 */       return this.pVencimiento;
/*      */     }
/*      */     
/*      */     public void setpVencimiento(String pVencimiento) {
/* 1740 */       this.pVencimiento = pVencimiento;
/*      */     }
/*      */     
/*      */     public String getFtramite() {
/* 1744 */       return this.ftramite;
/*      */     }
/*      */     
/*      */     public void setFtramite(String ftramite) {
/* 1748 */       this.ftramite = ftramite;
/*      */     }
/*      */     
/*      */     public String getFinicio() {
/* 1752 */       return this.finicio;
/*      */     }
/*      */     
/*      */     public void setFinicio(String finicio) {
/* 1756 */       this.finicio = finicio;
/*      */     }
/*      */     
/*      */     public String getfVencimiento() {
/* 1760 */       return this.fVencimiento;
/*      */     }
/*      */     
/*      */     public void setfVencimiento(String fVencimiento) {
/* 1764 */       this.fVencimiento = fVencimiento;
/*      */     }
/*      */     
/*      */     public String getDependencia() {
/* 1768 */       return this.dependencia;
/*      */     }
/*      */     
/*      */     public void setDependencia(String dependencia) {
/* 1772 */       this.dependencia = dependencia;
/*      */     }
/*      */     
/*      */     public String getCosto() {
/* 1776 */       return this.costo;
/*      */     }
/*      */     
/*      */     public void setCosto(String costo) {
/* 1780 */       this.costo = costo;
/*      */     }
/*      */     
/*      */     public String getDirTramite() {
/* 1784 */       return this.dirTramite;
/*      */     }
/*      */     
/*      */     public void setDirTramite(String dirTramite) {
/* 1788 */       this.dirTramite = dirTramite;
/*      */     }
/*      */     
/*      */     public String getTel() {
/* 1792 */       return this.tel;
/*      */     }
/*      */     
/*      */     public void setTel(String tel) {
/* 1796 */       this.tel = tel;
/*      */     }
/*      */     
/*      */     public String getComentarios() {
/* 1800 */       return this.comentarios;
/*      */     }
/*      */     
/*      */     public void setComentarios(String comentarios) {
/* 1804 */       this.comentarios = comentarios;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Documentos
/*      */   {
/*      */     private String num;
/*      */     private String archivo;
/*      */     private String tipo;
/*      */     private String act;
/*      */     
/*      */     public Documentos(String num, String archivo, String tipo, String act) {
/* 1816 */       this.num = num;
/* 1817 */       this.archivo = archivo;
/* 1818 */       this.tipo = tipo;
/* 1819 */       this.act = act;
/*      */     }
/*      */ 
/*      */     
/*      */     public Documentos() {}
/*      */     
/*      */     public String getNum() {
/* 1826 */       return this.num;
/*      */     }
/*      */     
/*      */     public void setNum(String num) {
/* 1830 */       this.num = num;
/*      */     }
/*      */     
/*      */     public String getArchivo() {
/* 1834 */       return this.archivo;
/*      */     }
/*      */     
/*      */     public void setArchivo(String archivo) {
/* 1838 */       this.archivo = archivo;
/*      */     }
/*      */     
/*      */     public String getTipo() {
/* 1842 */       return this.tipo;
/*      */     }
/*      */     
/*      */     public void setTipo(String tipo) {
/* 1846 */       this.tipo = tipo;
/*      */     }
/*      */     
/*      */     public String getAct() {
/* 1850 */       return this.act;
/*      */     }
/*      */     
/*      */     public void setAct(String act) {
/* 1854 */       this.act = act;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UnidadesTractosDoc.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */