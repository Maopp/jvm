package out_of_memory_error;

/**
 * out_of_memory_error
 *
 * @Args -Xss128k
 *
 * @Author cat_pp
 * @Date 2019/3/11
 * @Description 虚拟机栈和本地方法栈溢出
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.err.println("stack length:" + javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
