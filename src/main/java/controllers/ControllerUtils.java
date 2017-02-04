package controllers;

import javafx.scene.control.ComboBox;

/**
 * Created by micro on 04.02.2017.
 */
public class ControllerUtils {
    public static <T> void autoSelectComboBoxValue(ComboBox<T> comboBox, String value, Func<T, String> f) {
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
            }
        }
    }
    public interface Func<T, V> {
        boolean compare(T t, V v);
    }
}


