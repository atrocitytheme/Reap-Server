package server.reaptheflag.reaptheflag.udpserver.dispatcher.marker;
/**
 * This is the marker for supporting targeting the corresponding commmand
 * @see server.reaptheflag.reaptheflag.udpserver.Handler.commands.BatchCommandRunner
 * */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandType {
}
