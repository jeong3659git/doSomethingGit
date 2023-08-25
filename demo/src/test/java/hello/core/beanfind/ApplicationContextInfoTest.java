package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기.")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){       // 배열만큼 반복
            Object bean = ac.getBean(beanDefinitionName);           // bean을 get해온 다음 object에 넣는다.
            System.out.println("name= "+beanDefinitionName+" Object= "+ bean);
        }
    }

    //  실행하면 스프링에 등록된 모든 빈 정보를 출력할 수 있다.
    //  ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다.
    //  ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다.


    @Test
    @DisplayName("모든 어플리케이션 빈 출력하기.")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용한 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object= "+bean);
            }
        }
    }

    // 스프링이 내부에서 사용하는 빈은 제외하고, 내가 등록한 빈만 출력

}
