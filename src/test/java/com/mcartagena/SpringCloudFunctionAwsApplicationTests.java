package com.mcartagena;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@FunctionalSpringBootTest
@AutoConfigureWebTestClient
class SpringCloudFunctionAwsApplicationTests {

	@Autowired
	private WebTestClient client;
	
    @Test
    public void doesUpperCase() throws Exception {
        client.post().uri("/uppercase").body(Mono.just("This Is A Function In The Cloud"), String.class).exchange()
        .expectStatus().isOk().expectBody(String.class).isEqualTo("THIS IS A FUNCTION IN THE CLOUD");
    }

}
