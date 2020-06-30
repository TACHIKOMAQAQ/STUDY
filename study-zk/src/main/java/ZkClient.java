import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author cyq
 * @date 2020-06-05
 */
public class ZkClient {
    //会话超时时间
    private final static int SESSION_TIMEOUT = 30 * 1000;
    //连接超时时间
    private final static int CONNECTION_TIMEOUT = 3 * 1000;
    //ZooKeeper服务地址
    private static final String CONNECT_ADDR = "192.168.8.100:2181,192.168.8.100:2182,192.168.8.100:2183";
//    private static final String CONNECT_ADDR = "localhost:2181,localhost:2182,localhost:2183";
    //创建连接实例
    private static CuratorFramework client = null;

    static {
        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        //2 通过工厂创建连接
        client = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDR).connectionTimeoutMs(CONNECTION_TIMEOUT)
                .sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(retryPolicy)
//命名空间           .namespace("super")
                .build();
        //3 开启连接
        client.start();
    }

    public static CuratorFramework getInstance() {
        return client;
    }
}
