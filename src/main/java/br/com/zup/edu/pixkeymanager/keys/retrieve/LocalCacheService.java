package br.com.zup.edu.pixkeymanager.keys.retrieve;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocalCacheService {

    private static final Logger LOG = LoggerFactory.getLogger(LocalCacheService.class);


    private final ConcurrentHashMap<String, PixKey> cache = new ConcurrentHashMap<>();

    public Optional<PixKey> findBy(String pixId) {

        PixKey pixKey = cache.get(pixId);

        return Optional.ofNullable(pixKey);
    }

    public void update(String pixId,
                       PixKey pixKey) {

        LOG.info("[PIX][CACHE] Putting key '{}' in cache", pixId);
        cache.put(pixId, pixKey);
    }

    public void invalidate(UUID pixId) {
        this.cache.remove(pixId.toString());
    }
}
