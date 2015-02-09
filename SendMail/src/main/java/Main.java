
public class Main {

    public static void main(String[] args) {

        CreateMessage.createMessage();

        Sender tlsSender = new Sender(CreateMessage.fromEmail, CreateMessage.password);
        tlsSender.send(CreateMessage.title, CreateMessage.text, CreateMessage.fromEmail, CreateMessage.toEmail);

    }
}