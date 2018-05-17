## ribbon负载均衡客户端 ##
http://127.0.0.1:8764/hiHystrix?name=longhuiC <br/>
http://127.0.0.1:8764/hi?name=longhuiAd <br/>
http://127.0.0.1:8764/hystrix |http://127.0.0.1:8764/hystrix.stream |haha <br/>

## feign负载均衡客户端 ##
http://127.0.0.1:8765/sayHi?name=longhuid


## zuul路由网关 ##
127.0.0.1:8769/api-ribbon/hi?name=longhuiAd <br/>
127.0.0.1:8769/api-ribbon/hiHystrix?name=longhuiAd <br/>
127.0.0.1:8769/api-feign/sayHi?name=longhuiAd <br/>
127.0.0.1:8769/api-feign/sayHi?name=longhuiAd&token=23

## 配置中心(Spring Cloud Config) ##
http://127.0.0.1:8761/


## OrderServer ##
<ul>
<li>
http://127.0.0.1:8870/order/create/{userId}
</li>
<li>
http://127.0.0.1:8870/order/update
</li>
</ul>


## UcServer请求地址： ##
<ul>
<li>
http://127.0.0.1:8770/user/list?pageSize=2
</li>
<li>
http://127.0.0.1:8770/user/{userId}
</li>
<li>
http://127.0.0.1:8770/order/{userId}
</li>
</ul>






