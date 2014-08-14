package input;

import java.awt.Component;
import java.util.Calendar;
import seasonality.Crops;

/**
 *
 * @author Torri
 */
public class ActionArea extends MButton {

    public Crops data;

    public ActionArea(Crops c, Component parent1) {
        super(1, 1, 1, 1, c.toString(), parent1);
        if (c.forceSeason == 3) {
            img = la.createBufferedImage("Never.png", sx, sy);
        } else if (c.forceSeason == 2 || c.inSeason((double) Calendar.getInstance().get(Calendar.MONTH))) {
            img = la.createBufferedImage("Correct.png", sx, sy);
        } else {
            img = la.createBufferedImage("Incorrect.png", sx, sy);
        }
        data = c;
    }

    public void setPos(int x1, int y1, int sx1, int sy1) {
        super.setPos(x1, y1, sx1, sy1);
        if (data.forceSeason == 3) {
            img = la.createBufferedImage("Never.png", sx, sy);
        } else if (data.forceSeason == 2 || data.inSeason((double) Calendar.getInstance().get(Calendar.MONTH))) {
            img = la.createBufferedImage("Correct.png", sx, sy);
        } else {
            img = la.createBufferedImage("Incorrect.png", sx, sy);
        }
    }

}
