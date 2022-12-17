import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

/**program do przeglądania obrazów.
 * damian
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
/** Ramka z etykietą wyświetlającą obraz.
 */
class ImageViewerFrame extends JFrame {
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        /** Użycie etykiety do wyświetlania obrazów.
         */
        label = new JLabel();
        add(label);
        /** dodawanie opcji wyboru obrazu
         */
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        /** pasek menu.
         */
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);
        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            /**Wyświetlanie okna dialogowego wyboru pliku
             */
            int result = chooser.showOpenDialog(null);
            /**jesli plik został wybrany, ustawiamy go jako ikonę etykiety.
             *
             */
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));

            }
        });
        JMenuItem exitItem = new JMenuItem("Zakończ.");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}