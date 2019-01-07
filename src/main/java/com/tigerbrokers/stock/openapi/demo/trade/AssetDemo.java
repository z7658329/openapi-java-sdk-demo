package com.tigerbrokers.stock.openapi.demo.trade;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.request.TigerHttpRequest;
import com.tigerbrokers.stock.openapi.client.https.response.TigerHttpResponse;
import com.tigerbrokers.stock.openapi.client.util.builder.AccountParamBuilder;
import org.junit.Test;

import static com.tigerbrokers.stock.openapi.demo.DemoConstants.serverUrl;
import static com.tigerbrokers.stock.openapi.demo.DemoConstants.tigerId;
import static com.tigerbrokers.stock.openapi.demo.DemoConstants.tigerPubKey;
import static com.tigerbrokers.stock.openapi.demo.DemoConstants.yourPrivateKey;

/**
 * Description:
 * Created by lijiawen on 2018/05/31.
 */
public class AssetDemo {

  private static TigerHttpClient client = new TigerHttpClient(serverUrl, tigerId, yourPrivateKey, tigerPubKey);

  @Test
  public void queryAsset() {
    TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.ASSETS);
    String bizContent = AccountParamBuilder.instance()
        .account("DU575569")
        .buildJson();
    request.setBizContent(bizContent);

    TigerHttpResponse response = client.execute(request);
    outputResponse(bizContent, response);
  }

  private void outputResponse(String param, TigerHttpResponse response) {
    if (response != null) {
      System.out.println("request success,param:" + param + ",result:" + response);
    } else {
      System.out.println("request failure,param:" + param);
    }
  }
}