package br.com.zup.edu.pixkeymanager.keys.retrieve;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocalCacheService {

    private final ConcurrentHashMap<String, PixKey> cache = new ConcurrentHashMap<>();

    public Optional<PixKey> findBy(String pixId) {

        PixKey pixKey = cache.get(pixId);

        return Optional.ofNullable(pixKey);
    }

    public void update(String pixId,
                       PixKey pixKey) {

        cache.put(pixId, pixKey);
    }
}
