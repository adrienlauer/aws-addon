package org.seedstack.aws.dynamodb;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.seedstack.coffig.Config;

@Config("aws.dynamoDb")
public class DynamoDbConfig {
    private final Map<String, ClientConfiguration> clients = new HashMap<>();

    public Map<String, ClientConfiguration> getClients() {
        return Collections.unmodifiableMap(clients);
    }

    public DynamoDbConfig addClient(String name, ClientConfiguration clientConfiguration) {
        clients.put(name, clientConfiguration);
        return this;
    }

    public static class ClientConfig {
        private ClientConfiguration client;
        private AwsClientBuilder.EndpointConfiguration endpoint;
        private Regions region;
    }
}
