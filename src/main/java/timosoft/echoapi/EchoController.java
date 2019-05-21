package timosoft.echoapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Slf4j
public class EchoController {

    @GetMapping
    public @ResponseBody
    Object get(@RequestHeader HttpHeaders headers, @RequestBody(required = false) String requestBody) {
        log.info("get called with {}", headers);
        log.info("body was {}", requestBody);
        StringBuilder sb = new StringBuilder();
        headers.forEach((k, v) -> sb.append(k).append(" : ").append(v.get(0)).append("\n"));
        return sb.toString();
    }
}
