/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.text.NumberFormat;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class dowell extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JFrame padre;
/*      */   JScrollPane panel;
/*   21 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   22 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   23 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   24 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   25 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   26 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   27 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   28 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   29 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   MostrarTabla modelo;
/*   32 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*      */   JTabbedPane fichas;
/*      */   String USUARIO;
/*      */   JTable tabla;
/*      */   EscribirReporte esc;
/*   37 */   Errores error = new Errores(false);
/*   38 */   Validaciones val = new Validaciones();
/*   39 */   String CLAVE = "";
/*   40 */   Date fechaActual = new Date();
/*   41 */   Date fecha = new Date();
/*      */   String[] CLAVES;
/*   43 */   Date fechaInicio = null;
/*   44 */   Date fechaTermino = null;
/*   45 */   Date fechaMinimo = null;
/*      */   
/*      */   String[] clavesDesti;
/*      */   String[] empresasDesti;
/*      */   String[] ciudadesDesti;
/*      */   String[] domicilioDesti;
/*      */   String[] numeroDesti;
/*      */   String[] coloniaDesti;
/*      */   String[] rfcDesti;
/*      */   String[] montoDesti;
/*      */   String[] letraDesti;
/*      */   String[] operadores;
/*      */   String[] EQUIPOS;
/*   58 */   String MES = "";
/*   59 */   String[] CONCEPTOS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*   60 */   int CONTADOR = 0; private JButton jButton1; private JButton jButton10; private JButton jButton12; private JButton jButton13; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JLabel jLabel1; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51;
/*      */   public dowell(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*   62 */     String año = "2009";
/*   63 */     String mes = "11";
/*   64 */     String dia = "19";
/*   65 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   66 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   68 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*      */     }
/*   70 */     catch (ParseException ex) {
/*   71 */       ex.printStackTrace();
/*      */     } 
/*      */     
/*   74 */     Calendar ca = Calendar.getInstance();
/*   75 */     Calendar fecha = Calendar.getInstance();
/*   76 */     int aa = fecha.get(1);
/*   77 */     int mm = fecha.get(2);
/*   78 */     int dd = fecha.get(5);
/*   79 */     int diasTotal = diasDelMes(mm, aa);
/*   80 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   81 */     strFecha = "";
/*   82 */     if (diasTotal == dd) {
/*   83 */       dd = 1;
/*   84 */       if (mm == 11) {
/*   85 */         aa++;
/*   86 */         mm = 0;
/*      */       } else {
/*      */         
/*   89 */         mm++;
/*      */       } 
/*      */     } else {
/*   92 */       dd++;
/*      */     } 
/*   94 */     mm++;
/*   95 */     año = "" + aa;
/*   96 */     mes = "" + mm;
/*   97 */     dia = "" + dd;
/*   98 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   99 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  101 */       this.fechaTermino = formatoDelTexto.parse(strFecha);
/*      */     }
/*  103 */     catch (ParseException ex) {
/*  104 */       ex.printStackTrace();
/*      */     } 
/*      */     
/*  107 */     this.USUARIO = usua;
/*      */     
/*  109 */     this.fichas = fichas;
/*  110 */     this.padre = padre;
/*  111 */     initComponents();
/*  112 */     panelito.setViewportView(this);
/*  113 */     this.panel = panelito;
/*  114 */     colorear();
/*  115 */     consultar();
/*      */     
/*  117 */     int w = this.tama.width;
/*  118 */     int h = this.tama.height;
/*  119 */     int rw = (w - 987) / 2;
/*  120 */     int rh = (h - 737) / 2;
/*  121 */     this.jDialog1.setLocation(rw, rh);
/*  122 */     this.jDialog1.setSize(987, 737);
/*  123 */     this.jDialog1.setVisible(false);
/*  124 */     this.jDialog1.setResizable(false);
/*      */     
/*  126 */     rw = (w - 733) / 2;
/*  127 */     rh = (h - 160) / 2;
/*  128 */     this.jDialog2.setLocation(rw, rh);
/*  129 */     this.jDialog2.setSize(733, 160);
/*  130 */     this.jDialog2.setVisible(false);
/*  131 */     this.jDialog2.setResizable(false);
/*      */     
/*  133 */     this.jDialog3.setLocation(550, 20);
/*  134 */     this.jDialog3.setSize(700, 250);
/*  135 */     this.jDialog3.setVisible(false);
/*  136 */     this.jDialog2.setResizable(false);
/*      */     
/*  138 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  139 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  140 */     this.jLabel5.setCursor(micursor);
/*      */     
/*  142 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  143 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  144 */     this.jDialog1.setCursor(micursor);
/*  145 */     this.jDialog2.setCursor(micursor);
/*  146 */     this.jDialog3.setCursor(micursor);
/*  147 */     llenarCombo();
/*  148 */     sacarFecha();
/*      */   }
/*      */   private JLabel jLabel54; private JLabel jLabel56; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel30; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JSeparator jSeparator1; private JSeparator jSeparator3; private JSeparator jSeparator4; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField17; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  153 */     this.jDialog1 = new JDialog(this.padre);
/*  154 */     this.jPanel6 = new JPanel();
/*  155 */     this.jLabel22 = new JLabel();
/*  156 */     this.jLabel11 = new JLabel();
/*  157 */     this.jPanel21 = new JPanel();
/*  158 */     this.jLabel12 = new JLabel();
/*  159 */     this.jLabel13 = new JLabel();
/*  160 */     this.jLabel14 = new JLabel();
/*  161 */     this.jLabel17 = new JLabel();
/*  162 */     this.jPanel22 = new JPanel();
/*  163 */     this.jLabel18 = new JLabel();
/*  164 */     this.jLabel20 = new JLabel();
/*  165 */     this.jLabel21 = new JLabel();
/*  166 */     this.jLabel23 = new JLabel();
/*  167 */     this.jLabel34 = new JLabel();
/*  168 */     this.jLabel35 = new JLabel();
/*  169 */     this.jLabel36 = new JLabel();
/*  170 */     this.jLabel37 = new JLabel();
/*  171 */     this.jPanel23 = new JPanel();
/*  172 */     this.jPanel25 = new JPanel();
/*  173 */     this.jLabel30 = new JLabel();
/*  174 */     this.jLabel31 = new JLabel();
/*  175 */     this.jLabel32 = new JLabel();
/*  176 */     this.jLabel50 = new JLabel();
/*  177 */     this.jLabel51 = new JLabel();
/*  178 */     this.jSeparator1 = new JSeparator();
/*  179 */     this.jLabel56 = new JLabel();
/*  180 */     this.jLabel33 = new JLabel();
/*  181 */     this.jTextField11 = new JTextField();
/*  182 */     this.jPanel26 = new JPanel();
/*  183 */     this.jTextField1 = new JTextField();
/*  184 */     this.jPanel30 = new JPanel();
/*  185 */     this.jTextField5 = new JTextField();
/*  186 */     this.jPanel32 = new JPanel();
/*  187 */     this.jLabel61 = new JLabel();
/*  188 */     this.jLabel64 = new JLabel();
/*  189 */     this.jPanel2 = new JPanel();
/*  190 */     this.jTextField2 = new JTextField();
/*  191 */     this.jPanel35 = new JPanel();
/*  192 */     this.jLabel15 = new JLabel();
/*  193 */     this.jScrollPane1 = new JScrollPane();
/*  194 */     this.jTable1 = new JTable();
/*  195 */     this.jPanel33 = new JPanel();
/*  196 */     this.jTextField3 = new JTextField();
/*  197 */     this.jPanel34 = new JPanel();
/*  198 */     this.jTextField4 = new JTextField();
/*  199 */     this.jComboBox1 = new JComboBox();
/*  200 */     this.jLabel19 = new JLabel();
/*  201 */     this.jLabel24 = new JLabel();
/*  202 */     this.jButton9 = new JButton();
/*  203 */     this.jButton8 = new JButton();
/*  204 */     this.jButton7 = new JButton();
/*  205 */     this.jButton1 = new JButton();
/*  206 */     this.jTextField9 = new JTextField();
/*  207 */     this.jDialog2 = new JDialog(this.jDialog1);
/*  208 */     this.jPanel8 = new JPanel();
/*  209 */     this.jLabel62 = new JLabel();
/*  210 */     this.jSeparator3 = new JSeparator();
/*  211 */     this.jLabel63 = new JLabel();
/*  212 */     this.jTextField6 = new JTextField();
/*  213 */     this.jButton12 = new JButton();
/*  214 */     this.jButton13 = new JButton();
/*  215 */     this.jLabel65 = new JLabel();
/*  216 */     this.jTextField7 = new JTextField();
/*  217 */     this.jLabel66 = new JLabel();
/*  218 */     this.jTextField8 = new JTextField();
/*  219 */     this.jLabel67 = new JLabel();
/*  220 */     this.jTextField17 = new JTextField();
/*  221 */     this.jDialog3 = new JDialog(this.padre);
/*  222 */     this.jPanel9 = new JPanel();
/*  223 */     this.jLabel68 = new JLabel();
/*  224 */     this.jSeparator4 = new JSeparator();
/*  225 */     this.jScrollPane2 = new JScrollPane();
/*  226 */     this.jTable2 = new JTable();
/*  227 */     this.jButton2 = new JButton();
/*  228 */     this.jLabel1 = new JLabel();
/*  229 */     this.jLabel2 = new JLabel();
/*  230 */     this.jPanel1 = new JPanel();
/*  231 */     this.jLabel54 = new JLabel();
/*  232 */     this.jPanel5 = new JPanel();
/*  233 */     this.jLabel48 = new JLabel();
/*  234 */     this.jScrollPane3 = new JScrollPane();
/*  235 */     this.jTable3 = new JTable();
/*  236 */     this.jPanel17 = new JPanel();
/*  237 */     this.jLabel46 = new JLabel();
/*  238 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  239 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  240 */     this.jLabel47 = new JLabel();
/*  241 */     this.jLabel5 = new JLabel();
/*  242 */     this.jButton3 = new JButton();
/*  243 */     this.jButton6 = new JButton();
/*  244 */     this.jButton4 = new JButton();
/*  245 */     this.jButton5 = new JButton();
/*  246 */     this.jTextField10 = new JTextField();
/*  247 */     this.jLabel49 = new JLabel();
/*  248 */     this.jButton10 = new JButton();
/*      */     
/*  250 */     this.jDialog1.setModal(true);
/*  251 */     this.jDialog1.setUndecorated(true);
/*      */     
/*  253 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*  254 */     this.jPanel6.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
/*      */     
/*  256 */     this.jLabel22.setFont(new Font("Tahoma", 1, 22));
/*  257 */     this.jLabel22.setHorizontalAlignment(0);
/*  258 */     this.jLabel22.setText("<HTML><CENTER>FLETES Y MATERIALES FORSIS,<BR> S.A. DE C.V.</CENTER></HTML>");
/*      */     
/*  260 */     this.jLabel11.setFont(new Font("Tahoma", 0, 9));
/*  261 */     this.jLabel11.setHorizontalAlignment(0);
/*  262 */     this.jLabel11.setText("<HTML><CENTER>MATRIZ<BR>AUTOPISTA MONTERREY-CADEREYTA KM. 32.5<BR>A.P. 129 C.P. 67450 CADEREYTA JÍMENEZ N.L.<BR>TELS: 01(828) 284-4291, 284-4444, 284-4290 FAX:284-5671<BR> www.forsis.com &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; R.F.C. FMF-901004-UZ9</CENTER></HTML>");
/*      */     
/*  264 */     this.jPanel21.setBackground(new Color(255, 255, 255));
/*  265 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " FECHA ", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  267 */     this.jLabel12.setFont(new Font("Tahoma", 1, 12));
/*  268 */     this.jLabel12.setForeground(new Color(255, 0, 0));
/*  269 */     this.jLabel12.setHorizontalAlignment(0);
/*  270 */     this.jLabel12.setText("20/10/2009");
/*      */     
/*  272 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  273 */     this.jPanel21.setLayout(jPanel21Layout);
/*  274 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  275 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  276 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  277 */           .addContainerGap()
/*  278 */           .addComponent(this.jLabel12, -1, 163, 32767)
/*  279 */           .addContainerGap()));
/*      */     
/*  281 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  283 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
/*  284 */           .addContainerGap(-1, 32767)
/*  285 */           .addComponent(this.jLabel12)));
/*      */ 
/*      */     
/*  288 */     this.jLabel13.setFont(new Font("Tahoma", 0, 8));
/*  289 */     this.jLabel13.setText("<HTML><CENTER><b>BASE VERACRUZ</b><BR>AUTOPISTA AUTOPISTA A CARDEL KM. 5.<BR>COL. VERGARA TARIMOYA<BR>VERACRUZ, VER. C.P. 91810<BR>TELÉFONOS: 01(229) 924-8601 AL 03</CENTER></HTML>");
/*      */     
/*  291 */     this.jLabel14.setFont(new Font("Tahoma", 0, 8));
/*  292 */     this.jLabel14.setText("<HTML><CENTER><b>BASE POZA RICA</b><BR>EMÍLIO CARRANZA No. 6<BR>COL. LÓPEZ MATEOS<BR>POZA RICA, VERACRUZ<BR>TEL. 01 (782) 825-0387</CENTER></HTML>");
/*      */     
/*  294 */     this.jLabel17.setFont(new Font("Tahoma", 0, 8));
/*  295 */     this.jLabel17.setText("<HTML><CENTER><b>BASE TABASCO</b><BR>TEL. 01 (993) 399-9095<BR>01 (993) 160-7498<BR>VILLA HERMOSA</CENTER></HTML>");
/*      */     
/*  297 */     this.jPanel22.setBackground(new Color(255, 255, 255));
/*  298 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  300 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/*  301 */     this.jLabel18.setText("ORIGEN");
/*      */     
/*  303 */     this.jLabel20.setFont(new Font("Tahoma", 1, 11));
/*  304 */     this.jLabel20.setText("DOMICILIO");
/*      */     
/*  306 */     this.jLabel21.setFont(new Font("Tahoma", 1, 11));
/*  307 */     this.jLabel21.setText("COLONIA");
/*      */     
/*  309 */     this.jLabel23.setFont(new Font("Tahoma", 1, 11));
/*  310 */     this.jLabel23.setText("R.F.C.");
/*      */     
/*  312 */     this.jLabel34.setFont(new Font("Tahoma", 1, 11));
/*  313 */     this.jLabel34.setForeground(new Color(255, 0, 0));
/*  314 */     this.jLabel34.setText("DOWELL SCHULUMBER DE MÉXICO S.A. DE C.V.");
/*      */     
/*  316 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/*  317 */     this.jLabel35.setForeground(new Color(255, 0, 0));
/*  318 */     this.jLabel35.setText("AV. EJERCITO NACIONAL No. 425,");
/*      */     
/*  320 */     this.jLabel36.setFont(new Font("Tahoma", 1, 11));
/*  321 */     this.jLabel36.setForeground(new Color(255, 0, 0));
/*  322 */     this.jLabel36.setText("PISO 5, COL. GRANADA DEL MIGUEL HIDALGO");
/*      */     
/*  324 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/*  325 */     this.jLabel37.setForeground(new Color(255, 0, 0));
/*  326 */     this.jLabel37.setText("DSM830824AY6 CP 11520 MÉXICO, MÉXICO");
/*      */     
/*  328 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  329 */     this.jPanel22.setLayout(jPanel22Layout);
/*  330 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  331 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  332 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  333 */           .addContainerGap()
/*  334 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  335 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  336 */               .addComponent(this.jLabel21, -2, 67, -2)
/*  337 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  338 */               .addComponent(this.jLabel36, -1, 357, 32767))
/*  339 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  340 */               .addComponent(this.jLabel23, -2, 67, -2)
/*  341 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  342 */               .addComponent(this.jLabel37, -1, 357, 32767))
/*  343 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  344 */               .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  345 */                 .addComponent(this.jLabel18, -2, 67, -2)
/*  346 */                 .addComponent(this.jLabel20, -2, 67, -2))
/*  347 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  348 */               .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  349 */                 .addComponent(this.jLabel35, -1, 357, 32767)
/*  350 */                 .addComponent(this.jLabel34, -1, 357, 32767))))
/*  351 */           .addGap(22, 22, 22)));
/*      */     
/*  353 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  355 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  356 */           .addContainerGap(-1, 32767)
/*  357 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  358 */             .addComponent(this.jLabel18)
/*  359 */             .addComponent(this.jLabel34))
/*  360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  361 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  362 */             .addComponent(this.jLabel20)
/*  363 */             .addComponent(this.jLabel35))
/*  364 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  365 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  366 */             .addComponent(this.jLabel21)
/*  367 */             .addComponent(this.jLabel36))
/*  368 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  369 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  370 */             .addComponent(this.jLabel23)
/*  371 */             .addComponent(this.jLabel37))
/*  372 */           .addGap(26, 26, 26)));
/*      */ 
/*      */     
/*  375 */     this.jPanel23.setBackground(new Color(255, 255, 255));
/*  376 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  378 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/*  379 */     this.jPanel23.setLayout(jPanel23Layout);
/*  380 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/*  381 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  382 */         .addGap(0, 472, 32767));
/*      */     
/*  384 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/*  385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  386 */         .addGap(0, 87, 32767));
/*      */ 
/*      */     
/*  389 */     this.jPanel25.setBackground(new Color(255, 255, 255));
/*      */     
/*  391 */     this.jLabel30.setFont(new Font("Tahoma", 1, 11));
/*  392 */     this.jLabel30.setText("SUB-TOTAL");
/*      */     
/*  394 */     this.jLabel31.setFont(new Font("Tahoma", 1, 11));
/*  395 */     this.jLabel31.setText("I.V.A.");
/*      */     
/*  397 */     this.jLabel32.setFont(new Font("Tahoma", 1, 11));
/*  398 */     this.jLabel32.setText("RET-IVA");
/*      */     
/*  400 */     this.jLabel50.setFont(new Font("Tahoma", 1, 12));
/*  401 */     this.jLabel50.setForeground(new Color(255, 0, 0));
/*  402 */     this.jLabel50.setHorizontalAlignment(4);
/*  403 */     this.jLabel50.setText("00.00");
/*      */     
/*  405 */     this.jLabel51.setFont(new Font("Tahoma", 1, 12));
/*  406 */     this.jLabel51.setForeground(new Color(255, 0, 0));
/*  407 */     this.jLabel51.setHorizontalAlignment(4);
/*  408 */     this.jLabel51.setText("00.00");
/*      */     
/*  410 */     this.jSeparator1.setForeground(new Color(0, 0, 0));
/*  411 */     this.jSeparator1.setOrientation(1);
/*      */     
/*  413 */     this.jLabel56.setFont(new Font("Tahoma", 1, 12));
/*  414 */     this.jLabel56.setForeground(new Color(255, 0, 0));
/*  415 */     this.jLabel56.setHorizontalAlignment(4);
/*  416 */     this.jLabel56.setText("00.00");
/*      */     
/*  418 */     this.jLabel33.setFont(new Font("Tahoma", 1, 11));
/*  419 */     this.jLabel33.setText("TOTAL");
/*      */     
/*  421 */     this.jTextField11.setFont(new Font("Tahoma", 1, 12));
/*  422 */     this.jTextField11.setForeground(Color.red);
/*  423 */     this.jTextField11.setHorizontalAlignment(4);
/*  424 */     this.jTextField11.setText("00.00");
/*  425 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  427 */             dowell.this.jTextField11FocusGained(evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  430 */             dowell.this.jTextField11FocusLost(evt);
/*      */           }
/*      */         });
/*  433 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  435 */             dowell.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  439 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  440 */     this.jPanel25.setLayout(jPanel25Layout);
/*  441 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  442 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  443 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
/*  444 */           .addContainerGap(66, 32767)
/*  445 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  446 */             .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  447 */               .addComponent(this.jLabel31, GroupLayout.Alignment.TRAILING, -2, 67, -2)
/*  448 */               .addComponent(this.jLabel32, -2, 67, -2)
/*  449 */               .addComponent(this.jLabel30))
/*  450 */             .addComponent(this.jLabel33, -2, 67, -2))
/*  451 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  452 */           .addComponent(this.jSeparator1, -2, 14, -2)
/*  453 */           .addGap(10, 10, 10)
/*  454 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  455 */             .addComponent(this.jLabel56, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  456 */             .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  457 */             .addComponent(this.jLabel50, GroupLayout.Alignment.LEADING, -1, 116, 32767)
/*  458 */             .addComponent(this.jTextField11, GroupLayout.Alignment.LEADING))
/*  459 */           .addGap(29, 29, 29)));
/*      */     
/*  461 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  462 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  463 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  464 */           .addGap(11, 11, 11)
/*  465 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  466 */             .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  467 */               .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  468 */               .addGroup(jPanel25Layout.createSequentialGroup()
/*  469 */                 .addComponent(this.jLabel30)
/*  470 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  471 */                 .addComponent(this.jLabel31)
/*  472 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  473 */                 .addComponent(this.jLabel32)
/*  474 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  475 */                 .addComponent(this.jLabel33)))
/*  476 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  477 */               .addComponent(this.jLabel50)
/*  478 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  479 */               .addComponent(this.jLabel51)
/*  480 */               .addGap(1, 1, 1)
/*  481 */               .addComponent(this.jTextField11, -2, -1, -2)
/*  482 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  483 */               .addComponent(this.jLabel56)))
/*  484 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  487 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/*  488 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder(null, "SU PEDIDO No.", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  490 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  491 */     this.jPanel26.setLayout(jPanel26Layout);
/*  492 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  493 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  494 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  495 */           .addContainerGap()
/*  496 */           .addComponent(this.jTextField1, -1, 203, 32767)
/*  497 */           .addContainerGap()));
/*      */     
/*  499 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  500 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  501 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  502 */           .addComponent(this.jTextField1, -2, -1, -2)
/*  503 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  506 */     this.jPanel30.setBackground(new Color(255, 255, 255));
/*  507 */     this.jPanel30.setBorder(BorderFactory.createTitledBorder(null, "CANTIDAD EN LETRA", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  509 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/*  510 */     this.jPanel30.setLayout(jPanel30Layout);
/*  511 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/*  512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  513 */         .addComponent(this.jTextField5, -1, 640, 32767));
/*      */     
/*  515 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/*  516 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  517 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  518 */           .addComponent(this.jTextField5, -2, -1, -2)
/*  519 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  522 */     this.jPanel32.setBackground(new Color(255, 255, 255));
/*      */     
/*  524 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/*  525 */     this.jPanel32.setLayout(jPanel32Layout);
/*  526 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/*  527 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  528 */         .addGap(0, 286, 32767));
/*      */     
/*  530 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/*  531 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  532 */         .addGap(0, 55, 32767));
/*      */ 
/*      */     
/*  535 */     this.jLabel61.setFont(new Font("Tahoma", 1, 10));
/*  536 */     this.jLabel61.setForeground(new Color(255, 0, 0));
/*  537 */     this.jLabel61.setHorizontalAlignment(0);
/*  538 */     this.jLabel61.setText(" ");
/*      */     
/*  540 */     this.jLabel64.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Forsis 190x.png")));
/*      */     
/*  542 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*  543 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "FACTURA", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  545 */     this.jTextField2.setFont(new Font("Tahoma", 1, 20));
/*  546 */     this.jTextField2.setForeground(new Color(255, 0, 0));
/*  547 */     this.jTextField2.setHorizontalAlignment(0);
/*      */     
/*  549 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  550 */     this.jPanel2.setLayout(jPanel2Layout);
/*  551 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  552 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  553 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  554 */           .addContainerGap()
/*  555 */           .addComponent(this.jTextField2, -1, 163, 32767)
/*  556 */           .addContainerGap()));
/*      */     
/*  558 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  559 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  560 */         .addComponent(this.jTextField2, -1, 42, 32767));
/*      */ 
/*      */     
/*  563 */     this.jPanel35.setBackground(new Color(255, 255, 255));
/*  564 */     this.jPanel35.setBorder(BorderFactory.createTitledBorder(null, "LUGAR DE EXPEDICIÓN", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  566 */     this.jLabel15.setFont(new Font("Tahoma", 1, 12));
/*  567 */     this.jLabel15.setForeground(new Color(255, 0, 0));
/*  568 */     this.jLabel15.setHorizontalAlignment(0);
/*  569 */     this.jLabel15.setText("POZA RICA");
/*      */     
/*  571 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/*  572 */     this.jPanel35.setLayout(jPanel35Layout);
/*  573 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/*  574 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  575 */         .addGroup(jPanel35Layout.createSequentialGroup()
/*  576 */           .addContainerGap()
/*  577 */           .addComponent(this.jLabel15, -1, 163, 32767)
/*  578 */           .addContainerGap()));
/*      */     
/*  580 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/*  581 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  582 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
/*  583 */           .addContainerGap(-1, 32767)
/*  584 */           .addComponent(this.jLabel15)));
/*      */ 
/*      */     
/*  587 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
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
/*  602 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  607 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  610 */     this.jTable1.setEditingRow(0);
/*  611 */     this.jTable1.setSelectionMode(0);
/*  612 */     this.jTable1.setShowHorizontalLines(false);
/*  613 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  615 */     this.jPanel33.setBackground(new Color(255, 255, 255));
/*  616 */     this.jPanel33.setBorder(BorderFactory.createTitledBorder(null, "ZONA", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  618 */     this.jTextField3.setEditable(false);
/*  619 */     this.jTextField3.setHorizontalAlignment(0);
/*  620 */     this.jTextField3.setText("POZA RICA");
/*      */     
/*  622 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  623 */     this.jPanel33.setLayout(jPanel33Layout);
/*  624 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  625 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  626 */         .addGroup(jPanel33Layout.createSequentialGroup()
/*  627 */           .addContainerGap()
/*  628 */           .addComponent(this.jTextField3, -1, 203, 32767)
/*  629 */           .addContainerGap()));
/*      */     
/*  631 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/*  632 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  633 */         .addGroup(jPanel33Layout.createSequentialGroup()
/*  634 */           .addComponent(this.jTextField3, -2, -1, -2)
/*  635 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  638 */     this.jPanel34.setBackground(new Color(255, 255, 255));
/*  639 */     this.jPanel34.setBorder(BorderFactory.createTitledBorder(null, "CONDICIONES", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  641 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  642 */     this.jPanel34.setLayout(jPanel34Layout);
/*  643 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  644 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  645 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  646 */           .addContainerGap()
/*  647 */           .addComponent(this.jTextField4, -1, 450, 32767)
/*  648 */           .addContainerGap()));
/*      */     
/*  650 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  651 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  652 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  653 */           .addComponent(this.jTextField4, -2, -1, -2)
/*  654 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  657 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  658 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "SERVICIO INTEGRAL", "FLETE" }));
/*      */     
/*  660 */     this.jLabel19.setFont(new Font("Tahoma", 1, 11));
/*  661 */     this.jLabel19.setHorizontalAlignment(4);
/*  662 */     this.jLabel19.setText("EQUIPO");
/*      */     
/*  664 */     this.jLabel24.setFont(new Font("Tahoma", 1, 11));
/*  665 */     this.jLabel24.setHorizontalAlignment(4);
/*  666 */     this.jLabel24.setText("POZO");
/*      */     
/*  668 */     this.jButton9.setMnemonic('I');
/*  669 */     this.jButton9.setText("Imprimir");
/*  670 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  672 */             dowell.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  676 */     this.jButton8.setMnemonic('L');
/*  677 */     this.jButton8.setText("Limpiar");
/*  678 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  680 */             dowell.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  684 */     this.jButton7.setMnemonic('S');
/*  685 */     this.jButton7.setText("Salir");
/*  686 */     this.jButton7.setToolTipText("Salir (Alt+S)");
/*  687 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  689 */             dowell.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  693 */     this.jButton1.setText("Agregar ");
/*  694 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  696 */             dowell.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  700 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  701 */     this.jPanel6.setLayout(jPanel6Layout);
/*  702 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  703 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  704 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  705 */           .addContainerGap()
/*  706 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  707 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  708 */               .addComponent(this.jScrollPane1, -2, 946, -2)
/*  709 */               .addContainerGap())
/*  710 */             .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  711 */               .addGroup(jPanel6Layout.createSequentialGroup()
/*  712 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  713 */                   .addGroup(jPanel6Layout.createSequentialGroup()
/*  714 */                     .addComponent(this.jLabel64, -2, 185, -2)
/*  715 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  716 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  717 */                       .addGroup(jPanel6Layout.createSequentialGroup()
/*  718 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  719 */                           .addComponent(this.jLabel11, -2, 230, -2)
/*  720 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  721 */                             .addComponent(this.jLabel13, -2, 174, -2)
/*  722 */                             .addGap(18, 18, 18)
/*  723 */                             .addComponent(this.jLabel14, -2, 125, -2)))
/*  724 */                         .addGap(18, 18, 18)
/*  725 */                         .addComponent(this.jLabel17, -2, 125, -2)
/*  726 */                         .addGap(4, 4, 4)
/*  727 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  728 */                           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  729 */                             .addComponent(this.jPanel2, -1, -1, 32767)
/*  730 */                             .addComponent(this.jPanel21, -2, -1, -2))
/*  731 */                           .addComponent(this.jPanel35, -2, -1, -2)))
/*  732 */                       .addComponent(this.jLabel22, -2, 421, -2))
/*  733 */                     .addGap(816, 816, 816))
/*  734 */                   .addGroup(jPanel6Layout.createSequentialGroup()
/*  735 */                     .addComponent(this.jLabel61, -2, 556, -2)
/*  736 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 492, 32767)
/*  737 */                     .addComponent(this.jPanel32, -2, -1, -2)
/*  738 */                     .addGap(820, 820, 820))
/*  739 */                   .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  740 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  741 */                       .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  742 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  743 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  744 */                             .addComponent(this.jButton9, -2, 86, -2)
/*  745 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  746 */                             .addComponent(this.jButton8, -2, 90, -2)
/*  747 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  748 */                             .addComponent(this.jButton7, -2, 82, -2))
/*  749 */                           .addComponent(this.jPanel30, -2, -1, -2))
/*  750 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  751 */                         .addComponent(this.jPanel25, -1, -1, 32767))
/*  752 */                       .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  753 */                         .addComponent(this.jPanel26, -2, -1, -2)
/*  754 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  755 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  756 */                           .addComponent(this.jPanel33, -2, -1, -2)
/*  757 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  758 */                             .addComponent(this.jLabel24, -2, 53, -2)
/*  759 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  760 */                             .addComponent(this.jTextField9)))
/*  761 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  762 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  763 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  764 */                             .addComponent(this.jPanel34, -1, -1, 32767))
/*  765 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  766 */                             .addGap(106, 106, 106)
/*  767 */                             .addComponent(this.jButton1, -2, 124, -2))))
/*  768 */                       .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  769 */                         .addComponent(this.jPanel22, -2, -1, -2)
/*  770 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  771 */                         .addComponent(this.jPanel23, -2, -1, -2)))
/*  772 */                     .addGap(1190, 1190, 1190)))
/*  773 */                 .addGap(0, 0, 0))
/*  774 */               .addGroup(jPanel6Layout.createSequentialGroup()
/*  775 */                 .addComponent(this.jLabel19, -2, 53, -2)
/*  776 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  777 */                 .addComponent(this.jComboBox1, -2, 162, -2)
/*  778 */                 .addContainerGap())))));
/*      */     
/*  780 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  781 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  782 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  783 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  784 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  785 */               .addComponent(this.jLabel22, -2, 65, -2)
/*  786 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  787 */               .addComponent(this.jLabel11)
/*  788 */               .addGap(18, 18, 18)
/*  789 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  790 */                 .addComponent(this.jLabel13, -2, 64, -2)
/*  791 */                 .addComponent(this.jLabel14, -2, 58, -2)
/*  792 */                 .addComponent(this.jLabel17, -2, 56, -2)))
/*  793 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  794 */               .addGap(11, 11, 11)
/*  795 */               .addComponent(this.jLabel64, -2, 157, -2))
/*  796 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  797 */               .addContainerGap()
/*  798 */               .addComponent(this.jPanel2, -2, -1, -2)
/*  799 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  800 */               .addComponent(this.jPanel21, -2, -1, -2)
/*  801 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  802 */               .addComponent(this.jPanel35, -2, -1, -2))
/*  803 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  804 */               .addGap(226, 226, 226)
/*  805 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  806 */                 .addComponent(this.jPanel23, -1, -1, 32767)
/*  807 */                 .addComponent(this.jPanel22, -2, 100, -2))))
/*  808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  809 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  810 */             .addComponent(this.jPanel34, -1, -1, 32767)
/*  811 */             .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  812 */               .addComponent(this.jPanel33, -1, -1, 32767)
/*  813 */               .addComponent(this.jPanel26, -1, -1, 32767)))
/*  814 */           .addGap(12, 12, 12)
/*  815 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  816 */             .addComponent(this.jLabel19)
/*  817 */             .addComponent(this.jComboBox1, -2, -1, -2)
/*  818 */             .addComponent(this.jLabel24)
/*  819 */             .addComponent(this.jButton1)
/*  820 */             .addComponent(this.jTextField9, -2, -1, -2))
/*  821 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  822 */           .addComponent(this.jScrollPane1, -2, 168, -2)
/*  823 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  824 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  825 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  826 */               .addComponent(this.jPanel30, -2, -1, -2)
/*  827 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  828 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  829 */                 .addComponent(this.jButton7)
/*  830 */                 .addComponent(this.jButton8)
/*  831 */                 .addComponent(this.jButton9))
/*  832 */               .addGap(294, 294, 294)
/*  833 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  834 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/*  835 */                   .addGap(42, 42, 42)
/*  836 */                   .addComponent(this.jLabel61))
/*  837 */                 .addComponent(this.jPanel32, -1, -1, 32767)))
/*  838 */             .addComponent(this.jPanel25, -2, -1, -2))
/*  839 */           .addContainerGap()));
/*      */ 
/*      */     
/*  842 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  843 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  844 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  845 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  846 */         .addComponent(this.jPanel6, -2, 986, -2));
/*      */     
/*  848 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  849 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  850 */         .addComponent(this.jPanel6, -2, 736, -2));
/*      */ 
/*      */     
/*  853 */     this.jDialog2.setTitle("Agregar Conceptos");
/*  854 */     this.jDialog2.setModal(true);
/*      */     
/*  856 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/*  858 */     this.jLabel62.setFont(new Font("Tahoma", 1, 18));
/*  859 */     this.jLabel62.setForeground(new Color(0, 102, 102));
/*  860 */     this.jLabel62.setHorizontalAlignment(0);
/*  861 */     this.jLabel62.setText("PEDIDOS");
/*      */     
/*  863 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/*  864 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  865 */     this.jLabel63.setHorizontalAlignment(0);
/*  866 */     this.jLabel63.setText("Cantidad");
/*      */     
/*  868 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  870 */             dowell.this.jTextField6FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  874 */     this.jButton12.setMnemonic('C');
/*  875 */     this.jButton12.setText("Cerrar");
/*  876 */     this.jButton12.setToolTipText("Cerrar (Alt+C)");
/*  877 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  879 */             dowell.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  883 */     this.jButton13.setMnemonic('G');
/*  884 */     this.jButton13.setText("Guardar");
/*  885 */     this.jButton13.setToolTipText("Guardar Pedido(Alt+P)");
/*  886 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  888 */             dowell.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  892 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/*  893 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/*  894 */     this.jLabel65.setHorizontalAlignment(0);
/*  895 */     this.jLabel65.setText("Descripción");
/*      */     
/*  897 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/*  898 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/*  899 */     this.jLabel66.setHorizontalAlignment(0);
/*  900 */     this.jLabel66.setText("Precio Unitario");
/*      */     
/*  902 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  904 */             dowell.this.jTextField8FocusLost(evt);
/*      */           }
/*      */         });
/*  907 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  909 */             dowell.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  913 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/*  914 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/*  915 */     this.jLabel67.setHorizontalAlignment(0);
/*  916 */     this.jLabel67.setText("Importe");
/*      */     
/*  918 */     this.jTextField17.setEditable(false);
/*  919 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  921 */             dowell.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/*  924 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  926 */             dowell.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  930 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  931 */     this.jPanel8.setLayout(jPanel8Layout);
/*  932 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  933 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  934 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  935 */           .addContainerGap()
/*  936 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  937 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  938 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  939 */                 .addComponent(this.jLabel63, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  940 */                 .addComponent(this.jTextField6, GroupLayout.Alignment.LEADING, -1, 113, 32767))
/*  941 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  942 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  943 */                 .addComponent(this.jLabel65, -1, -1, 32767)
/*  944 */                 .addComponent(this.jTextField7, -1, 301, 32767)
/*  945 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  946 */                   .addComponent(this.jButton13, -2, 98, -2)
/*  947 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  948 */                   .addComponent(this.jButton12, -2, 93, -2)))
/*  949 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  950 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  951 */                 .addComponent(this.jLabel66, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  952 */                 .addComponent(this.jTextField8, GroupLayout.Alignment.LEADING, -2, 113, -2))
/*  953 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  954 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  955 */                 .addComponent(this.jTextField17, -1, 144, 32767)
/*  956 */                 .addComponent(this.jLabel67, -1, -1, 32767))
/*  957 */               .addContainerGap())
/*  958 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  959 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  960 */                 .addComponent(this.jLabel62, GroupLayout.Alignment.LEADING, -1, 689, 32767)
/*  961 */                 .addComponent(this.jSeparator3, -1, 689, 32767))
/*  962 */               .addContainerGap()))));
/*      */     
/*  964 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  965 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  966 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  967 */           .addComponent(this.jLabel62)
/*  968 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  969 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  970 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  971 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  972 */             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  973 */               .addGroup(jPanel8Layout.createSequentialGroup()
/*  974 */                 .addComponent(this.jLabel63)
/*  975 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  976 */                 .addComponent(this.jTextField6, -2, -1, -2))
/*  977 */               .addGroup(jPanel8Layout.createSequentialGroup()
/*  978 */                 .addComponent(this.jLabel65)
/*  979 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  980 */                 .addComponent(this.jTextField7, -2, -1, -2)))
/*  981 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  982 */               .addComponent(this.jLabel66)
/*  983 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  984 */               .addComponent(this.jTextField8, -2, -1, -2))
/*  985 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  986 */               .addComponent(this.jLabel67)
/*  987 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  988 */               .addComponent(this.jTextField17, -2, -1, -2)))
/*  989 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  990 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  991 */             .addComponent(this.jButton13)
/*  992 */             .addComponent(this.jButton12))
/*  993 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  996 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  997 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  998 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  999 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1000 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */     
/* 1002 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1003 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1004 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */ 
/*      */     
/* 1007 */     this.jDialog3.setTitle("Conceptos Agregados");
/* 1008 */     this.jDialog3.setAlwaysOnTop(true);
/*      */     
/* 1010 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*      */     
/* 1012 */     this.jLabel68.setFont(new Font("Tahoma", 1, 18));
/* 1013 */     this.jLabel68.setForeground(new Color(0, 102, 102));
/* 1014 */     this.jLabel68.setHorizontalAlignment(0);
/* 1015 */     this.jLabel68.setText("PEDIDOS");
/*      */     
/* 1017 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1025 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1030 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1033 */     this.jTable2.setShowHorizontalLines(false);
/* 1034 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1036 */     this.jButton2.setText("Ocultar");
/* 1037 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1039 */             dowell.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1043 */     this.jLabel1.setFont(new Font("Tahoma", 1, 14));
/* 1044 */     this.jLabel1.setText("Factura: ");
/*      */     
/* 1046 */     this.jLabel2.setFont(new Font("Tahoma", 1, 14));
/* 1047 */     this.jLabel2.setForeground(Color.red);
/* 1048 */     this.jLabel2.setText("jLabel2");
/*      */     
/* 1050 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1051 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1052 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1053 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1054 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1055 */           .addContainerGap()
/* 1056 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1057 */             .addComponent(this.jScrollPane2, -1, 699, 32767)
/* 1058 */             .addComponent(this.jLabel68, -1, 699, 32767)
/* 1059 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.TRAILING, -1, 699, 32767)
/* 1060 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 1061 */               .addComponent(this.jLabel1, -2, 70, -2)
/* 1062 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1063 */               .addComponent(this.jLabel2, -2, 156, -2)
/* 1064 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 342, 32767)
/* 1065 */               .addComponent(this.jButton2, -2, 125, -2)))
/* 1066 */           .addContainerGap()));
/*      */     
/* 1068 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1069 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1070 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1071 */           .addComponent(this.jLabel68)
/* 1072 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1073 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 1074 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1075 */           .addComponent(this.jScrollPane2, -2, 129, -2)
/* 1076 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1077 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1078 */             .addComponent(this.jButton2)
/* 1079 */             .addComponent(this.jLabel1)
/* 1080 */             .addComponent(this.jLabel2))
/* 1081 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1084 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1085 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1086 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1087 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1088 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/* 1090 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1091 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1092 */         .addComponent(this.jPanel9, -2, -1, -2));
/*      */ 
/*      */     
/* 1095 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1096 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1098 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1099 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1100 */     this.jLabel54.setHorizontalAlignment(0);
/* 1101 */     this.jLabel54.setText("FACTURACIÓN - SCHULEMBERGER");
/*      */     
/* 1103 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1104 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1106 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1107 */     this.jLabel48.setForeground(Color.red);
/* 1108 */     this.jLabel48.setHorizontalAlignment(2);
/* 1109 */     this.jLabel48.setText("t");
/* 1110 */     this.jLabel48.setBorder(new SoftBevelBorder(1));
/*      */     
/* 1112 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1113 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Factura", "Fecha", "Cliente", "Equipo", "Pozo", "Total", "Letra" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1121 */     this.jTable3.setShowVerticalLines(false);
/* 1122 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1124 */             dowell.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1127 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1129 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1130 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1131 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1132 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1133 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1134 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 1135 */           .addContainerGap(1011, 32767))
/* 1136 */         .addComponent(this.jScrollPane3, -1, 1174, 32767));
/*      */     
/* 1138 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1139 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1140 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1141 */           .addComponent(this.jLabel48)
/* 1142 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1143 */           .addComponent(this.jScrollPane3, -1, 167, 32767)
/* 1144 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1147 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1148 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Facturas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1150 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1151 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1152 */     this.jLabel46.setHorizontalAlignment(0);
/* 1153 */     this.jLabel46.setText("Periodo");
/*      */     
/* 1155 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1156 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1157 */     this.jDateChooser4.setIcon(this.icon);
/* 1158 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1159 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1161 */     this.jDateChooser5.setDate(this.fechaTermino);
/* 1162 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1163 */     this.jDateChooser5.setIcon(this.icon);
/* 1164 */     this.jDateChooser5.setMaxSelectableDate(this.fechaTermino);
/* 1165 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1167 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 1168 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1169 */     this.jLabel47.setHorizontalAlignment(0);
/* 1170 */     this.jLabel47.setText("-");
/*      */     
/* 1172 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 1173 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 1174 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 1175 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1177 */             dowell.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1180 */             dowell.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1183 */             dowell.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1187 */     this.jButton3.setMnemonic('F');
/* 1188 */     this.jButton3.setText("Filtrar");
/* 1189 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 1190 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1192 */             dowell.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1196 */     this.jButton6.setMnemonic('G');
/* 1197 */     this.jButton6.setText("Guardar Reporte");
/* 1198 */     this.jButton6.setToolTipText("Guardar Reporte (Alt+G)");
/* 1199 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1201 */             dowell.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1205 */     this.jButton4.setText("Ver Factura");
/* 1206 */     this.jButton4.setEnabled(false);
/* 1207 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1209 */             dowell.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1213 */     this.jButton5.setText("Agregar Factura");
/* 1214 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1216 */             dowell.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1220 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1222 */             dowell.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1226 */     this.jLabel49.setFont(new Font("Tahoma", 3, 12));
/* 1227 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 1228 */     this.jLabel49.setHorizontalAlignment(0);
/* 1229 */     this.jLabel49.setText("Buscar por Folio");
/*      */     
/* 1231 */     this.jButton10.setMnemonic('E');
/* 1232 */     this.jButton10.setText("Eliminar");
/* 1233 */     this.jButton10.setToolTipText("Eliminar (Alt+E)");
/* 1234 */     this.jButton10.setEnabled(false);
/* 1235 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1237 */             dowell.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1241 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1242 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1243 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1245 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1246 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1247 */             .addComponent(this.jLabel46, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1248 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
/* 1249 */               .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1250 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1251 */               .addComponent(this.jLabel47)
/* 1252 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1253 */               .addComponent((Component)this.jDateChooser5, -2, 108, -2)))
/* 1254 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1255 */           .addComponent(this.jButton3)
/* 1256 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1257 */           .addComponent(this.jLabel5)
/* 1258 */           .addGap(66, 66, 66)
/* 1259 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1260 */             .addComponent(this.jLabel49, -1, -1, 32767)
/* 1261 */             .addComponent(this.jTextField10, -1, 157, 32767))
/* 1262 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, 32767)
/* 1263 */           .addComponent(this.jButton5, -2, 131, -2)
/* 1264 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1265 */           .addComponent(this.jButton6, -2, 121, -2)
/* 1266 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1267 */           .addComponent(this.jButton4, -2, 112, -2)
/* 1268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1269 */           .addComponent(this.jButton10, -2, 112, -2)
/* 1270 */           .addContainerGap()));
/*      */     
/* 1272 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1273 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1274 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1275 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1276 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1277 */               .addComponent(this.jLabel47, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1278 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2))
/* 1279 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2))
/* 1280 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1281 */           .addComponent(this.jLabel46)
/* 1282 */           .addGap(23, 23, 23))
/* 1283 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1284 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1285 */             .addComponent(this.jButton3)
/* 1286 */             .addComponent(this.jLabel5, -1, -1, 32767)
/* 1287 */             .addComponent(this.jButton5)
/* 1288 */             .addComponent(this.jButton6)
/* 1289 */             .addComponent(this.jButton4)
/* 1290 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 1291 */             .addComponent(this.jButton10))
/* 1292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1293 */           .addComponent(this.jLabel49)
/* 1294 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1297 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1298 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1299 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1301 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1302 */           .addContainerGap()
/* 1303 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1304 */             .addComponent(this.jLabel54, -2, 1145, -2)
/* 1305 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 1306 */             .addComponent(this.jPanel17, -1, -1, 32767))
/* 1307 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1309 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1311 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1312 */           .addContainerGap()
/* 1313 */           .addComponent(this.jLabel54, -2, 37, -2)
/* 1314 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1315 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 1316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1317 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 1318 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1321 */     GroupLayout layout = new GroupLayout(this);
/* 1322 */     setLayout(layout);
/* 1323 */     layout.setHorizontalGroup(layout
/* 1324 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1325 */         .addGap(0, 1210, 32767)
/* 1326 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1327 */           .addGroup(layout.createSequentialGroup()
/* 1328 */             .addGap(0, 0, 32767)
/* 1329 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 1330 */             .addGap(0, 0, 32767))));
/*      */     
/* 1332 */     layout.setVerticalGroup(layout
/* 1333 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1334 */         .addGap(0, 419, 32767)
/* 1335 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1336 */           .addGroup(layout.createSequentialGroup()
/* 1337 */             .addContainerGap()
/* 1338 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1339 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 1344 */     this.jButton4.setEnabled(true);
/* 1345 */     this.jButton10.setEnabled(true);
/* 1346 */     String folio = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 1347 */     this.encontrado = this.con.consultar("count(numero)", "conceptos", "where factura =" + folio);
/* 1348 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1349 */     this.jLabel2.setText(folio);
/* 1350 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 1351 */           .buscarReg(4, totreg, "cantidad,concepto,precio_u,importe", "CONCEPTOS", "where factura = " + folio), (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1356 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1360 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 1364 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 1365 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1366 */     this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(120);
/* 1367 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(120);
/*      */     
/* 1369 */     this.jTable2.getColumnModel().getColumn(3).setPreferredWidth(120);
/* 1370 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(120);
/*      */     
/* 1372 */     this.jTable2.setSelectionMode(0);
/* 1373 */     this.jTable2.setAutoCreateRowSorter(true);
/* 1374 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/* 1375 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 1379 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 1380 */     this.jDateChooser5.setDate(this.fechaTermino);
/* 1381 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 1385 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 1389 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1393 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1397 */     String[] datos = { "FACTURA", "FECHA", "CLIENTE", "PEDIDO", "CONDICIONES", "EQUIPO", "POZO", "SUB-TOTAL", "IVA", "RET-IVA", "TOTAL", "LETRA" };
/* 1398 */     this.esc = new EscribirReporte("FACTURAS WEATHERFORD", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1402 */     sacarFecha();
/* 1403 */     this.jButton9.setEnabled(true);
/* 1404 */     this.jButton8.setEnabled(true);
/* 1405 */     limpiarTabla();
/* 1406 */     this.jTextField2.setText("");
/* 1407 */     this.jTextField1.setText("");
/* 1408 */     this.jTextField4.setText("");
/* 1409 */     this.jTextField9.setText("");
/* 1410 */     this.jTextField5.setText("");
/* 1411 */     this.jComboBox1.setSelectedIndex(0);
/* 1412 */     this.jLabel50.setText("00.00");
/* 1413 */     this.jTextField11.setText("00.00");
/* 1414 */     this.jLabel51.setText("00.00");
/* 1415 */     this.jLabel56.setText("00.00");
/* 1416 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 1420 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField11FocusGained(FocusEvent evt) {
/* 1424 */     if (this.jTextField11.getText() != null) {
/* 1425 */       String cant = this.jTextField11.getText();
/* 1426 */       String concat = "";
/* 1427 */       for (int j = 0; j < cant.length(); j++) {
/* 1428 */         if (cant.charAt(j) != ',') {
/* 1429 */           concat = concat + concat;
/*      */         }
/*      */       } 
/* 1432 */       this.jTextField11.setText(concat);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField11FocusLost(FocusEvent evt) {
/* 1437 */     sumarTotal();
/* 1438 */     NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1439 */     nf1.setMaximumFractionDigits(2);
/* 1440 */     nf1.setMinimumFractionDigits(2);
/* 1441 */     double ret = Double.parseDouble(this.jTextField11.getText());
/* 1442 */     this.jTextField11.setText(nf1.format(ret));
/*      */   }
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {
/* 1446 */     sumarTotal();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1450 */     if (this.jTextField2.getText().equals("")) {
/* 1451 */       this.jTextField2.setBackground(Color.red);
/* 1452 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el número de folio de la factura");
/*      */     }
/* 1454 */     else if (this.jComboBox1.getSelectedIndex() == 0) {
/* 1455 */       this.jComboBox1.setBackground(Color.red);
/* 1456 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas Seleccionar el equipo");
/*      */     }
/* 1458 */     else if (this.jTextField9.getText().equals("")) {
/* 1459 */       this.jTextField9.setBackground(Color.red);
/* 1460 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el pozo");
/*      */     }
/* 1462 */     else if (this.jTextField5.getText().equals("")) {
/* 1463 */       this.jTextField5.setBackground(Color.red);
/* 1464 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar la cantidad en letra");
/*      */     }
/*      */     else {
/*      */       
/* 1468 */       this.encontrado = false;
/* 1469 */       if (this.encontrado) {
/* 1470 */         JOptionPane.showMessageDialog(this.jDialog1, "El número de factura ya está registrado en la base de datos");
/*      */       } else {
/*      */         
/* 1473 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas imprimir la guía", "Imprimir Guía", 0, 3, this.PREG);
/* 1474 */         if (res == 0) {
/* 1475 */           String folio = this.jTextField2.getText();
/* 1476 */           String pedido = this.jTextField1.getText().toUpperCase();
/* 1477 */           String condiciones = this.jTextField4.getText();
/* 1478 */           String equipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 1479 */           String pozo = this.jTextField9.getText().toUpperCase();
/* 1480 */           String letra = this.jTextField5.getText();
/* 1481 */           this.con.inserSinMsj("insert into facturas(factura,fecha,expedicion,cliente,pedido,condiciones,equipo,pozo,sub_total,iva,ret_iva,total,letra,tipo)values(" + folio + ",now(),'POZA RICA','SCHULEMBERGER','" + pedido + "','" + condiciones + "','" + equipo + "','" + pozo + "','" + this.jLabel50
/* 1482 */               .getText() + "','" + this.jLabel51.getText() + "','" + this.jTextField11.getText() + "','" + this.jLabel56.getText() + "','" + letra + "','SCHULEMBERGER')");
/* 1483 */           for (int i = 0; i < this.CONTADOR; i++) {
/* 1484 */             this.con.inserSinMsj("insert into conceptos(cantidad,concepto,precio_u,importe,factura) values('" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "'," + folio + ")");
/*      */           }
/* 1486 */           imprimirFactura imp = new imprimirFactura();
/* 1487 */           String[] Datos = { folio, this.jLabel12.getText(), "POZA RICA", pedido, "Poza Rica", condiciones, equipo, pozo, this.jLabel50.getText(), this.jLabel51.getText(), this.jTextField11.getText(), this.jLabel56.getText(), letra, "1" };
/* 1488 */           imp.recibeDatos(Datos, this.jTable1, this.CONTADOR);
/* 1489 */           limpiarTabla();
/* 1490 */           consultar();
/* 1491 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1498 */     limpiarTabla();
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1502 */     this.jDialog1.setVisible(false);
/* 1503 */     limpiarTabla();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1507 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField6FocusLost(FocusEvent evt) {
/* 1511 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1515 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 1519 */     if (this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("")) {
/* 1520 */       JOptionPane.showMessageDialog(this.jDialog2, "Debes completar toda la información que se pide", "Falta Información", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1523 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas éste concepto", "Agregar Conceptos", 0, 3, this.PREG);
/* 1524 */       if (res == 0) {
/* 1525 */         NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1526 */         nf1.setMaximumFractionDigits(2);
/* 1527 */         nf1.setMinimumFractionDigits(2);
/*      */         
/* 1529 */         double dob = Double.parseDouble(this.jTextField6.getText());
/* 1530 */         this.jTable1.setValueAt(nf1.format(dob), this.CONTADOR, 0);
/* 1531 */         this.jTable1.setValueAt(this.jTextField7.getText(), this.CONTADOR, 1);
/* 1532 */         dob = Double.parseDouble(this.jTextField8.getText());
/* 1533 */         this.jTable1.setValueAt(nf1.format(dob), this.CONTADOR, 2);
/* 1534 */         this.jTable1.setValueAt(this.jTextField17.getText().toUpperCase(), this.CONTADOR, 3);
/*      */         
/* 1536 */         this.jTextField6.setText("");
/* 1537 */         this.jTextField7.setText("");
/* 1538 */         this.jTextField8.setText("");
/* 1539 */         this.jTextField17.setText("");
/* 1540 */         sumarTotal();
/* 1541 */         this.CONTADOR++;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField8FocusLost(FocusEvent evt) {
/* 1547 */     calcularImporte();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField17ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1563 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1567 */     this.CONTADOR = 3;
/* 1568 */     int indice = this.jTable3.getSelectedRow();
/* 1569 */     this.jLabel12.setText(String.valueOf(this.jTable3.getValueAt(indice, 1)));
/* 1570 */     this.jTextField2.setText(String.valueOf(this.jTable3.getValueAt(indice, 0)));
/* 1571 */     this.jTextField1.setText(String.valueOf(this.jTable3.getValueAt(indice, 3)));
/* 1572 */     this.jTextField4.setText(String.valueOf(this.jTable3.getValueAt(indice, 4)));
/* 1573 */     this.jComboBox1.setSelectedItem(String.valueOf(this.jTable3.getValueAt(indice, 5)));
/* 1574 */     this.jTextField9.setText(String.valueOf(this.jTable3.getValueAt(indice, 6)));
/* 1575 */     this.jTextField5.setText(String.valueOf(this.jTable3.getValueAt(indice, 11)));
/* 1576 */     this.jLabel50.setText(String.valueOf(this.jTable3.getValueAt(indice, 7)));
/* 1577 */     this.jLabel51.setText(String.valueOf(this.jTable3.getValueAt(indice, 8)));
/* 1578 */     this.jTextField11.setText(String.valueOf(this.jTable3.getValueAt(indice, 9)));
/* 1579 */     this.jLabel56.setText(String.valueOf(this.jTable3.getValueAt(indice, 10)));
/* 1580 */     this.jButton9.setEnabled(true);
/* 1581 */     this.jButton8.setEnabled(false);
/*      */     
/* 1583 */     String folio = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 1584 */     this.encontrado = this.con.consultar("count(numero)", "conceptos", "where factura =" + folio);
/* 1585 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1586 */     this.jLabel2.setText(folio);
/* 1587 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 1588 */           .buscarReg(4, totreg, "cantidad,concepto,precio_u,importe", "CONCEPTOS", "where factura = " + folio), (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1593 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1597 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1600 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 1601 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1602 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
/* 1603 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
/*      */     
/* 1605 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
/* 1606 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
/*      */     
/* 1608 */     this.jTable1.setSelectionMode(0);
/* 1609 */     this.jTable1.setAutoCreateRowSorter(true);
/* 1610 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 1612 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1616 */     int indice = this.jTable3.getSelectedRow();
/* 1617 */     String factura = String.valueOf(this.jTable3.getValueAt(indice, 0));
/* 1618 */     int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas eliminar la factura que seleccionaste?", "Eliminar Factura", 0, 3, this.PREG);
/* 1619 */     if (res == 0) {
/* 1620 */       this.con.eliminar("conceptos", "where factura = " + factura);
/* 1621 */       this.con.eliminar2("facturas", "where factura = " + factura);
/* 1622 */       consultar();
/*      */     } 
/*      */   }
/*      */   public void consultar() {
/* 1626 */     this.jButton4.setEnabled(false);
/* 1627 */     this.jButton10.setEnabled(false);
/* 1628 */     boolean correcto = true;
/* 1629 */     if (this.jDateChooser4.getDate() == null) {
/* 1630 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'AAAA-MM-DD'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 1631 */       if (res == 0) {
/* 1632 */         this.jDateChooser4.setDate(this.fechaActual);
/* 1633 */         correcto = true;
/*      */       } else {
/*      */         
/* 1636 */         correcto = false;
/*      */       }
/*      */     
/* 1639 */     } else if (this.jDateChooser5.getDate() == null) {
/* 1640 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'AAAA-MM-DD'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 1641 */       if (res == 0) {
/* 1642 */         Calendar ca = Calendar.getInstance();
/* 1643 */         Calendar fecha = Calendar.getInstance();
/* 1644 */         int aa = fecha.get(1);
/* 1645 */         int mm = fecha.get(2);
/* 1646 */         int dd = fecha.get(5);
/* 1647 */         int diasTotal = diasDelMes(mm, aa);
/* 1648 */         if (diasTotal == dd) {
/* 1649 */           dd = 1;
/* 1650 */           if (mm == 11) {
/* 1651 */             aa++;
/* 1652 */             mm = 0;
/*      */           } else {
/*      */             
/* 1655 */             mm++;
/*      */           } 
/*      */         } else {
/* 1658 */           dd++;
/*      */         } 
/* 1660 */         mm++;
/* 1661 */         String año = "" + aa;
/* 1662 */         String mes = "" + mm;
/* 1663 */         String dia = "" + dd;
/* 1664 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1665 */         String strFecha = año + "-" + año + "-" + mes;
/*      */         try {
/* 1667 */           this.fechaTermino = formatoDelTexto.parse(strFecha);
/*      */         }
/* 1669 */         catch (ParseException ex) {
/* 1670 */           ex.printStackTrace();
/*      */         } 
/* 1672 */         this.jDateChooser5.setDate(this.fechaTermino);
/* 1673 */         correcto = true;
/*      */       } else {
/*      */         
/* 1676 */         correcto = false;
/*      */       }
/*      */     
/* 1679 */     } else if (correcto) {
/* 1680 */       Date fecha1 = this.jDateChooser4.getDate();
/* 1681 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 1683 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1684 */       String cadenaFecha = "";
/* 1685 */       cadenaFecha = formato.format(fecha1);
/* 1686 */       String AÑO = cadenaFecha.substring(0, 4);
/* 1687 */       String MES = cadenaFecha.substring(4, 6);
/* 1688 */       String DIA = cadenaFecha.substring(6, 8);
/* 1689 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 1691 */       cadenaFecha = formato.format(fecha2);
/* 1692 */       AÑO = cadenaFecha.substring(0, 4);
/* 1693 */       MES = cadenaFecha.substring(4, 6);
/* 1694 */       DIA = cadenaFecha.substring(6, 8);
/* 1695 */       String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 1697 */       String folio = this.jTextField10.getText();
/* 1698 */       this.encontrado = this.con.consultar("count(factura)", "facturas", "where factura like '%" + folio + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and tipo = 'SCHULEMBERGER' order by factura desc");
/* 1699 */       int totreg = Integer.parseInt(this.con.Campo);
/* 1700 */       String tot = this.con.Campo;
/* 1701 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 1702 */       this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 1703 */             .buscarReg(12, totreg, "factura,fecha,cliente,pedido,condiciones,equipo,pozo,sub_total,iva,ret_iva,total,letra", "facturas", "where factura like '%" + folio + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and tipo = 'SCHULEMBERGER' order by factura desc"), (Object[])new String[] { "Factura", "Fecha", "Cliente", "Pedido", "Condiciones", "Equipo", "Pozo", "Sub-Total", "Iva", "Ret-Iva", "Total", "Letra" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 1708 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false };
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1712 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 1715 */       this.jTable3.setShowVerticalLines(false);
/* 1716 */       this.jScrollPane3.setViewportView(this.jTable3);
/*      */       
/* 1718 */       this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 1719 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 1720 */       this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(60);
/* 1721 */       this.jTable3.getColumnModel().getColumn(1).setMaxWidth(60);
/* 1722 */       this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(90);
/* 1723 */       this.jTable3.getColumnModel().getColumn(2).setMaxWidth(90);
/*      */       
/* 1725 */       this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 1726 */       this.jTable3.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */       
/* 1728 */       this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 1729 */       this.jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
/* 1730 */       this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(110);
/* 1731 */       this.jTable3.getColumnModel().getColumn(6).setMaxWidth(110);
/* 1732 */       this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(90);
/* 1733 */       this.jTable3.getColumnModel().getColumn(7).setMaxWidth(90);
/* 1734 */       this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 1735 */       this.jTable3.getColumnModel().getColumn(8).setMaxWidth(80);
/* 1736 */       this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(80);
/* 1737 */       this.jTable3.getColumnModel().getColumn(9).setMaxWidth(80);
/* 1738 */       this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(90);
/* 1739 */       this.jTable3.getColumnModel().getColumn(10).setMaxWidth(90);
/*      */       
/* 1741 */       this.jTable3.setSelectionMode(0);
/* 1742 */       this.jTable3.setAutoCreateRowSorter(true);
/* 1743 */       this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/*      */   }
/*      */   public void dowell(String usu) {
/* 1747 */     this.USUARIO = usu;
/* 1748 */     this.panel.setViewportView(this);
/* 1749 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1750 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 1751 */     consultar();
/*      */   }
/*      */   public void colorear() {
/* 1754 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1756 */             dowell.this.jTextGanado(dowell.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1759 */             dowell.this.jTextPerdido(dowell.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 1762 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1764 */             dowell.this.jTextGanado(dowell.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1767 */             dowell.this.jTextPerdido(dowell.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 1770 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1772 */             dowell.this.jTextGanado(dowell.this.jTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1775 */             dowell.this.jTextPerdido(dowell.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 1778 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1780 */             dowell.this.jTextGanado(dowell.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1783 */             dowell.this.jTextPerdido(dowell.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 1786 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1788 */             dowell.this.jTextGanado(dowell.this.jTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1791 */             dowell.this.jTextPerdido(dowell.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 1794 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1796 */             dowell.this.jTextGanado(dowell.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1799 */             dowell.this.jTextPerdido(dowell.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 1802 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1804 */             dowell.this.jTextGanado(dowell.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1807 */             dowell.this.jTextPerdido(dowell.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 1810 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1812 */             dowell.this.jTextGanado(dowell.this.jTextField8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1815 */             dowell.this.jTextPerdido(dowell.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 1818 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1820 */             dowell.this.jTextGanado(dowell.this.jTextField9, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1823 */             dowell.this.jTextPerdido(dowell.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 1826 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1828 */             dowell.this.jTextGanado(dowell.this.jTextField10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1831 */             dowell.this.jTextPerdido(dowell.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 1834 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1836 */             dowell.this.jTextGanado(dowell.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1839 */             dowell.this.jTextPerdido(dowell.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1844 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1847 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void llenarCombo() {
/* 1850 */     this.con.consultar("count(equipo)", "equipos", "where num_equipo<>0");
/* 1851 */     String[] plataformas = this.con.regresaCol("equipo", "equipos", "where num_equipo<>0 order by equipo", Integer.parseInt(this.con.Campo));
/*      */     
/* 1853 */     this.jComboBox1.removeAllItems();
/* 1854 */     this.jComboBox1.addItem("Selecciona uno...");
/* 1855 */     for (int i = 0; i < plataformas.length; i++)
/* 1856 */       this.jComboBox1.addItem(plataformas[i]); 
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 1860 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1868 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1874 */         return 30;
/*      */       
/*      */       case 1:
/* 1877 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 1879 */           return 29;
/*      */         }
/* 1881 */         return 28;
/*      */     } 
/*      */     
/* 1884 */     return 0;
/*      */   }
/*      */   
/*      */   public void sacarFecha() {
/* 1888 */     Calendar ahoraCal = Calendar.getInstance();
/* 1889 */     ahoraCal.setTime(this.fecha);
/* 1890 */     String mesesito = "";
/* 1891 */     String hoy = "";
/* 1892 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 1893 */     hoy = "" + ahoraCal.get(5);
/* 1894 */     if (ahoraCal.get(2) + 1 < 10) {
/* 1895 */       mesesito = "0" + mesesito;
/*      */     }
/* 1897 */     if (ahoraCal.get(5) < 10) {
/* 1898 */       hoy = "0" + hoy;
/*      */     }
/* 1900 */     String letra = "";
/* 1901 */     if (mesesito.equals("01")) {
/* 1902 */       letra = "Enero";
/*      */     }
/* 1904 */     else if (mesesito.equals("02")) {
/* 1905 */       letra = "Febrero";
/*      */     }
/* 1907 */     else if (mesesito.equals("03")) {
/* 1908 */       letra = "Marzo";
/*      */     }
/* 1910 */     else if (mesesito.equals("04")) {
/* 1911 */       letra = "Abril";
/*      */     }
/* 1913 */     else if (mesesito.equals("05")) {
/* 1914 */       letra = "Mayo";
/*      */     }
/* 1916 */     else if (mesesito.equals("06")) {
/* 1917 */       letra = "Junio";
/*      */     }
/* 1919 */     else if (mesesito.equals("07")) {
/* 1920 */       letra = "Julio";
/*      */     }
/* 1922 */     else if (mesesito.equals("08")) {
/* 1923 */       letra = "Agosto";
/*      */     }
/* 1925 */     else if (mesesito.equals("09")) {
/* 1926 */       letra = "Septiembre";
/*      */     }
/* 1928 */     else if (mesesito.equals("10")) {
/* 1929 */       letra = "Octubre";
/*      */     }
/* 1931 */     else if (mesesito.equals("11")) {
/* 1932 */       letra = "Noviembre";
/*      */     }
/* 1934 */     else if (mesesito.equals("12")) {
/* 1935 */       letra = "Diciembre";
/*      */     } 
/* 1937 */     this.jLabel12.setText(hoy + " " + hoy + " " + letra);
/*      */   }
/*      */   public void calcularImporte() {
/* 1940 */     if (!this.jTextField6.getText().equals("") && !this.jTextField8.getText().equals(""))
/*      */       try {
/* 1942 */         double cant = Double.parseDouble(this.jTextField6.getText());
/* 1943 */         double pre = Double.parseDouble(this.jTextField8.getText());
/* 1944 */         double im = cant * pre;
/* 1945 */         NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1946 */         nf1.setMaximumFractionDigits(2);
/* 1947 */         nf1.setMinimumFractionDigits(2);
/* 1948 */         this.jTextField17.setText(nf1.format(im));
/*      */       }
/* 1950 */       catch (NumberFormatException n) {
/* 1951 */         JOptionPane.showMessageDialog(this.jDialog2, "Los campos de cantidad y precio deben contener sólo números");
/*      */       }  
/*      */   }
/*      */   
/*      */   public void sumarTotal() {
/* 1956 */     double subTotal = 0.0D;
/* 1957 */     double iva = 0.0D;
/* 1958 */     NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1959 */     nf1.setMaximumFractionDigits(2);
/* 1960 */     nf1.setMinimumFractionDigits(2);
/* 1961 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1962 */       if (this.jTable1.getValueAt(i, 3) != null) {
/* 1963 */         String cant = String.valueOf(this.jTable1.getValueAt(i, 3));
/* 1964 */         String concat = "";
/* 1965 */         for (int j = 0; j < cant.length(); j++) {
/* 1966 */           if (cant.charAt(j) != ',') {
/* 1967 */             concat = concat + concat;
/*      */           }
/*      */         } 
/* 1970 */         subTotal += Double.parseDouble(concat);
/*      */       } 
/*      */     } 
/* 1973 */     this.jLabel50.setText(nf1.format(subTotal));
/* 1974 */     iva = subTotal * 0.16D;
/* 1975 */     this.jLabel51.setText(nf1.format(iva));
/* 1976 */     if (this.jTextField11.getText().equals("")) {
/* 1977 */       this.jTextField11.setText("00.00");
/*      */     }
/* 1979 */     double ret = Double.parseDouble(this.jTextField11.getText());
/* 1980 */     double Tot = subTotal - ret + iva;
/* 1981 */     this.jLabel56.setText(nf1.format(Tot));
/*      */   }
/*      */   public void limpiarTabla() {
/* 1984 */     this.jTable1 = new JTable();
/* 1985 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
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
/* 2000 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2004 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2007 */     this.jTable1.setEditingRow(0);
/* 2008 */     this.jTable1.setSelectionMode(0);
/* 2009 */     this.jTable1.setShowHorizontalLines(false);
/* 2010 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 2011 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(100);
/* 2012 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
/* 2013 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(150);
/* 2014 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
/* 2015 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(150);
/* 2016 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
/* 2017 */     this.CONTADOR = 0;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/dowell.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */