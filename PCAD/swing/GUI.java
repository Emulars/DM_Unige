// Funzionamento
// 1. Inizialmente il tasto SETP è selezionabile
// 2. Quando premo STEP
//      2.1 Il tasto STEP viene disattivato
//      2.2 viene lanciata su thread separato la fase corrente
// 3. Alla fine della simulazione della fase corrente
//      3.1 il thread invia i dati all'EDT che li visualizza nella GUI
//      3.2 Il bottone STEP viene riattivato
// 4. Si torna a 2


import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
	JButton step;
    JLabel  statusLabel;
    int counter;
    
    public GUI() {
        super("Swing");
        counter=0;
        step = new JButton("Step");
        statusLabel = new JLabel("0");
        MyListener step_handler  = new MyListener(this);
        step.addActionListener(step_handler);
        JPanel Panel = new JPanel();
        Panel.add(step);
        Panel.add(statusLabel);
        getContentPane().add(Panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            // per mantenere fin da principio l'esecuzione single thread
            // passando al EDT (Event Dispatch Thread) la gestione
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
