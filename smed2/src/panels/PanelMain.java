package panels;

import static org.openstreetmap.josm.tools.I18n.tr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.openstreetmap.josm.Main;

import smed2.Smed2Action;

public class PanelMain extends JPanel {

	private JTabbedPane tabs = null;
//	public PanelF panelF = null;
	public static JTextField messageBar = null;
	public JButton saveButton = null;
	private ActionListener alSave = new ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
//			item.saveSign(???);
		}
	};
	private JButton importButton = null;
	final JFileChooser ifc = new JFileChooser();
	private ActionListener alImport = new ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == importButton) {
        messageBar.setText("Select file");
        int returnVal = ifc.showOpenDialog(Main.parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          Smed2Action.panelS57.startImport(ifc.getSelectedFile());
         } else {
           messageBar.setText("");
         }
      }
		}
	};

	private JButton exportButton = null;
	final JFileChooser efc = new JFileChooser();
	private ActionListener alExport = new ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == exportButton) {
        messageBar.setText("Select file");
        int returnVal = efc.showOpenDialog(Main.parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          Smed2Action.panelS57.startExport(efc.getSelectedFile());
         } else {
           messageBar.setText("");
         }
      }
		}
	};

	public PanelMain() {

		setLayout(null);
		setSize(new Dimension(480, 480));
		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setBounds(new Rectangle(0, 0, 480, 420));

//		JPanel panelF = new PanelF();
//		tabs.addTab(null, new ImageIcon(getClass().getResource("/images/tabF.png")), panelF, Messages.getString("Ports"));

		add(tabs);
		
    messageBar = new JTextField();
    messageBar.setBounds(70, 430, 290, 20);
    messageBar.setEditable(false);
    messageBar.setBackground(Color.WHITE);
    add(messageBar);
		importButton = new JButton(new ImageIcon(getClass().getResource("/images/importButton.png")));
		importButton.setBounds(10, 430, 20, 20);
		add(importButton);
		importButton.addActionListener(alImport);
		exportButton = new JButton(new ImageIcon(getClass().getResource("/images/exportButton.png")));
		exportButton.setBounds(40, 430, 20, 20);
		add(exportButton);
		exportButton.addActionListener(alExport);
		saveButton = new JButton();
		saveButton.setBounds(370, 430, 100, 20);
		saveButton.setText(tr("Save"));
		add(saveButton);
		saveButton.addActionListener(alSave);

	}
}
