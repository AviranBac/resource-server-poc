package mahat.aviran.resource_server_poc.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
@Log4j2
public class SomeController {

    @GetMapping
    @ResponseBody
    public String getSubject(@AuthenticationPrincipal Jwt jwt) {
        log.info("Access token value: {}", jwt.getTokenValue());
        log.info("Sub: {}", jwt.getSubject());
        return jwt.getSubject();
    }
}
