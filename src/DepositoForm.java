import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositoForm extends JFrame {
    private JLabel labelCantidad;
    private JTextField fieldCantidad;
    private JButton buttonDepositar;
    private JButton buttonRegresar;

    private CuentaBancaria cuenta;

    public DepositoForm(CuentaBancaria cuenta) {
        this.cuenta = cuenta;

        setTitle("Depósito de Fondos");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        labelCantidad = new JLabel("Ingrese la cantidad a depositar:");
        fieldCantidad = new JTextField(10);
        buttonDepositar = new JButton("Depositar");
        buttonRegresar = new JButton("Regresar al Menú");

        panel.add(labelCantidad);
        panel.add(fieldCantidad);
        panel.add(buttonDepositar);
        panel.add(buttonRegresar);

        add(panel);


        buttonDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositarFondos();
            }
        });


        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void depositarFondos() {
        String cantidadStr = fieldCantidad.getText().trim();

        try {
            double cantidad = Double.parseDouble(cantidadStr);

            cuenta.depositar(cantidad);


            JOptionPane.showMessageDialog(this, "Se ha depositado $" + cantidad + "\nNuevo saldo: $" + cuenta.getSaldo(), "Depósito Exitoso", JOptionPane.INFORMATION_MESSAGE);

            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
