import java.util.Map;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.*;

public class HelloWorld {
  public static void main(String[] args) throws Exception {
    ClientCache cache = new ClientCacheFactory()
      .addPoolLocator("localhost", 10334)
      .create();
    Region<String, String> region = cache
      .<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY)
      .create("region");

    region.put("1", "Hello");
    region.put("2", "World");

    for (Map.Entry<String, String>  entry : region.entrySet()) {
      System.out.format("key = %s, value = %s\n", entry.getKey(), entry.getValue());
    }
    cache.close();
  }
}
