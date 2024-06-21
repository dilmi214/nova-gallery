package io.github.dilmi214.artgallery.nova_gallery.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "name");
        config.put("api_key", "key");
        config.put("api_secret", "key");
        return new Cloudinary(config);
    }
}
