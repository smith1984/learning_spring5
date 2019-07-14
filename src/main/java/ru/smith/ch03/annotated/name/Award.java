package ru.smith.ch03.annotated.name;

import org.springframework.core.annotation.AliasFor;

public @interface Award {
    @AliasFor("prize")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};
}
