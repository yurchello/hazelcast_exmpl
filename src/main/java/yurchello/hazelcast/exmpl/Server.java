package yurchello.hazelcast.exmpl;

import com.hazelcast.config.Config;
import com.hazelcast.core.Client;
import com.hazelcast.core.ClientListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Server {
    public static void main(String[] args) {
        Config config = new Config();
        HazelcastInstance server = Hazelcast.newHazelcastInstance(config);
        server.getClientService().addClientListener(new ClientListener() {

            @Override
            public void clientConnected(Client client) {
                System.out.println(client.getClientType() + ", " +client.getUuid() + " is connected.");
            }

            @Override
            public void clientDisconnected(Client client) {
                System.out.println(client.getClientType() + ", " +client.getUuid() + " is disconnected.");
            }
        });
    }
}
