package br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "bcbClient", url = "${integration.bcb.uri}")
public interface BcbClient {


    CreatePixKeyBcbResponse createPix(CreatePixKeyBcbRequest createPixKeyBcbRequest);
}
