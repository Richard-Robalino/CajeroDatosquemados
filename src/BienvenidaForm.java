import javax.swing.*;

public class BienvenidaForm extends JFrame {
    private JLabel labelPassword;
    private JPasswordField fieldPassword;
    private JButton buttonSubmit;

    public BienvenidaForm() {
        setTitle("Bienvenida - Ingrese su contraseña");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        labelPassword = new JLabel("Ingrese su contraseña:");
        fieldPassword = new JPasswordField(20);
        buttonSubmit = new JButton("Ingresar");

        panel.add(labelPassword);
        panel.add(fieldPassword);
        panel.add(buttonSubmit);

        add(panel);
    }

    public JLabel getLabelPassword() {
        return labelPassword;
    }

    public JPasswordField getFieldPassword() {
        return fieldPassword;
    }

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }

    public String getPassword() {
        return new String(fieldPassword.getPassword());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
}
