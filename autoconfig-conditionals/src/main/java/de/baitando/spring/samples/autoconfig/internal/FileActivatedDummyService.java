package de.baitando.spring.samples.autoconfig.internal;

import de.baitando.spring.samples.autoconfig.DummyService;
import de.baitando.spring.samples.autoconfig.condition.ConditionalOnFile;
import org.springframework.stereotype.Service;

@ConditionalOnFile("test.txt")
@Service
public class FileActivatedDummyService implements DummyService {
    @Override
    public String getName() {
        return FileActivatedDummyService.class.getName();
    }
}
