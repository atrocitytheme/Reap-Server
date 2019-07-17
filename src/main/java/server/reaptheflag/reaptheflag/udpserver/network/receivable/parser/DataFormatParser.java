package server.reaptheflag.reaptheflag.udpserver.network.receivable.parser;

/**
 * parse the transportation format
 * */
public abstract class DataFormatParser <E>{
    E data;
    DataFormatParser(E data){
        this.data = data;
    }
    public abstract String getAttributeByName(String name);
    public abstract Iterable<String> getAttributeArray(String name);
    public abstract int getIntByName(String name);
}
