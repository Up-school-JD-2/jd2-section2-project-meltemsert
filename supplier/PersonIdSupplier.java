package supplier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PersonIdSupplier {
    private Map<String, Supplier<String>> personIdSupplier;

    public PersonIdSupplier() {
        personIdSupplier = new HashMap<>();
    }

    public void registerPersonIdSupplier(String supplierId, Supplier<String> supplier) {
        personIdSupplier.put(supplierId, supplier);
    }

    public String generatePersonId(String supplierId) {
        Supplier<String> supplier = personIdSupplier.get(supplierId);
        if (supplier != null) {
            return supplier.get();
        } else {
            return "Supplier not found";
        }
    }
}







