import javax.swing.*;

public class MenuForm extends JFrame {
    private JButton buttonVerSaldo;
    private JButton buttonRetiro;
    private JButton buttonDeposito;
    private JButton buttonSalir;

    public MenuForm() {
        setTitle("Menú Principal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    public JButton getButtonVerSaldo() {
        return buttonVerSaldo;
    }

    public JButton getButtonRetiro() {
        return buttonRetiro;
    }

    public JButton getButtonDeposito() {
        return buttonDeposito;
    }

    public JButton getButtonSalir() {
        return buttonSalir;
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        buttonVerSaldo = new JButton("Ver Saldo");
        buttonRetiro = new JButton("Retiro");
        buttonDeposito = new JButton("Depósito");
        buttonSalir = new JButton("Salir");


        panel.add(buttonVerSaldo);
        panel.add(buttonRetiro);
        panel.add(buttonDeposito);
        panel.add(buttonSalir);

        add(panel);
    }
}
