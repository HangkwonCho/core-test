package hello.core.web;

import hello.core.common.MyLoggerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogProxyDemoService {

    private final MyLoggerProxy myLoggerProxy;

    public void logic(String id) {
        myLoggerProxy.log("service id = " + id);
    }
}
