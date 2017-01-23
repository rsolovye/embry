package views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
//TODO: move to Utilities.GUI pkg


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.StringSelection;


@SuppressWarnings("Since15")
public class Utils {

    public static  final String[]
            DIAGNOSES   = {"97.0", "97.1", "97.2", "97.3", "97.4", "97.8"},
            HEPATITIS   = {"HepA", "HepB", "HepC", "HepA", "HepB", "HepC"},
            DOCTORS     = {"Гвасалия Р.Г.", "Шарфи Ю.Н.", "Геркулов Д.А.", "Жарова М.В."},
            EMB         = {"Лямина ИВ", "Мурза ГВ", "Хандога АО", "Соловьев РС", "Черноштан К?"},
            FEM_EGG_STATE = {"свежие", "крио"};

//Gui global vars

    public static final Border LINE_BORDER = BorderFactory.createLineBorder(new Color(4, 212, 223), 2);

    public static final  Color BG_SUB_1 = new Color(72, 188, 228);

    public static final Color TFBG_COLOR = new Color(250,250,250);

    public static final Color TITLE_LINE_COLOR = new Color(4, 212, 223);


    public static final String[] BUTTON_GROUP_1 =  {"пациентка", "донор"};

    //title wrapper with standard single line border
//JPanel object assigns each panel's setName by combining
//title  string parameter passed at the call time and "_panel"
    //
    public static JPanel getPanel(JComponent j){
        JPanel p = new JPanel();
        p.add(j);
        return p;

    }

    public static JPanel makePaneledCheckBoxes(String[] titles) {
        JCheckBox[] jcb = new JCheckBox[titles.length];
        JPanel[] jcp = new JPanel[titles.length];
        JPanel last = new JPanel();
        for (int i = 0; i < titles.length; i++) {
            jcb[i] = new JCheckBox(titles[i]);
            jcb[i].setName("checkbox_" + titles + "_" + i);
            //  jcb[i].setBackground(BG_SUB_1);
            jcp[i] = new JPanel(new MigLayout("insets 0"));
            jcp[i].add(jcb[i]);
            //   jcp[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,BG_SUB_1));
            last.add(jcp[i]);
        }


        return last;
    }

//overload :1
//TODO:  move all Look&Fill values to the db and reference 'em

    public static JPanel getTitled(String title, JComponent[] jc) {
        JPanel pan= new JPanel();

        pan.setName(title + "_panel");

        for (int i = 0; i < jc.length; i++) {
            pan.add(jc[i]);
        }

        pan.setBorder(BorderFactory.createTitledBorder(LINE_BORDER, title));
        pan.setBackground(BG_SUB_1);
        pan.validate();

        return pan;
    }
    //EMPTY PANEL WITH TITLED BORDER
    public static JPanel getTitledPanel(String title) {
        return getTitledPanel(title, new JPanel(), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION);
    }
    //JPanel with titled border, no title
    public static JPanel getTitledPanel(JComponent jc) {

        return getTitledPanel("", jc, TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
    }

    public static JPanel getTitledPanel(String title, JComponent jc, int justification, int pos) {
        JPanel pan= new JPanel(new MigLayout(""));
        pan.setName(title + "_panel");
        pan.add(jc, "");
        pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), title, justification, pos));
        pan.validate();

        return pan;
    }


    public static JPanel setToPanel(String title, JComponent jc, Border b, MigLayout mg) {

        JPanel  pan = new JPanel();

        if  (mg !=  null)    pan.setLayout(mg);
        if  (jc !=  null)    pan.add(jc);
        if  (b  !=  null)    pan.setBorder(b);

        pan.setName(title + "_panel");
        pan.validate();

        return pan;
    }

    public static JPanel getTitledPanel(String title, JComponent jc, MigLayout mig) {
        JPanel pan= new JPanel(mig);

        pan.setName(title + "_panel");

        pan.add(jc);

        // pan.setBorder(BorderFactory.createTitledBorder(LINE_BORDER, title));
        // pan.setBackground(BG_SUB_1);
        pan.validate();

        return pan;
    }
    public static JComponent getTF(String tf){

        JPanel p = new JPanel(new MigLayout("left,  flowx"));
        JTextField t = new JTextField();
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), tf, TitledBorder.CENTER, TitledBorder.CENTER));
        p.add(t, "pushx, grow");

        return p;
    }

    public static JComponent getTF(String tf, int col){
        JPanel p = new JPanel(new MigLayout("left"));
        JTextField t = new JTextField(col);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), tf, TitledBorder.CENTER, TitledBorder.CENTER));
        p.add(t);

        return p;
    }
    public static JComponent getTF(String tf, int col, int just, int pos){
        JPanel p = new JPanel(new MigLayout("left"));
        JTextField t = new JTextField(col);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), tf, just, pos));
        p.add(t);

        return p;
    }
    public static JComponent getTwoTF(String tf, int col, int col2){
        JPanel p = new JPanel(new MigLayout("flowx"));
        JTextField t = new JTextField(col), t2 = new JTextField(col2);
        p.add(t);
        p.add(t2);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), tf, TitledBorder.CENTER, TitledBorder.CENTER));

        return p;
    }
    public static JPanel getTextFieldPanel(int columns) {
        JTextField tf = new JTextField(columns);
        JPanel pan = new JPanel();


        // tf.setBackground(new Color(250, 250, 250));
        // tf.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        //pan.setBorder(LINE_BORDER);
        pan.add(tf);
        // pan.setBackground(BG_SUB_1);
        pan.validate();
        return pan;
    }

    public static JPanel getTextFieldPanel(int columns, MigLayout mig) {
        JTextField tf = new JTextField(35);
        JPanel pan = new JPanel(mig);


        //tf.setBackground(new Color(250, 250, 250));
        //tf.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        // pan.setBorder(LINE_BORDER);
        pan.add(tf, "push, span, grow");
        //pan.setBackground(BG_SUB_1);
        pan.validate();
        return pan;
    }


    //TODO: Rename
