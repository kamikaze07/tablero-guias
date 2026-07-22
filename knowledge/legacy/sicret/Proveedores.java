/*      */ package sicret;
/*      */ 
/*      */ import Fuentes.Fuentes;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Point;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.IOException;
/*      */ import java.net.URL;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.plaf.ScrollBarUI;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableColumn;
/*      */ import net.sf.jasperreports.engine.JRDataSource;
/*      */ import net.sf.jasperreports.engine.JREmptyDataSource;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperFillManager;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import rojerusan.necesario.RSScrollBar;
/*      */ import utilerias.catMunicipios;
/*      */ import utilerias.pintarComponentes;
/*      */ 
/*      */ public class Proveedores
/*      */   extends JPanel {
/*      */   JScrollPane panel;
/*   75 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*      */   
/*   77 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   
/*   79 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   
/*   81 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*      */   
/*   83 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*      */   
/*   85 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*      */   
/*   87 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   
/*   89 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*      */   
/*   91 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*   93 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*      */   
/*   95 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   
/*   97 */   JFrame padre = null;
/*      */   
/*   99 */   JTabbedPane fichas = null;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   
/*  103 */   MensajePop mensajeTry = null;
/*      */   
/*      */   String USUARIO;
/*      */   
/*  107 */   SColores lc = new SColores();
/*      */   
/*  109 */   Fuentes fuentes = new Fuentes();
/*      */   
/*  111 */   PlaceHolder placeHolder = null;
/*      */   
/*  113 */   Consultas2 con = new Consultas2();
/*      */   
/*  115 */   String[] SUCURSALES = null;
/*      */   
/*  117 */   String holderRazonSocial = "RAZÓN SOCIAL";
/*      */   
/*  119 */   String holderRfc = "RFC";
/*      */   
/*  121 */   ArrayList TODOS_SUCURSALES = new ArrayList();
/*      */   
/*  123 */   ArrayList TODOS_MUNICIPIOS = new ArrayList();
/*      */   
/*  125 */   ArrayList TODOS_ESTADOS = new ArrayList();
/*      */   
/*  127 */   TextAutoCompleter com_Sucursales = null;
/*      */   
/*  129 */   TextAutoCompleter com_Municipios = null;
/*      */   
/*  131 */   TextAutoCompleter com_Estados = null;
/*      */   
/*  133 */   Validaciones val = new Validaciones();
/*      */   
/*  135 */   Errores error = new Errores(false);
/*      */   
/*      */   JLabel EtiquetaEstado;
/*      */   
/*  139 */   Cursor micursor = null;
/*      */   
/*      */   boolean entraCatMon = false;
/*      */   
/*      */   boolean entraCatPais = false;
/*      */   
/*      */   boolean entraCatMunicipios = false;
/*      */   
/*      */   EscribirReporte esc;
/*      */   
/*  149 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*  151 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   
/*  153 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*  155 */   Presionado presionado = null;
/*      */   
/*  157 */   String NUMPROV = "";
/*      */   
/*  159 */   String ACTIVARSUC = "";
/*      */   
/*      */   boolean entraSucPrimera = false;
/*      */   
/*  163 */   String ULTIMOUSUARIO = "";
/*      */   
/*      */   private ButtonGroup buttonGroup1;
/*      */   
/*      */   private JButton jButton1;
/*      */   
/*      */   private JButton jButton2;
/*      */   
/*      */   private JButton jButton25;
/*      */   
/*      */   private JButton jButton34;
/*      */   
/*      */   private JButton jButton5;
/*      */   
/*      */   private JButton jButton55;
/*      */   
/*      */   private JButton jButton56;
/*      */   
/*      */   private JButton jButton57;
/*      */   
/*      */   private JButton jButton6;
/*      */   
/*      */   private JButton jButton9;
/*      */   
/*      */   private JComboBox jComboBox1;
/*      */   
/*      */   private JComboBox jComboBox2;
/*      */   
/*      */   private JComboBox jComboBox3;
/*      */   
/*      */   private JDialog jDialog1;
/*      */   
/*      */   private JDialog jDialog2;
/*      */   
/*      */   private JDialog jDialog3;
/*      */   
/*      */   private JDialog jDialog4;
/*      */   
/*      */   private JLabel jLabel1;
/*      */   
/*      */   private JLabel jLabel10;
/*      */   
/*      */   private JLabel jLabel11;
/*      */   
/*      */   private JLabel jLabel12;
/*      */   
/*      */   private JLabel jLabel13;
/*      */   
/*      */   private JLabel jLabel14;
/*      */   
/*      */   private JLabel jLabel15;
/*      */   
/*      */   private JLabel jLabel16;
/*      */   
/*      */   private JLabel jLabel17;
/*      */   
/*      */   private JLabel jLabel18;
/*      */   
/*      */   private JLabel jLabel19;
/*      */   
/*      */   private JLabel jLabel2;
/*      */   
/*      */   private JLabel jLabel20;
/*      */   
/*      */   private JLabel jLabel21;
/*      */   
/*      */   private JLabel jLabel22;
/*      */   
/*      */   private JLabel jLabel23;
/*      */   
/*      */   private JLabel jLabel24;
/*      */   
/*      */   private JLabel jLabel25;
/*      */   
/*      */   private JLabel jLabel26;
/*      */   
/*      */   private JLabel jLabel27;
/*      */   
/*      */   private JLabel jLabel28;
/*      */   
/*      */   private JLabel jLabel29;
/*      */   
/*      */   private JLabel jLabel3;
/*      */   
/*      */   private JLabel jLabel30;
/*      */   
/*      */   private JLabel jLabel31;
/*      */   
/*      */   private JLabel jLabel32;
/*      */   
/*      */   private JLabel jLabel4;
/*      */   
/*      */   private JLabel jLabel48;
/*      */   
/*      */   private JLabel jLabel5;
/*      */   
/*      */   private JLabel jLabel55;
/*      */   
/*      */   private JLabel jLabel6;
/*      */   
/*      */   private JLabel jLabel7;
/*      */   
/*      */   private JLabel jLabel8;
/*      */   
/*      */   private JLabel jLabel9;
/*      */   
/*      */   private JPanel jPanel1;
/*      */   
/*      */   private JPanel jPanel10;
/*      */   
/*      */   private JPanel jPanel102;
/*      */   
/*      */   private JPanel jPanel103;
/*      */   
/*      */   private JPanel jPanel11;
/*      */   
/*      */   private JPanel jPanel13;
/*      */   
/*      */   private JPanel jPanel133;
/*      */   
/*      */   private JPanel jPanel134;
/*      */   
/*      */   private JPanel jPanel135;
/*      */   
/*      */   private JPanel jPanel136;
/*      */   
/*      */   private JPanel jPanel137;
/*      */   
/*      */   private JPanel jPanel138;
/*      */   
/*      */   private JPanel jPanel14;
/*      */   
/*      */   private JPanel jPanel15;
/*      */   
/*      */   private JPanel jPanel16;
/*      */   
/*      */   private JPanel jPanel17;
/*      */   
/*      */   private JPanel jPanel18;
/*      */   
/*      */   private JPanel jPanel19;
/*      */   
/*      */   private JPanel jPanel2;
/*      */   
/*      */   private JPanel jPanel20;
/*      */   
/*      */   private JPanel jPanel24;
/*      */   
/*      */   private JPanel jPanel25;
/*      */   
/*      */   private JPanel jPanel26;
/*      */   
/*      */   private JPanel jPanel27;
/*      */   
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private JPanel jPanel30;
/*      */   
/*      */   private JPanel jPanel31;
/*      */   
/*      */   private JPanel jPanel4;
/*      */   
/*      */   private JPanel jPanel48;
/*      */   
/*      */   private JPanel jPanel49;
/*      */   
/*      */   private JPanel jPanel5;
/*      */   
/*      */   private JPanel jPanel6;
/*      */   
/*      */   private JPanel jPanel7;
/*      */   
/*      */   private JPanel jPanel8;
/*      */   
/*      */   private JPanel jPanel9;
/*      */   
/*      */   private JRadioButton jRadioButton1;
/*      */   
/*      */   private JRadioButton jRadioButton2;
/*      */   
/*      */   private JScrollPane jScrollPane1;
/*      */   
/*      */   private JScrollPane jScrollPane23;
/*      */   
/*      */   private JScrollPane jScrollPane29;
/*      */   
/*      */   private JScrollPane jScrollPane31;
/*      */   
/*      */   private JScrollPane jScrollPane32;
/*      */   
/*      */   private JScrollPane jScrollPane33;
/*      */   
/*      */   private JTextField jTextField1;
/*      */   
/*      */   private JTextField jTextField10;
/*      */   
/*      */   private JTextField jTextField14;
/*      */   
/*      */   private JTextField jTextField15;
/*      */   
/*      */   private JTextField jTextField16;
/*      */   
/*      */   private JTextField jTextField17;
/*      */   
/*      */   private JTextField jTextField18;
/*      */   
/*      */   private JTextField jTextField19;
/*      */   
/*      */   private JTextField jTextField2;
/*      */   
/*      */   private JTextField jTextField20;
/*      */   
/*      */   private JTextField jTextField21;
/*      */   
/*      */   private JTextField jTextField22;
/*      */   
/*      */   private JTextField jTextField23;
/*      */   
/*      */   private JTextField jTextField24;
/*      */   
/*      */   private JTextField jTextField25;
/*      */   
/*      */   private JTextField jTextField3;
/*      */   
/*      */   private JTextField jTextField4;
/*      */   
/*      */   private JTextField jTextField5;
/*      */   
/*      */   private JTextField jTextField6;
/*      */   
/*      */   private JTextField jTextField7;
/*      */   
/*      */   private JTextField jTextField8;
/*      */   
/*      */   private JTextField jTextField85;
/*      */   
/*      */   private JTextField jTextField86;
/*      */   
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private MaterialButton materialButton21;
/*      */   
/*      */   private MaterialButton materialButton22;
/*      */   
/*      */   private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private RSTableMetro rSTableMetro4;
/*      */   
/*      */   private RSTableMetro rSTableMetro6;
/*      */   
/*      */   public Proveedores(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES) {
/*  418 */     this.EtiquetaEstado = EtiquetaEstado;
/*  419 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  420 */     this.mensajeTry = mensajeTry;
/*  421 */     this.padre = padre;
/*  422 */     this.fichas = fichas;
/*  423 */     this.USUARIO = USUARIO;
/*  424 */     this.panel = panelito;
/*  425 */     this.con.setBaseDatos("sicre2PR");
/*  426 */     this.con.cambiarServidor();
/*  427 */     this.panel.setViewportView(this);
/*  428 */     initComponents();
/*  429 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderRazonSocial, false, "Century Gothic", 11);
/*  430 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderRfc, false, "Century Gothic", 11);
/*  431 */     this.buttonGroup1.add(this.jRadioButton2);
/*  432 */     this.buttonGroup1.add(this.jRadioButton1);
/*  433 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  434 */     Cursor micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  435 */     this.rSTableMetro1.setCursor(micursor);
/*  436 */     this.rSTableMetro2.setCursor(micursor);
/*  437 */     this.rSTableMetro3.setCursor(micursor);
/*  438 */     this.rSTableMetro4.setCursor(micursor);
/*  439 */     this.rSTableMetro6.setCursor(micursor);
/*  440 */     this.jDialog1.setCursor(micursor);
/*  441 */     this.jDialog2.setCursor(micursor);
/*  442 */     this.jDialog3.setCursor(micursor);
/*  443 */     this.jDialog4.setCursor(micursor);
/*  444 */     this.jScrollPane31.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  445 */     this.jScrollPane32.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  446 */     this.jScrollPane33.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  447 */     int w = this.tama.width;
/*  448 */     int h = this.tama.height;
/*  449 */     int rw = (w - 870) / 2;
/*  450 */     int rh = (h - 10) / 2;
/*  451 */     rw = (w - 450) / 2;
/*  452 */     rh = (h - 200) / 2;
/*  453 */     this.jDialog1.setLocation(rw, rh);
/*  454 */     this.jDialog1.setSize(380, 160);
/*  455 */     this.jDialog1.setResizable(false);
/*  456 */     rw = (w - 650) / 2;
/*  457 */     rh = (h - 280) / 2;
/*  458 */     this.jDialog2.setLocation(rw, rh);
/*  459 */     this.jDialog2.setSize(650, 280);
/*  460 */     this.jDialog2.setResizable(false);
/*  461 */     rw = (w - 650) / 2;
/*  462 */     rh = (h - 250) / 2;
/*  463 */     this.jDialog3.setLocation(rw, rh);
/*  464 */     this.jDialog3.setSize(600, 230);
/*  465 */     this.jDialog3.setResizable(false);
/*  466 */     rw = (w - 680) / 2;
/*  467 */     rh = (h - 280) / 2;
/*  468 */     this.jDialog4.setLocation(rw, rh);
/*  469 */     this.jDialog4.setSize(680, 280);
/*  470 */     this.jDialog4.setResizable(false);
/*  471 */     this.rSTableMetro6.setSelectionMode(0);
/*  472 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/*  473 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/*  474 */     llenarCombo();
/*  475 */     privilegios();
/*  476 */     llenarSucursales();
/*  477 */     consultar();
/*  478 */     colorear();
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  482 */     this.jPanel3 = new JPanel();
/*  483 */     this.jPanel4 = new JPanel();
/*  484 */     this.jLabel1 = new JLabel();
/*  485 */     this.jLabel16 = new JLabel();
/*  486 */     this.jPanel6 = new JPanel();
/*  487 */     this.materialButton21 = new MaterialButton();
/*  488 */     this.materialButton22 = new MaterialButton();
/*  489 */     this.jPanel7 = new JPanel();
/*  490 */     this.jPanel9 = new JPanel();
/*  491 */     this.jLabel4 = new JLabel();
/*  492 */     this.jPanel15 = new JPanel();
/*  493 */     this.jTextField14 = new JTextField();
/*  494 */     this.jPanel16 = new JPanel();
/*  495 */     this.jLabel20 = new JLabel();
/*  496 */     this.jRadioButton1 = new JRadioButton();
/*  497 */     this.jLabel5 = new JLabel();
/*  498 */     this.jTextField15 = new JTextField();
/*  499 */     this.jLabel23 = new JLabel();
/*  500 */     this.jTextField19 = new JTextField();
/*  501 */     this.jLabel27 = new JLabel();
/*  502 */     this.jTextField23 = new JTextField();
/*  503 */     this.jLabel19 = new JLabel();
/*  504 */     this.jTextField8 = new JTextField();
/*  505 */     this.jLabel10 = new JLabel();
/*  506 */     this.jTextField4 = new JTextField();
/*  507 */     this.jLabel12 = new JLabel();
/*  508 */     this.jPanel134 = new JPanel();
/*  509 */     this.jTextField25 = new JTextField();
/*  510 */     this.jButton57 = new JButton();
/*  511 */     this.jPanel11 = new JPanel();
/*  512 */     this.jPanel20 = new JPanel();
/*  513 */     this.jPanel26 = new JPanel();
/*  514 */     this.jRadioButton2 = new JRadioButton();
/*  515 */     this.jPanel27 = new JPanel();
/*  516 */     this.jLabel6 = new JLabel();
/*  517 */     this.jTextField16 = new JTextField();
/*  518 */     this.jLabel24 = new JLabel();
/*  519 */     this.jTextField20 = new JTextField();
/*  520 */     this.jLabel28 = new JLabel();
/*  521 */     this.jTextField24 = new JTextField();
/*  522 */     this.jLabel21 = new JLabel();
/*  523 */     this.jTextField9 = new JTextField();
/*  524 */     this.jLabel11 = new JLabel();
/*  525 */     this.jTextField5 = new JTextField();
/*  526 */     this.jLabel17 = new JLabel();
/*  527 */     this.jComboBox3 = new JComboBox();
/*  528 */     this.jPanel13 = new JPanel();
/*  529 */     this.jLabel29 = new JLabel();
/*  530 */     this.jLabel31 = new JLabel();
/*  531 */     this.jLabel32 = new JLabel();
/*  532 */     this.jLabel30 = new JLabel();
/*  533 */     this.jLabel7 = new JLabel();
/*  534 */     this.jTextField17 = new JTextField();
/*  535 */     this.jLabel25 = new JLabel();
/*  536 */     this.jTextField21 = new JTextField();
/*  537 */     this.jLabel2 = new JLabel();
/*  538 */     this.jPanel133 = new JPanel();
/*  539 */     this.jTextField85 = new JTextField();
/*  540 */     this.jButton55 = new JButton();
/*  541 */     this.jLabel22 = new JLabel();
/*  542 */     this.jTextField10 = new JTextField();
/*  543 */     this.jLabel13 = new JLabel();
/*  544 */     this.jTextField6 = new JTextField();
/*  545 */     this.jPanel14 = new JPanel();
/*  546 */     this.jPanel19 = new JPanel();
/*  547 */     this.jPanel30 = new JPanel();
/*  548 */     this.jPanel31 = new JPanel();
/*  549 */     this.jPanel24 = new JPanel();
/*  550 */     this.jLabel8 = new JLabel();
/*  551 */     this.jTextField18 = new JTextField();
/*  552 */     this.jLabel26 = new JLabel();
/*  553 */     this.jTextField22 = new JTextField();
/*  554 */     this.jLabel3 = new JLabel();
/*  555 */     this.jTextField3 = new JTextField();
/*  556 */     this.jLabel9 = new JLabel();
/*  557 */     this.jPanel136 = new JPanel();
/*  558 */     this.jTextField86 = new JTextField();
/*  559 */     this.jButton56 = new JButton();
/*  560 */     this.jLabel18 = new JLabel();
/*  561 */     this.jPanel103 = new JPanel();
/*  562 */     this.jTextField7 = new JTextField();
/*  563 */     this.jButton34 = new JButton();
/*  564 */     this.jPanel18 = new JPanel();
/*  565 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  566 */     this.jPanel135 = new JPanel();
/*  567 */     this.jScrollPane32 = new JScrollPane();
/*  568 */     this.rSTableMetro2 = new RSTableMetro();
/*  569 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  570 */     this.jPanel137 = new JPanel();
/*  571 */     this.jScrollPane31 = new JScrollPane();
/*  572 */     this.rSTableMetro3 = new RSTableMetro();
/*  573 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  574 */     this.jPanel138 = new JPanel();
/*  575 */     this.jScrollPane23 = new JScrollPane();
/*  576 */     this.rSTableMetro4 = new RSTableMetro();
/*  577 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  578 */     this.jPanel102 = new JPanel();
/*  579 */     this.jScrollPane33 = new JScrollPane();
/*  580 */     this.rSTableMetro6 = new RSTableMetro();
/*  581 */     this.jPanel25 = new JPanel();
/*  582 */     this.buttonGroup1 = new ButtonGroup();
/*  583 */     this.jPanel2 = new JPanel();
/*  584 */     this.jPanel8 = new JPanel();
/*  585 */     this.jLabel55 = new JLabel();
/*  586 */     this.jPanel17 = new JPanel();
/*  587 */     this.jTextField1 = new JTextField();
/*  588 */     this.jTextField2 = new JTextField();
/*  589 */     this.jComboBox2 = new JComboBox();
/*  590 */     this.jComboBox1 = new JComboBox();
/*  591 */     this.jPanel1 = new JPanel();
/*  592 */     this.jPanel10 = new JPanel();
/*  593 */     this.jPanel48 = new JPanel();
/*  594 */     this.jPanel49 = new JPanel();
/*  595 */     this.jLabel14 = new JLabel();
/*  596 */     this.jLabel48 = new JLabel();
/*  597 */     this.jLabel15 = new JLabel();
/*  598 */     this.jButton2 = new JButton();
/*  599 */     this.jButton1 = new JButton();
/*  600 */     this.jButton6 = new JButton();
/*  601 */     this.jButton25 = new JButton();
/*  602 */     this.jButton9 = new JButton();
/*  603 */     this.jButton5 = new JButton();
/*  604 */     this.jScrollPane1 = new JScrollPane();
/*  605 */     this.jPanel5 = new JPanel();
/*  606 */     this.jScrollPane29 = new JScrollPane();
/*  607 */     this.rSTableMetro1 = new RSTableMetro();
/*  608 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*  609 */     this.jPanel3.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*  610 */     this.jPanel4.setBackground(this.lc.SECUNDARIO1);
/*  611 */     this.jLabel1.setFont(new Font("Cantarell", 1, 22));
/*  612 */     this.jLabel1.setForeground(this.lc.PRIMARIO2);
/*  613 */     this.jLabel1.setHorizontalAlignment(0);
/*  614 */     this.jLabel1.setText("Agregar Proveedor");
/*  615 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  616 */     this.jLabel16.setToolTipText("Cerrar");
/*  617 */     this.jLabel16.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  619 */             Proveedores.this.jLabel16MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/*  623 */             Proveedores.this.jLabel16MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/*  627 */             Proveedores.this.jLabel16MouseExited(evt);
/*      */           }
/*      */         });
/*  630 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  631 */     this.jPanel4.setLayout(jPanel4Layout);
/*  632 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  633 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  634 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  635 */           .addContainerGap()
/*  636 */           .addComponent(this.jLabel1, -1, 885, 32767)
/*  637 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  638 */           .addComponent(this.jLabel16)
/*  639 */           .addContainerGap()));
/*  640 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  641 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  642 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  643 */           .addContainerGap()
/*  644 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  645 */             .addComponent(this.jLabel1, -1, -1, 32767)
/*  646 */             .addComponent(this.jLabel16, -1, -1, 32767))
/*  647 */           .addContainerGap(-1, 32767)));
/*  648 */     this.jPanel6.setBackground(this.lc.SECUNDARIO2);
/*  649 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  650 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  651 */     this.materialButton21.setMnemonic('C');
/*  652 */     this.materialButton21.setText("Cerrar");
/*  653 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/*  654 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  655 */     this.materialButton21.setHorizontalTextPosition(0);
/*  656 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  658 */             Proveedores.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*  661 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  662 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  663 */     this.materialButton22.setMnemonic('G');
/*  664 */     this.materialButton22.setText("Guardar");
/*  665 */     this.materialButton22.setToolTipText("Guardar (Alt +G)");
/*  666 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  667 */     this.materialButton22.setHorizontalTextPosition(0);
/*  668 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  670 */             Proveedores.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*  673 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  674 */     this.jPanel6.setLayout(jPanel6Layout);
/*  675 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  676 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  677 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  678 */           .addContainerGap(-1, 32767)
/*  679 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  680 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  681 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/*  682 */           .addContainerGap()));
/*  683 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */         .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  686 */         .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2));
/*  687 */     this.jPanel7.setBackground(new Color(255, 255, 255));
/*  688 */     this.jPanel7.setLayout(new GridLayout(1, 4, 15, 0));
/*  689 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*  690 */     this.jPanel9.setLayout(new GridLayout(8, 2, 6, 6));
/*  691 */     this.jLabel4.setHorizontalAlignment(4);
/*  692 */     this.jLabel4.setText(" Clave del proveedor");
/*  693 */     this.jPanel9.add(this.jLabel4);
/*  694 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/*  695 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*  696 */     this.jTextField14.setEditable(false);
/*  697 */     this.jTextField14.setText("jTextField14");
/*  698 */     this.jPanel15.add(this.jTextField14);
/*  699 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/*  700 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/*  701 */     this.jPanel16.setLayout(jPanel16Layout);
/*  702 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/*  703 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  704 */         .addGap(0, 50, 32767));
/*  705 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/*  706 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  707 */         .addGap(0, 29, 32767));
/*  708 */     this.jPanel15.add(this.jPanel16);
/*  709 */     this.jPanel9.add(this.jPanel15);
/*  710 */     this.jLabel20.setHorizontalAlignment(4);
/*  711 */     this.jLabel20.setText("Tipo de proveedor");
/*  712 */     this.jPanel9.add(this.jLabel20);
/*  713 */     this.jRadioButton1.setText("Persona Moral");
/*  714 */     this.jRadioButton1.setHorizontalAlignment(0);
/*  715 */     this.jRadioButton1.setHorizontalTextPosition(4);
/*  716 */     this.jPanel9.add(this.jRadioButton1);
/*  717 */     this.jLabel5.setHorizontalAlignment(4);
/*  718 */     this.jLabel5.setText(" Razón social o Nombre");
/*  719 */     this.jPanel9.add(this.jLabel5);
/*  720 */     this.jTextField15.setText("jTextField15");
/*  721 */     this.jTextField15.setNextFocusableComponent(this.jTextField16);
/*  722 */     this.jPanel9.add(this.jTextField15);
/*  723 */     this.jLabel23.setHorizontalAlignment(4);
/*  724 */     this.jLabel23.setText(" Calle");
/*  725 */     this.jPanel9.add(this.jLabel23);
/*  726 */     this.jTextField19.setText("jTextField19");
/*  727 */     this.jTextField19.setNextFocusableComponent(this.jTextField20);
/*  728 */     this.jPanel9.add(this.jTextField19);
/*  729 */     this.jLabel27.setHorizontalAlignment(4);
/*  730 */     this.jLabel27.setText(" Ciudad");
/*  731 */     this.jPanel9.add(this.jLabel27);
/*  732 */     this.jTextField23.setText("jTextField23");
/*  733 */     this.jTextField23.setNextFocusableComponent(this.jTextField24);
/*  734 */     this.jTextField23.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  736 */             Proveedores.this.jTextField23FocusGained(evt);
/*      */           }
/*      */         });
/*  739 */     this.jPanel9.add(this.jTextField23);
/*  740 */     this.jLabel19.setHorizontalAlignment(4);
/*  741 */     this.jLabel19.setText("Banco");
/*  742 */     this.jPanel9.add(this.jLabel19);
/*  743 */     this.jTextField8.setText("jTextField8");
/*  744 */     this.jTextField8.setNextFocusableComponent(this.jTextField9);
/*  745 */     this.jPanel9.add(this.jTextField8);
/*  746 */     this.jLabel10.setHorizontalAlignment(4);
/*  747 */     this.jLabel10.setText("Nombre del contacto");
/*  748 */     this.jPanel9.add(this.jLabel10);
/*  749 */     this.jTextField4.setText("jTextField4");
/*  750 */     this.jTextField4.setNextFocusableComponent(this.jTextField5);
/*  751 */     this.jPanel9.add(this.jTextField4);
/*  752 */     this.jLabel12.setHorizontalAlignment(4);
/*  753 */     this.jLabel12.setText("Sucursal Operativa");
/*  754 */     this.jPanel9.add(this.jLabel12);
/*  755 */     this.jPanel134.setBackground(new Color(255, 255, 255));
/*  756 */     this.jTextField25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  758 */             Proveedores.this.jTextField25ActionPerformed(evt);
/*      */           }
/*      */         });
/*  761 */     this.jButton57.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  762 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  764 */             Proveedores.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/*  767 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/*  768 */     this.jPanel134.setLayout(jPanel134Layout);
/*  769 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/*  770 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  771 */         .addGroup(jPanel134Layout.createSequentialGroup()
/*  772 */           .addComponent(this.jTextField25)
/*  773 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  774 */           .addComponent(this.jButton57, -2, 18, -2)));
/*  775 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/*  776 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  777 */         .addComponent(this.jTextField25)
/*  778 */         .addComponent(this.jButton57, -1, -1, 32767));
/*  779 */     this.jPanel9.add(this.jPanel134);
/*  780 */     this.jPanel7.add(this.jPanel9);
/*  781 */     this.jPanel11.setBackground(new Color(255, 255, 255));
/*  782 */     this.jPanel11.setLayout(new GridLayout(8, 2, 6, 6));
/*  783 */     this.jPanel20.setBackground(new Color(255, 255, 255));
/*  784 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/*  785 */     this.jPanel20.setLayout(jPanel20Layout);
/*  786 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/*  787 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  788 */         .addGap(0, 106, 32767));
/*  789 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/*  790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  791 */         .addGap(0, 29, 32767));
/*  792 */     this.jPanel11.add(this.jPanel20);
/*  793 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/*  794 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  795 */     this.jPanel26.setLayout(jPanel26Layout);
/*  796 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  798 */         .addGap(0, 106, 32767));
/*  799 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  800 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  801 */         .addGap(0, 29, 32767));
/*  802 */     this.jPanel11.add(this.jPanel26);
/*  803 */     this.jRadioButton2.setText("Persona Física");
/*  804 */     this.jRadioButton2.setHorizontalAlignment(0);
/*  805 */     this.jRadioButton2.setHorizontalTextPosition(4);
/*  806 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  808 */             Proveedores.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  811 */     this.jPanel11.add(this.jRadioButton2);
/*  812 */     this.jPanel27.setBackground(new Color(255, 255, 255));
/*  813 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  814 */     this.jPanel27.setLayout(jPanel27Layout);
/*  815 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  816 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  817 */         .addGap(0, 106, 32767));
/*  818 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  819 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  820 */         .addGap(0, 29, 32767));
/*  821 */     this.jPanel11.add(this.jPanel27);
/*  822 */     this.jLabel6.setHorizontalAlignment(4);
/*  823 */     this.jLabel6.setText("Nombre comercial");
/*  824 */     this.jPanel11.add(this.jLabel6);
/*  825 */     this.jTextField16.setText("jTextField16");
/*  826 */     this.jTextField16.setNextFocusableComponent(this.jTextField17);
/*  827 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  829 */             Proveedores.this.jTextField16FocusGained(evt);
/*      */           }
/*      */         });
/*  832 */     this.jPanel11.add(this.jTextField16);
/*  833 */     this.jLabel24.setHorizontalAlignment(4);
/*  834 */     this.jLabel24.setText("Número");
/*  835 */     this.jPanel11.add(this.jLabel24);
/*  836 */     this.jTextField20.setText("jTextField20");
/*  837 */     this.jTextField20.setNextFocusableComponent(this.jTextField21);
/*  838 */     this.jPanel11.add(this.jTextField20);
/*  839 */     this.jLabel28.setHorizontalAlignment(4);
/*  840 */     this.jLabel28.setText("Estado");
/*  841 */     this.jPanel11.add(this.jLabel28);
/*  842 */     this.jTextField24.setText("jTextField24");
/*  843 */     this.jTextField24.setNextFocusableComponent(this.jButton55);
/*  844 */     this.jPanel11.add(this.jTextField24);
/*  845 */     this.jLabel21.setHorizontalAlignment(4);
/*  846 */     this.jLabel21.setText("Clabe");
/*  847 */     this.jPanel11.add(this.jLabel21);
/*  848 */     this.jTextField9.setText("jTextField9");
/*  849 */     this.jTextField9.setNextFocusableComponent(this.jTextField10);
/*  850 */     this.jPanel11.add(this.jTextField9);
/*  851 */     this.jLabel11.setHorizontalAlignment(4);
/*  852 */     this.jLabel11.setText("Teléfonos");
/*  853 */     this.jPanel11.add(this.jLabel11);
/*  854 */     this.jTextField5.setText("jTextField5");
/*  855 */     this.jTextField5.setNextFocusableComponent(this.jTextField6);
/*  856 */     this.jPanel11.add(this.jTextField5);
/*  857 */     this.jLabel17.setHorizontalAlignment(4);
/*  858 */     this.jLabel17.setText("Estado");
/*  859 */     this.jPanel11.add(this.jLabel17);
/*  860 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  861 */     this.jComboBox3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  862 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "ELIMINADO" }));
/*  863 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  865 */             Proveedores.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  868 */     this.jPanel11.add(this.jComboBox3);
/*  869 */     this.jPanel7.add(this.jPanel11);
/*  870 */     this.jPanel13.setBackground(new Color(255, 255, 255));
/*  871 */     this.jPanel13.setLayout(new GridLayout(8, 2, 6, 6));
/*  872 */     this.jLabel29.setText(" ");
/*  873 */     this.jPanel13.add(this.jLabel29);
/*  874 */     this.jLabel31.setText(" ");
/*  875 */     this.jPanel13.add(this.jLabel31);
/*  876 */     this.jLabel32.setText(" ");
/*  877 */     this.jPanel13.add(this.jLabel32);
/*  878 */     this.jLabel30.setText(" ");
/*  879 */     this.jPanel13.add(this.jLabel30);
/*  880 */     this.jLabel7.setHorizontalAlignment(4);
/*  881 */     this.jLabel7.setText("Nombre corto");
/*  882 */     this.jPanel13.add(this.jLabel7);
/*  883 */     this.jTextField17.setText("jTextField17");
/*  884 */     this.jTextField17.setNextFocusableComponent(this.jTextField18);
/*  885 */     this.jPanel13.add(this.jTextField17);
/*  886 */     this.jLabel25.setHorizontalAlignment(4);
/*  887 */     this.jLabel25.setText("Colonia");
/*  888 */     this.jPanel13.add(this.jLabel25);
/*  889 */     this.jTextField21.setText("jTextField21");
/*  890 */     this.jTextField21.setNextFocusableComponent(this.jTextField22);
/*  891 */     this.jPanel13.add(this.jTextField21);
/*  892 */     this.jLabel2.setHorizontalAlignment(4);
/*  893 */     this.jLabel2.setText("Código del país");
/*  894 */     this.jPanel13.add(this.jLabel2);
/*  895 */     this.jPanel133.setBackground(new Color(255, 255, 255));
/*  896 */     this.jTextField85.setEditable(false);
/*  897 */     this.jTextField85.setText("MEX");
/*  898 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  899 */     this.jButton55.setNextFocusableComponent(this.jTextField8);
/*  900 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  902 */             Proveedores.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*  905 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/*  906 */     this.jPanel133.setLayout(jPanel133Layout);
/*  907 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/*  908 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  909 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  910 */           .addComponent(this.jTextField85, -1, 82, 32767)
/*  911 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  912 */           .addComponent(this.jButton55, -2, 18, -2)));
/*  913 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/*  914 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  915 */         .addComponent(this.jTextField85)
/*  916 */         .addComponent(this.jButton55, -1, -1, 32767));
/*  917 */     this.jPanel13.add(this.jPanel133);
/*  918 */     this.jLabel22.setHorizontalAlignment(4);
/*  919 */     this.jLabel22.setText("Cuenta");
/*  920 */     this.jPanel13.add(this.jLabel22);
/*  921 */     this.jTextField10.setText("jTextField10");
/*  922 */     this.jTextField10.setNextFocusableComponent(this.jButton56);
/*  923 */     this.jPanel13.add(this.jTextField10);
/*  924 */     this.jLabel13.setHorizontalAlignment(4);
/*  925 */     this.jLabel13.setText("Correo electrónico");
/*  926 */     this.jPanel13.add(this.jLabel13);
/*  927 */     this.jTextField6.setText("jTextField6");
/*  928 */     this.jTextField6.setNextFocusableComponent(this.jButton34);
/*  929 */     this.jPanel13.add(this.jTextField6);
/*  930 */     this.jPanel7.add(this.jPanel13);
/*  931 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*  932 */     this.jPanel14.setLayout(new GridLayout(8, 2, 6, 6));
/*  933 */     this.jPanel19.setBackground(new Color(255, 255, 255));
/*  934 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  935 */     this.jPanel19.setLayout(jPanel19Layout);
/*  936 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  937 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  938 */         .addGap(0, 106, 32767));
/*  939 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  940 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  941 */         .addGap(0, 29, 32767));
/*  942 */     this.jPanel14.add(this.jPanel19);
/*  943 */     this.jPanel30.setBackground(new Color(255, 255, 255));
/*  944 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/*  945 */     this.jPanel30.setLayout(jPanel30Layout);
/*  946 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/*  947 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  948 */         .addGap(0, 106, 32767));
/*  949 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/*  950 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  951 */         .addGap(0, 29, 32767));
/*  952 */     this.jPanel14.add(this.jPanel30);
/*  953 */     this.jPanel31.setBackground(new Color(255, 255, 255));
/*  954 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/*  955 */     this.jPanel31.setLayout(jPanel31Layout);
/*  956 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/*  957 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  958 */         .addGap(0, 106, 32767));
/*  959 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/*  960 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  961 */         .addGap(0, 29, 32767));
/*  962 */     this.jPanel14.add(this.jPanel31);
/*  963 */     this.jPanel24.setBackground(new Color(255, 255, 255));
/*  964 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  965 */     this.jPanel24.setLayout(jPanel24Layout);
/*  966 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  967 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  968 */         .addGap(0, 106, 32767));
/*  969 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  970 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  971 */         .addGap(0, 29, 32767));
/*  972 */     this.jPanel14.add(this.jPanel24);
/*  973 */     this.jLabel8.setHorizontalAlignment(4);
/*  974 */     this.jLabel8.setText("RFC");
/*  975 */     this.jPanel14.add(this.jLabel8);
/*  976 */     this.jTextField18.setText("jTextField18");
/*  977 */     this.jTextField18.setNextFocusableComponent(this.jTextField19);
/*  978 */     this.jPanel14.add(this.jTextField18);
/*  979 */     this.jLabel26.setHorizontalAlignment(4);
/*  980 */     this.jLabel26.setText("Código Postal");
/*  981 */     this.jPanel14.add(this.jLabel26);
/*  982 */     this.jTextField22.setText("jTextField22");
/*  983 */     this.jTextField22.setNextFocusableComponent(this.jTextField23);
/*  984 */     this.jPanel14.add(this.jTextField22);
/*  985 */     this.jLabel3.setHorizontalAlignment(4);
/*  986 */     this.jLabel3.setText("País");
/*  987 */     this.jPanel14.add(this.jLabel3);
/*  988 */     this.jTextField3.setEditable(false);
/*  989 */     this.jTextField3.setText("jTextField3");
/*  990 */     this.jTextField3.setNextFocusableComponent(this.jButton56);
/*  991 */     this.jPanel14.add(this.jTextField3);
/*  992 */     this.jLabel9.setHorizontalAlignment(4);
/*  993 */     this.jLabel9.setText(" Moneda");
/*  994 */     this.jPanel14.add(this.jLabel9);
/*  995 */     this.jPanel136.setBackground(new Color(255, 255, 255));
/*  996 */     this.jTextField86.setEditable(false);
/*  997 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  998 */     this.jButton56.setNextFocusableComponent(this.jTextField4);
/*  999 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1001 */             Proveedores.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1004 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 1005 */     this.jPanel136.setLayout(jPanel136Layout);
/* 1006 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 1007 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1008 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1009 */           .addComponent(this.jTextField86, -1, 82, 32767)
/* 1010 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1011 */           .addComponent(this.jButton56, -2, 18, -2)));
/* 1012 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 1013 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1014 */         .addComponent(this.jTextField86)
/* 1015 */         .addComponent(this.jButton56, -1, -1, 32767));
/* 1016 */     this.jPanel14.add(this.jPanel136);
/* 1017 */     this.jLabel18.setHorizontalAlignment(4);
/* 1018 */     this.jLabel18.setText("Uso del CFDI");
/* 1019 */     this.jPanel14.add(this.jLabel18);
/* 1020 */     this.jPanel103.setBackground(new Color(255, 255, 255));
/* 1021 */     this.jTextField7.setEditable(false);
/* 1022 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1023 */     this.jButton34.setNextFocusableComponent(this.jButton57);
/* 1024 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1026 */             Proveedores.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1029 */     GroupLayout jPanel103Layout = new GroupLayout(this.jPanel103);
/* 1030 */     this.jPanel103.setLayout(jPanel103Layout);
/* 1031 */     jPanel103Layout.setHorizontalGroup(jPanel103Layout
/* 1032 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1033 */         .addGroup(jPanel103Layout.createSequentialGroup()
/* 1034 */           .addComponent(this.jTextField7)
/* 1035 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1036 */           .addComponent(this.jButton34, -2, 19, -2)));
/* 1037 */     jPanel103Layout.setVerticalGroup(jPanel103Layout
/* 1038 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1039 */         .addComponent(this.jTextField7)
/* 1040 */         .addComponent(this.jButton34, -1, -1, 32767));
/* 1041 */     this.jPanel14.add(this.jPanel103);
/* 1042 */     this.jPanel7.add(this.jPanel14);
/* 1043 */     this.jPanel18.setBackground(new Color(255, 255, 255));
/* 1044 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1045 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1046 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1047 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1048 */         .addGap(0, 0, 32767));
/* 1049 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1050 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1051 */         .addGap(0, 28, 32767));
/* 1052 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1053 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1054 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1055 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1056 */         .addComponent(this.jPanel6, -1, -1, 32767)
/* 1057 */         .addComponent(this.jPanel4, -1, -1, 32767)
/* 1058 */         .addComponent(this.jPanel18, -1, -1, 32767)
/* 1059 */         .addComponent(this.jPanel7, -2, 0, 32767));
/* 1060 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1061 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1062 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1063 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 1064 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1065 */           .addComponent(this.jPanel18, -2, -1, -2)
/* 1066 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1067 */           .addComponent(this.jPanel7, -2, -1, -2)
/* 1068 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 125, 32767)
/* 1069 */           .addComponent(this.jPanel6, -2, -1, -2)));
/* 1070 */     this.jDialog1.setTitle("Sucursales");
/* 1071 */     this.jDialog1.setUndecorated(true);
/* 1072 */     (new Object[2])[0] = null; (new Object[2])[1] = "Veracruz"; (new Object[2][])[0] = new Object[2]; (new Object[2])[0] = null; (new Object[2])[1] = "Poza Rica"; (new Object[2][])[1] = new Object[2]; (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(new Object[2][], (Object[])new String[2]) {
/* 1073 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 1075 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1078 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1082 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1085 */     this.rSTableMetro2.setAltoHead(25);
/* 1086 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1087 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 1088 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 1089 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1090 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 1091 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 1092 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 1093 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1094 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1095 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1096 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 1097 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 1098 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 1099 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 1100 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 1101 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 1102 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1104 */             Proveedores.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1107 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1109 */             Proveedores.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1112 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 1113 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/* 1114 */     this.jPanel135.setLayout(jPanel135Layout);
/* 1115 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/* 1116 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1117 */         .addComponent(this.jScrollPane32, -1, 418, 32767));
/* 1118 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/* 1119 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1120 */         .addComponent(this.jScrollPane32, -1, 131, 32767));
/* 1121 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1122 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1123 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1124 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1125 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
/* 1126 */           .addGap(0, 0, 0)
/* 1127 */           .addComponent(this.jPanel135, -1, -1, 32767)));
/* 1128 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1129 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1130 */         .addComponent(this.jPanel135, -1, -1, 32767));
/* 1131 */     this.jDialog2.setTitle("Catálogo de Monedas");
/* 1132 */     this.jDialog2.setUndecorated(true);
/* 1133 */     (new String[2])[0] = "Moneda"; (new String[2])[1] = "Descripción"; this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1134 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1137 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1140 */     this.rSTableMetro3.setAltoHead(25);
/* 1141 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1142 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1143 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1144 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1145 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1146 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1147 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1148 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1149 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1150 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1151 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1152 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1153 */     this.rSTableMetro3.setShowHorizontalLines(false);
/* 1154 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 1155 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1156 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1157 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1159 */             Proveedores.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1162 */     this.jScrollPane31.setViewportView((Component)this.rSTableMetro3);
/* 1163 */     GroupLayout jPanel137Layout = new GroupLayout(this.jPanel137);
/* 1164 */     this.jPanel137.setLayout(jPanel137Layout);
/* 1165 */     jPanel137Layout.setHorizontalGroup(jPanel137Layout
/* 1166 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1167 */         .addComponent(this.jScrollPane31, -1, 543, 32767));
/* 1168 */     jPanel137Layout.setVerticalGroup(jPanel137Layout
/* 1169 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1170 */         .addComponent(this.jScrollPane31, -1, 223, 32767));
/* 1171 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1172 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1173 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1174 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1175 */         .addGap(0, 543, 32767)
/* 1176 */         .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1177 */           .addComponent(this.jPanel137, -1, -1, 32767)));
/* 1178 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1179 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1180 */         .addGap(0, 223, 32767)
/* 1181 */         .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1182 */           .addComponent(this.jPanel137, -1, -1, 32767)));
/* 1183 */     this.jDialog3.setTitle("Catálogo de Paises");
/* 1184 */     this.jDialog3.setUndecorated(true);
/* 1185 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "País"; this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]));
/* 1186 */     this.rSTableMetro4.setAltoHead(25);
/* 1187 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1188 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1189 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1190 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1191 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1192 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1193 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1194 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 10));
/* 1195 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1196 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1197 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1198 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1199 */     this.rSTableMetro4.setRowHeight(18);
/* 1200 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/* 1201 */     this.rSTableMetro4.setShowHorizontalLines(false);
/* 1202 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 1203 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1204 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1205 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1207 */             Proveedores.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1210 */     this.jScrollPane23.setViewportView((Component)this.rSTableMetro4);
/* 1211 */     if (this.rSTableMetro4.getColumnModel().getColumnCount() > 0) {
/* 1212 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMinWidth(200);
/* 1213 */       this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(200);
/* 1214 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(200);
/*      */     } 
/* 1216 */     GroupLayout jPanel138Layout = new GroupLayout(this.jPanel138);
/* 1217 */     this.jPanel138.setLayout(jPanel138Layout);
/* 1218 */     jPanel138Layout.setHorizontalGroup(jPanel138Layout
/* 1219 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1220 */         .addComponent(this.jScrollPane23, -1, 543, 32767));
/* 1221 */     jPanel138Layout.setVerticalGroup(jPanel138Layout
/* 1222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1223 */         .addComponent(this.jScrollPane23, -1, 223, 32767));
/* 1224 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1225 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1226 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1227 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1228 */         .addGap(0, 543, 32767)
/* 1229 */         .addGroup(jDialog3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1230 */           .addComponent(this.jPanel138, -1, -1, 32767)));
/* 1231 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1232 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1233 */         .addGap(0, 223, 32767)
/* 1234 */         .addGroup(jDialog3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1235 */           .addComponent(this.jPanel138, -1, -1, 32767)));
/* 1236 */     this.jDialog4.setTitle("Catálogo de uso de comprobantes");
/* 1237 */     this.jDialog4.setUndecorated(true);
/* 1238 */     (new Object[2])[0] = "G01"; (new Object[2])[1] = "ADQUISICIÓN DE MERCANCÍAS"; (new Object[22][])[0] = new Object[2]; (new Object[2])[0] = "D06"; (new Object[2])[1] = "APORTACIONES VOLUNTARIAS AL SAR"; (new Object[22][])[1] = new Object[2]; (new Object[2])[0] = "I07"; (new Object[2])[1] = "COMUNICACIONES SATELITALES"; (new Object[22][])[2] = new Object[2]; (new Object[2])[0] = "I06"; (new Object[2])[1] = "COMUNICACIONES TELEFÓNICAS"; (new Object[22][])[3] = new Object[2]; (new Object[2])[0] = "I01"; (new Object[2])[1] = "CONSTRUCCIONES"; (new Object[22][])[4] = new Object[2]; (new Object[2])[0] = "I05"; (new Object[2])[1] = "DADOS, TROQUELES, MOLDES Y HERRAMENTAL"; (new Object[22][])[5] = new Object[2]; (new Object[2])[0] = "D09"; (new Object[2])[1] = "DEPÓSITOS EN CUENTAS PARA EL AHORRO, PRIMAS QUE TENGAN COMO BASE PLANES DE PENSIONES"; (new Object[22][])[6] = new Object[2]; (new Object[2])[0] = "G02"; (new Object[2])[1] = "DEVOLUCIONES, DESCUENTOS O BONIFICACIONES"; (new Object[22][])[7] = new Object[2]; (new Object[2])[0] = "D04"; (new Object[2])[1] = "DONATIVOS"; (new Object[22][])[8] = new Object[2]; (new Object[2])[0] = "I04"; (new Object[2])[1] = "EQUIPO DE CÓMPUTO Y ACCESORIOS"; (new Object[22][])[9] = new Object[2]; (new Object[2])[0] = "I03"; (new Object[2])[1] = "EQUIPO DE TRANSPORTE"; (new Object[22][])[10] = new Object[2]; (new Object[2])[0] = "D08"; (new Object[2])[1] = "GASTOS DE TRANSPORTACIÓN ESCOLAR OBLIGATORIA"; (new Object[22][])[11] = new Object[2]; (new Object[2])[0] = "G03"; (new Object[2])[1] = "GASTOS EN GENERAL"; (new Object[22][])[12] = new Object[2]; (new Object[2])[0] = "D03"; (new Object[2])[1] = "GASTOS FUNERALES"; (new Object[22][])[13] = new Object[2]; (new Object[2])[0] = "D02"; (new Object[2])[1] = "GASTOS MÉDICOS POR INCAPACIDAD O DISCAPACIDAD"; (new Object[22][])[14] = new Object[2]; (new Object[2])[0] = "D01"; (new Object[2])[1] = "HONORARIOS MEDICOS, DENTALES Y GASTOS HOSPITALARIOS"; (new Object[22][])[15] = new Object[2]; (new Object[2])[0] = "D05"; (new Object[2])[1] = "INTERESES REALES EFECTIVAMENTE PAGADOS POR CRÉDITOS HIPOTECARIOS (CASA HABITACIÓN)"; (new Object[22][])[16] = new Object[2]; (new Object[2])[0] = "I02"; (new Object[2])[1] = "MOBILIARIO Y EQUIPO DE OFICINA POR INVERSIONES"; (new Object[22][])[17] = new Object[2]; (new Object[2])[0] = "I08"; (new Object[2])[1] = "OTRA MAQUINARIA Y EQUIPO"; (new Object[22][])[18] = new Object[2]; (new Object[2])[0] = "D10"; (new Object[2])[1] = "PAGOS POR SERVICIOS EDUCATIVOS (COLEGIATURAS)"; (new Object[22][])[19] = new Object[2]; (new Object[2])[0] = "P01"; (new Object[2])[1] = "POR DEFINIR"; (new Object[22][])[20] = new Object[2]; (new Object[2])[0] = "D07"; (new Object[2])[1] = "PRIMAS POR SEGUROS DE GASTOS MEDICOS"; (new Object[22][])[21] = new Object[2]; (new String[2])[0] = "Clave"; (new String[2])[1] = "Descripción"; this.rSTableMetro6.setModel(new DefaultTableModel(new Object[22][], (Object[])new String[2])
/*      */         {
/*      */ 
/*      */           
/* 1242 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1245 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1248 */     this.rSTableMetro6.setAltoHead(25);
/* 1249 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1250 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/* 1251 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/* 1252 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1253 */     this.rSTableMetro6.setColorFilasForeground1(this.lc.SECUNDARIO1);
/* 1254 */     this.rSTableMetro6.setColorFilasForeground2(this.lc.SECUNDARIO1);
/* 1255 */     this.rSTableMetro6.setColorSelBackgound(this.lc.PRIMARIO2);
/* 1256 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/* 1257 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1258 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1259 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1260 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/* 1261 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/* 1262 */     this.rSTableMetro6.setShowHorizontalLines(false);
/* 1263 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 1264 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/* 1265 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 1266 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1268 */             Proveedores.this.rSTableMetro6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1271 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1273 */             Proveedores.this.rSTableMetro6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1276 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro6);
/* 1277 */     if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/* 1278 */       this.rSTableMetro6.getColumnModel().getColumn(0).setMinWidth(120);
/* 1279 */       this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(120);
/* 1280 */       this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(120);
/*      */     } 
/* 1282 */     GroupLayout jPanel102Layout = new GroupLayout(this.jPanel102);
/* 1283 */     this.jPanel102.setLayout(jPanel102Layout);
/* 1284 */     jPanel102Layout.setHorizontalGroup(jPanel102Layout
/* 1285 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1286 */         .addComponent(this.jScrollPane33, -1, 543, 32767));
/* 1287 */     jPanel102Layout.setVerticalGroup(jPanel102Layout
/* 1288 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1289 */         .addComponent(this.jScrollPane33, -1, 223, 32767));
/* 1290 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1291 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1292 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1293 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1294 */         .addGap(0, 543, 32767)
/* 1295 */         .addGroup(jDialog4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1296 */           .addComponent(this.jPanel102, -1, -1, 32767)));
/* 1297 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1298 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1299 */         .addGap(0, 223, 32767)
/* 1300 */         .addGroup(jDialog4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1301 */           .addComponent(this.jPanel102, -1, -1, 32767)));
/* 1302 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1303 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1304 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1305 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1306 */         .addGap(0, 822, 32767));
/* 1307 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1308 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1309 */         .addGap(0, 480, 32767));
/* 1310 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/* 1311 */     this.jPanel8.setBackground(this.lc.SECUNDARIO1);
/* 1312 */     this.jLabel55.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 1313 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 1314 */     this.jLabel55.setHorizontalAlignment(0);
/* 1315 */     this.jLabel55.setText("Proveedores");
/* 1316 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1317 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1318 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1319 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1320 */         .addComponent(this.jLabel55, -1, -1, 32767));
/* 1321 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1322 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1323 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1324 */           .addContainerGap()
/* 1325 */           .addComponent(this.jLabel55)
/* 1326 */           .addContainerGap(-1, 32767)));
/* 1327 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 1328 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/* 1329 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/* 1330 */     this.jPanel17.setLayout(new GridLayout(1, 5, 6, 0));
/* 1331 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1333 */             Proveedores.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1336 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1338 */             Proveedores.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1341 */     this.jPanel17.add(this.jTextField1);
/* 1342 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1344 */             Proveedores.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1347 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1349 */             Proveedores.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1352 */     this.jPanel17.add(this.jTextField2);
/* 1353 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1354 */     this.jComboBox2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1355 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "ELIMINADO", "TODOS" }));
/* 1356 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1358 */             Proveedores.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1361 */     this.jPanel17.add(this.jComboBox2);
/* 1362 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1363 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1364 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL OPERATIVA" }));
/* 1365 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1367 */             Proveedores.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1370 */     this.jPanel17.add(this.jComboBox1);
/* 1371 */     this.jPanel1.setBackground(this.lc.SECUNDARIO2);
/* 1372 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1373 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1374 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1375 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1376 */         .addGap(0, 193, 32767));
/* 1377 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1379 */         .addGap(0, 26, 32767));
/* 1380 */     this.jPanel17.add(this.jPanel1);
/* 1381 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/* 1382 */     this.jPanel48.setBackground(this.lc.SECUNDARIO2);
/* 1383 */     this.jPanel48.setPreferredSize(new Dimension(220, 36));
/* 1384 */     this.jPanel48.setLayout(new GridLayout(1, 7, 6, 0));
/* 1385 */     this.jPanel49.setBackground(this.lc.SECUNDARIO2);
/* 1386 */     this.jPanel49.setLayout(new GridLayout(1, 0));
/* 1387 */     this.jLabel14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/* 1388 */     this.jLabel14.setForeground(this.lc.SECUNDARIO1);
/* 1389 */     this.jLabel14.setHorizontalAlignment(4);
/* 1390 */     this.jLabel14.setText("Total ");
/* 1391 */     this.jPanel49.add(this.jLabel14);
/* 1392 */     this.jLabel48.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 1393 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 1394 */     this.jLabel48.setHorizontalAlignment(0);
/* 1395 */     this.jLabel48.setText("t");
/* 1396 */     this.jPanel49.add(this.jLabel48);
/* 1397 */     this.jPanel48.add(this.jPanel49);
/* 1398 */     this.jPanel48.add(this.jLabel15);
/* 1399 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1400 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1401 */     this.jButton2.setMnemonic('N');
/* 1402 */     this.jButton2.setText("Nuevo");
/* 1403 */     this.jButton2.setToolTipText("Nuevo Proveedor (Alt + N)");
/* 1404 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1406 */             Proveedores.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1409 */     this.jPanel48.add(this.jButton2);
/* 1410 */     this.jButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1411 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1412 */     this.jButton1.setText("Modificar");
/* 1413 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1415 */             Proveedores.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1418 */     this.jPanel48.add(this.jButton1);
/* 1419 */     this.jButton6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1420 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1421 */     this.jButton6.setText("Ver");
/* 1422 */     this.jButton6.setToolTipText("Imprimir Gafetes");
/* 1423 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1425 */             Proveedores.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1428 */     this.jPanel48.add(this.jButton6);
/* 1429 */     this.jButton25.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1430 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1431 */     this.jButton25.setMnemonic('E');
/* 1432 */     this.jButton25.setText("Eliminar");
/* 1433 */     this.jButton25.setToolTipText("Eliminar Proveedor (Alt+E)");
/* 1434 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1436 */             Proveedores.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1439 */     this.jPanel48.add(this.jButton25);
/* 1440 */     this.jButton9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1441 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1442 */     this.jButton9.setMnemonic('V');
/* 1443 */     this.jButton9.setText("Imprimir");
/* 1444 */     this.jButton9.setToolTipText("Ver a Detalle datos del Operador (Alt+V)");
/* 1445 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1447 */             Proveedores.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1450 */     this.jPanel48.add(this.jButton9);
/* 1451 */     this.jButton5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1452 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1453 */     this.jButton5.setMnemonic('G');
/* 1454 */     this.jButton5.setText("Guardar Reporte");
/* 1455 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 1456 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1458 */             Proveedores.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1461 */     this.jPanel48.add(this.jButton5);
/* 1462 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1463 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1466 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1469 */     this.rSTableMetro1.setAltoHead(40);
/* 1470 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1471 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1472 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1473 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1474 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1475 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1476 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1477 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1478 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1479 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1480 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1481 */     this.rSTableMetro1.setRowHeight(18);
/* 1482 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1483 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 1484 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 1485 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1486 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1487 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1489 */             Proveedores.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1492 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1494 */             Proveedores.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1497 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/* 1498 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1499 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1500 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1501 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1502 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1503 */           .addComponent(this.jScrollPane29, -2, 2203, -2)
/* 1504 */           .addGap(0, 0, 32767)));
/* 1505 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1507 */         .addComponent(this.jScrollPane29, -1, 232, 32767));
/* 1508 */     this.jScrollPane1.setViewportView(this.jPanel5);
/* 1509 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1510 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1511 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1513 */         .addComponent(this.jPanel48, -2, 990, 32767)
/* 1514 */         .addComponent(this.jScrollPane1, -1, 990, 32767));
/* 1515 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1516 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1517 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1518 */           .addComponent(this.jScrollPane1, -1, 248, 32767)
/* 1519 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1520 */           .addComponent(this.jPanel48, -2, 38, -2)
/* 1521 */           .addGap(7, 7, 7)));
/* 1522 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1523 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1524 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1526 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 1527 */         .addComponent(this.jPanel17, -1, 990, 32767)
/* 1528 */         .addComponent(this.jPanel10, -1, -1, 32767));
/* 1529 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1530 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1531 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1532 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 1533 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1534 */           .addComponent(this.jPanel17, -2, 26, -2)
/* 1535 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1536 */           .addComponent(this.jPanel10, -1, -1, 32767)));
/* 1537 */     GroupLayout layout = new GroupLayout(this);
/* 1538 */     setLayout(layout);
/* 1539 */     layout.setHorizontalGroup(layout
/* 1540 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1541 */         .addComponent(this.jPanel2, -1, -1, 32767));
/* 1542 */     layout.setVerticalGroup(layout
/* 1543 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1544 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1548 */     String cadena = this.jTextField1.getText();
/* 1549 */     if (!cadena.equals("")) {
/* 1550 */       if (this.presionado == null) {
/* 1551 */         this.presionado = new Presionado();
/* 1552 */         this.presionado.start();
/*      */       } else {
/* 1554 */         this.presionado.detenerFuera();
/* 1555 */         this.presionado = new Presionado();
/* 1556 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1559 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1564 */     String cadena = this.jTextField2.getText();
/* 1565 */     if (!cadena.equals("")) {
/* 1566 */       if (this.presionado == null) {
/* 1567 */         this.presionado = new Presionado();
/* 1568 */         this.presionado.start();
/*      */       } else {
/* 1570 */         this.presionado.detenerFuera();
/* 1571 */         this.presionado = new Presionado();
/* 1572 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1575 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1580 */     if (this.entraSucPrimera)
/* 1581 */       consultar(); 
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1585 */     if (evt.getClickCount() == 2)
/* 1586 */       verProveedorFicha(); 
/*      */   }
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1592 */     activar();
/* 1593 */     limpiarNuevo();
/* 1594 */     limpiarTablaSuc();
/* 1595 */     this.materialButton22.setVisible(true);
/* 1596 */     this.materialButton22.setText("Guardar");
/* 1597 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 1598 */     this.jLabel1.setText("AGREGAR PROVEEDOR");
/* 1599 */     this.jLabel4.setVisible(false);
/* 1600 */     this.jTextField14.setVisible(false);
/* 1601 */     this.materialButton22.setVisible(true);
/* 1602 */     this.fichas.addTab("Agregar Proveedor", this.jPanel3);
/* 1603 */     this.fichas.setSelectedIndex(1);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1607 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 1608 */     if (indice < 0) {
/* 1609 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1611 */       this.ACTIVARSUC = "";
/* 1612 */       verProveedor();
/* 1613 */       activar();
/* 1614 */       this.jComboBox3.setEnabled(true);
/* 1615 */       String[] sucursales = this.ACTIVARSUC.split(", ");
/* 1616 */       for (String v : sucursales)
/* 1617 */         selecTablaSucursal(v); 
/* 1618 */       if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 1619 */         this.jTextField25.setEnabled(true);
/* 1620 */         this.jTextField25.setText("");
/* 1621 */         this.jButton57.setEnabled(true);
/*      */       } 
/* 1623 */       this.materialButton22.setVisible(true);
/* 1624 */       this.materialButton22.setText("Modificar");
/* 1625 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 1626 */       this.jLabel4.setVisible(true);
/* 1627 */       this.jTextField14.setVisible(true);
/* 1628 */       this.jLabel17.setVisible(true);
/* 1629 */       this.jComboBox3.setVisible(true);
/* 1630 */       this.jTextField14.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/* 1631 */       this.fichas.addTab("Modificar Proveedor: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), this.jPanel3);
/* 1632 */       this.fichas.setSelectedIndex(1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1637 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 1638 */     if (indice < 0) {
/* 1639 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para ver la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1641 */       verProveedorFicha();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 1647 */       String sicret = "LOGO.jpg";
/* 1648 */       String forsis = "forsis100x.jpg";
/* 1649 */       JTable aux = crearTablaAux((JTable)this.rSTableMetro1, new Object[] { "cont", "id", "razonSocial", "rfc", "direccion", "contacto", "telefonos", "correo", "estado" });
/* 1650 */       Map<Object, Object> datos = new HashMap<>();
/* 1651 */       datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 1652 */       datos.put("estatus", this.jComboBox2.getSelectedItem().toString().toUpperCase());
/* 1653 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 1654 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 1655 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 1656 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_ProveedoresGral.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 1657 */       JasperViewer visor = new JasperViewer(print, false);
/* 1658 */       visor.setTitle("Proveedores");
/* 1659 */       visor.setIconImage(this.iconoImprimir);
/* 1660 */       visor.setZoomRatio(0.59F);
/* 1661 */       visor.setExtendedState(6);
/* 1662 */       visor.setVisible(true);
/* 1663 */     } catch (JRException e) {
/* 1664 */       System.out.println(e.getMessage());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1669 */     String[] datos = { "ID", "TIPO", "RAZÓN SOCIAL O NOMBRE", "NOMBRE COMERCIAL", "RFC", "DIRECCIÓN", "CONTACTO", "TELEFONOS", "CORREO", "MONEDA", "SUCURSAL OPERATIVA", "ESTADO", "ACTUALIZO (dd/mm/aaaa)" };
/*      */ 
/*      */     
/* 1672 */     this.esc = new EscribirReporte("PROVEDDORES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1676 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel16MouseClicked(MouseEvent evt) {
/* 1680 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 1681 */     this.fichas.remove(1);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseExited(MouseEvent evt) {
/* 1685 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jLabel16MouseEntered(MouseEvent evt) {
/* 1689 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 1693 */     this.fichas.removeTabAt(1);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 1697 */     String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 1698 */     String actualizo = this.USUARIO + this.USUARIO;
/* 1699 */     String tipo = "PM";
/* 1700 */     String persona = "PERSONA MORAL";
/* 1701 */     if (this.jRadioButton2.isSelected()) {
/* 1702 */       tipo = "PF";
/* 1703 */       persona = "PERSONA FÍSICA";
/*      */     } 
/* 1705 */     if (this.jTextField15.getText().equals("")) {
/* 1706 */       this.error.cargarError(this.jTextField15, "050");
/* 1707 */     } else if (this.jTextField16.getText().equals("")) {
/* 1708 */       this.error.cargarError(this.jTextField16, "050");
/* 1709 */     } else if (this.jTextField17.getText().equals("")) {
/* 1710 */       this.error.cargarError(this.jTextField17, "050");
/* 1711 */     } else if (this.jTextField18.getText().equals("")) {
/* 1712 */       this.error.cargarError(this.jTextField18, "050");
/* 1713 */     } else if (!this.val.validarTexto(this.jTextField18, this.jTextField18.getText(), "004") && 
/* 1714 */       !this.val.validarTexto(this.jTextField15, this.jTextField15.getText(), "004") && 
/* 1715 */       !this.val.validarTexto(this.jTextField16, this.jTextField16.getText(), "004") && 
/* 1716 */       !this.val.validarTexto(this.jTextField17, this.jTextField17.getText(), "004") && 
/* 1717 */       !this.val.validarTexto(this.jTextField15, this.jTextField15.getText(), "004") && 
/* 1718 */       !this.val.validarTexto(this.jTextField18, this.jTextField18.getText(), "004") && 
/* 1719 */       !this.val.validarTexto(this.jTextField19, this.jTextField19.getText(), "014")) {
/* 1720 */       if (!this.jTextField19.getText().equals("") && this.jTextField20.getText().equals("") && this.jTextField21.getText().equals("")) {
/* 1721 */         this.jTextField19.setBackground(new Color(255, 51, 51));
/* 1722 */         JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/* 1723 */       } else if (!this.val.validarTexto(this.jTextField20, this.jTextField20.getText().toUpperCase(), "015")) {
/* 1724 */         if (!this.jTextField20.getText().equals("") && this.jTextField19.getText().equals("")) {
/* 1725 */           this.jTextField20.setBackground(new Color(255, 51, 51));
/* 1726 */           JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/* 1727 */         } else if (!this.val.validarTexto(this.jTextField21, this.jTextField21.getText(), "014")) {
/* 1728 */           if (!this.jTextField21.getText().equals("") && this.jTextField19.getText().equals("")) {
/* 1729 */             this.jTextField21.setBackground(new Color(255, 51, 51));
/* 1730 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/* 1731 */           } else if (!this.val.validarCodigoPostal(this.jTextField22, this.jTextField22.getText(), "014") && 
/* 1732 */             !this.val.validarTexto(this.jTextField23, this.jTextField23.getText(), "004") && 
/* 1733 */             !this.val.validarTexto(this.jTextField24, this.jTextField24.getText(), "004") && 
/* 1734 */             !this.val.validarTexto(this.jTextField4, this.jTextField4.getText(), "004") && 
/* 1735 */             !this.val.validarTexto(this.jTextField5, this.jTextField5.getText(), "004") && 
/* 1736 */             !this.val.validarTexto(this.jTextField6, this.jTextField6.getText(), "004")) {
/* 1737 */             if (suc.equals("")) {
/* 1738 */               this.jTextField25.setBackground(Color.RED);
/* 1739 */               JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la sucursal operativa\nPor lo menos debe estar seleccionada una sucursal.", "Falta sucursal operativa", 0, this.ADVER);
/* 1740 */             } else if (this.materialButton22.getText().equals("Guardar")) {
/* 1741 */               String[] campos = { "Tipo", "Razón Social", "Nombre Comercial", "Iniciales", "RFC", "Calle", "Número", "Colonia", "CP", "Ciudad", "Estado", "País", "Moneda", "Uso del CFDI", "Contacto", "Teléfonos", "Correo", "Sucursal Operativa" };
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1746 */               String[] info = { tipo, this.jTextField15.getText().toUpperCase(), this.jTextField16.getText().toUpperCase(), this.jTextField17.getText().toUpperCase(), this.jTextField18.getText().toUpperCase(), this.jTextField19.getText().toUpperCase(), this.jTextField20.getText().toUpperCase(), this.jTextField21.getText().toUpperCase(), this.jTextField22.getText().toUpperCase(), this.jTextField23.getText().toUpperCase(), this.jTextField24.getText().toUpperCase(), this.jTextField85.getText() + " - " + this.jTextField85.getText(), this.jTextField86.getText(), this.jTextField7.getText(), this.jTextField4.getText().toUpperCase(), this.jTextField5.getText().toUpperCase(), this.jTextField6.getText().toUpperCase(), suc };
/* 1747 */               int res = this.error.cargarDatos(campos, info);
/* 1748 */               if (res == 0) {
/* 1749 */                 this.con.inserSinMsj("insert into prov_proveedores(tipo, razonSocial, nombreComercial,iniciales, rfc,calle, num,col, cp,cd, estadoRegion, codPais, pais, banco, clabe, cuenta, moneda, usoCFDIclave, contacto, tel, sucOp,estado, usuarioProv, correo, saldo, usuarioTarjeta) values ('" + tipo + "','" + this.jTextField15
/*      */                     
/* 1751 */                     .getText().toUpperCase() + "', '" + this.jTextField16.getText().toUpperCase() + "','" + this.jTextField17
/* 1752 */                     .getText().toUpperCase() + "','" + this.jTextField18.getText().toUpperCase() + "','" + this.jTextField19
/* 1753 */                     .getText().toUpperCase() + "','" + this.jTextField20.getText().toUpperCase() + "','" + this.jTextField21
/* 1754 */                     .getText().toUpperCase() + "','" + this.jTextField22.getText().toUpperCase() + "','" + this.jTextField23
/* 1755 */                     .getText().toUpperCase() + "','" + this.jTextField24.getText().toUpperCase() + "','" + this.jTextField85
/* 1756 */                     .getText().toUpperCase() + "','" + this.jTextField3.getText().toUpperCase() + "','" + this.jTextField8
/* 1757 */                     .getText().toUpperCase() + "','" + this.jTextField9.getText().toUpperCase() + "','" + this.jTextField10.getText().toUpperCase() + "','" + this.jTextField86
/* 1758 */                     .getText().toUpperCase() + "','" + this.jTextField7.getText().toUpperCase() + "','" + this.jTextField4.getText().toUpperCase() + "','" + this.jTextField5
/* 1759 */                     .getText().toUpperCase() + "','" + suc + "','ACTIVO','" + actualizo + "','" + this.jTextField6
/* 1760 */                     .getText().toUpperCase() + "','$0.00','" + actualizo + "')");
/* 1761 */                 this.fichas.remove(1);
/* 1762 */                 consultar();
/* 1763 */                 this.mensajeTry.guardarConf("Se ha agregado un nuevo proveedor, usuario: " + this.USUARIO, "Proveedor Nuevo (" + this.jTextField16.getText().toUpperCase() + ")", "INFO", "Cuentasporpagar");
/*      */               } 
/* 1765 */             } else if (this.materialButton22.getText().equals("Modificar")) {
/* 1766 */               String[] campos = { "Tipo", "Razón Social", "Nombre Comercial", "Iniciales", "RFC", "Calle", "Número", "Colonia", "CP", "Ciudad", "Estado", "País", "Moneda", "Uso del CFDI", "Contacto", "Teléfonos", "Correo", "Sucursal Operativa", "Estado" };
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1771 */               String[] info = { tipo, this.jTextField15.getText().toUpperCase(), this.jTextField16.getText().toUpperCase(), this.jTextField17.getText().toUpperCase(), this.jTextField18.getText().toUpperCase(), this.jTextField19.getText().toUpperCase(), this.jTextField20.getText().toUpperCase(), this.jTextField21.getText().toUpperCase(), this.jTextField22.getText().toUpperCase(), this.jTextField23.getText().toUpperCase(), this.jTextField24.getText().toUpperCase(), this.jTextField85.getText() + " - " + this.jTextField85.getText(), this.jTextField86.getText(), this.jTextField7.getText(), this.jTextField4.getText().toUpperCase(), this.jTextField5.getText().toUpperCase(), this.jTextField6.getText().toUpperCase(), suc, this.jComboBox3.getSelectedItem().toString() };
/* 1772 */               int res = this.error.cargarDatos2(campos, info);
/* 1773 */               if (res == 0) {
/* 1774 */                 this.con.inserSinMsj("update prov_proveedores set tipo = '" + tipo + "', razonSocial='" + this.jTextField15.getText().toUpperCase() + "', nombreComercial='" + this.jTextField16.getText().toUpperCase() + "',iniciales='" + this.jTextField17
/* 1775 */                     .getText().toUpperCase() + "', rfc='" + this.jTextField18.getText().toUpperCase() + "',calle='" + this.jTextField19
/* 1776 */                     .getText().toUpperCase() + "', num='" + this.jTextField20.getText().toUpperCase() + "',col='" + this.jTextField21
/* 1777 */                     .getText().toUpperCase() + "', cp='" + this.jTextField22.getText().toUpperCase() + "',cd='" + this.jTextField23
/* 1778 */                     .getText().toUpperCase() + "', estadoRegion='" + this.jTextField24.getText().toUpperCase() + "', codPais='" + this.jTextField85
/* 1779 */                     .getText().toUpperCase() + "', pais='" + this.jTextField3.getText().toUpperCase() + "', banco='" + this.jTextField8
/* 1780 */                     .getText().toUpperCase() + "', clabe='" + this.jTextField9.getText().toUpperCase() + "', cuenta='" + this.jTextField10.getText().toUpperCase() + "', moneda='" + this.jTextField86
/* 1781 */                     .getText().toUpperCase() + "', usoCFDIclave='" + this.jTextField7.getText() + "', contacto='" + this.jTextField4.getText().toUpperCase() + "', tel='" + this.jTextField5
/* 1782 */                     .getText().toUpperCase() + "', sucOp='" + suc + "', correo = '" + this.jTextField6
/* 1783 */                     .getText().toUpperCase() + "', estado='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "', usuarioProv='" + actualizo + "', estado='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "' where numProv= " + this.jTextField14.getText());
/* 1784 */                 this.fichas.removeTabAt(1);
/* 1785 */                 consultar();
/* 1786 */                 this.mensajeTry.guardarConf("Se ha modificado un proveedor, usuario: " + this.USUARIO, "Proveedor Modificado (" + this.jTextField16.getText().toUpperCase() + ")", "INFO", "Cuentasporpagar");
/*      */               } 
/*      */             } else {
/*      */               try {
/* 1790 */                 String sicret = "LOGO.jpg";
/* 1791 */                 String forsis = "forsis100x.jpg";
/* 1792 */                 Map<Object, Object> datos = new HashMap<>();
/* 1793 */                 datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 1794 */                 datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_mat"));
/* 1795 */                 datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 1796 */                 datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 1797 */                 datos.put("parameter1", this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/* 1798 */                 datos.put("parameter2", this.jTextField15.getText());
/* 1799 */                 datos.put("parameter3", this.jTextField16.getText());
/* 1800 */                 datos.put("parameter4", this.jTextField17.getText());
/* 1801 */                 datos.put("parameter5", this.jTextField18.getText());
/* 1802 */                 datos.put("parameter6", this.jTextField19.getText());
/* 1803 */                 datos.put("parameter7", this.jTextField20.getText());
/* 1804 */                 datos.put("parameter8", this.jTextField21.getText());
/* 1805 */                 datos.put("parameter9", this.jTextField22.getText());
/* 1806 */                 datos.put("parameter10", this.jTextField23.getText());
/* 1807 */                 datos.put("parameter11", this.jTextField24.getText());
/* 1808 */                 datos.put("parameter12", this.jTextField85.getText() + " - " + this.jTextField85.getText());
/* 1809 */                 datos.put("parameter13", this.jTextField86.getText());
/* 1810 */                 datos.put("parameter14", this.jTextField4.getText());
/* 1811 */                 datos.put("parameter15", this.jTextField5.getText());
/* 1812 */                 datos.put("parameter16", this.jTextField6.getText());
/* 1813 */                 datos.put("parameter17", suc);
/* 1814 */                 datos.put("parameter18", this.jComboBox3.getSelectedItem());
/* 1815 */                 datos.put("parameter19", this.ULTIMOUSUARIO);
/* 1816 */                 datos.put("parameter20", persona);
/* 1817 */                 JasperPrint reporte = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_ProveedoresIndividual.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 1818 */                 JasperViewer visor = new JasperViewer(reporte, false);
/* 1819 */                 visor.setTitle("Reporte de Proveedores");
/* 1820 */                 visor.setIconImage(this.iconoImprimir);
/* 1821 */                 visor.setZoomRatio(0.59F);
/* 1822 */                 visor.setExtendedState(6);
/* 1823 */                 visor.setVisible(true);
/* 1824 */               } catch (JRException e) {
/* 1825 */                 System.out.println(e.getMessage());
/* 1826 */                 Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 1836 */     if (this.entraCatPais != true) {
/* 1837 */       this.entraCatPais = true;
/* 1838 */       llenarCatPaises();
/*      */     } 
/* 1840 */     Dimension di = this.jButton55.getSize();
/* 1841 */     Point p = this.jButton55.getLocationOnScreen();
/* 1842 */     this.jDialog3.setLocation(p.x + di.width - 200, p.y + 30);
/* 1843 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 1847 */     if (this.entraCatMon != true) {
/* 1848 */       this.entraCatMon = true;
/* 1849 */       llenarCatMonedas();
/*      */     } 
/* 1851 */     Dimension di = this.jButton56.getSize();
/* 1852 */     Point p = this.jButton56.getLocationOnScreen();
/* 1853 */     this.jDialog2.setLocation(p.x + di.width - this.jDialog2.getWidth(), p.y + 30);
/* 1854 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 1862 */     if (evt.getClickCount() == 2) {
/* 1863 */       this.jTextField86.setText(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0).toString());
/* 1864 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 1869 */     if (evt.getClickCount() == 2) {
/* 1870 */       this.jTextField85.setText(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0).toString());
/* 1871 */       this.jTextField3.setText(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 1).toString());
/* 1872 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField23FocusGained(FocusEvent evt) {
/* 1877 */     if (!this.entraCatMunicipios) {
/* 1878 */       this.entraCatMunicipios = true;
/* 1879 */       catMunicipios mun = new catMunicipios();
/*      */       try {
/* 1881 */         this.TODOS_MUNICIPIOS = new ArrayList(mun.catMunicipios());
/* 1882 */         this.com_Municipios = new TextAutoCompleter(this.jTextField23, this.TODOS_MUNICIPIOS);
/* 1883 */       } catch (IOException ex) {
/* 1884 */         Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField16FocusGained(FocusEvent evt) {
/* 1890 */     if (this.jTextField16.getText().equals("") && 
/* 1891 */       !this.jTextField15.getText().equals(""))
/* 1892 */       if (this.jTextField15.getText().length() > 3) {
/* 1893 */         String cad = "";
/* 1894 */         String iniciales = "";
/* 1895 */         String v = this.jTextField15.getText().toUpperCase();
/* 1896 */         String[] campos = v.split(" ");
/* 1897 */         int indice = 0;
/* 1898 */         for (String e : campos) {
/* 1899 */           if (e.length() > 2) {
/* 1900 */             cad = cad + cad + " ";
/* 1901 */             indice++;
/* 1902 */             iniciales = iniciales + iniciales;
/* 1903 */             if (indice > 2)
/*      */               break; 
/*      */           } 
/*      */         } 
/* 1907 */         cad = cad.replaceAll(",", "");
/* 1908 */         String temp = cad.replace(".", "");
/* 1909 */         this.jTextField16.setText(temp.substring(0, temp.length() - 1));
/* 1910 */         this.jTextField17.setText(iniciales);
/*      */       } else {
/* 1912 */         this.jTextField16.setText(this.jTextField15.getText().toUpperCase());
/* 1913 */         this.jTextField17.setText(this.jTextField15.getText().toUpperCase());
/*      */       }  
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 1918 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 1922 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 1926 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 1927 */     if (indice < 0) {
/* 1928 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para eliminar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1930 */       String v = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 1931 */       String p = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3).toString();
/* 1932 */       if (v.equals("ACTIVO")) {
/* 1933 */         int res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Estás seguro que deseas eliminar el proveedor: <b>" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + " </b>?</html>", "Eliminar Proveedor", 0, 3, this.PREG);
/* 1934 */         if (res == 0) {
/* 1935 */           String actualizo = this.USUARIO + this.USUARIO;
/* 1936 */           this.con.inserSinMsj("update prov_proveedores set estado='ELIMINADO', usuarioProv='" + actualizo + "' where numProv= " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 1937 */           this.mensajeTry.guardarConf("Se ha eliminado un proveedor, usuario: " + this.USUARIO, "Proveedor Eliminado (" + p + ")", "ERROR", "Cuentasporpagar");
/* 1938 */           if (this.jComboBox2.getSelectedIndex() == 0) {
/* 1939 */             DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro1.getModel();
/* 1940 */             temp.removeRow(this.rSTableMetro1.getSelectedRow());
/* 1941 */             this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/*      */           } else {
/* 1943 */             consultar();
/*      */           } 
/*      */         } 
/*      */       } else {
/* 1947 */         JOptionPane.showMessageDialog(this.padre, "El registro que seleccionaste ya se encuentra eliminado, confirma tu información", "Registro Eliminado", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 1955 */     Dimension di = this.jButton34.getSize();
/* 1956 */     Point p = this.jButton34.getLocationOnScreen();
/* 1957 */     this.jDialog4.setLocation(p.x + di.width - this.jDialog4.getWidth(), p.y + 30);
/* 1958 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/* 1962 */     if (evt.getClickCount() == 2) {
/* 1963 */       this.jTextField7.setText(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0).toString());
/* 1964 */       this.jDialog4.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jTextField25ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/* 1973 */     Dimension di = this.jButton57.getSize();
/* 1974 */     Point p = this.jButton57.getLocationOnScreen();
/* 1975 */     this.jDialog1.setLocation(p.x + di.width - 200, p.y + 30);
/* 1976 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   public JTable crearTablaAux(JTable Original, Object[] columnas) {
/* 1982 */     Object[] Columnas = columnas;
/* 1983 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount()];
/* 1984 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1985 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1986 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1987 */         if (j == 0)
/* 1988 */           registros[i][1] = Original.getValueAt(i, j); 
/* 1989 */         if (j == 2)
/* 1990 */           registros[i][2] = Original.getValueAt(i, j); 
/* 1991 */         if (j == 4)
/* 1992 */           registros[i][3] = Original.getValueAt(i, j); 
/* 1993 */         if (j == 5)
/* 1994 */           registros[i][4] = Original.getValueAt(i, j).toString(); 
/* 1995 */         if (j == 6)
/* 1996 */           registros[i][5] = Original.getValueAt(i, j).toString(); 
/* 1997 */         if (j == 7)
/* 1998 */           registros[i][6] = Original.getValueAt(i, j).toString(); 
/* 1999 */         if (j == 8)
/* 2000 */           registros[i][7] = Original.getValueAt(i, j).toString(); 
/* 2001 */         if (j == 11)
/* 2002 */           registros[i][8] = Original.getValueAt(i, j).toString(); 
/*      */       } 
/*      */     } 
/* 2005 */     JTable aux = new JTable(registros, Columnas);
/* 2006 */     return aux;
/*      */   }
/*      */   
/*      */   public void verProveedorFicha() {
/* 2010 */     this.ACTIVARSUC = "";
/* 2011 */     verProveedor();
/* 2012 */     String[] sucursales = this.ACTIVARSUC.split(", ");
/* 2013 */     for (String v : sucursales)
/* 2014 */       selecTablaSucursal(v); 
/* 2015 */     this.NUMPROV = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 2016 */     this.jLabel4.setVisible(true);
/* 2017 */     this.jTextField14.setVisible(true);
/* 2018 */     this.materialButton22.setText("Imprimir");
/* 2019 */     this.materialButton22.setToolTipText("Imprimir (Alt + P)");
/* 2020 */     this.materialButton22.setMnemonic('P');
/* 2021 */     this.jLabel17.setVisible(true);
/* 2022 */     this.jComboBox3.setVisible(true);
/* 2023 */     this.fichas.addTab("Proveedor Núm. " + this.NUMPROV, this.jPanel3);
/* 2024 */     this.fichas.setSelectedIndex(1);
/*      */   }
/*      */   
/*      */   public void verProveedor() {
/* 2028 */     limpiarNuevo();
/* 2029 */     desactivar();
/* 2030 */     this.jLabel1.setText("INFORMACIÓN DEL PROVEEDOR");
/* 2031 */     this.jTextField14.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/* 2032 */     String[] datos = this.con.regresaReg("razonSocial, nombreComercial, iniciales, rfc, calle, num, col, cp, cd, estadoRegion, codPais, pais, moneda, contacto, tel, correo, sucOp, estado, usoCFDIclave, usuarioProv, tipo, banco, clabe, cuenta", "prov_proveedores", "where numProv= " + 
/*      */         
/* 2034 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 24);
/* 2035 */     this.jTextField15.setText(datos[0]);
/* 2036 */     this.jTextField16.setText(datos[1]);
/* 2037 */     this.jTextField17.setText(datos[2]);
/* 2038 */     this.jTextField18.setText(datos[3]);
/* 2039 */     this.jTextField19.setText(datos[4]);
/* 2040 */     this.jTextField20.setText(datos[5]);
/* 2041 */     this.jTextField21.setText(datos[6]);
/* 2042 */     this.jTextField22.setText(datos[7]);
/* 2043 */     this.jTextField23.setText(datos[8]);
/* 2044 */     this.jTextField24.setText(datos[9]);
/* 2045 */     this.jTextField85.setText(datos[10]);
/* 2046 */     this.jTextField3.setText(datos[11]);
/* 2047 */     this.jTextField86.setText(datos[12]);
/* 2048 */     this.jTextField7.setText(datos[18]);
/* 2049 */     this.jTextField4.setText(datos[13]);
/* 2050 */     this.jTextField5.setText(datos[14]);
/* 2051 */     this.jTextField6.setText(datos[15]);
/* 2052 */     this.jTextField25.setText(datos[16].substring(0, 8) + "...");
/* 2053 */     this.jTextField25.setToolTipText(datos[16]);
/* 2054 */     this.ACTIVARSUC = datos[16];
/* 2055 */     this.jComboBox3.setSelectedItem(datos[17]);
/* 2056 */     this.ULTIMOUSUARIO = datos[19];
/* 2057 */     String tipo = datos[20];
/* 2058 */     if (tipo.equals("PM")) {
/* 2059 */       this.jRadioButton1.setSelected(true);
/*      */     } else {
/* 2061 */       this.jRadioButton2.setSelected(true);
/*      */     } 
/* 2063 */     this.jTextField8.setText(datos[21]);
/* 2064 */     this.jTextField9.setText(datos[22]);
/* 2065 */     this.jTextField10.setText(datos[23]);
/*      */   }
/*      */   
/*      */   public String sacarFechaHoy() {
/* 2069 */     Date fechaHoy = new Date(Calendar.getInstance().getTimeInMillis());
/* 2070 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* 2071 */     String fecha = formatter.format(fechaHoy);
/* 2072 */     return " (" + fecha + ")";
/*      */   }
/*      */   
/*      */   public String dameSucursalOp(JTextField campo, JTable tabla) {
/* 2076 */     String sucursales = "";
/* 2077 */     boolean entra = false;
/* 2078 */     if (campo.isEditable()) {
/* 2079 */       for (int i = 0; i < tabla.getRowCount(); i++) {
/* 2080 */         boolean selec = ((Boolean)tabla.getValueAt(i, 0)).booleanValue();
/* 2081 */         if (selec) {
/* 2082 */           sucursales = sucursales + " " + sucursales + ",";
/* 2083 */           entra = true;
/*      */         } 
/*      */       } 
/* 2086 */       if (entra) {
/* 2087 */         sucursales = sucursales.substring(1, sucursales.length() - 1);
/*      */       } else {
/* 2089 */         sucursales = "";
/*      */       } 
/*      */     } else {
/* 2092 */       sucursales = campo.getText().toUpperCase();
/*      */     } 
/* 2094 */     return sucursales;
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 2098 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 2099 */       this.jComboBox1.setEnabled(true);
/*      */     } else {
/* 2101 */       this.jComboBox1.setEnabled(false);
/*      */     } 
/* 2103 */     this.jComboBox1.setSelectedItem(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/*      */   }
/*      */   
/*      */   public void activar() {
/* 2107 */     this.jTextField15.setEnabled(true);
/* 2108 */     this.jTextField16.setEnabled(true);
/* 2109 */     this.jTextField17.setEnabled(true);
/* 2110 */     this.jTextField18.setEnabled(true);
/* 2111 */     this.jTextField19.setEnabled(true);
/* 2112 */     this.jTextField20.setEnabled(true);
/* 2113 */     this.jTextField21.setEnabled(true);
/* 2114 */     this.jTextField22.setEnabled(true);
/* 2115 */     this.jTextField23.setEnabled(true);
/* 2116 */     this.jTextField24.setEnabled(true);
/* 2117 */     this.jButton55.setEnabled(true);
/* 2118 */     this.jButton56.setEnabled(true);
/* 2119 */     this.jButton34.setEnabled(true);
/* 2120 */     this.jTextField3.setEnabled(true);
/* 2121 */     this.jTextField4.setEnabled(true);
/* 2122 */     this.jTextField5.setEnabled(true);
/* 2123 */     this.jTextField6.setEnabled(true);
/* 2124 */     this.jTextField8.setEnabled(true);
/* 2125 */     this.jTextField9.setEnabled(true);
/* 2126 */     this.jTextField10.setEnabled(true);
/* 2127 */     this.jButton57.setEnabled(true);
/* 2128 */     this.jRadioButton1.setEnabled(true);
/* 2129 */     this.jRadioButton2.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 2133 */     this.jTextField15.setEnabled(false);
/* 2134 */     this.jTextField16.setEnabled(false);
/* 2135 */     this.jTextField17.setEnabled(false);
/* 2136 */     this.jTextField18.setEnabled(false);
/* 2137 */     this.jTextField19.setEnabled(false);
/* 2138 */     this.jTextField20.setEnabled(false);
/* 2139 */     this.jTextField21.setEnabled(false);
/* 2140 */     this.jTextField22.setEnabled(false);
/* 2141 */     this.jTextField23.setEnabled(false);
/* 2142 */     this.jTextField24.setEnabled(false);
/* 2143 */     this.jButton55.setEnabled(false);
/* 2144 */     this.jButton56.setEnabled(false);
/* 2145 */     this.jButton34.setEnabled(false);
/* 2146 */     this.jTextField3.setEnabled(false);
/* 2147 */     this.jTextField4.setEnabled(false);
/* 2148 */     this.jTextField5.setEnabled(false);
/* 2149 */     this.jTextField6.setEnabled(false);
/* 2150 */     this.jTextField25.setEnabled(false);
/* 2151 */     this.jTextField8.setEnabled(false);
/* 2152 */     this.jTextField9.setEnabled(false);
/* 2153 */     this.jTextField10.setEnabled(false);
/* 2154 */     this.jButton57.setEnabled(false);
/* 2155 */     this.jRadioButton1.setEnabled(false);
/* 2156 */     this.jRadioButton2.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void limpiarTablaSuc() {
/* 2160 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 2161 */       this.jTextField25.setText("");
/* 2162 */       this.jTextField25.setEnabled(true);
/* 2163 */       this.jButton57.setEnabled(true);
/*      */     } else {
/* 2165 */       this.jTextField25.setEnabled(false);
/* 2166 */       this.jTextField25.setText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 2167 */       this.jButton57.setEnabled(false);
/*      */     } 
/* 2169 */     this.jTextField25.setToolTipText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 2170 */     selecTablaSucursal(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public void selecTablaSucursal(String suc) {
/* 2174 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2175 */       String columna = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 2176 */       if (columna.equals(suc))
/* 2177 */         this.rSTableMetro2.setValueAt(Boolean.valueOf(true), i, 0); 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void limpiarNuevo() {
/* 2182 */     this.jTextField14.setText("");
/* 2183 */     this.jTextField15.setText("");
/* 2184 */     this.jTextField16.setText("");
/* 2185 */     this.jTextField17.setText("");
/* 2186 */     this.jTextField18.setText("");
/* 2187 */     this.jTextField19.setText("");
/* 2188 */     this.jTextField20.setText("");
/* 2189 */     this.jTextField21.setText("");
/* 2190 */     this.jTextField22.setText("");
/* 2191 */     this.jTextField23.setText("");
/* 2192 */     this.jTextField24.setText("");
/* 2193 */     this.jTextField85.setText("MEX");
/* 2194 */     this.jTextField3.setText("MÉXICO");
/* 2195 */     this.jTextField86.setText("MXN");
/* 2196 */     this.jTextField7.setText("G03");
/* 2197 */     this.jTextField4.setText("");
/* 2198 */     this.jTextField5.setText("");
/* 2199 */     this.jTextField6.setText("");
/* 2200 */     this.jLabel17.setVisible(false);
/* 2201 */     this.jComboBox3.setVisible(false);
/* 2202 */     this.jRadioButton1.setEnabled(true);
/* 2203 */     this.jRadioButton2.setEnabled(true);
/* 2204 */     this.jRadioButton1.setSelected(true);
/* 2205 */     this.jComboBox3.setEnabled(false);
/* 2206 */     this.jTextField8.setText("");
/* 2207 */     this.jTextField9.setText("");
/* 2208 */     this.jTextField10.setText("");
/* 2209 */     llenarSucursales();
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2213 */     this.pintar.colorear(this.jTextField1);
/* 2214 */     this.pintar.colorear(this.jTextField2);
/* 2215 */     this.pintar.colorear(this.jComboBox1);
/* 2216 */     this.pintar.colorear(this.jComboBox2);
/* 2217 */     this.pintar.colorear(this.jTextField14);
/* 2218 */     this.pintar.colorear(this.jTextField15);
/* 2219 */     this.pintar.colorear(this.jTextField16);
/* 2220 */     this.pintar.colorear(this.jTextField17);
/* 2221 */     this.pintar.colorear(this.jTextField18);
/* 2222 */     this.pintar.colorear(this.jTextField19);
/* 2223 */     this.pintar.colorear(this.jTextField20);
/* 2224 */     this.pintar.colorear(this.jTextField21);
/* 2225 */     this.pintar.colorear(this.jTextField22);
/* 2226 */     this.pintar.colorear(this.jTextField23);
/* 2227 */     this.pintar.colorear(this.jTextField24);
/* 2228 */     this.pintar.colorear(this.jTextField4);
/* 2229 */     this.pintar.colorear(this.jTextField5);
/* 2230 */     this.pintar.colorear(this.jTextField6);
/* 2231 */     this.pintar.colorear(this.jTextField8);
/* 2232 */     this.pintar.colorear(this.jTextField9);
/* 2233 */     this.pintar.colorear(this.jTextField10);
/*      */   }
/*      */   
/*      */   public void llenarSucursales() {
/* 2237 */     this.TODOS_SUCURSALES = new ArrayList();
/* 2238 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 2239 */     Object[][] Object = new Object[lista.size()][2];
/* 2240 */     Iterator<String> it = lista.iterator();
/* 2241 */     while (it.hasNext()) {
/* 2242 */       String v = it.next();
/* 2243 */       this.TODOS_SUCURSALES.add(v);
/* 2244 */       Object[lista.indexOf(v)][0] = Boolean.valueOf(false);
/* 2245 */       Object[lista.indexOf(v)][1] = v;
/*      */     } 
/* 2247 */     llenarTablaSuc(Object);
/* 2248 */     this.com_Sucursales = new TextAutoCompleter(this.jTextField25, this.TODOS_SUCURSALES);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCatMonedas() {
/* 2253 */     (new String[2])[0] = "Moneda"; (new String[2])[1] = "Descripción"; this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(2, "moneda,descripcion", "catmoneda", "order by moneda"), (Object[])new String[2]) {
/* 2254 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2257 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2260 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 2261 */     this.rSTableMetro3.setSelectionMode(0);
/* 2262 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 2263 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 2264 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 2265 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(90);
/* 2266 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 2267 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 2268 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCatPaises() {
/* 2273 */     (new String[2])[0] = "Pais"; (new String[2])[1] = "Descripción"; this.rSTableMetro4.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(2, "pais,descripcion", "catpaises", "order by descripcion"), (Object[])new String[2]) {
/* 2274 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2277 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2280 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 2281 */     this.rSTableMetro4.setSelectionMode(0);
/* 2282 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 2283 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 2284 */     this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 2285 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(90);
/* 2286 */     this.rSTableMetro4.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 2287 */     this.rSTableMetro4.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/*      */   }
/*      */   
/*      */   public void llenarTablaSuc(Object[][] arrayOfObject) {
/* 2291 */     (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(arrayOfObject, (Object[])new String[2]) {
/* 2292 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 2294 */           boolean[] canEdit = new boolean[] { true, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 2297 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2301 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2304 */     this.rSTableMetro2.setAltoHead(25);
/* 2305 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2306 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 2307 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 2308 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2309 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 2310 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 2311 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 2312 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2313 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2314 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2315 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 2316 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 2317 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 2318 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 2319 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 2320 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 2321 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2323 */             Proveedores.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 2326 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2328 */             Proveedores.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2331 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 2332 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 2333 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/* 2334 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2335 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/* 2337 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 2338 */     this.rSTableMetro2.setSelectionMode(0);
/* 2339 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2343 */     this.entraSucPrimera = true;
/* 2344 */     String razon = "";
/* 2345 */     if (!this.jTextField1.getText().equals(this.holderRazonSocial))
/* 2346 */       razon = this.jTextField1.getText(); 
/* 2347 */     String rfc = "";
/* 2348 */     if (!this.jTextField2.getText().equals(this.holderRfc))
/* 2349 */       rfc = this.jTextField2.getText(); 
/* 2350 */     String sucursalForsis = "";
/* 2351 */     if (this.jComboBox1.getSelectedIndex() != 0)
/* 2352 */       sucursalForsis = this.jComboBox1.getSelectedItem().toString(); 
/* 2353 */     String estado = " estado like '%%'";
/* 2354 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 2355 */       estado = " estado = 'ACTIVO'";
/* 2356 */     } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 2357 */       estado = " estado = 'ELIMINADO'";
/*      */     } 
/*      */     
/* 2360 */     (new String[18])[0] = "ID"; (new String[18])[1] = ""; (new String[18])[2] = "Razón Social o Nombre"; (new String[18])[3] = "Nombre Comercial"; (new String[18])[4] = "RFC"; (new String[18])[5] = "Dirección"; (new String[18])[6] = "Num"; (new String[18])[7] = "Col"; (new String[18])[8] = "CP"; (new String[18])[9] = "Ciudad"; (new String[18])[10] = "EstadoP"; (new String[18])[11] = "Contacto"; (new String[18])[12] = "Teléfonos"; (new String[18])[13] = "Correo"; (new String[18])[14] = "Moneda"; (new String[18])[15] = "Sucursal Operativa"; (new String[18])[16] = "Estado"; (new String[18])[17] = "Actualizó (dd/mm/aaaa)"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(18, "numProv, tipo, razonSocial, nombreComercial, rfc, calle, num, col, cp, cd, estadoREgion, contacto, tel, correo, moneda, sucOp, estado, usuarioProv", "prov_proveedores", "where razonSocial like '%" + razon + "%' and rfc like '%" + rfc + "%' and sucOp like '%" + sucursalForsis + "%' and " + estado + " order by razonSocial"), (Object[])new String[18])
/*      */         {
/*      */           
/* 2363 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2368 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2371 */     eliminarColumna(6, 5, "Num");
/* 2372 */     eliminarColumna(6, 5, "Col");
/* 2373 */     eliminarColumna(7, 5, "Ciudad");
/* 2374 */     eliminarColumna(6, 5, "CP");
/* 2375 */     eliminarColumna(6, 5, "EstadoP");
/* 2376 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 2377 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2378 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2379 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(30);
/* 2380 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(30);
/* 2381 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(390);
/* 2382 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(390);
/* 2383 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(390);
/* 2384 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(390);
/* 2385 */     this.rSTableMetro1.getColumnModel().getColumn(9).setPreferredWidth(70);
/* 2386 */     this.rSTableMetro1.getColumnModel().getColumn(9).setMaxWidth(70);
/* 2387 */     this.rSTableMetro1.getColumnModel().getColumn(11).setPreferredWidth(100);
/* 2388 */     this.rSTableMetro1.getColumnModel().getColumn(11).setMaxWidth(100);
/* 2389 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 2390 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2391 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 2392 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 2393 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 2394 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 2395 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 2396 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 2397 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 2398 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 2399 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 2400 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 2401 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 2402 */     this.rSTableMetro1.setSelectionMode(0);
/* 2403 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 2404 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2405 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/* 2406 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 2407 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "ELIMINADO", 0, 11, 0));
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 2411 */     int cont = this.rSTableMetro1.getRowCount();
/* 2412 */     String[] registros = new String[cont];
/*      */     int i;
/* 2414 */     for (i = 0; i < cont; i++)
/* 2415 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString(); 
/* 2416 */     for (i = 0; i < cont; i++) {
/* 2417 */       registros[i] = registros[i] + " " + registros[i];
/* 2418 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 2420 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 2421 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 2425 */     this.SUCURSALES = this.con.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 2426 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 2427 */     Iterator<String> it = lista.iterator();
/* 2428 */     while (it.hasNext()) {
/* 2429 */       String v = it.next();
/* 2430 */       this.jComboBox1.addItem(v);
/*      */     } 
/* 2432 */     this.TODOS_ESTADOS.add("AGUASCALIENTES");
/* 2433 */     this.TODOS_ESTADOS.add("BAJA CALIFORNIA NORTE");
/* 2434 */     this.TODOS_ESTADOS.add("BAJA CALIFORNIA SUR");
/* 2435 */     this.TODOS_ESTADOS.add("CAMPECHE");
/* 2436 */     this.TODOS_ESTADOS.add("CIUDAD DE MEXICO");
/* 2437 */     this.TODOS_ESTADOS.add("COAHUILA");
/* 2438 */     this.TODOS_ESTADOS.add("COLIMA");
/* 2439 */     this.TODOS_ESTADOS.add("CHIAPAS");
/* 2440 */     this.TODOS_ESTADOS.add("CHIHUAHUA");
/* 2441 */     this.TODOS_ESTADOS.add("DISTRITO FEDERAL");
/* 2442 */     this.TODOS_ESTADOS.add("DURANGO");
/* 2443 */     this.TODOS_ESTADOS.add("GUANAJUATO");
/* 2444 */     this.TODOS_ESTADOS.add("GUERRERO");
/* 2445 */     this.TODOS_ESTADOS.add("HIDALGO");
/* 2446 */     this.TODOS_ESTADOS.add("JALISCO");
/* 2447 */     this.TODOS_ESTADOS.add("MÉXICO");
/* 2448 */     this.TODOS_ESTADOS.add("MICHOACÁN");
/* 2449 */     this.TODOS_ESTADOS.add("MORELOS");
/* 2450 */     this.TODOS_ESTADOS.add("NAYARIT");
/* 2451 */     this.TODOS_ESTADOS.add("NUEVO LEÓN");
/* 2452 */     this.TODOS_ESTADOS.add("OAXACA");
/* 2453 */     this.TODOS_ESTADOS.add("PUEBLA");
/* 2454 */     this.TODOS_ESTADOS.add("QUERETARO");
/* 2455 */     this.TODOS_ESTADOS.add("QUINTANA ROO");
/* 2456 */     this.TODOS_ESTADOS.add("SAN LUIS POTOSÍ");
/* 2457 */     this.TODOS_ESTADOS.add("SINALOA");
/* 2458 */     this.TODOS_ESTADOS.add("SONORA");
/* 2459 */     this.TODOS_ESTADOS.add("TABASCO");
/* 2460 */     this.TODOS_ESTADOS.add("TAMAULIPAS");
/* 2461 */     this.TODOS_ESTADOS.add("TLAXCALA");
/* 2462 */     this.TODOS_ESTADOS.add("VERACRUZ");
/* 2463 */     this.TODOS_ESTADOS.add("YUCATÁN");
/* 2464 */     this.TODOS_ESTADOS.add("ZACATECAS");
/* 2465 */     this.com_Estados = new TextAutoCompleter(this.jTextField24, this.TODOS_ESTADOS);
/*      */   }
/*      */   
/*      */   public void proveedores(String USUARIO) {
/* 2469 */     privilegios();
/* 2470 */     this.USUARIO = USUARIO;
/* 2471 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public int sacarMayor() {
/* 2475 */     int clave = 0;
/* 2476 */     this.con.consultar("max(numProv)", "prov_proveedores", "");
/*      */     try {
/* 2478 */       clave = Integer.parseInt(this.con.Campo);
/* 2479 */       clave++;
/* 2480 */     } catch (Exception e) {
/* 2481 */       clave = 1;
/*      */     } 
/* 2483 */     return clave;
/*      */   }
/*      */   
/*      */   public class CeldaRender1 extends DefaultTableCellRenderer {
/* 2487 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2490 */       setEnabled((table == null || table.isEnabled()));
/* 2491 */       if (row % 2 == 0) {
/* 2492 */         setBackground(Proveedores.this.lc.FONDOTABLA);
/*      */       } else {
/* 2494 */         setBackground((Color)null);
/*      */       } 
/* 2496 */       setForeground(Proveedores.this.lc.SECUNDARIO1);
/* 2497 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2498 */       return this;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender2() {
/* 2503 */       this.otro = -1;
/*      */       
/* 2505 */       this.indices = new String[0];
/*      */     } String[] indices;
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2508 */       setEnabled((table == null || table.isEnabled()));
/* 2509 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 2510 */       setForeground(Proveedores.this.lc.SECUNDARIO1);
/* 2511 */       if (comparar(comp)) {
/* 2512 */         setBackground(Color.RED);
/* 2513 */         setForeground(Color.WHITE);
/* 2514 */       } else if (row % 2 == 0) {
/* 2515 */         setBackground(Proveedores.this.lc.FONDOTABLA);
/*      */       } else {
/* 2517 */         setBackground((Color)null);
/*      */       } 
/* 2519 */       if (column == 0) {
/* 2520 */         setHorizontalAlignment(4);
/* 2521 */       } else if (column == 1) {
/* 2522 */         setHorizontalAlignment(0);
/*      */       } else {
/* 2524 */         setHorizontalAlignment(10);
/*      */       } 
/* 2526 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2527 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 2531 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 2535 */       for (int i = 0; i < this.indices.length; i++) {
/* 2536 */         if (this.indices[i].equals(reg))
/* 2537 */           return true; 
/*      */       } 
/* 2539 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable {
/*      */     Thread t;
/* 2546 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 2549 */       this.t = new Thread(this);
/* 2550 */       this.t.start();
/*      */     }
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 2557 */         Proveedores.this.EtiquetaEstado.setVisible(true);
/* 2558 */         Proveedores.this.EtiquetaEstado.setText("Buscando datos, por favor espere...");
/* 2559 */         Proveedores.this.setCursor(new Cursor(3));
/* 2560 */         Thread.currentThread();
/* 2561 */         Thread.sleep(1000L);
/* 2562 */         detener();
/* 2563 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */     
/*      */     public void detener() {
/* 2567 */       Proveedores.this.consultar();
/* 2568 */       Proveedores.this.setCursor(Proveedores.this.micursor);
/* 2569 */       Proveedores.this.EtiquetaEstado.setVisible(false);
/* 2570 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 2574 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Proveedores.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */