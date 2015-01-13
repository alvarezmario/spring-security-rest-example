package demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

@Configuration
public class EmbeddedRedisConfiguration {
	@Bean
	public static RedisServerBean redisServer() {
		return new RedisServerBean();
	}

	static class RedisServerBean implements InitializingBean, DisposableBean, BeanDefinitionRegistryPostProcessor {
		private RedisServer redisServer;

		public void afterPropertiesSet() throws Exception {
			redisServer = new RedisServer(Protocol.DEFAULT_PORT);
			redisServer.start();
		}

		public void destroy() throws Exception {
			if (redisServer != null) {
				redisServer.stop();
			}
		}

		@Override
		public void postProcessBeanDefinitionRegistry(
				BeanDefinitionRegistry registry) throws BeansException {
		}

		@Override
		public void postProcessBeanFactory(
				ConfigurableListableBeanFactory beanFactory)
				throws BeansException {
		}
	}
}
