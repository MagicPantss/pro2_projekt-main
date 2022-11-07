import models.chatClients.ChatClient;
import models.chatClients.FileChatClient;
import models.chatClients.InMemoryChatClient;
import models.chatClients.fileOperations.ChatFileOperations;
import models.chatClients.fileOperations.JsonChatFileOperatinos;
import models.gui.MainFrame;

import java.awt.*;


public class Main {

    public static void main(String[] args) {
        ChatFileOperations chatFileOperations = new JsonChatFileOperatinos();
        ChatClient chatClient = new FileChatClient(chatFileOperations);
        MainFrame frame = new MainFrame(800,600, chatClient);

    }

    private static void huh() {
        InMemoryChatClient client1 = new InMemoryChatClient();
        client1.login("client1");
        client1.sendMessage("Hello");
        client1.sendMessage("Suckers");
        client1.logout();
    }
}