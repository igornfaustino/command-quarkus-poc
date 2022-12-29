import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import external.Extension;
import external.ExtensionsService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import local.ExtensionModel;
import local.ExtensionRepository;

@QuarkusMain
public class Main implements QuarkusApplication {
    @Inject
    @RestClient
    ExtensionsService extensionsService;

    @Inject
    ExtensionRepository extensionRepository;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    @Transactional
    public int run(String... args) throws Exception {
        Set<Extension> extensions = extensionsService.getAll();
        extensions.stream().forEach(extension -> System.out.println(extension));
        System.out.println("Hello world");
        extensionRepository.persist(extensions.stream().map(extension -> ExtensionModel.fromExtension(extension)));
        return 0;
    }
}
