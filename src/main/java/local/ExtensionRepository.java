package local;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ExtensionRepository implements PanacheRepository<ExtensionModel> {

}
