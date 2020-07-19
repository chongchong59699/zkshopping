package com.qf.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created  on 2019-9-09
 */
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2016102500760783"; //测试

    // 商户私钥，您的PKCS8格式RSA2私钥
   public static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAd3hrdpSoq6Ht8anWMqIRvspHJO8BnnKAKCJNzosrpkhRHryRrrwQl8Ojz/Kp6HhgfJ0tMt0Hi8OC5BBH0PjJUySvPhzW1XyrR0XO+OcnTy6t8W76/St8tAFubGUsJzRSr8KvtjxlAIrDVCqwOHiFjLSycSJ/5wU4noPrEJbuvNyTW9yv9eDjLXNHZlBFcWcuY/No7uqO8ani9sZOoX2nZEjBAd2sQ8gtlu5IvSIRccDdQCnR1yAAElLIRKkH9xpPnAcpwKqnfu4A1CdQdzVlbnOAPJ/kqcV4bvLlwibi2ybGx4xPcUJseZI8dXpBifwVjBwR33NYYYCzIm8thVqfAgMBAAECggEAW6tkrWI/cCCQ+wagB224AmufUacEOaaD0/lPiS/iVTJhlikVq+sA3eI9w23GngF5rHgffDo4SIMt7v+osmZmsNp4aegrkg1i2aGRKcCoyX8SMyL963Guj1yvTMliZGBRUNOEW/fxHq2FVx5/G6IgNkQSSOa8FIKYUi+iuKDs4suyn3jsIUVR6DLVXV7NsnHiSrOusypSibwqYilo9BAE8z7tqbQ43c32PLjHtlXOKXGmStCz3WkQh8x2udRz+JFf+hpBXekyPPGj7lcEUiT/b07VvHxKKxQqpuuhkFMtbp774qVXBWIN3ZEPqzm2h2Jnr92N5BNIDyWuh+rIPx+w0QKBgQDOqjqnt/SW1knCRjEMYHMlYN4oJBSqPaFXoaS2PkJWjomqJApDrZ7efD7gQ54hi8vFzaiJi+Har/IYadNymQ3dhwKqY+V7mC3XPF4WKJUj3nYaI0KxzgcAejhqX6kKNSKM75jIP1Uc0VZ+KSYjT2L2O/ESB/Z3oXK9gi2CMeXemQKBgQCfIl1gM+l4WoUqalmGm2JaljH7bRfWXruLHRla54M3b6GfeBlmxzPgVWkWiYWx5olx/CMX7sg8KTGNCGuFRExVYca61bTR6RG/dbiMHEas3GHbsNGU7a6AjINEh37UPs/bowHNg0wWoXcwGgZPWOMAFClehK22rWdOP6A2Po5d9wKBgAgoahZSyaHmpZS4ppkBeaohD8Pv4Kzzr9nAtLrI7F90UvTXZVxUjy/jIaxCnwxd81ZEjwGW9vxl852JF+KvLf/vo2hMdzOQx0Z2yJQBWBnJX0oa2DgilN4s9OsmCYswm8OKdbJ55Yc0sEBcqXe9W3+y0ApRLCZ+xgO7DsbT52oJAoGAel33hZGFl1msCriqzPpRQC08lAUIjnxcJJYkuCVMXmWF19WHWuQVPQ0QeRcY6nrG+BKVfcLM0I4wny15WInzVLiSE3tfxwY88of4eC0KH8R7r26hSq8WP51NF3ZFjbobJd6L9VdgPAq/Vwq8DWnhbF8UjKzj05Q12xLMBMpHuXMCgYBJH9yKJ16HPc/RCI1VZMNZAM6IJ/mdtwbwNU614kIiXa1080FyPAJWWz+nvkCq/rvd+o/vsvxjYJj1Lv3lcqAq5Zx+xR0V4swUNSd29BpKAMittO3xr7Eq3o+fV0fWBhDI/xe3HzRhPCviR9XS5fyh85ljMPREHco2qmzkFuhrYg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgPJQB05/mZUJSg9QUKOBHjW8AYtwcsXd7IX+C7PqRzXlg7wlCekqaKQV9n85BElaza78EAilsGTLqhswJyRrBlmWAsR45zNhfZ01o04icD3wHnDk4XxqJMXb/cbi52fCmaj6xt2qShwEYnN0KkZA5RuFHxuGmNw9UKsN4m6zXjxY/OR68AQBdaY4yMCsY1VA4WqIEy2bboi1yLBiVrlPHcm+r5nQQsdleDoz04515bcISr900I8Ho6xVXCQ351iVR2uA9SqAthY6sMtMZvjNj6CMRSRChNcadxLYGGjUJqhXQeCVW2SF4L3ykTtiWNmgGkkR5vlxgtpTKNFHmEbmoQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/Alipay/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8080/Alipay/returnUrl";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "UTF-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do"; //测试

    // 支付宝网关
    public static String log_path = "E:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}