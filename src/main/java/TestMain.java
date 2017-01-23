import controllers.MasterController;
import models.MasterModel;
import views.MasterView;

import javax.swing.*;

/**
 * Created by bobsol on 24.01.17.
 */
public class TestMain {
public static void main(String args[]){
    JFrame frame = new JFrame();
    MasterView v = new MasterView();
    MasterModel m = new MasterModel();
    MasterController controller=new MasterController(v, m);
    frame.add(v.getUI());
    frame.pack();
    frame.setVisible(true);

}
}
