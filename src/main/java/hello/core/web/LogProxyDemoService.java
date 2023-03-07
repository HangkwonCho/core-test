package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.common.MyLoggerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogProxyDemoService {

    private final MyLoggerProxy myLoggerProxy;
    //@Autowired
    //Provider<MyLogger> myLoggerProvider;
    //private final MyLogger myLogger;

    public void logic(String id) {
        myLoggerProxy.log("service id = " + id);
    }
}
