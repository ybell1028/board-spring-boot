package com.hw.board;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//pom.xml을 먼저 작성했기때문에 Spring 관련 어노테이션 사용가능
/*
특별히 한것도 없는데 어떻게 실행되는 걸까요?
모든 것은 Application 파일에 있는 @SpringBootApplication 어노테이션에 있습니다.
@SpringBootApplication은 @Configuration, @EnableAutoConfiguration, @ComponentScan
 어노테이션이 합쳐진 것으로써 스프링부트 기반의 애플리케이션이라고 알려줍니다.
*/
/*
@SpringBootApplication 어노테이션을 작성하게되면
해당 클래스는 main 클래스로의 기능을 수행하게 된다.
해당 어노테이션을 확인해보면 여러가지 설정 어노테이션이 있는데,
이 중 @ComponentScan 어노테이션은 해당 어노테이션이 있는 클래스의 패키지 하위를 탐색하여
Bean들을 등록한다. main 클래스가 될 파일을 프로젝트에서 사용할 패키지의 가장 상위(루트)에 위치시키는 이유이다.
만약 java 패키지 밑에 존재할 경우 모오든 패키지를 탐색하게 되는 일이 발생하게 된다.
*/
@SpringBootApplication
public class BoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }
}
