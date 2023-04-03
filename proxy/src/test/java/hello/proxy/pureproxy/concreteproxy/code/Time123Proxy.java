package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Time123Proxy extends ConcreteLogic {
    private ConcreteLogic concreteLogic;

    public Time123Proxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator12123123123123 실행");
        String result = concreteLogic.operation();
        log.info("TimeDecorator123123123123123 종료");
        return result;
    }

}
