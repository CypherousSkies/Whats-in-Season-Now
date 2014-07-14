package seasonality;

import assets.LoadArt;
import input.ActionArea;
import input.ButtonInput;
import input.MButton;
import input.MButtonInput;
import input.MouseInput;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import ui.EndScreen;
import ui.Gameplay;
import ui.MainMenuPanel;
import ui.StartupOptions;

/**
 *
 * @author Torri
 */
public class Seasonality extends JFrame {

    //Panels
    public static Seasonality s;
    public static StartupOptions o;
    public static MainMenuPanel mmp;
    public static Gameplay gp;
    public static ButtonInput bi = new ButtonInput();
    public static MouseInput mi = new MouseInput();
    public static MButtonInput mbi = new MButtonInput();
    public static EndScreen es = new EndScreen();
    //MButtons
    public static ArrayList<MButton> buttons = new ArrayList<>();
    public static ArrayList<Double> placeX = new ArrayList<>();
    public static ArrayList<Double> placeY = new ArrayList<>();
    public static ArrayList<Double> sizeX = new ArrayList<>();
    public static ArrayList<Double> sizeY = new ArrayList<>();
    //Action Areas
    public static ArrayList<ActionArea> aa = new ArrayList<>();
    public static ArrayList<Integer> aaX = new ArrayList<>();
    public static ArrayList<Integer> aaY = new ArrayList<>();
    public static ArrayList<Integer> aasX = new ArrayList<>();
    public static ArrayList<Integer> aasY = new ArrayList<>();
    //Count Down
    public static long timeLeft = 5 * (60000);
    //Crops Clicked
    public static boolean[] clicked = new boolean[Crops.values().length];
    public static int pickedup = -1;
    public static boolean[] pointTaken = new boolean[Crops.values().length];
    public static boolean update = false, resetPaint = false;
    //Score
    public static int score = 0;
    //Mode
    public static final int EASY_MODE = 0;
    public static final int NORMAL_MODE = 1;
    public static int mode = 0;
    //Reder Points
    public static double xMult = 1920.0 / 1174.0;
    public static double yMult = 1080.0 / 868.0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        s = new Seasonality();
    }

    public Seasonality() {
        super("Seasonality");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setIconImage(new LoadArt().createBufferedImage("Favicon.jpg"));
        setResizable(false);
        addMouseListener(mi);
        addMouseMotionListener(mi);
        o = new StartupOptions();
        o.setVisible(true);
        add(o);
        o.updateUI();
        mmp = new MainMenuPanel();
        mmp.setVisible(false);
        add(mmp);
        gp = new Gameplay();
        gp.setVisible(false);
        add(gp);
    }

    public void fullScreen() {
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(s);
    }

    public static int renders = 0;
    
    public static int l;

    public void render() {

        long start = System.nanoTime();

        xMult = getWidth() / 1174.0;
        yMult = getHeight() / 868.0;

        if (o.isVisible()) {
            return;
        }

        this.setFocusable(true);

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if (mmp.isVisible()) {
            mmp.render(g);
        } else if (gp.isVisible()) {
            gp.render(g);
        } else if (es.isVisible()) {
            es.render(g);
        }

        updateButtons(g, gp.isVisible());

        g.dispose();
        bs.show();

        if (timeLeft == 5 * (60000) && renders < 5) {
            renders++;
        }

        System.out.println("That update took " + (System.nanoTime() - start) / (1.0E9) + " seconds.");
    }
    
    /**
     * updates both buttons and action areas if justButtons is false
     * @param g 
     * @param justButtons 
     */
    public void updateButtons(Graphics g, boolean justButtons){
        
        l = justButtons ? buttons.size() : aa.size();
        
        for (int i = 0; i < l; i++) {
            if (i < buttons.size()) {
                if (buttons.get(i) == null) {
                }else if (!buttons.get(i).parent.isVisible() || !buttons.get(i).visible) {
                }else{
                    g.drawImage(buttons.get(i).img, buttons.get(i).x, buttons.get(i).y, this);
                }
            }
            if (i < aa.size() && gp.isVisible()) {
                if (pointTaken[aa.get(i).data.ordinal()]) {
                    g.drawImage(aa.get(i).img, aa.get(i).x, aa.get(i).y, this);
                }
            }
        }
        
    }

    public void paint(Graphics g) {
        if (s == null) {
            return;
        }
        render();
        g.dispose();
    }

    public static void doScoreOp() {
        if (Crops.values()[pickedup].inSeason((double) Calendar.getInstance().get(Calendar.MONTH))) {
            score++;
        } else {
            score--;
        }
        pointTaken[pickedup] = true;
        pickedup = -1;
    }

}
