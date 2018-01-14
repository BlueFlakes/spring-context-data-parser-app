package scc.services.starter;

import org.springframework.stereotype.Component;

@Component
public class ZeroArgStarter implements ConverterStarter {

    @Override
    public void start() throws Exception {
        System.out.println("No input defined.");
    }
}
