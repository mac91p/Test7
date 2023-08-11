package pl.kurs.finaltest.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateShapeCommand {

    @NotBlank
    private String type;
    @NotEmpty
    private List<Double> parameters;

    public String getType() {
        return type;
    }

    public List<Double> getParameters() {
        return parameters;
    }
}
