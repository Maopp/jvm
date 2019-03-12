package out_of_memory_error;

import java.util.ArrayList;
import java.util.List;

/**
 * out_of_memory_error
 *
 * @rgs -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @Author cat_pp
 * @Date 2019/3/11
 * @Description 堆溢出
 */
public class HeapOOM {

    static class OOMObject {
        public static void main(String[] args) {
            List<OOMObject> list = new ArrayList<>();
            while (true) {
                list.add(new OOMObject());
            }
        }
    }
}