//TODO: try other  jcomponents
//set ups for Jlist's individual string looks and behaves props
    public static ListCellRenderer choosable_label(int font_size) {
        final int font_s = font_size;

        ListCellRenderer renderer = (list, value, index, isSelected, cellHasFocus) -> {
            JLabel label = new JLabel();
            JPanel k = new JPanel(new MigLayout("insets 5"));
            label.setText(value.toString());
            if (isSelected) {
                // k.setBackground(new Color(216, 218, 216));
                label.setForeground(Color.BLACK);

                label.setFont(new Font("PT Sans", Font.BOLD, font_s));
                k.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, Color.black), ""));
            } else {
                k.setBackground(Color.WHITE);
                label.setForeground(Color.black);
                label.setFont(new Font("PT Sans", Font.BOLD, font_s));

                k.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.lightGray));

            }


            k.add(label, "left");
            return k;
        };
        return renderer;
    }


    public static ListCellRenderer choosable_bold_label() {

        ListCellRenderer renderer = new ListCellRenderer() {

            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                JPanel k = new JPanel(new MigLayout("", ""));

                label.setText(value.toString());
                label.setForeground(Color.BLACK);

                if (isSelected) {
                    k.setBackground(Color.white);
                    label.setForeground(Color.BLACK);

                    label.setFont(new Font("PT Sans", Font.BOLD, 12));
                } else {
                    k.setBackground(Color.WHITE);

                    label.setFont(new Font("PT Sans", Font.PLAIN, 12));

                }
                k.add(label, "");
                return k;
            }
        };
        return renderer;
    }

//GUI Utilities: methods for readable interface construction

    public  static JList getList(String[] list_array, int font_size, int vrc, boolean auto_scrls) {
        DefaultListModel lm = new DefaultListModel();
        for (String k : list_array){
            lm.addElement(k);
        }
        JList rList = new JList(lm);
        //rList.setCellRenderer(choosable_label(font_size));
        rList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rList.setVisibleRowCount(vrc);
        rList.setAutoscrolls(auto_scrls);

        return rList;
    }


    public  static JList getList(DefaultListModel m, int vrc, int sel) {

        JList rList = new JList(m);
        //rList.setCellRenderer(choosable_label(12));
        rList.setSelectionMode(sel);
        rList.setVisibleRowCount(vrc);
        //rList.setAutoscrolls(auto_scrls);

        return rList;
    }
    public  static JList getList(String[] list_array) {
        return getList(list_array, 12, 4, true);
    }


    public  static JList getList() {
        return getList(new String[]{}, 12, 4, true);
    }


    public static JPanel getMultiComboPanel (String[] str_arr, int count) {

        JPanel p_JB = new JPanel(new MigLayout("", "", ""));
        int x = 0;
        while (x < count) {
            JComboBox jbox = new JComboBox(str_arr);
            jbox.setName("combo_" + x);

            // jbox.setRenderer(choosable_bold_label());
            p_JB.add(jbox, "wrap");
            x++;
        }

        //p_JB.setBackground(BG_SUB_1);
        p_JB.validate();
        return p_JB;

    }
    public static JComponent getCB(String title, int x, int y, int font_sz, boolean inPanel){
        JCheckBox jc = new JCheckBox(title);

        jc.setFont(new Font("PT Serif Caption", Font.BOLD, font_sz));

        if (x>0 && y>0 && !inPanel) {
            jc.setSize(new Dimension(x, y));
            jc.setMinimumSize(jc.getSize());
            jc.setPreferredSize(jc.getSize());


            return jc;}
        else {

            JPanel jp = new JPanel(new MigLayout(""));
            jp.add(jc, "top, push, grow");
            if (x>0 && y>0) {
                jp.setMinimumSize(new Dimension(x, y));
                jp.setPreferredSize(jp.getMinimumSize());
            }

            return jp;
        }
    }

    public  static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("PT Sans", Font.BOLD, 13));

        label.setVerticalAlignment(SwingUtilities.CENTER);
        return label;
    }

}