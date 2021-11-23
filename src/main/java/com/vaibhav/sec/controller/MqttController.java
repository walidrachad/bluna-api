package com.vaibhav.sec.controller;


import com.vaibhav.sec.config.Mqtt;
import com.vaibhav.sec.exception.ExceptionMessages;
import com.vaibhav.sec.model.MqttPublishModel;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/api/mqtt")
public class MqttController {
    @GetMapping(value = "/publish")
    public void publishMessage() throws org.eclipse.paho.client.mqttv3.MqttException {
        MqttMessage mqttMessage = new MqttMessage("messagePublishModel.getMessage()".getBytes());
        mqttMessage.setQos(0);
        mqttMessage.setRetained(true);
        Mqtt.getInstance().publish("testtest", mqttMessage);
    }

    @GetMapping(value = "/subscribe")
    public void subscribeChannel(@RequestParam(value = "topic") String topic,
                                                     @RequestParam(value = "wait_millis") Integer waitMillis)
            throws InterruptedException, org.eclipse.paho.client.mqttv3.MqttException {
        List<String> messages = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Mqtt.getInstance().subscribeWithResponse(topic, (s, mqttMessage) -> {

            messages.add(new String(mqttMessage.getPayload()));
            countDownLatch.countDown();
        });

        countDownLatch.await(waitMillis, TimeUnit.MILLISECONDS);


    }
}
