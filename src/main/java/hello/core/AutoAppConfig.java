package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 자동빈 * 수동빈 빈 이름이 중복될 경우 수동 빈이 우선권을 가지게 되어 Overriding 된다.
    // 스프링인 자동으로 Overriding 한다. 스프링부트는 오류를 출력하여 properties 파일에 설정값을 변경하도록 메세지를 출력한다.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

        // @ComponentScan 으로 하는 방법
        // @Component 가 붙은 클래스를 스캔하여 bean 컨테이너에 등록

        // @Component
        // @Controller      - 스프링 MVC 컨트롤러로 인식
        // @Service         - 특별한 기능은 없음. 개발자들의 핵심 비즈니스 로직이 존재함을 나타냄
        // @Repository      - 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환
        // @Configuration   - 스프링 설정 정보로 인식, 스프링 빈이 싱글톤을 유지하도록 추가 처리.
        // 어노테이션에는 상속관계가 없음. 그래서 어노테이션이 특정 어노테이션을 들고 있는 것을 인식할 수 있는 것은 자바 언어가 지원하는 기능이 아니고 스프링이 지원하는 기능임.
}
