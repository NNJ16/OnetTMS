package lk.nnj.mdss.fx.dto;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ProgressDTO {
    private final DoubleProperty percentage = new SimpleDoubleProperty();

    public final double getPercentage() {
        return percentage.get();
    }

    public final DoubleProperty percentageProperty() {
        return percentage;
    }

    public final void setPercentage(double percentage) {
        this.percentage.set(percentage);
    }
}
