import javax.swing.SwingUtilities;

public class principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Instanciamos y mostramos la ventana
            jFrame_dibujorick ventana = new jFrame_dibujorick();
            ventana.setVisible(true);
        });
    }
}