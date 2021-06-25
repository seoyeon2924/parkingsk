package skcc.parkingsk.member.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

@Configuration
public class ApplicationConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    /* modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); */
    return modelMapper;
  }
}
