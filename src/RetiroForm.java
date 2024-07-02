import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetiroForm extends JFrame {
    private JLabel labelCantidad;
    private JTextField fieldCantidad;
    private JButton buttonRetirar;
    private JButton buttonRegresar;

    private CuentaBancaria cuenta;

    public RetiroForm(CuentaBancaria cuenta) {
        this.cuenta = cuenta;

        setTitle("Retiro de Fondos");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        labelCantidad = new JLabel("Ingrese la cantidad a retirar:");
        fieldCantidad = new JTextField(10);
        buttonRetirar = new JButton("Retirar");
        buttonRegresar = new JButton("Regresar al Menú");

        panel.add(labelCantidad);
        panel.add(fieldCantidad);
        panel.add(buttonRetirar);
        panel.add(buttonRegresar);

        add(panel);


        buttonRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retirarFondos();
            }
        });


        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void retirarFondos() {
        String cantidadStr = fieldCantidad.getText().trim();

        try {
            double cantidad = Double.parseDouble(cantidadStr);

            cuenta.retirar(cantidad);


            JOptionPane.showMessageDialog(this, "Se ha retirado $" + cantidad + "\nNuevo saldo: $" + cuenta.getSaldo(), "Retiro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            dispose(); // Cerrar ventana actual
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SaldoInsuficienteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
