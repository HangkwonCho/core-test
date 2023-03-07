package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.common.MyLoggerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogProxyDemoController {

    private final LogProxyDemoService logProxyDemoService;
    private final MyLoggerProxy myLoggerProxy;

    @RequestMapping("log-proxy-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLoggerProxy = " + myLoggerProxy.getClass());
        myLoggerProxy.setRequestURL(requestURL);
        myLoggerProxy.log("controller test");
        Thread.sleep(1000);
        logProxyDemoService.logic("testId");
        return "OK";
    }
}
