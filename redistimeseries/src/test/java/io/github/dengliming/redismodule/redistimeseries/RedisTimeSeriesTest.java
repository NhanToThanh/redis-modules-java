/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dengliming.redismodule.redistimeseries;

import io.github.dengliming.redismodule.redistimeseries.Sample.Value;
import io.github.dengliming.redismodule.redistimeseries.client.RedisTimeSeriesClient;
import org.junit.Test;
import org.redisson.config.Config;

/**
 *
 * @author baonnt
 */
public class RedisTimeSeriesTest {
	private RedisTimeSeries redisTimeSeries;
	
	public RedisTimeSeriesTest() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		RedisTimeSeriesClient redisTimeSeriesClient = new RedisTimeSeriesClient(config);
		redisTimeSeries = redisTimeSeriesClient.getRedisTimeSeries();
	}

	@Test
	public void testSomeMethod() {
		long ts = 1612352460000L;
		Long add = redisTimeSeries.add(new Sample("key2", Value.of(ts, 456)), new TimeSeriesOptions().dupPolicy(DupPolicy.LAST));
		
		System.out.println(add);
	}

}
