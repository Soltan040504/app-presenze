package it.pigrecoallaterza.app_presenze.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class GUI {

	/*
	 * GUI COMPONENTS DECLARATION
	 */
	private JFrame mainFrame;

	private JScrollPane scrollBox;

	private JTable table;
	private int HEADER_HEIGHT = 40;
	private String[] tableColumnNames = { "Giorno", "Ferie, Malattia o Permesso", "Ore Permesso", "Ingresso", "Uscita",
			"Intervallo", "Attività / Note", "Cliente" };

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame frame) {
		this.mainFrame = frame;
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the main frame.
	 */
	private void initialize() {
		mainFrame = new JFrame("App Presenze");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		mainFrame.setMinimumSize(new Dimension(480, 480));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[2][], tableColumnNames));

		table.getTableHeader().setPreferredSize(new Dimension(0, HEADER_HEIGHT));
		fitColumnWidths(table, 10);

		scrollBox = new JScrollPane(table);
		mainFrame.add(scrollBox, BorderLayout.CENTER);

	}

	/*
	 * FUNCTIONS
	 */

	/**
	 * Makes each column of the given table exactly the right size it needs. Note
	 * that this method turns the table auto resize off.
	 * 
	 * @param table   the table that will have its columns adjust to appropriate
	 *                size
	 * @param padding the number of pixels of extra space to leave (the actual
	 *                column width will be the maximum width of any value in the
	 *                column, plus this padding amount)
	 */
	public static void fitColumnWidths(JTable table, int padding) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 0; i < table.getColumnCount(); i++) {
			fitColumnWidth(table, i, padding);
		}
	}

	/**
	 * Sets the given column of the given table to be exactly as wide as it needs to
	 * be to fit its current contents. The contents of each body cell in this
	 * column, as well as the header component is taken into account.
	 * 
	 * @param table    The table whose column to resize
	 * @param colIndex The index of the column to resize
	 * @param padding  the number of pixels of extra space to leave (the actual
	 *                 column width will be the maximum width of any value in the
	 *                 column, plus this padding amount)
	 */
	public static void fitColumnWidth(JTable table, int colIndex, int padding) {
		TableColumn column = null;
		Component comp = null;
		int cellWidth = 0;
		TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
		column = table.getColumnModel().getColumn(colIndex);

		comp = headerRenderer.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, 0, colIndex);

		// Headers need additional padding for some reason!
		cellWidth = comp.getPreferredSize().width + 2;
		
		// Set minimum cell width to header's width
		column.setMinWidth(cellWidth + padding);

		for (int i = 0; i < table.getRowCount(); i++) {
			final TableCellRenderer cellRenderer = table.getCellRenderer(i, colIndex);
			if (cellRenderer == null)
				continue;
			comp = cellRenderer.getTableCellRendererComponent(table, table.getValueAt(i, colIndex), false, false, i,
					colIndex);

			// add a one-pixel fudge factor
			cellWidth = Math.max(cellWidth, comp.getPreferredSize().width + 1);
		}
		column.setPreferredWidth(cellWidth + padding);
	}
}
