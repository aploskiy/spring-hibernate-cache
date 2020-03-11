package com.example.cache;

import javafx.beans.binding.Bindings;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;
import java.util.Map;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void getUSer() {
        User user = userService.getById(1);
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.example.cache.User").getSize();
        Assertions.assertThat(size).isEqualTo(1);
        user = userService.getById(1);
    }

}
