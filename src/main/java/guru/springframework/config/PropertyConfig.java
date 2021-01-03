package guru.springframework.config;

import guru.springframework.exmpleBeans.FakeDataSource;
import guru.springframework.exmpleBeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyConfig {

     @Autowired
     Environment environment;

    @Value("${guru.username}")
    String user;


    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;

    @Value("${guru.jms.username}")
    String username;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value("${guru.jms.url}")
    String jmsUrl;

    @Bean
    public FakeJmsBroker jmsDataSources(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();

        fakeJmsBroker.setUsername(username);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setPassword(jmsPassword);
        return fakeJmsBroker;
    }

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(user);
        fakeDataSource.setUser(environment.getProperty("MINE_USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

}