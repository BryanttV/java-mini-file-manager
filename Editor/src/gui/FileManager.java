package gui;

// Utilities
import comunication.IArchiver;
import comunication.ICompressor;
import comunication.PArchiver;
import comunication.PCompressor;

// Java
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Bryann_Valderrama
 */
public class FileManager extends javax.swing.JFrame {

    // Components
    IArchiver ia = PArchiver.obtainFile();
    ICompressor ic = PCompressor.compressFile();

    JFileChooser fileChooser = null; // Manejador de Archivos
    FileNameExtensionFilter textFilter = null; // Filtro de archivos .txt

    public FileManager() {
        initComponents();
        configureWindow();
    }

    private void configureWindow() {
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/resources/notepad.png")).getImage());
    }

    private File save() {
        // Manejador de Archivos
        fileChooser = new JFileChooser();
        // Solo se puede seleccionar archivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Filtar para mostrar solo los archivos .txt
        textFilter = new FileNameExtensionFilter("Archivos de Texto", "txt");
        fileChooser.setFileFilter(textFilter);

        int result = fileChooser.showSaveDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if (fileName != null) {
                
                if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                    fileName = new File(fileChooser.getSelectedFile() + ".txt");
                }
                
                String text = Txa_FileManager.getText();
                boolean save = ia.save(fileName.getAbsolutePath(), text);
                
                if (save) {
                    JOptionPane.showMessageDialog(null, "Archivo Guardado");
                    return fileName;
                }
            }
        }
        return null;
    }

    private void load() {
        // Manejador de Archivos
        fileChooser = new JFileChooser();
        // Solo se puede seleccionar archivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Filtar para mostrar solo los archivos .txt
        textFilter = new FileNameExtensionFilter("Archivos de Texto", "txt");
        fileChooser.setFileFilter(textFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if (fileName != null) {
                if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                    fileName = new File(fileChooser.getSelectedFile() + ".txt");
                }
                String text = ia.load(fileName.getAbsolutePath());
                Txa_FileManager.setText(text);
                Txa_FileManager.setCaretPosition(0);
            }
        }
    }

    private void compress() {
        File path = save();
        if (path != null) {
            boolean result = ic.compress(path.getAbsolutePath(), path.getName());
            if (result) {
                JOptionPane.showMessageDialog(null, "Archivo Comprimido");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_FileManager = new javax.swing.JPanel();
        Scp_FileManager = new javax.swing.JScrollPane();
        Txa_FileManager = new javax.swing.JTextArea();
        Mnb_FileManager = new javax.swing.JMenuBar();
        Mnu_Options = new javax.swing.JMenu();
        Mni_Save = new javax.swing.JMenuItem();
        Mni_Open = new javax.swing.JMenuItem();
        Mni_Compress = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bloc de Notas");

        Txa_FileManager.setColumns(20);
        Txa_FileManager.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Txa_FileManager.setLineWrap(true);
        Txa_FileManager.setRows(5);
        Txa_FileManager.setWrapStyleWord(true);
        Txa_FileManager.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        Scp_FileManager.setViewportView(Txa_FileManager);

        javax.swing.GroupLayout Pnl_FileManagerLayout = new javax.swing.GroupLayout(Pnl_FileManager);
        Pnl_FileManager.setLayout(Pnl_FileManagerLayout);
        Pnl_FileManagerLayout.setHorizontalGroup(
            Pnl_FileManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scp_FileManager, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        Pnl_FileManagerLayout.setVerticalGroup(
            Pnl_FileManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scp_FileManager, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        Mnu_Options.setText("Acciones");

        Mni_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Mni_Save.setText("Guardar");
        Mni_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mni_SaveActionPerformed(evt);
            }
        });
        Mnu_Options.add(Mni_Save);

        Mni_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Mni_Open.setText("Abrir");
        Mni_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mni_OpenActionPerformed(evt);
            }
        });
        Mnu_Options.add(Mni_Open);

        Mni_Compress.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Mni_Compress.setText("Comprimir");
        Mni_Compress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mni_CompressActionPerformed(evt);
            }
        });
        Mnu_Options.add(Mni_Compress);

        Mnb_FileManager.add(Mnu_Options);

        setJMenuBar(Mnb_FileManager);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_FileManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_FileManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Mni_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mni_SaveActionPerformed
        save();
    }//GEN-LAST:event_Mni_SaveActionPerformed

    private void Mni_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mni_OpenActionPerformed
        load();
    }//GEN-LAST:event_Mni_OpenActionPerformed

    private void Mni_CompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mni_CompressActionPerformed
        compress();
    }//GEN-LAST:event_Mni_CompressActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FileManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Mnb_FileManager;
    private javax.swing.JMenuItem Mni_Compress;
    private javax.swing.JMenuItem Mni_Open;
    private javax.swing.JMenuItem Mni_Save;
    private javax.swing.JMenu Mnu_Options;
    private javax.swing.JPanel Pnl_FileManager;
    private javax.swing.JScrollPane Scp_FileManager;
    private javax.swing.JTextArea Txa_FileManager;
    // End of variables declaration//GEN-END:variables
}
