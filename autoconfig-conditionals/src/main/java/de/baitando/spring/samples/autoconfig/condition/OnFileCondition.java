package de.baitando.spring.samples.autoconfig.condition;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnFileCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnFile.class.getCanonicalName());

        if (context.getResourceLoader().getResource((String) attributes.get("value")).exists()) {
            return ConditionOutcome.match(ConditionMessage.forCondition(ConditionalOnFile.class).available("file"));
        } else {
            return ConditionOutcome.noMatch(ConditionMessage.forCondition(ConditionalOnFile.class).notAvailable("file"));
        }
    }
}
