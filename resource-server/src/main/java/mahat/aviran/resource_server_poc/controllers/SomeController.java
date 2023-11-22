package mahat.aviran.resource_server_poc.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SomeController {

    @GetMapping
    @ResponseBody
    public String username(@AuthenticationPrincipal Jwt jwt) {
        log.info("idToken value: {}", jwt.getTokenValue());
        log.info("Email: {}", jwt.getSubject());
        return jwt.getSubject();
    }
}
