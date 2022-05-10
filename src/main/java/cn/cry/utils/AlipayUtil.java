package cn.cry.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.springframework.stereotype.Component;

/**
 * 支付工具类
 */
@Component
public class AlipayUtil {
    private String appId = "2021000119689935";
    private String url = "https://openapi.alipaydev.com/gateway.do";
    private String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCAg9feoVT2Utcow2aG9gp1lrDfvyZ7M1z2SywXiphoz5vWnPPoEWlroHM/w511cluu9kge2wg/TUmiBtTjhf02cAkHXPwYyvToGJKBOeDQQcMypCnWwaDF1ZW9v2Ho/03d+jnGTmISNZCiirqTlWkn+1S3VISwxnQo8TTdJtpfigLTWaKXSN7GC4UbVpbehhUV1XkDw5hMEUiPGch1IHluUdRAJAWc3cDutHEJbVVrk4cG4SNws22zkBqksNEEeKbuq4vEBUZij0B6EPwNKVNYUPu8BnCuF8bZKThQMc4/E5+E3bfSkptuTFIvwOig+/6D0/CutLVJKm1Dno/deP+tAgMBAAECggEACXgthtUCaqgN/I3xVw54FNQGsmXmUvuk5O0DEbT/p/FsPTMRcc8eonSPKWqjhoznnou9IrDm+asbOtogA6fS0ZkNwUIjvTvvMc7ltKnsG8xMssWP46gezZUAVJvuffmZ5jpS2X7bERZrUt7AArHmrrCBPIT4xgHJe17Sk10SiCmK6+ZuF0cr/TCC8HyQO+/dhPaxAeeLNdi1ZDaMIPdW+KjKjUTAUUTYmJg8TrnntODAf4eAkRzZsSYOLyCUfyep52yRi9hxSA1PnqLW2IeuJ6XBOMhZPwRO02P3cjGjJ98a1ouMBTGZzhu9DqPNjfRcsGyP9nqpI6eJMQLnOYfm7QKBgQDdJq70aYwvDhFjjASkOL1PcbepzNB+01DANrxn/w8+TzAybxN4pgGGSJz00qflFnI9UQycPio4PYjkI/QycJY1RpU3YNVHwvzSbqDddPPzqeRc8htwOJ5ect14U4FOazeTjWRdbVHrmJvKWvOnb2DO4/iVgHlSM/j9Tiduxzu78wKBgQCUxC+Vpis0VpDJjuwf5OrjY/WgiBVW/8fV9d6oUdWlyK3/289rZ+2tc6HavP0vglNrF/USsfUMN4oIDcOVhsgleOFsl6vF+quFvoty3aCwWY4hpkNR66n54iU310+SrFncspb1GfD0jhfYID8rXYFjN6xClJEusG66hOnj1XNd3wKBgQDKioE1i+09s06tszEVDnojZmzlcJWLchHE2NyZCnp1gKUNq7lTiAZha+OEPeJS58nc6nv4JN8Z/xF+kIc4IvEO/gPvYhozzRsrxvJBoLlEclaZ4YrLrq8spVq8tw34Oi3+T0KaZmLeuTgFjmMU9+bb1OJ4Wd/DL6Jcq9VlmcbVjQKBgG3e3w31JZ+H93MFPVro5JmAL96Z4rjYO6zH4+QIXHQOXIPEwdIfdahO6FD2lz9JT3aewP9HsyWMt0Lvd22tl5AlUMe01MZpNdiXO8Jf8NeNrK0pcDrGhEjrPnWZbUl0RQH8XAU1XYIgl3eliUHr0y2F5pFdzEPhRkY2986uzH+dAoGBAKHRW+/E3i7xRZufwSoi0uXq4jxaWRnUvfI7YqdgWFILmDhKwdsKBPUGrdzrg73/DItIfFqf9pd08541ljlmQh5kJXwWuoqvTJXZWBXvusQ+4aKeSrnp9pl+Z1S6bpY0cyqMRce1lrLwGw/CW1rNg5bOnCoFKnGgybiLIyc01o+B";
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgIPX3qFU9lLXKMNmhvYKdZaw378mezNc9kssF4qYaM+b1pzz6BFpa6BzP8OddXJbrvZIHtsIP01JogbU44X9NnAJB1z8GMr06BiSgTng0EHDMqQp1sGgxdWVvb9h6P9N3fo5xk5iEjWQooq6k5VpJ/tUt1SEsMZ0KPE03SbaX4oC01mil0jexguFG1aW3oYVFdV5A8OYTBFIjxnIdSB5blHUQCQFnN3A7rRxCW1Va5OHBuEjcLNts5AapLDRBHim7quLxAVGYo9AehD8DSlTWFD7vAZwrhfG2Sk4UDHOPxOfhN230pKbbkxSL8DooPv+g9PwrrS1SSptQ56P3Xj/rQIDAQAB";
    private String notifUrl = "http://localhost:8080/MVC_MAVEN/notify";
    private String returnUrl = "http://localhost:8080/MVC_MAVEN/userIndex";

    public String pay(String id,String price,String title) {
        System.out.println("id="+id+"price="+price+"title="+title);
        AlipayClient alipayClient = new DefaultAlipayClient(url,appId,privateKey,"json","UTF-8",publicKey ,"RSA2");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(notifUrl);
        request.setReturnUrl(returnUrl);
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", id);
        bizContent.put("total_amount", price);
        bizContent.put("subject", title);
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = null;
        String form = null;
        try {
            response = alipayClient.pageExecute(request);
           form = response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return form;
    }
}
