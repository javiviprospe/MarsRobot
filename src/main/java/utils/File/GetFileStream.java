package utils.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetFileStream {

    private BufferedReader reader;

    public GetFileStream(String path){
        try{
            this.reader = new BufferedReader(new FileReader(path));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void cose(){
        try {
            this.reader.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public BufferedReader getStream(){
        return this.reader;
    }
}
