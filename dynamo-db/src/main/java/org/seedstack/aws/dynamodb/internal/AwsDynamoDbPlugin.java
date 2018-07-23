package org.seedstack.aws.dynamodb.internal;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import io.nuun.kernel.api.plugin.InitState;
import io.nuun.kernel.api.plugin.context.InitContext;
import java.util.HashMap;
import java.util.Map;
import org.seedstack.aws.dynamodb.DynamoDbConfig;
import org.seedstack.seed.core.internal.AbstractSeedPlugin;

public class AwsDynamoDbPlugin extends AbstractSeedPlugin {
    private final Map<String, AmazonDynamoDB> clients = new HashMap<>();

    @Override
    public String name() {
        return "aws-dynamo-db";
    }

    @Override
    protected InitState initialize(InitContext initContext) {
        DynamoDbConfig dynamoDbConfig = getConfiguration(DynamoDbConfig.class);
        dynamoDbConfig.getClients().forEach((name, clientConfiguration) -> {
            clients.put(name, buildClient(clientConfiguration));
        });
        return InitState.INITIALIZED;
    }

    private AmazonDynamoDB buildClient(ClientConfiguration clientConfiguration) {
        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration()
    }
}
