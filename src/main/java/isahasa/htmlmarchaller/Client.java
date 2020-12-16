package isahasa.htmlmarchaller;

public class Client {
    private Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public int writeToChannel(TextSource txt){
        return channel.writeByte( txt.getPlainText().getBytes() );

    }

}
