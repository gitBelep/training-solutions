package week12d04;

import java.io.IOException;
import java.io.InputStream;

public class Secret {

    public String showSecret() {
        try  {
            InputStream ins = Secret.class.getResourceAsStream("/secret.dat");
            byte[] bytes = ins.readAllBytes();
            StringBuilder sb = new StringBuilder();
            for(byte b : bytes){
                char c = (char) (b + 10);
                sb.append(c);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public static void main(String[] args) {
        Secret secret = new Secret();
        System.out.println( secret.showSecret() );
    }
}