package study;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import sun.rmi.runtime.Log;

import java.lang.reflect.Method;

/**
 * @author cyq
 * @date 2020-06-03
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     *
     */
    private long id;

    /**
     * 给⽬标对象创建代理对象
     * @return
     */
    public Object getProxyInstance() {
        //1. ⼯具类
        Enhancer en = new Enhancer();
        //2. 设置⽗类
        en.setSuperclass(new App().getClass());
        //3. 设置回调函数
        en.setCallback(this);
        //4. 创建⼦类(代理对象)
        return en.create();
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.getProxyInstance();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
