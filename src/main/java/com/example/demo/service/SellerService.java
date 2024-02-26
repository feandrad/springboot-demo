

import com.example.demo.entity.Seller;
import java.util.List;

public interface SellerService {
    Seller saveSeller(Seller seller);
    List<Seller> getAllSellers();
    Seller getSellerById(Long id);
    Seller updateSeller(Seller seller, Long id);
    void deleteSeller(Long id);
}

