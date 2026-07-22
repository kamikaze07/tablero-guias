/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Insets;
/*      */ import java.awt.LayoutManager;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.nio.file.Path;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRootPane;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.JTextPane;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SpinnerNumberModel;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.filechooser.FileNameExtensionFilter;
/*      */ import principal.MaterialButton;
/*      */ import utilerias.Utilerias;
/*      */ import utilerias.pintarComponentes;
/*      */ 
/*      */ public class AlmProductosForm extends JDialog {
/*   51 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   52 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   53 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   54 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   55 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   56 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   57 */   Icon MODIFI = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/modificar.png")));
/*   58 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   59 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   63 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   64 */   Utilerias utilerias = new Utilerias();
/*      */   JFrame padre;
/*   66 */   String USUARIO = "";
/*      */   
/*      */   JTabbedPane fichas;
/*   69 */   Consultas2 con2 = new Consultas2();
/*   70 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   72 */   Fuentes fuentes = new Fuentes();
/*   73 */   PlaceHolder placeHolder = null;
/*   74 */   String holderId = "ID DEL PRODUCTO";
/*   75 */   String holderDesc = "DECRIPCIÓN";
/*   76 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean actualizado = false;
/*      */   boolean encontrado = false;
/*   79 */   TextAutoCompleter com_ListaCodigos = null;
/*      */   boolean entraPrimera = false;
/*      */   boolean PRIMERA = false;
/*      */   boolean entraModificarImagenes = false;
/*      */   EscribirReporte esc;
/*   84 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*      */   String[] CATEGORIAS;
/*      */   private int xx;
/*      */   private int xy;
/*   88 */   Date fechaActual = new Date();
/*   89 */   private String RUTAGRAL = "";
/*   90 */   String RUTAGUARDAR = "";
/*   91 */   String TIPOARCHIVO = "";
/*      */   String ID;
/*   93 */   String TIPO = ""; private JButton jButton3; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JCheckBox jCheckBox1; private JComboBox<String> jComboBox1; private JComboBox jComboBox20; private JComboBox<String> jComboBox6; private JComboBox<String> jComboBox7; private JComboBox<String> jComboBox8; private JComboBox<String> jComboBox9; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel135; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel52; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private JPanel jPanel100;
/*      */   private JPanel jPanel105;
/*      */   
/*      */   public AlmProductosForm(String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, String TIPO, boolean actualizado, String ID) {
/*  100 */     this.USUARIO = USUARIO;
/*  101 */     this.ID = ID;
/*  102 */     this.TIPO = TIPO;
/*      */     
/*  104 */     initComponents();
/*  105 */     colorear();
/*  106 */     if (this.tama.height > 950) {
/*  107 */       this.tama.height = 950;
/*      */     }
/*  109 */     this.utilerias.activarVentanajDialog(this, 987, this.tama.height - 30);
/*  110 */     this.utilerias.formatearAPesos(this.jFormattedTextField1);
/*  111 */     this.utilerias.formatearAPesos(this.jFormattedTextField2);
/*  112 */     this.utilerias.formatearAPesos(this.jFormattedTextField3);
/*  113 */     this.utilerias.formatearAPesos(this.jFormattedTextField4);
/*  114 */     desactivarImagenes();
/*      */     
/*  116 */     if (this.TIPO.equals("NUEVO")) {
/*  117 */       this.con2.consultar("direccion", "unidadescarpetas", "where tipo = 'PRODUCTOS'");
/*  118 */       this.RUTAGUARDAR = this.con2.Campo;
/*      */       
/*  120 */       this.con2.setBaseDatos("sicre2PR");
/*  121 */       llenarCombo();
/*  122 */       limpiar();
/*  123 */       this.jComboBox1.setEnabled(false);
/*  124 */       this.materialButton20.setText("Guardar");
/*  125 */       this.materialButton20.setToolTipText("Guardar (Alt + G)");
/*  126 */       this.materialButton20.setMnemonic('G');
/*  127 */       sacarMayor();
/*      */     } 
/*  129 */     if (this.TIPO.equals("VER")) {
/*  130 */       this.con2.setBaseDatos("sicre2PR");
/*  131 */       verProducto();
/*      */       
/*  133 */       this.materialButton20.setText("Ver");
/*      */       
/*  135 */       desactivar();
/*  136 */       this.materialButton20.setVisible(false);
/*  137 */       this.jButton6.setEnabled(false);
/*      */     } 
/*  139 */     if (this.TIPO.equals("MODIFICAR")) {
/*  140 */       this.con2.consultar("direccion", "unidadescarpetas", "where tipo = 'PRODUCTOS'");
/*  141 */       this.RUTAGUARDAR = this.con2.Campo;
/*      */       
/*  143 */       this.con2.setBaseDatos("sicre2PR");
/*  144 */       llenarCombo();
/*  145 */       limpiar();
/*  146 */       this.materialButton20.setText("Modificar");
/*  147 */       this.materialButton20.setToolTipText("Modificar (Alt + M)");
/*  148 */       this.materialButton20.setMnemonic('M');
/*  149 */       activarEtiqueta();
/*  150 */       verProducto();
/*      */     } 
/*      */     
/*  153 */     this.jButton3.setVisible(false);
/*  154 */     this.jButton5.setVisible(false);
/*  155 */     this.jButton7.setVisible(false);
/*      */     
/*  157 */     setLocationRelativeTo(null);
/*  158 */     setVisible(true);
/*  159 */     setResizable(true);
/*      */   }
/*      */   private JPanel jPanel108; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel36;
/*      */   private JPanel jPanel37;
/*      */   private JPanel jPanel38;
/*      */   private JPanel jPanel39;
/*      */   
/*      */   private void initComponents() {
/*  167 */     this.jLabel26 = new JLabel();
/*  168 */     this.jPanel105 = new JPanel();
/*  169 */     this.jPanel54 = new JPanel();
/*  170 */     this.jLabel52 = new JLabel();
/*  171 */     this.jPanel100 = new JPanel();
/*  172 */     this.jLabel135 = new JLabel();
/*  173 */     this.jLabel60 = new JLabel();
/*  174 */     this.jPanel2 = new JPanel();
/*  175 */     this.jPanel6 = new JPanel();
/*  176 */     this.jPanel3 = new JPanel();
/*  177 */     this.jLabel1 = new JLabel();
/*  178 */     this.jPanel4 = new JPanel();
/*  179 */     this.jLabel14 = new JLabel();
/*  180 */     this.jPanel7 = new JPanel();
/*  181 */     this.jPanel13 = new JPanel();
/*  182 */     this.jPanel14 = new JPanel();
/*  183 */     this.jLabel2 = new JLabel();
/*  184 */     this.jTextField3 = new JTextField();
/*  185 */     this.jPanel24 = new JPanel();
/*  186 */     this.jPanel25 = new JPanel();
/*  187 */     this.jPanel26 = new JPanel();
/*  188 */     this.jPanel27 = new JPanel();
/*  189 */     this.jPanel18 = new JPanel();
/*  190 */     this.jLabel3 = new JLabel();
/*  191 */     this.jComboBox20 = new JComboBox();
/*  192 */     this.jLabel4 = new JLabel();
/*  193 */     this.jComboBox6 = new JComboBox<>();
/*  194 */     this.jPanel28 = new JPanel();
/*  195 */     this.jPanel29 = new JPanel();
/*  196 */     this.jPanel19 = new JPanel();
/*  197 */     this.jLabel5 = new JLabel();
/*  198 */     this.jTextField4 = new JTextField();
/*  199 */     this.jPanel30 = new JPanel();
/*  200 */     this.jLabel19 = new JLabel();
/*  201 */     this.jTextField5 = new JTextField();
/*  202 */     this.jPanel21 = new JPanel();
/*  203 */     this.jLabel7 = new JLabel();
/*  204 */     this.jTextField6 = new JTextField();
/*  205 */     this.jLabel8 = new JLabel();
/*  206 */     this.jTextField7 = new JTextField();
/*  207 */     this.jPanel31 = new JPanel();
/*  208 */     this.jPanel32 = new JPanel();
/*  209 */     this.jPanel22 = new JPanel();
/*  210 */     this.jLabel9 = new JLabel();
/*  211 */     this.jComboBox7 = new JComboBox<>();
/*  212 */     this.jLabel10 = new JLabel();
/*  213 */     this.jComboBox8 = new JComboBox<>();
/*  214 */     this.jLabel11 = new JLabel();
/*  215 */     this.jComboBox9 = new JComboBox<>();
/*  216 */     this.jPanel23 = new JPanel();
/*  217 */     this.jLabel12 = new JLabel();
/*  218 */     this.jSpinner1 = new JSpinner();
/*  219 */     this.jLabel13 = new JLabel();
/*  220 */     this.jSpinner2 = new JSpinner();
/*  221 */     this.jPanel33 = new JPanel();
/*  222 */     this.jPanel34 = new JPanel();
/*  223 */     this.jPanel8 = new JPanel();
/*  224 */     this.jLabel15 = new JLabel();
/*  225 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  226 */     this.jCheckBox1 = new JCheckBox();
/*  227 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  228 */     this.jLabel17 = new JLabel();
/*  229 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  230 */     this.jLabel18 = new JLabel();
/*  231 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  232 */     this.jLabel20 = new JLabel();
/*  233 */     this.jPanel20 = new JPanel();
/*  234 */     this.jPanel38 = new JPanel();
/*  235 */     this.jLabel21 = new JLabel();
/*  236 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  237 */     this.jLabel22 = new JLabel();
/*  238 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  239 */     this.jLabel23 = new JLabel();
/*  240 */     this.jTextField8 = new JTextField();
/*  241 */     this.jPanel36 = new JPanel();
/*  242 */     this.jPanel37 = new JPanel();
/*  243 */     this.jButton3 = new JButton();
/*  244 */     this.jButton5 = new JButton();
/*  245 */     this.jButton6 = new JButton();
/*  246 */     this.jButton7 = new JButton();
/*  247 */     this.jLabel6 = new JLabel();
/*  248 */     this.jPanel39 = new JPanel();
/*  249 */     this.jPanel41 = new JPanel();
/*  250 */     this.jLabel25 = new JLabel();
/*  251 */     this.jPanel43 = new JPanel();
/*  252 */     this.jPanel44 = new JPanel();
/*  253 */     this.jLabel27 = new JLabel();
/*  254 */     this.jSpinner3 = new JSpinner();
/*  255 */     this.jPanel45 = new JPanel();
/*  256 */     this.jLabel28 = new JLabel();
/*  257 */     this.jPanel46 = new JPanel();
/*  258 */     this.jPanel47 = new JPanel();
/*  259 */     this.jLabel29 = new JLabel();
/*  260 */     this.jLabel30 = new JLabel();
/*  261 */     this.jPanel40 = new JPanel();
/*  262 */     this.jLabel24 = new JLabel();
/*  263 */     this.jScrollPane1 = new JScrollPane();
/*  264 */     this.jTextPane1 = new JTextPane();
/*  265 */     this.jLabel16 = new JLabel();
/*  266 */     this.jTextField1 = new JTextField();
/*  267 */     this.jPanel108 = new JPanel();
/*  268 */     this.materialButton19 = new MaterialButton();
/*  269 */     this.materialButton20 = new MaterialButton();
/*  270 */     this.jComboBox1 = new JComboBox<>();
/*      */     
/*  272 */     this.jLabel26.setFont(new Font("Cantarell", 0, 48));
/*  273 */     this.jLabel26.setHorizontalAlignment(0);
/*  274 */     this.jLabel26.setText("4");
/*  275 */     this.jLabel26.addMouseListener(new MouseAdapter() {
/*      */           public void mouseEntered(MouseEvent evt) {
/*  277 */             AlmProductosForm.this.jLabel26MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  281 */     setDefaultCloseOperation(2);
/*  282 */     setModal(true);
/*  283 */     setUndecorated(true);
/*      */     
/*  285 */     this.jPanel105.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/*  287 */     this.jPanel54.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  289 */     this.jLabel52.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  290 */     this.jLabel52.setForeground(new Color(255, 255, 255));
/*  291 */     this.jLabel52.setHorizontalAlignment(0);
/*  292 */     this.jLabel52.setText("Información del Producto");
/*  293 */     this.jLabel52.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  295 */             AlmProductosForm.this.jLabel52MouseDragged(evt);
/*      */           }
/*      */         });
/*  298 */     this.jLabel52.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  300 */             AlmProductosForm.this.jLabel52MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  304 */     this.jPanel100.setBackground(this.lc.PRIMARIO1);
/*  305 */     this.jPanel100.setLayout(new GridLayout(1, 0));
/*      */     
/*  307 */     this.jLabel135.setHorizontalAlignment(0);
/*  308 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  309 */     this.jLabel135.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  311 */             AlmProductosForm.this.jLabel135MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  314 */             AlmProductosForm.this.jLabel135MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  317 */             AlmProductosForm.this.jLabel135MouseExited(evt);
/*      */           }
/*      */         });
/*  320 */     this.jPanel100.add(this.jLabel135);
/*      */     
/*  322 */     this.jLabel60.setHorizontalAlignment(0);
/*  323 */     this.jLabel60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/box(1).png")));
/*      */     
/*  325 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/*  326 */     this.jPanel54.setLayout(jPanel54Layout);
/*  327 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/*  328 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  329 */         .addGroup(jPanel54Layout.createSequentialGroup()
/*  330 */           .addGap(1, 1, 1)
/*  331 */           .addComponent(this.jLabel60, -2, 36, -2)
/*  332 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  333 */           .addComponent(this.jLabel52, -1, -1, 32767)
/*  334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  335 */           .addComponent(this.jPanel100, -2, 34, -2)));
/*      */     
/*  337 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/*  338 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  339 */         .addComponent(this.jPanel100, -1, -1, 32767)
/*  340 */         .addGroup(jPanel54Layout.createSequentialGroup()
/*  341 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  342 */             .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  343 */             .addComponent(this.jLabel52, -1, 30, 32767))
/*  344 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  347 */     this.jPanel6.setLayout(new GridLayout(1, 2, 24, 0));
/*      */     
/*  349 */     this.jPanel3.setLayout((LayoutManager)null);
/*      */     
/*  351 */     this.jLabel1.setFont(new Font("Cantarell", 3, 15));
/*  352 */     this.jLabel1.setText(" Información del Producto");
/*  353 */     this.jPanel3.add(this.jLabel1);
/*  354 */     this.jLabel1.setBounds(0, 0, 230, 19);
/*      */     
/*  356 */     this.jPanel4.setBackground(this.lc.PRIMARIO1);
/*      */     
/*  358 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  359 */     this.jPanel4.setLayout(jPanel4Layout);
/*  360 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  361 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  362 */         .addGap(0, 1060, 32767));
/*      */     
/*  364 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  366 */         .addGap(0, 7, 32767));
/*      */ 
/*      */     
/*  369 */     this.jPanel3.add(this.jPanel4);
/*  370 */     this.jPanel4.setBounds(0, 18, 1060, 7);
/*      */     
/*  372 */     this.jLabel14.setFont(new Font("Cantarell", 3, 15));
/*  373 */     this.jLabel14.setText(" Precios");
/*  374 */     this.jPanel3.add(this.jLabel14);
/*  375 */     this.jLabel14.setBounds(0, 230, 130, 19);
/*      */     
/*  377 */     this.jPanel7.setBackground(this.lc.PRIMARIO1);
/*      */     
/*  379 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  380 */     this.jPanel7.setLayout(jPanel7Layout);
/*  381 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  382 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  383 */         .addGap(0, 1020, 32767));
/*      */     
/*  385 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  386 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  387 */         .addGap(0, 7, 32767));
/*      */ 
/*      */     
/*  390 */     this.jPanel3.add(this.jPanel7);
/*  391 */     this.jPanel7.setBounds(0, 250, 1020, 7);
/*      */     
/*  393 */     this.jPanel13.setLayout(new GridLayout(7, 0, 0, 6));
/*      */     
/*  395 */     this.jPanel14.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  397 */     this.jLabel2.setFont(new Font("Cantarell", 1, 15));
/*  398 */     this.jLabel2.setText(" ID");
/*  399 */     this.jPanel14.add(this.jLabel2);
/*      */     
/*  401 */     this.jTextField3.setEditable(false);
/*  402 */     this.jTextField3.setHorizontalAlignment(4);
/*  403 */     this.jTextField3.setText("jTextField3");
/*  404 */     this.jPanel14.add(this.jTextField3);
/*      */     
/*  406 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  407 */     this.jPanel24.setLayout(jPanel24Layout);
/*  408 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  409 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  410 */         .addGap(0, 158, 32767));
/*      */     
/*  412 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  413 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  414 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  417 */     this.jPanel14.add(this.jPanel24);
/*      */     
/*  419 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  420 */     this.jPanel25.setLayout(jPanel25Layout);
/*  421 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  422 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  423 */         .addGap(0, 158, 32767));
/*      */     
/*  425 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  426 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  427 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  430 */     this.jPanel14.add(this.jPanel25);
/*      */     
/*  432 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  433 */     this.jPanel26.setLayout(jPanel26Layout);
/*  434 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  435 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  436 */         .addGap(0, 158, 32767));
/*      */     
/*  438 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  440 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  443 */     this.jPanel14.add(this.jPanel26);
/*      */     
/*  445 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  446 */     this.jPanel27.setLayout(jPanel27Layout);
/*  447 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  449 */         .addGap(0, 158, 32767));
/*      */     
/*  451 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  452 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  453 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  456 */     this.jPanel14.add(this.jPanel27);
/*      */     
/*  458 */     this.jPanel13.add(this.jPanel14);
/*      */     
/*  460 */     this.jPanel18.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  462 */     this.jLabel3.setText(" Unidad de Medida");
/*  463 */     this.jPanel18.add(this.jLabel3);
/*      */     
/*  465 */     this.jComboBox20.setEditable(true);
/*  466 */     this.jPanel18.add(this.jComboBox20);
/*      */     
/*  468 */     this.jLabel4.setHorizontalAlignment(0);
/*  469 */     this.jLabel4.setText(" Tipo de Producto");
/*  470 */     this.jPanel18.add(this.jLabel4);
/*      */     
/*  472 */     this.jComboBox6.setBackground(new Color(255, 255, 255));
/*  473 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "ALMACENABLE", "CONSUMIBLE", "SERVICIO" }));
/*  474 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  476 */             AlmProductosForm.this.jComboBox6FocusLost(evt);
/*      */           }
/*      */         });
/*  479 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  481 */             AlmProductosForm.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  484 */     this.jPanel18.add(this.jComboBox6);
/*      */     
/*  486 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/*  487 */     this.jPanel28.setLayout(jPanel28Layout);
/*  488 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/*  489 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  490 */         .addGap(0, 158, 32767));
/*      */     
/*  492 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/*  493 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  494 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  497 */     this.jPanel18.add(this.jPanel28);
/*      */     
/*  499 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/*  500 */     this.jPanel29.setLayout(jPanel29Layout);
/*  501 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/*  502 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  503 */         .addGap(0, 158, 32767));
/*      */     
/*  505 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/*  506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  507 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  510 */     this.jPanel18.add(this.jPanel29);
/*      */     
/*  512 */     this.jPanel13.add(this.jPanel18);
/*      */     
/*  514 */     this.jPanel19.setLayout(new GridBagLayout());
/*      */     
/*  516 */     this.jLabel5.setText(" Desc. Interna *");
/*  517 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  518 */     gridBagConstraints.gridx = 0;
/*  519 */     gridBagConstraints.gridy = 0;
/*  520 */     gridBagConstraints.fill = 1;
/*  521 */     gridBagConstraints.anchor = 21;
/*  522 */     this.jPanel19.add(this.jLabel5, gridBagConstraints);
/*      */     
/*  524 */     this.jTextField4.setText("jTextField4");
/*  525 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  527 */             AlmProductosForm.this.jTextField4FocusLost(evt);
/*      */           }
/*      */         });
/*  530 */     gridBagConstraints = new GridBagConstraints();
/*  531 */     gridBagConstraints.gridx = 2;
/*  532 */     gridBagConstraints.gridy = 0;
/*  533 */     gridBagConstraints.fill = 1;
/*  534 */     gridBagConstraints.anchor = 18;
/*  535 */     gridBagConstraints.weightx = 1.0D;
/*  536 */     gridBagConstraints.weighty = 1.0D;
/*  537 */     gridBagConstraints.insets = new Insets(0, 96, 0, 6);
/*  538 */     this.jPanel19.add(this.jTextField4, gridBagConstraints);
/*      */     
/*  540 */     this.jPanel13.add(this.jPanel19);
/*      */     
/*  542 */     this.jPanel30.setLayout(new GridBagLayout());
/*      */     
/*  544 */     this.jLabel19.setText(" Desc. del Proveedor");
/*  545 */     gridBagConstraints = new GridBagConstraints();
/*  546 */     gridBagConstraints.gridx = 0;
/*  547 */     gridBagConstraints.gridy = 0;
/*  548 */     gridBagConstraints.fill = 1;
/*  549 */     gridBagConstraints.anchor = 21;
/*  550 */     this.jPanel30.add(this.jLabel19, gridBagConstraints);
/*      */     
/*  552 */     this.jTextField5.setText("jTextField5");
/*  553 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  555 */             AlmProductosForm.this.jTextField5FocusLost(evt);
/*      */           }
/*      */         });
/*  558 */     gridBagConstraints = new GridBagConstraints();
/*  559 */     gridBagConstraints.gridx = 2;
/*  560 */     gridBagConstraints.gridy = 0;
/*  561 */     gridBagConstraints.fill = 1;
/*  562 */     gridBagConstraints.anchor = 12;
/*  563 */     gridBagConstraints.weightx = 1.0D;
/*  564 */     gridBagConstraints.weighty = 1.0D;
/*  565 */     gridBagConstraints.insets = new Insets(0, 65, 0, 6);
/*  566 */     this.jPanel30.add(this.jTextField5, gridBagConstraints);
/*      */     
/*  568 */     this.jPanel13.add(this.jPanel30);
/*      */     
/*  570 */     this.jPanel21.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  572 */     this.jLabel7.setText(" Ref Interna *");
/*  573 */     this.jPanel21.add(this.jLabel7);
/*      */     
/*  575 */     this.jTextField6.setText("jTextField6");
/*  576 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  578 */             AlmProductosForm.this.jTextField6FocusLost(evt);
/*      */           }
/*      */         });
/*  581 */     this.jPanel21.add(this.jTextField6);
/*      */     
/*  583 */     this.jLabel8.setHorizontalAlignment(0);
/*  584 */     this.jLabel8.setText(" Ref del Proveedor ");
/*  585 */     this.jPanel21.add(this.jLabel8);
/*      */     
/*  587 */     this.jTextField7.setText("jTextField7");
/*  588 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  590 */             AlmProductosForm.this.jTextField7FocusLost(evt);
/*      */           }
/*      */         });
/*  593 */     this.jPanel21.add(this.jTextField7);
/*      */     
/*  595 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/*  596 */     this.jPanel31.setLayout(jPanel31Layout);
/*  597 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/*  598 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */         .addGap(0, 158, 32767));
/*      */     
/*  601 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/*  602 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  603 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  606 */     this.jPanel21.add(this.jPanel31);
/*      */     
/*  608 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/*  609 */     this.jPanel32.setLayout(jPanel32Layout);
/*  610 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/*  611 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  612 */         .addGap(0, 158, 32767));
/*      */     
/*  614 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/*  615 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  616 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  619 */     this.jPanel21.add(this.jPanel32);
/*      */     
/*  621 */     this.jPanel13.add(this.jPanel21);
/*      */     
/*  623 */     this.jPanel22.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  625 */     this.jLabel9.setText(" Categoría 1");
/*  626 */     this.jPanel22.add(this.jLabel9);
/*      */     
/*  628 */     this.jComboBox7.setBackground(new Color(255, 255, 255));
/*  629 */     this.jPanel22.add(this.jComboBox7);
/*      */     
/*  631 */     this.jLabel10.setHorizontalAlignment(0);
/*  632 */     this.jLabel10.setText(" Categoría 2");
/*  633 */     this.jPanel22.add(this.jLabel10);
/*      */     
/*  635 */     this.jComboBox8.setBackground(new Color(255, 255, 255));
/*  636 */     this.jPanel22.add(this.jComboBox8);
/*      */     
/*  638 */     this.jLabel11.setHorizontalAlignment(0);
/*  639 */     this.jLabel11.setText("Categoría 3");
/*  640 */     this.jPanel22.add(this.jLabel11);
/*      */     
/*  642 */     this.jComboBox9.setBackground(new Color(255, 255, 255));
/*  643 */     this.jPanel22.add(this.jComboBox9);
/*      */     
/*  645 */     this.jPanel13.add(this.jPanel22);
/*      */     
/*  647 */     this.jPanel23.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  649 */     this.jLabel12.setText(" Stock Min");
/*  650 */     this.jPanel23.add(this.jLabel12);
/*      */     
/*  652 */     this.jSpinner1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/*  653 */     this.jPanel23.add(this.jSpinner1);
/*      */     
/*  655 */     this.jLabel13.setHorizontalAlignment(0);
/*  656 */     this.jLabel13.setText(" Stock Max");
/*  657 */     this.jPanel23.add(this.jLabel13);
/*      */     
/*  659 */     this.jSpinner2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/*  660 */     this.jPanel23.add(this.jSpinner2);
/*      */     
/*  662 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  663 */     this.jPanel33.setLayout(jPanel33Layout);
/*  664 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  665 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  666 */         .addGap(0, 158, 32767));
/*      */     
/*  668 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/*  669 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  670 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  673 */     this.jPanel23.add(this.jPanel33);
/*      */     
/*  675 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  676 */     this.jPanel34.setLayout(jPanel34Layout);
/*  677 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  678 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  679 */         .addGap(0, 158, 32767));
/*      */     
/*  681 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  682 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  683 */         .addGap(0, 22, 32767));
/*      */ 
/*      */     
/*  686 */     this.jPanel23.add(this.jPanel34);
/*      */     
/*  688 */     this.jPanel13.add(this.jPanel23);
/*      */     
/*  690 */     this.jPanel3.add(this.jPanel13);
/*  691 */     this.jPanel13.setBounds(0, 30, 980, 190);
/*      */     
/*  693 */     this.jPanel8.setLayout(new GridLayout(1, 8, 6, 0));
/*      */     
/*  695 */     this.jLabel15.setText(" Subtotal");
/*  696 */     this.jPanel8.add(this.jLabel15);
/*      */     
/*  698 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  699 */     this.jFormattedTextField1.setText("jFormattedTextField1");
/*  700 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  702 */             AlmProductosForm.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*  705 */     this.jPanel8.add(this.jFormattedTextField1);
/*      */     
/*  707 */     this.jCheckBox1.setText("Iva");
/*  708 */     this.jCheckBox1.setHorizontalAlignment(0);
/*  709 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  711 */             AlmProductosForm.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  714 */     this.jPanel8.add(this.jCheckBox1);
/*      */     
/*  716 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*  717 */     this.jFormattedTextField2.setText("jFormattedTextField2");
/*  718 */     this.jFormattedTextField2.setEnabled(false);
/*  719 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  721 */             AlmProductosForm.this.jFormattedTextField2FocusLost(evt);
/*      */           }
/*      */         });
/*  724 */     this.jPanel8.add(this.jFormattedTextField2);
/*      */     
/*  726 */     this.jLabel17.setHorizontalAlignment(0);
/*  727 */     this.jLabel17.setText("Retención");
/*  728 */     this.jPanel8.add(this.jLabel17);
/*      */     
/*  730 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*  731 */     this.jFormattedTextField3.setText("jFormattedTextField3");
/*  732 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  734 */             AlmProductosForm.this.jFormattedTextField3FocusLost(evt);
/*      */           }
/*      */         });
/*  737 */     this.jPanel8.add(this.jFormattedTextField3);
/*      */     
/*  739 */     this.jLabel18.setHorizontalAlignment(0);
/*  740 */     this.jLabel18.setText("Total");
/*  741 */     this.jPanel8.add(this.jLabel18);
/*      */     
/*  743 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/*  744 */     this.jFormattedTextField4.setText("jFormattedTextField4");
/*  745 */     this.jFormattedTextField4.setEnabled(false);
/*  746 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  748 */             AlmProductosForm.this.jFormattedTextField4FocusLost(evt);
/*      */           }
/*      */         });
/*  751 */     this.jPanel8.add(this.jFormattedTextField4);
/*      */     
/*  753 */     this.jPanel3.add(this.jPanel8);
/*  754 */     this.jPanel8.setBounds(0, 260, 980, 23);
/*      */     
/*  756 */     this.jLabel20.setFont(new Font("Cantarell", 3, 15));
/*  757 */     this.jLabel20.setText("Otros Datos");
/*  758 */     this.jPanel3.add(this.jLabel20);
/*  759 */     this.jLabel20.setBounds(0, 290, 130, 19);
/*      */     
/*  761 */     this.jPanel20.setBackground(this.lc.PRIMARIO1);
/*      */     
/*  763 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/*  764 */     this.jPanel20.setLayout(jPanel20Layout);
/*  765 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/*  766 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  767 */         .addGap(0, 1020, 32767));
/*      */     
/*  769 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/*  770 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  771 */         .addGap(0, 7, 32767));
/*      */ 
/*      */     
/*  774 */     this.jPanel3.add(this.jPanel20);
/*  775 */     this.jPanel20.setBounds(0, 310, 1020, 7);
/*      */     
/*  777 */     this.jPanel38.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  779 */     this.jLabel21.setText(" Última F. de Entrada");
/*  780 */     this.jPanel38.add(this.jLabel21);
/*      */     
/*  782 */     this.jDateChooser6.setDate(this.fechaActual);
/*  783 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  784 */     this.jDateChooser6.setEnabled(false);
/*  785 */     this.jDateChooser6.setIcon(this.icon);
/*  786 */     this.jDateChooser6.setMinSelectableDate(new Date(1257058862000L));
/*  787 */     this.jPanel38.add((Component)this.jDateChooser6);
/*      */     
/*  789 */     this.jLabel22.setHorizontalAlignment(0);
/*  790 */     this.jLabel22.setText("F. de Último Mov.");
/*  791 */     this.jPanel38.add(this.jLabel22);
/*      */     
/*  793 */     this.jDateChooser7.setDate(this.fechaActual);
/*  794 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  795 */     this.jDateChooser7.setEnabled(false);
/*  796 */     this.jDateChooser7.setIcon(this.icon);
/*  797 */     this.jDateChooser7.setMinSelectableDate(new Date(1257058862000L));
/*  798 */     this.jPanel38.add((Component)this.jDateChooser7);
/*      */     
/*  800 */     this.jLabel23.setHorizontalAlignment(0);
/*  801 */     this.jLabel23.setText("Último Movimiento");
/*  802 */     this.jPanel38.add(this.jLabel23);
/*      */     
/*  804 */     this.jTextField8.setText("jTextField8");
/*  805 */     this.jTextField8.setEnabled(false);
/*  806 */     this.jPanel38.add(this.jTextField8);
/*      */     
/*  808 */     this.jPanel3.add(this.jPanel38);
/*  809 */     this.jPanel38.setBounds(0, 320, 980, 23);
/*      */     
/*  811 */     this.jPanel37.setLayout((LayoutManager)null);
/*      */     
/*  813 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/flechaAzulDer.png")));
/*  814 */     this.jPanel37.add(this.jButton3);
/*  815 */     this.jButton3.setBounds(14, 50, 22, 48);
/*      */     
/*  817 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/flechaAzulIzq.png")));
/*  818 */     this.jPanel37.add(this.jButton5);
/*  819 */     this.jButton5.setBounds(274, 50, 22, 48);
/*      */     
/*  821 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  822 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  824 */             AlmProductosForm.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  827 */     this.jPanel37.add(this.jButton6);
/*  828 */     this.jButton6.setBounds(15, 138, 50, 26);
/*      */     
/*  830 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/*  831 */     this.jPanel37.add(this.jButton7);
/*  832 */     this.jButton7.setBounds(245, 138, 50, 26);
/*      */     
/*  834 */     this.jLabel6.setHorizontalAlignment(0);
/*  835 */     this.jLabel6.setVerticalAlignment(1);
/*  836 */     this.jLabel6.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/*  837 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  839 */             AlmProductosForm.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */         });
/*  842 */     this.jPanel37.add(this.jLabel6);
/*  843 */     this.jLabel6.setBounds(10, 0, 290, 170);
/*      */     
/*  845 */     this.jPanel39.setLayout(new GridLayout(1, 2, 15, 0));
/*      */     
/*  847 */     this.jPanel41.setLayout((LayoutManager)null);
/*      */     
/*  849 */     this.jLabel25.setHorizontalAlignment(0);
/*  850 */     this.jLabel25.setText("DISPONIBLES");
/*  851 */     this.jPanel41.add(this.jLabel25);
/*  852 */     this.jLabel25.setBounds(10, 10, 310, 19);
/*      */     
/*  854 */     this.jPanel43.setBackground(this.lc.PRIMARIO2);
/*      */     
/*  856 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/*  857 */     this.jPanel43.setLayout(jPanel43Layout);
/*  858 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/*  859 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  860 */         .addGap(0, 310, 32767));
/*      */     
/*  862 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/*  863 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  864 */         .addGap(0, 25, 32767));
/*      */ 
/*      */     
/*  867 */     this.jPanel41.add(this.jPanel43);
/*  868 */     this.jPanel43.setBounds(10, 30, 310, 25);
/*      */     
/*  870 */     this.jPanel44.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  872 */     this.jLabel27.setHorizontalAlignment(0);
/*  873 */     this.jLabel27.setText("Cantidad");
/*      */     
/*  875 */     this.jSpinner3.setFont(new Font("Cantarell", 0, 48));
/*  876 */     this.jSpinner3.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/*  877 */     this.jSpinner3.addChangeListener(new ChangeListener() {
/*      */           public void stateChanged(ChangeEvent evt) {
/*  879 */             AlmProductosForm.this.jSpinner3StateChanged(evt);
/*      */           }
/*      */         });
/*  882 */     this.jSpinner3.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  884 */             AlmProductosForm.this.jSpinner3FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  888 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/*  889 */     this.jPanel44.setLayout(jPanel44Layout);
/*  890 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/*  891 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  892 */         .addGroup(jPanel44Layout.createSequentialGroup()
/*  893 */           .addGap(21, 21, 21)
/*  894 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  895 */             .addComponent(this.jSpinner3, -2, 271, -2)
/*  896 */             .addComponent(this.jLabel27, -2, 263, -2))
/*  897 */           .addContainerGap(18, 32767)));
/*      */     
/*  899 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/*  900 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  901 */         .addGroup(jPanel44Layout.createSequentialGroup()
/*  902 */           .addGap(24, 24, 24)
/*  903 */           .addComponent(this.jSpinner3, -2, 73, -2)
/*  904 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  905 */           .addComponent(this.jLabel27)
/*  906 */           .addContainerGap()));
/*      */ 
/*      */     
/*  909 */     JComponent editor = this.jSpinner3.getEditor();
/*  910 */     JFormattedTextField textField = ((JSpinner.DefaultEditor)editor).getTextField();
/*  911 */     textField.setHorizontalAlignment(0);
/*      */     
/*  913 */     this.jPanel41.add(this.jPanel44);
/*  914 */     this.jPanel44.setBounds(10, 40, 310, 130);
/*      */     
/*  916 */     this.jPanel39.add(this.jPanel41);
/*      */     
/*  918 */     this.jPanel45.setLayout((LayoutManager)null);
/*      */     
/*  920 */     this.jLabel28.setHorizontalAlignment(0);
/*  921 */     this.jLabel28.setText("INVERSIÓN");
/*  922 */     this.jPanel45.add(this.jLabel28);
/*  923 */     this.jLabel28.setBounds(10, 10, 310, 19);
/*      */     
/*  925 */     this.jPanel46.setBackground(this.lc.PRIMARIO2);
/*      */     
/*  927 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/*  928 */     this.jPanel46.setLayout(jPanel46Layout);
/*  929 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/*  930 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  931 */         .addGap(0, 310, 32767));
/*      */     
/*  933 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/*  934 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  935 */         .addGap(0, 25, 32767));
/*      */ 
/*      */     
/*  938 */     this.jPanel45.add(this.jPanel46);
/*  939 */     this.jPanel46.setBounds(10, 30, 310, 25);
/*      */     
/*  941 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  943 */     this.jLabel29.setFont(new Font("Cantarell", 0, 48));
/*  944 */     this.jLabel29.setHorizontalAlignment(0);
/*  945 */     this.jLabel29.setText("$1,000,000");
/*  946 */     this.jLabel29.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  948 */             AlmProductosForm.this.jLabel29MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  952 */     this.jLabel30.setHorizontalAlignment(0);
/*  953 */     this.jLabel30.setText("Costo");
/*      */     
/*  955 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/*  956 */     this.jPanel47.setLayout(jPanel47Layout);
/*  957 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/*  958 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  959 */         .addGroup(jPanel47Layout.createSequentialGroup()
/*  960 */           .addGap(21, 21, 21)
/*  961 */           .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  962 */             .addComponent(this.jLabel29, -1, -1, 32767)
/*  963 */             .addComponent(this.jLabel30, -1, 263, 32767))
/*  964 */           .addContainerGap(26, 32767)));
/*      */     
/*  966 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/*  967 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  968 */         .addGroup(jPanel47Layout.createSequentialGroup()
/*  969 */           .addGap(14, 14, 14)
/*  970 */           .addComponent(this.jLabel29, -1, 85, 32767)
/*  971 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  972 */           .addComponent(this.jLabel30)
/*  973 */           .addContainerGap()));
/*      */ 
/*      */     
/*  976 */     this.jPanel45.add(this.jPanel47);
/*  977 */     this.jPanel47.setBounds(10, 40, 310, 130);
/*      */     
/*  979 */     this.jPanel39.add(this.jPanel45);
/*      */     
/*  981 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  982 */     this.jPanel36.setLayout(jPanel36Layout);
/*  983 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  984 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  985 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  986 */           .addComponent(this.jPanel37, -2, 300, -2)
/*  987 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  988 */           .addComponent(this.jPanel39, -1, 678, 32767)
/*  989 */           .addContainerGap()));
/*      */     
/*  991 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/*  992 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  993 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  994 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  995 */             .addComponent(this.jPanel39, -1, 173, 32767)
/*  996 */             .addComponent(this.jPanel37, -1, -1, 32767))
/*  997 */           .addGap(7, 7, 7)));
/*      */ 
/*      */     
/* 1000 */     this.jPanel3.add(this.jPanel36);
/* 1001 */     this.jPanel36.setBounds(0, 350, 990, 180);
/*      */     
/* 1003 */     this.jLabel24.setText("Notas o comentarios");
/*      */     
/* 1005 */     this.jTextPane1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1007 */             AlmProductosForm.this.jTextPane1FocusGained(evt);
/*      */           }
/*      */         });
/* 1010 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*      */     
/* 1012 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 1013 */     this.jPanel40.setLayout(jPanel40Layout);
/* 1014 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 1015 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1016 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 1017 */           .addContainerGap()
/* 1018 */           .addGroup(jPanel40Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1019 */             .addGroup(jPanel40Layout.createSequentialGroup()
/* 1020 */               .addComponent(this.jLabel24, -2, 185, -2)
/* 1021 */               .addGap(0, 780, 32767))
/* 1022 */             .addComponent(this.jScrollPane1))
/* 1023 */           .addContainerGap()));
/*      */     
/* 1025 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 1026 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1027 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 1028 */           .addContainerGap()
/* 1029 */           .addComponent(this.jLabel24)
/* 1030 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1031 */           .addComponent(this.jScrollPane1, -1, 37, 32767)
/* 1032 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1035 */     this.jLabel16.setText("Proveedor");
/*      */     
/* 1037 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1038 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1039 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1040 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1041 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1042 */           .addGap(995, 995, 995)
/* 1043 */           .addComponent(this.jPanel6, -1, -1, 32767))
/* 1044 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 1045 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1046 */           .addComponent(this.jPanel40, -2, -1, -2)
/* 1047 */           .addGap(0, 0, 32767))
/* 1048 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1049 */           .addContainerGap()
/* 1050 */           .addComponent(this.jLabel16, -2, 94, -2)
/* 1051 */           .addGap(59, 59, 59)
/* 1052 */           .addComponent(this.jTextField1)
/* 1053 */           .addContainerGap()));
/*      */     
/* 1055 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1056 */         .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1057 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1058 */           .addContainerGap()
/* 1059 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1060 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1061 */               .addGap(0, 0, 32767)
/* 1062 */               .addComponent(this.jPanel6, -2, -1, -2))
/* 1063 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1064 */               .addComponent(this.jPanel3, -2, 535, -2)
/* 1065 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1066 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1067 */                 .addComponent(this.jLabel16)
/* 1068 */                 .addComponent(this.jTextField1, -2, -1, -2))
/* 1069 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1070 */               .addComponent(this.jPanel40, -1, -1, 32767)))));
/*      */ 
/*      */     
/* 1073 */     this.jPanel108.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1075 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/* 1076 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/* 1077 */     this.materialButton19.setMnemonic('C');
/* 1078 */     this.materialButton19.setText("Cerrar");
/* 1079 */     this.materialButton19.setToolTipText("Cerrar (Alt+C)");
/* 1080 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/* 1081 */     this.materialButton19.setHorizontalTextPosition(0);
/* 1082 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1084 */             AlmProductosForm.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1088 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/* 1089 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 1090 */     this.materialButton20.setMnemonic('E');
/* 1091 */     this.materialButton20.setText("Guardar");
/* 1092 */     this.materialButton20.setToolTipText("Expedir CFDI (Alt+E)");
/* 1093 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 1094 */     this.materialButton20.setHorizontalTextPosition(0);
/* 1095 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1097 */             AlmProductosForm.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1101 */     this.jComboBox1.setBackground(new Color(255, 255, 255));
/* 1102 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "ELIMINADO" }));
/*      */     
/* 1104 */     GroupLayout jPanel108Layout = new GroupLayout(this.jPanel108);
/* 1105 */     this.jPanel108.setLayout(jPanel108Layout);
/* 1106 */     jPanel108Layout.setHorizontalGroup(jPanel108Layout
/* 1107 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1108 */         .addGroup(jPanel108Layout.createSequentialGroup()
/* 1109 */           .addContainerGap()
/* 1110 */           .addComponent(this.jComboBox1, -2, 195, -2)
/* 1111 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1112 */           .addComponent((Component)this.materialButton20, -2, 150, -2)
/* 1113 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1114 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/* 1115 */           .addContainerGap()));
/*      */     
/* 1117 */     jPanel108Layout.setVerticalGroup(jPanel108Layout
/* 1118 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1119 */         .addGroup(jPanel108Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1120 */           .addComponent((Component)this.materialButton19, -2, 38, -2)
/* 1121 */           .addComponent((Component)this.materialButton20, -2, 38, -2)
/* 1122 */           .addComponent(this.jComboBox1, -2, -1, -2)));
/*      */ 
/*      */     
/* 1125 */     GroupLayout jPanel105Layout = new GroupLayout(this.jPanel105);
/* 1126 */     this.jPanel105.setLayout(jPanel105Layout);
/* 1127 */     jPanel105Layout.setHorizontalGroup(jPanel105Layout
/* 1128 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1129 */         .addComponent(this.jPanel54, -1, -1, 32767)
/* 1130 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 1131 */         .addComponent(this.jPanel108, -1, -1, 32767));
/*      */     
/* 1133 */     jPanel105Layout.setVerticalGroup(jPanel105Layout
/* 1134 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1135 */         .addGroup(jPanel105Layout.createSequentialGroup()
/* 1136 */           .addComponent(this.jPanel54, -2, -1, -2)
/* 1137 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1138 */           .addComponent(this.jPanel2, -1, -1, 32767)
/* 1139 */           .addGap(12, 12, 12)
/* 1140 */           .addComponent(this.jPanel108, -2, -1, -2)));
/*      */ 
/*      */     
/* 1143 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1144 */     getContentPane().setLayout(layout);
/* 1145 */     layout.setHorizontalGroup(layout
/* 1146 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1147 */         .addComponent(this.jPanel105, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1149 */     layout.setVerticalGroup(layout
/* 1150 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1151 */         .addComponent(this.jPanel105, -1, -1, 32767));
/*      */ 
/*      */     
/* 1154 */     pack();
/*      */   }
/*      */   private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel54; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JScrollPane jScrollPane1; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JTextField jTextField1; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextPane jTextPane1; private MaterialButton materialButton19; private MaterialButton materialButton20;
/*      */   private void jLabel52MouseDragged(MouseEvent evt) {
/* 1158 */     int x = evt.getXOnScreen();
/* 1159 */     int y = evt.getYOnScreen();
/* 1160 */     setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel52MouseClicked(MouseEvent evt) {
/* 1164 */     this.xx = evt.getX();
/* 1165 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel135MouseClicked(MouseEvent evt) {
/* 1169 */     setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel135MouseEntered(MouseEvent evt) {
/* 1173 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel135MouseExited(MouseEvent evt) {
/* 1177 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 1181 */     setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 1185 */     calcularInversion();
/* 1186 */     int index7 = this.jComboBox7.getSelectedIndex();
/* 1187 */     int index8 = this.jComboBox8.getSelectedIndex();
/* 1188 */     int index9 = this.jComboBox9.getSelectedIndex();
/*      */     
/* 1190 */     String cat2 = "";
/* 1191 */     String cat3 = "";
/*      */     
/* 1193 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/* 1194 */       cat2 = this.jComboBox8.getSelectedItem().toString();
/*      */     }
/*      */     
/* 1197 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 1198 */       cat3 = this.jComboBox9.getSelectedItem().toString();
/*      */     }
/*      */     
/* 1201 */     if (this.jComboBox20.getSelectedItem().equals(""))
/* 1202 */     { this.jComboBox20.setBackground(Color.RED);
/* 1203 */       JOptionPane.showMessageDialog(this, "Falta agregar la Unidad de Medida", "Fala la Unidad de Medida", 0, this.ERROR); }
/* 1204 */     else if (this.jTextField4.getText().equals(""))
/* 1205 */     { this.jTextField4.setBackground(Color.RED);
/* 1206 */       JOptionPane.showMessageDialog(this, "Necesitas agregar la descripción interna del producto", "Fala la Descripción Interna", 0, this.ERROR); }
/* 1207 */     else { if (index7 <= 0) {
/* 1208 */         this.jComboBox7.setBackground(Color.RED);
/* 1209 */         JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una opcion en CATEGORÍA 1", "Falta la categoría", 0, this.ADVER); return;
/*      */       } 
/* 1211 */       if ((index8 > 0 && index8 == index7) || (index9 > 0 && (index9 == index7 || index9 == index8))) {
/* 1212 */         JOptionPane.showMessageDialog(this, "No puedes repetir las categorías seleccionadas", "Selecciona categorias diferentes", 0, this.ADVER);
/* 1213 */       } else if (this.utilerias.convertirCantTexto(this.jFormattedTextField4.getText()) <= 0.0D) {
/* 1214 */         this.jFormattedTextField4.setBackground(Color.RED);
/* 1215 */         JOptionPane.showMessageDialog(this, "Falta agregar el precio unitario", "Fala el precio", 0, this.ERROR);
/* 1216 */       } else if (this.materialButton20.getText().equals("Guardar")) {
/* 1217 */         this.encontrado = this.con2.consultar("descInterna", "alm_productos", "where descInterna = '" + this.jTextField4.getText() + "'");
/* 1218 */         if (this.encontrado) {
/* 1219 */           this.jTextField4.setBackground(Color.ORANGE);
/* 1220 */           JOptionPane.showMessageDialog(this, "La DESCRIPCIÓN que ingresaste ya existe en la base de datos, ingresa una diferente.", "Descripción Duplicada", 0, this.ERROR);
/*      */           return;
/*      */         } 
/* 1223 */         this.encontrado = this.con2.consultar("refInterna", "alm_productos", "where refInterna = '" + this.jTextField6.getText() + "'");
/* 1224 */         if (this.encontrado) {
/* 1225 */           this.jTextField6.setBackground(Color.ORANGE);
/* 1226 */           JOptionPane.showMessageDialog(this, "La REFERENCIA INTERNA que ingresaste ya existe en la base de datos, ingresa una diferente.", "Descripción Duplicada", 0, this.ERROR);
/*      */           
/*      */           return;
/*      */         } 
/* 1230 */         int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas CREAR el nuevo producto?", "Crear Producto", 0, 3, this.PREG);
/* 1231 */         if (res == 0) {
/* 1232 */           this.actualizado = true;
/* 1233 */           this.con2.inserSinMsj("insert into alm_productos ( unidadMed, tipoProd, descInterna, descProv, refInterna, refProv, compraSub, compraIva, compraRet, compraPrecio, stockMin, stockMax, cat1, cat2, cat3, fechaUltimaEntrada, fechaUltimoMov, ultimoMov, comentario, disponibles, inversion, estatus, actualizacion, proveedor) VALUES ('" + this.jComboBox20
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1243 */               .getSelectedItem().toString().toUpperCase() + "', '" + String.valueOf(this.jComboBox6.getSelectedItem()) + "', '" + this.jTextField4.getText().toUpperCase() + "', '" + this.jTextField5
/* 1244 */               .getText().toUpperCase() + "', '" + this.jTextField6.getText().toUpperCase() + "', '" + this.jTextField7.getText().toUpperCase() + "', '" + this.jFormattedTextField1
/* 1245 */               .getText() + "', '" + this.jFormattedTextField2.getText() + "', '" + this.jFormattedTextField3.getText() + "', '" + this.jFormattedTextField4
/* 1246 */               .getText() + "'," + String.valueOf(this.jSpinner1.getValue()) + ", " + String.valueOf(this.jSpinner2.getValue()) + ", '" + 
/* 1247 */               String.valueOf(this.jComboBox7.getSelectedItem()) + "', '" + cat2 + "', '" + cat3 + "', now(), now(), 'CREADO', '" + this.jTextPane1
/*      */               
/* 1249 */               .getText().toUpperCase() + "'," + String.valueOf(this.jSpinner3.getValue()) + " , '" + this.jLabel29.getText() + "', 'ACTIVO', '" + this.utilerias
/* 1250 */               .sacarUsuario(this.USUARIO) + "', '" + this.jTextField1.getText().toUpperCase() + "') ");
/*      */ 
/*      */           
/* 1253 */           if (!this.RUTAGRAL.equals("")) {
/* 1254 */             this.con2.inserSinMsj("inserT into alm_imagenes (ruta, idProd) VALUES ('" + this.RUTAGUARDAR + this.jTextField3
/*      */ 
/*      */                 
/* 1257 */                 .getText() + "." + this.TIPOARCHIVO + "', " + this.jTextField3.getText() + ")");
/*      */             
/* 1259 */             copiarArchivos(this.RUTAGRAL, this.RUTAGUARDAR + this.RUTAGUARDAR + "." + this.jTextField3.getText());
/*      */           } 
/* 1261 */           setVisible(false);
/*      */         } 
/*      */       } else {
/* 1264 */         this.encontrado = this.con2.consultar("descInterna", "alm_productos", "where idProd != " + this.jTextField3.getText() + " and descInterna = '" + this.jTextField4.getText() + "'");
/* 1265 */         if (this.encontrado) {
/* 1266 */           this.jTextField4.setBackground(Color.ORANGE);
/* 1267 */           JOptionPane.showMessageDialog(this, "La DESCRIPCIÓN que ingresaste ya existe en la base de datos, ingresa una diferente.", "Descripción Duplicada", 0, this.ERROR);
/*      */           
/*      */           return;
/*      */         } 
/* 1271 */         this.encontrado = this.con2.consultar("refInterna", "alm_productos", "where idProd != " + this.jTextField3.getText() + " and refInterna = '" + this.jTextField6.getText() + "'");
/* 1272 */         if (this.encontrado) {
/* 1273 */           this.jTextField6.setBackground(Color.ORANGE);
/* 1274 */           JOptionPane.showMessageDialog(this, "La DESCRIPCIÓN que ingresaste ya existe en la base de datos, ingresa una diferente.", "Descripción Duplicada", 0, this.ERROR);
/*      */           
/*      */           return;
/*      */         } 
/* 1278 */         int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas MODIFICAR el nuevo producto?", "Modificar Producto", 0, 3, this.MODIFI);
/* 1279 */         if (res == 0) {
/* 1280 */           this.actualizado = true;
/* 1281 */           Map<String, Object> fieldValues = new HashMap<>();
/* 1282 */           fieldValues.put("unidadMed", "'" + String.valueOf(this.jComboBox20.getSelectedItem()) + "'");
/* 1283 */           fieldValues.put("tipoProd", "'" + String.valueOf(this.jComboBox6.getSelectedItem()) + "'");
/* 1284 */           fieldValues.put("descInterna", "'" + this.jTextField4.getText().toUpperCase() + "'");
/* 1285 */           fieldValues.put("descProv", "'" + this.jTextField5.getText().toUpperCase() + "'");
/* 1286 */           fieldValues.put("refInterna", "'" + this.jTextField6.getText().toUpperCase() + "'");
/* 1287 */           fieldValues.put("refProv", "'" + this.jTextField7.getText().toUpperCase() + "'");
/* 1288 */           fieldValues.put("compraSub", "'" + this.jFormattedTextField1.getText() + "'");
/* 1289 */           fieldValues.put("compraIva", "'" + this.jFormattedTextField2.getText() + "'");
/* 1290 */           fieldValues.put("compraRet", "'" + this.jFormattedTextField3.getText() + "'");
/* 1291 */           fieldValues.put("compraPrecio", "'" + this.jFormattedTextField4.getText() + "'");
/* 1292 */           fieldValues.put("stockMin", this.jSpinner1.getValue());
/* 1293 */           fieldValues.put("stockMax", this.jSpinner2.getValue());
/* 1294 */           fieldValues.put("cat1", "'" + String.valueOf(this.jComboBox7.getSelectedItem()) + "'");
/* 1295 */           fieldValues.put("cat2", "'" + cat2 + "'");
/* 1296 */           fieldValues.put("cat3", "'" + cat3 + "'");
/* 1297 */           fieldValues.put("fechaUltimoMov", "'" + this.utilerias.convertirFechaDateString(this.jDateChooser7.getDate()) + "'");
/* 1298 */           fieldValues.put("ultimoMov", "'MODIFICADO'");
/* 1299 */           fieldValues.put("comentario", "'" + this.jTextPane1.getText().toUpperCase() + "'");
/* 1300 */           fieldValues.put("inversion", "'" + this.jLabel29.getText() + "'");
/* 1301 */           fieldValues.put("estatus", "'" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 1302 */           fieldValues.put("actualizacion", "'" + this.utilerias.sacarUsuario(this.USUARIO) + "'");
/* 1303 */           fieldValues.put("proveedor", "'" + this.jTextField1.getText().toUpperCase() + "'");
/* 1304 */           this.con2.actualizarReg("alm_productos", fieldValues, "WHERE idProd = " + this.jTextField3.getText());
/*      */           
/* 1306 */           if (this.entraModificarImagenes) {
/* 1307 */             this.con2.eliminar2("alm_imagenes", "WHERE idProd = " + this.jTextField3.getText());
/* 1308 */             this.con2.inserSinMsj("inserT into alm_imagenes (ruta, idProd) VALUES ('" + this.RUTAGUARDAR + this.jTextField3
/*      */ 
/*      */                 
/* 1311 */                 .getText() + "." + this.TIPOARCHIVO + "', " + this.jTextField3.getText() + ")");
/*      */             
/* 1313 */             copiarArchivos(this.RUTAGRAL, this.RUTAGUARDAR + this.RUTAGUARDAR + "." + this.jTextField3.getText());
/*      */           } 
/*      */           
/* 1316 */           setVisible(false);
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 1322 */     calcularImporte();
/* 1323 */     calcularInversion();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField2FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField3FocusLost(FocusEvent evt) {
/* 1331 */     calcularImporte();
/* 1332 */     calcularInversion();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField4FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 1340 */     calcularImporte();
/* 1341 */     calcularInversion();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1345 */     cargarArchivo();
/* 1346 */     this.entraModificarImagenes = true;
/*      */   }
/*      */   
/*      */   private void jComboBox6FocusLost(FocusEvent evt) {
/* 1350 */     System.out.println("pruebaa sale");
/*      */   }
/*      */   
/*      */   private void jLabel26MouseEntered(MouseEvent evt) {
/* 1354 */     this.utilerias.cargarMouse(this);
/*      */   }
/*      */   
/*      */   private void jSpinner3FocusLost(FocusEvent evt) {
/* 1358 */     calcularInversion();
/*      */   }
/*      */   
/*      */   private void jTextPane1FocusGained(FocusEvent evt) {
/* 1362 */     calcularInversion();
/*      */   }
/*      */   
/*      */   private void jLabel29MouseClicked(MouseEvent evt) {
/* 1366 */     calcularInversion();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/*      */     try {
/* 1371 */       File path = new File(this.RUTAGUARDAR);
/* 1372 */       Desktop.getDesktop().open(path);
/* 1373 */     } catch (IOException ex) {
/* 1374 */       ex.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 1379 */     if (this.jComboBox6.getSelectedIndex() == 2) {
/* 1380 */       this.jSpinner3.setValue(Integer.valueOf(1));
/* 1381 */       this.jSpinner3.setEnabled(false);
/* 1382 */       this.jSpinner1.setValue(Integer.valueOf(0));
/* 1383 */       this.jSpinner2.setValue(Integer.valueOf(0));
/* 1384 */       this.jSpinner1.setEnabled(false);
/* 1385 */       this.jSpinner2.setEnabled(false);
/*      */     } else {
/* 1387 */       this.jSpinner3.setValue(Integer.valueOf(0));
/* 1388 */       this.jSpinner3.setEnabled(true);
/* 1389 */       this.jSpinner1.setValue(Integer.valueOf(0));
/* 1390 */       this.jSpinner2.setValue(Integer.valueOf(0));
/* 1391 */       this.jSpinner1.setEnabled(true);
/* 1392 */       this.jSpinner2.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jSpinner3StateChanged(ChangeEvent evt) {
/* 1397 */     calcularInversion();
/*      */   }
/*      */   
/*      */   private void jTextField6FocusLost(FocusEvent evt) {
/* 1401 */     if (this.jTextField6.getText().contains("'")) {
/* 1402 */       this.jTextField6.setText(this.jTextField6.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField4FocusLost(FocusEvent evt) {
/* 1407 */     if (this.jTextField4.getText().contains("'")) {
/* 1408 */       this.jTextField4.setText(this.jTextField4.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField5FocusLost(FocusEvent evt) {
/* 1413 */     if (this.jTextField5.getText().contains("'")) {
/* 1414 */       this.jTextField5.setText(this.jTextField5.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField7FocusLost(FocusEvent evt) {
/* 1419 */     if (this.jTextField7.getText().contains("'")) {
/* 1420 */       this.jTextField7.setText(this.jTextField7.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */   
/*      */   public void verProducto() {
/* 1425 */     String[] datos = this.con2.regresaRegIndex("unidadMed,tipoProd,descInterna,descProv,refInterna,refProv,compraSub,compraIva,compraRet,compraPrecio,stockMin,stockMax,cat1,cat2,cat3,fechaUltimaEntrada,fechaUltimoMov,ultimoMov,comentario,disponibles,inversion,estatus, proveedor", "alm_productos", "where IdProd = " + this.ID);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1436 */     this.jTextField3.setText(this.ID);
/* 1437 */     this.jComboBox20.setSelectedItem(datos[0]);
/* 1438 */     this.jComboBox6.setSelectedItem(datos[1]);
/*      */     
/* 1440 */     this.jTextField4.setText(datos[2]);
/* 1441 */     this.jTextField5.setText(datos[3]);
/* 1442 */     this.jTextField6.setText(datos[4]);
/*      */     
/* 1444 */     this.jTextField7.setText(datos[5]);
/* 1445 */     this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(datos[6])));
/* 1446 */     if (!datos[7].equals("$0.00")) {
/* 1447 */       this.jCheckBox1.setSelected(true);
/* 1448 */       this.jFormattedTextField2.setValue(Double.valueOf(this.utilerias.convertirCantTexto(datos[7])));
/*      */     } else {
/* 1450 */       this.jCheckBox1.setSelected(false);
/* 1451 */       this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*      */     } 
/*      */     
/* 1454 */     System.out.println("datos 8 " + datos[8]);
/*      */     
/* 1456 */     this.jFormattedTextField3.setValue(Double.valueOf(this.utilerias.convertirCantTexto(datos[8])));
/* 1457 */     this.jFormattedTextField4.setValue(Double.valueOf(this.utilerias.convertirCantTexto(datos[9])));
/*      */     
/* 1459 */     this.jComboBox7.setSelectedItem(datos[12]);
/* 1460 */     this.jComboBox8.setSelectedItem(datos[13]);
/*      */     
/* 1462 */     this.jComboBox9.setSelectedItem(datos[14]);
/* 1463 */     this.jDateChooser6.setDate(this.utilerias.convertirFechaStringADate(datos[15]));
/* 1464 */     this.jDateChooser7.setDate(this.utilerias.convertirFechaStringADate(datos[16]));
/*      */     
/* 1466 */     this.jTextField8.setText(datos[17]);
/* 1467 */     this.jTextPane1.setText(datos[18]);
/* 1468 */     this.jLabel26.setText(datos[19]);
/*      */     
/* 1470 */     this.jLabel29.setText(datos[20]);
/* 1471 */     this.jComboBox1.setSelectedItem(datos[21]);
/*      */     
/* 1473 */     this.jTextField1.setText(datos[22]);
/*      */     
/* 1475 */     this.encontrado = this.con2.consultar("ruta", "alm_imagenes", "where idProd = " + this.ID);
/* 1476 */     if (this.encontrado) {
/* 1477 */       this.RUTAGUARDAR = this.con2.Campo;
/* 1478 */       verImagen(this.RUTAGUARDAR);
/*      */     } 
/*      */     
/* 1481 */     if (this.TIPO.equals("VER")) {
/* 1482 */       this.jComboBox20.addItem(datos[0]);
/* 1483 */       this.jComboBox20.setSelectedItem(datos[0]);
/*      */       
/* 1485 */       this.jComboBox6.addItem(datos[1]);
/* 1486 */       this.jComboBox6.setSelectedItem(datos[1]);
/*      */       
/* 1488 */       this.jComboBox7.addItem(datos[12]);
/* 1489 */       this.jComboBox7.setSelectedItem(datos[12]);
/*      */       
/* 1491 */       this.jComboBox8.addItem(datos[13]);
/* 1492 */       this.jComboBox8.setSelectedItem(datos[13]);
/*      */       
/* 1494 */       this.jComboBox9.addItem(datos[14]);
/* 1495 */       this.jComboBox9.setSelectedItem(datos[14]);
/*      */     } 
/*      */     
/* 1498 */     this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(datos[10])));
/* 1499 */     this.jSpinner2.setValue(Integer.valueOf(Integer.parseInt(datos[11])));
/*      */   }
/*      */   
/*      */   public void copiarArchivos(String origen, String destino) {
/* 1503 */     Path origenPath = Paths.get(origen, new String[0]);
/*      */     
/* 1505 */     Path destinoPath = Paths.get(destino, new String[0]);
/*      */     
/*      */     try {
/* 1508 */       Files.copy(origenPath, destinoPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*      */     }
/* 1510 */     catch (FileNotFoundException ex) {
/* 1511 */       System.out.println("ERROR 1: al copiar Arhivo: " + ex.getMessage());
/* 1512 */     } catch (IOException ex) {
/* 1513 */       System.out.println("ERROR 2: al copiar Arhivo: " + ex.getMessage());
/*      */     } 
/*      */ 
/*      */     
/* 1517 */     String nuevaRuta = destinoPath.toString().replace("\\", "\\\\");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void sacarMayor() {
/* 1523 */     this.con2.consultar("max(idProd)", "alm_productos", "");
/* 1524 */     String mayor = this.con2.Campo;
/* 1525 */     int MAYOR = 0;
/*      */     try {
/* 1527 */       MAYOR = Integer.parseInt(mayor);
/* 1528 */     } catch (NumberFormatException e) {
/* 1529 */       MAYOR = 0;
/*      */     } 
/* 1531 */     MAYOR++;
/* 1532 */     this.jTextField3.setText("" + MAYOR);
/*      */   }
/*      */   
/*      */   public void calcularImporte() {
/* 1536 */     boolean tieneIva = this.jCheckBox1.isSelected();
/* 1537 */     double cant = 1.0D;
/* 1538 */     double precio = this.utilerias.convertirCantTexto(this.jFormattedTextField1.getText());
/* 1539 */     double ret = this.utilerias.convertirCantTexto(this.jFormattedTextField3.getText());
/* 1540 */     double sub = cant * precio;
/* 1541 */     double iva = 0.0D;
/*      */     
/* 1543 */     if (tieneIva) {
/* 1544 */       iva = sub * 0.16D;
/*      */     }
/* 1546 */     double total = sub + iva - ret;
/* 1547 */     this.jFormattedTextField2.setValue(Double.valueOf(iva));
/* 1548 */     this.jFormattedTextField4.setValue(Double.valueOf(total));
/*      */   }
/*      */   
/*      */   public void calcularInversion() {
/* 1552 */     double cant = 0.0D;
/* 1553 */     double precio = this.utilerias.convertirCantTexto(this.jFormattedTextField4.getText());
/* 1554 */     if (this.materialButton20.getText().equals("Guardar")) {
/* 1555 */       cant = Double.parseDouble(this.jSpinner3.getValue().toString());
/*      */     } else {
/* 1557 */       cant = Double.parseDouble(this.jLabel26.getText());
/*      */     } 
/* 1559 */     double inv = cant * precio;
/* 1560 */     this.jLabel29.setText(this.utilerias.convertirDoublePesos(inv));
/*      */   }
/*      */   
/*      */   public void cargarArchivo() {
/* 1564 */     JFileChooser selector = new JFileChooser();
/* 1565 */     selector.setDialogTitle("Seleccione el archivo");
/* 1566 */     selector.setCurrentDirectory(new File(this.RUTAGRAL));
/* 1567 */     FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes", new String[] { "jpg", "jpeg", "png", "gif", "bmp" });
/* 1568 */     selector.setFileFilter(filtro);
/*      */     
/* 1570 */     File file = null;
/* 1571 */     int flag = selector.showOpenDialog(null);
/* 1572 */     if (flag == 0) {
/* 1573 */       file = selector.getSelectedFile();
/*      */       
/* 1575 */       String nombre = file.getAbsolutePath();
/* 1576 */       this.RUTAGRAL = nombre;
/* 1577 */       this.TIPOARCHIVO = FilenameUtils.getExtension(nombre);
/*      */       
/* 1579 */       verImagen(nombre);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void verImagen(String file) {
/* 1585 */     ImageIcon tmpIcon = new ImageIcon(file);
/* 1586 */     ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(160, -1, 1));
/* 1587 */     this.jLabel6.setIcon(temporal);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 1591 */     String[] medida = this.con2.regresaColIndex("distinct(unidadMedida)", "com_requi_conceptos", "order by unidadMedida");
/* 1592 */     this.jComboBox20.addItem("");
/* 1593 */     this.utilerias.llenarCombo(this.jComboBox20, medida);
/*      */     
/* 1595 */     String[] cat1 = this.con2.regresaColIndex("distinct(categoria)", "alm_categorias", "order by categoria");
/* 1596 */     this.jComboBox7.addItem("CATEGORÍA 1");
/* 1597 */     this.utilerias.llenarCombo(this.jComboBox7, cat1);
/*      */     
/* 1599 */     this.jComboBox8.addItem("CATEGORÍA 2");
/* 1600 */     this.utilerias.llenarCombo(this.jComboBox8, cat1);
/*      */     
/* 1602 */     this.jComboBox9.addItem("CATEGORÍA 3");
/* 1603 */     this.utilerias.llenarCombo(this.jComboBox9, cat1);
/*      */   }
/*      */   
/*      */   public void activarEtiqueta() {
/* 1607 */     this.jPanel44.removeAll();
/* 1608 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 1609 */     this.jPanel44.setLayout(jPanel44Layout);
/* 1610 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 1611 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1612 */         .addGroup(jPanel44Layout.createSequentialGroup()
/* 1613 */           .addGap(21, 21, 21)
/* 1614 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1615 */             .addComponent(this.jLabel26, -2, 271, -2)
/* 1616 */             .addComponent(this.jLabel27, -2, 263, -2))
/* 1617 */           .addContainerGap(18, 32767)));
/*      */     
/* 1619 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 1620 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1621 */         .addGroup(jPanel44Layout.createSequentialGroup()
/* 1622 */           .addGap(24, 24, 24)
/* 1623 */           .addComponent(this.jLabel26, -2, 73, -2)
/* 1624 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1625 */           .addComponent(this.jLabel27)
/* 1626 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1629 */     JComponent editor = this.jSpinner3.getEditor();
/* 1630 */     JFormattedTextField textField = ((JSpinner.DefaultEditor)editor).getTextField();
/* 1631 */     textField.setHorizontalAlignment(0);
/*      */     
/* 1633 */     this.jPanel41.add(this.jPanel44);
/* 1634 */     this.jPanel44.setBounds(10, 40, 310, 130);
/* 1635 */     this.jPanel44.repaint();
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 1639 */     this.jComboBox20.setEnabled(false);
/* 1640 */     this.jComboBox6.setEnabled(false);
/* 1641 */     this.jTextField4.setEditable(false);
/* 1642 */     this.jTextField5.setEditable(false);
/* 1643 */     this.jTextField6.setEditable(false);
/* 1644 */     this.jTextField7.setEditable(false);
/* 1645 */     this.jComboBox7.setEnabled(false);
/* 1646 */     this.jComboBox8.setEnabled(false);
/* 1647 */     this.jComboBox9.setEnabled(false);
/*      */     
/* 1649 */     this.jFormattedTextField1.setEnabled(false);
/* 1650 */     this.jFormattedTextField3.setEnabled(false);
/* 1651 */     this.jSpinner1.setEnabled(false);
/* 1652 */     this.jSpinner2.setEnabled(false);
/*      */     
/* 1654 */     this.jTextPane1.setEditable(false);
/* 1655 */     this.jComboBox1.setEnabled(false);
/* 1656 */     this.jCheckBox1.setEnabled(false);
/* 1657 */     activarEtiqueta();
/* 1658 */     this.jTextField1.setEditable(false);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 1662 */     this.jTextField3.setText("");
/* 1663 */     this.jComboBox20.setSelectedIndex(0);
/* 1664 */     this.jComboBox6.setSelectedIndex(0);
/* 1665 */     this.jTextField4.setText("");
/* 1666 */     this.jTextField5.setText("");
/* 1667 */     this.jTextField6.setText("");
/* 1668 */     this.jTextField7.setText("");
/* 1669 */     this.jTextField1.setText("");
/* 1670 */     this.jComboBox7.setSelectedIndex(0);
/* 1671 */     this.jComboBox8.setSelectedIndex(0);
/* 1672 */     this.jComboBox9.setSelectedIndex(0);
/* 1673 */     this.jSpinner1.setValue(Integer.valueOf(0));
/* 1674 */     this.jSpinner2.setValue(Integer.valueOf(0));
/* 1675 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 1676 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 1677 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 1678 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 1679 */     this.jDateChooser6.setDate(this.fechaActual);
/* 1680 */     this.jDateChooser7.setDate(this.fechaActual);
/* 1681 */     this.jTextField8.setText("");
/* 1682 */     this.jTextPane1.setText("");
/* 1683 */     this.jLabel26.setText("0");
/* 1684 */     this.jLabel29.setText("$0.00");
/* 1685 */     this.jComboBox1.setSelectedIndex(0);
/* 1686 */     this.jCheckBox1.setSelected(true);
/* 1687 */     this.jTextField8.setText("CREADO");
/*      */   }
/*      */   
/*      */   public void desactivarImagenes() {
/* 1691 */     this.jButton3.setEnabled(false);
/* 1692 */     this.jButton5.setEnabled(false);
/* 1693 */     this.jButton7.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 1697 */     this.pintar.colorear(this.jTextField3);
/* 1698 */     this.pintar.colorear(this.jComboBox20);
/* 1699 */     this.pintar.colorear(this.jComboBox6);
/* 1700 */     this.pintar.colorear(this.jTextField4);
/* 1701 */     this.pintar.colorear(this.jTextField5);
/* 1702 */     this.pintar.colorear(this.jTextField6);
/* 1703 */     this.pintar.colorear(this.jTextField7);
/* 1704 */     this.pintar.colorear(this.jTextField1);
/* 1705 */     this.pintar.colorear(this.jComboBox7);
/* 1706 */     this.pintar.colorear(this.jComboBox8);
/* 1707 */     this.pintar.colorear(this.jComboBox9);
/* 1708 */     this.pintar.colorear(this.jSpinner1);
/* 1709 */     this.pintar.colorear(this.jSpinner2);
/*      */     
/* 1711 */     this.pintar.colorear(this.jFormattedTextField1);
/* 1712 */     this.pintar.colorear(this.jFormattedTextField2);
/* 1713 */     this.pintar.colorear(this.jFormattedTextField3);
/* 1714 */     this.pintar.colorear(this.jFormattedTextField4);
/*      */     
/* 1716 */     this.pintar.colorear(this.jTextPane1);
/* 1717 */     this.pintar.colorear(this.jComboBox1);
/*      */   }
/*      */   
/*      */   protected JRootPane createRootPane() {
/* 1721 */     JRootPane rootPane = new JRootPane();
/* 1722 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 1723 */     Action actionListener = new AbstractAction() {
/*      */         public void actionPerformed(ActionEvent actionEvent) {
/* 1725 */           AlmProductosForm.this.actualizado = false;
/* 1726 */           AlmProductosForm.this.setVisible(false);
/*      */         }
/*      */       };
/* 1729 */     InputMap inputMap = rootPane.getInputMap(2);
/* 1730 */     inputMap.put(stroke, "ESCAPE");
/* 1731 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 1732 */     return rootPane;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/AlmProductosForm.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */