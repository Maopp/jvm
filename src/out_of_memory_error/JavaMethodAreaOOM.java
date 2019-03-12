package out_of_memory_error;

import java.lang.reflect.Method;

/**
 * out_of_memory_error
 *
 * @Args -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @Author cat_pp
 * @Date 2019/3/12
 * @Description 方法区溢出，使用cglib技术复现
 */
public class JavaMethodAreaOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        while (true) {
            /*Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.useCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();*/
        }
    }
}
