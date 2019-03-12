package out_of_memory_error;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * out_of_memory_error
 *
 * @Args -Xmx:20M -XX:MaxDirectMemorySize=10M
 *
 * @Author cat_pp
 * @Date 2019/3/12
 * @Description 直接内存溢出，使用Unsafe类的getUnsafe()，这个方法限制了只有引导类加载器才会返回实例，也就是设计者希望
 * 只有rt.jar中的类才能使用Unsafe的功能。
 * DirectByteBuffer也会抛出直接内存溢出异常，但是没有向系统申请内存分配，是通过计算得知的内存无法分配，真正申请分配内存
 * 的方法是unsafe.allocateMemory()
 */
public class DirectMemoryOOM {

    private static final int _10MB = 1024 * 1024 * 10;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        // 不能直接获取 Unsafe 类
//        Unsafe unsafe1 = Unsafe.getUnsafe();
        while (true) {
            unsafe.allocateMemory(_10MB);
        }
    }
}
