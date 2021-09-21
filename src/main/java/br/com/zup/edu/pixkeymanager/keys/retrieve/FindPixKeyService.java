package br.com.zup.edu.pixkeymanager.keys.retrieve;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import br.com.zup.edu.pixkeymanager.keys.PixKeyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindPixKeyService {

    private final LocalCacheService cacheService;
    private final PixKeyRepository repository;

    public FindPixKeyService(LocalCacheService cacheService,
                             PixKeyRepository repository) {
        this.cacheService = cacheService;
        this.repository = repository;
    }

    public Optional<PixKey> findPixKeyBy(String pixId) {

        Optional<PixKey> cached = cacheService.findBy(pixId);


        if (cached.isEmpty()) {

            Optional<PixKey> possiblePixKey = repository.findById(UUID.fromString(pixId));

            if (possiblePixKey.isPresent()) {

                cacheService.update(pixId, possiblePixKey.get());
                return possiblePixKey;
            }
        }

        return Optional.empty();
    }
}