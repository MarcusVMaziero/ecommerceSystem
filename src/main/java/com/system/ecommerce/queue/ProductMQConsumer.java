package com.system.ecommerce.queue;

import com.system.ecommerce.core.product.Product;
import com.system.ecommerce.data.product.ProductGateway;
import com.system.ecommerce.rest.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMQConsumer {

    private final ProductGateway productGateway;
    private static final Logger logger = LoggerFactory.getLogger(ProductMQConsumer.class);

    @RabbitListener(queues = "${queue.product.name}")
    public void recievedMessage(ProductRequest productMQRequest) {
        logger.info("produto chegou: ", productMQRequest);
        productGateway.create(Product.toService(productMQRequest));
    }
}
