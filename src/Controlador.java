import javax.swing.*;

public class Controlador {
    private BienvenidaForm bienvenidaForm;
    private MenuForm menuForm;
    private SaldoForm saldoForm;
    private RetiroForm retiroForm;
    private DepositoForm depositoForm;

    private CuentaBancaria cuenta;

    public Controlador() {

        cuenta = new CuentaBancaria("1234567890", 1000);

        bienvenidaForm = new BienvenidaForm();
        bienvenidaForm.setVisible(true);

        bienvenidaForm.getButtonSubmit().addActionListener(e -> {
            String password = bienvenidaForm.getPassword();
            if (password.equals("password")) {
                bienvenidaForm.setVisible(false);
                mostrarMenu();
            } else {
                bienvenidaForm.mostrarMensaje("Contraseña incorrecta");
            }
        });
    }

    private void mostrarMenu() {
        menuForm = new MenuForm();
        menuForm.setVisible(true);

        menuForm.getButtonVerSaldo().addActionListener(e -> {
            mostrarSaldo();
        });

        menuForm.getButtonRetiro().addActionListener(e -> {
            mostrarRetiro();
        });

        menuForm.getButtonDeposito().addActionListener(e -> {
            mostrarDeposito();
        });

        menuForm.getButtonSalir().addActionListener(e -> {
            System.exit(0);
        });
    }

    private void mostrarSaldo() {
        if (saldoForm == null) {
            saldoForm = new SaldoForm(cuenta);
        }
        saldoForm.actualizarSaldo(); // Actualizar el saldo antes de mostrar el formulario
        saldoForm.setVisible(true);
    }

    private void mostrarRetiro() {
        if (retiroForm == null) {
            retiroForm = new RetiroForm(cuenta);
        }
        retiroForm.setVisible(true);
    }

    private void mostrarDeposito() {
        if (depositoForm == null) {
            depositoForm = new DepositoForm(cuenta);
        }
        depositoForm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Controlador::new);
    }
}
