import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.CreateMode;

import java.util.Date;

/**
 * @author cyq
 * @date 2020-06-05
 */
public class ZkTest {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = ZkClient.getInstance();
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, "/", true);
        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()) {
                    case CHILD_ADDED:
                        System.out.println(new Date() + "-" + "CHILD_ADDED: " + event.getData().getPath());
                        break;
                    case CHILD_REMOVED:
                        System.out.println(new Date() + "-" + "CHILD_REMOVED: " + event.getData().getPath());
                        break;
                    case CHILD_UPDATED:
                        System.out.println(new Date() + "-" + "CHILD_UPDATED: " + event.getData().getPath());
                        break;
                    default:
                        break;
                }
            }
        });
        curatorFramework.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
                System.out.println(new Date() +"|"+connectionState);
                if (connectionState == ConnectionState.LOST){
                    while (true) {
                        try {
                            if (curatorFramework.getZookeeperClient().blockUntilConnectedOrTimedOut()) {
                                System.out.println("OKOKOKOKOKOKOKOKOKOKOKOKOK");
                            break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        curatorFramework.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
                if (connectionState == ConnectionState.LOST) {
                    System.out.println(new Date() + "-" + "[负载均衡失败]zk session超时");
                    while (true) {
                        try {
                            if (curatorFramework.getZookeeperClient().blockUntilConnectedOrTimedOut()) {
                                if (curatorFramework.checkExists().forPath("/test") != null) {
                                    try {
                                        curatorFramework.delete().forPath("/test");
                                        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/test");
                                    }catch (Exception e){
                                        System.out.println(e);
                                    }
                                }else {
                                    curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/test");
                                }
//                                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, data.getBytes("UTF-8"));
                                System.out.println(new Date() + "-" + "[负载均衡修复]重连zk成功");
                                break;
                            }
                        } catch (InterruptedException e) {
                            System.out.println(e);
                            break;
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else {
                    System.out.println(new Date() + "-" + connectionState);
                }
            }
        });
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/test");
        Thread.sleep(6000000);
    }
}
