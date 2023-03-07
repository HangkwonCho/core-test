package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 방버 1
// public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    // 생성과 초기화는 분리하는게 좋다.
    // 스프링은 크게 3가지 방법으로 빈 생명주기 콜백을 지원한다.
    // 1. 인터페이스(InitializingBean, DisposableBean) - 스프링 초창기에 나온 방법임.
    /**
     - 단점 : 이 인터페이스는 스프링 전용 인터페이스다. 해당 코드가 스프링 전용 인터페이스에 의존한다.
             초기화, 소멸 메서드의 이름을 변경할 수 없다.
             내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.
    */
    // 2. 설정 정보에 초기화 메서드, 종료 메서드 지정
    // 3. @PostConstruct, @PreDestory 에노테이션 지원

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, URL = " + url);
        //connect();
        //call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disConnect() {
        System.out.println("close: " + url);
    }

    // 방법 1.
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//    @Override
//    public void destroy() throws Exception {
//        disConnect();
//    }

    // 방법 2
    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    public void close() throws Exception {
        disConnect();
    }
}
