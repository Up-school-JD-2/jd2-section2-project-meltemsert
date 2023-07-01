package supplier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ApplicationIdSupplier {
    private Map<String, Supplier<String>> applicationIdsupplier;

    public ApplicationIdSupplier() {
        applicationIdsupplier=new HashMap<>();
    }

    public void registerApplicationIdSupplier(String supplierId, Supplier<String> supplier){
        applicationIdsupplier.put(supplierId,supplier);
    }
    public String generateApplicationId(String supplierId){
        Supplier<String> supplier=applicationIdsupplier.get(supplierId);
        if(supplier!=null){
            return supplier.get();
        }else{
            System.out.println("Supplier not found");
        }
        return null;
    }
}

