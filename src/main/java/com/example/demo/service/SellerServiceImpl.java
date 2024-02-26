

import com.example.demo.entity.Seller;
import com.example.demo.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Seller not found!"));
    }

    @Override
    public Seller updateSeller(Seller seller, Long id) {
        Seller existingSeller = getSellerById(id);
        existingSeller.setName(seller.getName());
        existingSeller.setEmail(seller.getEmail());
        return sellerRepository.save(existingSeller);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
