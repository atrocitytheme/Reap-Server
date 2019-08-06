package server.reaptheflag.reaptheflag;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.parser.JsonFormatParser;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.converter.JsonFormatConverter;

@SpringBootTest
public class ReaptheflagGameTests {
    class TestClass {
        private int a = 123;
        private int b = 123;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
    @Test
    public void testJsonFormatConverter() {
        TestClass tester = new TestClass();
        tester.setA(100);
        tester.setB(50);
        JsonFormatConverter converter = new JsonFormatConverter(tester);
        TestClass clz =  new GsonBuilder().serializeNulls().
                setPrettyPrinting().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create().fromJson(converter.convertToSendable(), TestClass.class);
        assertEquals(100, clz.getA());
        assertEquals(50, clz.getB());
    }

    @Test
    public void tewsJsonFormatParser() {
        JsonFormatParser<TestClass> parser = new JsonFormatParser<>("{A: 10, B:5}", TestClass.class);
        assertEquals(10, parser.getIntByName("A"));
        assertEquals(5, parser.getIntByName("B"));
    }
}
