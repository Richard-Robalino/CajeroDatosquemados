import javax.swing.*;

public class SaldoForm extends JFrame {
    private JLabel labelSaldo;
    private JButton buttonRegresar;

    private CuentaBancaria cuenta;

    public SaldoForm(CuentaBancaria cuenta) {
        this.cuenta = cuenta;

        setTitle("Consulta de Saldo");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();

        labelSaldo = new JLabel();
        actualizarSaldo();

        buttonRegresar = new JButton("Regresar al Menú");

        panel.add(labelSaldo);
        panel.add(buttonRegresar);

        add(panel);


        buttonRegresar.addActionListener(e -> {
            dispose();
        });
    }

    public void actualizarSaldo() {
        labelSaldo.setText("Saldo actual: $" + cuenta.getSaldo());
    }
}
