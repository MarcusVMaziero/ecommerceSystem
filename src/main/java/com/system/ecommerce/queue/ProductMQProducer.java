package com.system.ecommerce.queue;

import com.system.ecommerce.rest.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMQProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private static final Logger logger = LoggerFactory.getLogger(ProductMQProducer.class);

    public void send(ProductRequest productRequest) {
        logger.info("enviando produto:", productRequest);
        rabbitTemplate.convertSendAndReceive(this.queue.getName(), productRequest);
    }
}
