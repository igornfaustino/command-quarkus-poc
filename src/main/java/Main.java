import java.util.Set;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import external.Extension;
import external.ExtensionsService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {
    @RestClient
    ExtensionsService extensionsService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        Set<Extension> extensions = extensionsService.getAll();
        extensions.stream().forEach(extension -> System.out.println(extension));
        System.out.println("Hello world");
        return 0;
    }
}
