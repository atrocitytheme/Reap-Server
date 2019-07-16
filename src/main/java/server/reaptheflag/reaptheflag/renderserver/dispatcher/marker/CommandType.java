package server.reaptheflag.reaptheflag.renderserver.dispatcher.marker;
/**
 * This is the marker for supporting targeting the corresponding commmand
 * @see server.reaptheflag.reaptheflag.renderserver.Handler.BatchCommandRunner
 * */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandType {
}
