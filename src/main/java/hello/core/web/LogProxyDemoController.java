package hello.core.web;

import hello.core.common.MyLoggerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogProxyDemoController {

    private final LogProxyDemoService logProxyDemoService;
    private final MyLoggerProxy myLoggerProxy;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("log-proxy-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();

        MyLoggerProxy bean = applicationContext.getBean("myLoggerProxy", MyLoggerProxy.class);
        System.out.println("bean = " + bean);

        System.out.println("myLoggerProxy = " + myLoggerProxy.getClass());
        myLoggerProxy.setRequestURL(requestURL);
        myLoggerProxy.log("controller test");
        Thread.sleep(1000);
        logProxyDemoService.logic("testId");
        return "OK";
    }
}
