package org.hotl.genericsreflectionpractice;


import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class FirstTaskClass {

    @Getter
    private String something;

    public FirstTaskClass() {
        this.something = "some text";
    }

    private String setSomething(String something) {
        this.something = something;
        return something;
    }


}
