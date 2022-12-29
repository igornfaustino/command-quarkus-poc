package local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import external.Extension;

@Entity(name = "extension")
public class ExtensionModel {
    @Id
    @GeneratedValue
    public Long id;

    public String quarkusId;

    public String name;

    public String shortName;

    public static ExtensionModel fromExtension(Extension extension) {
        ExtensionModel model = new ExtensionModel();
        model.quarkusId = extension.id;
        model.name = extension.name;
        model.shortName = extension.shortName;
        return model;
    }
}