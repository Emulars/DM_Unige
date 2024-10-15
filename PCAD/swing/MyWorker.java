import javax.swing.*;
import java.util.List;

public class MyWorker extends SwingWorker<String, Integer> {

    private final GUI gui;
    private int count;

    public MyWorker(GUI gui) {
        this.gui = gui;
        this.count = gui.counter;
    }

    // Lanciata da Execute()
    // NON FARE UPDATE perche' crea conflitto con EDT
    @Override
    protected String doInBackground() throws Exception {
        Thread.sleep(1000);
        count++;
        return "Done!";
    }

    //delegata al EDT e thread safedone();
    // Log dei messaggi intermedi
    @Override
    protected void process(List<Integer> chunks) {
    }

    //delegata al EDT e thread safe
    // Da lanciare alla fine di doInBackground()
    // Scrive risultato su GUI
    @Override
    protected void done() {
        // Possiamo anche rimuovere la riga count++ da doInBackground()
        // e aggiungere qui l'incremento, così da rimuovere la variabile locale count
        //gui.counter += 1
        gui.counter = count;
        gui.statusLabel.setText(Integer.toString(count));
        gui.step.setEnabled(true);
    }

}
